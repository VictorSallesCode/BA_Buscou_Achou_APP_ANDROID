package com.example.babuscouachou;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton; // Importante
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1. Configurar o Botão Sair
        ImageButton btnSair = findViewById(R.id.btnSairApp);

        btnSair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // --- ADICIONE ESTA LINHA PARA TESTAR ---
                android.widget.Toast.makeText(MainActivity.this, "Clicou no Sair", android.widget.Toast.LENGTH_SHORT).show();

                fazerLogout();
            }
        });

        // 2. Configurar Navegação Inferior
        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        // Carregar Fragmento Inicial
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new MapFragment()).commit();
        }
    }

    // Método de Logout (Seguro)
    private void fazerLogout() {
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        // Limpa o histórico para o usuário não conseguir voltar com o botão "Voltar" do celular
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }

    // Listener das Abas
    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;
                    int itemId = item.getItemId();

                    if (itemId == R.id.nav_map) {
                        selectedFragment = new MapFragment();
                    } else if (itemId == R.id.nav_checkin) {
                        selectedFragment = new CheckInFragment();
                    } else if (itemId == R.id.nav_ranking) {
                        selectedFragment = new RankingFragment();
                    }

                    if (selectedFragment != null) {
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                                selectedFragment).commit();
                    }
                    return true;
                }
            };
}