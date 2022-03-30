public class Automovel {
    String marca, modelo, numPlaca;
    boolean vendido = false;

    public Automovel() {

    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getNumPlaca() {
        return numPlaca;
    }

    public void setNumPlaca(String numPlaca) {
        this.numPlaca = numPlaca;
    }

    public boolean getVendido() {
        return vendido;
    }

    public void setVendido(boolean vendido) {
        this.vendido = vendido;
    }

    public Automovel(String marca, String modelo, String numPlaca, boolean vendido) {
        this.marca = marca;
        this.modelo = modelo;
        this.numPlaca = numPlaca;
        this.vendido = vendido;

    }
}
