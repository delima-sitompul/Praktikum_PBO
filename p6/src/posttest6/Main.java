package posttest6;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    static List<Pasien> daftarPasien = new ArrayList<>();
    static List<Dokter> daftarDokter = new ArrayList<>();
    static List<JadwalKunjungan> daftarJadwal = new ArrayList<>();
    static List<RekamMedis> daftarRekamMedis = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    
    // Static variable untuk menyimpan tarif konsultasi
    public static final double TARIF_KONSULTASI_DASAR = 150000.0;

    public static void main(String[] args) {
        try {
            while (true) {
                System.out.println("\nMenu Utama:");
                System.out.println("1. Kelola Pasien");
                System.out.println("2. Kelola Dokter");
                System.out.println("3. Kelola Jadwal Kunjungan");
                System.out.println("4. Kelola Rekam Medis");
                System.out.println("5. Keluar");
                System.out.print("Pilih menu: ");
    
                try {
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
                } catch (InputMismatchException e) {
                    System.out.println("Error: Masukkan angka, bukan huruf atau karakter lain!");
                    scanner.nextLine(); // Clear buffer
                } catch (Exception e) {
                    System.out.println("Error tidak terduga: " + e.getMessage());
                }
            }
        } catch (Exception e) {
            System.out.println("Terjadi error dalam aplikasi: " + e.getMessage());
            e.printStackTrace();
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
            
            try {
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
            } catch (InputMismatchException e) {
                System.out.println("Error: Masukkan angka, bukan huruf atau karakter lain!");
                scanner.nextLine(); // Clear buffer
            } catch (RekamMedisException e) {
                System.out.println("Error rekam medis: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Error tidak terduga: " + e.getMessage());
            }
        }
    }

    static void tambahData(String tipe) throws Exception {
        try {
            System.out.print("Masukkan ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            
            // Mengecek apakah ID sudah ada
            switch (tipe) {
                case "Pasien":
                    if (cekIDPasien(id)) {
                        throw new Exception("ID Pasien sudah ada, pilih ID lain.");
                    }
                    System.out.print("Masukkan Nama: ");
                    String nama = scanner.nextLine();
                    System.out.print("Masukkan Alamat: ");
                    String alamat = scanner.nextLine();
                    System.out.print("Masukkan No HP: ");
                    String noHp = scanner.nextLine();
                    
                    // Validasi nomor HP
                    if (!Orang.validasiNoHP(noHp)) {
                        throw new Exception("Format nomor HP tidak valid! Harus 10-13 digit angka.");
                    }
                    
                    System.out.print("Masukkan Tanggal Lahir: ");
                    String tanggalLahir = scanner.nextLine();
                    daftarPasien.add(new Pasien(id, nama, alamat, noHp, tanggalLahir));
                    System.out.println("Pasien berhasil ditambahkan!");
                    break;
                case "Dokter":
                    if (cekIDDokter(id)) {
                        throw new Exception("ID Dokter sudah ada, pilih ID lain.");
                    }
                    System.out.print("Masukkan Nama: ");
                    String namaDokter = scanner.nextLine();
                    System.out.print("Masukkan Spesialisasi: ");
                    String spesialisasi = scanner.nextLine();
                    System.out.print("Masukkan No HP: ");
                    String noHpDokter = scanner.nextLine();
                    
                    // Validasi nomor HP
                    if (!Orang.validasiNoHP(noHpDokter)) {
                        throw new Exception("Format nomor HP tidak valid! Harus 10-13 digit angka.");
                    }
                    
                    Dokter dokterBaru = new Dokter(id, namaDokter, noHpDokter, spesialisasi);
                    daftarDokter.add(dokterBaru);
                    System.out.println("Dokter berhasil ditambahkan!");
                    
                    // Tampilkan biaya konsultasi menggunakan method interface
                    System.out.println("Biaya konsultasi: Rp " + dokterBaru.hitungBiaya());
                    
                    // Tampilkan jumlah dokter menggunakan static method
                    System.out.println("Total jumlah dokter: " + Dokter.getJumlahDokter());
                    break;
                case "Jadwal Kunjungan":
                    if (cekIDJadwal(id)) {
                        throw new Exception("ID Jadwal Kunjungan sudah ada, pilih ID lain.");
                    }
                    
                    // Validasi ID Pasien
                    System.out.print("Masukkan ID Pasien: ");
                    int idPasien = scanner.nextInt();
                    if (!cekIDPasien(idPasien)) {
                        throw new Exception("ID Pasien tidak ditemukan!");
                    }
                    
                    // Validasi ID Dokter
                    System.out.print("Masukkan ID Dokter: ");
                    int idDokter = scanner.nextInt();
                    if (!cekIDDokter(idDokter)) {
                        throw new Exception("ID Dokter tidak ditemukan!");
                    }
                    
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
                        throw new Exception("ID Rekam Medis sudah ada, pilih ID lain.");
                    }
                    
                    // Validasi ID Pasien
                    System.out.print("Masukkan ID Pasien: ");
                    int idPasienRekam = scanner.nextInt();
                    if (!cekIDPasien(idPasienRekam)) {
                        throw new Exception("ID Pasien tidak ditemukan!");
                    }
                    
                    // Validasi ID Dokter
                    System.out.print("Masukkan ID Dokter: ");
                    int idDokterRekam = scanner.nextInt();
                    if (!cekIDDokter(idDokterRekam)) {
                        throw new Exception("ID Dokter tidak ditemukan!");
                    }
                    
                    // Validasi ID Jadwal
                    System.out.print("Masukkan ID Jadwal: ");
                    int idJadwal = scanner.nextInt();
                    scanner.nextLine(); // Membaca newline
                    if (!cekIDJadwal(idJadwal)) {
                        throw new Exception("ID Jadwal tidak ditemukan!");
                    }
                    
                    System.out.print("Masukkan Nama Penyakit: ");
                    String namaPenyakit = scanner.nextLine();
                    System.out.print("Masukkan Status Penyakit: ");
                    String statusPenyakit = scanner.nextLine();
                    System.out.print("Masukkan Keterangan: ");
                    String keterangan = scanner.nextLine();
                    
                    // Validasi data rekam medis menggunakan static method
                    if (!RekamMedis.validasiRekamMedis(namaPenyakit, statusPenyakit)) {
                        throw new RekamMedisException("Data rekam medis tidak valid!");
                    }
                    
                    daftarRekamMedis.add(new RekamMedis(id, idPasienRekam, idDokterRekam, idJadwal, namaPenyakit, statusPenyakit, keterangan));
                    System.out.println("Rekam Medis berhasil ditambahkan!");
                    break;   
            }
        } catch (InputMismatchException e) {
            scanner.nextLine(); // Clear buffer
            throw new Exception("Format input tidak valid! Pastikan ID berupa angka.");
        }
    }

    // Kode lainnya tetap sama dengan Main.java sebelumnya
    
    static void lihatData(String tipe) {
        switch (tipe) {
            case "Pasien":
                if (daftarPasien.isEmpty()) {
                    System.out.println("Tidak ada data pasien.");
                } else {
                    for (Pasien p : daftarPasien) {
                        p.tampilInfo();
                        System.out.println("--------------------");
                    }
                }
                break;
    
            case "Dokter":
                if (daftarDokter.isEmpty()) {
                    System.out.println("Tidak ada data dokter.");
                } else {
                    for (Dokter d : daftarDokter) {
                        d.tampilInfo();
                        System.out.println("Biaya Konsultasi: Rp " + d.hitungBiaya());
                        System.out.println("Status: " + (d.cekStatus("AKTIF") ? "Dokter Aktif" : "Dokter Tidak Aktif"));
                        System.out.println("--------------------");
                    }
                    // Tampilkan total jumlah dokter menggunakan static method
                    System.out.println("Total jumlah dokter: " + Dokter.getJumlahDokter());
                }
                break;
    
            case "Jadwal Kunjungan":
                if (daftarJadwal.isEmpty()) {
                    System.out.println("Tidak ada data Jadwal Kunjungan.");
                } else {
                    for (JadwalKunjungan j : daftarJadwal) {
                        System.out.println(j);
                        System.out.println("--------------------");
                    }
                }
                break;
            case "Rekam Medis":
                if (daftarRekamMedis.isEmpty()) {
                    System.out.println("Tidak ada data Rekam Medis.");
                } else {
                    for (RekamMedis r : daftarRekamMedis) {
                        System.out.println(r);
                        System.out.println("--------------------");
                    }
                }
                break;
        }
    }
    

    static void updateData(String tipe) throws Exception {
        try {
            System.out.print("Masukkan ID " + tipe + " yang akan diperbarui: ");
            int idUpdate = scanner.nextInt();
            scanner.nextLine();
    
            boolean found = false;
            switch (tipe) {
                case "Pasien":
                    for (Pasien p : daftarPasien) {
                        if (p.getId() == idUpdate) {
                            found = true;
                            System.out.print("Masukkan Nama Baru (tekan Enter untuk tidak mengubah): ");
                            String namaBaru = scanner.nextLine();
                            if (!namaBaru.isEmpty()) p.setNama(namaBaru);
    
                            System.out.print("Masukkan Alamat Baru (tekan Enter untuk tidak mengubah): ");
                            String alamatBaru = scanner.nextLine();
                            if (!alamatBaru.isEmpty()) p.setAlamat(alamatBaru);
    
                            System.out.print("Masukkan No HP Baru (tekan Enter untuk tidak mengubah): ");
                            String noHpBaru = scanner.nextLine();
                            if (!noHpBaru.isEmpty()) {
                                // Validasi nomor HP
                                if (!Orang.validasiNoHP(noHpBaru)) {
                                    throw new Exception("Format nomor HP tidak valid! Harus 10-13 digit angka.");
                                }
                                p.setNoHp(noHpBaru);
                            }
    
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
                        if (d.getId() == idUpdate) {
                            found = true;
                            System.out.print("Masukkan Nama Baru (tekan Enter untuk tidak mengubah): ");
                            String namaBaruDokter = scanner.nextLine();
                            if (!namaBaruDokter.isEmpty()) d.setNama(namaBaruDokter);
    
                            System.out.print("Masukkan Spesialisasi Baru (tekan Enter untuk tidak mengubah): ");
                            String spesialisasiBaru = scanner.nextLine();
                            if (!spesialisasiBaru.isEmpty()) d.setSpesialisasi(spesialisasiBaru);
    
                            System.out.print("Masukkan No HP Baru (tekan Enter untuk tidak mengubah): ");
                            String noHpBaruDokter = scanner.nextLine();
                            if (!noHpBaruDokter.isEmpty()) {
                                // Validasi nomor HP
                                if (!Orang.validasiNoHP(noHpBaruDokter)) {
                                    throw new Exception("Format nomor HP tidak valid! Harus 10-13 digit angka.");
                                }
                                d.setNoHp(noHpBaruDokter);
                            }
    
                            System.out.println("Data dokter berhasil diperbarui!");
                            
                            // Tampilkan biaya konsultasi yang diperbarui
                            System.out.println("Biaya konsultasi setelah update: Rp " + d.hitungBiaya());
                            return;
                        }
                    }
                    break;
                case "Jadwal Kunjungan":
                    for (JadwalKunjungan j : daftarJadwal) {
                        if (j.getIdJadwal() == idUpdate) {
                            found = true;
                            System.out.print("Masukkan Tanggal Waktu Baru (tekan Enter untuk tidak mengubah): ");
                            String tanggalWaktuBaru = scanner.nextLine();
                            if (!tanggalWaktuBaru.isEmpty()) {
                                j.setTanggalWaktu(tanggalWaktuBaru);
                            }
                            System.out.print("Masukkan Status Kunjungan Baru (tekan Enter untuk tidak mengubah): ");
                            String statusKunjunganBaru = scanner.nextLine();
                            if (!statusKunjunganBaru.isEmpty()) {
                                j.setStatusKunjungan(statusKunjunganBaru);
                            }
                            System.out.println("Jadwal kunjungan berhasil diperbarui!");
                            return;
                        }
                    }
                    break;
                case "Rekam Medis":
                    for (RekamMedis r : daftarRekamMedis) {
                        if (r.getIdRekam() == idUpdate) {
                            found = true;
                            System.out.print("Masukkan Nama Penyakit Baru (tekan Enter untuk tidak mengubah): ");
                            String namaPenyakitBaru = scanner.nextLine();
                            if (!namaPenyakitBaru.isEmpty()) {
                                try {
                                    r.setNamaPenyakit(namaPenyakitBaru);
                                } catch (RekamMedisException e) {
                                    System.out.println(e.getMessage());
                                    return;
                                }
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
                throw new Exception(tipe + " dengan ID tersebut tidak ditemukan!");
            }
        } catch (InputMismatchException e) {
            scanner.nextLine(); // Clear buffer
            throw new Exception("Format ID tidak valid! Masukkan angka.");
        }
    }

    static void hapusData(String tipe) throws Exception {
        try {
            System.out.print("Masukkan ID " + tipe + " yang akan dihapus: ");
            int idHapus = scanner.nextInt();
            scanner.nextLine();
    
            boolean found = false;
            switch (tipe) {
                case "Pasien":
                    for (int i = 0; i < daftarPasien.size(); i++) {
                        if (daftarPasien.get(i).getId() == idHapus) {
                            // Cek referential integrity
                            for (JadwalKunjungan j : daftarJadwal) {
                                if (j.getIdPasien() == idHapus) {
                                    throw new Exception("Pasien tidak dapat dihapus karena memiliki jadwal kunjungan!");
                                }
                            }
                            
                            for (RekamMedis r : daftarRekamMedis) {
                                if (r.getIdPasien() == idHapus) {
                                    throw new Exception("Pasien tidak dapat dihapus karena memiliki rekam medis!");
                                }
                            }
                            
                            daftarPasien.remove(i);
                            found = true;
                            System.out.println("Pasien berhasil dihapus!");
                            return;
                        }
                    }
                    break;
                case "Dokter":
                    for (int i = 0; i < daftarDokter.size(); i++) {
                        if (daftarDokter.get(i).getId() == idHapus) {
                            // Cek referential integrity
                            for (JadwalKunjungan j : daftarJadwal) {
                                if (j.getIdDokter() == idHapus) {
                                    throw new Exception("Dokter tidak dapat dihapus karena memiliki jadwal kunjungan!");
                                }
                            }
                            
                            for (RekamMedis r : daftarRekamMedis) {
                                if (r.getIdDokter() == idHapus) {
                                    throw new Exception("Dokter tidak dapat dihapus karena memiliki rekam medis!");
                                }
                            }
                            
                            daftarDokter.remove(i);
                            found = true;
                            System.out.println("Dokter berhasil dihapus!");
                            return;
                        }
                    }
                    break;
                case "Jadwal Kunjungan":
                    for (int i = 0; i < daftarJadwal.size(); i++) {
                        if (daftarJadwal.get(i).getIdJadwal() == idHapus) {
                            // Cek referential integrity
                            for (RekamMedis r : daftarRekamMedis) {
                                if (r.getIdJadwal() == idHapus) {
                                    throw new Exception("Jadwal tidak dapat dihapus karena terkait dengan rekam medis!");
                                }
                            }
                            
                            daftarJadwal.remove(i);
                            found = true;
                            System.out.println("Jadwal kunjungan berhasil dihapus!");
                            return;
                        }
                    }
                    break;
                case "Rekam Medis":
                    for (int i = 0; i < daftarRekamMedis.size(); i++) {
                        if (daftarRekamMedis.get(i).getIdRekam() == idHapus) {
                            daftarRekamMedis.remove(i);
                            found = true;
                            System.out.println("Rekam Medis berhasil dihapus!");
                            return;
                        }
                    }
                    break;
            }
    
            if (!found) {
                throw new Exception(tipe + " dengan ID tersebut tidak ditemukan!");
            }
        } catch (InputMismatchException e) {
            scanner.nextLine(); // Clear buffer
            throw new Exception("Format ID tidak valid! Masukkan angka.");
        }
    }

    // Cek ID Pasien
    static boolean cekIDPasien(int id) {
        for (Pasien p : daftarPasien) {
            if (p.getId() == id) {
                return true;
            }
        }
        return false;
    }

    // Cek ID Dokter
    static boolean cekIDDokter(int id) {
        for (Dokter d : daftarDokter) {
            if (d.getId() == id) {
                return true;
            }
        }
        return false;
    }

    // Cek ID Jadwal
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