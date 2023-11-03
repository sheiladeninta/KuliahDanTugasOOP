package model;

public class Prodi {
    private String IDProdi;
    private String namaProdi;

    public Prodi(String IDProdi, String namaProdi){
        this.IDProdi = IDProdi;
        this.namaProdi = namaProdi;
    }

    public String getIDProdi(){
        return IDProdi;
    }

    public String getNamaProdi() {
        return namaProdi;
    }
}