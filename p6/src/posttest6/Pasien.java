package posttest6;

public final class Pasien extends Orang { // Menerapkan final pada class
    private String alamat;
    private String tanggalLahir;

    // Constructor Pasien
    public Pasien(int id, String nama, String noHp, String alamat, String tanggalLahir) {
        super(id, nama, noHp);  // Memanggil constructor dari Orang
        this.alamat = alamat;
        this.tanggalLahir = tanggalLahir;
    }

    // Getter dan Setter untuk alamat dan tanggalLahir
    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getTanggalLahir() {
        return tanggalLahir;
    }

    public void setTanggalLahir(String tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

    @Override
    public String toString() {
        return super.toString() + ", Alamat: " + alamat + ", Tanggal Lahir: " + tanggalLahir;
    }

    // Overload untuk setData di Pasien
    public void setData(String alamat) {
        this.alamat = alamat;
    }

    public void setData(String nama, String alamat) {
        this.nama = nama;
        this.alamat = alamat;
    }
    
    // Implementasi abstract method
    @Override
    public final void tampilInfo() { // Menerapkan final pada method
        System.out.println("Pasien: " + nama + " (ID: " + id + ")");
        System.out.println("Alamat: " + alamat);
        System.out.println("Tanggal Lahir: " + tanggalLahir);
        System.out.println("No HP: " + noHp);
    }
}