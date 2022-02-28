package mx.unam.unica.tienda2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SesionActivity extends AppCompatActivity {
    private EditText edtNombre;
    private EditText edtPassword;
    private Button btnEntrar;
    private String usuario="";
    private String password="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sesion);
        edtNombre= findViewById(R.id.edtNombre);
        edtPassword = findViewById(R.id.edtPassword);
        btnEntrar = findViewById(R.id.btnEntrar);
        btnEntrar.setOnClickListener(onClickEntrar);

    }


    View.OnClickListener onClickEntrar = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (Valida())
            {
                Intent intMain = new Intent(SesionActivity.this,MainActivity.class );
                startActivity(intMain);
            }
            else
            {
                Toast.makeText(getApplicationContext(),"Usuario o contraseña incorrecta",Toast.LENGTH_LONG).show();
            }

        }
    };


    private boolean Valida()
    {
        try {
            usuario=edtNombre.getText().toString();
            password= edtPassword.getText().toString();
        }
        catch (Exception error)
        {
            Log.d("Login","Error en los dados: "+error.toString() );
        }

        if ( usuario.equals("armando") && password.equals("armando")  )
        {
            return true;
        }
        else
        {
            return  false;
        }

    }


}