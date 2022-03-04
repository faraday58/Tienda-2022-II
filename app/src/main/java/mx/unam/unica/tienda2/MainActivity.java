package mx.unam.unica.tienda2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView btmNavigationPrincipal;
        btmNavigationPrincipal= findViewById(R.id.btmNavigationPrincipal);
        btmNavigationPrincipal.setOnItemSelectedListener(navListener);

    }

    NavigationBarView.OnItemSelectedListener navListener = new NavigationBarView.OnItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId())
            {
                case R.id.nav_home:
                    Toast.makeText(getApplicationContext(),"Inicio",Toast.LENGTH_SHORT).show();
                    break;
                case R.id.nav_buscar:
                    Toast.makeText(getApplicationContext(),"Buscar",Toast.LENGTH_SHORT).show();
                    break;
                case R.id.nav_menu_comprar:
                    Toast.makeText(getApplicationContext(),"Comprar",Toast.LENGTH_SHORT).show();
                    break;
                case R.id.nav_menu_iniciar:
                    Toast.makeText(getApplicationContext(),"Sesión",Toast.LENGTH_SHORT).show();
                    break;
            }

            return true;
        }
    };

}