package posttest3;

public class Pasien extends Orang {
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
}
