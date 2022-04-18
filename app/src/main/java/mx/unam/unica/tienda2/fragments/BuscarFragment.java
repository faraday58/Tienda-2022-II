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

import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

import java.util.ArrayList;

import mx.unam.unica.tienda2.R;
import mx.unam.unica.tienda2.recyclerview.AdaptadorMuestraProducto;
import mx.unam.unica.tienda2.recyclerview.MuestraProducto;

public class BuscarFragment extends Fragment {

    private RecyclerView rcvProductos;
    private AdaptadorMuestraProducto mAdapter;
    private FirebaseFirestore mFirestore;
 //   private ArrayList<MuestraProducto> productos;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_buscar,container,false);
        rcvProductos= v.findViewById(R.id.rcvProductos);
        mFirestore= FirebaseFirestore.getInstance();

        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rcvProductos.setLayoutManager(llm);
//        InicializarProductos();
        InicializarAdaptador();

           return v;

    }

    private void InicializarAdaptador() {
        mAdapter= new AdaptadorMuestraProducto(Consulta(),getContext());
        mAdapter.notifyDataSetChanged();
        rcvProductos.setAdapter(mAdapter);
    }

    private FirestoreRecyclerOptions Consulta()
    {

        //La consulta se realiza en esta sección
        Query query = mFirestore.collection("Producto").whereEqualTo("descripcion","En familia o en el trabajo");
        FirestoreRecyclerOptions<MuestraProducto> firestoreRecyclerOptions = new FirestoreRecyclerOptions.Builder<MuestraProducto>()
                .setQuery(query,MuestraProducto.class).build();
        return firestoreRecyclerOptions;
    }

    @Override
    public void onStart() {
        super.onStart();
        mAdapter.startListening(); //Para recargar el rcv cada que seleccionamos el fragment
    }

    /*
    Antes de utilizar una base de datos remota
    private void InicializarProductos(){
        productos= new ArrayList<>();
        productos.add(new MuestraProducto("Estrena",R.drawable.tenisblancos,"Justo"));
        productos.add(new MuestraProducto("Discreto",R.drawable.teniscasual,"Momento oportuno"));
        productos.add(new MuestraProducto("Casuales",R.drawable.zapatos,"En familia o el trabajo"));
    }
 */

}
