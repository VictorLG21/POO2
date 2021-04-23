public class PessoaFisica extends Cliente {
    
    private String cpf;

    public PessoaFisica(String cpf) {
        super();
    }

    public String getCpf() {
        return cpf;
    }

    public void setNome(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return" Possui o cpf -> " + cpf;
    }
}
