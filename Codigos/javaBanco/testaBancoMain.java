package javaBanco;

public class testaBancoMain {
    public static void main(String[] args) {
        // Criando os clientes (dados pessoais)
        Cliente cliente01 = new Cliente("João Silva", "12345678901", "Engenheiro", 30);
        Cliente cliente02 = new Cliente("Maria Oliveira", "98765432100", "Médica", 28);
        Cliente cliente03 = new Cliente("Carlos Souza", "45678912300", "Professor", 35);

        // Criando contas para os clientes (com saldo inicial)
        Conta conta01 = new Conta(1001, cliente01, 500.0);
        Conta conta02 = new Conta(1002, cliente02, 1000.0);
        Conta conta03 = new Conta(1003, cliente03, 750.0);
 
        /*
        // Alterando idade do cliente
        cliente01.setIdade(31);

        // Operações bancárias
        conta01.transferir(conta02, 30);
        conta01.exibirSaldo();
        conta02.exibirSaldo();

        conta03.transferir(conta01, 50);
        conta03.exibirSaldo();
        conta01.exibirSaldo();
        */
        // Exibindo dados do cliente
        cliente01.exibirDados();
        conta01.exibirDados();
        cliente02.exibirDados();
        conta02.exibirDados();
        cliente03.exibirDados();
        conta03.exibirDados();
    
    
        Cliente.totalClientes();
}

}

