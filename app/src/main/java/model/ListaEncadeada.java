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

    //Funções

    //Verifica se a lista está vazia
    public boolean listaVazia(){ //Verifica se a lista está vazia
        return(this.primeiro==null);
    }

    //Insere o produto na lista
    public void insert(Produto p) {
        No novoNo = new No(p);  //instancia um novo nó
        if (this.listaVazia()) {
            this.ultimo = novoNo;
        }
        novoNo.setProximo(this.primeiro);
        this.primeiro=novoNo;
        this.quantidade++;



    }

    //Imprime a Lista
    public String imprimirLista(){
        String msg="", reporProd;
        int i=1;

        No atual=this.primeiro;
        while(atual!=null){
            if(atual.getProd().getQtdAtual()<atual.getProd().getQtdMinima()){
                reporProd="REPOR ESTOQUE DO PRODUTO";
            }
            else{
                reporProd="";
            }
            msg+= +i+"."+atual.getProd().getNomeProduto()+"\t |PRECO: R$"+atual.getProd().getValorProduto()+
                    "\t |QTD ATUAL: "+atual.getProd().getQtdAtual()+"\t |QTD MINIMA: "+atual.getProd().getQtdMinima()+"\t|"+reporProd+"\n";
            atual=atual.getProximo();
            i++;
        }

        return msg;
    }

    public String sqlite(){
        String msg="", reporProd;
        int i=1;

        No atual=this.primeiro;
        while(atual!=null){
            msg+= +i+"."+atual.getProd().getNomeProduto()+"\t |PRECO: R$"+atual.getProd().getValorProduto()+
                    "\t |QTD ATUAL: "+atual.getProd().getQtdAtual()+"\t |QTD MINIMA: "+atual.getProd().getQtdMinima();
            atual=atual.getProximo();
            i++;
        }

        return msg;
    }
}
