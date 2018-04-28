package com.example.android.stockholmtourguide;


import android.content.Intent;
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

        final ArrayList<Location> locations = new ArrayList<Location>();
        //texts from www.visitstockholm.com
        locations.add(new Location("Sights and Vistas!","Click on each location to navigate to it with Google Maps!","Often called the \"Venice of the North,\" Stockholm lies on a number of islands and peninsulas at the outflow of Lake Mälar into the Baltic, which here forms a deep inlet. The list of things to do in Stockholm could be made endless and there are more than a hundred attractions to choose from." , false));
        //https://www.klm.com/travel/en/images/B4E364A2-BF2D-4737-9619-EBAB30197DE8_tcm493-541318_912x912_80.jpg
        locations.add(new Location("Gamla stan", "Stortorget, 111 29 Stockholm","Gamla Stan, the Old Town, is one of the largest and best preserved medieval city centers in Europe. This is where Stockholm was founded in 1252.", R.drawable.gamla_stan,true));
        //img ref: https://europevideoproductions.com/files/uploads/swedish-royal-palace-stockholm-sweden.jpg
        locations.add(new Location("The Royal Palace", "Slottsbacken 1", "The Royal Palace is the official residence of His Majesty the King of Sweden, with over 600 rooms. It also contains the Armory, with royal costumes and armor.", R.drawable.royal_palace,true));
        //img ref: https://firsthotelsiv.azurewebsites.net/publishedmedia/ojjve7692r703jvs6yhf/iStock-458086041.jpg
        locations.add(new Location("Gröna Lund", "Lilla Allmänna Gänd 9 11521 Stockholm", "Experience the joyful and magical world of Gröna Lund, Stockholm´s amusement park. Dine in one of the restaurants, enjoy a pentathlon, a live concert or one of the 30 exciting rides.", R.drawable.groena_lund,true));
        //img ref: http://2.bp.blogspot.com/-fL7dfwtYBw4/UJVnZBC_lmI/AAAAAAACPjU/aAOnwhbcHqI/s1600/16497644_1aaf7f80b7_b.jpg
        locations.add(new Location("Drottningholm Palace", "178 02 Drottningholm", "Experience a historic milieu of the highest standard. Drottningholm Palace is Sweden's best-preserved royal palace constructed in the seventeenth century.", R.drawable.drottningholm,true));
        //img ref: https://www.visitstockholm.com/globalassets/see-and-do/attractionssevardheter/the-city-hall_rectangle.jpg?preset=detail_big_retina
        locations.add(new Location("The City Hall", "Hantverkargatan 1S Stockholm", "The City Hall, with its spire featuring the golden Three Crowns, is one of the famous silhouettes in Stockholm. It's one of Sweden's leading examples of national romanticism in architecture.", R.drawable.stadshus,true));
        //img ref: https://i.pinimg.com/originals/97/f7/6f/97f76f22baa32d3797afdb25c1e333b0.jpg
        locations.add(new Location("Monteliusvägen", "Monteliusvägen Stockholm", "A 500-meter long walking path with a magnificent view of Lake Mälaren, City Hall, and Riddarholmen. The path is lined with charming houses on one side and a beautiful view on the other.", R.drawable.montelius,true));

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
