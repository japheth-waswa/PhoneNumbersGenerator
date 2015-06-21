package com.jemslab.android.phonenumbersgenerator;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Handles the generation of phone numbers and returns the array to the main activity
 */
public class PhonesGeneratorFragment extends Fragment {

    private int countryCode ;
    private int precedingDigits ;
    private int quantityOfPhones ;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);


        /**screen rotated do nothing ie "savedInstance is not null"
         * else if it is first time then do something**/

        if(savedInstanceState == null){
            Bundle args = getArguments();
            if(args != null){
            /*data successfuly passed here*/
                this.countryCode = args.getInt("countryCode");
                this.precedingDigits = args.getInt("precedingDigits");
                this.quantityOfPhones = args.getInt("quantityOfPhoneNumbers");
            }
        }

    }


    @Override
    public void onStart() {
        super.onStart();


        /**NOTE THE BUNDLE HAS TO HAVE THE OPTIONS FOR
         * GENERATING THE RANDOM NUMBERS **/

        String phoneNumber="jefflilcot";
        String country = "kenya";
        ArrayList<Phones> phonesArray = new ArrayList<>();
        int i= 0;

        while(i < 1000) phonesArray.add(new Phones(phoneNumber + i++, country));

        MainActivity.generatedPhones(phonesArray,countryCode,getActivity());
    }




}
