// System.out.print -> print gak new line
// System.out.println -> print new line
public class kalkulator {
    public double hitung(double angka1, double angka2, char operator) {
        double hasil = 0.0;

        switch (operator) {
            case '+':
                hasil = angka1 + angka2;
                break;
            case '-':
                hasil = angka1 - angka2;
                break;
            case '*':
                hasil = angka1 * angka2;
                break;
            case '/':
                if (angka2 == 0) {
                    System.out.println("Tidak bisa melakukan pembagian dengan 0.");
                    System.exit(1);
                }
                hasil = angka1 / angka2;
                break;
            default:
                System.out.println("Operator tidak valid.");
                System.exit(1);
        }

        return hasil;
    }
}