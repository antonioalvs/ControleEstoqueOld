package com.example.controleestoque;

import com.example.controleestoque.bd.Sqlite;
import com.example.controleestoque.model.Produto;
//import model.No;
import com.example.controleestoque.model.ListaEncadeada;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Inserir extends AppCompatActivity {


    Button prx, save;
    EditText nome, valor, qtdAtual, qtdMin;
    TextView res;
    private SQLiteDatabase bdLite;

    Sqlite db = new Sqlite(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inserir);

        //Variáveis dos campos
        nome = findViewById(R.id.txtNome);
        valor = findViewById(R.id.txtValor);
        qtdAtual = findViewById(R.id.txtQtdAtual);
        qtdMin = findViewById(R.id.txtQtdMin);

        //Definindo campos e botões
        //prx = findViewById(R.id.btnProximo);
        save = findViewById(R.id.btnSalvar);
        res = findViewById(R.id.lblResult);
        ListaEncadeada le = new ListaEncadeada();
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Variaveis comuns
                String n; //nome
                float v; //valor
                int c = 0, qta, qtm; // qtd atual e qtd minima

                //Passando valor dos campos para variáveis
                n = String.valueOf(nome.getText());
                v = Float.parseFloat(String.valueOf(valor.getText()));
                qta = Integer.parseInt(String.valueOf(qtdAtual.getText()));
                qtm = Integer.parseInt(String.valueOf(qtdMin.getText()));

                //Construindo o Produto
                Produto p = new Produto(c,n,v,qta,qtm);

                //Inserindo na lista de controle
                String nr = "Nome do produto: " + n + "\nValor do Produto: R$" + v +
                "\nQuantidade Mínima: " + qtm + "\nQuantidade Atual: " + qta +
                        "\n----------------------\n";
                String r = String.valueOf(res.getText());
                res.setText(r + nr);

                //Cadastra produto Banco de Dados
                db.addProduto(new Produto(c, n, v, qta, qtm));

                //Limpa campos
                limpaTela();
            }

//            public void cadastrar(){
//                if(!TextUtils.isEmpty(nome.getText().toString())) {
//                    try {
//                        bdLite = openOrCreateDatabase("estoque", MODE_PRIVATE, null);
//                        String sql = "INSERT INTO estoque (nomeProduto, valorProduto, qtMinima, qtAtual) VALUES (?, ?, ?, ?)";
//                        SQLiteStatement stmt = bdLite.compileStatement(sql);
//                        stmt.bindString(1, nome.getText().toString());
//                        stmt.bindDouble(2, Double.parseDouble(String.valueOf(valor.getText())));
//                        stmt.bindString(3, qtdMin.getText().toString());
//                        stmt.bindString(4, qtdAtual.getText().toString());
//                        stmt.executeInsert();
//                        bdLite.close();
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                }
//            }

            public void limpaTela(){
                nome.setText("");
                valor.setText("");
                qtdAtual.setText("");
                qtdMin.setText("");

            }

        });
    }

}