package javaBanco;

import java.util.Scanner;

public class Main{
    public static void main (String[] args){
        Scanner scanner = new Scanner(System.in);
        Banco banco = new Banco();
        //Criando Clientes
        Cliente cliente1 = new Cliente("Alice Martins", "12345678900","Engenheira", 30);
        Cliente cliente2 = new Cliente("Bob Fernandes", "98765432100", "Professor", 45);
        Cliente cliente3 = new Cliente("Carlos Silva", "11122233344", "Médico", 38);

        //Adicionando Clientes ao Banco
        banco.adicionarCliente(cliente1);
        banco.adicionarCliente(cliente2);
        banco.adicionarCliente(cliente3);

        //Criando Contas
        ContaCorrente contaCorrente1 = new ContaCorrente(cliente1, 5000.0, 1000.0);
        ContaPoupanca contaPoupanca1 = new ContaPoupanca(cliente2, 3000.0, 0.05);
        ContaCorrente contaCorrente2 = new ContaCorrente(cliente3, 7000.0, 1500.0);

        //Adicionando Contas ao Banco
        banco.adicionarContaCorrente(contaCorrente1);
        banco.adicionarContaPoupanca(contaPoupanca1);
        banco.adicionarContaCorrente(contaCorrente2);

        //Menu interativo
        int opcao;
        do {
            System.out.println("\n Menu do Banco:");
            System.out.println("0. Sair");
            System.out.println("1. Criar cliente");
            System.out.println("2. Exibir clientes");
            System.out.println("3  Criar conta");
            System.out.println("4. Exibir contas correntes");
            System.out.println("5. Exibir contas poupança");
            System.out.println("6. Exibir todas as contas");
            System.out.println("7. Buscar cliente por CPF");
            System.out.println("8. Sacar dinheiro");
            System.out.println("9. Depositar dinheiro");
            
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao){
                case 1:
                    System.out.println("Digite o nome do cliente:");
                    String nome = scanner.nextLine();
                    if(nome == null || nome.isBlank()){
                        System.out.println("Nome inválido. Cliente não criado.");
                        break;
                    }
                    System.out.println("Digite o CPF do cliente:");
                    String cpf = scanner.nextLine();
                    if(cpf == null || cpf.length() != 11){
                        System.out.println("CPF inválido. Cliente não criado.");
                        break;
                    }
                    else if (banco.buscarClientePorCPF(cpf) != null){
                        System.out.println("CPF já cadastrado. Cliente não criado.");
                        break;
                    }
                    System.out.println("Digite a profissão do cliente:");
                    String profissao = scanner.nextLine();
                    System.out.println("Digite a idade do cliente:");
                    int idade = scanner.nextInt();
                    if(idade <= 0){
                        System.out.println("Idade inválida. Cliente não criado.");
                        break;
                    }
                    Cliente novoCliente = new Cliente(nome, cpf, profissao, idade);
                    banco.adicionarCliente(novoCliente);
                    System.out.println("Cliente criado com sucesso!");
                break;
                case 2:
                    System.out.println("Clientes no Banco:");
                    for (Cliente cliente : banco.getClientes()) {
                        cliente.exibirDados();
                    }
                break;
                case 3:
                    System.out.println("Digite 1 para Conta Corrente ou 2 para Conta Poupança:");
                    int tipoConta = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Digite o CPF do cliente:");
                    String cpfConta = scanner.nextLine();
                    Cliente clienteConta = banco.buscarClientePorCPF(cpfConta);

                    if (clienteConta == null) {
                        System.out.println("Cliente não encontrado. Conta não criada.");
                        break;
                    }

                    // número da conta é sempre o código do cliente
                    int numeroConta = clienteConta.getCodigo();

                    // Validação: já existe conta desse cliente
                    if (tipoConta == 1 && banco.buscarContaCorrentePorNumero(numeroConta) != null) {
                        System.out.println("Cliente já possui conta corrente. Conta não criada.");
                        break;
                    } else if (tipoConta == 2 && banco.buscarContaPoupancaPorNumero(numeroConta) != null) {
                        System.out.println("Cliente já possui conta poupança. Conta não criada.");
                        break;
                    }

                    System.out.println("Digite o saldo inicial:");
                    double saldoInicial = scanner.nextDouble();

                    if (tipoConta == 1) {
                        System.out.println("Digite o limite da conta corrente:");
                        double limite = scanner.nextDouble();
                        ContaCorrente novaContaCorrente = new ContaCorrente(clienteConta, saldoInicial, limite);
                        banco.adicionarContaCorrente(novaContaCorrente);
                        System.out.println("Conta Corrente criada com sucesso! Número: " + numeroConta);
                    } else if (tipoConta == 2) {
                        System.out.println("Digite a taxa de rendimento (ex: 0.05 para 5%):");
                        double taxaRendimento = scanner.nextDouble();
                        ContaPoupanca novaContaPoupanca = new ContaPoupanca(clienteConta, saldoInicial, taxaRendimento);
                        banco.adicionarContaPoupanca(novaContaPoupanca);
                        System.out.println("Conta Poupança criada com sucesso! Número: " + numeroConta);
                    } else {
                        System.out.println("Tipo de conta inválido. Conta não criada.");
                    }
                    break;
                case 4:
                    System.out.println("Contas no Banco:");
                    for (Conta conta : banco.getContasCorrentes()) {
                        conta.exibirDados();
                    }
                break;
                case 5:
                    System.out.println("Contas no Banco:");
                    for (Conta conta : banco.getContasPoupancas()) {
                        conta.exibirDados();
                    }
                break;
                case 6:
                    System.out.println("Contas Correntes no Banco:");
                    for (Conta conta : banco.getContasCorrentes()) {
                        conta.exibirDados();
                    }
                    System.out.println("Contas Poupança no Banco:");
                    for (Conta conta : banco.getContasPoupancas()) {
                        conta.exibirDados();
                    }
                break;

                case 7:
                    System.out.println("Digite o CPF que deseja buscar: ");
                    String cpfBusca = scanner.nextLine();
                    Cliente clienteBuscado = banco.buscarClientePorCPF(cpfBusca);
                    if (clienteBuscado != null) {
                        clienteBuscado.exibirDados();
                    } else {
                        System.out.println("Cliente com CPF " + cpfBusca + " não encontrado.");
                    }
                break;
                case 8:
                    System.out.println("Digite o número da conta para sacar:");
                    int numeroSaque = scanner.nextInt();
                    Conta contaSaque = banco.buscarContaPorNumero(numeroSaque);
                    if (contaSaque == null) {
                        System.out.println("Conta não encontrada.");
                        break;
                    }
                    System.out.println("Digite o valor para sacar:");
                    double valorSaque = scanner.nextDouble();
                    contaSaque.sacar(valorSaque);
                    System.out.println("Saque realizado. Novo saldo: " + contaSaque.getSaldo());
                break;
                case 9:
                    System.out.println("Digite o número da conta para depositar:");
                    int numeroDeposito = scanner.nextInt();
                    Conta contaDeposito = banco.buscarContaPorNumero(numeroDeposito);
                    if (contaDeposito == null) {
                        System.out.println("Conta não encontrada.");
                        break;
                    }
                    System.out.println("Digite o valor para depositar:");
                    double valorDeposito = scanner.nextDouble();
                    contaDeposito.depositar(valorDeposito);
                    System.out.println("Depósito realizado. Novo saldo: " + contaDeposito.getSaldo());
                break;
                }
        } while (opcao != 0);
        scanner.close();
}
}