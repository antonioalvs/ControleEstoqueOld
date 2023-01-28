package com.example.controleestoque.bd;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

import com.example.controleestoque.model.Produto;

public class Sqlite extends SQLiteOpenHelper {

    private static final int VERSAO_BANCO = 1;
    private static final String BANCO_PRODUTOS = "bd_produtos";

    private static final String TABELA_PRODUTOS = "td_produtos";
    private static final String COLUNA_CODIGO = "bd_produtos";
    private static final String COLUNA_NOME_PROD = "bd_produtos";
    private static final String COLUNA_VALOR_PROD = "bd_produtos";
    private static final String COLUNA_QTD_ATUAL = "bd_produtos";
    private static final String COLUNA_QTD_MINIMA = "bd_produtos";
    public Sqlite(@Nullable Context context) {
        super(context, BANCO_PRODUTOS, null, VERSAO_BANCO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String QUERY_COLUNA = "CREATE TABLE " + TABELA_PRODUTOS + "("
                + COLUNA_CODIGO + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUNA_NOME_PROD + " TEXT, "
                + COLUNA_VALOR_PROD + " TEXT, " + COLUNA_QTD_ATUAL + " INTEGER, " + COLUNA_QTD_MINIMA + " INTEGER)";
        db.execSQL(QUERY_COLUNA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void addProduto(Produto produto) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUNA_NOME_PROD, produto.getNomeProduto());
        values.put(COLUNA_VALOR_PROD, produto.getValorProduto());
        values.put(COLUNA_QTD_ATUAL, produto.getQtdAtual());
        values.put(COLUNA_QTD_MINIMA, produto.getQtdMinima());

        db.insert(TABELA_PRODUTOS, null, values);
        db.close();
    }

    void apagarProduto(Produto produto) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABELA_PRODUTOS, COLUNA_CODIGO + " = ?", new String[] { String.valueOf(produto.getCodigo())});
        db.close();
    }

    public Produto selecionaProduto(int codigo) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABELA_PRODUTOS, new String[]{COLUNA_CODIGO, COLUNA_NOME_PROD, COLUNA_VALOR_PROD, COLUNA_QTD_ATUAL, COLUNA_QTD_MINIMA}, COLUNA_CODIGO + " = ?",
                new String[]{String.valueOf(codigo)}, null, null, null, null);

        if (cursor != null) {
            cursor.moveToFirst();
        }

        Produto produto = new Produto(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), Float.parseFloat(cursor.getString(2)),
                Integer.parseInt(cursor.getString(3)), Integer.parseInt(cursor.getString(4)));
        return produto;
    }
}
