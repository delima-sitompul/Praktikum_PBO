package posttest2;
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
            System.out.print("Pilih menu: ");

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
        
        // Mengecek apakah ID sudah ada
        switch (tipe) {
            case "Pasien":
                if (cekIDPasien(id)) {
                    System.out.println("ID Pasien sudah ada, pilih ID lain.");
                    return;
                }
                System.out.print("Masukkan Nama: ");
                String nama = scanner.nextLine();
                System.out.print("Masukkan Alamat: ");
                String alamat = scanner.nextLine();
                System.out.print("Masukkan No HP: ");
                String noHp = scanner.nextLine();
                System.out.print("Masukkan Tanggal Lahir: ");
                String tanggalLahir = scanner.nextLine();
                daftarPasien.add(new Pasien(id, nama, alamat, noHp, tanggalLahir));
                System.out.println("Pasien berhasil ditambahkan!");
                break;
            case "Dokter":
                if (cekIDDokter(id)) {
                    System.out.println("ID Dokter sudah ada, pilih ID lain.");
                    return;
                }
                System.out.print("Masukkan Nama: ");
                String namaDokter = scanner.nextLine();
                System.out.print("Masukkan Spesialisasi: ");
                String spesialisasi = scanner.nextLine();
                System.out.print("Masukkan No HP: ");
                String noHpDokter = scanner.nextLine();
                daftarDokter.add(new Dokter(id, namaDokter, noHpDokter, spesialisasi));
                System.out.println("Dokter berhasil ditambahkan!");
                break;
            case "Jadwal Kunjungan":
                if (cekIDJadwal(id)) {
                    System.out.println("ID Jadwal Kunjungan sudah ada, pilih ID lain.");
                    return;
                }
                System.out.print("Masukkan ID Pasien: ");
                int idPasien = scanner.nextInt();
                System.out.print("Masukkan ID Dokter: ");
                int idDokter = scanner.nextInt();
                System.out.print("Masukkan ID Admin: ");
                int idAdmin = scanner.nextInt();
                scanner.nextLine(); // untuk membaca newline
                System.out.print("Masukkan Tanggal dan Waktu: ");
                String tanggalWaktu = scanner.nextLine();
                System.out.print("Masukkan Status Kunjungan: ");
                String statusKunjungan = scanner.nextLine();
    
                daftarJadwal.add(new JadwalKunjungan(id, idPasien, idDokter, idAdmin, tanggalWaktu, statusKunjungan));
                System.out.println("Jadwal Kunjungan berhasil ditambahkan!");
                break;
            case "Rekam Medis":
                if (cekIDRekam(id)) {
                    System.out.println("ID Rekam Medis sudah ada, pilih ID lain.");
                    return;
                }
                System.out.print("Masukkan ID Pasien: ");
                int idPasienRekam = scanner.nextInt();  // Ganti nama variabelnya
                System.out.print("Masukkan ID Dokter: ");
                int idDokterRekam = scanner.nextInt();  // Ganti nama variabelnya
                System.out.print("Masukkan ID Jadwal: ");
                int idJadwal = scanner.nextInt();
                scanner.nextLine(); // Membaca newline
                
                System.out.print("Masukkan Nama Penyakit: ");
                String namaPenyakit = scanner.nextLine();
                System.out.print("Masukkan Status Penyakit: ");
                String statusPenyakit = scanner.nextLine();
                System.out.print("Masukkan Keterangan: ");
                String keterangan = scanner.nextLine();
                
                daftarRekamMedis.add(new RekamMedis(id, idPasienRekam, idDokterRekam, idJadwal, namaPenyakit, statusPenyakit, keterangan));
                System.out.println("Rekam Medis berhasil ditambahkan!");
                break;   
        }
    }

    static void lihatData(String tipe) {
        switch (tipe) {
            case "Pasien":
                if (daftarPasien.isEmpty()) {
                    System.out.println("Tidak ada data pasien.");
                } else {
                    for (Pasien p : daftarPasien) {
                        System.out.println(p);
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
    
            case "Jadwal Kunjungan":
                if (daftarJadwal.isEmpty()) {
                    System.out.println("Tidak ada data Jadwal Kunjungan.");
                } else {
                    for (JadwalKunjungan j : daftarJadwal) {
                        System.out.println(j);  // Secara otomatis memanggil toString()
                    }
                }
                break;
            case "Rekam Medis":
                if (daftarRekamMedis.isEmpty()) {
                    System.out.println("Tidak ada data Rekam Medis.");
                } else {
                    for (RekamMedis r : daftarRekamMedis) {
                        System.out.println(r);  // Secara otomatis memanggil toString()
                    }
                }
                break;

    
        
        }
    }
    

    static void updateData(String tipe) {
        System.out.print("Masukkan ID " + tipe + " yang akan diperbarui: ");
        int idUpdate = scanner.nextInt();
        scanner.nextLine();

        boolean found = false;
        switch (tipe) {
            case "Pasien":
                for (Pasien p : daftarPasien) {
                    if (p.getIdPasien() == idUpdate) {
                        found = true;
                        System.out.print("Masukkan Nama Baru (tekan Enter untuk tidak mengubah): ");
                        String namaBaru = scanner.nextLine();
                        if (!namaBaru.isEmpty()) p.setNama(namaBaru);

                        System.out.print("Masukkan Alamat Baru (tekan Enter untuk tidak mengubah): ");
                        String alamatBaru = scanner.nextLine();
                        if (!alamatBaru.isEmpty()) p.setAlamat(alamatBaru);

                        System.out.print("Masukkan No HP Baru (tekan Enter untuk tidak mengubah): ");
                        String noHpBaru = scanner.nextLine();
                        if (!noHpBaru.isEmpty()) p.setNoHp(noHpBaru);

                        System.out.print("Masukkan Tanggal Lahir Baru (tekan Enter untuk tidak mengubah): ");
                        String tanggalLahirBaru = scanner.nextLine();
                        if (!tanggalLahirBaru.isEmpty()) p.setTanggalLahir(tanggalLahirBaru);

                        System.out.println("Data pasien berhasil diperbarui!");
                        return;
                    }
                }
                break;
            case "Dokter":
                for (Dokter d : daftarDokter) {
                    if (d.getIdDokter() == idUpdate) {
                        found = true;
                        System.out.print("Masukkan Nama Baru (tekan Enter untuk tidak mengubah): ");
                        String namaBaruDokter = scanner.nextLine();
                        if (!namaBaruDokter.isEmpty()) d.setNama(namaBaruDokter);

                        System.out.print("Masukkan Spesialisasi Baru (tekan Enter untuk tidak mengubah): ");
                        String spesialisasiBaru = scanner.nextLine();
                        if (!spesialisasiBaru.isEmpty()) d.setSpesialisasi(spesialisasiBaru);

                        System.out.print("Masukkan No HP Baru (tekan Enter untuk tidak mengubah): ");
                        String noHpBaruDokter = scanner.nextLine();
                        if (!noHpBaruDokter.isEmpty()) d.setNoHp(noHpBaruDokter);

                        System.out.println("Data dokter berhasil diperbarui!");
                        return;
                    }
                }
            case "Jadwal Kunjungan":
                for (JadwalKunjungan j : daftarJadwal) {
                    if (j.getIdJadwal() == idUpdate) {
                        found = true;
                        System.out.print("Masukkan Tanggal Waktu Baru (tekan Enter untuk tidak mengubah): ");
                        String tanggalWaktuBaru = scanner.nextLine();
                        if (!tanggalWaktuBaru.isEmpty()) {
                            j.setTanggalWaktu(tanggalWaktuBaru); // Update jika tanggal waktu tidak kosong
                    }
                    System.out.print("Masukkan Status Kunjungan Baru (tekan Enter untuk tidak mengubah): ");
                    String statusKunjunganBaru = scanner.nextLine();
                    if (!statusKunjunganBaru.isEmpty()) {
                        j.setStatusKunjungan(statusKunjunganBaru); // Update jika status kunjungan tidak kosong
                    }
                    System.out.println("Jadwal kunjungan berhasil diperbarui!");
                    return;
                    }
                }
            case "Rekam Medis":
                for (RekamMedis r : daftarRekamMedis) {
                    if (r.getIdRekam() == idUpdate) {
                        found = true;
                        System.out.print("Masukkan Nama Penyakit Baru (tekan Enter untuk tidak mengubah): ");
                        String namaPenyakitBaru = scanner.nextLine();
                        if (!namaPenyakitBaru.isEmpty()) {
                            r.setNamaPenyakit(namaPenyakitBaru);
                        }
    
                        System.out.print("Masukkan Status Penyakit Baru (tekan Enter untuk tidak mengubah): ");
                        String statusPenyakitBaru = scanner.nextLine();
                        if (!statusPenyakitBaru.isEmpty()) {
                            r.setStatusPenyakit(statusPenyakitBaru);
                        }
    
                        System.out.print("Masukkan Keterangan Baru (tekan Enter untuk tidak mengubah): ");
                        String keteranganBaru = scanner.nextLine();
                        if (!keteranganBaru.isEmpty()) {
                            r.setKeterangan(keteranganBaru);
                        }
    
                        System.out.println("Rekam Medis berhasil diperbarui!");
                        return;
                    }
                }
                break;
            }

        if (!found) {
            System.out.println(tipe + " dengan ID tersebut tidak ditemukan!");
        }
    }

    static void hapusData(String tipe) {
        System.out.print("Masukkan ID " + tipe + " yang akan dihapus: ");
        int idHapus = scanner.nextInt();
        scanner.nextLine();

        boolean found = false;
        switch (tipe) {
            case "Pasien":
                for (Pasien p : daftarPasien) {
                    if (p.getIdPasien() == idHapus) {
                        daftarPasien.remove(p);
                        found = true;
                        System.out.println("Pasien berhasil dihapus!");
                        return;
                    }
                }
                break;
            case "Dokter":
                for (Dokter d : daftarDokter) {
                    if (d.getIdDokter() == idHapus) {
                        daftarDokter.remove(d);
                        found = true;
                        System.out.println("Dokter berhasil dihapus!");
                        return;
                    }
                }
                break;
            case "Jadwal Kunjungan":
                for (JadwalKunjungan j : daftarJadwal) {
                    if (j.getIdJadwal() == idHapus) {
                        daftarJadwal.remove(j);
                        found = true;
                        System.out.println("Jadwal kunjungan berhasil dihapus!");
                        return;
                    }
                }
            case "Rekam Medis":
                for (RekamMedis r : daftarRekamMedis) {
                    if (r.getIdRekam() == idHapus) {
                        daftarRekamMedis.remove(r);
                        found = true;
                        System.out.println("Rekam Medis berhasil dihapus!");
                        return;
                    }
                }
                break;
            }

        if (!found) {
            System.out.println(tipe + " dengan ID tersebut tidak ditemukan!");
        }
    }

    // Cek ID Pasien
    static boolean cekIDPasien(int id) {
        for (Pasien p : daftarPasien) {
            if (p.getIdPasien() == id) {
                return true;
            }
        }
        return false;
    }

    // Cek ID Dokter
    static boolean cekIDDokter(int id) {
        for (Dokter d : daftarDokter) {
            if (d.getIdDokter() == id) {
                return true;
            }
        }
        return false;
    }

    // cek id jadwal
    static boolean cekIDJadwal(int id) {
        for (JadwalKunjungan j : daftarJadwal) {
            if (j.getIdJadwal() == id) {
                return true;
            }
        }
        return false;
    }  
    
    
    // Cek ID Rekam Medis
    static boolean cekIDRekam(int id) {
        for (RekamMedis r : daftarRekamMedis) {
            if (r.getIdRekam() == id) {
                return true;
            }
        }
        return false;
    }

}
