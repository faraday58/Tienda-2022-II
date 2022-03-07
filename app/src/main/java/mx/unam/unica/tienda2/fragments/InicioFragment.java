package mx.unam.unica.tienda2.fragments;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

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
        registerForContextMenu(lstProductos);
        return v;
    }

    @Override
    public void onCreateContextMenu(@NonNull ContextMenu menu, @NonNull View v, @Nullable ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater= getActivity().getMenuInflater();
        inflater.inflate(R.menu.menu_contextual_archivos,menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        AdapterView.AdapterContextMenuInfo info= (AdapterView.AdapterContextMenuInfo)item.getMenuInfo();


        switch (item.getItemId()   )
        {
            case R.id.menContCargar:
                Toast.makeText(getContext(),"Cargando",Toast.LENGTH_SHORT).show();
                break;
            case R.id.menContSalvar:
                Toast.makeText(getContext(),"Salvando",Toast.LENGTH_SHORT).show();
                break;
        }

        return super.onContextItemSelected(item);
    }

    private void RellenarLista() {
        ArrayAdapter miAdapter = new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1, productos );
        lstProductos.setAdapter(miAdapter);
    }

    private void RellenarProductos() {
        productos= getResources().getStringArray(R.array.string_productos);
    }



}
