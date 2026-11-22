# Skip Ads Always Active — Android project v1.0

## Isi versi awal
- Aplikasi Android native Kotlin.
- Tombol mulai/hentikan layanan.
- Foreground service dengan notifikasi permanen selama layanan aktif.
- Minimum Android 8.0 (API 26).

## Batasan penting
Ini adalah fondasi layanan latar belakang, bukan implementasi ulang fitur internal APK Skip Ads 2.8.10. APK asli belum dibongkar dan dianalisis secara menyeluruh. Aplikasi ini tidak melakukan klik otomatis, tidak menutup iklan, dan tidak mengakali sistem iklan aplikasi lain.

Android/OEM dapat menghentikan layanan, terutama setelah Force stop, pembatasan baterai, atau reboot. `START_STICKY` hanya meminta sistem mencoba membuat ulang service; bukan jaminan aktif 24/7. Versi ini belum mengaktifkan auto-start setelah reboot.

## Build menjadi APK
1. Buka folder ini melalui Android Studio (Hedgehog atau lebih baru).
2. Tunggu Gradle Sync selesai.
3. Pilih Build > Build Bundle(s) / APK(s) > Build APK(s).
4. APK debug akan muncul di `app/build/outputs/apk/debug/app-debug.apk`.

Gunakan JDK 17 dan Android SDK Platform 35. Untuk distribusi, buat signed release APK melalui Build > Generate Signed Bundle / APK.

## Build APK langsung dari HP (tanpa memasang IDE)
Proyek ini menyertakan GitHub Actions untuk membangun APK di cloud.
1. Di browser HP, masuk atau buat akun GitHub.
2. Buat repository baru, misalnya `SkipAdsAlwaysActive`.
3. Unggah seluruh isi folder proyek ini ke repository (termasuk folder tersembunyi `.github/workflows`).
4. Buka tab **Actions**, pilih workflow **Build Android APK**, lalu tekan **Run workflow**.
5. Setelah selesai, buka hasil run yang berhasil dan unduh artifact `SkipAdsAlwaysActive-debug-apk`.
6. Ekstrak ZIP artifact, lalu instal `app-debug.apk`. Jika diminta, izinkan instalasi aplikasi dari browser/file manager yang digunakan.

Build cloud memerlukan akun GitHub dan koneksi internet. APK yang dihasilkan adalah debug APK untuk uji coba pribadi, bukan release APK bertanda tangan untuk distribusi luas.
