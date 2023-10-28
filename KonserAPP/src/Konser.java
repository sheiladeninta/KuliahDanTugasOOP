public class Konser {
    private String namaBand;
    private String tanggal;
    private String lokasi;
    private int hargaTiket;

    public Konser(String namaBand, String tanggal, String lokasi, int hargaTiket) {
        this.namaBand = namaBand;
        this.tanggal = tanggal;
        this.lokasi = lokasi;
        this.hargaTiket = hargaTiket;
    }

    public String getNamaBand() {
        return namaBand;
    }

    public String getTanggal() {
        return tanggal;
    }

    public int getHargaTiket() {
        return hargaTiket;
    }

    public String getLokasi() {
        return lokasi;
    }

    // Other methods for konser attributes can remain the same.
}
