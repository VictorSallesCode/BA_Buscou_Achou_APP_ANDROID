package com.example.babuscouachou;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.exemplo.babuscouachou.model.Usuario;

public class DatabaseHelper extends SQLiteOpenHelper {

    // Informações do Banco
    private static final String NOME_BANCO = "babuscouachou.db";
    private static final int VERSAO_BANCO = 1;

    // Tabelas
    private static final String TABELA_USUARIOS = "usuarios";
    private static final String TABELA_AVALIACOES = "avaliacoes";

    // Colunas Usuários
    private static final String COL_ID = "id";
    private static final String COL_NOME = "nome";
    private static final String COL_TELEFONE = "telefone";
    private static final String COL_EMAIL = "email";
    private static final String COL_SENHA = "senha";

    // Comando SQL para criar tabela Usuários
    private static final String CRIAR_TABELA_USUARIOS = "CREATE TABLE " + TABELA_USUARIOS + " (" +
            COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COL_NOME + " TEXT, " +
            COL_TELEFONE + " TEXT UNIQUE, " + // Telefone único para login
            COL_EMAIL + " TEXT, " +
            COL_SENHA + " TEXT)";

    // Comando SQL para criar tabela Avaliações
    // Nota: Simplifiquei para focar na estrutura. No futuro adicionamos as foreign keys rigorosas.
    private static final String CRIAR_TABELA_AVALIACOES = "CREATE TABLE " + TABELA_AVALIACOES + " (" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "id_usuario INTEGER, " +
            "nome_local TEXT, " +
            "estrelas REAL, " +
            "comentario TEXT, " +
            "caminho_foto TEXT)";

    public DatabaseHelper(Context context) {
        super(context, NOME_BANCO, null, VERSAO_BANCO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Executa a criação das tabelas quando o app abre pela primeira vez
        db.execSQL(CRIAR_TABELA_USUARIOS);
        db.execSQL(CRIAR_TABELA_AVALIACOES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Se mudarmos a versão do banco, ele apaga e cria de novo (para desenvolvimento)
        db.execSQL("DROP TABLE IF EXISTS " + TABELA_USUARIOS);
        db.execSQL("DROP TABLE IF EXISTS " + TABELA_AVALIACOES);
        onCreate(db);
    }

    // --- MÉTODOS CRUD PARA USUÁRIO ---

    // 1. Criar Usuário (Registrar)
    public boolean adicionarUsuario(Usuario usuario) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_NOME, usuario.getNome());
        values.put(COL_TELEFONE, usuario.getTelefone());
        values.put(COL_EMAIL, usuario.getEmail());
        values.put(COL_SENHA, usuario.getSenha());

        long result = db.insert(TABELA_USUARIOS, null, values);
        return result != -1; // Retorna true se inseriu com sucesso
    }

    // 2. Verificar Login (Buscar)
    public boolean verificarLogin(String telefone, String senha) {
        SQLiteDatabase db = this.getReadableDatabase();
        // Busca onde telefone = ? E senha = ?
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABELA_USUARIOS +
                " WHERE " + COL_TELEFONE + "=? AND " + COL_SENHA + "=?", new String[]{telefone, senha});

        boolean existe = cursor.getCount() > 0;
        cursor.close();
        return existe;
    }
}