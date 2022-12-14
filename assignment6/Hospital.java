import java.util.ArrayList;

public class Hospital {

    public String id;

    public final int allowedResidents;
    public ArrayList<String> residents;

    // Arraylists preserve order of insertion, which happens to be order of
    // preference.
    public ArrayList<String> preferences;

    public Hospital(String id, int allowedResidents, ArrayList<String> preferences) {
        this.id = id;
        this.allowedResidents = allowedResidents;
        this.residents = new ArrayList<>();
        this.preferences = preferences;
    }

    public String toString() {
        String str = "[" + id + ", residents: " + this.residents + "]";
        return str;
    }

}