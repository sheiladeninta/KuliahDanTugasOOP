public class CobaFilter {
    public static void main(String[] args) {
        String find_bulan = "Des";
        String tanggal = "23 Des 2023";

        if (tanggal.contains(find_bulan)){
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}
