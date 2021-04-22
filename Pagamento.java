public interface Pagamento {
    public static double calcularPagamento(boolean pagamentoAVista) {
        double valor = 3200.00;
        if (pagamentoAVista == true) {
            valor = valor * 0.9;
            return valor;
        } else {
            return valor;
        }
    }
}
