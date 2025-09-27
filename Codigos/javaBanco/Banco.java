package javaBanco;

import java.util.ArrayList;

public class Banco {
    private ArrayList<Cliente> clientes = new ArrayList<>();
    private ArrayList<ContaCorrente> contasCorrentes = new ArrayList<>();
    private ArrayList<ContaPoupanca> contasPoupancas = new ArrayList<>();
    private int proximoNumeroConta = 1000;

    public int gerarNumeroConta() {
        return proximoNumeroConta++;
    }

    // Adicionar cliente e evita duplicadas.
    public void adicionarCliente(Cliente cliente) {
        for (Cliente c : clientes) {
            if (c.getCpf().equals(cliente.getCpf())) {
                System.out.println("Cliente com CPF " + cliente.getCpf() + " já existe.");
                return;
            }
        }
        this.clientes.add(cliente);
    }
    public void adicionarContaCorrente(ContaCorrente conta) {
        this.contasCorrentes.add(conta);
    }
    public void adicionarContaPoupanca(ContaPoupanca conta) {
        this.contasPoupancas.add(conta);
    }
public Cliente buscarClientePorCPF(String cpf) {
    for (Cliente cliente : clientes) {
        if (cliente.getCpf().equals(cpf)) {
            return cliente;
        }
    }
    return null;
}
    
public Conta buscarContaPorNumero(int numero) {
    for (ContaCorrente conta : contasCorrentes) {
        if (conta.getNumeroConta() == numero) {
            return conta;
        }
    }
    for (ContaPoupanca conta : contasPoupancas) {
        if (conta.getNumeroConta() == numero) {
            return conta;
        }
    }
    return null;
}

    public ContaCorrente buscarContaCorrentePorNumero(int numero) {
        for (ContaCorrente conta : contasCorrentes) {
            if (conta.getNumeroConta() == numero) {
                return conta;
            }
        }
        return null;
    }

    public ContaPoupanca buscarContaPoupancaPorNumero(int numero) {
        for (ContaPoupanca conta : contasPoupancas) {
            if (conta.getNumeroConta() == numero) {
                return conta;
            }
        }
        return null; // não achou
    }
    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public ArrayList<ContaCorrente> getContasCorrentes() {
        return contasCorrentes;
    }
    public ArrayList<ContaPoupanca> getContasPoupancas() {
        return contasPoupancas;
    }
}