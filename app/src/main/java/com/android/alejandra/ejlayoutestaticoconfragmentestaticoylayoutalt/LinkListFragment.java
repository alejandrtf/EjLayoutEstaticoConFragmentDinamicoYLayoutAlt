package com.android.alejandra.ejlayoutestaticoconfragmentestaticoylayoutalt;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.android.alejandra.ejlayoutestaticoconfragmentestaticoylayoutalt.model.LinkData;
import com.android.alejandra.ejlayoutestaticoconfragmentestaticoylayoutalt.model.LinkData.TutorialAndroid;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentSelectionListener}
 * interface.
 */
public class LinkListFragment extends ListFragment {
    private static final String TAG = "LinkListFragment" ;
    //listener
    private OnListFragmentSelectionListener mListener;


    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnListFragmentSelectionListener {

        void onListFragmentSelection(String urlTutorialSeleccionado);
    }


    /**
     * Método que es ejecutado cuando el usuario selecciona un elemento de la ListView del fragment
     *
     * @param l        ListView
     * @param v        View sobre la que se pulsó
     * @param position posición que ocupa la vista sobre la que se pulsó, dentro de la listView
     * @param id
     */
    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        //muestro el elemento seleccionado en diferente color
        getListView().setSelector(R.color.colorAccentTransparent);
        //obtengo la url
        String url= LinkData.ITEM_MAP.get((String)l.getAdapter().getItem(position)).getEnlaceContenido();
        //aviso a mi listener
        mListener.onListFragmentSelection(url);


    }



    /**
     * CONSTRUCTOR BÁSICO
     */
    public LinkListFragment() {
    }

    //MÉTODO ACONSEJADO PARA INSTANCIAR FRAGMENTS QUE SUSTITUYE AL CONSTRUCTOR
    public static LinkListFragment newInstance() {
        LinkListFragment fragment = new LinkListFragment();
        return fragment;
    }



    //MÉTODOS CICLO VIDA
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //asigno adaptador
        setListAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, LinkData.getStringArrayTutorialesTitulo()));

    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentSelectionListener) {
            mListener = (OnListFragmentSelectionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " debe implementar OnListFragmentSelectionListener");
        }
    }



    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    //NO LLEVA onCreateView porque usaré la lista de texto básica que incluye como layout la clase ListFragment
}
