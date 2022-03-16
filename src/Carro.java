public class Carro extends Automovel{
    int qtdPorta, cavalos;
    String tracao;

    public Carro() {
        super();
    }


    public int getQtdPorta() {
        return qtdPorta;
    }

    public void setQtdPorta(int qtdPorta) {
        this.qtdPorta = qtdPorta;
    }

    public int getCavalos() {
        return cavalos;
    }

    public void setCavalos(int cavalos) {
        this.cavalos = cavalos;
    }

    public String getTracao() {
        return tracao;
    }

    public void setTracao(String tracao) {
        this.tracao = tracao;
    }

    public Carro(String marca, String modelo, String numPlaca, int qtdPorta, int cavalos, String tracao) {
        super(marca, modelo, numPlaca);
        this.cavalos = cavalos;
        this.qtdPorta = qtdPorta;
        this.tracao = tracao;
    }


    @Override
    public String toString() {
        return "Carro{" +
                "marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", numPlaca='" + numPlaca + '\'' +
                ", qtdPorta=" + qtdPorta +
                ", cavalos=" + cavalos +
                ", tracao='" + tracao + '\'' +
                '}';
    }
}
