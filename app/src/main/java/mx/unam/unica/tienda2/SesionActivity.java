package mx.unam.unica.tienda2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class SesionActivity extends AppCompatActivity {
    EditText edtNombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sesion);
        edtNombre= findViewById(R.id.edtNombre);

    }

    public  void onClickSplit(View v)
    {
        String texto= edtNombre.getText().toString();
        String [] datos;
        datos = texto.split("\\+");
        for( int i=0;  i< datos.length; i++)
        {
            Log.d("Cadena",datos[i]);
        }


    }
}