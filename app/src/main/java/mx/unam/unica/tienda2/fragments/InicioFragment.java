package mx.unam.unica.tienda2.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import mx.unam.unica.tienda2.R;

public class InicioFragment extends Fragment {

    private ListView lstProductos;
    private String [] productos;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_inicio,container,false);
        lstProductos=v.findViewById(R.id.lstProductos);
        RellenarProductos();
        RellenarLista();
        return v;
    }

    private void RellenarLista() {
        ArrayAdapter miAdapter = new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1, productos );
        lstProductos.setAdapter(miAdapter);
    }

    private void RellenarProductos() {
        productos= getResources().getStringArray(R.array.string_productos);
    }



}
