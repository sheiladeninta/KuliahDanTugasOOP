import java.io.Serializable;
import java.util.ArrayList;

public class RegisteredUser extends User implements Serializable {
    private static final long serialVersionUID = 1L;
    private static ArrayList<RegisteredUser> userDatabase;
    private String fullName;
    private String education;
    private String email;

    public RegisteredUser(String username, String password, String fullName, String education, String email) {
        super(username, password);
        this.fullName = fullName;
        this.education = education;
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEducation() {
        return education;
    }

    public String getEmail() {
        return email;
    }

    public static void initializeUserDatabase() {
        FileHelper fileHelper = new FileHelper();
        userDatabase = fileHelper.readFromDatabaseFile();
    }

    public static boolean registerUser(String username, String password, String fullName, String education, String email) {
        if (userDatabase == null) {
            initializeUserDatabase();
        }

        for (RegisteredUser user : userDatabase) {
            if (user.getUsername().equals(username)) {
                System.out.println("Username sudah terdaftar. Silakan pilih username lain.");
                return false;
            }
        }

        RegisteredUser newUser = new RegisteredUser(username, password, fullName, education, email);
        userDatabase.add(newUser);
        saveDataToDatabaseFile();
        System.out.println("Registrasi berhasil!");
        return true;
    }

    public static RegisteredUser loginUser(String username, String password) {
        if (userDatabase == null) {
            initializeUserDatabase();
        }

        for (RegisteredUser user : userDatabase) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                System.out.println("Login berhasil!");
                return user;
            }
        }

        System.out.println("Login gagal. Username atau password salah.");
        return null;
    }

    private static void saveDataToDatabaseFile() {
        FileHelper fileHelper = new FileHelper();
        fileHelper.saveToDatabaseFile(userDatabase);
    }
}
