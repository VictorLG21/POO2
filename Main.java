import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class main {
    public static void main(String[] args) {
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
                    if (contador <= 6) {
                        reserva.add(reservar());
                    } else {
                        int op;
                        do {
                            System.out.println(
                                    "Você será colocado na lista de espera. Deseja continuar? \n 1.Sim \n 2.Não");
                            op = teclado.nextInt();
                            switch (op) {
                            case 1:
                                reserva.add(reservar());
                                break;
                            case 2:
                                System.out.println("Obrigado, volte sempre!");
                                break;
                            }
                        } while (op != 2);
                    }
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

    private static Reserva reservar() {
        Scanner teclado = new Scanner(System.in);
        Reserva aux = new Reserva();
        aux.setCliente(cadastrarCliente());

        int op;
        do {
            System.out.println("Pagamento será a vista? \n 1.Sim \n 2.Não");
            op = teclado.nextInt();
            if (op != 1 && op != 2) {
                System.out.println("Opção inválida");
            } else {
                switch (op) {
                case 1:
                    aux.setPagamentoAVista(true);
                    break;
                case 2:
                    aux.setPagamentoAVista(false);
                    break;
                }

            }
        } while (op != 1 && op != 2);
        teclado.close();
        return aux;
    }

    private static Cliente cadastrarCliente() {
        Cliente aux = null;
        Scanner teclado = new Scanner(System.in);
        System.out.println("1.Pessoa Física \n 2.Pessoa Jurídica");
        int op = teclado.nextInt();
        do {
            if (op != 1 && op != 2) {
                System.out.println("Opção inválida");
            } else {
                switch (op) {
                case 1:
                    aux = cadastrarPf();
                    break;
                case 2:
                    aux = cadastrarPj();
                    break;
                }

            }
        } while (op != 1 && op != 2);
        System.out.println("Informe seu nome");
        aux.setNome(teclado.nextLine());
        teclado.close();
        return aux;
    }

    private static Cliente cadastrarPj() {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Informe seu cnpj");
        String cnpj = teclado.nextLine();
        PessoaJuridica aux = new PessoaJuridica(cnpj);
        teclado.close();
        return aux;
    }

    private static Cliente cadastrarPf() {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Informe seu cpf");
        String cpf = teclado.nextLine();
        PessoaFisica aux = new PessoaFisica(cpf);
        teclado.close();
        return aux;
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