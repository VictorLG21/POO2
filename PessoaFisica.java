public class PessoaFisica extends Cliente {

    private String cpf;

    public PessoaFisica(String cpf) {
        super();
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return getNome() + ", " + cpf;
    }

    public void setCpf() {
    }
}
