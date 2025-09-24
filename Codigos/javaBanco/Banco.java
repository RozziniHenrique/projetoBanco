package javaBanco;

import java.util.ArrayList;

public class Banco {
    ArrayList<Cliente> clientes = new ArrayList<>();
    ArrayList<ContaCorrente> contasCorrentes = new ArrayList<>();
    ArrayList<ContaPoupanca> contasPoupancas = new ArrayList<>();

    public void adicionarCliente(Cliente cliente) {
        this.clientes.add(cliente);
    }
    public void adicionarContaCorrente(ContaCorrente conta) {
        this.contasCorrentes.add(conta);
    }
    public void adicionarContaPoupanca(ContaPoupanca conta) {
        this.contasPoupancas.add(conta);
    }
    public void buscarClientePorCPF(String cpf) {
        for (Cliente cliente : clientes) {
            if (cliente.getCpf().equals(cpf)) {
                System.out.println("Cliente encontrado: " + cliente.getNome());
                return;
            }
        }
        System.out.println("Cliente com CPF " + cpf + " não encontrado.");
    }
    public void buscarContaPorNumero(int numero) {
        for (ContaCorrente conta : contasCorrentes) {
            if (conta.getNumeroConta() == numero) {
                System.out.println("Conta Corrente encontrada: " + conta.getNumeroConta() + " do cliente " + conta.getCliente().getNome());
                return;
            }
        }
        for (ContaPoupanca conta : contasPoupancas) {
            if (conta.getNumeroConta() == numero) {
                System.out.println("Conta Poupança encontrada: " + conta.getNumeroConta() + " do cliente " + conta.getCliente().getNome());
                return;
            }
        }
        System.out.println("Conta com número " + numero + " não encontrada.");
    }
    
    public ArrayList<Cliente> getClientes() {
        return clientes;
    }
}

/*5. Coleções para gerenciar clientes e contas

Crie uma classe Banco que terá listas de clientes e contas (ArrayList por exemplo).

Essa classe será responsável por cadastrar novos clientes/contas e buscar clientes/contas existentes pelo número ou CPF. */