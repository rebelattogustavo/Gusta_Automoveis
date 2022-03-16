public class Moto extends Automovel{
    int cilindradas, alternador;
    double taxaCompressao;

    public int getCilindradas() {
        return cilindradas;
    }

    public void setCilindradas(int cilindradas) {
        this.cilindradas = cilindradas;
    }

    public int getAlternador() {
        return alternador;
    }

    public void setAlternador(int alternador) {
        this.alternador = alternador;
    }

    public double getTaxaCopressao() {
        return taxaCompressao;
    }

    public void setTaxaCopressao(double taxaCopressao) {
        this.taxaCompressao = taxaCopressao;
    }

    public Moto(String marca, String modelo, String numPlaca, int cilindradas, int alternador, double taxaCompressao) {
        super(marca, modelo, numPlaca);
        this.cilindradas = cilindradas;
        this.alternador = alternador;
        this.taxaCompressao = taxaCompressao;
    }
}
