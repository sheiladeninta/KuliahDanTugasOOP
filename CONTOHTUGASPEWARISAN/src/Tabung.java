public class Tabung extends BangunRuang {
    public double diameter;
    public double tinggi;

    Tabung (double diameter, double tinggi){
        this.diameter = diameter;
        this.tinggi = tinggi;
    }
    Tabung (String nama, double diameter, double tinggi){
        super();
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
