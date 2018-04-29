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
        Resources res = getResources();


        final ArrayList<Location> locations = new ArrayList<Location>();
        // texts from www.visitstockholm.com and https://www.stockholmarchipelago.se/en/destinations/
        locations.add(new Location(res.getString(R.string.archipelago_description), res.getString(R.string.click_on_location),res.getString(R.string.archipelago_description),false));
        //img ref: https://thumbs.dreamstime.com/b/port-vaxholm-sweden-island-popular-tourist-destination-stockholm-archipelago-embankment-front-hotel-42423351.jpg
        locations.add(new Location(res.getString(R.string.vaxholm_name), res.getString(R.string.vaxholm_address),res.getString(R.string.vaxholm_information),R.drawable.vaxholm,true));
        //img ref: https://www.stromma.se/link/8a771f5bb8d2421e807d62b42dab6e05.aspx
        locations.add(new Location(res.getString(R.string.fjaederholmarna_name), res.getString(R.string.fjaederholmarna_address),res.getString(R.string.fjaederholmarna_information),R.drawable.fjaederholmarna,true));
        //img ref: https://upload.wikimedia.org/wikipedia/commons/thumb/8/8a/Ljuster%C3%B6_kyrka_fr%C3%A5n_luften.jpg/800px-Ljuster%C3%B6_kyrka_fr%C3%A5n_luften.jpg
        locations.add(new Location(res.getString(R.string.ljusteroe_name), res.getString(R.string.ljusteroe_address),res.getString(R.string.ljusteroe_information),R.drawable.ljusteroe,true));
        //img ref: https://www.norrtalje.se/imagevault/publishedmedia/h3tvjnm8zzswy8wyrncx/CH_sk-rg-rd_05.jpg
        locations.add(new Location(res.getString(R.string.norrtaelje_name), res.getString(R.string.norrtaelje_address),res.getString(R.string.norrtaelje_information),R.drawable.norrtaelje,true));
        //img ref: http://www.tyreso.com/ovrigt/huvudskar/DSC01065Large.JPG
        locations.add(new Location(res.getString(R.string.huvudskaer_name), res.getString(R.string.huvudskaer_address),res.getString(R.string.huvudskaer_information),R.drawable.huvudskaer,true));
        //img ref: http://www.efncp.org/img/hnv/graesoe/map1.jpg
        locations.add(new Location(res.getString(R.string.graesoe_name), res.getString(R.string.graesoe_address),res.getString(R.string.graesoe_information),R.drawable.graeso,true));
        //img ref http://archipelagofoundation.se/wp-content/uploads/2012/05/Arholma12-725x420.jpg
        locations.add(new Location(res.getString(R.string.arholma_name), res.getString(R.string.arholma_address),res.getString(R.string.arholma_information),R.drawable.arholma,true));
        //img ref http://anderslif.se/20092013/anderslif.files.wordpress.com/2011/05/greentunnel.jpg
        locations.add(new Location(res.getString(R.string.aengsoe_name), res.getString(R.string.aengsoe_address),res.getString(R.string.aengsoe_information),R.drawable.aengso,true));
        //img ref http://www.upplevroslagen.se/content/uploads/2016/01/soderarm-konferens-skargard.jpg
        locations.add(new Location(res.getString(R.string.soederarm_name), res.getString(R.string.soederarm_address),res.getString(R.string.soederarm_information),R.drawable.soederarm,true));

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
