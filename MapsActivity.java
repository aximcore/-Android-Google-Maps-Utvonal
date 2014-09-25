package com.example.aximcore.hangyamaps;

// Készítette Tóth Máté < aximcore@gmail.com > 2014.09.23             
// Copyright (C) 2014, Máté Tóth

// This program is free software: you can redistribute it and/or modify
// it under the terms of the GNU General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.

// This program is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// GNU General Public License for more details.

// You should have received a copy of the GNU General Public License
// along with this program.  If not, see http://www.gnu.org/licenses/

// Ez a program szabad szoftver; terjeszthető illetve módosítható a 
// Free Software Foundation által kiadott GNU General Public License
// dokumentumában leírtak; akár a licenc 3-as, akár (tetszőleges) későbbi változata szerint.
                
// Ez a program abban a reményben kerül közreadásra, hogy hasznos lesz, 
// de minden egyéb GARANCIA NÉLKÜL, az ELADHATÓSÁGRA vagy VALAMELY CÉLRA 
// VALÓ ALKALMAZHATÓSÁGRA való származtatott garanciát is beleértve. 
// További részleteket a GNU General Public License tartalmaz.

// A felhasználónak a programmal együtt meg kell kapnia a GNU General 
// Public License egy példányát; ha mégsem kapta meg, akkor tekintse meg a
// http://www.gnu.org/licenses/ oldalon.

// Begin ****************************************
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.Criteria;
import android.widget.TextView;
import android.widget.Toast;
// End ******************************************

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity
        // Begin ****************************************
        implements LocationListener
        // End ******************************************
{
    // Begin ****************************************
    private TextView latituteField;
    private TextView longitudeField;
    private LocationManager locationManager;
    private String provider;
    // End ******************************************

    private GoogleMap mMap; // Might be null if Google Play services APK is not available.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        setUpMapIfNeeded();

        // Begin ****************************************
        if (mMap != null) {
            mMap.setMyLocationEnabled(true);
        }

        latituteField = (TextView) findViewById(R.id.TextView01);
        longitudeField = (TextView) findViewById(R.id.TextView02);
        locationManager = ( LocationManager ) getSystemService(Context.LOCATION_SERVICE);
        Criteria criteria = new Criteria();
        provider = locationManager.getBestProvider(criteria,false);
        Location location = locationManager.getLastKnownLocation(provider);

        if ( location != null) {
            System.out.println("Provider " + provider + " kiválasztva.");
            onLocationChanged(location);
        }else{
          latituteField.setText("Hely nem elérhető!");
          longitudeField.setText("Hely nem elérhető");
        }
        // End ******************************************
    }

    @Override
    protected void onResume() {
        super.onResume();
        setUpMapIfNeeded();
        // Begin ****************************************
        locationManager.requestLocationUpdates(provider,/*400*/1,1,this);
        // End ******************************************
    }

    // Begin ****************************************
    @Override
    protected void onPause(){
        super.onPause();
        locationManager.removeUpdates(this);
    }

    @Override
    public void onLocationChanged(Location location){
        double lat =  location.getLatitude();
        double lng =  location.getLongitude();

        latituteField.setText(String.valueOf(lat));
        longitudeField.setText(String.valueOf(lng));

        LatLng POINTS = new LatLng(location.getLatitude(),
                location.getLongitude() );

        mMap.addMarker(new MarkerOptions().position(POINTS)
                .title("Pontok"));
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras){

    }

    @Override
    public void onProviderEnabled(String provider){
        Toast.makeText(this, "Enabled new provide " + provider, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onProviderDisabled(String provider){
        Toast.makeText(this,"Disabled provide " + provider, Toast.LENGTH_SHORT).show();
    }
    // End ******************************************

    private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.
        if (mMap == null) {
            // Try to obtain the map from the SupportMapFragment.
            mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
                    .getMap();
            // Check if we were successful in obtaining the map.
            if (mMap != null) {
                setUpMap();

            }
        }
    }

    private void setUpMap() {
        //mMap.addMarker(new MarkerOptions().position(new LatLng(0, 0)).title("Marker"));
    }
}
