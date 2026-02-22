import java.util.Scanner;

public class ListaDinamica {
    No inicio;

    public ListaDinamica() {
        this.inicio = new No(null);
        System.out.println("Lista Dinâmica criada com sucesso!");
    }

    public void adicionarElemento(String conteudo) {
        if(!this.existeInicio()) {
            this.inicio.setConteudo(conteudo);
        } else {
            No novoNo = new No(conteudo);
            No aux = this.inicio;
            while(aux.getProx() != null) {
                aux = aux.getProx();
            }
            aux.setProx(novoNo);
        }
    }

    private boolean existeInicio() {
        if(this.inicio.getConteudo() == null) {
            return false;
        } else {
            return true;
        }
    }

    public void exibirElementos() {
        if(existeInicio()) {
            No aux = this.inicio;
            while(aux != null) {
                System.out.println(aux.getConteudo());
                aux = aux.getProx();
            }
        } else {
            System.out.println("Não existem elementos na Lista Dinâmica.");
        }
    }

    public void removerElemento(String elemento) {
        if(existeInicio()) {
            //verificar existência
                //removendo primeiro
                if(this.inicio.getProx() != null) {
                    this.inicio = this.inicio.getProx();
                } else {
                    this.inicio.setConteudo(null);
                }
        } else {
            System.out.println("Não existem elementos na lista.");
        }
    }

    public void menuDeAcesso(int op){
        Scanner sc = new Scanner(System.in);
        String elemento;
        switch (op){
            case 1:
                System.out.print("Informe o nome do produto a ser adicionado: ");
                elemento =  sc.nextLine();
                adicionarElemento(elemento);
                break;
            case 2:
                System.out.print("Informe o nome do produto a ser removido: ");
                elemento =  sc.nextLine();
                removerElemento(elemento);
                break;
            case 3:
                System.out.println("Lista: ");
                exibirElementos();
                break;
            case 4:
                System.out.println("Programa finalizado");
                break;
            default:
                System.out.println("Opção inválida. Digite uma opção válida.");
        }
    }
}
