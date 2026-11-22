package tech.lagartotech.qriant

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.media.MediaScannerConnection
import android.net.Uri
import android.os.Build
import android.os.Environment
import android.content.ContentValues
import android.provider.MediaStore
import androidx.core.content.FileProvider
import java.io.File
import java.io.IOException

fun saveQrToGallery(context: Context, bitmap: Bitmap): Boolean {
    return try {
        val name = "Qriant_${System.currentTimeMillis()}.png"

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.Q) {
            val directory = File(
                Environment.getExternalStoragePublicDirectory(
                    Environment.DIRECTORY_PICTURES
                ),
                "Qriant"
            )

            if (!directory.exists() && !directory.mkdirs()) {
                throw IOException("Could not create directory")
            }

            val file = File(directory, name)
            file.outputStream().use {
                if (!bitmap.compress(Bitmap.CompressFormat.PNG, 100, it)) {
                    throw IOException("Could not save image")
                }
            }

            MediaScannerConnection.scanFile(
                context,
                arrayOf(file.absolutePath),
                arrayOf("image/png"),
                null
            )
        } else {
            val values = ContentValues().apply {
                put(MediaStore.Images.Media.DISPLAY_NAME, name)
                put(MediaStore.Images.Media.MIME_TYPE, "image/png")
                put(
                    MediaStore.Images.Media.RELATIVE_PATH,
                    "${Environment.DIRECTORY_PICTURES}/Qriant"
                )
                put(MediaStore.Images.Media.IS_PENDING, 1)
            }

            val uri = context.contentResolver.insert(
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                values
            ) ?: throw IOException("Could not register image")

            try {
                context.contentResolver.openOutputStream(uri)?.use {
                    if (!bitmap.compress(Bitmap.CompressFormat.PNG, 100, it)) {
                        throw IOException("Could not save image")
                    }
                } ?: throw IOException("Could not open image")

                context.contentResolver.update(
                    uri,
                    ContentValues().apply {
                        put(MediaStore.Images.Media.IS_PENDING, 0)
                    },
                    null,
                    null
                )
            } catch (e: Exception) {
                context.contentResolver.delete(uri, null, null)
                throw e
            }
        }

        true
    } catch (_: Exception) {
        false
    }
}

fun shareQrImage(context: Context, bitmap: Bitmap) {
    val directory = File(context.cacheDir, "shared_qr").apply {
        if (!exists() && !mkdirs()) {
            throw IOException("Could not create cache directory")
        }
    }

    val file = File(directory, "qriant_qr.png")

    file.outputStream().use {
        if (!bitmap.compress(Bitmap.CompressFormat.PNG, 100, it)) {
            throw IOException("Could not create image")
        }
    }

    val uri = FileProvider.getUriForFile(
        context,
        "${context.packageName}.fileprovider",
        file
    )

    val intent = Intent(Intent.ACTION_SEND).apply {
        type = "image/png"
        putExtra(Intent.EXTRA_STREAM, uri)
        addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
        clipData = android.content.ClipData.newUri(
            context.contentResolver,
            "QR Code",
            uri
        )
    }

    context.startActivity(Intent.createChooser(intent, "Share QR code"))
}
