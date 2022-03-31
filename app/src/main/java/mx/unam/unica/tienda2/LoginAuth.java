package mx.unam.unica.tienda2;

import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.firebase.ui.auth.AuthUI;

import java.util.List;

public class LoginAuth  extends AppCompatActivity {

    private List<AuthUI.IdpConfig> proveedores;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CargarProveedores();

    }

    private void CargarProveedores() {


    }
}
