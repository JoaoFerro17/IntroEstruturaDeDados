public class ListaDinamica implements ListaOperacoes{
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
        if (this.inicio == null) {
            return false;
        } else {
            return this.inicio.getConteudo() != null;
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
        if (!existeInicio()) {
            System.out.println("Lista vazia!");
            return;
        }
        if (this.inicio.getConteudo().equals(elemento)) {
            this.inicio = this.inicio.getProx(); // O "segundo" vira o "primeiro"
            return;
        }
        No aux = this.inicio;
        while (aux.getProx() != null) {
            if (aux.getProx().getConteudo().equals(elemento)) {
                aux.setProx(aux.getProx().getProx());
                return;
            }
            aux = aux.getProx();
        }
        System.out.println("Elemento não encontrado.");
    }

    public boolean buscarElemento(String elemento) {
        No aux = this.inicio;
        do {
            if(aux.getConteudo().equals(elemento)) {
                System.out.println("Elemento " + elemento + " encontrado.");
                return true;
            }
            aux = aux.getProx();
        } while(aux != null);
        System.out.println("Elemento " + elemento + " não encontrado!");
        return false;
    }

    @Override
    public int removerTodas(String elemento) {
        int contador = 0;
        if (!existeInicio()) {
            return 0;
        }
        while (this.inicio != null && this.inicio.getConteudo().equals(elemento)) {
            this.inicio = this.inicio.getProx();
            contador++;
        }
        if (this.inicio == null) {
            return contador;
        }
        No aux = this.inicio;
        while (aux.getProx() != null) {
            if (aux.getProx().getConteudo().equals(elemento)) {
                aux.setProx(aux.getProx().getProx());
                contador++;
            } else {
                aux = aux.getProx();
            }
        }

        return contador;
    }

    @Override
    public int contar() {
        int contador = 0;
        No aux = this.inicio;
        while (aux != null) {
            contador++;
            aux = aux.getProx();
        }
        return contador;
    }

    @Override
    public int adicionarVarios(String[] elementos) {
        int contador = 0;
        for (String elemento : elementos) {
            adicionarElemento(elemento);
            contador++;
        }
        return contador;
    }

    @Override
    public String obter(int indice) {
        if (this.inicio == null || indice < 0){
            return null;
        }
        No aux =  this.inicio;
        int contador = 0;
        while (aux != null){
            if (contador == indice){
                return aux.getConteudo();
            }
            aux = aux.getProx();
            contador++;
        }
        return null;
    }

    @Override
    public boolean inserir(int indice, String elemento) {
        int contador = 0;
        No aux =  this.inicio;
        if (indice == 0){
            No novoNo = new No(elemento);
            novoNo.setProx(this.inicio);
            this.inicio = novoNo;
            return true;
        }
        while (aux != null){
            if (contador == indice-1){
                No novoNo = new No(elemento);
                novoNo.setProx(aux.getProx());
                aux.setProx(novoNo);
                return true;
            }
            aux = aux.getProx();
            contador++;
        }
        return false;
    }

    @Override
    public String removerPorIndice(int indice) {
        String elementoRemovido;
        No aux = this.inicio;
        if (indice < 0){
            return null;
        }
        if (indice == 0){
            this.inicio = this.inicio.getProx();
            elementoRemovido = aux.getConteudo();
            return elementoRemovido;
        }
        int contador = 0;
        while (aux != null){
            if (contador == indice-1){
                elementoRemovido = aux.getProx().getConteudo();
                aux.setProx(aux.getProx().getProx());
                return elementoRemovido;
            }
            aux = aux.getProx();
            contador++;
        }
        return null;
    }
    @Override
    public void limpar() {
        this.inicio = null;
    }

    @Override
    public int ultimoIndiceDe(String elemento) {
        if (!existeInicio()){
            return -1;
        }
        No aux = this.inicio;
        int contador = 0;
        int ultimaOcorrencia = -1;
        while (aux != null){
            if (aux.getConteudo() != null && aux.getConteudo().equals(elemento)){
                ultimaOcorrencia = contador;
            }
            aux = aux.getProx();
            contador++;
        }
        return ultimaOcorrencia;
    }

    @Override
    public int contarOcorrencias(String elemento) {
        if (!existeInicio()) {
            return 0;
        }
        No aux = this.inicio;
        int contador = 0;
        while (aux != null) {
            if (aux.getConteudo() != null && aux.getConteudo().equals(elemento)) {
                contador++;
            }
            aux = aux.getProx();
        }
        return contador;
    }

    @Override
    public int substituir(String antigo, String novo) {
        if (!existeInicio()){
            return 0;
        }
        No aux = this.inicio;
        int contador = 0;
        while (aux != null){
            if (aux.getConteudo() != null && aux.getConteudo().equals(antigo)){
                aux.setConteudo(novo);
                contador++;
            }
            aux = aux.getProx();
        }
        return contador;
    }
}