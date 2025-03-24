package posttest2;

public class Pasien {
    private int idPasien;
    private String nama;
    private String alamat;
    private String noHp;
    private String tanggalLahir;

    public Pasien(int idPasien, String nama, String alamat, String noHp, String tanggalLahir) {
        this.idPasien = idPasien;
        this.nama = nama;
        this.alamat = alamat;
        this.noHp = noHp;
        this.tanggalLahir = tanggalLahir;
    }

    public int getIdPasien() {
        return idPasien;
    }

    public String getNama() {
        return nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public String getNoHp() {
        return noHp;
    }

    public String getTanggalLahir() {
        return tanggalLahir;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public void setNoHp(String noHp) {
        this.noHp = noHp;
    }

    public void setTanggalLahir(String tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

    @Override
public String toString() {
    return "Pasien [ID: " + idPasien + ", Nama: " + nama + ", Alamat: " + alamat + 
           ", No HP: " + noHp + ", Tanggal Lahir: " + tanggalLahir + "]";
}

    }

