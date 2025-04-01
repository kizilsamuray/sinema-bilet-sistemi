import java.util.Scanner;

public class Main {
    // Sabitler
    private static final int MAX_FILM = 10;
    private static final int MAX_MUSTERI = 20;
    private static final int MAX_BILET = 100;
    
    // Veri yapıları
    private static String[] filmAdlari = new String[MAX_FILM];
    private static int[] filmSureleri = new int[MAX_FILM];
    private static String[] filmTurleri = new String[MAX_FILM];
    private static int filmSayisi = 0;
    
    private static String[] musteriAdlari = new String[MAX_MUSTERI];
    private static String[] musteriEmailler = new String[MAX_MUSTERI];
    private static int musteriSayisi = 0;
    
    private static int[][] biletler = new int[MAX_BILET][2]; // [0]=musteriIndex, [1]=filmIndex
    private static int biletSayisi = 0;
    
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        anaMenu();
    }
    
    private static void anaMenu() {
        while (true) {
            System.out.println("\n=== SINEMA BİLET SİSTEMİ ===");
            System.out.println("1. Film İşlemleri");
            System.out.println("2. Müşteri İşlemleri");
            System.out.println("3. Bilet İşlemleri");
            System.out.println("0. Çıkış");
            System.out.print("Seçiminiz: ");
            
            int secim = scanner.nextInt();
            scanner.nextLine(); // Boş satırı oku
            
            switch (secim) {
                case 1:
                    filmMenu();
                    break;
                case 2:
                    musteriMenu();
                    break;
                case 3:
                    biletMenu();
                    break;
                case 0:
                    System.out.println("Çıkış yapılıyor...");
                    return;
                default:
                    System.out.println("Geçersiz seçim!");
            }
        }
    }
    
    private static void filmMenu() {
        while (true) {
            System.out.println("\n=== FİLM İŞLEMLERİ ===");
            System.out.println("1. Film Ekle");
            System.out.println("2. Filmleri Listele");
            System.out.println("0. Ana Menü");
            System.out.print("Seçiminiz: ");
            
            int secim = scanner.nextInt();
            scanner.nextLine();
            
            switch (secim) {
                case 1:
                    filmEkle();
                    break;
                case 2:
                    filmleriListele();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Geçersiz seçim!");
            }
        }
    }
    
    private static void filmEkle() {
        if (filmSayisi >= MAX_FILM) {
            System.out.println("Maksimum film sayısına ulaşıldı! (" + MAX_FILM + ")");
            return;
        }
        
        System.out.print("Film Adı: ");
        String ad = scanner.nextLine();
        
        System.out.print("Film Süresi (dk): ");
        int sure = scanner.nextInt();
        scanner.nextLine();
        
        System.out.print("Film Türü: ");
        String tur = scanner.nextLine();
        
        filmAdlari[filmSayisi] = ad;
        filmSureleri[filmSayisi] = sure;
        filmTurleri[filmSayisi] = tur;
        filmSayisi++;
        
        System.out.println("Film başarıyla eklendi! (Toplam: " + filmSayisi + "/" + MAX_FILM + ")");
    }
    
    private static void filmleriListele() {
        if (filmSayisi == 0) {
            System.out.println("Kayıtlı film bulunmamaktadır.");
            return;
        }
        
        System.out.println("\n=== FİLM LİSTESİ ===");
        System.out.printf("%-5s %-30s %-10s %-20s%n", "ID", "Film Adı", "Süre", "Tür");
        System.out.println("--------------------------------------------------");
        
        for (int i = 0; i < filmSayisi; i++) {
            System.out.printf("%-5d %-30s %-10d %-20s%n", 
                i, 
                kisalt(filmAdlari[i], 30), 
                filmSureleri[i], 
                kisalt(filmTurleri[i], 20));
        }
    }
    
    private static void musteriMenu() {
        while (true) {
            System.out.println("\n=== MÜŞTERİ İŞLEMLERİ ===");
            System.out.println("1. Müşteri Ekle");
            System.out.println("2. Müşterileri Listele");
            System.out.println("0. Ana Menü");
            System.out.print("Seçiminiz: ");
            
            int secim = scanner.nextInt();
            scanner.nextLine();
            
            switch (secim) {
                case 1:
                    musteriEkle();
                    break;
                case 2:
                    musterileriListele();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Geçersiz seçim!");
            }
        }
    }
    
    private static void musteriEkle() {
        if (musteriSayisi >= MAX_MUSTERI) {
            System.out.println("Maksimum müşteri sayısına ulaşıldı! (" + MAX_MUSTERI + ")");
            return;
        }
        
        System.out.print("Müşteri Adı: ");
        String ad = scanner.nextLine();
        
        System.out.print("E-posta: ");
        String email = scanner.nextLine();
        
        musteriAdlari[musteriSayisi] = ad;
        musteriEmailler[musteriSayisi] = email;
        musteriSayisi++;
        
        System.out.println("Müşteri başarıyla eklendi! (Toplam: " + musteriSayisi + "/" + MAX_MUSTERI + ")");
    }
    
    private static void musterileriListele() {
        if (musteriSayisi == 0) {
            System.out.println("Kayıtlı müşteri bulunmamaktadır.");
            return;
        }
        
        System.out.println("\n=== MÜŞTERİ LİSTESİ ===");
        System.out.printf("%-5s %-30s %-30s%n", "ID", "Müşteri Adı", "E-posta");
        System.out.println("--------------------------------------------------");
        
        for (int i = 0; i < musteriSayisi; i++) {
            System.out.printf("%-5d %-30s %-30s%n", 
                i, 
                kisalt(musteriAdlari[i], 30), 
                kisalt(musteriEmailler[i], 30));
        }
    }
    
    private static void biletMenu() {
        while (true) {
            System.out.println("\n=== BİLET İŞLEMLERİ ===");
            System.out.println("1. Bilet Oluştur");
            System.out.println("2. Biletleri Listele");
            System.out.println("0. Ana Menü");
            System.out.print("Seçiminiz: ");
            
            int secim = scanner.nextInt();
            scanner.nextLine();
            
            switch (secim) {
                case 1:
                    biletOlustur();
                    break;
                case 2:
                    biletleriListele();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Geçersiz seçim!");
            }
        }
    }
    
    private static void biletOlustur() {
        if (musteriSayisi == 0) {
            System.out.println("Önce müşteri eklemelisiniz!");
            return;
        }
        
        if (filmSayisi == 0) {
            System.out.println("Önce film eklemelisiniz!");
            return;
        }
        
        musterileriListele();
        System.out.print("Müşteri ID: ");
        int musteriId = scanner.nextInt();
        scanner.nextLine();
        
        if (musteriId < 0 || musteriId >= musteriSayisi) {
            System.out.println("Geçersiz müşteri ID!");
            return;
        }
        
        filmleriListele();
        System.out.print("Film ID: ");
        int filmId = scanner.nextInt();
        scanner.nextLine();
        
        if (filmId < 0 || filmId >= filmSayisi) {
            System.out.println("Geçersiz film ID!");
            return;
        }
        
        biletler[biletSayisi][0] = musteriId;
        biletler[biletSayisi][1] = filmId;
        biletSayisi++;
        
        System.out.println("Bilet başarıyla oluşturuldu! Bilet No: " + (biletSayisi - 1));
    }
    
    private static void biletleriListele() {
        if (biletSayisi == 0) {
            System.out.println("Kayıtlı bilet bulunmamaktadır.");
            return;
        }
        
        System.out.println("\n=== BİLET LİSTESİ ===");
        System.out.printf("%-10s %-30s %-30s%n", "Bilet No", "Müşteri", "Film");
        System.out.println("--------------------------------------------------");
        
        for (int i = 0; i < biletSayisi; i++) {
            int musteriId = biletler[i][0];
            int filmId = biletler[i][1];
            
            String musteriAdi = musteriId < musteriSayisi ? musteriAdlari[musteriId] : "Silinmiş Müşteri";
            String filmAdi = filmId < filmSayisi ? filmAdlari[filmId] : "Silinmiş Film";
            
            System.out.printf("%-10d %-30s %-30s%n", 
                i, 
                kisalt(musteriAdi, 30), 
                kisalt(filmAdi, 30));
        }
    }
    
    private static String kisalt(String metin, int uzunluk) {
        if (metin == null) return "";
        if (metin.length() <= uzunluk) return metin;
        return metin.substring(0, uzunluk - 3) + "...";
    }
}