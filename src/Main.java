public class Main {
    public static void main(String[] args) {
        System.out.println("=== TESTE DA LISTA SIMPLES ===");
        ListaSimples lista = new ListaSimples(5);

        //Adicionar um elemento
        lista.adicionarElemento("Ana");
        lista.adicionarElemento("Carlos");
        lista.exibirElementos();
        System.out.println("----------------------------------------------------\n");

        //Adicionar vários
        String[] nomesParaAdicionar = {"Ana", "Pedro"};
        int qtdAdicionada = lista.adicionarVarios(nomesParaAdicionar);
        System.out.println("Foram adicionados " + qtdAdicionada + " elementos.");
        lista.exibirElementos();
        System.out.println("----------------------------------------------------\n");

        //Contagem e Ocorrências
        System.out.println("Total de elementos válidos: " + lista.contar());
        System.out.println("Quantas vezes 'Ana' aparece: " + lista.contarOcorrencias("Ana"));
        System.out.println("Último índice de 'Ana': " + lista.ultimoIndiceDe("Ana"));
        System.out.println("----------------------------------------------------\n");

        //Inserção
        lista.inserir(1, "Zeca");
        lista.exibirElementos();
        System.out.println("----------------------------------------------------\n");

        //Substituição
        int trocas = lista.substituir("Ana", "Beatriz");
        System.out.println("Trocas realizadas: " + trocas);
        lista.exibirElementos();
        System.out.println("----------------------------------------------------\n");

        //Obter
        System.out.println(lista.obter(3));
        System.out.println("----------------------------------------------------\n");

        //Remoção por Índice
        String removido = lista.removerPorIndice(2);
        System.out.println("Resultado: " + removido);
        lista.exibirElementos();
        System.out.println("----------------------------------------------------\n");

        //Remover Todas
        int totalRemovidos = lista.removerTodas("Beatriz");
        System.out.println("Total de elementos removidos: " + totalRemovidos);
        lista.exibirElementos();
        System.out.println("----------------------------------------------------\n");

        //Limpar tudo
        lista.limpar();
        lista.exibirElementos();
    }
}