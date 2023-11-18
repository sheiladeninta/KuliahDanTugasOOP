public abstract class BaseFormulir {
    public String nama;
    public Integer noHP;
    public String alamat;
    public String prodi;

    public void caraBayar() {
        System.out.println("CARA BAYAR SECARA UMUM");
    }

    public abstract void tataTertib();

}