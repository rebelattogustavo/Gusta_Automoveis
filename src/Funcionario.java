public class Funcionario extends Pessoa{
    private String senha;
    private double salario = 1250.00;

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public double getSalario() { return salario; }

    public void setSalario(double salario) { this.salario = salario; }

    public Funcionario(String nome, String cpf, String telefone, String genero, int idade, int matricula, String senha) {
        super(nome, cpf, telefone, genero, idade, matricula);
        this.senha = senha;
    }

    public void mudarSalario(double preco){
        this.salario += preco * 0.02;
    }

    public void mudarSalario(double preco, double por){
        this.salario += preco * por;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome: '" + getNome() + '\'' +
                ", cpf: '" + getCpf() + '\'' +
                ", telefone: '" + getTelefone() + '\'' +
                ", genero: '" + getGenero() + '\'' +
                ", idade: " + getIdade() +
                ", matricula: " + getMatricula() +
                ", senha: " + senha +
                ", salario: " + salario +
                '}';
    }

}
