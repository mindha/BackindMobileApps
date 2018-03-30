package kukila.backindapps;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import kukila.backindapps.Activity.LoginActivity;
import kukila.backindapps.Adapter.CountryAdapter;
import kukila.backindapps.Adapter.Model.CountryModel;


/**
 * A simple {@link Fragment} subclass.
 */
public class Home extends Fragment {


    public Home() {
        // Required empty public constructor
    }


    View myView;
    private static CountryAdapter adapter;
    ArrayList<CountryModel> dataModels;
    ListView listViewMessage;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.fragment_home, container, false);
        getActivity().setTitle("Home");
        listViewMessage = (ListView) myView.findViewById(R.id.listInfo);
        dummyInfo();
        initAdapter();
        return myView;
    }

    public void dummyInfo() {
        dataModels = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            dataModels.add(new CountryModel(i, "Kota" + (i + 1),"starting Rp20.000,-"));
        }
    }


    public void initAdapter() {
        adapter = new CountryAdapter(dataModels, getActivity().getApplicationContext());
        listViewMessage.setAdapter(adapter);
        listViewMessage.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                CountryModel dataModel = dataModels.get(position);
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
            }
        });

    }
}
