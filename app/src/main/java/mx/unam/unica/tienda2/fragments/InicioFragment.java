package mx.unam.unica.tienda2.fragments;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
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
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import mx.unam.unica.tienda2.R;

public class InicioFragment extends Fragment {

    private static final String FILE_NAME = "archivoSelect.txt" ;
    private ListView lstProductos;
    private String [] productos;
    private String prodSelect;
    private AppCompatTextView actvSeleccionado;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_inicio,container,false);
        lstProductos=v.findViewById(R.id.lstProductos);
        actvSeleccionado = v.findViewById(R.id.actvSeleccionado);
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
        prodSelect= lstProductos.getItemAtPosition(info.position).toString();

        switch (item.getItemId()   )
        {
            case R.id.menContCargar:
                Toast.makeText(getContext(),"Cargando",Toast.LENGTH_SHORT).show();
                Cargar();
                break;
            case R.id.menContSalvar:
                Salvar();
                Toast.makeText(getContext(),"Salvando",Toast.LENGTH_SHORT).show();
                break;
        }

        return super.onContextItemSelected(item);
    }

    private void Cargar() {
        FileInputStream fis= null;

        try {
            fis=getActivity().openFileInput(FILE_NAME);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br= new BufferedReader(isr);
            StringBuilder sb= new StringBuilder();
            String texto;
            while ((texto=br.readLine())!= null)
            {
                sb.append(texto).append("\n");
            }
            actvSeleccionado.setText(sb.toString());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void Salvar() {
        FileOutputStream fos= null;

        try {
            fos= getActivity().openFileOutput(FILE_NAME, Context.MODE_PRIVATE);
            fos.write(prodSelect.getBytes());
            Toast.makeText(getContext(),"Selección guardada",Toast.LENGTH_SHORT).show();
            Log.d("Ruta del archivo", getActivity().getFilesDir() + "/" +FILE_NAME);
           } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {

            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


    private void RellenarLista() {
        ArrayAdapter miAdapter = new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1, productos );
        lstProductos.setAdapter(miAdapter);
    }

    private void RellenarProductos() {
        productos= getResources().getStringArray(R.array.string_productos);
    }



}
