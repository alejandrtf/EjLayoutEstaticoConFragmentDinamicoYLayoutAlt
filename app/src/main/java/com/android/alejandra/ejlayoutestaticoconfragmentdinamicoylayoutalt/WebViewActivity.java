package com.android.alejandra.ejlayoutestaticoconfragmentdinamicoylayoutalt;

import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


public class WebViewActivity extends AppCompatActivity {
    public static final String EXTRA_URL = "com.android.alejandra.ejlayoutestaticoconfragmentdinamicoylayoutalt.EXTRA_URL";
    private WebViewFragment wvFragment;
    private FragmentManager mFragmentManager;
    private String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.web_view_activity_detalle);

        mFragmentManager = getSupportFragmentManager();

        //obtengo la url a mostrar
        url = getIntent().getStringExtra(EXTRA_URL);

        // Comprobamos que previamente no hayamos entrado en esta actividad (por ejemplo, al rotar el dispositivo).
        // Si es así se añade el fragmento al contenedor
        if (savedInstanceState == null) {
            //creo el fragment
            wvFragment = new WebViewFragment();
            //lo añado al layout

            FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
            fragmentTransaction.add(R.id.contenedorWebFragment, wvFragment);
            fragmentTransaction.commit();
            // Force Android to execute the committed FragmentTransaction
            mFragmentManager.executePendingTransactions();
        } else {
            //ya existe el fragment,pues la activity ya fue creada antes
            //Por tanto, lo recojo usando el mFragmentManager.
            wvFragment = (WebViewFragment) mFragmentManager.getFragments().get(0);
        }

        if (!wvFragment.getActualUrl().equals(url)) {
            wvFragment.mostrarUrl(url);
        }

    }


}



