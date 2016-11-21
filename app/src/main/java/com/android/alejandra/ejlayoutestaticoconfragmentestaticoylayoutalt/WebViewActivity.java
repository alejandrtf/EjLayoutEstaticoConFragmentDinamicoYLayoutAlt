package com.android.alejandra.ejlayoutestaticoconfragmentestaticoylayoutalt;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


public class WebViewActivity extends AppCompatActivity {
    public static final String EXTRA_URL="com.android.alejandra.ejlayoutestaticoconfragmentestaticoylayoutalt.EXTRA_URL";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.web_view_activity_detalle);

        //obtengo la url a mostrar
        String url=getIntent().getStringExtra(EXTRA_URL);

        //obtengo el fragment del layout
        WebViewFragment wvFragment=(WebViewFragment)getSupportFragmentManager().findFragmentById(R.id.webFragment);
        //muestro la url
        if(!wvFragment.getActualUrl().equals(url)){
            wvFragment.mostrarUrl(url);
        }
    }
}
