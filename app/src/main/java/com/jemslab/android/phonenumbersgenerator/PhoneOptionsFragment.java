package com.jemslab.android.phonenumbersgenerator;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * The first fragment to be displayed ie handles user input and validation.
 *
 */
public class PhoneOptionsFragment extends Fragment {
    @Nullable
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.phones_options,container,false);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        /**handle button clicks and validation
         * on success validation return the options to the MainActivity**/
        final Button btnGenerate = (Button) view.findViewById(R.id.button_generate);

        btnGenerate.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                MainActivity.userOptions(254,72,1000,getActivity());
            }
        });

    }
}
