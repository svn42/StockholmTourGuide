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

public class MuseumsFragment extends Fragment {


    public MuseumsFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list, container, false);

        final ArrayList<Location> locations = new ArrayList<Location>();
        // texts from www.visitstockholm.com and https://www.thelocal.se/20150813/ten-must-see-museums-and-galleries-in-stockholm and https://www.lonelyplanet.com/sweden/stockholm/things-to-do/museums-and-galleries-in-stockholm
        locations.add(new Location("Museums in Stockholm","Click on each location to navigate to it with Google Maps!","Stockholm is mad on museums and new and innovative places to showcase the city’s creative heritage. A penchant for hoarding heritage has led to a hefty collection of 70 museum offerings, while contemporary galleries continue to sprout alongside the Swedish capital’s artistic stalwarts." , false));
        locations.add(new Location("Fotografiska", "Stadsgårdshamnen 22, Stockholm", "Stockholm's largest space for contemporary photography is housed in a former industrial Art Nouveau style building dating back to 1906, with stunning views over Djurgården island. Remodelled by Swedish architect Ferdinand Boberg, the huge gallery opened in 2010 and quickly became one of the city's hottest attractions.",true));
        locations.add(new Location("Moderna Museet", "Exercisplan, Skeppsholmen, Stockholm", "Moderna Museet is situated on the pretty island of Skeppsholmen and can be accessed via a ferry from Slussen or on foot from the swanky Östermalm district. The bright red museum attracts big names in contemporary art; it recently hosted work from one of the most important sculptors of the last few decades, Louise Bourgeois.", true));
        locations.add(new Location("Arkdes", "Exercisplan 4, Skeppsholmen, Stockholm", "Sweden's largest architecture museum, Arkdes, was founded in 1962. The museum is currently exhibiting some forty projects looking at how it could be possible to “hack” Stockholm's design and infrastructure in order to develop new sustainable and visually stimulating solutions.",true));
        locations.add(new Location("ABBA Museum", "Djurgården 68, Stockholm", "Here you can spend a day singing in a mocked-up Polar Studio, meeting ABBA holograms and dancing alongside the Swedish heroes on stage. You can also sneak a peak at plenty of ABBA's spectacular and eccentric stage costumes from the 1970s and 1980s.",true));
        locations.add(new Location("Tekniska Museet", "Museivägen 7, Stockholm", "Teknska Museet opened in 1936 and ever since then it has played host to millions of people curious to know more about technology. From September 6th 2015, a keynote exhibition entitled MEGA MIND is set to offer visitors the chance to \"paint\" with their eyes, make virtual sculptures or create music through the power of thought.",true));
        locations.add(new Location("Spirit Museum", "Djurgårdsvägen 38, Djurgården, Stockholm", "Located in Stockholm’s two remaining 18th century naval buildings on the island of Djurgården, the Spirit Museum focuses on the history of colourful, bitter, sweet, strong, soft and bubbly types of alcohol. This is also where Sweden's annual drinking song contest is held. Skål!",true));
        locations.add(new Location("The Vasa Museum", "Galärvarvsvägen 14 Stockholm", "Today the Vasa Museum is the most visited museum in Scandinavia, with over one million visitors a year. There are ten different exhibitions around the ship to tell about life on board the ship. The film about the Vasa is shown in 13 different languages. In addition, there is a well-stocked shop and a pleasant restaurant.",true));

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
