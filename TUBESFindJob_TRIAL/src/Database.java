import java.util.ArrayList;

public class Database {
    private ArrayList<RegisteredUser> registeredUsers;
    private FileHelper fileHelper;

    public Database() {
        fileHelper = new FileHelper();
        registeredUsers = fileHelper.readFromDatabaseFile();
        if (registeredUsers == null) {
            registeredUsers = new ArrayList<>();
        }
    }

    public void create(RegisteredUser user) {
        registeredUsers.add(user);
        saveDataToDatabaseFile();
        System.out.println("Data berhasil ditambahkan");
    }

    public ArrayList<RegisteredUser> readAll() {
        return registeredUsers;
    }

    public RegisteredUser read(String username) {
        for (RegisteredUser user : registeredUsers) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    public void update(RegisteredUser user, String username) {
        for (int i = 0; i < registeredUsers.size(); i++) {
            if (registeredUsers.get(i).getUsername().equals(username)) {
                registeredUsers.set(i, user);
                saveDataToDatabaseFile();
                System.out.println("Data berhasil diubah");
                return;
            }
        }
        System.out.println("Data tidak ditemukan");
    }

    public void delete(String username) {
        for (int i = 0; i < registeredUsers.size(); i++) {
            if (registeredUsers.get(i).getUsername().equals(username)) {
                registeredUsers.remove(i);
                saveDataToDatabaseFile();
                System.out.println("Data berhasil dihapus");
                return;
            }
        }
        System.out.println("Data tidak ditemukan");
    }

    private void saveDataToDatabaseFile() {
        fileHelper.saveToDatabaseFile(registeredUsers);
    }
}
