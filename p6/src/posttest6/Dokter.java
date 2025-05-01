package posttest6;

public class Dokter extends Orang implements PelayananMedis {
    private String spesialisasi;
    
    // Static variable untuk tracking jumlah dokter
    private static int jumlahDokter = 0;

    // Constructor Dokter
    public Dokter(int id, String nama, String noHp, String spesialisasi) {
        super(id, nama, noHp);  // Memanggil constructor dari Orang
        this.spesialisasi = spesialisasi;
        jumlahDokter++; // Increment jumlah dokter
    }

    // Getter dan Setter untuk spesialisasi
    public String getSpesialisasi() {
        return spesialisasi;
    }

    public void setSpesialisasi(String spesialisasi) {
        this.spesialisasi = spesialisasi;
    }
    
    // Static method untuk mendapatkan jumlah dokter
    public static int getJumlahDokter() {
        return jumlahDokter;
    }

    @Override
    public String toString() {
        return super.toString() + ", Spesialisasi: " + spesialisasi;
    }

    // Overload di Dokter
    public void setData(String spesialisasi) {
        this.spesialisasi = spesialisasi;
    }

    public void setData(String nama, String spesialisasi) {
        this.nama = nama;
        this.spesialisasi = spesialisasi;
    }
    
    // Implementasi abstract method
    @Override
    public void tampilInfo() {
        System.out.println("Dokter: " + nama + " (ID: " + id + ")");
        System.out.println("Spesialisasi: " + spesialisasi);
        System.out.println("No HP: " + noHp);
    }
    
    // Implementasi method dari interface PelayananMedis
    @Override
    public double hitungBiaya() {
        // Menghitung biaya berdasarkan spesialisasi
        if (spesialisasi.equalsIgnoreCase("umum")) {
            return TARIF_DASAR;
        } else if (spesialisasi.equalsIgnoreCase("spesialis")) {
            return TARIF_DASAR * 1.5;
        } else {
            return TARIF_DASAR * 2.0; // Untuk subspesialis atau lainnya
        }
    }
    
    @Override
    public boolean cekStatus(String kode) {
        // Misalnya kode "AKTIF" untuk dokter yang sedang bertugas
        return kode.equalsIgnoreCase("AKTIF");
    }
}