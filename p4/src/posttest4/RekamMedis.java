package posttest4;

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

    public int getIdPasien() {
        return idPasien;
    }

    public int getIdDokter() {
        return idDokter;
    }

    public int getIdJadwal() {
        return idJadwal;
    }

    public String getNamaPenyakit() {
        return namaPenyakit;
    }

    public String getStatusPenyakit() {
        return statusPenyakit;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setNamaPenyakit(String namaPenyakit) {
        this.namaPenyakit = namaPenyakit;
    }

    public void setStatusPenyakit(String statusPenyakit) {
        this.statusPenyakit = statusPenyakit;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    @Override
public String toString() {
    return "Rekam Medis [ID Rekam: " + idRekam + 
           ", ID Pasien: " + idPasien + 
           ", ID Dokter: " + idDokter + 
           ", ID Jadwal: " + idJadwal + 
           ", Nama Penyakit: " + namaPenyakit + 
           ", Status Penyakit: " + statusPenyakit + 
           ", Keterangan: " + keterangan + "]";
        }

}
