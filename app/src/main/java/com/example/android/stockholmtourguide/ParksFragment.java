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

public class ParksFragment extends Fragment {


    public ParksFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list, container, false);
        // texts from www.visitstockholm.com and https://www.thelocal.se/20150725/best-city-park-picks-in-stockholm//
        final ArrayList<Location> locations = new ArrayList<Location>();
        locations.add(new Location("Stockholm is green!","Click on each location to navigate to it with Google Maps!","Stockholm is practically a synonym for outdoor living, with parks and green spaces making up more than a third of the city. There are an impressive selection of public parks and pretty gardens that greet visitors to Stockholm, allowing you to enjoy recreational spaces, pleasant green surroundings and Swedish flora." , false));
        //img ref: http://www.travelmoments.eu/travelmoments/wordpress_2016/wp-content/uploads/stockholm_skansen-2.jpg
        locations.add(new Location("Skansen", "Djurgårdsslätten 49-51 11521 Stockholm", "Skansen is the oldest open-air museum in the world and also the Stockholm zoo, with animals native to Scandinavia.", R.drawable.vaxholm,true));
        //img ref: https://media-cdn.tripadvisor.com/media/photo-s/11/1b/77/12/djurgarden-stockholm.jpg
        locations.add(new Location("Kungliga Djurgården", "Fredrik Bloms väg 115 21 Stockholm", "Djurgården island became the world's first National City Park in the 1990s, gaining special protection thanks to its unique nature, culture and recreation offerings right in the middle of a capital." , R.drawable.skansen,true));
        //img ref: http://2.bp.blogspot.com/-dE6s0EKSxRs/VAiINilcNsI/AAAAAAAALvU/QN1OKbsTyHU/s1600/a%2Br%C3%A5.jpg
        locations.add(new Location("Rålambshovsparken", "Smedsuddsvägen 6, 112 35 Stockholm", "The park that locals call ‘Rålis’, is said to be inspired by Hyde Park in London and seeks to be a playground for visitors and residents alike, offering spots to play boule and volleyball.", R.drawable.kungliga,true));
        //img ref: https://viewstockholm.com/wp-content/uploads/2017/09/observatorielunden-stockholm.jpg
        locations.add(new Location("Observatorielunden", "Drottninggatan 120A, 113 60 Stockholm", "This small but pretty park leads you up a hill towards a magnificent view over the city. It’s the last trace of an esker that was formed when the last ice sheet receded from Sweden about 10,000 years ago.", R.drawable.observatorielunden,true));
        //img ref: https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQNz9n4t4lVRwpYaf8Tsif75JMyw43o6kkep9odJ_wBmFZDGjdO
        locations.add(new Location("Tantolunden", "Zinkens Väg, 118 42 Stockholm", "Tantolunden is one of Stockholm’s largest inner city parks. Here, you’ll find colourful mini-summer houses and people gardening in their own small yards and the popular Tanto Beach.", R.drawable.tanto,true));
        //img ref: https://stockholmskallan.stockholm.se/skblobs/4c/4cb05310-3699-44ad-8232-1b5354397147.JPG
        locations.add(new Location("Humlegården", "Karlavägen 32, 114 31 Stockholm", "Humlegården is right next to the buzzing Stureplan area packed with restaurants, hotels and expensive shops. Yet it still offers delightfully green and peaceful spot to relax in.", R.drawable.humle,true));

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
