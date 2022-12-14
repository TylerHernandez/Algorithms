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

    public String toString() {
        String str = "[" + id + ", preferences: " + this.preferences + "]";
        return str;
    }

    public int compareTo(Resident resident) {
        if (this.preferences.size() < resident.preferences.size()) {
            return 1;
        } else if (this.preferences.size() == resident.preferences.size()) {
            return 0;
        } else {
            return -1;
        }
    }

}