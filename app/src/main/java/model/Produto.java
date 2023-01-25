package model;

import java.util.Locale;

public class Produto {

    //Vars
    private int codigo;
    private String nomeProduto;
    private float valorProduto;
    private int qtdAtual;
    private int qtdMinima;

    //Construtor
    public Produto(String nomeProduto, float valorProduto, int qtdAtual, int qtdMinima){
        this.codigo = 0;
        this.nomeProduto = nomeProduto;
        this.valorProduto = valorProduto;
        this.qtdAtual = qtdAtual;
        this.qtdMinima = qtdMinima;
    }


    //Getters and Setters

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public float getValorProduto() {
        return valorProduto;
    }

    public void setValorProduto(float valorProduto) {
        this.valorProduto = valorProduto;
    }

    public int getQtdAtual() {
        return qtdAtual;
    }

    public void setQtdAtual(int qtdAtual) {
        this.qtdAtual = qtdAtual;
    }

    public int getQtdMinima() {
        return qtdMinima;
    }

    public void setQtdMinima(int qtdMinima) {
        this.qtdMinima = qtdMinima;
    }

}
