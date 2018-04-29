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

public class ParksFragment extends Fragment {


    public ParksFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list, container, false);
        Resources res = getResources();

        // texts from www.visitstockholm.com and https://www.thelocal.se/20150725/best-city-park-picks-in-stockholm//
        final ArrayList<Location> locations = new ArrayList<Location>();
        locations.add(new Location(res.getString(R.string.parks_description_title),res.getString(R.string.click_on_location),res.getString(R.string.parks_description), false));
        //img ref: http://www.travelmoments.eu/travelmoments/wordpress_2016/wp-content/uploads/stockholm_skansen-2.jpg
        locations.add(new Location(res.getString(R.string.skansen_name), res.getString(R.string.skansen_address),res.getString(R.string.skansen_information),R.drawable.skansen,true));
        //img ref: https://media-cdn.tripadvisor.com/media/photo-s/11/1b/77/12/djurgarden-stockholm.jpg
        locations.add(new Location(res.getString(R.string.kungliga_djurgarden_name), res.getString(R.string.kungliga_djurgarden_address),res.getString(R.string.kungliga_djurgarden_information),R.drawable.kungliga,true));
        //img ref: http://2.bp.blogspot.com/-dE6s0EKSxRs/VAiINilcNsI/AAAAAAAALvU/QN1OKbsTyHU/s1600/a%2Br%C3%A5.jpg
        locations.add(new Location(res.getString(R.string.ralambshovsparken_name), res.getString(R.string.ralambshovsparken_address),res.getString(R.string.ralambshovsparken_information),R.drawable.ralomb,true));
        //img ref: https://viewstockholm.com/wp-content/uploads/2017/09/observatorielunden-stockholm.jpg
        locations.add(new Location(res.getString(R.string.observatorielunden_name), res.getString(R.string.observatorielunden_address),res.getString(R.string.observatorielunden_information),R.drawable.observatorielunden,true));
        //img ref: https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQNz9n4t4lVRwpYaf8Tsif75JMyw43o6kkep9odJ_wBmFZDGjdO
        locations.add(new Location(res.getString(R.string.tantolunden_name), res.getString(R.string.tantolunden_address),res.getString(R.string.tantolunden_information),R.drawable.tanto,true));
        //img ref: https://stockholmskallan.stockholm.se/skblobs/4c/4cb05310-3699-44ad-8232-1b5354397147.JPG
        locations.add(new Location(res.getString(R.string.humlegarden_name), res.getString(R.string.humlegarden_address),res.getString(R.string.humlegarden_information),R.drawable.humle,true));

        LocationAdapter adapter = new LocationAdapter(getActivity(), locations, R.color.category_parks);

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
