import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner tec = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<Carro> listaCarros = new ArrayList<Carro>();
        ArrayList<Moto> listaMotos = new ArrayList<Moto>();

        menuPrincipal(listaCarros, listaMotos);
    }


    public static void menuPrincipal(ArrayList<Carro> listaCarros, ArrayList<Moto> listaMotos){
        System.out.println("--- MENU PRINCIPAL ---" +
                "\n1- Cadastrar" +
                "\n2- Listar" +
                "\n3- Editar" +
                "\n4- Remover" +
                "\n5- Encerrar");
        int opcao = tec.nextInt();

        switch (opcao){
            case 1:
                int opcaoTipo = selecionarTipo("Cadastro: ");
                switch(opcaoTipo){
                    case 1:
                        listaCarros.add(cadastrarCarro());
                        break;
                    case 2:
                        listaMotos.add(cadastrarMoto());
                }
                break;
            case 2:
                opcaoTipo = selecionarTipo("Listar: ");
                switch (opcaoTipo){
                    case 1:
                        Carro carro = new Carro();
                        for (int i =0; i<listaCarros.size();i++){
                            System.out.println(carro.toString());
                        }
                        break;
                    case 2:
                        Moto moto = new Moto();
                        for (int i = 0;i<listaMotos.size();i++){
                            System.out.println(moto.toString());
                        }

                }
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                System.exit(0);
                break;
        }

    }

    private static Automovel cadastrarAutomovel(){
        System.out.println("Informe os dados:" +
                "\nMarca: ");
        String marca = tec.next();
        System.out.println("Modelo: ");
        String modelo = tec.next();
        System.out.println("Número da placa: ");
        String numPlaca = tec.next();
        Automovel automovel = new Automovel(marca, modelo, numPlaca);
        return automovel;
    }

    private static Carro cadastrarCarro(){
        Automovel automovel = cadastrarAutomovel();

        System.out.println("Quantidade de portas: ");
        int qtdPorta = tec.nextInt();
        System.out.println("Cavalos (HP): ");
        int cavalos = tec.nextInt();
        System.out.println("Tração: ");
        String tracao = tec.next();

        Carro carro = new Carro(automovel.getMarca(), automovel.getModelo(), automovel.getNumPlaca(), qtdPorta,
                cavalos, tracao);
        return carro;
    }

    private static Moto cadastrarMoto(){
        Automovel automovel = cadastrarAutomovel();

        System.out.println("Informe a quantidade de CC: ");
        int cilindradas = tec.nextInt();
        System.out.println("Informe a quantidade de WATTS no alternador: ");
        int alternador = tec.nextInt();
        System.out.println("Informe a taxa de compressão: ");
        double  taxaCompressao = tec.nextDouble();

        Moto moto = new Moto(automovel.getMarca(), automovel.getModelo(), automovel.getNumPlaca(), cilindradas,
                alternador, taxaCompressao);
        return  moto;

    }

    private static int verificaAutomovel(ArrayList<Carro> listaCarros, ArrayList<Moto> listaMotos, int opcaoTipo){
        System.out.println("Informe a placa do veículo: ");
        String numPlaca = tec.next();
        int indice = -1;
        switch (opcaoTipo){
            case 1:
                for (int i =0; i < listaCarros.size(); i++){
                    if(listaCarros.get(i).getNumPlaca() == numPlaca){
                        return i;
                    }
                }
                break;
            case 2:
                for (int i =0; i < listaMotos.size(); i++){
                    if(listaMotos.get(i).getNumPlaca() == numPlaca){
                        return i;
                    }
                }
                break;
        }
        return -1;
    }

    private static int selecionarTipo(String opcaoMenu){
        System.out.println(opcaoMenu +
                "\n1- Carro" +
                "\n2- Moto");
        return tec.nextInt();
    }

}
