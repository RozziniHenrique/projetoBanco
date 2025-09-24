package javaBanco;

public class testaBancoMain {
    public static void main(String[] args) {
        Banco banco = new Banco();
        //Criando Clientes
        Cliente cliente1 = new Cliente("Alice Martins", "12345678900","Engenheira", 30);
        Cliente cliente2 = new Cliente("Bob Fernandes", "98765432100", "Professor", 45);
        
        //Adicionando Clientes ao Banco
        banco.adicionarCliente(cliente1);
        banco.adicionarCliente(cliente2);

        //Criando Contas
        ContaPoupanca contaPoupanca1 = new ContaPoupanca(2001, cliente2, 3000.0, 0.05);
        ContaCorrente conta1 = new ContaCorrente(1001, cliente1, 5000.0, 1000.0);

        //Adicionando Contas ao Banco
        banco.adicionarContaPoupanca(contaPoupanca1);
        banco.adicionarContaCorrente(conta1);

        //Exibindo Clientes
        System.out.println("Clientes no Banco:");
        for (Cliente cliente : banco.getClientes()) {
            cliente.exibirDados();
        }

        banco.buscarContaPorNumero(1001);
        banco.buscarClientePorCPF("12345678900");

        banco.getClientes();
}

}

