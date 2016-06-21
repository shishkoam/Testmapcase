package shishkoam.testmapcase;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SearchView;
import android.widget.TabHost;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private SearchView searchView;
    private ListView listView;
    private Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_maps);
        setContentView(R.layout.main);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        RelativeLayout head = (RelativeLayout) findViewById(R.id.header0);
        searchView = (SearchView) findViewById(R.id.searchView);
        searchView.setQueryHint("Search View");

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String query) {
                Toast.makeText(getBaseContext(), query, Toast.LENGTH_LONG).show();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                Toast.makeText(getBaseContext(), newText, Toast.LENGTH_LONG).show();
                return false;
            }
        });

        TabHost tabs = (TabHost) findViewById(android.R.id.tabhost);

        tabs.setup();

        TabHost.TabSpec spec = tabs.newTabSpec("tag1");

        spec.setContent(R.id.tab1);
        spec.setIndicator("По расстоянию");
        tabs.addTab(spec);

        spec = tabs.newTabSpec("tag2");
        spec.setContent(R.id.tab2);
        spec.setIndicator("По стоимости");
        tabs.addTab(spec);

        tabs.setCurrentTab(0);

        Set<MapObject> gusStations = new HashSet();
        MapObject shell1 = new MapObject(new LatLng(-34, 151), "ул. Садовническая, 57", "Автозаправка Shell", 0, 0, 0);
        MapObject shell2 = new MapObject(new LatLng(-34, 151), "ул. Садовническая, 12", "Автозаправка Shell", 0, 0, 0);
        MapObject shell3 = new MapObject(new LatLng(-34, 151), "ул. Садовая, 57", "Автозаправка Shell", 0, 0, 0);
        MapObject shell4 = new MapObject(new LatLng(-34, 151), "ул. Садовая, 15", "Автозаправка Shell", 0, 0, 0);
        MapObject shell5 = new MapObject(new LatLng(-34, 151), "ул. Пчевская, 5", "Автозаправка Shell", 0, 0, 0);
        gusStations.add(shell1);
        gusStations.add(shell2);
        gusStations.add(shell3);
        gusStations.add(shell4);
        ArrayList<MapObject> gusList = new ArrayList();
        for (MapObject obj : gusStations) {
            gusList.add(obj);
        }
        listView = (ListView) findViewById(R.id.list_by_dist);
        ListHolder simpleListHolder = new ListHolder(context, gusList);
        SimpleAdapter listAdapter;
        listAdapter = new SimpleAdapter(context, simpleListHolder, 0);
        listView.setAdapter(listAdapter);
//        StikkyHeaderBuilder.stickTo(listView)
//                .setHeader(R.id.header, head)
//                .minHeightHeader(100)
//                .build();
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }
}
