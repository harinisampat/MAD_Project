package com.example.mad_project;

import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.mad_project.databinding.HomePageMapBinding;

import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;

public class HomePageMap extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private HomePageMapBinding binding;
    Button btn_start;

    LatLng Udaan = new LatLng(19.11622, 72.91854);
    LatLng Punarvas = new LatLng(19.17109, 72.84524);
    LatLng Yuva = new LatLng(19.18268, 72.86169);
    LatLng BHN = new LatLng(19.13429, 72.83640);
    LatLng Anthony = new LatLng(19.054241, 72.82716);
    LatLng Smile = new LatLng(19.10914, 72.85068);
    LatLng Help = new LatLng(18.928328, 72.8242207);
    LatLng VCF = new LatLng(18.9796917, 72.838351);

    LatLngBounds mumbaiBounds = new LatLngBounds(
            new LatLng(18.8924, 72.7758), // SW bounds
            new LatLng(19.2535, 72.9754)  // NE bounds
    );


    private ArrayList<LatLng> ngoarray;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = HomePageMapBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        btn_start = findViewById(R.id.btn_start);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        ngoarray = new ArrayList<>();
        ngoarray.add(Udaan);
        ngoarray.add(Punarvas);
        ngoarray.add(Yuva);
        ngoarray.add(BHN);
        ngoarray.add(Anthony);
        ngoarray.add(Smile);
        ngoarray.add(Help);
        ngoarray.add(VCF);

        btn_start.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(HomePageMap.this, SelectCategory.class);
                startActivity(intent);
            }
        });

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

        for (int i=0; i<ngoarray.size(); i++)
        {
            LatLng location = ngoarray.get(i);
            String name = getNgoName(location);
            mMap.addMarker(new MarkerOptions().position(ngoarray.get(i)).title(name));
            mMap.moveCamera(CameraUpdateFactory.newLatLngBounds(mumbaiBounds, 0));

        }
    }

    private String getNgoName(LatLng location)
    {
        if(location.equals(Udaan))
            return "Udaan Foundation";
        else if(location.equals(Punarvas))
            return "Punarvas Special School";
        else if(location.equals(Yuva))
            return "Yuva Foundation";
        else if(location.equals(BHN))
            return "BHN Healthcare & Senior Living Center";
        else if(location.equals(Anthony))
            return "St. Anthony's Home for Aged";
        else if(location.equals(Smile))
            return "Smile Foundation";
        else if(location.equals(Help))
            return "Help Your NGO";
        else if(location.equals(VCF))
            return "VConnect Foundation";
        else
            return "";
    }
}