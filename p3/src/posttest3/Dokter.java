package posttest3;

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
}
