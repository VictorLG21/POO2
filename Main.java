import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class main {
    public static void main(String[] args) {
        List<Cliente> cliente = new ArrayList<>();
        List<Reserva> reserva = new ArrayList<>();
        int opcao = 0;
        int contador = 0;
        Scanner teclado = new Scanner(System.in);

        do {
            gerarMenu();
            String x = teclado.nextLine();
            opcao = Integer.parseInt(x);
            if (opcao == 0) {
                System.out.println("Apenas números são válidos");
            } else if (opcao < 1 || opcao > 6) {
                System.out.println("Opção invalida");

            } else {
                switch (opcao) {
                case 1:
                    reservar(cliente, reserva, contador);
                    break;

                case 2:
                    pesquisar(reserva);
                    break;

                case 3:
                    imprimirReservas();
                    break;

                case 4:
                    imprimirEspera();
                    break;

                case 5:
                    cancelarReserva(reserva);
                    break;

                }
            }

        } while (opcao != 6);
        teclado.close();
    }

    private static void reservar(List<Cliente> cliente, List<Reserva> reserva, int contador) {
    }

    private static void pesquisar(List<Reserva> reserva) {
    }

    private static void imprimirReservas() {
    }

    private static void imprimirEspera() {
    }

    private static void cancelarReserva(List<Reserva> reserva) {
    }

    public static void gerarMenu() {
        String aux = "Escolha uma opção\n";
        aux += "1. Reservar mesa\n";
        aux += "2. Pesquisar reserva\n";
        aux += "3. Imprimir reservas\n";
        aux += "4. Imprimir lista de espera\n";
        aux += "5. Cancelar reserva\n";
        aux += "6. Finalizar\n";
        System.out.println(aux);
    }
}