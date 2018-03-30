package kukila.backindapps.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import kukila.backindapps.Adapter.Model.BookingModel;
import kukila.backindapps.R;

/**
 * Created by Mindha on 18/06/2017.
 */

public class BookingAdapter extends ArrayAdapter<BookingModel> {
    private int lastPosition = -1;
    private ArrayList<BookingModel> dataSet;
    Context mContext;
    private static class ViewHolder {
        TextView booking, wisata, harga, homestay;
        LinearLayout itemWisata;

    }
    BookingAdapter.ViewHolder viewHolder;
    public BookingAdapter(ArrayList<BookingModel> data, Context context) {
        super(context, R.layout.item_homestay, data);
        this.dataSet = data;
        this.mContext=context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        BookingModel dataModel = getItem(position);
        final View result;
        if (convertView == null) {
            viewHolder = new BookingAdapter.ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(mContext);
            convertView = inflater.inflate(R.layout.item_booking, parent, false);
            viewHolder.itemWisata= (LinearLayout) convertView.findViewById(R.id.item_wisata_list);
            viewHolder.booking= (TextView) convertView.findViewById(R.id.booking);
            viewHolder.wisata= (TextView) convertView.findViewById(R.id.nama_wisata);
            viewHolder.homestay= (TextView) convertView.findViewById(R.id.nama_homestay);
            viewHolder.harga= (TextView) convertView.findViewById(R.id.harga);

            result=convertView;
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (BookingAdapter.ViewHolder) convertView.getTag();
            result=convertView;
        }

        lastPosition = position;

        viewHolder.itemWisata.setVisibility(View.VISIBLE);
        viewHolder.booking.setText(dataModel.getBooking());
        viewHolder.wisata.setText(dataModel.getWisata());
        viewHolder.homestay.setText(dataModel.getHomestay());
        viewHolder.harga.setText(dataModel.getHarga());

        return convertView;
    }
}
