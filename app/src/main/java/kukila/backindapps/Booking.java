package kukila.backindapps;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import kukila.backindapps.Adapter.BookingAdapter;
import kukila.backindapps.Adapter.Model.BookingModel;


/**
 * A simple {@link Fragment} subclass.
 */
public class Booking extends Fragment {


    public Booking() {
        // Required empty public constructor
    }

    View myView;
    private static BookingAdapter adapter;
    ArrayList<BookingModel> dataModels;
    ListView listViewMessage;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.fragment_booking, container, false);
        getActivity().setTitle("MyBooking");
        listViewMessage = (ListView) myView.findViewById(R.id.listBooking);
        dummyInfo();
        initAdapter();
        return myView;
    }

    public void dummyInfo() {
        dataModels = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            dataModels.add(new BookingModel(i, "Kota " + (i + 1),"Wisata", "Homestay","Rp "+(i+1)+"50.000"));
        }
    }


    public void initAdapter() {
        adapter = new BookingAdapter(dataModels, getActivity().getApplicationContext());
        listViewMessage.setAdapter(adapter);
        listViewMessage.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                HomeModel dataModel = dataModels.get(position);
//                Intent intent = new Intent(getActivity(), DetailsInfo.class);
//                startActivity(intent);
            }
        });

    }
}
