package mx.unam.unica.tienda2.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

import java.util.ArrayList;

import mx.unam.unica.tienda2.R;


//public class AdaptadorMuestraProducto extends RecyclerView.Adapter<AdaptadorMuestraProducto.ViewHolder> {
public  class AdaptadorMuestraProducto extends FirestoreRecyclerAdapter<MuestraProducto, AdaptadorMuestraProducto.ViewHolder> {


  /**
   * Create a new RecyclerView adapter that listens to a Firestore Query.  See {@link
   * FirestoreRecyclerOptions} for configuration options.
   *
   * @param options
   */
  public AdaptadorMuestraProducto(@NonNull FirestoreRecyclerOptions<MuestraProducto> options) {
    super(options);
  }

  @Override
  protected void onBindViewHolder(@NonNull ViewHolder holder, int position, @NonNull MuestraProducto producto) {
      holder.txtCvTitulo.setText( producto.getTitulo());
      holder.txtCvDescribe.setText( producto.getDescripcion());
  }

  @NonNull
  @Override
  public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View v = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.cardview_producto,parent, false);

    return new ViewHolder(v);
  }

  /*  ArrayList<MuestraProducto> productos;
    public AdaptadorMuestraProducto(ArrayList<MuestraProducto> productos)
    {
      this.productos= productos;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_producto,parent,false);    return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MuestraProducto producto= productos.get(position);
        holder.txtCvTitulo.setText(producto.getTitulo());
        holder.txtCvDescribe.setText(producto.getDescripcion());
        holder.imgCVcoleccion.setImageResource(producto.getImagen());
    }

    @Override
    public int getItemCount() {
      return productos.size();
    }
  */
  public static class ViewHolder extends RecyclerView.ViewHolder{
    TextView txtCvTitulo;
    TextView txtCvDescribe;
    ImageButton imgCVcoleccion;

    public ViewHolder(@NonNull View itemView) {
      super(itemView);
      txtCvTitulo= itemView.findViewById(R.id.txCvTitulo);
      txtCvDescribe= itemView.findViewById(R.id.txtCvDescribe);
      imgCVcoleccion= itemView.findViewById(R.id.imgbCVProducto);
    }
  }
}
