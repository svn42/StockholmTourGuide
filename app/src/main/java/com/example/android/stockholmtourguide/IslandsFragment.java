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

/**
 * A simple {@link Fragment} subclass.
 */
public class IslandsFragment extends Fragment {


    public IslandsFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list, container, false);

        final ArrayList<Location> locations = new ArrayList<Location>();
        // texts from www.visitstockholm.com and https://www.stockholmarchipelago.se/en/destinations/
        locations.add(new Location("Welcome to Stockholm Archipelago", "Click on each location to navigate to it with Google Maps!","For archipelago explorers who want to discover more, these islands offer welcoming inns, hostels, and a genuine archipelago atmosphere. They are only a couple of hours away from the city, but we can assure you that you will feel as if you’ve entered a completely different world.",false));
        //img ref: https://thumbs.dreamstime.com/b/port-vaxholm-sweden-island-popular-tourist-destination-stockholm-archipelago-embankment-front-hotel-42423351.jpg
        locations.add(new Location("Vaxholm", "185 32 Vaxholm", "Idyllic archipelago town with many well-preserved wooden houses from the turn of the last century painted in the archipelago’s typical delicate pastel tones.", R.drawable.vaxholm, true));
        //img ref: https://www.stromma.se/link/8a771f5bb8d2421e807d62b42dab6e05.aspx
        locations.add(new Location("Fjäderholmarna", "Stora Fjäderholmen 111 15 Stockholm", "Fjäderholmarna provides a nice taste of the archipelago for people who don't have time to explore further. Boats depart from Strandvägen and Slussen during the summer.", R.drawable.fjaederholmarna, true));
        //img ref: https://upload.wikimedia.org/wikipedia/commons/thumb/8/8a/Ljuster%C3%B6_kyrka_fr%C3%A5n_luften.jpg/800px-Ljuster%C3%B6_kyrka_fr%C3%A5n_luften.jpg
        locations.add(new Location("Ljusterö", "184 95 Ljusterö", "Ljusterö is one of the largest islands in the Stockholm archipelago. Known for its beautiful nature, its well preserved settings from the 1700s.", R.drawable.ljusteroe, true));
        //img ref: https://www.norrtalje.se/imagevault/publishedmedia/h3tvjnm8zzswy8wyrncx/CH_sk-rg-rd_05.jpg
        locations.add(new Location("Norrtälje", "761 30 Norrtälje", "A genuine small town with many old wooden houses and beautiful cobblestone roads along the water. Here you'll find a rich cultural life with art, museums, music etc.", R.drawable.norrtaelje,true));
        //img ref: http://www.tyreso.com/ovrigt/huvudskar/DSC01065Large.JPG
        locations.add(new Location("Huvudskär", "S, 130 55 Utö", "Huvudskär is Haninge archipelago's final outpost. A vast, beautiful archipelago with more than 200 islands, islets and rocks. In the Middle Ages, there was a fishing village.", R.drawable.huvudskaer, true));
        //img ref: http://www.efncp.org/img/hnv/graesoe/map1.jpg
        locations.add(new Location("Gräsö", "Gräsö 742 97", "Gräsö which is Sweden’s tenth largest island has a unique cultural landscape with untouched outer archipelago, orchids and sea birds.", R.drawable.graeso,true));
        //img ref http://archipelagofoundation.se/wp-content/uploads/2012/05/Arholma12-725x420.jpg
        locations.add(new Location("Arholma", "Björkö-Arholma 764 54 Arholma", "A legendary island with proud maritime traditions and a vibrant cultural community. On Arholma you'll find many well-preserved houses and small farms", R.drawable.arholma,true));
        //img ref http://anderslif.se/20092013/anderslif.files.wordpress.com/2011/05/greentunnel.jpg
        locations.add(new Location("Ängsö", "Ängsö 761 12", "Ängsö is one of the first national parks in Sweden, and the county's smallest. Over 400 different kinds of plant species grow here.", R.drawable.aengso,true));
        //img ref http://www.upplevroslagen.se/content/uploads/2016/01/soderarm-konferens-skargard.jpg
        locations.add(new Location("Söderarm", "Tjockö Söderarm 2, 760 15 Gräddö", "Söderarm lighthouse is a public historical building well worth a visit. There is a conference centre on the island that's open year-round for pre-booked groups.", R.drawable.soederarm,true));

        LocationAdapter adapter = new LocationAdapter(getActivity(), locations, R.color.category_islands);

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
