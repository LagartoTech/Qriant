package tech.lagartotech.qriant

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PhotoLibrary
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color
import com.google.mlkit.vision.barcode.BarcodeScanning
import com.google.mlkit.vision.common.InputImage

@Composable
fun GalleryQrPicker(onResult: (String) -> Unit) {
    val context = LocalContext.current
    val scanner = remember { BarcodeScanning.getClient() }
    var status by remember { mutableStateOf("") }

    val picker = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri ->
        if (uri != null) {
            onResult("")
            status = "Reading image..."
            try {
                val image = InputImage.fromFilePath(context, uri)
                scanner.process(image)
                    .addOnSuccessListener { codes ->
                        val value = codes.firstOrNull()?.rawValue
                        if (value != null) {
                            status = "QR code found"
                            onResult(value)
                        } else {
                            status = "No QR code found in this image"
                        }
                    }
                    .addOnFailureListener {
                        status = "Could not read this image"
                    }
            } catch (_: Exception) {
                status = "Could not open this image"
            }
        }
    }

    DisposableEffect(scanner) {
        onDispose { scanner.close() }
    }

    Column {
        OutlinedButton(onClick = { picker.launch("image/*") }) {
            Icon(Icons.Default.PhotoLibrary, contentDescription = null)
            Spacer(Modifier.width(6.dp))
            Text("Choose image from gallery")
        }
        if (status.isNotBlank()) {
            Text(status, color = Color.LightGray)
        }
    }
}
