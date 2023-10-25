import java.util.ArrayList; 

public class Database {
    private ArrayList <Mahasiswa> daftarMahasiswa = new ArrayList<>( );
    private FileHelper filehelper;
    public Database() {
        filehelper = new FileHelper();
        daftarMahasiswa = filehelper.bacaDariFile();
    }

    public void create(Mahasiswa mahasiswa) {
        daftarMahasiswa.add(mahasiswa);
        filehelper.simpanKeFile(daftarMahasiswa);
        // System.out.println("Data berhasil di tambahkan"); -> dinonaktifkan krn nanti ke-print 2 kali, soalnya di KampusApp udh ada print warning tsb
    }

    public ArrayList<Mahasiswa> read() {
        return daftarMahasiswa;
    }

    public Mahasiswa read(String nim) {
        Mahasiswa mahasiswa = null;
        for (int i = 0; i <daftarMahasiswa.size(); i++) {
            if(daftarMahasiswa.get(i).getNim().equals(nim)) {
                mahasiswa = daftarMahasiswa.get(i);
                break;
            }
        }
        return mahasiswa;
    }
    public void update(Mahasiswa mahasiswa, String nimLama) {
        for (int i = 0; i < daftarMahasiswa.size(); i++) {
            if(daftarMahasiswa.get(i).getNim().equals(nimLama)) {
                daftarMahasiswa.set(i, mahasiswa);
                filehelper.simpanKeFile(daftarMahasiswa);
                //System.out.println("* Data berhasil diubah *");
                return;
            }
        }
        System.out.println("* Data tidak ditemukan *");
    }
    public void delete(String nim) {
        for (int i = 0; i < daftarMahasiswa.size(); i++) {
            if(daftarMahasiswa.get(i).getNim().equals(nim)) {
                daftarMahasiswa.remove(i);
                filehelper.simpanKeFile(daftarMahasiswa);
                //System.out.println("* Data berhasil dihapus *");
                return;
            }
        }
        System.out.println("* Data tidak ditemukan *"); // tambah ';' krn sblmnya gaada
    }   
}  