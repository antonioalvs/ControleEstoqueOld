package com.example.controleestoque;

import model.Produto;
//import model.No;
import model.ListaEncadeada;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Inserir extends AppCompatActivity {


    Button prx, save;
    EditText nome, valor, qtdAtual, qtdMin;
    TextView res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inserir);

        //Definindo campos e botões
        //prx = findViewById(R.id.btnProximo);
        save = findViewById(R.id.btnSalvar);
        res = findViewById(R.id.lblResult);
        ListaEncadeada le = new ListaEncadeada();
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Variáveis dos campos
                nome = findViewById(R.id.txtNome);
                valor = findViewById(R.id.txtValor);
                qtdAtual = findViewById(R.id.txtQtdAtual);
                qtdMin = findViewById(R.id.txtQtdMin);
                //Variaveis comuns
                String n; //nome
                float v; //valor
                int qta, qtm; // qtd atual e qtd minima

                //Passando valor dos campos para variáveis
                n = String.valueOf(nome.getText());
                v = Float.parseFloat(String.valueOf(valor.getText()));
                qta = Integer.parseInt(String.valueOf(qtdAtual.getText()));
                qtm = Integer.parseInt(String.valueOf(qtdMin.getText()));

                //Construindo o Produto
                Produto p = new Produto(n,v,qta,qtm);

                //Inserindo na lista de controle
                String nr = "Nome do produto: " + n + "\nValor do Produto: R$" + v +
                "\nQuantidade Mínima: " + qtm + "\nQuantidade Atual: " + qta +
                        "\n----------------------\n";
                String r = String.valueOf(res.getText());
                res.setText(r + nr);

                //Limpa campos
                limpaTela();
            }

            public void limpaTela(){
                nome.setText("");
                valor.setText("");
                qtdAtual.setText("");
                qtdMin.setText("");

            }

        });
    }

}