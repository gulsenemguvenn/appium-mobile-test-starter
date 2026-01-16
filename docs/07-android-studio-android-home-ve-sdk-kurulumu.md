# Android Studio, ANDROID_HOME ve Android SDK Kurulumu

Appium ile Android mobil test otomasyonu yapabilmek için sistemde
**Android Studio**, **Android SDK** ve ilgili ortam değişkenlerinin
doğru şekilde yapılandırılması gerekir.

Bu doküman, Android tarafındaki kurulum sürecini ve temel kavramları
anlaşılır bir şekilde açıklamak amacıyla hazırlanmıştır.

---

##  Android Studio Nedir?

**Android Studio**, Android uygulamaları geliştirmek ve test etmek için kullanılan
resmi geliştirme ortamıdır (IDE).

Android Studio, Appium testleri için doğrudan kod yazmak amacıyla değil;
**Android SDK, emulator ve platform araçlarını** sağladığı için gereklidir.

Android Studio ile birlikte:
- Android SDK
- Emulator
- Platform Tools (adb vb.)
- System Image’lar

kurulabilir ve yönetilebilir.

---

##  Android SDK Nedir?

**Android SDK (Software Development Kit)**, Android cihazlar ve emülatörler ile
çalışmak için gerekli olan araçlar bütünüdür.

Android SDK, Appium’un:
- Cihaz/emülatör ile haberleşmesini
- Uygulama yüklemesini
- Test komutlarını çalıştırmasını

sağlayan temel bileşendir.

---

##  Android SDK İçerisinde Neler Bulunur?

Android SDK aşağıdaki temel bileşenlerden oluşur:

- **Platform Tools**
  - `adb` (Android Debug Bridge)
  - Cihaz ile bilgisayar arasındaki iletişimi sağlar

- **Build Tools**
  - Android uygulamalarının derlenmesi ve paketlenmesi için kullanılır

- **Android Platforms**
  - Farklı Android sürümleri (API Level’lar)

- **Emulator**
  - Gerçek cihaz olmadan Android uygulamalarını çalıştırmak için

- **System Images**
  - Emulator’ün kullanacağı Android işletim sistemi imajları

---

##  ANDROID_HOME Nedir?

**ANDROID_HOME**, sistemde kurulu olan Android SDK’nın
**ana dizin yolunu gösteren ortam değişkenidir**.

Birçok araç (Appium, adb, emulator, build araçları),
Android SDK’nın yerini bulmak için bu değişkene bakar.

###  Örnek ANDROID_HOME Yolu (Windows)

C:\Users\KullaniciAdi\AppData\Local\Android\Sdk

##  ANDROID_HOME Ayarlanmazsa Ne Olur?

- `adb` komutu çalışmayabilir
- Emulator başlatılamaz
- Appium cihaz/emülatör ile bağlantı kuramaz
- **“SDK not found”** benzeri hatalar alınır

Bu nedenle Android SDK kurulumundan sonra  
**ANDROID_HOME mutlaka tanımlanmalıdır**.

---

##  Android Studio Kurulum Adımları (Genel)

- Android Studio resmi sitesinden indirilir
- Kurulum sihirbazı başlatılır
- **Standard** kurulum seçeneği tercih edilir
- SDK, Emulator ve gerekli bileşenler yüklenir
- Kurulum tamamlandıktan sonra Android Studio açılır

---

##  Android SDK Kurulumu ve Kontrolü

Android Studio açıldıktan sonra:

- **SDK Manager** ekranına girilir
- Gerekli Android sürümleri (**API Level**) seçilir
- Platform Tools ve Build Tools yüklü olduğundan emin olunur
- Emulator için **System Image** indirilir

Bu adımlar tamamlandığında Android SDK kullanıma hazır hale gelir.

---

##  Android Studio – ANDROID_HOME – Appium İlişkisi

Bu yapı taşları birlikte çalışır:

- **Android Studio** → SDK ve Emulator yönetimi
- **Android SDK** → Cihaz/emülatör ile iletişim
- **ANDROID_HOME** → SDK’nın sistem tarafından bulunmasını sağlar
- **Appium** → Android SDK üzerinden testleri çalıştırır

Appium + Android testlerinde:

> Bu bileşenlerden biri eksik veya yanlış yapılandırılmışsa  
> test ortamı sağlıklı çalışmaz.

---

## Not

Android tarafında Appium kullanırken yaşanan problemlerin büyük bir kısmı:

- SDK yolu hataları
- ANDROID_HOME tanımlanmaması
- `adb` veya emulator problemleri

kaynaklıdır.

Bu nedenle kurulum adımlarını doğru yapmak,  
ileride oluşabilecek birçok sorunu en baştan engeller.
