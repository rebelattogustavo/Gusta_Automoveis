import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Scanner tec = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<Carro> listaCarros = new ArrayList<Carro>();
        ArrayList<Carro> listaCarrosVendidos = new ArrayList<Carro>();
        ArrayList<Moto> listaMotos = new ArrayList<Moto>();
        ArrayList<Moto> listaMotosVendidas = new ArrayList<Moto>();

        menuPrincipal(listaCarros, listaMotos,listaCarrosVendidos,listaMotosVendidas);
    }


    public static void menuPrincipal(ArrayList<Carro> listaCarros, ArrayList<Moto> listaMotos, ArrayList<Carro> listaCarrosVendidos, ArrayList<Moto> listaMotosVendidas){
        System.out.println("--- MENU PRINCIPAL ---" +
                "\n1- Cadastrar" +
                "\n2- Listar" +
                "\n3- Editar" +
                "\n4- Remover" +
                "\n5- Vender" +
                "\n6- Encerrar");
        int opcao = tec.nextInt();

        switch (opcao){
            case 1:
                int opcaoTipo = selecionarTipo("Cadastro: ");
                switch(opcaoTipo){
                    case 1:
                        listaCarros.add(cadastrarCarro());
                        menuPrincipal(listaCarros, listaMotos,listaCarrosVendidos,listaMotosVendidas);
                        break;
                    case 2:
                        listaMotos.add(cadastrarMoto());
                        menuPrincipal(listaCarros, listaMotos,listaCarrosVendidos,listaMotosVendidas);
                        break;
                    case 3:
                        menuPrincipal(listaCarros,listaMotos,listaCarrosVendidos,listaMotosVendidas);
                        break;
                }
                break;
            case 2:
                opcaoTipo = selecionarTipo("Listar: ");
                if (opcaoTipo == 3){
                    menuPrincipal(listaCarros,listaMotos,listaCarrosVendidos,listaMotosVendidas);
                }
                int listar = selecionarTipoListar("Informe o que deseja ver: ");
                switch (opcaoTipo){
                    case 1:
                        switch (listar){
                            case 1:
                                for (Carro carro : listaCarros){
                                    System.out.println(carro.toString());
                                }
                                menuPrincipal(listaCarros, listaMotos,listaCarrosVendidos,listaMotosVendidas);
                                break;
                            case 2:
                                for (Carro carro : listaCarrosVendidos){
                                    System.out.println(carro.toString());
                                }
                                menuPrincipal(listaCarros, listaMotos,listaCarrosVendidos,listaMotosVendidas);
                                break;
                        }
                        break;
                    case 2:
                        switch (listar){
                            case 1:
                                for (Moto moto : listaMotos){
                                    System.out.println(moto.toString());
                                }
                                menuPrincipal(listaCarros, listaMotos,listaCarrosVendidos,listaMotosVendidas);
                                break;
                            case 2:
                                for (Moto moto : listaMotosVendidas){
                                    System.out.println(moto.toString());
                                }
                                menuPrincipal(listaCarros, listaMotos,listaCarrosVendidos,listaMotosVendidas);
                                break;
                        }
                        break;
                }
                break;
            case 3:
                opcaoTipo = selecionarTipo("Editar");
                if(opcaoTipo == 3){
                    menuPrincipal(listaCarros,listaMotos,listaCarrosVendidos,listaMotosVendidas);
                }
                int indice = verificaAutomovel(listaCarros,listaMotos,listaCarrosVendidos,listaMotosVendidas,opcaoTipo);
                if(indice == -1){
                    System.out.println("Placa não encontrada!");
                    menuPrincipal(listaCarros,listaMotos,listaCarrosVendidos,listaMotosVendidas);
                }
                int editar = selecionarEditar("Informe o que deseja editar: ");
                switch (opcaoTipo){
                    case 1:
                        switch (editar){
                            case 1:
                                listaCarros.set(indice,cadastrarCarro());
                                menuPrincipal(listaCarros,listaMotos,listaCarrosVendidos,listaMotosVendidas);
                                break;
                            case 2:
                                editarAtributo(indice, listaCarros, listaMotos, opcaoTipo);
                                menuPrincipal(listaCarros,listaMotos,listaCarrosVendidos,listaMotosVendidas);
                                break;
                        }
                        break;
                    case 2:
                        switch (editar){
                            case 1:
                                listaMotos.set(indice, cadastrarMoto());
                                menuPrincipal(listaCarros,listaMotos,listaCarrosVendidos,listaMotosVendidas);
                                break;
                            case 2:
                                editarAtributo(indice,listaCarros,listaMotos,opcaoTipo);
                                menuPrincipal(listaCarros,listaMotos,listaCarrosVendidos,listaMotosVendidas);
                                break;
                        }
                        break;
                }
                break;
            case 4:
                opcaoTipo = selecionarTipo("Remover: ");
                if (opcaoTipo == 3){
                    menuPrincipal(listaCarros,listaMotos,listaCarrosVendidos,listaMotosVendidas);
                }
                indice = verificaAutomovel(listaCarros,listaMotos,listaCarrosVendidos,listaMotosVendidas,opcaoTipo);
                if(indice == -1){
                    System.out.println("Placa não encontrada!");
                    menuPrincipal(listaCarros,listaMotos,listaCarrosVendidos,listaMotosVendidas);
                }else{
                excluirCarro(listaCarros,listaMotos,listaCarrosVendidos,listaMotosVendidas,opcaoTipo,indice);
                }
                menuPrincipal(listaCarros,listaMotos,listaCarrosVendidos,listaMotosVendidas);
                break;
            case 5:
                opcaoTipo = selecionarTipo("Vender: ");
                if (opcaoTipo == 3){
                    menuPrincipal(listaCarros,listaMotos,listaCarrosVendidos,listaMotosVendidas);
                }
                indice = verificaAutomovel(listaCarros,listaMotos,listaCarrosVendidos,listaMotosVendidas,opcaoTipo);
                if(indice == -1){
                    System.out.println("Placa não encontrada!");
                    menuPrincipal(listaCarros,listaMotos,listaCarrosVendidos,listaMotosVendidas);
                }else{
                    venderAutomovel(listaCarros,listaCarrosVendidos,listaMotos,listaMotosVendidas,opcaoTipo,indice);
                }
                menuPrincipal(listaCarros,listaMotos,listaCarrosVendidos,listaMotosVendidas);
                break;
            case 6:
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

    private static int verificaAutomovel(ArrayList<Carro> listaCarros, ArrayList<Moto> listaMotos, ArrayList<Carro> listaCarrosVendidos, ArrayList<Moto> listaMotosVendidas, int opcaoTipo){
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
                menuPrincipal(listaCarros,listaMotos,listaCarrosVendidos,listaMotosVendidas);
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

    private static void editaAutomovel(ArrayList<Carro> listaCarros,ArrayList<Moto> listaMotos){
        System.out.println("Informe o que deseja editar:" +
                "\n1- Marca" +
                "\n2- Modelo" +
                "\n3- Número da placa");
    }

    private static void editarAtributo(int indice,ArrayList<Carro> listaCarros,ArrayList<Moto> listaMotos,int opcaoTipo){
        switch (opcaoTipo){
            case 1:
                editaAutomovel(listaCarros,listaMotos);
                System.out.println("4- Quantidade de portas" +
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
                System.out.println("4- Cilindradas" +
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

    private static void excluirCarro(ArrayList<Carro> listaCarros,ArrayList<Moto> listaMotos,ArrayList<Carro> listaCarrosVendidos,ArrayList<Moto> listaMotosVendidas,int opcaoTipo,int indice){
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
                    
                    break;
            }
        }else{
            menuPrincipal(listaCarros,listaMotos,listaCarrosVendidos,listaMotosVendidas);
        }

    }

    private static int selecionarTipoListar(String opcaoMenu){
        System.out.println(opcaoMenu +
                "\n1- Em estoque" +
                "\n2- Vendidos");
        return tec.nextInt();
    }

    private static void venderAutomovel(ArrayList<Carro> listaCarros,ArrayList<Carro> listaCarrosVendidos,ArrayList<Moto> listaMotos,ArrayList<Moto> listaMotosVendidas,int opcaoTipo,int indice){
        switch (opcaoTipo){
            case 1:
                listaCarrosVendidos.add(listaCarros.get(indice));
                listaCarros.remove(indice);
                System.out.println("Carro vendido com sucesso!");
                break;
            case 2:
                listaMotosVendidas.add(listaMotos.get(indice));
                listaMotos.remove(indice);
                System.out.println("Moto vendida com sucesso!");
                break;
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