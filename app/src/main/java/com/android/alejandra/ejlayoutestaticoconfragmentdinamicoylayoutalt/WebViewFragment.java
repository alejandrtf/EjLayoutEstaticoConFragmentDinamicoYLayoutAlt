package com.android.alejandra.ejlayoutestaticoconfragmentdinamicoylayoutalt;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

/**
 * Created by Sandra on 15/11/2016.
 */
public class WebViewFragment extends Fragment {
    public static final String URL_ARG_TUTORIAL_SELECCIONADO = "url_item_elegido_en_la_listview" ;
    private String url;
    private String actualUrl = "" ; //usado para no recargar una url si está visible en ese momento


    public WebViewFragment() {
    }


    public String getActualUrl() {
        return actualUrl;
    }


    /**
     * Método que mostrará la url que se pasa
     *
     * @param url url a mostrar
     */
    public void mostrarUrl(String url) {

        //actualizo la url actual
        actualUrl = url;

        //obtengo la webview
        WebView webView = (WebView) getView().findViewById(R.id.wvWebPage);
        //activo javascript
        if (webView != null) {
            webView.getSettings().setJavaScriptEnabled(true);
            //cargo la url
            webView.loadUrl(url);
        }
    }


    //MÉTODOS DEL CICLO DE VIDA DEL FRAGMENT

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //inflo layout
        return (inflater.inflate(R.layout.web_layout, container, false));

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
}
