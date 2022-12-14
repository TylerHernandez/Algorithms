import java.util.ArrayList;

public class Resident {

    public String id;

    // Arraylists preserve order of insertion, which happens to be order of
    // preference.
    public ArrayList<String> preferences;

    public Resident(String id, ArrayList<String> preferences) {
        this.id = id;
        this.preferences = preferences;
    }

}