public class Bola extends BangunRuang {
    public double diameter;

    public Bola (String nama, double diameter){
        super(nama);
        this.diameter = diameter;
    }
    
    @Override
    public double hitungLuas(){
        return 4 * Math.PI * Math.pow((diameter/2), 2);
    }

    public double hitungVolume(){
        return (4/3) * Math.PI * Math.pow((diameter/2), 2);
    }
    
}
