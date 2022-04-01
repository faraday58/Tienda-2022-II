package mx.unam.unica.tienda2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import com.firebase.ui.auth.ui.HelperActivityBase;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler(Looper.getMainLooper()).postDelayed(
                new Runnable() {
                    @Override
                    public void run() {
                        CargarLogin();
                    }
                }
        ,3000);

    }

    private void CargarLogin() {
        Intent intent = new Intent(this, LoginAuth.class);
        startActivity(intent);
    }
}