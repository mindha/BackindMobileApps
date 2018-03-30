package kukila.backindapps.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import kukila.backindapps.Adapter.Model.CountryModel;
import kukila.backindapps.R;

/**
 * Created by Mindha on 18/06/2017.
 */

public class CountryAdapter extends ArrayAdapter<CountryModel> {
    private int lastPosition = -1;
    private ArrayList<CountryModel> dataSet;
    Context mContext;
    private static class ViewHolder {
        TextView country, start;
        LinearLayout itemWisata;

    }
    CountryAdapter.ViewHolder viewHolder;
    public CountryAdapter(ArrayList<CountryModel> data, Context context) {
        super(context, R.layout.item_country, data);
        this.dataSet = data;
        this.mContext=context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        CountryModel dataModel = getItem(position);
        final View result;
        if (convertView == null) {
            viewHolder = new CountryAdapter.ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(mContext);
            convertView = inflater.inflate(R.layout.item_country, parent, false);
            viewHolder.itemWisata= (LinearLayout) convertView.findViewById(R.id.item_wisata_list);
            viewHolder.country= (TextView) convertView.findViewById(R.id.country);
            viewHolder.start= (TextView) convertView.findViewById(R.id.start);


            result=convertView;
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (CountryAdapter.ViewHolder) convertView.getTag();
            result=convertView;
        }

        lastPosition = position;

        viewHolder.itemWisata.setVisibility(View.VISIBLE);
        viewHolder.country.setText(dataModel.getKota());
        viewHolder.start.setText(dataModel.getStart());


        return convertView;
    }
}
