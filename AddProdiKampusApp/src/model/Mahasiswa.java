package model;

public class Mahasiswa {
    private String nim;
    public String getNim() {
        return nim;
    }

    private String nama;
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    private String IDProdi;
    public String getIDProdi(){
        return IDProdi;
    }

    public Mahasiswa(String nim, String nama, String IDProdi) {
        this.nim = nim;
        this.nama = nama;
        this.IDProdi = IDProdi;
    }
}
