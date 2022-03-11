package mx.unam.unica.tienda2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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
        cargarPreferencias();

    }

    private void cargarPreferencias()
    {
    SharedPreferences preferences = getSharedPreferences(getResources().getString(R.string.strCredenciales),Context.MODE_PRIVATE);
    SharedPreferences.Editor editor= preferences.edit();

    String user = preferences.getString(getResources().getString(R.string.strUser),getResources().getString(R.string.strNoUsuarios));
    String password= preferences.getString(getResources().getString(R.string.strPassword),"");
    edtNombre.setText(user);
    edtPassword.setText(password);

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

        if (!password.equals(""))
        {
            return false;
        }
        else if ( usuario.equals(getResources().getString(R.string.strUser)) && password.equals(getResources().getString(R.string.strPassword))  )
        {
            return true;
        }
        else
        {
            return  false;
        }

    }


}