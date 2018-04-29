package com.example.android.stockholmtourguide;


import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MuseumsFragment extends Fragment {


    public MuseumsFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list, container, false);
        Resources res = getResources();


        final ArrayList<Location> locations = new ArrayList<Location>();
        // texts from www.visitstockholm.com and https://www.thelocal.se/20150813/ten-must-see-museums-and-galleries-in-stockholm and https://www.lonelyplanet.com/sweden/stockholm/things-to-do/museums-and-galleries-in-stockholm
        locations.add(new Location(res.getString(R.string.museums_description_title),res.getString(R.string.click_on_location),res.getString(R.string.museums_description), false));
        locations.add(new Location(res.getString(R.string.fotografiska_name), res.getString(R.string.fotografiska_address),res.getString(R.string.fotografiska_information),true));
        locations.add(new Location(res.getString(R.string.moderna_name), res.getString(R.string.moderna_address),res.getString(R.string.moderna_information),true));
        locations.add(new Location(res.getString(R.string.arkdes_name), res.getString(R.string.arkdes_address),res.getString(R.string.arkdes_information),true));
        locations.add(new Location(res.getString(R.string.abba_name), res.getString(R.string.abba_address),res.getString(R.string.abba_information),true));
        locations.add(new Location(res.getString(R.string.tekniska_name), res.getString(R.string.tekniska_address),res.getString(R.string.tekniska_information),true));
        locations.add(new Location(res.getString(R.string.spirit_name), res.getString(R.string.spirit_address),res.getString(R.string.spirit_information),true));
        locations.add(new Location(res.getString(R.string.vasa_name), res.getString(R.string.vasa_address),res.getString(R.string.vasa_information),true));

        LocationAdapter adapter = new LocationAdapter(getActivity(), locations, R.color.category_museums);

        ListView listView = (ListView) rootView.findViewById(R.id.list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // Get the {@link Location} object at the given position the user clicked on
                Location location = locations.get(position);

                if (location.getHasAddress()) {
                    //reference: https://stackoverflow.com/questions/2662531/launching-google-maps-directions-via-an-intent-on-android?utm_medium=organic&utm_source=google_rich_qa&utm_campaign=google_rich_qa
                    //I used the address of the mainstation as starting address. For the geo-based location of your phone, just remove "?saddr=Centralplan 15, 111 20 Stockholm&"
                    Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                            Uri.parse("http://maps.google.com/maps?saddr=Centralplan 15, 111 20 Stockholm&daddr=" + location.getLocationAddress() + ""));
                    startActivity(intent);
                }
            }
        });
        return rootView;
    }

}
