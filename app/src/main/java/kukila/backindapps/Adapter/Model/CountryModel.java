package kukila.backindapps.Adapter.Model;

/**
 * Created by Mindha on 15/11/2017.
 */

public class CountryModel {
    int id;
    String kota, start ;

    public CountryModel(int id, String kota, String start) {
        this.id = id;
        this.kota = kota;
        this.start = start;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKota() {
        return kota;
    }

    public void setKota(String kota) {
        this.kota = kota;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }
}
