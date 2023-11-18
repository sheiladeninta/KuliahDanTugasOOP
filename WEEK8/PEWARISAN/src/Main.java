public class Main {
    public static void main(String[] args) {
        FormulirMahasiswa formulir_01 = new FormulirMahasiswa();
        formulir_01.caraBayar();
        formulir_01.tataTertib();

        FormulirDosen formulir_02 = new FormulirDosen();
        System.out.println("=======================");
        formulir_02.caraBayar();
        formulir_02.tataTertib();

        FormulirAdmin formulir_03 = new FormulirAdmin();
        System.out.println("=======================");
        formulir_03.caraBayar();
        formulir_03.tataTertib();
    }
    // bikin tugas contoh abstrak dg override dan overloading
    BaseFormulir [] listFormulir = BaseFormulir[5];
}
