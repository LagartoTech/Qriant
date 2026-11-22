# Qriant

**Um utilitário de QR Code simples e direto para Android.**
**A simple, straightforward QR code utility for Android.**

[Português](#português) | [English](#english)

---

## Português

O Qriant é um aplicativo Android de código aberto para ler e gerar códigos QR, com foco em simplicidade e funcionamento local.

### Recursos atuais

- Leitura de códigos QR usando a câmera.
- Geração de códigos QR a partir de texto ou links.
- Cópia do conteúdo lido ou gerado.
- Interface simples e sem anúncios.

### Estado do projeto

O Qriant está em desenvolvimento inicial. Algumas funções planejadas, como leitura de imagens da galeria e exportação de QR Codes como imagem, ainda não estão disponíveis.

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

Qriant is an open-source Android application for scanning and generating QR codes, designed around simplicity and on-device operation.

### Current features

- Scan QR codes using the camera.
- Generate QR codes from text or links.
- Copy scanned or generated content.
- Simple, ad-free interface.

### Project status

Qriant is in early development. Planned features such as scanning images from the gallery and exporting QR codes as image files are not available yet.

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
