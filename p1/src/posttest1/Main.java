package posttest1;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static List<Pasien> daftarPasien = new ArrayList<>();
    static List<Dokter> daftarDokter = new ArrayList<>();
    static List<JadwalKunjungan> daftarJadwal = new ArrayList<>();
    static List<RekamMedis> daftarRekamMedis = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nMenu Utama:");
            System.out.println("1. Kelola Pasien");
            System.out.println("2. Kelola Dokter");
            System.out.println("3. Kelola Jadwal Kunjungan");
            System.out.println("4. Kelola Rekam Medis");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: p");

            int pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1: kelolaData("Pasien"); break;
                case 2: kelolaData("Dokter"); break;
                case 3: kelolaData("Jadwal Kunjungan"); break;
                case 4: kelolaData("Rekam Medis"); break;
                case 5: System.exit(0);
                default: System.out.println("Pilihan tidak valid!");
            }
        }
    }

    static void kelolaData(String tipe) {
        while (true) {
            System.out.println("\nKelola " + tipe + ":");
            System.out.println("1. Tambah " + tipe);
            System.out.println("2. Lihat " + tipe);
            System.out.println("3. Update " + tipe);
            System.out.println("4. Hapus " + tipe);
            System.out.println("5. Kembali");
            System.out.print("Pilih: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine();
            
            switch (pilihan) {
                case 1: tambahData(tipe); break;
                case 2: lihatData(tipe); break;
                case 3: updateData(tipe); break;
                case 4: hapusData(tipe); break;
                case 5: return;
                default: System.out.println("Pilihan tidak valid!");
            }
        }
    }

    static void tambahData(String tipe) {
        System.out.print("Masukkan ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Masukkan Nama: ");
        String nama = scanner.nextLine();
        
        switch (tipe) {
            case "Pasien":
                System.out.print("Masukkan Alamat: ");
                String alamat = scanner.nextLine();
                System.out.print("Masukkan No HP: ");
                String noHp = scanner.nextLine();
                System.out.print("Masukkan Tanggal Lahir: ");
                String tanggalLahir = scanner.nextLine();
                daftarPasien.add(new Pasien(id, nama, alamat, noHp, tanggalLahir));
                break;
            case "Dokter":
                System.out.print("Masukkan Spesialisasi: ");
                String spesialisasi = scanner.nextLine();
                System.out.print("Masukkan No HP: ");
                String noHpDokter = scanner.nextLine();
                daftarDokter.add(new Dokter(id, nama, spesialisasi, noHpDokter));
                break;
        }
        System.out.println(tipe + " berhasil ditambahkan!");
    }

    static void lihatData(String tipe) {
        switch (tipe) {
            case "Pasien":
                if (daftarPasien.isEmpty()) {
                    System.out.println("Tidak ada data pasien.");
                } else {
                    for (Pasien p : daftarPasien) {
                        System.out.println("Nama: " + p.getNama() + " | Alamat: " + p.getAlamat() + " | No HP: " + p.getNoHp() + " | Tanggal Lahir: " + p.getTanggalLahir());
                    }
                }
                break;
            case "Dokter":
                if (daftarDokter.isEmpty()) {
                    System.out.println("Tidak ada data dokter.");
                } else {
                    for (Dokter d : daftarDokter) {
                        System.out.println(d);
                    }
                }
                break;
        }
    }

    static void updateData(String tipe) {
        System.out.print("Masukkan ID " + tipe + " yang akan diperbarui: ");
        int idUpdate = scanner.nextInt();
        scanner.nextLine();
        
        switch (tipe) {
            case "Pasien":
                for (Pasien p : daftarPasien) {
                    if (p.getIdPasien() == idUpdate) {
                        System.out.print("Masukkan Nama Baru: ");
                        p.setNama(scanner.nextLine());
                        System.out.print("Masukkan Alamat Baru: ");
                        p.setAlamat(scanner.nextLine());
                        System.out.print("Masukkan No HP Baru: ");
                        p.setNoHp(scanner.nextLine());
                        System.out.print("Masukkan Tanggal Lahir Baru: ");
                        p.setTanggalLahir(scanner.nextLine());
                        System.out.println("Data pasien berhasil diperbarui!");
                        return;
                    }
                }
                break;
            case "Dokter":
                for (Dokter d : daftarDokter) {
                    if (d.getIdDokter() == idUpdate) {
                        System.out.print("Masukkan Nama Baru: ");
                        d.setNama(scanner.nextLine());
                        System.out.print("Masukkan Spesialisasi Baru: ");
                        d.setSpesialisasi(scanner.nextLine());
                        System.out.print("Masukkan No HP Baru: ");
                        d.setNoHp(scanner.nextLine());
                        System.out.println("Data dokter berhasil diperbarui!");
                        return;
                    }
                }
                break;
        }
        System.out.println(tipe + " dengan ID tersebut tidak ditemukan!");
    }

    static void hapusData(String tipe) {
        System.out.print("Masukkan ID " + tipe + " yang akan dihapus: ");
        int idHapus = scanner.nextInt();
        scanner.nextLine();
        
        switch (tipe) {
            case "Pasien":
                daftarPasien.removeIf(p -> p.getIdPasien() == idHapus);
                break;
            case "Dokter":
                daftarDokter.removeIf(d -> d.getIdDokter() == idHapus);
                break;
        }
        System.out.println(tipe + " berhasil dihapus!");
    }
}
