public class Main {
    public static void main(String[] args) {
        ListaSimples listaSimples = new ListaSimples(5);
        listaSimples.exibirElementos();
        listaSimples.adicionarElemento("Arroz");
        listaSimples.adicionarElemento("Feijão");
        listaSimples.adicionarElemento("Batata");
        listaSimples.adicionarElemento("Arroz2");
        listaSimples.adicionarElemento("Feijão2");
        //listaSimples.removerElemento("Batata");
        listaSimples.quantidadeElementos();
        listaSimples.exibirElementos();
    }
}