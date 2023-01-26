package com.example.controleestoque;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    Button ins; //Adicionar Item
    Button ger; //Gerenciar
    Button rel; //Relatórios

    private SQLiteDatabase bdLite;
    public ListView listViewProdutos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewProdutos = (ListView) findViewById(R.id.listViewProdutos);

//        Crindo banco de dados SQLite
        criarBancoDados();
        listarDados();

        //Trocar para tela de cadastro
        ins = findViewById(R.id.btnAddItem);
        ins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent insert = new Intent(getApplicationContext(),Inserir.class);
                startActivity(insert);
            }
        });
    }

    private void criarBancoDados() {
        try {
            bdLite = openOrCreateDatabase("estoque", MODE_PRIVATE, null);
            bdLite.execSQL("CREATE TABLE IF NOT EXISTS produto(" +
                    " id INTEGER PRIMARY KEY AUTOINCREMENT" +
                    " , nomeProduto VARCHAR(50), " +
                    " valorProduto REAL, " +
                    " qtMinima INTEGER," +
                    " qtAtual INTEGER)");
            bdLite.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void listarDados() {
        try {
            bdLite = openOrCreateDatabase("estoque", MODE_PRIVATE, null);
            Cursor meuCursor = bdLite.rawQuery("SELECT id, nomeProduto FROM estoque", null);
            ArrayList<String> linhas = new ArrayList<String>();
            ArrayAdapter meuAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
                    android.R.id.text1, linhas );
            listViewProdutos.setAdapter(meuAdapter);
            meuCursor.moveToFirst();
            while(meuCursor!=null){
                linhas.add(meuCursor.getString(1));
                meuCursor.moveToNext();
            }

            bdLite.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}