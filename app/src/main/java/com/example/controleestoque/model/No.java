package com.example.controleestoque.model;

//Classe que cria a ListaEncadeada
public class No {

    //Vars
    private Produto prod; //Agragação
    private No proximo;


    public No(Produto p) {
        this.prod = p;
        this.proximo = null;
    }

    //Getters And Setters
    public Produto getProd() {
        return prod;
    }

    public void setProd(Produto prod) {
        this.prod = prod;
    }

    public No getProximo() {
        return proximo;
    }

    public void setProximo(No proximo) {
        this.proximo = proximo;
    }
}
