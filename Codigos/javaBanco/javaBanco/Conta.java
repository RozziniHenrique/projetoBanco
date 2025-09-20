package javaBanco;

public class Conta {
    private int numeroConta;
    private Cliente cliente;
    private double saldo;

    // Construtor

    public Conta(){}
    
    public Conta(int numeroConta, Cliente cliente, double saldoInicial) {
        this.numeroConta = numeroConta;
        this.cliente = cliente;
        this.saldo = saldoInicial;
    }

    // Getters e Setters
    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor de depósito deve ser positivo.");
        }
        saldo += valor;
        System.out.println("Depósito de R$" + valor + " realizado com sucesso.");
    }

    public void sacar(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor de saque deve ser positivo.");
        }
        if (valor > saldo) {
            throw new IllegalArgumentException("Saldo insuficiente para saque.");
        }
        saldo -= valor;
        System.out.println("Saque de R$" + valor + " realizado com sucesso.");
    }

    public void transferir(Conta destino, double valor) {
        if (destino == null) {
            throw new IllegalArgumentException("Conta de destino inválida.");
        }
        this.sacar(valor);
        destino.depositar(valor);
        System.out.println("Transferência de R$" + valor + " para a conta " + destino.getNumeroConta() + " realizada com sucesso.");
    }

    public void exibirSaldo() {
        System.out.println("Saldo da conta " + numeroConta + ": R$" + saldo);
    }
}