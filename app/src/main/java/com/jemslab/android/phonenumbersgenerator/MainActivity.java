package com.jemslab.android.phonenumbersgenerator;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.res.Configuration;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.StaticLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends ActionBarActivity implements PhonesListFragment.OnPhoneItemSelectedListener{

    private static ArrayList<Phones> phonesArrayLocal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_container);

        /**are we using the single or double pane layout ?**/

        if(getResources().getConfiguration().orientation != Configuration.ORIENTATION_LANDSCAPE){
            /**we are using single pane layout**/

            /**are we restoring the instance state ?**/
        if(savedInstanceState != null){
            //yes we are restoring from a saved state-do nothing then

            return;
        }
            /**if it's the first time onCreate is being called we need to display the single pane fragment**/
                PhoneOptionsFragment phoneOptionsFragment = new PhoneOptionsFragment();

            /**add the fragment to the fragment_container FrameLayout**/
                getFragmentManager().beginTransaction()
                        .add(R.id.phonesFragContainer,phoneOptionsFragment)
                        .addToBackStack(null).commit();
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

/**********************************************************************************/
/**********************************************************************************/
/**********************************************************************************/


    /**on receiving user options call the PhonesGeneratorFragment**/
    public static void userOptions(int countryCode, int precedingDigits, int quantityOfPhoneNumbers, Activity activity) {
        /**PhonesGeneratorFragment instantiated and
         *  arguments passed through the bundle**/
        Context context = activity.getApplicationContext();
        CharSequence text = "Hello" + quantityOfPhoneNumbers;
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();

        FragmentManager fm = activity.getFragmentManager();
            PhonesGeneratorFragment phonesGeneratorFragment = new PhonesGeneratorFragment();
            Bundle args = new Bundle();
            args.putInt("countryCode",countryCode);
            args.putInt("precedingDigits",precedingDigits);
            args.putInt("quantityOfPhoneNumbers",quantityOfPhoneNumbers);
            phonesGeneratorFragment.setArguments(args);
            fm.beginTransaction().add(phonesGeneratorFragment, "phoneGen").addToBackStack(null).commit();

    }

    public static void generatedPhones(ArrayList<Phones> phonesArray, int countryCode, Activity activity) {

        phonesArrayLocal = phonesArray;


        /**two implementations depending on the layout currently being used**/
        /**CODE**/


        if(activity.findViewById(R.id.phonesFragContainer) != null){
            /**we are using single pane layout
            * therefore perform a fragment replace**/

            PhonesListFragment phonesListFrag = new PhonesListFragment();
            FragmentManager fm = activity.getFragmentManager();
            Bundle args = new Bundle();
            args.putParcelableArrayList("phoneArrayListParcelable",phonesArray);
            phonesListFrag.setArguments(args);
                fm.beginTransaction()
                    .replace(R.id.phonesFragContainer,phonesListFrag).addToBackStack(null)
                    .commit();

        }else{
            /**we are using the double pane layout
            * therefore update the listview**/
            PhonesListFragment phonesListFragm = (PhonesListFragment) activity.getFragmentManager()
                    .findFragmentById(R.id.phonesListFrag);
            phonesListFragm.populateListView(phonesArray);

        }


    }



    /**override the interface from the fragment displaying the phones list**/
    @Override
    public void onPhoneItemSelected(int position) {
    /**Just display the item index**/
        Phones phoneItem = phonesArrayLocal.get(position);
        String phone = phoneItem.getPhoneNumber();
        String country = phoneItem.getCountry();

        Context context = getApplicationContext();
        CharSequence text = "Hello " + phone + " "+country;
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();

    }

}

