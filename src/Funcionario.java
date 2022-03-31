public class Funcionario extends Pessoa{
    private String senha;

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Funcionario(String nome, String cpf, String telefone, String genero, int idade, int matricula, String senha) {
        super(nome, cpf, telefone, genero, idade, matricula);
        this.senha = senha;
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
                '}';
    }

}
