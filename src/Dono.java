public class Dono extends Funcionario{

    private double salario = 30000.00;

    public Dono(String nome, String cpf, String telefone, String genero, int idade, int matricula, String senha) {
        super(nome, cpf, telefone, genero, idade, matricula, senha);
    }

    @Override
    public double getSalario() {
        return salario;
    }

    @Override
    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public void mudarSalario(double precoAuto){
        this.setSalario(this.getSalario());
    }

}
