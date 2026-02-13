import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class Rezept {
    private final String name;
    private final String gang;
    private final String zubereitung;
    private final String notizen;
    private final List<RezeptZutat> zutaten;

    @JsonCreator
    public Rezept(
            @JsonProperty("name") String name,
            @JsonProperty("gang") String gang,
            @JsonProperty("zubereitung") String zubereitung,
            @JsonProperty("notizen") String notizen,
            @JsonProperty("zutaten") List<RezeptZutat> zutaten
    ) {
        this.name = name;
        this.gang = gang;
        this.zubereitung = zubereitung;
        this.notizen = notizen;
        this.zutaten = zutaten == null ? List.of() : List.copyOf(zutaten);
    }

    public String getName() { return name; }
    public String getGang() { return gang; }
    public String getZubereitung() { return zubereitung; }
    public String getNotizen() { return notizen; }
    public List<RezeptZutat> getZutaten() { return zutaten; }
}

public class RezeptZutat {
    private final String name;
    private final String menge;     // STRING wegen "nach Bedarf"
    private final String einheit;

    @JsonCreator
    public RezeptZutat(
            @JsonProperty("name") String name,
            @JsonProperty("menge") String menge,
            @JsonProperty("einheit") String einheit
    ) {
        this.name = name;
        this.menge = menge;
        this.einheit = einheit;
    }

    public String getName() { return name; }
    public String getMenge() { return menge; }
    public String getEinheit() { return einheit; }

    // optional: versuchen, Zahl zu extrahieren
    public Double getMengeAlsZahl() {
        try {
            return Double.parseDouble(menge);
        } catch (Exception e) {
            return null; // z.B. "nach"
        }
    }
}