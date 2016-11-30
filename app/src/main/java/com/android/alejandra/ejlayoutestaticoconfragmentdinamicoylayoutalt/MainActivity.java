package com.android.alejandra.ejlayoutestaticoconfragmentdinamicoylayoutalt;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

import com.android.alejandra.ejlayoutestaticoconfragmentdinamicoylayoutalt.model.LinkData;

public class MainActivity extends AppCompatActivity implements LinkListFragment.OnListFragmentSelectionListener,
        WebViewFragment.OnViewCreatedListener {
    //lo usaré para guardar el estado del fragment detalle
    private static final String ID_WEBVIEW_FRAGMET = WebViewFragment.class.getSimpleName();

    //contenedor donde irá el fragment
    private FrameLayout contenedorLinkListFragment;
    //gestión de los fragments dinámicos
    private FragmentManager mFragmentManager;
    //fragment detalle
    private WebViewFragment wvFragment;
    //saber si hay dos paneles o no
    private boolean hayDosPaneles;

    private String url;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

        //cargo datos de los recursos
        LinkData.inicializarItemsFromResources(getResources().getStringArray(R.array.lista_enlaces_tutoriales_Android),
                getResources().getStringArray(R.array.urls_enlaces_tutoriales_Android));

        aniadirFragmentListado();
        if(savedInstanceState!=null) {
            //recupero el fragment guardado y la url
            wvFragment = (WebViewFragment) getSupportFragmentManager().getFragment(savedInstanceState, ID_WEBVIEW_FRAGMET);
            url=savedInstanceState.getString("url");
        }
    }


    /**
     * Método que añade dinámicamente el Fragment Listado al layout correspondiente
     */
    private void aniadirFragmentListado() {
        // Obtengo referencia a FragmentManager
        mFragmentManager = getSupportFragmentManager();

        // Arranco una nueva FragmentTransaction
        FragmentTransaction fragmentTransaction = mFragmentManager
                .beginTransaction();

        // Añado el Fragment LinkListFragment al layout
        fragmentTransaction.add(R.id.contenedorListFragment,
                new LinkListFragment());

        // Commit the FragmentTransaction
        fragmentTransaction.commit();

        //averiguo si hay dos paneles o no
        hayDosPaneles = getResources().getBoolean(R.bool.has_two_panels);
    }


    @Override
    public void onListFragmentSelection(String urlTutorialSeleccionado) {
        url = urlTutorialSeleccionado;
        if (hayDosPaneles) {
            //compruebo si se creo el segundo fragment ya, y si no, lo creo
            if (wvFragment == null) {
                wvFragment = new WebViewFragment();
            }

            //compruebo si ya fue añadido y si no, lo añado
            if (!wvFragment.isAdded()) {
                FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
                fragmentTransaction.add(R.id.contenedorWebFragment, wvFragment);
                // Add this FragmentTransaction to the backstack
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                // Force Android to execute the committed FragmentTransaction
                mFragmentManager.executePendingTransactions();
            }


        } else {
            //debo lanzar la activity WebViewActivity
            Intent i = new Intent(this, WebViewActivity.class);
            i.putExtra(WebViewActivity.EXTRA_URL, urlTutorialSeleccionado);
            startActivity(i);
        }

    }

    @Override
    public void onViewCreated() {
        //muestro la url
        if (!wvFragment.getActualUrl().equals(url))
            wvFragment.mostrarUrl(url);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        //guardo el fragment y la url
        mFragmentManager.putFragment(outState,ID_WEBVIEW_FRAGMET,wvFragment);
        outState.putString("url",url);
    }



}
