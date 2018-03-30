package kukila.backindapps.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import kukila.backindapps.Adapter.Model.HomeModel;
import kukila.backindapps.R;

/**
 * Created by Mindha on 18/06/2017.
 */

public class HomeAdapter extends ArrayAdapter<HomeModel> {
    private int lastPosition = -1;
    private ArrayList<HomeModel> dataSet;
    Context mContext;
    private static class ViewHolder {
        TextView namaWisata;
        LinearLayout itemWisata;

    }
    HomeAdapter.ViewHolder viewHolder;
    public HomeAdapter(ArrayList<HomeModel> data, Context context) {
        super(context, R.layout.item_homestay, data);
        this.dataSet = data;
        this.mContext=context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        HomeModel dataModel = getItem(position);
        final View result;
        if (convertView == null) {
            viewHolder = new HomeAdapter.ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(mContext);
            convertView = inflater.inflate(R.layout.item_homestay, parent, false);
            viewHolder.itemWisata= (LinearLayout) convertView.findViewById(R.id.item_wisata_list);
            viewHolder.namaWisata= (TextView) convertView.findViewById(R.id.nama_wisata);

            result=convertView;
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (HomeAdapter.ViewHolder) convertView.getTag();
            result=convertView;
        }

        lastPosition = position;

        viewHolder.itemWisata.setVisibility(View.VISIBLE);
        viewHolder.namaWisata.setText(dataModel.getJudul());

        return convertView;
    }
}
