#  Appium İlk Otomasyon ve Driver

Bu bölümde Appium ile **ilk mobil otomasyon testimizi** yazdık ve Appium’un en kritik kavramlarından biri olan **Driver (AndroidDriver / IOSDriver)** yapısını öğrendik.

**Amaç:**  
Bir Android uygulamasını otomasyonla başlatmak, elementlere erişmek, temel aksiyonları yapmak ve testi temiz şekilde sonlandırmak.

---

## 1) Driver Nedir? Neden Bu Kadar Önemli?

**Driver**, Appium üzerinden cihaz/emülatör ve uygulama ile iletişim kurmamızı sağlayan “kontrol paneli” gibidir.

Driver ile şu işlemler gerçekleştirilir:

- Uygulamayı başlatma / kapatma  
- Element bulma (`findElement`)  
- Tıklama, yazı yazma, kaydırma gibi aksiyonlar  
- Uygulama durumunu yönetme (arka plana atma, tekrar açma vb.)  
- Ekran kaydı, ekran görüntüsü (screenshot) ve log alma  

Android tarafında genellikle:

- `AndroidDriver`  
- `UiAutomator2` otomasyon motoru  

kullanılır.

---

## 2) Ön Koşullar (Hızlı Kontrol Listesi)

### ✅ Gerekli Araçlar

- Java (JDK)  
- Android Studio + SDK  
- ADB (Android Debug Bridge)  
- Appium Server (Appium 2 önerilir)  
- (Opsiyonel) Appium Inspector  

---

### ✅ Cihaz / Emülatör Kontrolü

Bağlı cihazları kontrol etmek için:

adb devices

Cihaz listeleniyorsa bağlantı başarılıdır.

### ✅ Appium Server Çalıştırma

Appium server’ı başlatmak için:

appium

---

## 3) Desired Capabilities (Capabilities) Mantığı

Appium’a “hangi cihazda, hangi uygulamayı, hangi otomasyon motoruyla test edeceğini” söylemek için capabilities kullanırız.

En sık kullandıklarımız:

- `platformName`: Android / iOS  
- `deviceName`: cihaz adı (emülatör veya fiziksel)  
- `automationName`: Android için genelde UiAutomator2  
- `appPackage / appActivity`: Android uygulamasını açmak için  
- `noReset`: uygulama verilerini sıfırlama davranışı (true/false)  

---

## 4) Maven Bağımlılıkları (pom.xml)

Not: Versiyonlar projene göre değişebilir. Buradaki yapı genel örnektir.

![alt text](images\images-2.png)

## 5) Driver Kurulumu (BaseTest)

Aşağıdaki BaseTest sınıfı:

- Capabilities’i ayarlar  
- Driver’ı başlatır  
- Her testten sonra driver’ı kapatır  

![alt text](images\images-6.png)

![alt text](images\images-3.png)

---

### Notlar

- `http://127.0.0.1:4723` Appium server adresidir (default).  
- `appPackage` ve `appActivity` değerlerini Appium Inspector/ADB ile bulabiliriz.  
- `noReset=true` sayesinde her testte uygulama sıfırlanmaz (login vs. durumlar korunur).  

---

## 6) İlk Otomasyon Testi

Bu testte:

- Uygulama açılır  
- Element bulunur  
- Tıklama / yazma gibi aksiyonlar yapılır  

![alt text](images\images-4.png)

## 7) Locator (Element Bulma) Yöntemleri

En yaygın locator’lar:

- `By.id("...")` ✅ En stabil olanlardan  
- `By.xpath("...")` ❗ Çok güçlü ama kırılgan olabilir  
- `By.className("...")`  
- `By.accessibilityId("...")` (Appium tarafında çok önerilir)  

---

![alt text](images\images-5.png)

---

**Öneri:** Mümkünse `id` veya `accessibilityId` kullanmak daha sağlıklıdır.

---

## 8) Wait (Bekleme) Mantığı — Kısa Not

Mobil uygulamalarda ekran geçişleri ve element yüklenmesi gecikebilir.  
Bu yüzden bekleme stratejisi önemlidir.

- `implicitWait`: genel bekleme  
- `explicitWait`: belirli bir element/koşul için bekleme (daha doğru yaklaşım)  

(İleriki bölümlerde explicit wait detaylı kullanılacaktır.)

## 9) Sık Karşılaşılan Hatalar ve Çözümler

### ❌ ADB cihaz görmüyor

- `adb devices` ile kontrol et  
- USB debugging açık mı?  
- Emülatör açık mı?  

---

### ❌ appPackage / appActivity yanlış

- Appium Inspector ile kontrol et  
- ADB ile:

adb shell dumpsys window | grep -E "mCurrentFocus"

### ❌ Appium Server’a bağlanmıyor

- Server çalışıyor mu? (`appium`)  
- URL doğru mu? (`http://127.0.0.1:4723`)  

---

## 10) Bu Bölümde Kazanımlarım

Bu çalışma ile:

- Appium’da driver kurulumunu öğrendim  
- Capabilities mantığını kavradım  
- Uygulama açma, element bulma, tıklama/yazma gibi temel otomasyon adımlarını uyguladım  
- Mobil test otomasyonunda stabilite için locator seçimi ve bekleme mantığının önemini gördüm  

---

✅ **Sonuç:** Appium ile mobil uygulamalara bağlanıp ilk otomasyon senaryomu çalıştırabilecek seviyeye geldim.