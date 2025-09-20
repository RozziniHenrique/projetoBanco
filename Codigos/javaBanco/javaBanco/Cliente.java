package javaBanco;

public class Cliente {
    private int idCliente;
    private String nome;
    private String cpf;
    private String profissao;
    private int idade;

    // Construtor

    public Cliente (){}
    
    public Cliente(int idCliente, String nome, String cpf, String profissao, int idade) {
        this.idCliente = idCliente;
        this.nome = nome;
        this.cpf = cpf;
        this.profissao = profissao;
        setIdade(idade); // Usa o setter para validar
    }

    // Getters e Setters
    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome não pode ser vazio.");
        }
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        if (cpf == null || cpf.length() != 11) {
            throw new IllegalArgumentException("CPF inválido.");
        }
        this.cpf = cpf;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        if (idade <= 0) {
            throw new IllegalArgumentException("Idade inválida.");
        }
        this.idade = idade;
    }

    // Exibir informações do cliente
    public void exibirDados() {
        System.out.println("Cliente: " + nome + " | CPF: " + cpf + " | Profissão: " + profissao + " | Idade: " + idade);
    }
}
