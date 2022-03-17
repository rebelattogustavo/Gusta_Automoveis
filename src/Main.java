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
                        menuPrincipal(listaCarros, listaMotos);
                        break;
                    case 2:
                        listaMotos.add(cadastrarMoto());
                        menuPrincipal(listaCarros, listaMotos);
                        break;
                    case 3:
                        menuPrincipal(listaCarros,listaMotos);
                        break;
                }
                break;
            case 2:
                opcaoTipo = selecionarTipo("Listar: ");
                switch (opcaoTipo){
                    case 1:
                        for (Carro carro : listaCarros){
                            System.out.println(carro.toString());
                        }
                        menuPrincipal(listaCarros, listaMotos);
                        break;
                    case 2:
                        for (Moto moto : listaMotos){
                            System.out.println(moto.toString());
                        }
                        menuPrincipal(listaCarros, listaMotos);
                        break;
                    case 3:
                        menuPrincipal(listaCarros,listaMotos);
                        break;
                }
                break;
            case 3:
                opcaoTipo = selecionarTipo("Editar");
                int indice = verificaAutomovel(listaCarros,listaMotos,opcaoTipo);
                if(verificaAutomovel(listaCarros,listaMotos,opcaoTipo) == -1){
                    System.out.println("Placa não encontrada!");
                    menuPrincipal(listaCarros,listaMotos);
                }
                int editar = selecionarEditar("Informe o que deseja editar: ");
                switch (opcaoTipo){
                    case 1:
                        switch (editar){
                            case 1:
                                listaCarros.set(indice,cadastrarCarro());
                                menuPrincipal(listaCarros,listaMotos);
                                break;
                            case 2:
                                editarAtributo(indice, listaCarros, listaMotos, opcaoTipo);
                                menuPrincipal(listaCarros,listaMotos);
                                break;
                        }
                        break;
                    case 2:
                        switch (editar){
                            case 1:
                                listaMotos.set(indice, cadastrarMoto());
                                menuPrincipal(listaCarros,listaMotos);
                                break;
                            case 2:
                                editarAtributo(indice,listaCarros,listaMotos,opcaoTipo);
                                menuPrincipal(listaCarros,listaMotos);
                                break;
                        }
                        break;
                    case 3:
                        menuPrincipal(listaCarros,listaMotos);
                        break;
                }
                menuPrincipal(listaCarros,listaMotos);
                break;
            case 4:
                opcaoTipo = selecionarTipo("Remover: ");
                indice = verificaAutomovel(listaCarros,listaMotos,opcaoTipo);
                if(verificaAutomovel(listaCarros,listaMotos,opcaoTipo) == -1){
                    System.out.println("Placa não encontrada!");
                    menuPrincipal(listaCarros,listaMotos);
                }else{
                excluirCarro(listaCarros,listaMotos,opcaoTipo,indice);
                menuPrincipal(listaCarros,listaMotos);
                }
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
        switch (opcaoTipo){
            case 1:
                for (int i =0; i < listaCarros.size(); i++){
                    if(listaCarros.get(i).getNumPlaca().equals(numPlaca)){
                        return i;
                    }else{
                        return -1;
                    }
                }
                break;
            case 2:
                for (int i =0; i < listaMotos.size(); i++){
                    if(listaMotos.get(i).getNumPlaca().equals(numPlaca)){
                        return i;
                    }else{
                        return -1;
                    }
                }
                break;
            case 3:
                menuPrincipal(listaCarros,listaMotos);
                break;
        }
        return -1;
    }

    private static int selecionarEditar(String opcaoMenu){
        System.out.println(opcaoMenu +
                "\n1- Tudo" +
                "\n2- Um atributo");
        return tec.nextInt();
    }

    private static void editarAtributo(int indice,ArrayList<Carro> listaCarros,ArrayList<Moto> listaMotos,int opcaoTipo){
        switch (opcaoTipo){
            case 1:
                System.out.println("Informe o que deseja editar: " +
                        "\n1- Marca" +
                        "\n2- Modelo" +
                        "\n3- Número da placa" +
                        "\n4- Quantidade de portas" +
                        "\n5- Cavalos" +
                        "\n6- Tração");
                int opcao = tec.nextInt();
                switch (opcao){
                    case 1:
                        System.out.print("Informe a nova marca: ");
                        listaCarros.get(indice).setMarca(tec.next());
                        break;
                    case 2:
                        System.out.print("Informe o novo modelo: ");
                        listaCarros.get(indice).setModelo(tec.next());
                        break;
                    case 3:
                        System.out.print("Informe a nova placa: ");
                        listaCarros.get(indice).setNumPlaca(tec.next());
                        break;
                    case 4:
                        System.out.print("Informe a nova quantidade de portas: ");
                        listaCarros.get(indice).setQtdPorta(tec.nextInt());
                        break;
                    case 5:
                        System.out.print("Informe a nova quantidade de cavalos(HP): ");
                        listaCarros.get(indice).setCavalos(tec.nextInt());
                        break;
                    case 6:
                        System.out.println("Informe a nova tração: ");
                        listaCarros.get(indice).setTracao(tec.next());
                        break;
                }
                break;
            case 2:
                System.out.println("Informe o que deseja editar: " +
                        "\n1- Marca" +
                        "\n2- Modelo" +
                        "\n3- Número da placa" +
                        "\n4- Cilindradas" +
                        "\n5- Alternador" +
                        "\n6- Taxa de compressão");
                opcao = tec.nextInt();
                switch (opcao){
                    case 1:
                        System.out.print("Informe a nova marca: ");
                        listaMotos.get(indice).setMarca(tec.next());
                        break;
                    case 2:
                        System.out.print("Informe o novo modelo: ");
                        listaMotos.get(indice).setModelo(tec.next());
                        break;
                    case 3:
                        System.out.print("Informe a nova placa: ");
                        listaMotos.get(indice).setNumPlaca(tec.next());
                        break;
                    case 4:
                        System.out.print("Informe a nova quantidade de cilindradas: ");
                        listaMotos.get(indice).setCilindradas(tec.nextInt());
                        break;
                    case 5:
                        System.out.print("Informe a nova medida do alternador: ");
                        listaMotos.get(indice).setAlternador(tec.nextInt());
                        break;
                    case 6:
                        System.out.print("Informe a nova taxa de compressão: ");
                        listaMotos.get(indice).setTaxaCopressao(tec.nextInt());
                        break;
                }
                break;
        }
    }

    private static void excluirCarro(ArrayList<Carro> listaCarros,ArrayList<Moto> listaMotos,int opcaoTipo,int indice){
        System.out.println("Realmente deseja excluir esse veículo?");
        char resposta = tec.next().charAt(0);
        if(resposta == 's' || resposta == 'S'){
            switch (opcaoTipo){
                case 1:
                    listaCarros.remove(indice);
                    break;
                case 2:
                    listaMotos.remove(indice);
                    break;
                case 3:
                    menuPrincipal(listaCarros,listaMotos);
                    break;
            }
        }else{
            menuPrincipal(listaCarros,listaMotos);
        }

    }

    private static int selecionarTipo(String opcaoMenu){
        System.out.println(opcaoMenu +
                "\n1- Carro" +
                "\n2- Moto" +
                "\n3- Voltar");
        return tec.nextInt();
    }
}