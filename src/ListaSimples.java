public class ListaSimples implements ListaOperacoes {
    String[] lista;

    public ListaSimples(int tamanho) {
        this.lista = new String[tamanho];
    }

    public void exibirElementos() {
        for (int i = 0; i < this.lista.length; i++) {
            System.out.println("Lista[" + i + "] = " + this.lista[i]);
        }
    }

    public void adicionarElemento(String elemento) {
        if (!estaCheia()) {
            this.lista[encontrarPosicaoVazia()] = elemento;
            System.out.println("Elemento " + elemento + " adicionado com sucesso!");
        }
    }

    private boolean estaCheia() {
        for (int i = 0; i < this.lista.length; i++) {
            if (this.lista[i] == null) {
                return false;
            }
        }
        System.out.println("A lista está cheia!");
        return true;
    }

    private boolean estaVazio() {
        for (int i = 0; i < this.lista.length; i++) {
            if (this.lista[i] != null) {
                return false;
            }
        }
        System.out.println("A lista está vazia!");
        return true;
    }

    private int encontrarPosicaoVazia() {
        int i;
        for (i = 0; i < this.lista.length; i++) {
            if (this.lista[i] == null) {
                return i;
            }
        }
        return i;
    }

    public void removerElemento(String elemento) {
        if (!estaVazio()) {
            if (this.buscarElemento(elemento) >= 0) {
                this.lista[this.buscarElemento(elemento)] = null;
                System.out.println("Elemento " + elemento + " removido com sucesso!");
            }
        }
    }

    public int buscarElemento(String elemento){
        int i;
        if (!estaVazio()) {
            for (i = 0; i < this.lista.length; i++) {
                if (this.lista[i].equals(elemento)) {
                    return i;
                }
            }
        }
        System.out.println("Elemento não encontrado na lista.");
        return -1;
    }

    public void alterarElemento(String elementoASerAlterado, String alteracao) {
        if(buscarElemento(elementoASerAlterado) >= 0) {
            this.lista[buscarElemento(elementoASerAlterado)] = alteracao;
            System.out.println("Elemento " + elementoASerAlterado + " alterado com sucesso para " + alteracao);
        }
    }

    public void quantidadeElementos() {
        int cont = 0;
        if(!estaVazio()) {
            for (int i = 0; i < this.lista.length; i++) {
                if(this.lista[i] != null) {
                    cont++;
                }
            }
        }
        System.out.println("A lista possui " + cont + " elementos!");
    }

    @Override
    public int removerTodas(String elemento) {
        int contador = 0;
        if (!estaVazio()){
            for (int i = 0; i < this.lista.length; i++) {
                if (this.lista[i] != null && this.lista[i].equals(elemento)) {
                    this.lista[i] = null;
                    contador++;
                }
            }
        }
        return contador;
    }

    @Override
    public int contar() {
        int contador = 0;
        if(!estaVazio()) {
            for (int i = 0; i < this.lista.length; i++) {
                if(this.lista[i] != null) {
                    contador++;
                }
            }
        }
        return contador;
    }

    @Override
    public int adicionarVarios(String[] elementos) {
        int contador = 0;
        for (String elem : elementos) {
            if (!estaCheia()) {
            this.lista[encontrarPosicaoVazia()] = elem;
            contador++;
            }else {
                System.out.println("A lista está cheia.");
                break;
            }
        }
        return contador;
    }

    @Override
    public String obter(int indice) {
        if (!estaVazio()) {
            if (indice < 0 || indice > this.lista.length) {
                System.out.println("Índice inexistente");
            } else {
                return "Índice: " + indice + " - Elemento: " + this.lista[indice];
            }
        }
        return null;
    }

    @Override
    public boolean inserir(int indice, String elemento) {
        if (!estaCheia()){
            if (indice < 0 || indice >= this.lista.length) {
                System.out.println("Índice inválido.");
                return false;
            }
            String valorParaInserir = elemento;
            for (int i = indice; i < this.lista.length; i++) {
                String aux = this.lista[i];
                this.lista[i] = valorParaInserir;
                valorParaInserir = aux;
                if (valorParaInserir == null) {
                    break;
                }
            }
        }
        return true;
    }

    @Override
    public String removerPorIndice(int indice) {
        if (indice < 0 || indice >= this.lista.length) {
            System.out.println("Índice inválido.");
            return null;
        }
        String elementoRemovido = this.lista[indice];
        int i;
        for (i = indice; i < this.lista.length-1; i++) {
            this.lista[i] = this.lista[i + 1];
        }
        this.lista[i] = null;
        return elementoRemovido;
    }

    @Override
    public void limpar() {
        for (int i = 0; i < this.lista.length; i++){
            this.lista[i] = null;
        }
    }

    @Override
    public int ultimoIndiceDe(String elemento) {
        if (estaVazio()){
            System.out.println("Lista vazia.");
        }else {
            for (int i = this.lista.length-1; i >= 0; i--) {
                if (this.lista[i] != null && this.lista[i].equals(elemento)) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public int contarOcorrencias(String elemento) {
        int contador = 0;
            for (int i = 0; i < this.lista.length; i++) {
                if (this.lista[i] != null && this.lista[i].equals(elemento)) {
                    contador++;
                }
            }
        return contador;
    }

    @Override
    public int substituir(String antigo, String novo) {
        int contador = 0;
        if (estaVazio()){
            System.out.println("Lista vazia.");
        }
        if(buscarElemento(antigo) >= 0) {
            for (int i = 0; i < this.lista.length; i++) {
                // Checa se não é nulo e se é o que queremos trocar
                if (this.lista[i] != null && this.lista[i].equals(antigo)) {
                    this.lista[i] = novo; // Troca direto no índice atual
                    contador++;
                }
            }
         }
        return contador;
    }
}