import java.io.*;
import java.util.ArrayList;

public class FileHelper {
    private static final String BASE_PATH = "data/";

    public <T> void saveToDatabaseFile(String fileName, ArrayList<T> data) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(BASE_PATH + fileName))) {
            oos.writeObject(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public <T> ArrayList<T> readFromDatabaseFile(String fileName) {
        ArrayList<T> data = new ArrayList<>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(BASE_PATH + fileName))) {
            data = (ArrayList<T>) ois.readObject();
        } catch (FileNotFoundException e) {
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return data;
    }

}
