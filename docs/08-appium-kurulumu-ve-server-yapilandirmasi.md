# Appium Kurulumu ve Appium Server Yapılandırması

Mobil test otomasyonu yapabilmek için Appium’un sistemde doğru şekilde
kurulması ve Appium Server’ın düzgün çalışır durumda olması gerekir.

Bu doküman, Appium kurulum sürecini ve Appium Server’ın temel
yapılandırmasını adım adım açıklamak amacıyla hazırlanmıştır.

---

##  Appium Nedir?

**Appium**, mobil uygulamalar için kullanılan açık kaynaklı bir test otomasyon
aracıdır. Test kodları ile mobil cihaz/emülatör arasında köprü görevi görür.

Appium iki ana parçadan oluşur:
- **Appium Server**
- **Appium Client (test kodları)**

Bu dokümanda odak noktamız **Appium Server kurulumu**dur.

---

##  Appium Kurulumu (Genel Yaklaşım)

Appium, **Node.js** tabanlı bir araçtır ve `npm` (Node Package Manager)
üzerinden kurulur.

Bu nedenle Appium kurulumu öncesinde:
- Node.js
- npm

sistemde kurulu olmalıdır.

---

##  Appium Server Kurulumu (npm ile)

Appium Server’ı global olarak kurmak için terminal/komut satırında
aşağıdaki komut kullanılır:

npm install -g appium


##  Appium Kurulum Kontrolü

Kurulum tamamlandıktan sonra Appium’un yüklü olup olmadığı kontrol edilebilir:

appium --version

Bu komut, Appium sürüm bilgisini döndürüyorsa kurulum başarılıdır.


## Appium Server Ne İşe Yarar?

Appium Server:

- Test kodlarından gelen komutları alır

- Bu komutları cihazın anlayacağı dile çevirir

- Android veya iOS cihaz/emülatör üzerinde uygular

- Sonuçları test framework’üne geri döndürür

Kısaca

Appium Server, testlerin çalışabilmesi için merkezi kontrol noktasıdır.

## Appium Server Nasıl Çalıştırılır?

Appium Server’ı başlatmak için terminalde şu komut çalıştırılır:

appium

Varsayılan olarak aşağıdaki adreste çalışır:

http://localhost:4723


## Appium Server Yapılandırması (Temel Ayarlar)

Appium Server çalışırken bazı ayarlar varsayılan olarak gelir:

Port: 4723

Host: localhost

Base Path: /

İhtiyaç halinde bu ayarlar komut satırı parametreleriyle değiştirilebilir.

Örnek:

appium --port 4725


## Appium Driver’ları (Android / iOS)

Appium Server, platforma özel driver’lar kullanır.

Android için

 Genellikle UiAutomator2 driver kullanılır

Android cihaz/emülatör ile etkileşimi sağlar

Driver kurulumu kontrolü:

appium driver list


Eksik driver varsa:

appium driver install uiautomator2


## Appium Server – Android SDK – Emulator İlişkisi

Appium Server tek başına yeterli değildir.
Aşağıdaki bileşenlerle birlikte çalışır:

- Android SDK → Cihaz/emülatör iletişimi

- adb → Cihaz bağlantısı

- Emulator / Real Device → Test ortamı

- Appium Server → Komutları yöneten katman

Bu bileşenlerden biri eksikse testler başlatılamaz.

## Yaygın Problemler

Appium Server kurulumu sonrası sık karşılaşılan sorunlar:

- appium komutu tanınmıyor

- Port çakışmaları

- adb bulunamadı hatası

- Driver (UiAutomator2) eksikliği

Bu sorunların büyük kısmı:

- Ortam değişkenleri

- Eksik SDK bileşenleri

- Yanlış Node/npm kurulumu

kaynaklıdır.

## Not

Appium testlerinin çalışmaması durumunda ilk kontrol edilmesi gerekenler:

- Appium Server çalışıyor mu?

- Doğru port üzerinden mi dinliyor?

- Android SDK ve adb erişilebilir mi?

- Gerekli driver’lar kurulu mu?

Bu kontroller, kurulum kaynaklı problemlerin büyük kısmını hızlıca çözmeyi sağlar.
