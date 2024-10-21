import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class MID {
    private HashMap<String, Boolean> absensi;

    public MID() {
        absensi = new HashMap<>();
    }

    public void tambahMahasiswa(String nama) {
        if (!absensi.containsKey(nama)) {
            absensi.put(nama, false);
            System.out.println(nama + " berhasil ditambahkan.");
        } else {
            System.out.println(nama + " sudah ada dalam daftar.");
        }
    }

    public void catatKehadiran(String nama) {
        if (absensi.containsKey(nama)) {
            absensi.put(nama, true);
            System.out.println(nama + " telah hadir.");
        } else {
            System.out.println(nama + " tidak ditemukan dalam daftar.");
        }
    }

    public void tampilkanAbsensi() {
        System.out.println("Daftar Absensi:");
        for (String nama : absensi.keySet()) {
            String status = absensi.get(nama) ? "Hadir" : "Tidak Hadir";
            System.out.println(nama + ": " + status);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MID MID= new MID();

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Tambah Mahasiswa");
            System.out.println("2. Catat Kehadiran");
            System.out.println("3. Tampilkan Absensi");
            System.out.println("4. Keluar");
            System.out.print("Pilih opsi: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine(); // Clear newline

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan nama mahasiswa: ");
                    String namaTambah = scanner.nextLine();
                    MID.tambahMahasiswa(namaTambah);
                    break;
                case 2:
                    System.out.print("Masukkan nama mahasiswa yang hadir: ");
                    String namaHadir = scanner.nextLine();
                    MID.catatKehadiran(namaHadir);
                    break;
                case 3:
                    MID .tampilkanAbsensi();
                    break;
                case 4:
                    System.out.println("Keluar dari program.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }
    }
}
