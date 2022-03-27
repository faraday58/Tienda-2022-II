package mx.unam.unica.tienda2.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import mx.unam.unica.tienda2.R;
import mx.unam.unica.tienda2.recyclerview.AdaptadorMuestraProducto;
import mx.unam.unica.tienda2.recyclerview.MuestraProducto;

public class BuscarFragment extends Fragment {

    private RecyclerView rcvProductos;
    private AdaptadorMuestraProducto mAdapter;
    private ArrayList<MuestraProducto> productos;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_buscar,container,false);
        rcvProductos= v.findViewById(R.id.rcvProductos);
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rcvProductos.setLayoutManager(llm);
        InicializarProductos();
        InicializarAdaptador();

           return v;

    }

    private void InicializarAdaptador() {
        mAdapter= new AdaptadorMuestraProducto(productos);
        rcvProductos.setAdapter(mAdapter);
    }

    private void InicializarProductos(){
        productos= new ArrayList<>();
        productos.add(new MuestraProducto("Estrena",R.drawable.tenisblancos,"Justo"));
        productos.add(new MuestraProducto("Estrena",R.drawable.teniscasual,"Justo"));
        productos.add(new MuestraProducto("Estrena",R.drawable.zapatos,"Justo"));
    }
}
