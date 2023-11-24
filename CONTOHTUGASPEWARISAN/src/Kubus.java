public class Kubus extends BangunRuang {
    public double sisi;

    Kubus(double sisi){
        this.sisi = sisi;
    }
    Kubus(String nama, double sisi){
        super();
        this.sisi = sisi;
    }

    @Override
    public double hitungLuas() {
        double hasil = Math.pow(sisi, 2) * 6;
        return hasil;
    }

    @Override
    public double hitungVolume(){
        double hasil = Math.pow(sisi, 3);
        return hasil;
    }
}
