package com.example.babuscouachou;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    EditText editTelefone, editSenha;
    Button btnEntrar;
    TextView txtCadastrar;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        // Inicializar Banco de Dados
        db = new DatabaseHelper(this);

        // Ligar variáveis aos componentes da tela
        editTelefone = findViewById(R.id.editLoginTelefone);
        editTelefone.addTextChangedListener(MascaraUtil.mask(editTelefone, "(###) #####-####"));
        editSenha = findViewById(R.id.editLoginSenha);
        btnEntrar = findViewById(R.id.btnEntrar);
        txtCadastrar = findViewById(R.id.txtIrParaCadastro);

        // Ação do Botão Entrar
        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String telefone = editTelefone.getText().toString();
                String senha = editSenha.getText().toString();

                if(telefone.equals("") || senha.equals("")) {
                    Toast.makeText(LoginActivity.this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
                } else {
                    // Verifica no SQLite
                    boolean checkUser = db.verificarLogin(telefone, senha);
                    if(checkUser) {
                        Toast.makeText(LoginActivity.this, "Login com Sucesso!", Toast.LENGTH_SHORT).show();
                        // Aqui iremos para a MainActivity (Mapa)
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish(); // Fecha a tela de login para não voltar ao apertar "voltar"
                    } else {
                        Toast.makeText(LoginActivity.this, "Telefone ou senha incorretos", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        // Ação para ir para a tela de Cadastro
        txtCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
}