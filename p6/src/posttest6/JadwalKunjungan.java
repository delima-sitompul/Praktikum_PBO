package posttest6;

public class JadwalKunjungan {
    private int idJadwal;
    private int idPasien;
    private int idDokter;
    private int idAdmin;
    private String tanggalWaktu;
    private String statusKunjungan;
    
    public JadwalKunjungan(int idJadwal, int idPasien, int idDokter, int idAdmin, String tanggalWaktu, String statusKunjungan) {
        this.idJadwal = idJadwal;
        this.idPasien = idPasien;
        this.idDokter = idDokter;
        this.idAdmin = idAdmin;
        this.tanggalWaktu = tanggalWaktu;
        this.statusKunjungan = statusKunjungan;
    }
    
    public int getIdJadwal() {
        return idJadwal;
    }
    
    public int getIdPasien() {
        return idPasien;
    }
    
    public int getIdDokter() {
        return idDokter;
    }
    
    public int getIdAdmin() {
        return idAdmin;
    }
    
    public String getTanggalWaktu() {
        return tanggalWaktu;
    }
    
    public void setTanggalWaktu(String tanggalWaktu) {
        this.tanggalWaktu = tanggalWaktu;
    }
    
    public String getStatusKunjungan() {
        return statusKunjungan;
    }
    
    public void setStatusKunjungan(String statusKunjungan) {
        this.statusKunjungan = statusKunjungan;
    }
    
    @Override
public String toString() {
    return "Jadwal Kunjungan [ID Jadwal: " + idJadwal + 
           ", ID Pasien: " + idPasien + 
           ", ID Dokter: " + idDokter + 
           ", ID Admin: " + idAdmin + 
           ", Tanggal Waktu: " + tanggalWaktu + 
           ", Status Kunjungan: " + statusKunjungan + "]";
    }

}

    

