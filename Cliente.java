package javaBanco;

public class Cliente{
    private int id_cliente;
    private String nome;
    private String cpf;
    private String profissao;
    private int idade;
    private double saldo;

public Cliente(int id_cliente, String nome, String cpf, String profissao, int idade, double saldo) {
    this.id_cliente = id_cliente;
    this.nome = nome;
    this.cpf = cpf;
    this.profissao = profissao;
    this.idade = idade;
    this.saldo = saldo;
}


    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
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
        if (idade <= 0){
            System.out.println("Idade inválida");
        }else{
        this.idade = idade;
        }
    }
    public void exibirSaldo(){
        System.out.println("Saldo atual: R$" + saldo);
    }

public void depositarSaldo(double valor){
    if (valor > 0){
    saldo += valor;
        System.out.println("Depósito de R$" + valor + " realizado com sucesso.");
    } else {
        System.out.println("Valor de depósito inválido.");
    }
}

public void sacarSaldo(double valor){
    if (valor > 0 && valor <= saldo){
        saldo -= valor;
        System.out.println("Saque de R$" + valor + " realizado com sucesso.");
    } else {
        System.out.println("Valor de saque inválido ou saldo insuficiente.");
    }
    
}
}