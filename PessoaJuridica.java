public class PessoaJuridica extends Cliente {
    private String cnpj;
    public String setCnpj;

    public PessoaJuridica(String cnpj) {
        super();
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}
