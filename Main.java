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
                        int op;
                        do {
                            System.out.println(
                                    "Você será colocado na lista de espera. Deseja continuar? \n 1.Sim \n2.Não");
                            op = teclado.nextInt();
                            switch (op) {
                            case 1:
                                reserva.add(reservar());
                                contador++;
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
                    imprimirReservas(reserva);
                    break;

                case 4:
                    imprimirEspera(reserva);
                    break;

                case 5:
                    int i = cancelarReserva(reserva);
                    if (i >= 0) {
                        reserva.remove(i);
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
        teclado.close();
        return aux;
    }

    private static Cliente cadastrarPj() {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Informe seu cnpj");
        String cnpj = teclado.nextLine();
        System.out.println("Informe seu nome");
        String nome = teclado.nextLine();
        PessoaJuridica aux = new PessoaJuridica(cnpj);
        aux.setNome(nome);
        teclado.close();
        return aux;
    }

    private static Cliente cadastrarPf() {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Informe seu cpf");
        String cpf = teclado.nextLine();
        System.out.println("Informe seu nome");
        String nome = teclado.nextLine();
        PessoaFisica aux = new PessoaFisica(cpf);
        aux.setNome(nome);
        teclado.close();
        return aux;
    }

    private static void pesquisar(List<Reserva> reserva) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Informe o cpf ou o cnpj a ser buscado");
        String busca = teclado.nextLine();
        boolean valida = false;
        for (int i = 0; i < reserva.size(); i++) {
            if (reserva.get(i).getCliente() instanceof PessoaFisica) {
                PessoaFisica pf = (PessoaFisica) reserva;
                if (pf.getCpf().equals(busca)) {
                    System.out.println(reserva.get(i) + "" + pf + " Possui uma reserva");
                    valida = true;
                }
            } else if (reserva.get(i).getCliente() instanceof PessoaJuridica) {
                PessoaJuridica pj = (PessoaJuridica) reserva;
                if (pj.getCnpj().equals(busca)) {
                    System.out.println(reserva.get(i) + "" + pj + " Possui uma reserva");
                    valida = true;
                }
            } else if (!valida) {
                System.out.println("Cpf/Cnpj informado não possui reserva!");
            }

        }

        teclado.close();
    }

    private static void imprimirReservas(List<Reserva> reserva) {
        System.out.println("---Lista de Reservas---");
        for (int i = 0; i < 6; i++) {
            System.out.println(reserva.get(i));
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
        System.out.println("Informe o cpf ou o cnpj a ser buscado");
        String busca = teclado.nextLine();
        boolean valida = false;
        for (int i = 0; i < reserva.size(); i++) {
            if (reserva.get(i).getCliente() instanceof PessoaFisica) {
                PessoaFisica pf = (PessoaFisica) reserva;
                if (pf.getCpf().equals(busca)) {
                    System.out.println(reserva.get(i) + "\nSerá removido");
                    x = i;
                    valida = true;
                }
            } else if (reserva.get(i).getCliente() instanceof PessoaJuridica) {
                PessoaJuridica pj = (PessoaJuridica) reserva;
                if (pj.getCnpj().equals(busca)) {
                    System.out.println(reserva.get(i) + "\nSerá removido");
                    x = i;
                    valida = true;
                }
            } else if (valida == false) {
                System.out.println("Cpf/Cnpj informado não possui reserva!");
            }

        }

        teclado.close();
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