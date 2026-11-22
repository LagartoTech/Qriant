# Qriant

**Um utilitário Android simples e direto para ler códigos QR e códigos de barras.**
**A simple, straightforward Android utility for scanning QR codes and barcodes.**

[Português](#português) | [English](#english)

---

## Português

O Qriant é um aplicativo Android de código aberto para leitura de códigos QR e códigos de barras em diversos formatos, além da geração de códigos QR. Foi desenvolvido com foco em simplicidade e funcionamento local.

### Recursos

- Leitura de códigos QR usando a câmera.
- Leitura de códigos QR e códigos de barras a partir da galeria.
- Suporte aos formatos reconhecidos pelo Google ML Kit, incluindo QR Code, EAN-8, EAN-13, UPC-A, UPC-E, Code 128, Code 39, PDF417, Data Matrix e Aztec.
- Geração de códigos QR a partir de textos ou links.
- Cópia do conteúdo lido ou gerado.
- Abertura de links detectados.
- Salvamento de códigos QR como imagens PNG.
- Compartilhamento de imagens geradas.
- Interface simples e sem anúncios.

### Tecnologias

- Kotlin
- Jetpack Compose
- AndroidX CameraX
- Google ML Kit Barcode Scanning
- ZXing

### Compilação

Requisitos: JDK 17, Android SDK 35 e Gradle 8.9.

Na raiz do projeto, execute:

    gradle assembleDebug

O APK será gerado em:

    app/build/outputs/apk/debug/app-debug.apk

### Licença

Distribuído sob a licença MIT. Consulte [LICENSE](LICENSE).

---

## English

Qriant is an open-source Android application for scanning QR codes and barcodes in multiple formats, as well as generating QR codes. It is designed around simplicity and on-device operation.

### Features

- Scan QR codes using the camera.
- Scan QR codes and barcodes from gallery images.
- Supports formats recognized by Google ML Kit, including QR Code, EAN-8, EAN-13, UPC-A, UPC-E, Code 128, Code 39, PDF417, Data Matrix and Aztec.
- Generate QR codes from text or links.
- Copy scanned or generated content.
- Open detected links.
- Save generated QR codes as PNG images.
- Share generated images.
- Simple, ad-free interface.

### Built with

- Kotlin
- Jetpack Compose
- AndroidX CameraX
- Google ML Kit Barcode Scanning
- ZXing

### Building

Requirements: JDK 17, Android SDK 35 and Gradle 8.9.

From the project root, run:

    gradle assembleDebug

The APK will be generated at:

    app/build/outputs/apk/debug/app-debug.apk

### License

Released under the MIT License. See [LICENSE](LICENSE).
