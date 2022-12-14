import java.util.ArrayList;

public class Hospital {

    public String id;

    public final int allowedResidents;
    public ArrayList<String> residents;

    // Arraylists preserve order of insertion, which happens to be order of
    // preference.
    public ArrayList<String> preferences;

    public Hospital(String id, int allowedResidents,
            ArrayList<String> residents, ArrayList<String> preferences) {
        this.id = id;
        this.allowedResidents = allowedResidents;
        this.residents = residents;
        this.preferences = preferences;
    }

}