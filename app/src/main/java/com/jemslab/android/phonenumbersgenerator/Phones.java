package com.jemslab.android.phonenumbersgenerator;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Define model that has certain fields used in the list view
 */
public class Phones implements Parcelable{

    //parcel keys
    private static final String KEY_PHONE = "phone";
    private static final String KEY_COUNTRY = "country";
    public String phoneNumber;
    public String country;


    public Phones(String phoneNumber,String country){

        this.phoneNumber = phoneNumber;
        this.country = country;

    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        //create a bundle for the key value pairs
        Bundle bundle = new Bundle();

        /**Insert the key value pairs into the bundle**/
        bundle.putString(KEY_PHONE,phoneNumber);
        bundle.putString(KEY_COUNTRY,country);

        /**write the key value pairs to the bundle**/
        dest.writeBundle(bundle);

    }

    /**creator required for class implementing the parcelable interface**/
    public static final Parcelable.Creator<Phones> CREATOR = new Creator<Phones>() {
        @Override
        public Phones createFromParcel(Parcel source) {
            /**read the bundle containing the key value pairs from parcel**/

            Bundle bundle = source.readBundle();

            return new Phones(bundle.getString(KEY_PHONE),bundle.getString(KEY_COUNTRY));

        }

        @Override
        public Phones[] newArray(int size) {
            return new Phones[0];
        }
    };






}
