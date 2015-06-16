package com.jemslab.android.phonenumbersgenerator;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by JAPHETH on 2015-06-16.
 */
public class PhonesListFragment extends Fragment {

    PhonesListAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.phones_listings,container,false);

        String phoneNumber="jefflilcot";
        String country = "kenya";
        ArrayList<Phones> phonesArray = new ArrayList<>();
        int i= 0;

        while(i < 1000) phonesArray.add(new Phones(phoneNumber + i++, country));

        adapter = new PhonesListAdapter(getActivity(),phonesArray);
        ListView myListView = (ListView) view;
        myListView.setAdapter(adapter);

        return view;

    }
}
