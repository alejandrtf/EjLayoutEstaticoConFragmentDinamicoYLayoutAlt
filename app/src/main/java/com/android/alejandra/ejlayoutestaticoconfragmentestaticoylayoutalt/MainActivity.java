package com.android.alejandra.ejlayoutestaticoconfragmentestaticoylayoutalt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.android.alejandra.ejlayoutestaticoconfragmentestaticoylayoutalt.model.LinkData;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements LinkListFragment.OnListFragmentSelectionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

        //cargo datos de los recursos
        LinkData.inicializarItemsFromResources(getResources().getStringArray(R.array.lista_enlaces_tutoriales_Android),
                getResources().getStringArray(R.array.urls_enlaces_tutoriales_Android));


    }



    @Override
    public void onListFragmentSelection(String urlTutorialSeleccionado) {
        boolean hayDosPaneles=getResources().getBoolean(R.bool.has_two_panels);

        if(hayDosPaneles){
            //obtengo el segundo panel
            WebViewFragment wvFragment=(WebViewFragment)getSupportFragmentManager().findFragmentById(R.id.webFragment);
            //muestro la url
            if(!wvFragment.getActualUrl().equals(urlTutorialSeleccionado))
                wvFragment.mostrarUrl(urlTutorialSeleccionado);
        }
        else{
            //debo lanzar la activity WebViewActivity
            Intent i = new Intent(this, WebViewActivity.class);
            i.putExtra(WebViewActivity.EXTRA_URL, urlTutorialSeleccionado);
            startActivity(i);
        }

    }
}
