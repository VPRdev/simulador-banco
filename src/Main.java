import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Banco banco = new Banco();

        while (true) {
            System.out.println("### SIMULADOR DE BANCO ###");
            System.out.println("1. Criar Conta");
            System.out.println("2. Depositar");
            System.out.println("3. Sacar");
            System.out.println("4. Transferir");
            System.out.println("5. Listar Contas");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Nome do titular: ");
                    String titular = scanner.nextLine();
                    System.out.print("Número da conta: ");
                    int numeroConta = scanner.nextInt();
                    System.out.print("Saldo inicial: ");
                    double saldoInicial = scanner.nextDouble();

                    ContaBancaria novaConta = new ContaBancaria(titular, numeroConta, saldoInicial);
                    banco.adicionarConta(novaConta);
                    System.out.println("Conta criada com sucesso!");
                    break;

                case 2:
                    System.out.print("Número da conta para depósito: ");
                    int numeroDeposito = scanner.nextInt();
                    ContaBancaria contaDeposito = banco.buscarConta(numeroDeposito);

                    if (contaDeposito != null) {
                        System.out.print("Valor para depositar: ");
                        double valorDeposito = scanner.nextDouble();
                        contaDeposito.depositar(valorDeposito);
                    } else {
                        System.out.println("Conta não encontrada.");
                    }
                    break;

                case 3:
                    System.out.print("Número da conta para saque: ");
                    int numeroSaque = scanner.nextInt();
                    ContaBancaria contaSaque = banco.buscarConta(numeroSaque);

                    if (contaSaque != null) {
                        System.out.print("Valor para sacar: ");
                        double valorSaque = scanner.nextDouble();
                        contaSaque.sacar(valorSaque);
                    } else {
                        System.out.println("Conta não encontrada.");
                    }
                    break;

                case 4:
                    System.out.print("Número da conta de origem: ");
                    int numeroOrigem = scanner.nextInt();
                    ContaBancaria contaOrigem = banco.buscarConta(numeroOrigem);

                    System.out.print("Número da conta de destino: ");
                    int numeroDestino = scanner.nextInt();
                    ContaBancaria contaDestino = banco.buscarConta(numeroDestino);

                    if (contaOrigem != null && contaDestino != null) {
                        System.out.print("Valor para transferir: ");
                        double valorTransferencia = scanner.nextDouble();
                        contaOrigem.transferir(contaDestino, valorTransferencia);
                    } else {
                        System.out.println("Conta de origem ou destino não encontrada.");
                    }
                    break;

                case 5:
                    banco.listarContas();
                    break;

                case 6:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção inválida, tente novamente.");
            }
        }
    }
}
