import java.util.List;
import java.util.ArrayList;

public class Database {
    private List<Konser> konserList;

    public Database() {
        konserList = new ArrayList<>();
        // Initialize the database with sample concerts
        konserList.add(new Konser("NOAH", "15-11-2023", "Sukabirus", 150000));
        konserList.add(new Konser("SHEILA ON 7", "18-11-2023", "Bandung", 200000));
    }

    public List<Konser> getKonserList() {
        return konserList;
    }

    // Other methods for inserting, showing, and handling concerts can remain the same.
}
