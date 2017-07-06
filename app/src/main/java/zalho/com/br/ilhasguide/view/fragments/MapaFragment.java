package zalho.com.br.ilhasguide.view.fragments;

import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;

import java.io.IOException;
import java.util.List;

/**
 * Created by andrepereira on 20/06/17.
 */

public class MapaFragment extends SupportMapFragment implements OnMapReadyCallback {

    @Override
    public void onCreate(Bundle savedInstaceState) {
        super.onCreate(savedInstaceState);

        getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        LatLng coordenadas = getMapCoordinates("Rua Vergueiro 3185, Vila Mariana, Sao Paulo");

        if(coordenadas != null){
            CameraUpdate update = CameraUpdateFactory.newLatLngZoom(coordenadas, 17);
            googleMap.moveCamera(update);
        }

    }

    private LatLng getMapCoordinates(String endereco) {
        try {
            Geocoder geocoder = new Geocoder(getContext());
            List<Address> resultadosMapa = geocoder.getFromLocationName(endereco, 1);

            if(!resultadosMapa.isEmpty()){
                LatLng posicao = new LatLng(resultadosMapa.get(0).getLatitude(), resultadosMapa.get(0).getLongitude());
                return posicao;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
