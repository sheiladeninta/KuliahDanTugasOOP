public class BelajarArray {
    public static void main(String[] args) {
        // 1 dimensi
        String [] daftar_nama_mahasiswa = new String[10];
        daftar_nama_mahasiswa[0] = "sheila";
        String nama_mahasiswa = daftar_nama_mahasiswa[3];
        String [] daftar_nama_mhs = { "sheila", "lala", "eka", "jihan", "silma"};

        // 2 dimensi
        String [][] daftar_nama_mahasiswa_2 = new String[9][16];
        daftar_nama_mahasiswa_2[0][0] = "sheila";
        daftar_nama_mahasiswa_2[0][1] = "silma";
        System.out.println(daftar_nama_mahasiswa_2[1][1]); // dia akan print null krn blm diisi untuk posisi 1,1

        // String[][]daftar_nama_mhs_2 ={
        //     {"Sheila", "Lala", "Silma", "Jihan"},
            
        // }

    }
}
