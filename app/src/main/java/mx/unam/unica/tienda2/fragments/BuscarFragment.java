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

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
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
    private FirebaseFirestore mFirestore; //Es el objeto o instancia que manipula a la base de datos
  //  private ArrayList<MuestraProducto> productos;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_buscar,container,false);
        rcvProductos= v.findViewById(R.id.rcvProductos);
        mFirestore= FirebaseFirestore.getInstance(); //Abre la conexión con la base de datos
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rcvProductos.setLayoutManager(llm);

       // InicializarProductos();
        InicializarAdaptador();

           return v;

    }

    private void InicializarAdaptador() {

        mAdapter= new AdaptadorMuestraProducto(Consulta());
        mAdapter.notifyDataSetChanged();
        rcvProductos.setAdapter(mAdapter);
      //  mAdapter= new AdaptadorMuestraProducto(productos);
       // rcvProductos.setAdapter(mAdapter);

    }
        //Método que realiza una consulta a la base de datos
    private FirestoreRecyclerOptions Consulta(){

        Query query = mFirestore.collection("Producto");
        FirestoreRecyclerOptions<MuestraProducto> firestoreRecyclerOptions = new FirestoreRecyclerOptions.Builder<MuestraProducto>()
                .setQuery(query,MuestraProducto.class).build();
        return firestoreRecyclerOptions;
    }

    @Override
    public void onStart() {
        super.onStart();
        mAdapter.startListening();
    }

    /*
    private void InicializarProductos(){
        productos= new ArrayList<>();
        productos.add(new MuestraProducto("Estrena",R.drawable.tenisblancos,"Justo"));
        productos.add(new MuestraProducto("Discreto",R.drawable.teniscasual,"Momento oportuno"));
        productos.add(new MuestraProducto("Casuales",R.drawable.zapatos,"En familia o el trabajo"));
    }*/
}
