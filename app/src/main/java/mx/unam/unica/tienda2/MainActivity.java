package mx.unam.unica.tienda2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import mx.unam.unica.tienda2.fragments.BuscarFragment;
import mx.unam.unica.tienda2.fragments.ComprarFragment;
import mx.unam.unica.tienda2.fragments.InicioFragment;
import mx.unam.unica.tienda2.fragments.SesionFragment;

public class MainActivity extends AppCompatActivity {
    //region Objetos fragment
    private InicioFragment inicioFragment;
    private BuscarFragment buscarFragment;
    private ComprarFragment comprarFragment;
    private SesionFragment sesionFragment;
    //endregion
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView btmNavigationPrincipal;
        btmNavigationPrincipal= findViewById(R.id.btmNavigationPrincipal);
        btmNavigationPrincipal.setOnItemSelectedListener(navListener);
        inicioFragment= new InicioFragment();
        buscarFragment= new BuscarFragment();
        comprarFragment = new ComprarFragment();
        sesionFragment = new SesionFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContenedor,inicioFragment).commit();
    }

    NavigationBarView.OnItemSelectedListener navListener = new NavigationBarView.OnItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId())
            {
                case R.id.nav_home:
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContenedor,inicioFragment).commit();
                    Toast.makeText(getApplicationContext(),"Inicio",Toast.LENGTH_SHORT).show();
                    break;
                case R.id.nav_buscar:
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContenedor,buscarFragment).commit();
                    Toast.makeText(getApplicationContext(),"Buscar",Toast.LENGTH_SHORT).show();
                    break;
                case R.id.nav_menu_comprar:
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContenedor,comprarFragment).commit();
                    Toast.makeText(getApplicationContext(),"Comprar",Toast.LENGTH_SHORT).show();
                    break;
                case R.id.nav_menu_iniciar:
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContenedor,sesionFragment).commit();
                    Toast.makeText(getApplicationContext(),"Sesión",Toast.LENGTH_SHORT).show();
                    break;
            }

            return true;
        }
    };

}