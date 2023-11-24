public abstract class BangunRuang {
    public String nama;
    void setNama(String nama){
        this.nama = nama;
    }
    String getNama (String nama){
        return this.nama;
    }
    abstract double hitungLuas();
    abstract double hitungVolume();
}
