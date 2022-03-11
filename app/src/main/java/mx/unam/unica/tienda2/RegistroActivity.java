package mx.unam.unica.tienda2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistroActivity extends AppCompatActivity {

    EditText edtUsuario;
    EditText edtPassword;
    EditText edtPasswordConfirmar;
    Button btnSalvar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        edtUsuario= findViewById(R.id.edtUsuario);
        edtPassword= findViewById(R.id.edtPassword);
        edtPasswordConfirmar= findViewById(R.id.edtPasswordConfirmar);
        btnSalvar= findViewById(R.id.btnSalvar);
        btnSalvar.setOnClickListener(onClickRegistrar);
    }


    View.OnClickListener onClickRegistrar= View ->{
        if(edtUsuario.getText().toString().equals(""))
        {
            Toast.makeText(getApplicationContext(),"Debes ingresar un usuario",Toast.LENGTH_SHORT).show();
        }
        else if(edtPassword.getText().toString().equals(edtPasswordConfirmar.getText().toString())  )
        {
            Intent intLogin= new Intent(RegistroActivity.this,SesionActivity.class  );

            SharedPreferences preferences= getSharedPreferences(getResources().getString(R.string.strCredenciales), Context.MODE_PRIVATE);
            SharedPreferences.Editor editor= preferences.edit();
            String usuario= edtUsuario.getText().toString();
            String password=edtPassword.getText().toString();

            editor.putString(getResources().getString(R.string.strUser),usuario);
            editor.putString(getResources().getString(R.string.strPassword),password);
            editor.commit();
            startActivity(intLogin);
            finish();
        }
    };


}