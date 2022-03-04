package mx.unam.unica.tienda2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Toast;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import mx.unam.unica.tienda2.fragments.BuscarFragment;
import mx.unam.unica.tienda2.fragments.InicioFragment;

public class MainActivity extends AppCompatActivity {

    private InicioFragment inicioFragment;
    private BuscarFragment buscarFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BottomNavigationView  btmNavigationPrincipal;
        setContentView(R.layout.activity_main);
        btmNavigationPrincipal = findViewById(R.id.btmNavigationPrincipal);
        btmNavigationPrincipal.setOnItemSelectedListener(navListener);
        inicioFragment = new InicioFragment();
        buscarFragment = new BuscarFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContenedor,inicioFragment).commit();
    }



    @SuppressLint("NonConstantResourceId")
    NavigationBarView.OnItemSelectedListener navListener = item -> {
        switch ( item.getItemId() )
        {
            case R.id.nav_home:
                //Toast.makeText(getApplicationContext(),"Inicio",Toast.LENGTH_SHORT).show();
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContenedor,inicioFragment).commit();
                break;
            case R.id.nav_buscar:
                //Toast.makeText(getApplicationContext(),"Buscar",Toast.LENGTH_SHORT).show();
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContenedor,buscarFragment).commit();
                break;
        }

        return true;
    };

}