public class Tabung extends BangunRuang {
    public double diameter;
    public double tinggi;

    Tabung (String nama, double diameter, double tinggi){
        super(nama);
        this.diameter = diameter;
        this.tinggi = tinggi;
    }

    @Override
    public double hitungLuas() {
        return 2 * Math.PI * (diameter/2) * ((diameter/2)+tinggi);
    }

    @Override
    public double hitungVolume() {
        return Math.PI * Math.pow((diameter/2), 2) * tinggi;
    }
}
