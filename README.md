🎬 Sinema Bilet Sistemi - Konsol Uygulaması
Java
License
Status

📜 Proje Açıklaması
Bu Java konsol uygulaması, sinema işletmeleri için temel bilet yönetim sistemi sağlar. BIP1026 dersi kapsamında geliştirilmiştir.

✨ Özellikler
🎥 Film yönetimi (ekleme/listeleme)

👥 Müşteri kayıt sistemi

🎟️ Bilet oluşturma ve takibi

📊 Temel raporlama özellikleri

🔄 Türkçe karakter desteği

🛠️ Kurulum
Önkoşullar
Java JDK 17+

Windows/Linux/macOS işletim sistemi

Kurulum Adımları
Projeyi klonlayın:

bash
Copy
git clone https://github.com/kizilsamuray/sinema-bilet-sistemi.git
Proje dizinine gidin:

bash
Copy
cd sinema-bilet-sistemi
🚀 Çalıştırma
Windows Kullanıcıları İçin:
cmd
Copy
javac -encoding UTF-8 Main.java
java -Dfile.encoding=CP1254 Main
Linux/macOS Kullanıcıları İçin:
bash
Copy
javac Main.java
java Main
Türkçe Karakter Desteği İçin:
Windows'ta aşağıdaki komutları çalıştırın:

cmd
Copy
chcp 1254
java Main
📋 Kullanım Kılavuzu
Ana Menü
Copy
=== SINEMA BİLET SİSTEMİ ===
1. Film İşlemleri
2. Müşteri İşlemleri
3. Bilet İşlemleri
4. Raporlar
0. Çıkış
Seçiminiz: 
Temel İşlemler:
Film Ekleme:

Film adı, süresi ve türü girin

Maksimum 10 film eklenebilir

Müşteri Kaydı:

Müşteri adı ve e-posta bilgileri

Maksimum 20 müşteri kaydı

Bilet Oluşturma:

Mevcut müşteri ve filmleri eşleştirin

Bilet numarası otomatik oluşturulur

📂 Proje Yapısı
Copy
sinema-bilet-sistemi/
├── src/
│   └── Main.java          # Ana uygulama sınıfı
├── README.md              # Bu dosya
└── LICENSE                # Lisans dosyası
🐛 Bilinen Sorunlar ve Çözümler
Türkçe karakter sorunu:

cmd
Copy
chcp 1254
java -Dfile.encoding=CP1254 Main
Listeleme hataları: Veri girmeden önce listelemeyi denemeyin 

📜 Lisans
Bu proje MIT lisansı altında lisanslanmıştır - detaylar için LICENSE dosyasına bakınız.

📧 İletişim
semih aker - Akersemih07@gmail.com
-----------------------------------
BIP1026 dersi kapsamında geliştirilmiştir | Teslim tarihi: 06.04.2025
