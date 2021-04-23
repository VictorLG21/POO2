import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class main {
    public static void main(String[] args) {
        List<Reserva> reserva = new ArrayList<>();
        int opcao = 0;
        int contador = 1;
        Scanner teclado = new Scanner(System.in);

        do {
            gerarMenu();
            String x = teclado.nextLine();

            if (x.length() > 1) {
                System.out.println("Apenas 1 digito!");

            } else if (x.matches("^[0-9]*$")) {
                opcao = Integer.parseInt(x);

            } else {
                System.out.println("Apenas números são válidos!");
            }
            if (opcao < 1 || opcao > 6) {
                System.out.println("Opção invalida!");

            } else {

                switch (opcao) {
                case 1:
                    if (contador <= 6) {
                        reserva.add(reservar());
                        contador++;
                    } else {

                        System.out.println("Você será colocado na lista de espera");
                        reserva.add(reservar());
                        contador++;

                    }

                    break;

                case 2:
                    pesquisar(reserva);
                    break;

                case 3:
                    imprimirReservas(reserva);
                    break;

                case 4:
                    imprimirEspera(reserva);
                    break;

                case 5:
                    int i = cancelarReserva(reserva);
                    if (i >= 0) {
                        reserva.remove(i);
                        contador--;
                    }

                    break;

                }
            }

        } while (opcao != 6);
        teclado.close();

    }

    private static Reserva reservar() {
        Scanner teclado = new Scanner(System.in);
        Reserva aux = new Reserva();
        System.out.println("1.Pessoa Física \n 2.Pessoa Jurídica");
        int op = teclado.nextInt();
        Cliente cliente = null;
        switch (op) {
        case 1:
            cliente = cadastrarPf();
            break;
        case 2:
            cliente = cadastrarPj();
        }
        System.out.println("Informe seu nome");
        String nome = teclado.next();
        cliente.setNome(nome);
        aux.setCliente(cliente);
        int opc;

        do {
            System.out.println("Pagamento será a vista?\n 1.Sim \n2.Não");
            opc = teclado.nextInt();

            if (opc != 1 && opc != 2) {
                System.out.println("Opção inválida");
            } else {
                switch (opc) {
                case 1:
                    aux.setPagamentoAVista(true);
                    break;
                case 2:
                    aux.setPagamentoAVista(false);
                    break;
                }

            }
        } while (opc != 1 && opc != 2);

        return aux;
    }

    private static Cliente cadastrarPj() {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Informe seu cnpj");
        String cnpj = teclado.nextLine();

        PessoaJuridica aux = new PessoaJuridica("");
        aux.setCnpj(cnpj);
        return aux;
    }

    private static Cliente cadastrarPf() {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Informe seu cpf");
        String cpf = teclado.nextLine();

        PessoaFisica aux = new PessoaFisica("");
        aux.setCpf(cpf);
        return aux;
    }

    private static void pesquisar(List<Reserva> reserva) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Informe o cpf ou o cnpj a ser buscado");
        String busca = teclado.nextLine();
        boolean valida = false;
        Cliente cliente = null;

        for (int i = 0; i < reserva.size(); i++) {

            if (reserva.get(i).getCliente() instanceof PessoaFisica) {
                cliente = reserva.get(i).getCliente();
                PessoaFisica pf = (PessoaFisica) cliente;
                if (pf.getCpf().equals(busca)) {
                    System.out.println(reserva.get(i) + " Possui uma reserva");
                    valida = true;
                }
            } else if (reserva.get(i).getCliente() instanceof PessoaJuridica) {
                cliente = reserva.get(i).getCliente();
                PessoaJuridica pj = (PessoaJuridica) cliente;
                if (pj.getCnpj().equals(busca)) {
                    System.out.println(reserva.get(i) + " Possui uma reserva");
                    valida = true;
                }
            } else if (valida == false) {
                System.out.println("Cpf/Cnpj informado não possui reserva!");
            }

        }

    }

    private static void imprimirReservas(List<Reserva> reserva) {
        System.out.println("---Lista de Reservas---");
        if (reserva.size() < 6) {
            for (int i = 0; i < reserva.size(); i++) {
                System.out.println(reserva.get(i));

            }
        } else {
            for (int i = 0; i < 6; i++) {
                System.out.println(reserva.get(i));
            }
        }
    }

    private static void imprimirEspera(List<Reserva> reserva) {
        System.out.println("---Lista de Espera---");
        int contador = 1;
        for (int i = 6; i < reserva.size(); i++) {
            System.out.println(contador + "." + reserva.get(i));
            contador++;
        }
    }

    private static int cancelarReserva(List<Reserva> reserva) {
        int x = -58;
        Scanner teclado = new Scanner(System.in);
        System.out.println("Informe o cpf ou o cnpj a ser cancelado");
        String busca = teclado.nextLine();
        boolean valida = false;
        for (int i = 0; i < reserva.size(); i++) {
            if (reserva.get(i).getCliente() instanceof PessoaFisica) {
                PessoaFisica pf = (PessoaFisica) reserva.get(i).getCliente();
                if (pf.getCpf().equals(busca)) {
                    System.out.println("Reserva de: " + reserva.get(i) + " Será cancelado");
                    x = i;
                    valida = true;
                }
            } else if (reserva.get(i).getCliente() instanceof PessoaJuridica) {
                PessoaJuridica pj = (PessoaJuridica) reserva.get(i).getCliente();
                if (pj.getCnpj().equals(busca)) {
                    System.out.println("Reserva de: " + reserva.get(i) + " Será cancelado");
                    x = i;
                    valida = true;
                }
            } else if (valida == false) {
                System.out.println("Cpf/Cnpj informado não possui reserva!");
            }

        }

        return x;
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