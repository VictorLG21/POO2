public abstract class Cliente {
    private String nome;

    public Cliente() {

    }

  

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Nome -> " + nome ;
    }
}
