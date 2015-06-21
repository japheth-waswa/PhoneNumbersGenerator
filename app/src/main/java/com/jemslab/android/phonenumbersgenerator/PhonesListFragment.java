package com.jemslab.android.phonenumbersgenerator;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Receives the arrayList from main activity.Populates the list view and returns the index of the selected list item to
 * the main activity.
 */
public class PhonesListFragment extends Fragment {

    PhonesListAdapter adapter;
    OnPhoneItemSelectedListener mListener;
    View view;
    private ArrayList<Phones> phonesArray;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

         view = inflater.inflate(R.layout.phones_listings,container,false);

        /**NOTE THE BUNDLE NEEDS TO HAVE THE LISTARRAY also the phone local arraylist**/

        Bundle args = getArguments();
        if(args != null){
            phonesArray = args.getParcelableArrayList("phoneArrayListParcelable");
            populateListView(phonesArray);
        }

        return view;

    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try{
            mListener = (OnPhoneItemSelectedListener) activity;
        }catch(ClassCastException e){
            throw new ClassCastException(activity.toString() + "must implement OnPhoneItemSelectedListener");
        }

    }

    public void populateListView(ArrayList<Phones> phonesArrayList) {

        adapter = new PhonesListAdapter(getActivity(),phonesArrayList);
        ListView myListView = (ListView) view;
        myListView.setAdapter(adapter);

    }

    public interface OnPhoneItemSelectedListener{

        void onPhoneItemSelected(int position);

    }



}



