# Appium Context ve WebView

Hibrit uygulamaları doğru ve stabil bir şekilde test edebilmek için **context** kavramını iyi anlamak gerekir.
Bu doküman, Appium’da context nedir, neden önemlidir ve WebView ile nasıl çalışılır sorularını açıklamak
amacıyla hazırlanmıştır.

---

##  Context Nedir?

**Context**, Appium’un test sırasında **hangi ortamda** (native mi web mi) çalıştığını ifade eder.

Hibrit uygulamalarda iki farklı dünya vardır:
- **Native ekranlar**
- **WebView içeriği**

Appium, test sırasında bu iki ortam arasında geçiş yapabilmek için context bilgisini kullanır.

---

##  Context Türleri

### 1️⃣ Native Context (`NATIVE_APP`)
- Uygulamanın **yerel (native)** ekranlarını temsil eder
- Butonlar, text alanları, menüler gibi native UI elementleri içerir
- Varsayılan context’tir

Native context’te:
- Native locator’lar kullanılır
- UI elementleri doğrudan test edilir

---

### 2️⃣ WebView Context (`WEBVIEW`)
- Uygulama içerisindeki **web tabanlı** içerikleri temsil eder
- HTML, CSS ve JavaScript ile oluşturulmuş ekranları kapsar
- Genellikle hibrit uygulamalarda bulunur

WebView context’te:
- Web elementleri test edilir
- Selenium mantığına benzer şekilde çalışılır

---

## 🔄 Context Switching Nedir?

**Context switching**, test sırasında Appium’un:
- Native context’ten WebView context’e
- WebView context’ten Native context’e

geçiş yapabilmesidir.

Bu geçiş yapılmadan, Appium yanlış ortamda element aramaya çalışır ve testler başarısız olur.

---

##  Context Switching Neden Gereklidir?

Hibrit uygulamalarda sıkça şu senaryo yaşanır:
- Login ekranı native
- İçerik sayfası WebView
- Menü veya popup tekrar native

Bu durumda:
- Native ekranda → `NATIVE_APP`
- Web içeriğinde → `WEBVIEW`

context’inin aktif olması gerekir.

---

##  Appium Context’leri Nasıl Görür?

Appium, aktif context’leri test sırasında otomatik olarak algılar.

Genellikle şu şekilde context’ler görülür:
- `NATIVE_APP`
- `WEBVIEW_com.example.app`

WebView context’in ismi uygulamaya göre farklılık gösterebilir.

---

##  Context Switching Yapılmazsa Ne Olur?

- Element bulunamaz (`NoSuchElementException`)
- Yanlış locator kullanımı
- Testler kararsız (unstable) hale gelir
- “Element var ama bulunamıyor” problemleri yaşanır

Bu sorunların büyük bir kısmı yanlış context’te test çalıştırılmasından kaynaklanır.

---

##  Appium ve WebView İlişkisi

Appium, WebView içeren uygulamalarda:
- Native ve WebView ekranları **aynı test** içinde yönetebilir
- Her iki context için de test yazılmasına olanak tanır

Bu özellik sayesinde Appium:
- Hibrit uygulama testlerinde
- Karmaşık kullanıcı akışlarında
- Gerçek hayata yakın senaryolarda

çok güçlü bir araç haline gelir.

---

##  Not

Appium testlerinde sorun yaşandığında ilk kontrol edilmesi gerekenlerden biri:

> **Doğru context’te miyim?**

Context kavramını iyi anlamak;
- Daha stabil testler yazmayı
- Hataları daha hızlı analiz etmeyi
- Hibrit uygulamalarda güvenle test yapmayı

sağlar.
