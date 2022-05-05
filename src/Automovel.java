public class Automovel {
    String marca, modelo, numPlaca, nomeDono="Indefinido";
    double preco;
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

    public double getPreco() { return preco; }

    public String getNomeDono() {
        return nomeDono;
    }

    public void setNomeDono(String nomeDono) {
        this.nomeDono = nomeDono;
    }

    public void setPreco(double preco) { this.preco = preco; }

    public Automovel(String marca, String modelo, String numPlaca, boolean vendido, double preco) {
        this.marca = marca;
        this.modelo = modelo;
        this.numPlaca = numPlaca;
        this.vendido = vendido;
        this.preco = preco;
    }
}
