import java.util.Scanner;

public class MainListaDinamica {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ListaDinamica listaDinamica = new ListaDinamica();

        System.out.println("---MENU DE ACESSO---");
        int op;
        do{
            System.out.println("\n1- Adicionar produto\n2- Remover produto\n3- Exibir Produtos\n4- Sair do menu");
            op = sc.nextInt();
            listaDinamica.menuDeAcesso(op);
        }while (op != 4);

        sc.close();
    }
}
