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

public class SightsFragment extends Fragment {


    public SightsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list, container, false);
        Resources res = getResources();


        final ArrayList<Location> locations = new ArrayList<Location>();
        //texts from www.visitstockholm.com
        locations.add(new Location(res.getString(R.string.sights_description_title),res.getString(R.string.click_on_location),res.getString(R.string.sights_description), false));
        //https://www.klm.com/travel/en/images/B4E364A2-BF2D-4737-9619-EBAB30197DE8_tcm493-541318_912x912_80.jpg
        locations.add(new Location(res.getString(R.string.gamla_stan_name), res.getString(R.string.gamla_stan_address),res.getString(R.string.gamla_stan_information),R.drawable.gamla_stan,true));
        //img ref: https://europevideoproductions.com/files/uploads/swedish-royal-palace-stockholm-sweden.jpg
        locations.add(new Location(res.getString(R.string.royal_name), res.getString(R.string.royal_address),res.getString(R.string.royal_information),R.drawable.royal_palace,true));
        //img ref: https://firsthotelsiv.azurewebsites.net/publishedmedia/ojjve7692r703jvs6yhf/iStock-458086041.jpg
        locations.add(new Location(res.getString(R.string.groena_name), res.getString(R.string.groena_address),res.getString(R.string.groena_information),R.drawable.groena_lund,true));
        //img ref: http://2.bp.blogspot.com/-fL7dfwtYBw4/UJVnZBC_lmI/AAAAAAACPjU/aAOnwhbcHqI/s1600/16497644_1aaf7f80b7_b.jpg
        locations.add(new Location(res.getString(R.string.drottningholm_name), res.getString(R.string.drottningholm_address),res.getString(R.string.drottningholm_information),R.drawable.drottningholm,true));
        //img ref: https://www.visitstockholm.com/globalassets/see-and-do/attractionssevardheter/the-city-hall_rectangle.jpg?preset=detail_big_retina
        locations.add(new Location(res.getString(R.string.the_city_hall_name), res.getString(R.string.the_city_hall_address),res.getString(R.string.the_city_hall_information),R.drawable.stadshus,true));
        //img ref: https://i.pinimg.com/originals/97/f7/6f/97f76f22baa32d3797afdb25c1e333b0.jpg
        locations.add(new Location(res.getString(R.string.montelius_name), res.getString(R.string.montelius_address),res.getString(R.string.montelius_information),R.drawable.montelius,true));

        LocationAdapter adapter = new LocationAdapter(getActivity(), locations, R.color.category_sights);

        ListView listView = (ListView) rootView.findViewById(R.id.list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
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
