package posttest5;

public abstract class Orang {
    protected final int id; // Menerapkan final pada atribut
    protected String nama;
    protected String noHp;

    // Constructor
    public Orang(int id, String nama, String noHp) {
        this.id = id;
        this.nama = nama;
        this.noHp = noHp;
    }

    // Getter untuk id, nama, noHp
    public int getId() {
        return id;
    }

    // Setter untuk nama dan noHp saja (id final tidak bisa diubah)
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNoHp() {
        return noHp;
    }

    public void setNoHp(String noHp) {
        this.noHp = noHp;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Nama: " + nama + ", No HP: " + noHp;
    }

    // Method Overloading
    public void setData(String nama) {
        this.nama = nama;
    }

    public void setData(String nama, String noHp) {
        this.nama = nama;
        this.noHp = noHp;
    }
    
    // Tidak bisa mengubah id karena sudah final
    public void setData(String nama, String noHp, String info) {
        this.nama = nama;
        this.noHp = noHp;
    }
    
    // Abstract method yang harus diimplementasikan oleh subclass
    public abstract void tampilInfo();
}