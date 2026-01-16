# JDK Nedir? Java Home ve SDK Kavramları

Mobil test otomasyonu (özellikle Appium + Android) ile çalışırken bazı temel
geliştirme kavramlarını doğru anlamak gerekir.
Bu doküman, **JDK**, **JAVA_HOME** ve **SDK** kavramlarını netleştirmek amacıyla hazırlanmıştır.

---

##  JDK Nedir? (Java Development Kit)

**JDK (Java Development Kit)**, Java ile uygulama geliştirmek için gerekli olan
tüm araçları içeren yazılım paketidir.

JDK içerisinde şunlar bulunur:
- **JRE (Java Runtime Environment)** → Java uygulamalarını çalıştırmak için
- **Javac** → Java kodlarını derlemek için
- **Java** → Derlenen kodları çalıştırmak için
- Geliştirici araçları (debug, jar, vs.)

 Kısaca:
> Java ile kod yazmak ve bu kodu çalıştırmak için **JDK zorunludur**.

---

##  Appium ve Mobil Testlerde JDK Neden Gerekli?

- Android tarafında Appium testleri Java tabanlı araçlarla çalışır
- Android SDK, Java’ya bağımlıdır
- Appium Server ve test framework’leri (özellikle Java kullanıldığında) JDK ister

Bu nedenle:
> Appium + Android testleri için sistemde **JDK kurulu olmalıdır**.

---

##  JAVA_HOME Nedir?

**JAVA_HOME**, sistemde kurulu olan JDK’nın **dosya yolunu gösteren ortam değişkenidir**.

Birçok araç (Appium, Maven, Android SDK vb.), Java’yı bulmak için
`JAVA_HOME` değişkenine bakar.

###  Neden Önemlidir?
- Java’nın nerede kurulu olduğunu sisteme söyler
- Komut satırından Java araçlarının sorunsuz çalışmasını sağlar
- CI/CD ve otomasyon araçları için kritiktir

###  Örnek JAVA_HOME Yolu

C:\Program Files\Java\jdk-21

##  JAVA_HOME Ayarlanmazsa Ne Olur?

- `java` veya `javac` komutları çalışmayabilir
- Appium veya Android araçları Java’yı bulamaz
- **“Java not found”** benzeri hatalar alınır

Bu yüzden JDK kurulumundan sonra **JAVA_HOME mutlaka tanımlanmalıdır**.

---

##  SDK Nedir? (Software Development Kit)

**SDK (Software Development Kit)**, belirli bir platform veya teknoloji için  
geliştirme yapılmasını sağlayan araçlar bütünüdür.

Bir SDK genellikle şunları içerir:

- Kütüphaneler
- Geliştirme araçları
- Emulator / Simulator
- Dokümantasyon
- Build ve debug araçları

---

##  Android SDK Nedir?

**Android SDK**, Android uygulamaları geliştirmek ve test etmek için kullanılan  
resmi geliştirme kitidir.

Android SDK içerisinde:

- Platform araçları (adb vb.)
- Emulator
- Android sistem imajları
- Build araçları

bulunur.

Appium, Android cihaz veya emülatör ile haberleşmek için **Android SDK’ya ihtiyaç duyar**.

---

##  JDK – JAVA_HOME – SDK İlişkisi

Bu üç kavram birlikte çalışır:

- **JDK** → Java tabanlı araçların çalışmasını sağlar
- **JAVA_HOME** → Sisteme JDK’nın nerede olduğunu söyler
- **Android SDK** → Android cihaz/emülatör ile iletişimi sağlar

Appium + Android testlerinde:

> Bu yapı taşlarından biri eksik olursa test ortamı sağlıklı çalışmaz.

---

## Not

Mobil test otomasyonuna başlamadan önce:

- JDK’nın ne olduğunu
- JAVA_HOME’un neden gerekli olduğunu
- SDK kavramının neyi ifade ettiğini

iyi anlamak, ileride yaşanacak birçok kurulum ve yapılandırma problemini  
önceden engeller.
