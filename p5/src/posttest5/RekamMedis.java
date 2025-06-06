package posttest5;

public class RekamMedis {
    private int idRekam;
    private int idPasien;
    private int idDokter;
    private int idJadwal;
    private String namaPenyakit;
    private String statusPenyakit;
    private String keterangan;

    public RekamMedis(int idRekam, int idPasien, int idDokter, int idJadwal, String namaPenyakit, String statusPenyakit, String keterangan) {
        this.idRekam = idRekam;
        this.idPasien = idPasien;
        this.idDokter = idDokter;
        this.idJadwal = idJadwal;
        this.namaPenyakit = namaPenyakit;
        this.statusPenyakit = statusPenyakit;
        this.keterangan = keterangan;
    }

    public int getIdRekam() {
        return idRekam;
    }

    public void setIdRekam(int idRekam) {
        this.idRekam = idRekam;
    }

    public int getIdPasien() {
        return idPasien;
    }

    public void setIdPasien(int idPasien) {
        this.idPasien = idPasien;
    }

    public int getIdDokter() {
        return idDokter;
    }

    public void setIdDokter(int idDokter) {
        this.idDokter = idDokter;
    }

    public int getIdJadwal() {
        return idJadwal;
    }

    public void setIdJadwal(int idJadwal) {
        this.idJadwal = idJadwal;
    }

    public String getNamaPenyakit() {
        return namaPenyakit;
    }

    public void setNamaPenyakit(String namaPenyakit) {
        this.namaPenyakit = namaPenyakit;
    }

    public String getStatusPenyakit() {
        return statusPenyakit;
    }

    public void setStatusPenyakit(String statusPenyakit) {
        this.statusPenyakit = statusPenyakit;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    @Override
    public String toString() {
        return "RekamMedis{" +
                "idRekam=" + idRekam +
                ", idPasien=" + idPasien +
                ", idDokter=" + idDokter +
                ", idJadwal=" + idJadwal +
                ", namaPenyakit='" + namaPenyakit + '\'' +
                ", statusPenyakit='" + statusPenyakit + '\'' +
                ", keterangan='" + keterangan + '\'' +
                '}';
    }
}