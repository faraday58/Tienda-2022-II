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
import android.widget.TextView;
import android.widget.Toast;

public class SesionActivity extends AppCompatActivity {
    private EditText edtNombre;
    private EditText edtPassword;
    private TextView txtvRegistrar;
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
        txtvRegistrar= findViewById(R.id.txtvRegistrar);
        txtvRegistrar.setOnClickListener(onClickRegistrar);
        cargarPreferencias();
        if (Valida())
        {
            Intent intMain = new Intent(SesionActivity.this,MainActivity.class );
            startActivity(intMain);
        }

    }

    View.OnClickListener onClickRegistrar = view ->
    {
            Intent intentRegistrar= new Intent(this,RegistroActivity.class);
            startActivity(intentRegistrar);
    };

    private void cargarPreferencias()
    {
    SharedPreferences preferences = getSharedPreferences(getResources().getString(R.string.strCredenciales),Context.MODE_PRIVATE);
    SharedPreferences.Editor editor= preferences.edit();

    String user = preferences.getString(getResources().getString(R.string.strUser),getResources().getString(R.string.strNoUsuarios));
    String password= preferences.getString(getResources().getString(R.string.strPassword),"");
    edtNombre.setText(user);
    edtPassword.setText(password);

    }


    View.OnClickListener onClickEntrar = view -> {
        if (Valida())
        {
            Intent intMain = new Intent(SesionActivity.this,MainActivity.class );
            startActivity(intMain);
        }
        else
        {
            Toast.makeText(getApplicationContext(),"Usuario o contraseña incorrecta",Toast.LENGTH_LONG).show();
            Log.d("Login","Usuario o contraseña incorrecta " );
        }

    };


    private boolean Valida()
    {
        SharedPreferences preferences = getSharedPreferences(getResources().getString(R.string.strCredenciales),Context.MODE_PRIVATE);
        SharedPreferences.Editor editor= preferences.edit();
        String user = preferences.getString(getResources().getString(R.string.strUser),getResources().getString(R.string.strNoUsuarios));
        String passw= preferences.getString(getResources().getString(R.string.strPassword),"");


        try {
            usuario=edtNombre.getText().toString();
            password= edtPassword.getText().toString();
            Log.d("User","Usuario: "+ user + " " + usuario);
            Log.d("Pass","Password: "+passw +" " + password);
        }
        catch (Exception error)
        {
            Log.d("Login","Error en los dados: "+error.toString() );
        }

        if (password.equals(""))
        {
            return false;
        }
        else if ( usuario.equals(user) && password.equals(passw) )
        {
            return true;
        }
        else
        {
            return  false;
        }

    }


}