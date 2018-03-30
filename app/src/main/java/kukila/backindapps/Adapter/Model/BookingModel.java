package kukila.backindapps.Adapter.Model;

/**
 * Created by Mindha on 15/11/2017.
 */

public class BookingModel {
    int id;
    String booking,wisata,homestay, harga;

    public BookingModel(int id, String booking, String wisata, String homestay, String harga) {
        this.id = id;
        this.booking = booking;
        this.wisata = wisata;
        this.homestay = homestay;
        this.harga = harga;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBooking() {
        return booking;
    }

    public void setBooking(String booking) {
        this.booking = booking;
    }

    public String getWisata() {
        return wisata;
    }

    public void setWisata(String wisata) {
        this.wisata = wisata;
    }

    public String getHomestay() {
        return homestay;
    }

    public void setHomestay(String homestay) {
        this.homestay = homestay;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }
}
