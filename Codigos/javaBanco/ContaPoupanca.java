package javaBanco;

public class ContaPoupanca extends Conta {
    private double taxaJuros;


    public ContaPoupanca(Cliente cliente, double saldo, double taxaJuros) {
        super(cliente, saldo);
        this.taxaJuros = taxaJuros;
    }


    public double getTaxaJuros() {
        return taxaJuros;
    }

    public void setTaxaJuros(double taxaJuros) {
        this.taxaJuros = taxaJuros;
    }

    public void aplicarRendimento() {
        double rendimento = getSaldo() * taxaJuros / 100;
        depositar(rendimento);
        System.out.println("Rendimento de R$" + rendimento + " aplicado com sucesso.");
    }
    
}
