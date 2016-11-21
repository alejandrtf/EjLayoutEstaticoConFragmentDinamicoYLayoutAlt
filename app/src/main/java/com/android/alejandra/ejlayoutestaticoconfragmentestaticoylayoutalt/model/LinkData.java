package com.android.alejandra.ejlayoutestaticoconfragmentestaticoylayoutalt.model;

import com.android.alejandra.ejlayoutestaticoconfragmentestaticoylayoutalt.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class LinkData {

    /**
     * Un array de TutorialAndroid
     */
    public static final List<TutorialAndroid> ITEMS = new ArrayList<>();

    /**
     * Un mapa de TutorialAndroid con el titulo como clave
     */
    public static final Map<String, TutorialAndroid> ITEM_MAP = new HashMap<>();

    private static int COUNT= ITEMS.size();


    private static void addTutorialAndroid(TutorialAndroid item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.titulo, item);
        COUNT=ITEMS.size();
    }

    public static TutorialAndroid createTutorialAndroid(String titulo) {
        return new TutorialAndroid(titulo);
    }


    public static void inicializarItemsFromResources(String[] arrayTitulos, String[] arrayUrls) {
        ITEMS.clear();
        ITEM_MAP.clear();
        for (int i = 0; i < arrayTitulos.length; i++) {
            addTutorialAndroid(new TutorialAndroid(String.valueOf(i), arrayTitulos[i], arrayUrls[i]));

        }
    }

    public static String[]getStringArrayTutorialesTitulo(){
        String[] arrayString=new String[COUNT];
        int pos=0;

        for (String entrada:ITEM_MAP.keySet()) {
            arrayString[pos]=entrada;
            pos++;

        }
        return(arrayString);
    }

    /**
     * A TutorialAndroid representing a piece of content.
     */
    public static class TutorialAndroid {
        public String id;
        public String titulo;
        public String enlaceContenido;

        public TutorialAndroid(String id, String titulo, String enlaceContenido) {
            this.id = id;
            this.titulo = titulo;
            this.enlaceContenido = enlaceContenido;
        }

        public TutorialAndroid(String id) {
            this.id = id;
        }

        @Override
        public String toString() {
            return titulo;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTitulo() {
            return titulo;
        }

        public String getEnlaceContenido() {
            return enlaceContenido;
        }

        public void setTitulo(String titulo) {
            this.titulo = titulo;
        }

        public void setEnlaceContenido(String enlaceContenido) {
            this.enlaceContenido = enlaceContenido;
        }

    }
}
