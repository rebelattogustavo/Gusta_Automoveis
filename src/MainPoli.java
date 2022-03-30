import java.util.ArrayList;
import java.util.Scanner;

public class MainPoli {
    static Scanner tec = new Scanner(System.in);
    static ArrayList<Automovel> listaAutomoveis = new ArrayList<>();

    public static void main(String[] args) {
        menuPrincipal();
    }

    public static void menuPrincipal(){
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
                if(opcaoTipo == 3){
                    menuPrincipal();
                }
                listaAutomoveis.add(cadastrarAutomovel(opcaoTipo));
                menuPrincipal();
                break;
            case 2:
                opcaoTipo = selecionarTipo("Listar: ");
                if (opcaoTipo == 3){
                    menuPrincipal();
                }
                int listar = selecionarTipoListar("Informe o que deseja ver: ");
                switch (opcaoTipo){
                    case 1:
                        switch (listar){
                            case 1:
                                listaAutomoveis.forEach(automovel -> {
                                    if (automovel instanceof Carro && automovel.getVendido() == false){
                                        System.out.println(automovel);
                                    }
                                });
                                menuPrincipal();
                                break;
                            case 2:
                                listaAutomoveis.forEach(automovel -> {
                                    if(automovel instanceof Carro && automovel.getVendido() == true){
                                        System.out.println(automovel);
                                    }
                                });
                                menuPrincipal();
                                break;
                        }
                        break;
                    case 2:
                        switch (listar){
                            case 1:
                                listaAutomoveis.forEach(automovel -> {
                                    if(automovel instanceof Moto && automovel.getVendido() == false){
                                        System.out.println(automovel);
                                    }
                                });
                                menuPrincipal();
                                break;
                            case 2:
                                listaAutomoveis.forEach(automovel -> {
                                    if(automovel instanceof Moto && automovel.getVendido() == true){
                                        System.out.println(automovel);
                                    }
                                });
                                menuPrincipal();
                                break;
                        }
                        break;
                }
                break;
            case 3:
                opcaoTipo = selecionarTipo("Editar");
                if(opcaoTipo == 3){
                    menuPrincipal();
                }
                int indice = verificaAutomovel(opcaoTipo);
                if(indice == -1){
                    System.out.println("Placa não encontrada!");
                    menuPrincipal();
                }
                int editar = selecionarEditar("Informe o que deseja editar: ");
                switch (editar){
                    case 1:
                        listaAutomoveis.set(indice, cadastrarAutomovel(opcaoTipo));
                        menuPrincipal();
                        break;
                    case 2:
                        editarAtributo(indice, opcaoTipo);
                        menuPrincipal();
                        break;
                }
                break;
            case 4:
                opcaoTipo = selecionarTipo("Remover: ");
                if (opcaoTipo == 3){
                    menuPrincipal();
                }
                indice = verificaAutomovel(opcaoTipo);
                if(indice == -1){
                    System.out.println("Placa não encontrada!");
                    menuPrincipal();
                }else{
                    excluirCarro(indice);
                }
                menuPrincipal();
                break;
            case 5:
                opcaoTipo = selecionarTipo("Vender: ");
                if (opcaoTipo == 3){
                    menuPrincipal();
                }
                indice = verificaAutomovel(opcaoTipo);
                if(indice == -1){
                    System.out.println("Placa não encontrada!");
                    menuPrincipal();
                }else{
                    venderAutomovel(opcaoTipo,indice);
                }
                menuPrincipal();
                break;
            case 6:
                System.exit(0);
                break;
        }
    }

    private static Automovel cadastrarAutomovel(int opcaoTipo){
        System.out.println("Informe os dados:" +
                "\nMarca: ");
        String marca = tec.next();
        System.out.println("Modelo: ");
        String modelo = tec.next();
        System.out.println("Número da placa: ");
        String numPlaca = tec.next();
        Automovel automovel = new Automovel(marca, modelo, numPlaca, false);

        switch (opcaoTipo){
            case 1:
                System.out.println("Quantidade de portas: ");
                int qtdPorta = tec.nextInt();
                System.out.println("Cavalos (HP): ");
                int cavalos = tec.nextInt();
                System.out.println("Tração: ");
                String tracao = tec.next();
                return new Carro(automovel.getMarca(), automovel.getModelo(), automovel.getNumPlaca(), automovel.getVendido(),qtdPorta,
                        cavalos, tracao);
            case 2:
                System.out.println("Informe a quantidade de CC: ");
                int cilindradas = tec.nextInt();
                System.out.println("Informe a quantidade de WATTS no alternador: ");
                int alternador = tec.nextInt();
                System.out.println("Informe a taxa de compressão: ");
                double  taxaCompressao = tec.nextDouble();
                return new Moto(automovel.getMarca(), automovel.getModelo(), automovel.getNumPlaca(), automovel.getVendido(), cilindradas,
                        alternador, taxaCompressao);
        }
        return automovel;
    }

    private static int verificaAutomovel(int opcaoTipo){
        System.out.println("Informe a placa do veículo: ");
        String numPlaca = tec.next();
                for (int i =0; i < listaAutomoveis.size(); i++) {
                    if (listaAutomoveis.get(i).getNumPlaca().equals(numPlaca)) {
                        return i;
                    } else {
                        return -1;
                    }
                }
        menuPrincipal();
        return -1;
    }

    private static int selecionarEditar(String opcaoMenu){
        System.out.println(opcaoMenu +
                "\n1- Tudo" +
                "\n2- Um atributo");
        return tec.nextInt();
    }

    private static void editaAutomovel(){
        System.out.println("Informe o que deseja editar:" +
                "\n1- Marca" +
                "\n2- Modelo" +
                "\n3- Número da placa");
    }

    private static void editarAtributo(int indice,int opcaoTipo){
        switch (opcaoTipo){
            case 1:
                editaAutomovel();
                System.out.println("4- Quantidade de portas" +
                        "\n5- Cavalos" +
                        "\n6- Tração");
                int opcao = tec.nextInt();
                switch (opcao){
                    case 1:
                        System.out.print("Informe a nova marca: ");
                        listaAutomoveis.get(indice).setMarca(tec.next());
                        break;
                    case 2:
                        System.out.print("Informe o novo modelo: ");
                        listaAutomoveis.get(indice).setModelo(tec.next());
                        break;
                    case 3:
                        System.out.print("Informe a nova placa: ");
                        listaAutomoveis.get(indice).setNumPlaca(tec.next());
                        break;
                    case 4:
                        System.out.print("Informe a nova quantidade de portas: ");
                        ((Carro)listaAutomoveis.get(indice)).setQtdPorta(tec.nextInt());
                        break;
                    case 5:
                        System.out.print("Informe a nova quantidade de cavalos(HP): ");
                        ((Carro)listaAutomoveis.get(indice)).setCavalos(tec.nextInt());
                        break;
                    case 6:
                        System.out.println("Informe a nova tração: ");
                        ((Carro)listaAutomoveis.get(indice)).setTracao(tec.next());
                        break;
                }
                break;
            case 2:
                editaAutomovel();
                System.out.println("4- Cilindradas" +
                        "\n5- Alternador" +
                        "\n6- Taxa de compressão");
                opcao = tec.nextInt();
                switch (opcao){
                    case 1:
                        System.out.print("Informe a nova marca: ");
                        listaAutomoveis.get(indice).setMarca(tec.next());
                        break;
                    case 2:
                        System.out.print("Informe o novo modelo: ");
                        listaAutomoveis.get(indice).setModelo(tec.next());
                        break;
                    case 3:
                        System.out.print("Informe a nova placa: ");
                        listaAutomoveis.get(indice).setNumPlaca(tec.next());
                        break;
                    case 4:
                        System.out.print("Informe a nova quantidade de cilindradas: ");
                        ((Moto)listaAutomoveis.get(indice)).setCilindradas(tec.nextInt());
                        break;
                    case 5:
                        System.out.print("Informe a nova medida do alternador: ");
                        ((Moto)listaAutomoveis.get(indice)).setAlternador(tec.nextInt());
                        break;
                    case 6:
                        System.out.print("Informe a nova taxa de compressão: ");
                        ((Moto)listaAutomoveis.get(indice)).setTaxaCopressao(tec.nextInt());
                        break;
                }
                break;
        }
    }

    private static void excluirCarro(int indice){
        System.out.println("Realmente deseja excluir esse veículo?");
        char resposta = tec.next().charAt(0);
        if(resposta == 's' || resposta == 'S'){
            listaAutomoveis.remove(indice);
        }
        else{
            menuPrincipal();
        }
        menuPrincipal();
    }

    private static int selecionarTipoListar(String opcaoMenu){
        System.out.println(opcaoMenu +
                "\n1- Em estoque" +
                "\n2- Vendidos");
        return tec.nextInt();
    }

    private static void venderAutomovel(int opcaoTipo,int indice){
        switch (opcaoTipo){
            case 1:
                listaAutomoveis.get(indice).setVendido(true);
                System.out.println("Carro vendido com sucesso!");
                break;
            case 2:
                listaAutomoveis.get(indice).setVendido(true);
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
