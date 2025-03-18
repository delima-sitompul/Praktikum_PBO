package posttest1;

// public class Dokter {
//     import java.util.ArrayList;
// import java.util.List;

public class Dokter {
    private int idDokter;
    private String nama;
    private String noHp;
    private String spesialisasi;

    public Dokter(int idDokter, String nama, String noHp, String spesialisasi) {
        this.idDokter = idDokter;
        this.nama = nama;
        this.noHp = noHp;
        this.spesialisasi = spesialisasi;
    }

    public int getIdDokter() {
        return idDokter;
    }

    public String getNama() {
        return nama;
    }

    public String getNoHp() {
        return noHp;
    }

    public String getSpesialisasi() {
        return spesialisasi;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setNoHp(String noHp) {
        this.noHp = noHp;
    }

    public void setSpesialisasi(String spesialisasi) {
        this.spesialisasi = spesialisasi;
    }

    @Override
    public String toString() {
        return "Dokter { " +
                "ID = " + idDokter +
                ", Nama = '" + nama + '\'' +
                ", No HP = '" + noHp + '\'' +
                ", Spesialisasi = '" + spesialisasi + '\'' +
                " }";
    }
}


