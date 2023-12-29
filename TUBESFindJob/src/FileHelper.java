import java.io.*;
import java.util.ArrayList;

public class FileHelper {
    private static final String DATABASE_FILE_PATH = "database.txt";

    public <T> void saveToDatabaseFile(ArrayList<T> data) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(DATABASE_FILE_PATH))) {
            oos.writeObject(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public <T> ArrayList<T> readFromDatabaseFile() {
        ArrayList<T> data = new ArrayList<>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(DATABASE_FILE_PATH))) {
            data = (ArrayList<T>) ois.readObject();
        } catch (FileNotFoundException e) {
            // Jika file tidak ditemukan, akan mengembalikan ArrayList kosong.
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return data;
    }
}
