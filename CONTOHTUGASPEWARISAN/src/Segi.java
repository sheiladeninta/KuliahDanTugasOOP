public class Segi extends BangunDatar {
    public double panjang;
    public double lebar;
    public double sisi;
    public double jumlahSisi;

    Segi(double panjang, double lebar, double sisi, double jumlahSisi){
        this.panjang = panjang;
        this.lebar = lebar;
        this.sisi = sisi;
        this.jumlahSisi = jumlahSisi;
    }
    Segi(String nama, double panjang, double lebar, double sisi, double jumlahSisi){
        super();
        this.panjang = panjang;
        this.lebar = lebar;
        this.sisi = sisi;
        this.jumlahSisi = jumlahSisi;
    }
    @Override
    public double hitungLuas(){
        double hasilLuasSegiPanjang = panjang * lebar;
        return hasilLuasSegiPanjang;
    }

    @Override
    public double hitungKeliling(){
        double hasilKelilingSegiPanjang = panjang*2 + lebar*2;
        return hasilKelilingSegiPanjang;
    }
    // Overloading
    public double hitungKeliling(double sisi, double jumlahSisi){
        double hasilKelilingSegi = sisi * jumlahSisi;
        return hasilKelilingSegi;
    }
}
