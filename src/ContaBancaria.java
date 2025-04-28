public class ContaBancaria {
    private String titular;
    private int numeroConta;
    private double saldo;

    public ContaBancaria (String titular, int numeroConta, double saldoInicial) {
        this.titular = titular;
        this.numeroConta = numeroConta;
        this.saldo = saldoInicial;
    }

    public String getTitular() {
        return titular;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double valor){
        if (valor > 0){
            saldo += valor;
            System.out.println("Deposito de R$" + valor + " realizado com sucesso!");
        } else {
            System.out.println("Valor iválido para deposito.");
        }
    }

    public void sacar(double valor){
        if (valor > 0 && saldo >= valor){
            saldo -= valor;
            System.out.println("Saque de R$" + valor + "realizado com sucesso!");
        } else {
            System.out.println("Saldo insulficiente ou valor iválido para saldo");
        }
    }

    public void transferir(ContaBancaria destino, double valor){
        if (valor > 0 && saldo >= valor){
            saldo -= valor;
            destino.depositar(valor);
            System.out.println("Transferência de R$" + valor + " para " + destino.getTitular() + " realzada com sucesso");
        } else {
            System.out.println("Saldo insuficiente ou valor inválido para transferência.");
        }
    }

    public void  exibirInformacoes(){
        System.out.println("Titular: " + titular);
        System.out.println("Numero da Conta: " + numeroConta);
        System.out.println("Saldo: R$" + saldo);
    }
}
