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
        return "---Cliente---\n" + cliente + ", " + cliente.getClass() + ", " + pagamentoAVista;
    }
}
