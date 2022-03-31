import java.util.ArrayList;
import java.util.Scanner;

public class MainPoli {
    static Scanner tec = new Scanner(System.in);
    static ArrayList<Automovel> listaAutomoveis = new ArrayList<>();
    static ArrayList<Pessoa> listaPessoas = new ArrayList<>();

    public static void main(String[] args) {
        cadastra();
        login();
    }

    private static void cadastra(){
        String nome = "Gustavo", cpf = "106.141.649-66", telefone = "(47)99124-3008", genero = "Masculino", senha = "1";
        int idade = 17, matricula = 72130;
        Dono dono = new Dono(nome, cpf, telefone, genero, idade, matricula, senha);
        listaPessoas.add(dono);
    }

    public static void login(){
        System.out.print("Informe a matrícula: ");
        int matricula = tec.nextInt();
        listaPessoas.forEach(pessoa -> {
                if(matricula == pessoa.getMatricula()){
                    if(pessoa instanceof Funcionario || pessoa instanceof Dono) {
                        System.out.print("Informe a senha: ");
                        String senha = tec.next();
                        if(((Funcionario) pessoa).getSenha().equals(senha)){
                            menuPrincipal();
                        }else{
                            System.out.println("Senha incorreta! Tente novamente");
                            login();
                        }
                    }else {
                        System.out.println("Você não é um funcionário!");
                        login();
                    }
                }else {
                    System.out.println("Matrícula incorreta! Tente novamente");
                    login();
                }
        });
//        System.out.print("Informe a matrícula: ");
//        int matricula = tec.nextInt();
//        for(int i=0;i<listaPessoas.size();i++){
//            if(listaPessoas.get(i) instanceof Funcionario || listaPessoas.get(i) instanceof Dono){
//                if(matricula == listaPessoas.get(i).getMatricula()){
//                    System.out.print("Informe a senha: ");
//                    String senha = tec.next();
//                    if(listaPessoas.get(i) instanceof Funcionario){
//                        if(senha == ((Funcionario) listaPessoas.get(i)).getSenha()){
//                            menuPrincipal();
//                        }else{
//                            System.out.println("Senha incorreta! Tente novamente");
//                            login();
//                        }
//                    }
//                }
//            }
//        }
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
                if(opcaoTipo == 5){
                    menuPrincipal();
                }else if(opcaoTipo == 1 || opcaoTipo == 2){
                    listaAutomoveis.add(cadastrarAutomovel(opcaoTipo));
                }else if(opcaoTipo == 3 || opcaoTipo == 4){
                    listaPessoas.add(cadastrarPessoa(opcaoTipo));
                }
                    menuPrincipal();
                break;
            case 2:
                int listar = 0;
                opcaoTipo = selecionarTipo("Listar: ");
                if (opcaoTipo == 5){
                    menuPrincipal();
                }else if(opcaoTipo == 1 || opcaoTipo == 2){
                    listar = selecionarTipoListar("Informe o que deseja ver: ");
                }
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
                    case 3:
                        listaPessoas.forEach(pessoa -> {
                            if(pessoa instanceof Funcionario){
                                System.out.println(pessoa);
                            }
                        });
                        menuPrincipal();
                        break;
                    case 4:
                        listaPessoas.forEach(pessoa -> {
                            if(pessoa instanceof Cliente){
                                System.out.println(pessoa);
                            }
                        });
                        menuPrincipal();
                        break;
                }
                break;
            case 3:
                opcaoTipo = selecionarTipo("Editar");
                int indice =0;
                if(opcaoTipo == 5){
                    menuPrincipal();
                }else if(opcaoTipo == 1 || opcaoTipo == 2){
                    indice = verificaAutomovel(opcaoTipo);
                    if(indice == -1){
                        System.out.println("Placa não encontrada!");
                        menuPrincipal();
                    }
                }else if(opcaoTipo == 3 || opcaoTipo ==4){
                    indice = verificaPessoa(opcaoTipo);
                    if(indice == -1){
                        System.out.println("Pessoa não encontrada!");
                        menuPrincipal();
                    }
                }
                int editar = selecionarEditar("Informe o que deseja editar: ");
                if(opcaoTipo == 1 || opcaoTipo == 2){
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
                }else if (opcaoTipo == 3 || opcaoTipo == 4){
                    switch (editar){
                        case 1:
                            listaPessoas.set(indice, cadastrarPessoa(opcaoTipo));
                            menuPrincipal();
                            break;
                        case 2:
                            editarAtributo(indice, opcaoTipo);
                            menuPrincipal();
                    }
                }
                break;
            case 4:
                opcaoTipo = selecionarTipo("Remover: ");
                if (opcaoTipo == 5){
                    menuPrincipal();
                }else if(opcaoTipo == 1 || opcaoTipo == 2){
                    indice = verificaAutomovel(opcaoTipo);
                    if(indice == -1){
                        System.out.println("Placa não encontrada!");
                        menuPrincipal();
                    }else{
                        excluirCarro(indice);
                    }
                }else if(opcaoTipo == 3 || opcaoTipo == 4){
                    indice = verificaPessoa(opcaoTipo);
                    if(indice == -1){
                        System.out.println("Pessoa não encontrada!");
                        menuPrincipal();
                    }else{
                        excluirPessoa(indice);
                    }
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
        System.out.print("Modelo: ");
        String modelo = tec.next();
        System.out.print("Número da placa: ");
        String numPlaca = tec.next();
        Automovel automovel = new Automovel(marca, modelo, numPlaca, false);

        switch (opcaoTipo){
            case 1:
                System.out.print("Quantidade de portas: ");
                int qtdPorta = tec.nextInt();
                System.out.print("Cavalos (HP): ");
                int cavalos = tec.nextInt();
                System.out.print("Tração: ");
                String tracao = tec.next();
                return new Carro(automovel.getMarca(), automovel.getModelo(), automovel.getNumPlaca(), automovel.getVendido(),qtdPorta,
                        cavalos, tracao);
            case 2:
                System.out.print("Informe a quantidade de CC: ");
                int cilindradas = tec.nextInt();
                System.out.print("Informe a quantidade de WATTS no alternador: ");
                int alternador = tec.nextInt();
                System.out.print("Informe a taxa de compressão: ");
                double  taxaCompressao = tec.nextDouble();
                return new Moto(automovel.getMarca(), automovel.getModelo(), automovel.getNumPlaca(), automovel.getVendido(), cilindradas,
                        alternador, taxaCompressao);
        }
        return automovel;
    }

    private static Pessoa cadastrarPessoa(int opcaoTipo){

        System.out.print("Informe os dados:" +
                "\nNome: ");
        String nome = tec.next();
        System.out.print("CPF: ");
        String cpf = tec.next();
        System.out.print("Número de telefone: ");
        String telefone = tec.next();
        System.out.print("Gênero: ");
        String genero = tec.next();
        System.out.print("Idade: ");
        int idade = tec.nextInt();
        System.out.print("Matrícula: ");
        int matricula = tec.nextInt();
        Pessoa pessoa = new Pessoa(nome, cpf, genero, telefone, idade, matricula);

        switch (opcaoTipo) {
            case 3:
                System.out.println("Senha: ");
                String senha = tec.next();
                return new Funcionario(nome, cpf, telefone, genero, idade, matricula, senha);
            case 4:
                return  new Cliente(nome,cpf, telefone, genero, idade, matricula);
        }
        return pessoa;
    }

    private static int verificaAutomovel(int opcaoTipo){
        System.out.print("Informe a placa do veículo: ");
        String numPlaca = tec.next();
                for (int i =0; i < listaAutomoveis.size(); i++) {
                    if (listaAutomoveis.get(i).getNumPlaca().equals(numPlaca)) {
                        return i;
                    }
                }
        return -1;
    }

   private static int verificaPessoa(int opcaoTipo){
        System.out.print("Informe a matrícula da pessoa: ");
        int matricula = tec.nextInt();
            for (int i =0; i < listaPessoas.size(); i++) {
                if (matricula == listaPessoas.get(i).getMatricula()) {
                    return i;
                }
            }
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

    private static void editaPessoa(){

        System.out.println("Informe o que deseja editar:" +
                "\n1- Nome" +
                "\n2- CPF" +
                "\n3- Telefone" +
                "\n4- Gênero" +
                "\n5- Idade" +
                "\n6- Matrícula");
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
                        System.out.print("Informe a nova tração: ");
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
            case 3:
                editaPessoa();
                System.out.println("7- Senha");
                opcao = tec.nextInt();
                switch (opcao){
                    case 1:
                        System.out.print("Informe o novo nome: ");
                        listaPessoas.get(indice).setNome(tec.next());
                        break;
                    case 2:
                        System.out.print("Informe o novo CPF: ");
                        listaPessoas.get(indice).setCpf(tec.next());
                        break;
                    case 3:
                        System.out.print("Informe o novo telefone: ");
                        listaPessoas.get(indice).setTelefone(tec.next());
                        break;
                    case 4:
                        System.out.print("Informe o novo gênero: ");
                        listaPessoas.get(indice).setGenero(tec.next());
                        break;
                    case 5:
                        System.out.print("Informe a nova idade: ");
                        listaPessoas.get(indice).setIdade(tec.nextInt());
                        break;
                    case 6:
                        System.out.print("Informe a nova matrícula: ");
                        listaPessoas.get(indice).setMatricula(tec.nextInt());
                        break;
                    case 7:
                        System.out.print("Informe a nova senha");
                        ((Funcionario)listaPessoas.get(indice)).setSenha(tec.next());
                        break;
                }
                break;
            case 4:
                editaPessoa();
                opcao = tec.nextInt();
                switch (opcao){
                    case 1:
                        System.out.print("Informe o novo nome: ");
                        listaPessoas.get(indice).setNome(tec.next());
                        break;
                    case 2:
                        System.out.print("Informe o novo CPF: ");
                        listaPessoas.get(indice).setCpf(tec.next());
                        break;
                    case 3:
                        System.out.print("Informe o novo telefone: ");
                        listaPessoas.get(indice).setTelefone(tec.next());
                        break;
                    case 4:
                        System.out.print("Informe o novo gênero: ");
                        listaPessoas.get(indice).setGenero(tec.next());
                        break;
                    case 5:
                        System.out.print("Informe a nova idade: ");
                        listaPessoas.get(indice).setIdade(tec.nextInt());
                        break;
                    case 6:
                        System.out.print("Informe a nova matrícula: ");
                        listaPessoas.get(indice).setMatricula(tec.nextInt());
                        break;

                }
                break;
    }}

    private static void excluirCarro(int indice){
        System.out.println("Realmente deseja excluir esse veículo?");
        char resposta = tec.next().charAt(0);
        if(resposta == 's' || resposta == 'S'){
            listaAutomoveis.remove(indice);
        }
        else{
            menuPrincipal();
        }
    }

    private static void excluirPessoa(int indice){
        System.out.println("Realmente deseja excluir essa pessoa?");
        char resposta = tec.next().charAt(0);
        if(resposta == 's' || resposta == 'S'){
            listaPessoas.remove(indice);
        }
        else{
            menuPrincipal();
        }
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
                "\n3- Funcionário" +
                "\n4- Cliente" +
                "\n5- Voltar");
        return tec.nextInt();
    }

}
