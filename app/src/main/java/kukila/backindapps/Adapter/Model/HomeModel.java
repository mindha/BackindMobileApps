package kukila.backindapps.Adapter.Model;

/**
 * Created by Mindha on 15/11/2017.
 */

public class HomeModel {
    int id;
    String judul;

    public HomeModel(int id, String judul) {
        this.id = id;
        this.judul = judul;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }
}
