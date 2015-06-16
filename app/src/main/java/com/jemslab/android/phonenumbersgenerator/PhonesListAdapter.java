package com.jemslab.android.phonenumbersgenerator;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Define the adapter to describe the process of converting the java object to a view( in the getView)
 */
public class PhonesListAdapter extends ArrayAdapter<Phones> {

    public static class ViewHolder{
        TextView phoneNumber;
        TextView country;

    }

    public PhonesListAdapter(Context context, ArrayList<Phones> phones) {
        super(context, 0,phones);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        /**get the current item**/
        Phones phone = getItem(position);

        /**check if the view(layout in my case containing the custom views for the list view)
         *  is being reused otherwise inflate it**/

        ViewHolder viewholder; /**view lookup stored in cache**/

        if(convertView == null){
            viewholder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.phone_list_item,parent,false);
            viewholder.phoneNumber = (TextView) convertView.findViewById(R.id.contactsPhoneNumber);
            viewholder.country = (TextView) convertView.findViewById(R.id.contactCountry);
            convertView.setTag(viewholder);
            //convertView = LayoutInflater.from(getContext()).inflate(R.layout.phone_list_item,parent,false);
        }else{
            viewholder = (ViewHolder) convertView.getTag();
        }

        /**views that are gonna contain data ie for data population from the java object**/
        /*TextView vPhoneNumber = (TextView) convertView.findViewById(R.id.contactsPhoneNumber);
        TextView vCountry = (TextView) convertView.findViewById(R.id.contactCountry); */

        /****/
        viewholder.phoneNumber.setText(phone.phoneNumber);
        viewholder.country.setText(phone.country);

        return convertView;
    }
}
