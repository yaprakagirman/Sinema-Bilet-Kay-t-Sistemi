import java.util.Scanner;

public class SinemaSistemi {

    // Maksimum eklenebilecek film, müşteri ve bilet sayısı
    static String[] filmler = new String[100];         // Film isimlerini tutar
    static String[] filmTurleri = new String[100];     // Film türlerini tutar
    static int[] filmSureleri = new int[100];          // Film sürelerini tutar
    static int filmSayisi = 0;                          // Kaç film eklendiğini sayar

    static String[] musteriler = new String[100];      // Müşteri isimlerini tutar
    static String[] mailler = new String[100];         // Müşteri e-maillerini tutar
    static int musteriSayisi = 0;                      // Kaç müşteri eklendiğini sayar

    // Biletlerin tutulduğu 2 boyutlu dizi (musteri x film)
    static boolean[][] biletler = new boolean[100][100];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int secim;

        // Menü sürekli çalışsın diye do-while kullanıyoruz
        do {
            // Kullanıcıya gösterilecek ana menü
            System.out.println("\n------ SİNEMA SİSTEMİ ------");
            System.out.println("1- Film Ekle");
            System.out.println("2- Müşteri Ekle");
            System.out.println("3- Bilet Sat");
            System.out.println("4- Filmleri Göster");
            System.out.println("5- Müşterileri Göster");
            System.out.println("6- Satılan Biletleri Göster");
            System.out.println("0- Çıkış");
            System.out.print("Seçiminizi girin: ");
            secim = scanner.nextInt();
            scanner.nextLine(); // Satır sonunu temizlemek için

            // Kullanıcının seçimine göre işlemler yapılıyor
            if (secim == 1) {
                // Film ekleme işlemi
                System.out.print("Film adı: ");
                filmler[filmSayisi] = scanner.nextLine();

                System.out.print("Film türü: ");
                filmTurleri[filmSayisi] = scanner.nextLine();

                System.out.print("Film süresi (dakika): ");
                filmSureleri[filmSayisi] = scanner.nextInt();
                scanner.nextLine(); // Satır sonunu temizle

                filmSayisi++; // Film sayısını artır
                System.out.println("Film başarıyla eklendi.");

            } else if (secim == 2) {
                // Müşteri ekleme işlemi
                System.out.print("Müşteri adı: ");
                musteriler[musteriSayisi] = scanner.nextLine();

                System.out.print("Müşteri e-mail: ");
                mailler[musteriSayisi] = scanner.nextLine();

                musteriSayisi++; // Müşteri sayısını artır
                System.out.println("Müşteri başarıyla eklendi.");

            } else if (secim == 3) {
                // Bilet satışı işlemi
                if (musteriSayisi == 0 || filmSayisi == 0) {
                    System.out.println("Bilet satışı için önce müşteri ve film ekleyin.");
                } else {
                    // Müşterileri listele
                    System.out.println("----- Müşteriler -----");
                    for (int i = 0; i < musteriSayisi; i++) {
                        System.out.println(i + " - " + musteriler[i] + " (" + mailler[i] + ")");
                    }

                    // Film listesi
                    System.out.println("----- Filmler -----");
                    for (int i = 0; i < filmSayisi; i++) {
                        System.out.println(i + " - " + filmler[i] + " [" + filmTurleri[i] + ", " + filmSureleri[i] + " dk]");
                    }

                    System.out.print("Müşteri numarası girin: ");
                    int mNo = scanner.nextInt();
                    System.out.print("Film numarası girin: ");
                    int fNo = scanner.nextInt();

                    if (mNo < musteriSayisi && fNo < filmSayisi) {
                        biletler[mNo][fNo] = true; // Bileti işaretle
                        System.out.println("Bilet başarıyla satıldı.");
                    } else {
                        System.out.println("Geçersiz numara girdiniz.");
                    }
                }

            } else if (secim == 4) {
                // Film listesi gösterimi
                System.out.println("----- Filmler -----");
                for (int i = 0; i < filmSayisi; i++) {
                    System.out.println((i + 1) + ". " + filmler[i] + " - Tür: " + filmTurleri[i] + " - Süre: " + filmSureleri[i] + " dk");
                }

            } else if (secim == 5) {
                // Müşteri listesi gösterimi
                System.out.println("----- Müşteriler -----");
                for (int i = 0; i < musteriSayisi; i++) {
                    System.out.println((i + 1) + ". " + musteriler[i] + " - E-mail: " + mailler[i]);
                }

            } else if (secim == 6) {
                // Satılan biletleri göster
                System.out.println("----- Satılan Biletler -----");
                for (int i = 0; i < musteriSayisi; i++) {
                    for (int j = 0; j < filmSayisi; j++) {
                        if (biletler[i][j]) {
                            System.out.println(musteriler[i] + " -> " + filmler[j]);
                        }
                    }
                }

            } else if (secim == 0) {
                // Programdan çıkılıyor
                System.out.println("Çıkış yapılıyor...");

            } else {
                // Geçersiz seçim durumu
                System.out.println("Geçersiz seçim. Lütfen tekrar deneyin.");
            }

        } while (secim != 0); // Kullanıcı çıkış yapana kadar tekrar et

        scanner.close(); // Scanner kapatılır
    }
}