public class Reserva implements Pagamento {
    private Cliente cliente;
    private boolean pagamentoAVista;

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;

    }

    public boolean getpagamentoAVista() {
        return pagamentoAVista;
    }

    public void setPagamentoAVista(boolean pagamentoAVista) {
        this.pagamentoAVista = pagamentoAVista;

    }

    @Override
    public String toString() {
        if (pagamentoAVista == true) {
            String opcao = "pagamento será a vista!";
            return cliente + ", " + cliente.getClass() + ", " + opcao;
        } else {
            String opcao = "Pagamento será parcelado!";
            return cliente + ", " + cliente.getClass() + ", " + opcao;
        }
    }
}
