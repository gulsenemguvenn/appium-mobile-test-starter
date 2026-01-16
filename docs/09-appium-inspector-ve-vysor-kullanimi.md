# Appium Inspector ve Vysor Kullanımı

Mobil test otomasyonu sürecinde, uygulamayı **görerek incelemek** ve
**elementleri doğru şekilde tespit etmek** büyük önem taşır.
Bu noktada **Appium Inspector** ve **Vysor**, test mühendislerine önemli kolaylıklar sağlar.

---

##  Appium Inspector Nedir?

**Appium Inspector**, Appium testleri yazmadan önce mobil uygulama üzerindeki
elementleri incelemek ve doğru locator’ları bulmak için kullanılan bir araçtır.

Appium Inspector sayesinde:
- Uygulama ekranı canlı olarak görüntülenir
- UI elementleri hiyerarşik yapıda incelenir
- Element locator’ları (id, accessibilityId, xpath vb.) elde edilir
- Test yazmadan önce doğrulama yapılır

---

##  Appium Inspector Ne İşe Yarar?

Appium Inspector:
- Element bulunamama problemlerini azaltır
- Yanlış locator kullanımını önler
- Daha stabil testler yazılmasını sağlar
- Test geliştirme süresini kısaltır

 Kısaca:
> Appium Inspector, **test yazmadan önce yapılan keşif (exploration) aracıdır**.

---

##  Appium Inspector Nasıl Çalışır?

Appium Inspector, arka planda:
- Appium Server’a bağlanır
- Belirlenen **capabilities** ile bir session açar
- Uygulamanın anlık ekran görüntüsünü ve element ağacını getirir

Bu mantık, test kodlarının çalışma mantığıyla birebir aynıdır.

---

##  Appium Inspector Kullanım Adımları (Genel)

1. Appium Server başlatılır
2. Appium Inspector açılır
3. Desired Capabilities bilgileri girilir
4. Session başlatılır
5. Uygulama ekranı görüntülenir
6. Elementler incelenir ve locator’lar alınır

---

##  Appium Inspector ile Neler Yapılabilir?

- Element locator’ı üretme
- Element özelliklerini inceleme (text, resource-id, content-desc)
- XPath denemeleri yapma
- Native / WebView context’lerini görme
- Test yazmadan önce hata tespiti yapma

---

##  Vysor Nedir?

**Vysor**, Android cihaz veya emülatör ekranını bilgisayar üzerinden
**canlı olarak görüntülemeyi ve kontrol etmeyi** sağlayan bir araçtır.

Vysor, özellikle:
- Gerçek cihazla çalışırken
- Emulator ekranını daha rahat izlemek için
- Test sırasında cihazı kontrol etmek için

kullanılır.

---

##  Vysor Ne İşe Yarar?

Vysor ile:
- Android cihaz ekranı bilgisayardan izlenebilir
- Mouse ve klavye ile cihaz kontrol edilebilir
- Test sırasında uygulama akışı takip edilebilir
- Demo ve inceleme süreçleri kolaylaşır

 Appium testleri sırasında Vysor, **gözlem ve kontrol aracı** olarak kullanılır.

---

##  Appium Inspector ve Vysor Arasındaki Fark

| Appium Inspector | Vysor |
|------------------|------|
| Element bulmaya odaklıdır | Ekran yansıtma ve kontrol amaçlıdır |
| Locator üretir | Locator üretmez |
| Test öncesi keşif sağlar | Test sırasında gözlem sağlar |
| Appium Server’a bağlanır | adb üzerinden çalışır |

---

##  Sık Karşılaşılan Durumlar

- Inspector açılıyor ama ekran gelmiyorsa → Appium Server kontrol edilmeli
- Inspector session açamıyorsa → Capabilities yanlış olabilir
- Vysor cihazı görmüyorsa → `adb devices` kontrol edilmelidir
- Emulator yavaşsa → System Image ve donanım ayarları gözden geçirilmelidir

---

## Not

- **Appium Inspector**, doğru locator seçimi için vazgeçilmezdir
- **Vysor**, test sırasında uygulamayı görsel olarak takip etmeyi kolaylaştırır
- İki araç birlikte kullanıldığında, mobil test süreci daha verimli ve kontrollü ilerler

Bu araçları etkili kullanmak, Appium testlerinde yaşanan birçok problemi
test yazmadan önce fark etmeyi sağlar.
