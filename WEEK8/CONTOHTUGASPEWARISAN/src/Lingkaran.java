public class Lingkaran extends BangunDatar {
    public double diameter;

    Lingkaran(String nama, double diameter){
        super(nama);
        this.diameter = diameter;
    }

    @Override
    public double hitungLuas(){
        double hasil = Math.PI * Math.pow((diameter/2), 2);
        return hasil;
    }
    
}
