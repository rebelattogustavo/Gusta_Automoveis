public class Automovel {
    String marca, modelo, numPlaca;

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


    public Automovel(String marca, String modelo, String numPlaca) {
        this.marca = marca;
        this.modelo = modelo;
        this.numPlaca = numPlaca;
    }
}
