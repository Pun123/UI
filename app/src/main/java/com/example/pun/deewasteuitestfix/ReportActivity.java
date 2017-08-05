package com.example.pun.deewasteuitestfix;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;


import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import static com.example.pun.deewasteuitestfix.R.id.map;

/**
 * Created by Pun on 8/5/2017 AD.
 */

public class ReportActivity extends AppCompatActivity implements OnMapReadyCallback{

    private Marker _myPositionMarker;
    private EditText editText_lat, editText_long;
    SupportMapFragment mapFragment;
    private GoogleMap _googleMap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);

        mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(map);
        mapFragment.getMapAsync(this);

     //   editText_lat = (EditText) findViewById(R.id.editText_lat);
      //  editText_long = (EditText) findViewById(R.id.editText_long);

        LocationManager locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);

        LocationListener locationListener = new LocationListener() {


            @Override
            public void onLocationChanged(Location location) {
                double latitude = (double) location.getLatitude();
                double longitude = (double) location.getLongitude();
              //  editText_lat.setText(String.valueOf(latitude));
              //  editText_long.setText(String.valueOf(longitude));
                Log.d("GPS", "Latitude is " + latitude);
                Log.d("GPS", "Longitude is " + longitude);
                LatLng currentPosition = new LatLng(latitude, longitude);
                _myPositionMarker = _googleMap.addMarker(new MarkerOptions().position(currentPosition).title("Hello").draggable(true));
                _myPositionMarker.setTag(0);
                float cameraZoom = 17;
                _googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(currentPosition, cameraZoom));

            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {

            }

            @Override
            public void onProviderEnabled(String provider) {

            }

            @Override
            public void onProviderDisabled(String provider) {

            }
        };
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, locationListener);









    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        _googleMap = googleMap;
        float cameraZoom = 17;
        LatLng paragonPosition = new LatLng(13.7468, 100.5351);
        _myPositionMarker = googleMap.addMarker(new MarkerOptions().position(paragonPosition).title("Hello").draggable(true));
        _myPositionMarker.setTag(0);



        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(paragonPosition, cameraZoom));

        googleMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {

            }
        });
        googleMap.setOnMarkerDragListener(new GoogleMap.OnMarkerDragListener() {
            @Override
            public void onMarkerDragStart(Marker marker) {

            }

            @Override
            public void onMarkerDrag(Marker marker) {

            }

            @Override
            public void onMarkerDragEnd(Marker marker) {
                LatLng position = marker.getPosition();
                // Toast.makeText(MainActivity.this, "Latitude " + position.latitude + " " + "Longitude " + position.longitude, Toast.LENGTH_LONG).show();




            }
        });

    }


}


