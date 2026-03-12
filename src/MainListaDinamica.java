public class MainListaDinamica {
    public static void main(String[] args) {
        System.out.println("=== TESTE DA LISTA DINÂMICA ===");
        ListaDinamica lista = new ListaDinamica();

        //Adicionar um e adicionar vários elementos
        lista.adicionarElemento("Pão");
        lista.adicionarVarios(new String[]{"Leite", "Pão", "Café"});
        lista.exibirElementos();
        System.out.println("----------------------------------------------------\n");

        //Contagem e Ocorrências
        System.out.println("Total de elementos: " + lista.contar());
        System.out.println("Quantidade de 'Pão': " + lista.contarOcorrencias("Pão"));
        System.out.println("Último índice de 'Pão': " + lista.ultimoIndiceDe("Pão"));
        System.out.println("----------------------------------------------------\n");

        //Inserção por Índice
        lista.inserir(0, "Açúcar");
        lista.inserir(2, "Manteiga");
        lista.exibirElementos();
        System.out.println("----------------------------------------------------\n");

        //Busca e Obter
        System.out.println("Elemento no índice 3: " + lista.obter(3));
        lista.buscarElemento("Pao");
        System.out.println("----------------------------------------------------\n");

        //Substituição
        int trocas = lista.substituir("Café", "Iogurte");
        System.out.println("Trocas feitas: " + trocas);
        lista.exibirElementos();
        System.out.println("----------------------------------------------------\n");

        //Remoção Individual e por Índice
        lista.removerElemento("Cafe");
        String removido = lista.removerPorIndice(1);
        System.out.println("Removido por índice: " + removido);
        lista.exibirElementos();
        System.out.println("----------------------------------------------------\n");

        //removerTodas
        lista.adicionarElemento("Iogurte");
        lista.exibirElementos();
        int qtdRemovida = lista.removerTodas("Iogurte");
        System.out.println("Foram removidos: " + qtdRemovida);
        lista.exibirElementos();
        System.out.println("----------------------------------------------------\n");

        //Limpar
        lista.limpar();
        System.out.println("Contagem final: " + lista.contar());
        lista.exibirElementos();
    }
}