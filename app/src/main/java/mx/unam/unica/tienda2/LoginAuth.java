package mx.unam.unica.tienda2;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.firebase.ui.auth.AuthUI;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Arrays;
import java.util.List;

public class LoginAuth extends AppCompatActivity  {

    private static final int AUTH_REQUEST_CODE = 1224;
    private FirebaseAuth firebaseAuth; //Manipulará la sesión del usuario
    private FirebaseAuth.AuthStateListener listener;  //Manipulará la sesión de acuerdo al ciclo de vida
    private List<AuthUI.IdpConfig> proveedores;
    @Override
    protected void onStart() {
        super.onStart();
        firebaseAuth.addAuthStateListener(listener);
    }
    @Override
    protected void onStop() {
        if ( listener != null)
        {
            firebaseAuth.removeAuthStateListener(listener);
        }
        super.onStop();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CargarPorveedores();
        login();
    }

    private void login() {
            firebaseAuth = FirebaseAuth.getInstance(); //Solamente se ejecuta una vez en toda la aplicación

            listener = new FirebaseAuth.AuthStateListener() {
                @Override
                public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                     //Obtener al usuario registrado
                    FirebaseUser  usuario = firebaseAuth.getCurrentUser();
                    if (usuario != null)
                    {
                        Intent intMain = new Intent(getApplicationContext(),MainActivity.class );
                        startActivity(intMain);
                    }
                    else
                    {
                        startActivityForResult(
                                AuthUI.getInstance()
                        .createSignInIntentBuilder()
                        .setAvailableProviders(proveedores)
                        .build(),AUTH_REQUEST_CODE
                        );

                    }



                }
            };


    }


    private void CargarPorveedores() {
        proveedores= Arrays.asList(
          new AuthUI.IdpConfig.GoogleBuilder().build() //Agrega un botón con las rutinas necesarias para la autenticación
        );
    }
}

