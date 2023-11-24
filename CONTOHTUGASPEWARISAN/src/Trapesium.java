public class Trapesium extends BangunDatar {
    public double sisiAtas;
    public double sisiBawah;
    public double sisiSamping1;
    public double sisiSamping2;
    public double tinggi;

    public Trapesium(double sisiAtas, double sisiBawah, double sisiSamping1, double sisiSamping2, double tinggi) {
        this.sisiAtas = sisiAtas;
        this.sisiBawah = sisiBawah;
        this.sisiSamping1 = sisiSamping1;
        this.sisiSamping2 = sisiSamping2;
        this.tinggi = tinggi;
    }
    public Trapesium(String nama, double sisiAtas, double sisiBawah, double sisiSamping1, double sisiSamping2, double tinggi) {
        super();
        this.sisiAtas = sisiAtas;
        this.sisiBawah = sisiBawah;
        this.sisiSamping1 = sisiSamping1;
        this.sisiSamping2 = sisiSamping2;
        this.tinggi = tinggi;
    }
    @Override
    public double hitungLuas(){
        double hasil = (sisiAtas + sisiBawah) * 0.5 * tinggi;
        return hasil;
    }

    @Override
    public double hitungKeliling(){
        return sisiAtas + sisiBawah + sisiSamping1 + sisiSamping2 + tinggi;
    }

}
