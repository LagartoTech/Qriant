# Qriant

**A quiet QR toolkit for Android.** Scan and create QR codes without ads, accounts, analytics, subscriptions, or unnecessary permissions.

> Project status: early prototype (0.1.0). Not yet release-ready.

## Current prototype
- Live QR/barcode scanning using CameraX + bundled ML Kit.
- QR generation on-device using ZXing.
- Copy scan results and generated content.
- Dark interface with a small, focused feature set.
- No `INTERNET` permission in the manifest.

## Planned
- Persistent local scan history and favorites.
- Scan QR codes from images.
- Dedicated Wi-Fi, contact, email, phone and event templates.
- Safe URL preview (show the full host before opening; never auto-open).
- Export generated QR images.
- Accessibility and Portuguese/English localization.
- Automated tests and reproducible release builds.

## Build
Open the project in Android Studio, or use a local Gradle 8.9 installation:

```bash
gradle assembleDebug
```

Requirements:
- JDK 17
- Android SDK Platform 35
- Android Gradle Plugin 8.7.3

The first Gradle sync requires internet to download build dependencies. The app itself does not need network access to scan or generate codes.

## Privacy
The prototype requests camera permission only when scanning. QR decoding and generation are performed on-device. There is no analytics, advertising SDK, account system, or network permission.

## License
MIT. See [LICENSE](LICENSE).
