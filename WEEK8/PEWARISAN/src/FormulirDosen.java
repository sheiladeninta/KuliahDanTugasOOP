public class FormulirDosen extends BaseFormulir {
    public String kodeDosen;

    @Override
    public void tataTertib() {
        System.out.println("TATA TERTIB DOSEN");
    }

    @Override
    public void caraBayar() {
        System.out.println("CARA BAYAR DOSEN");
        super.caraBayar(); // ini untuk manggil method di base dan ingin ditambah/modify logic di caraBayar
    }
}