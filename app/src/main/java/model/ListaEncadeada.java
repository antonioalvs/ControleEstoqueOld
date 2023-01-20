package model;


public class ListaEncadeada {

    //Vars
    private No primeiro;
    private No ultimo;
    private int quantidade;

    public ListaEncadeada() { // Garante que a lista iniciará vazia
        this.primeiro=null;
        this.ultimo=null;
        this.quantidade=0;
    }

    //Getters and Setters
    public No getPrimeiro() {
        return primeiro;
    }

    public void setPrimeiro(No primeiro) {
        this.primeiro = primeiro;
    }

    public No getUltimo() {
        return ultimo;
    }

    public void setUltimo(No ultimo) {
        this.ultimo = ultimo;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
