public class Moto extends Automovel{
    int cilindradas, alternador;
    double taxaCompressao;

    public Moto() {
        super();
    }



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

    public Moto(String marca, String modelo, String numPlaca, boolean vendido, double preco, int cilindradas, int alternador, double taxaCompressao) {
        super(marca, modelo, numPlaca, vendido, preco);
        this.cilindradas = cilindradas;
        this.alternador = alternador;
        this.taxaCompressao = taxaCompressao;
    }

    @Override
    public String toString() {
        return "Moto{" +
                "marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", numPlaca='" + numPlaca + '\'' +
                ", cilindradas=" + cilindradas +
                ", alternador=" + alternador +
                ", taxaCompressao=" + taxaCompressao +
                '}';
    }
}
