package posttest6;
import posttest6.RekamMedisException;

// Custom exception class untuk RekamMedis
class RekamMedisException extends Exception {
    public RekamMedisException(String message) {
        super(message);
    }
}

public class RekamMedis {
    private int idRekam;
    private int idPasien;
    private int idDokter;
    private int idJadwal;
    private String namaPenyakit;
    private String statusPenyakit;
    private String keterangan;
    
    // Static counter untuk ID otomatis
    private static int counter = 1;

    public RekamMedis(int idRekam, int idPasien, int idDokter, int idJadwal, String namaPenyakit, String statusPenyakit, String keterangan) {
        this.idRekam = idRekam;
        this.idPasien = idPasien;
        this.idDokter = idDokter;
        this.idJadwal = idJadwal;
        this.namaPenyakit = namaPenyakit;
        this.statusPenyakit = statusPenyakit;
        this.keterangan = keterangan;
    }
    
    // Constructor dengan ID otomatis
    public RekamMedis(int idPasien, int idDokter, int idJadwal, String namaPenyakit, String statusPenyakit, String keterangan) throws RekamMedisException {
        // Validasi input
        if (namaPenyakit == null || namaPenyakit.trim().isEmpty()) {
            throw new RekamMedisException("Nama penyakit tidak boleh kosong");
        }
        
        this.idRekam = counter++;
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

    public void setNamaPenyakit(String namaPenyakit) throws RekamMedisException {
        if (namaPenyakit == null || namaPenyakit.trim().isEmpty()) {
            throw new RekamMedisException("Nama penyakit tidak boleh kosong");
        }
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
    
    // Static method untuk reset counter
    public static void resetCounter() {
        counter = 1;
    }
    
    // Static method untuk validasi rekam medis
    public static boolean validasiRekamMedis(String namaPenyakit, String statusPenyakit) {
        return namaPenyakit != null && !namaPenyakit.trim().isEmpty() &&
               statusPenyakit != null && !statusPenyakit.trim().isEmpty();
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