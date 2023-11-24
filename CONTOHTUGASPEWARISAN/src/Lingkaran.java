public class Lingkaran extends BangunDatar {
    public double diameter;

    Lingkaran(double diameter){
        this.diameter = diameter;
    }
    Lingkaran(String nama, double diameter){
        super();
        this.diameter = diameter;
    }
    @Override
    public double hitungLuas(){
        double hasil = Math.PI * Math.pow((diameter/2), 2);
        return hasil;
    }

    @Override
    public double hitungKeliling(){
        double hasil = 2 * Math.PI * (diameter/2);
        return hasil;
    }
    
}
