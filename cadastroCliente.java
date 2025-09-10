package javaBanco;
public class cadastroCliente {
    public static void main(String[] args) {
        Cliente cliente01 = new Cliente(1, "João Silva", "123.456.789-00", "Engenheiro", 30, 1500.75);
        Cliente cliente02 = new Cliente(2, "Maria Oliveira", "987.654.321-00", "Médica", 28, 2500.00);
        Cliente cliente03 = new Cliente(3, "Carlos Souza", "456.789.123-00", "Professor", 35, 1800.50);
        
        cliente01.setIdade(31);

        cliente02.depositarSaldo(10000);
        cliente02.exibirSaldo();
        cliente02.sacarSaldo(15000);
}
}