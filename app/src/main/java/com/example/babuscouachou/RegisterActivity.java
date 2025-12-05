package com.example.babuscouachou;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.exemplo.babuscouachou.model.Usuario;

public class RegisterActivity extends AppCompatActivity {

    EditText editNome, editTelefone, editEmail, editSenha;
    Button btnCadastrar;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        db = new DatabaseHelper(this);

        editNome = findViewById(R.id.editNome);
        editTelefone = findViewById(R.id.editTelefone);
        editTelefone.addTextChangedListener(MascaraUtil.mask(editTelefone, "(###) #####-####"));
        editEmail = findViewById(R.id.editEmail);
        editSenha = findViewById(R.id.editSenha);
        btnCadastrar = findViewById(R.id.btnCadastrar);

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obter textos
                String nome = editNome.getText().toString();
                String telefone = editTelefone.getText().toString();
                String email = editEmail.getText().toString();
                String senha = editSenha.getText().toString();

                if(nome.equals("") || telefone.equals("") || senha.equals("")) {
                    Toast.makeText(RegisterActivity.this, "Preencha os campos obrigatórios", Toast.LENGTH_SHORT).show();
                } else {
                    // Criar objeto Usuario
                    Usuario novoUsuario = new Usuario(nome, telefone, email, senha);

                    // Salvar no Banco
                    boolean sucesso = db.adicionarUsuario(novoUsuario);

                    if(sucesso) {
                        Toast.makeText(RegisterActivity.this, "Cadastro realizado!", Toast.LENGTH_SHORT).show();
                        finish(); // Volta para o Login
                    } else {
                        Toast.makeText(RegisterActivity.this, "Erro: Telefone já cadastrado?", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}