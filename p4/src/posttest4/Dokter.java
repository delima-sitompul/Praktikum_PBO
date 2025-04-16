package posttest4;

public class Dokter extends Orang {
    private String spesialisasi;

    // Constructor Dokter
    public Dokter(int id, String nama, String noHp, String spesialisasi) {
        super(id, nama, noHp);  // Memanggil constructor dari Orang
        this.spesialisasi = spesialisasi;
    }

    // Getter dan Setter untuk spesialisasi
    public String getSpesialisasi() {
        return spesialisasi;
    }

    public void setSpesialisasi(String spesialisasi) {
        this.spesialisasi = spesialisasi;
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

    }
