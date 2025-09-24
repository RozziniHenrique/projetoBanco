package javaBanco;

public class ContaCorrente extends Conta {
    private double limite;

    public ContaCorrente(int numero, Cliente cliente, double saldo, double limite) {
        super(numero, cliente, saldo);
        this.limite = limite;
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    @Override
    public void sacar(double valor) {
    if (valor <= 0) {
        throw new IllegalArgumentException("Valor de saque deve ser positivo.");
    }
    if (valor > getSaldo() + limite) {
        throw new IllegalArgumentException("Saldo insuficiente para saque, considerando o limite.");
    }
    setSaldo(getSaldo() - valor);
    System.out.println("Saque de R$" + valor + " realizado com sucesso na Conta Corrente.");
}
}