import java.util.ArrayList;
import java.util.Scanner;
import java.lang.Math;

public class Main
{
    static Scanner s = new Scanner(System.in);

    //Declaração de todas as variáveis utilizadas:
    //Cadastros: Tutor, Animal, Usuário


    //Tutores
    //Responsável: Thiago Ferreira Rocha

    static ArrayList<TutorData> listaTutores = new ArrayList<>();


    //Animais
    //Responsável: Brenda Luana

    static final int MAX_ANIMAIS = 100;
    static String nomeAnimal[] = new String[MAX_ANIMAIS];
    static String especieAnimal[] = new String [MAX_ANIMAIS];
    static String racaAnimal[] = new String [MAX_ANIMAIS];
    static Integer tutorAnimal[] = new Integer [MAX_ANIMAIS];
    static int[] id_animal = new int[MAX_ANIMAIS];
    static int qtdadeAnimal = 0;
    static int proximoIDAnimal = 1;

    //Usuarios:
    //Responsáveis: cadastro e listagem de animais Arthur
    //Regras de negocio para cadastro de animais Illana
    //Deletar e Alterar usuários Caio Basilio

    static final int MAX_USUARIOS = 100;
    static int[] ids = new int[MAX_USUARIOS];
    static String[] nomes = new String[MAX_USUARIOS];
    static String[] emails = new String[MAX_USUARIOS];
    static String[] telefones = new String[MAX_USUARIOS];
    static int totalUsuarios = 0;
    static int proximoId = 1;

    // Ocorrências - NOVO MÓDULO ADICIONADO AQUI
    // Responsáveis: Illana Rabelo e Lawrenzy Rocha

    static final int MAX_OCORRENCIAS = 100;
    static int[] id_ocorrencia = new int[MAX_OCORRENCIAS];
    static String[] tipoOcorrencia = new String[MAX_OCORRENCIAS];
    static String[] dataOcorrencia = new String[MAX_OCORRENCIAS];
    static String[] localOcorrencia = new String[MAX_OCORRENCIAS];
    static String[] descricaoOcorrencia = new String[MAX_OCORRENCIAS];
    static int[] idAnimalRelacionado = new int[MAX_OCORRENCIAS];
    static String[] statusOcorrencia = new String[MAX_OCORRENCIAS];
    static int totalOcorrencias = 0;
    static int proximoIDOcorrencia = 1;

    //Funções Globais/Main:
    public static void main(String[] args) {


        //Menu principal:
        while(true)
        {
            limparTela();
            imprimirMenuPrincipal();
            int opcao = s.nextInt();
            s.nextLine();


            switch(opcao)
            {
                case 1:
                    submenuTutor();
                    break;
                case 2:
                    submenuAnimais();
                    break;
                case 3:
                    subMenuUsuario();
                    break;
                case 4:
                    submenuOcorrencias(); // Chamada para o novo submenu de ocorrências
                    break;
                case 5:
                    System.out.println();
                    System.out.println("Programa encerrado.");
                    return;
                default:
                    limparTela();
                    System.out.println("Opção inválida. Tente novamente!");
                    s.nextLine();
            }
        }
    }

    // Função utilitária para limpar a tela / verificar id tutor
    static void limparTela(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    static boolean apenasNumeros(String texto){
    //função olha o texto e se achar algo que não é número retorna falso, se não true

                    for (int i = 0; i < texto.length(); i++)
                    {
                        char c = texto.charAt(i);

                        if(c < '0' || c > '9')
                        {
                           return false;
                        }
                    }
                        return true;
    }

    static void imprimirMenuPrincipal() {

        System.out.println("----------STRAY PET----------");
        System.out.println("Selecione uma das opções:");
        System.out.println("1 - Tutores");
        System.out.println("2 - Animais");
        System.out.println("3 - Usuários");
        System.out.println("4 - Ocorrências");
        System.out.println("5 - Sair");
        System.out.println("-----------------------------");
    }

    //----------Funções relacionadas com Tutor----------//
    // Thiago Ferreira Rocha
    //Lawrenzy - validação

    public static void submenuTutor() {

        while (true) {

            limparTela();
            imprimirSubMenuTutor();
            int opcao = s.nextInt();
            s.nextLine();

            switch (opcao) {
                case 1:
                    funcaoTutor();
                    break;
                case 2:
                    listaTutores();
                    break;
                case 3:
                    alterarTutor();
                    break;
                case 4:
                    deletarTutor();
                    break;
                case 5:
                    return;
                default:
                    limparTela();
                    System.out.println("Opção inválida. Tente novamente!");
                    s.nextLine(); // Pausar na mensagem de erro
            }
        }
    }

    public static void imprimirSubMenuTutor() {
        System.out.println("----------STRAY PET----------");
        System.out.println("------------TUTOR------------");
        System.out.println("Selecione uma das opções:");
        System.out.println("1 - Cadastrar tutor");
        System.out.println("2 - Tutores cadastrados");
        System.out.println("3 - Alterar tutor");
        System.out.println("4 - Excluir tutor");
        System.out.println("5 - Voltar ao menu principal");
        System.out.println("-----------------------------");
    }

    public static void funcaoTutor() {

        String nomeCompleto;
        String nomeUsuario;
        String genero;
        String email;
        int dia;
        int mes;
        int ano;
        int enderecoCEP;
        long telefone;
        int senha;
        char inicio;

        System.out.println();
        System.out.println("Registrar novo tutor? (S ou N)");
        inicio = Character.toUpperCase(s.next().charAt(0));

        if (inicio == 'N') {
            return;
        } else {
            s.nextLine();

            System.out.println("Insira seu nome e sobrenome:");
            nomeCompleto = s.nextLine();

            System.out.println("Insira seu nome de usuário:");
            nomeUsuario = s.nextLine();

            String senhaString;
            while (true) {
                System.out.println("Defina uma senha (deve conter apenas números, máx. 8 dígitos):");
                senhaString = s.nextLine();

                if (apenasNumeros(senhaString) && senhaString.length() <= 8 && !senhaString.isEmpty()) {
                    senha = Integer.parseInt(senhaString);
                    break;
                } else {
                    System.out.println("Senha inválida.");
                    System.out.println("Insira apenas números (máx. 8 dígitos).");
                }
            }

            while (true) { // Added a loop for gender validation
                System.out.println("Informe o seu gênero (Masculino ou Feminino):");
                genero = s.nextLine();
                if (genero.equalsIgnoreCase("Masculino") || genero.equalsIgnoreCase("Feminino")) {
                    break; // Gênero válido, sai do loop
                } else {
                    System.out.println("Gênero inválido. Por favor, insira 'Masculino' ou 'Feminino'.");
                }
            }


            // --- Validar as datas informadas ---//
            while (true) {
                System.out.println("Informe sua data de nascimento:");
                System.out.print("Dia (DD): ");
                String diaString = s.nextLine();
                if (apenasNumeros(diaString) && diaString.length() <= 2 && !diaString.isEmpty()) {
                    dia = Integer.parseInt(diaString);
                    if (dia >= 1 && dia <= 31) {
                        break; // Dia válido, sai do loop do dia
                    } else {
                        System.out.println("Dia inválido. O dia deve estar entre 1 e 31.");
                    }
                } else {
                    System.out.println("Formato inválido. O dia deve conter 1 ou 2 números.");
                    System.out.println("Ex: 01");
                }
            }

            while (true) {
                System.out.print("Mês (MM): ");
                String mesString = s.nextLine();
                if (apenasNumeros(mesString) && mesString.length() <= 2 && !mesString.isEmpty()) {
                    mes = Integer.parseInt(mesString);
                    if (mes >= 1 && mes <= 12) {
                        break; // Mês válido, sai do loop do mês
                    } else {
                        System.out.println("Mês inválido. O mês deve estar entre 1 e 12.");
                    }
                } else {
                    System.out.println("Formato inválido. O mês deve conter 1 ou 2 números.");
                    System.out.println("Ex: 12");
                }
            }

            while (true) {
                System.out.print("Ano (AAAA): ");
                String anoString = s.nextLine();
                if (apenasNumeros(anoString) && anoString.length() == 4 && !anoString.isEmpty()) {
                    ano = Integer.parseInt(anoString);
                    if (ano >= 1900 && ano <= 2025) {
                        break; // Ano válido, sai do loop do ano
                    } else {
                        System.out.println("Ano inválido. O ano deve estar entre 1900 e 2025.");
                    }
                } else {
                    System.out.println("Formato inválido. O ano deve conter exatamente 4 números.");
                    System.out.println("Ex: 2025");
                }
            }


            System.out.println("Informe o seu e-mail:");
            System.out.println("Ex: nomeemail@email.com");
            email = s.nextLine();

            // Validação para CEP (apenas números, exatamente 8 dígitos o limite do CEP)
            String enderecoCEPString;
            while (true) {
                System.out.println("Informe o seu endereço (CEP - 8 dígitos):");
                enderecoCEPString = s.nextLine();
                if (apenasNumeros(enderecoCEPString) && enderecoCEPString.length() == 8) {
                    enderecoCEP = Integer.parseInt(enderecoCEPString);
                    break;
                } else {
                    System.out.println("CEP inválido. Por favor, insira exatamente 8 números.");
                }
            }

            // Validação para Telefone (apenas números, até 11 dígitos considerando o DDD Regional 34 12345 6789)
            String telefoneString;
            while (true) {
                System.out.println("Informe o seu telefone de contato (até 11 dígitos):");
                telefoneString = s.nextLine();
                if (apenasNumeros(telefoneString) && telefoneString.length() <= 11 && !telefoneString.isEmpty()) {
                    telefone = Long.parseLong(telefoneString);
                    break;
                } else {
                    System.out.println("Telefone inválido. Por favor, insira apenas números e no máximo 11 dígitos.");
                }
            }

            System.out.println("Usuário registrado com sucesso.");
            TutorData tutor = new TutorData(nomeCompleto, nomeUsuario, genero, email, dia, mes, ano, enderecoCEP, telefone, senha);
            listaTutores.add(tutor);
            s.nextLine(); // Pausa para ver a mensagem de sucesso
        }
        // Após cadastro, retorna ao menu anterior
        return;
    }


    static void listaTutores() {
        if (listaTutores.isEmpty()) {
            System.out.println();
            System.out.println("Nenhum tutor cadastrado.");
        } else {
            System.out.println();
            System.out.println("Lista de tutores cadastrados:");
            for (TutorData tutor : listaTutores) {
                System.out.println(tutor);
            }
        }
        s.nextLine(); // Adicionei nextline aqui para parar e visualizar os cadastros
    }


    static void alterarTutor() {
        if (listaTutores.isEmpty()) {
            System.out.println("Nenhum tutor cadastrado.");
            return;
        }

        System.out.println("Digite o ID do tutor que deseja alterar:");
        int idAlterado = s.nextInt();
        s.nextLine();

        TutorData tutorEncontrado = null;

        for (TutorData tutor : listaTutores) {
            if (tutor.id == idAlterado) {
                tutorEncontrado = tutor;
                break;
            }
        }

        if (tutorEncontrado == null) {
            System.out.println("Tutor com ID não encontrado.");
            return;
        }

        while (true) {
            System.out.println("Qual dado deseja alterar?");
            System.out.println("1 - Nome completo");
            System.out.println("2 - Nome de usuário");
            System.out.println("3 - Gênero");
            System.out.println("4 - E-mail");
            System.out.println("5 - Data de nascimento");
            System.out.println("6 - CEP");
            System.out.println("7 - Telefone");
            System.out.println("8 - Senha");
            System.out.println();
            System.out.println("9 - Sair do menu de alteração");

            int escolha = s.nextInt();
            s.nextLine();

            if (escolha == 9) { // Opção 9 é para sair
                System.out.println("Saindo do menu de alteração.");
                break;
            }

            switch (escolha) {
                case 1:
                    System.out.println("Nome completo:");
                    tutorEncontrado.nomeCompleto = s.nextLine();
                    break;
                case 2:
                    System.out.println("Nome de usuário:");
                    tutorEncontrado.nomeUsuario = s.nextLine();
                    break;
                case 3:
                    while (true) { // Added validation for gender during alteration
                        System.out.println("Novo Gênero (Masculino ou Feminino):");
                        String novoGenero = s.nextLine();
                        if (novoGenero.equalsIgnoreCase("Masculino") || novoGenero.equalsIgnoreCase("Feminino")) {
                            tutorEncontrado.genero = novoGenero;
                            break;
                        } else {
                            System.out.println("Gênero inválido. Por favor, insira 'Masculino' ou 'Feminino'.");
                        }
                    }
                    break;
                case 4:
                    System.out.println("E-mail:");
                    tutorEncontrado.email = s.nextLine();
                    break;
                case 5:
                    // Alteração de Data de Nascimento - Lógica de validação similar à funcaoTutor
                    while (true) {
                        System.out.print("Novo Dia (DD): ");
                        String diaString = s.nextLine();
                        if (apenasNumeros(diaString) && diaString.length() <= 2 && !diaString.isEmpty()) {
                            tutorEncontrado.dia = Integer.parseInt(diaString);
                            if (tutorEncontrado.dia >= 1 && tutorEncontrado.dia <= 31) {
                                break;
                            } else {
                                System.out.println("Dia inválido. O dia deve estar entre 1 e 31.");
                            }
                        } else {
                            System.out.println("Formato inválido. O dia deve conter 1 ou 2 números.");
                        }
                    }

                    while (true) {
                        System.out.print("Novo Mês (MM): ");
                        String mesString = s.nextLine();
                        if (apenasNumeros(mesString) && mesString.length() <= 2 && !mesString.isEmpty()) {
                            tutorEncontrado.mes = Integer.parseInt(mesString);
                            if (tutorEncontrado.mes >= 1 && tutorEncontrado.mes <= 12) {
                                break;
                            } else {
                                System.out.println("Mês inválido. O mês deve estar entre 1 e 12.");
                            }
                        } else {
                            System.out.println("Formato inválido. O mês deve conter 1 ou 2 números.");
                        }
                    }

                    while (true) {
                        System.out.print("Novo Ano (AAAA): ");
                        String anoString = s.nextLine();
                        if (apenasNumeros(anoString) && anoString.length() == 4 && !anoString.isEmpty()) {
                            tutorEncontrado.ano = Integer.parseInt(anoString);
                            if (tutorEncontrado.ano >= 1900 && tutorEncontrado.ano <= 2025) {
                                break;
                            } else {
                                System.out.println("Ano inválido. O ano deve estar entre 1900 e 2025.");
                            }
                        } else {
                            System.out.println("Formato inválido. O ano deve conter exatamente 4 números.");
                        }
                    }
                    break;
                case 6:
                    // Validação para alteração de CEP
                    String novoCepString;
                    while (true) {
                        System.out.println("Novo CEP (8 dígitos):");
                        novoCepString = s.nextLine();
                        if (apenasNumeros(novoCepString) && novoCepString.length() == 8) {
                            tutorEncontrado.enderecoCEP = Integer.parseInt(novoCepString);
                            break;
                        } else {
                            System.out.println("CEP inválido. Por favor, insira exatamente 8 números.");
                        }
                    }
                    break;
                case 7:
                    // Validação para alteração de Telefone
                    String novoTelefoneString;
                    while (true) {
                        System.out.println("Novo Telefone (até 11 dígitos):");
                        novoTelefoneString = s.nextLine();
                        if (apenasNumeros(novoTelefoneString) && novoTelefoneString.length() <= 11 && !novoTelefoneString.isEmpty()) {
                            tutorEncontrado.telefone = Long.parseLong(novoTelefoneString);
                            break;
                        } else {
                            System.out.println("Telefone inválido. Por favor, insira apenas números e no máximo 11 dígitos.");
                        }
                    }
                    break;
                case 8:
                    String novaSenhaString;
                    while (true) {
                        System.out.println("Nova Senha (apenas números, máx. 8 dígitos):");
                        novaSenhaString = s.nextLine();
                        if (apenasNumeros(novaSenhaString) && novaSenhaString.length() <= 8 && !novaSenhaString.isEmpty()) {
                            tutorEncontrado.senha = Integer.parseInt(novaSenhaString);
                            break;
                        } else {
                            System.out.println("Senha inválida. Por favor, insira apenas números (máx. 8 dígitos).");
                        }
                    }
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
            System.out.println("Dados atualizados com sucesso!");
            s.nextLine(); // Pausa para exibir a mensagem de atualização
        }
    }

    static void deletarTutor() {
        if (listaTutores.isEmpty()) {
            System.out.println();
            System.out.println("Nenhum tutor cadastrado.");
            s.nextLine(); // Para não limpar a tela
            return;
        }

        System.out.println("Informe o ID do tutor que deseja deletar:");
        int idParaDeletar = s.nextInt();
        s.nextLine();

        boolean encontrado = false;

        for (int i = 0; i < listaTutores.size(); i++) {
            if (listaTutores.get(i).id == idParaDeletar) {
                listaTutores.remove(i);
                System.out.println("Tutor removido com sucesso!");
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Tutor com ID " + idParaDeletar + " não encontrado.");}
        }

    //----------Funções relacionadas com Animal----------
    //Brenda Luana

    public static void submenuAnimais(){

        //Menu principal:
        while(true)
        {
            limparTela();
            imprimirSubMenuAnimais();
            int opcao = s.nextInt();
            s.nextLine();

            switch(opcao)
            {
                case 1:
                   cadastrarAnimais();
                    break;
                case 2:
                   imprimirAnimais();
                    break;
                case 3:
                   atualizarAnimais();
                    break;
                case 4:
                    deletarAnimais();
                    break;
                case 5:
                    return;
                default:
                    limparTela();
                    System.out.println("Opção inválida. Tente novamente!");
                    s.nextLine(); //parar na mensagem de erro
            }
        }

    }

    public static void imprimirSubMenuAnimais(){
        System.out.println("----------STRAY PET----------");
        System.out.println("-----------ANIMAIS-----------");
        System.out.println("Selecione uma das opções:");
        System.out.println("1 - Cadastrar");
        System.out.println("2 - Listar");
        System.out.println("3 - Atualizar");
        System.out.println("4 - Deletar");
        System.out.println("5 - Voltar ao menu principal");
        System.out.println("-----------------------------");
        System.out.println();
    }

    public static boolean tutorExiste(Integer id){

        for(int i = 0; i < listaTutores.size();i++)
        {
                //percorre a lista de tutores, se achar retorna true.
            if(listaTutores.get(i).id == id)
            {
                return true;
            }
        }
        return false;
    }
    public static void cadastrarAnimais(){

        //CONDIÇÃO PARA VERIFICAR SE O LIMITE DE ANIMAIS FOI ATINGIDO
        if (qtdadeAnimal >= MAX_ANIMAIS) {
            System.out.println("Limite de animais atingido. Não é possível cadastrar mais animais.");
            s.nextLine(); // Pausar para o usuário ler
            return;
        }

          while (true){

            System.out.println();
            System.out.println("Registrar novo animal? (S ou N)");
            char inicio = s.next().charAt(0);

                if(inicio == 'N')
                {
                    return;
                }

                else
                {
                s.nextLine();

                String idTutor = " ";
                while(true)
                {
                    //validação do id se é números
                    System.out.println("Insira o id do tutor:");
                    idTutor = s.nextLine(); // o que o usuário digitar está na variável

                     if(apenasNumeros(idTutor) == false)
                     {
                         System.out.println("Digite apenas números.");
                         continue;
                     }

                     //validar se tutor existe na base:
                     if(tutorExiste(Integer.parseInt(idTutor)) == false){
                         System.out.println("Tutor não encontrado na base. Cadastre o tutor primeiro.");
                         s.nextLine(); 
                         return; 
                     }

                     break;

                }
                tutorAnimal[qtdadeAnimal] = Integer.parseInt(idTutor);
                //para converter a variavel para inteiro
                //variavel para controlar a quantidade de animais cadastrados e salvando nos vetores

                System.out.println("Insira o nome do animal:");
                    nomeAnimal[qtdadeAnimal] = s.nextLine();

                System.out.println("Insira a espécie do animal:");
                    especieAnimal[qtdadeAnimal] = s.nextLine();

                System.out.println("Insira a raça do animal:");
                    racaAnimal[qtdadeAnimal]= s.nextLine();

                id_animal[qtdadeAnimal] = proximoIDAnimal;

                System.out.println("Usuário registrado com sucesso.");
                s.nextLine(); // Pausar para o usuário ler

                 qtdadeAnimal++; //controle da posição livre do vetor
                 proximoIDAnimal++; // Incrementa o ID para o próximo animal

                }
          }
      }

        public static void imprimirAnimais(){


            for(int i = 0; i < qtdadeAnimal; i++)
            {

                System.out.println("--------ANIMAL(ID: " + id_animal[i] + ")--------");
                System.out.println("Tutor ID: " + tutorAnimal[i]);
                System.out.println("Nome animal: " + nomeAnimal[i]);
                System.out.println("Espécie animal: " + especieAnimal[i]);
                System.out.println("Raça animal: " + racaAnimal[i]);
                System.out.println("-----------------------------");

            }

            s.nextLine();

    }

        public static void atualizarAnimais(){

        if(qtdadeAnimal == 0)
            {
                System.out.println("Nenhum animal cadastrado.");
                 s.nextLine();
                return;
            }

        System.out.println("Digite o ID do animal que deseja alterar:");
        int idAnimalAlterado = s.nextInt();
        s.nextLine();
        int indice_animal = -1;// define esse indice para que possa "segurar" a posição do id
        for(int i= 0; i < qtdadeAnimal; i++) 
        {
            if(id_animal[i] == idAnimalAlterado)
            {
                indice_animal = i;
                break; 
            }
        }
        if (indice_animal <= -1)
        {
            System.out.println("Animal com ID " + idAnimalAlterado + " não encontrado.");
            s.nextLine(); // Pausar para o usuário ler
            return;
        }

        while(true) {
            System.out.println("----------STRAY PET----------");
            System.out.println("-----------ANIMAIS-----------");
            System.out.println("Qual dado deseja alterar?");
            System.out.println("1 - Nome do animal");
            System.out.println("2 - Espécie do animal");
            System.out.println("3 - Raça do animal");
            System.out.println("4 - Sair do menu de alteração");
            System.out.println("-----------------------------");
            System.out.println();


            int escolhaAnimal = s.nextInt();
            s.nextLine();

            switch(escolhaAnimal)
            {
                //para alteração dentro do vetor preciso colocar a funçao no mesmo
                case 1:
                    System.out.println("Novo nome do animal:");
                    nomeAnimal[indice_animal] = s.nextLine();
                    break;
                case 2:
                    System.out.println("Nova espécie do animal:");
                    especieAnimal[indice_animal] = s.nextLine();
                    break;
                case 3:
                    System.out.println("Nova raça do animal:");
                    racaAnimal[indice_animal] = s.nextLine();
                    break;
                case 4:
                    System.out.println("Saindo do menu de alteração.");
                    return; // Sai do método
                default:
                    limparTela();
                    System.out.println("Opção Inválida. Tente novamente!");
                    s.nextLine(); //parar na mensagem de erro
                }

            System.out.println("Dados atualizados com sucesso!");
            s.nextLine(); // Pausar para o usuário ler
        }
}

    public static void deletarAnimais(){

         if(qtdadeAnimal == 0)
           {
                System.out.println("Nenhum animal cadastrado.");
                s.nextLine();
                return;
            }

            System.out.println("Qual o ID do animal que deseja deletar:");//pergunta o id do animal para localizar do vetor
            int id = s.nextInt();
            s.nextLine();
            int indice_animal = -1;// define esse indice para que possa "segurar" a posição do id
            for (int i = 0; i < qtdadeAnimal; i++) //for para rodar dentro e ver todos os animais
            {
                if (id_animal[i] == id)
                {
                    indice_animal = i;
                    break;
                }
            }

            if (indice_animal == -1) { // Adiciona verificação se o animal foi encontrado
                System.out.println("Animal com ID " + id + " não encontrado.");
                s.nextLine();
                return;
            }


        System.out.println("Deseja continuar com a ação de exlusão de animal? (S/N)");//confirmando para que o usuario não delete um animal diferente
        System.out.println("Nome do animal: " + nomeAnimal[indice_animal]);
        System.out.println("Espécie do animal: " + especieAnimal[indice_animal]);
        System.out.println("Raça do Animal: " + racaAnimal[indice_animal]);

        char opcao = s.next().charAt(0);
        s.nextLine(); // Limpa o buffer

        if (opcao == 'S')
        {
            for (int i = indice_animal; i < qtdadeAnimal - 1; i++) {//irá alocar os indices no vetor
                id_animal[i] = id_animal[i + 1];
                nomeAnimal[i] = nomeAnimal[i + 1];
                especieAnimal[i] = especieAnimal[i + 1];
                racaAnimal[i] = racaAnimal[i + 1];
                tutorAnimal[i] = tutorAnimal[i + 1]; // Move também o tutor
            }
            qtdadeAnimal--;
            System.out.println("Animal deletado com sucesso!");
        } else {
            System.out.println("Operação de exclusão cancelada.");
        }
        s.nextLine(); // Pausar para o usuário ler


    }

    //----------Funções relacionadas com Usuário----------
    //Arthur Cavichioli

    public static void subMenuUsuario() {
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        do {
            limparTela();
            imprimirSubMenuUsuario(); //FUNÇÃO DE EXIBIR O MENU
            opcao = scanner.nextInt();
            scanner.nextLine(); //LIMPEZA DO BUFFER
            //MENU SIMPLES PARA CADASTRO DE USUÁRIOS
            switch (opcao) {
                case 1:
                    cadastrarUsuario(scanner);
                    break;
                case 2:
                    listarUsuarios();
                    s.nextLine();
                    break;
                case 3:
                    alterarUsuario();
                    s.nextLine();
                    break;
                case 4:
                    excluirUsuarios();
                    s.nextLine();
                    break;
                case 5:
                    System.out.println("Voltando ao menu principal...");
                    return; // Sai do subMenuUsuario
                default:
                    System.out.println("Opção inválida.");
                    s.nextLine();
            }
        } while (opcao != 0); // O loop continuará indefinidamente se a opção 0 não for para sair do programa
                               // Mudei para while(true) e um return no case 5 para sair
    }
     //FUNÇÃO PARA EXIBIR O MENU
    public static void imprimirSubMenuUsuario() {
        System.out.println("----------STRAY PET----------");
        System.out.println("-----------USUARIO-----------");
        System.out.println("1 - Cadastrar Usuário");
        System.out.println("2 - Listar Usuários");
        System.out.println("3 - Alterar Usuários");
        System.out.println("4 - Excluir Usuários");
        System.out.println("5 - Voltar ao menu principal");
        System.out.println("-----------------------------");
    }

     //FUNÇÃO PARA CADASTRAR USUÁRIOS
    public static void cadastrarUsuario(Scanner sc) {
        //CONDIÇÃO PARA VERIFICAR SE O LIMITE DE USUÁRIOS FOI ATINGIDO
        if (totalUsuarios >= MAX_USUARIOS) {
            System.out.println("Limite de usuários atingido. Não é possível cadastrar mais usuários.");
            s.nextLine(); // Pausar para o usuário ler
            return;
        }

        String nome;
        do {
            System.out.print("Nome completo: ");
            nome = sc.nextLine();
            if (nome.trim().isEmpty() || nome.length() < 3) {
                System.out.println("Nome inválido. O nome não pode ser vazio e deve ter no mínimo 3 caracteres.");
            }
        } while (nome.trim().isEmpty() || nome.length() < 3);

        String email;
        do {
            System.out.print("Email: ");
            email = sc.nextLine();
            // Validação de email simples: deve conter "@" e "." e não ser vazio
            if (email.trim().isEmpty() || !email.contains("@") || !email.contains(".")) {
                System.out.println("Email inválido. Por favor, insira um email válido (ex: seu.email@dominio.com).");
            } else if (emailJaExiste(email)) {
                System.out.println("Email já cadastrado. Por favor, insira um email único.");
                email = ""; // Limpa o email para forçar nova entrada
            }
        } while (email.trim().isEmpty() || !email.contains("@") || !email.contains(".") || email.isEmpty());
        // Adiciona email.isEmpty() para tratar o caso de email duplicado

        String telefone;
        do {
            System.out.print("Telefone (apenas números, mínimo 8 dígitos): ");
            telefone = sc.nextLine();
            // Validação de telefone simples: deve conter apenas números e ter no mínimo 8 dígitos
            if (telefone.trim().isEmpty() || !telefone.matches("\\d+") || telefone.length() < 8) {
                System.out.println("Telefone inválido. Por favor, insira apenas números e no mínimo 8 dígitos.");
            }
        } while (telefone.trim().isEmpty() || !telefone.matches("\\d+") || telefone.length() < 8);

        ids[totalUsuarios] = proximoId;
        nomes[totalUsuarios] = nome;
        emails[totalUsuarios] = email;
        telefones[totalUsuarios] = telefone;

        totalUsuarios++;
        proximoId++; //INCREMENTA O ID PARA O PRÓXIMO USUÁRIO

        System.out.println("Usuário cadastrado com sucesso!");
        s.nextLine();
    }

    //FUNÇÃO PARA VERIFICAR SE O EMAIL JÁ EXISTE
    //Illana Rabelo
    public static boolean emailJaExiste(String email) {
        for (int i = 0; i < totalUsuarios; i++) {
            if (emails[i].equalsIgnoreCase(email)) {
                return true;
            }
        }
        return false;
    }

    //FUNÇÃO PARA LISTAR USUÁRIOS CADASTRADOS
    //Arthur Cavichioli
    public static void listarUsuarios() {
        //VERIFICA SE HÁ USUÁRIOS CADASTRADOS
        if (totalUsuarios == 0) {
            System.out.println("Nenhum usuário cadastrado.");
            return;
        }
        //EXIBE A LISTA DE USUÁRIOS CADASTRADOS
        System.out.println("\n--- Usuários Cadastrados ---");
        for (int i = 0; i < totalUsuarios; i++) {
            System.out.println("ID: " + ids[i]);
            System.out.println("Nome: " + nomes[i]);
            System.out.println("Email: " + emails[i]);
            System.out.println("Telefone: " + telefones[i]);
            System.out.println("----------------------------");
        }
    }
     //FUNÇÃO PARA ALTERAR USUÁRIOS CADASTRADOS
    //Caio Basilio

     public static void alterarUsuario(){
        // Scanner s = new Scanner (System.in); // Usar o scanner global 's'
        int i;//para uso nos for
        if (totalUsuarios == 0){// um if para saber se possui algume usuario cadastrado
            System.out.println("Nenhum usuário cadastrado.");
            return;
        }
        System.out.print("Qual o ID do usuário que deseja ser alterado:");//pergunta o id do usurio para localizar do vetor
        int id = s.nextInt();
        s.nextLine(); //limpar buffer, não sei oq é, porem funcionou depois que coloquei
        int indice = -1;// define esse indice para que possa "segurar" a posição do id
        for (i=0; i<totalUsuarios; i++) {//for para rodar dentro e ver todos os usuarios
            if (ids[i] == id) {
                indice = i;
                break;
            }
        }
        if (indice<=-1) {
            System.out.println("Usuário com ID " + id + " não encontrado.");
            return;
        }
        System.out.println("--- Dados Atuais ---");
        System.out.println("Nome: " + nomes[indice]);
        System.out.println("Email: " + emails[indice]);
        System.out.println("Telefone: " + telefones[indice]);
        System.out.print("Deseja alterar o nome? (S/N)");//pergunta para alteração
        char op = s.next().charAt(0);
        s.nextLine(); //limpar buffer, não sei oq é, porem funcionou depois que coloquei
        if(op =='S'){
            System.out.print("Qual o novo nome? ");
            nomes[indice] = s.nextLine();
        }
        System.out.print("Deseja alterar o e-mail? (S/N)");//pergunta para alteração
        op = s.next().charAt(0);
        s.nextLine(); //limpar buffer, não sei oq é, porem funcionou depois que coloquei
        if(op =='S'){
            System.out.print("Qual o novo e-mail? ");
            emails[indice] = s.nextLine();
        }
        System.out.print("Deseja alterar o telefone? (S/N)");//pergunta para alteração
        op = s.next().charAt(0);
        s.nextLine(); //limpar buffer, não sei oq é, porem funcionou depois que coloquei
        if(op =='S'){
            System.out.print("Qual o novo telefone? ");
            telefones[indice] = s.nextLine();
        }
        System.out.println("Usuário atualizado com sucesso!!!");
    }

    //FUNÇÃO PARA DELETAR USUÁRIOS
    //Caio Basilio
    public static void excluirUsuarios(){
        // Scanner s = new Scanner (System.in); // Usar o scanner global 's'
        int i;//para usar no for
        if (totalUsuarios == 0){// um if para saber se possui algume usuario cadastrado
            System.out.println("Nenhum usuário cadastrado.");
            return;
        }
        System.out.print("Qual o ID do usuário que deseja ser excluido:");//pergunta o id do usurio para localizar do vetor
        int id = s.nextInt();
        s.nextLine(); // Limpar buffer
        int indice = -1;// define esse indice para que possa "segurar" a posição do id
        for (i=0; i<totalUsuarios; i++) {
            if (ids[i] == id) {
                indice = i;
                break;
            }//for para rodar dentro e ver todos os usuarios
        }

        if (indice == -1) { // Verifica se o ID foi encontrado
            System.out.println("Usuário com ID " + id + " não encontrado.");
            return;
        }

        System.out.println("Certeza que deseja excluir o seguinte usuário? (S/N)");//confirmando para que o usuario não delete um diferente
        System.out.println("ID: " + ids[indice]);
        System.out.println("Nome: " + nomes[indice]);
        System.out.println("Email: " + emails[indice]);
        System.out.println("Telefone: " + telefones[indice]);
        char op = s.next().charAt(0);
        s.nextLine(); // Limpar buffer

        if (op == 'S'){
            for (i=indice; i<totalUsuarios-1; i++) {//vai colocar todos os usuarios pos ele para "cima"
                ids[i] = ids[i + 1];
                nomes[i] = nomes[i + 1];
                emails[i] = emails[i + 1];
                telefones[i] = telefones[i + 1];
            }
            totalUsuarios--;
            System.out.println("Usuário deletado com sucesso!!!");
        } else {
            System.out.println("Operação de exclusão cancelada.");
        }
    }


    //----------Funções relacionadas com Ocorrências----------
    // Responsáveis: Illana Rabelo e Lawrenzy Rocha 

    public static void submenuOcorrencias(){

        while(true)
        {
            limparTela();
            imprimirSubMenuOcorrencias();
            int opcao = s.nextInt();
            s.nextLine();

            switch(opcao)
            {
                case 1:
                   cadastrarOcorrencia(s);
                    break;
                case 2:
                   listarOcorrencias();
                   s.nextLine();
                    break;
                case 3:
                   atualizarOcorrencia(s);
                    break;
                case 4:
                    deletarOcorrencia(s);
                    break;
                case 5:
                    return;
                default:
                    limparTela();
                    System.out.println("Opção inválida. Tente novamente!");
                    s.nextLine();
            }
        }
    }

    public static void imprimirSubMenuOcorrencias(){
        System.out.println("----------STRAY PET----------");
        System.out.println("---------OCORRÊNCIAS---------");
        System.out.println("Selecione uma das opções:");
        System.out.println("1 - Cadastrar Ocorrência");
        System.out.println("2 - Listar Ocorrências");
        System.out.println("3 - Atualizar Ocorrência");
        System.out.println("4 - Deletar Ocorrência");
        System.out.println("5 - Voltar ao menu principal");
        System.out.println("-----------------------------");
        System.out.println();
    }

    public static void cadastrarOcorrencia(Scanner sc){

        if (totalOcorrencias >= MAX_OCORRENCIAS) {
            System.out.println("Limite de ocorrências atingido. Não é possível cadastrar mais ocorrências.");
            s.nextLine();
            return;
        }

        System.out.println("\n--- Cadastrar Nova Ocorrência ---");

        String tipo;
        do {
            System.out.print("Tipo da Ocorrência (Ex: Encontrado, Perdido, etc.): ");
            tipo = sc.nextLine();
            if (tipo.trim().isEmpty() || tipo.length() < 3) {
                System.out.println("Tipo de ocorrência inválido. Deve ter no mínimo 3 caracteres.");
            }
        } while (tipo.trim().isEmpty() || tipo.length() < 3);

        String data;
        do {
            System.out.print("Data da Ocorrência (DD/MM/AAAA): ");
            data = sc.nextLine();
            if (!data.matches("\\d{2}/\\d{2}/\\d{4}")) {
                System.out.println("Formato de data inválido. Use DD/MM/AAAA.");
            }
        } while (!data.matches("\\d{2}/\\d{2}/\\d{4}"));

        String local;
        do {
            System.out.print("Local da Ocorrência: ");
            local = sc.nextLine();
            if (local.trim().isEmpty() || local.length() < 5) {
                System.out.println("Local inválido. Deve ter no mínimo 5 caracteres.");
            }
        } while (local.trim().isEmpty() || local.length() < 5);

        String descricao;
        do {
            System.out.print("Descrição do Animal/Ocorrência: ");
            descricao = sc.nextLine();
            if (descricao.trim().isEmpty() || descricao.length() < 10) {
                System.out.println("Descrição inválida. Deve ter no mínimo 10 caracteres.");
            }
        } while (descricao.trim().isEmpty() || descricao.length() < 10);

        int idAnimal = -1;
        System.out.print("Deseja relacionar esta ocorrência a um animal já cadastrado? (S/N): ");
        char relacionar = sc.next().charAt(0);
        sc.nextLine();

        if (relacionar == 'S') {
            boolean idValido = false;
            while (!idValido) {
                System.out.print("Digite o ID do animal cadastrado para relacionar: ");
                if (sc.hasNextInt()) {
                    int tempId = sc.nextInt();
                    sc.nextLine();
                    if (buscarAnimalPorID(tempId)) {
                        idAnimal = tempId;
                        idValido = true;
                    } else {
                        System.out.println("Animal com ID " + tempId + " não encontrado. Tente novamente.");
                    }
                } else {
                    System.out.println("ID inválido. Por favor, digite um número.");
                    sc.nextLine();
                }
            }
        }

        String status = "Aberta";

        id_ocorrencia[totalOcorrencias] = proximoIDOcorrencia;
        tipoOcorrencia[totalOcorrencias] = tipo;
        dataOcorrencia[totalOcorrencias] = data;
        localOcorrencia[totalOcorrencias] = local;
        descricaoOcorrencia[totalOcorrencias] = descricao;
        idAnimalRelacionado[totalOcorrencias] = idAnimal;
        statusOcorrencia[totalOcorrencias] = status;

        totalOcorrencias++;
        proximoIDOcorrencia++;

        System.out.println("Ocorrência cadastrada com sucesso!");
        if (idAnimal != -1) {
            System.out.println("Ocorrência relacionada ao animal ID: " + idAnimal);
        }
        s.nextLine();
    }

    public static void listarOcorrencias(){
        if (totalOcorrencias == 0) {
            System.out.println("Nenhuma ocorrência cadastrada.");
            return;
        }

        System.out.println("\n--- Ocorrências Cadastradas ---");
        for (int i = 0; i < totalOcorrencias; i++) {
            System.out.println("ID Ocorrência: " + id_ocorrencia[i]);
            System.out.println("Tipo: " + tipoOcorrencia[i]);
            System.out.println("Data: " + dataOcorrencia[i]);
            System.out.println("Local: " + localOcorrencia[i]);
            System.out.println("Descrição: " + descricaoOcorrencia[i]);
            System.out.println("Status: " + statusOcorrencia[i]);
            if (idAnimalRelacionado[i] != -1) {
                System.out.println("Animal Relacionado (ID): " + idAnimalRelacionado[i]);
                int indiceAnimal = -1;
                for(int j = 0; j < qtdadeAnimal; j++){
                    if(id_animal[j] == idAnimalRelacionado[i]){
                        indiceAnimal = j;
                        break;
                    }
                }
                if(indiceAnimal != -1){
                    System.out.println("  - Nome do Animal: " + nomeAnimal[indiceAnimal]);
                    System.out.println("  - Espécie: " + especieAnimal[indiceAnimal]);
                    System.out.println("  - Raça: " + racaAnimal[indiceAnimal]);
                }
            } else {
                System.out.println("Animal Relacionado: N/A (Não vinculado a um animal cadastrado)");
            }
            System.out.println("---------------------------------");
        }
    }

    public static void atualizarOcorrencia(Scanner sc) {
        if (totalOcorrencias == 0) {
            System.out.println("Nenhuma ocorrência cadastrada.");
            s.nextLine();
            return;
        }

        System.out.print("Digite o ID da ocorrência que deseja alterar: ");
        int idOcorrenciaAlterar = sc.nextInt();
        sc.nextLine();

        int indiceOcorrencia = -1;
        for (int i = 0; i < totalOcorrencias; i++) {
            if (id_ocorrencia[i] == idOcorrenciaAlterar) {
                indiceOcorrencia = i;
                break;
            }
        }

        if (indiceOcorrencia == -1) {
            System.out.println("Ocorrência com ID " + idOcorrenciaAlterar + " não encontrada.");
            s.nextLine();
            return;
        }

        while (true) {
            limparTela();
            System.out.println("\n--- Atualizar Ocorrência (ID: " + idOcorrenciaAlterar + ") ---");
            System.out.println("1 - Tipo da Ocorrência");
            System.out.println("2 - Data da Ocorrência");
            System.out.println("3 - Local da Ocorrência");
            System.out.println("4 - Descrição da Ocorrência");
            System.out.println("5 - Animal Relacionado");
            System.out.println("6 - Status da Ocorrência");
            System.out.println("7 - Voltar ao menu de Ocorrências");
            System.out.print("Escolha uma opção para alterar: ");

            int escolha = sc.nextInt();
            sc.nextLine();

            switch (escolha) {
                case 1:
                    String novoTipo;
                    do {
                        System.out.print("Novo Tipo da Ocorrência: ");
                        novoTipo = sc.nextLine();
                        if (novoTipo.trim().isEmpty() || novoTipo.length() < 3) {
                            System.out.println("Tipo de ocorrência inválido. Deve ter no mínimo 3 caracteres.");
                        }
                    } while (novoTipo.trim().isEmpty() || novoTipo.length() < 3);
                    tipoOcorrencia[indiceOcorrencia] = novoTipo;
                    System.out.println("Tipo da ocorrência atualizado com sucesso!");
                    break;
                case 2:
                    String novaData;
                    do {
                        System.out.print("Nova Data da Ocorrência (DD/MM/AAAA): ");
                        novaData = sc.nextLine();
                        if (!novaData.matches("\\d{2}/\\d{2}/\\d{4}")) {
                            System.out.println("Formato de data inválido. Use DD/MM/AAAA.");
                        }
                    } while (!novaData.matches("\\d{2}/\\d{2}/\\d{4}"));
                    dataOcorrencia[indiceOcorrencia] = novaData;
                    System.out.println("Data da ocorrência atualizada com sucesso!");
                    break;
                case 3:
                    String novoLocal;
                    do {
                        System.out.print("Novo Local da Ocorrência: ");
                        novoLocal = sc.nextLine();
                        if (novoLocal.trim().isEmpty() || novoLocal.length() < 5) {
                            System.out.println("Local inválido. Deve ter no mínimo 5 caracteres.");
                        }
                    } while (novoLocal.trim().isEmpty() || novoLocal.length() < 5);
                    localOcorrencia[indiceOcorrencia] = novoLocal;
                    System.out.println("Local da ocorrência atualizado com sucesso!");
                    break;
                case 4:
                    String novaDescricao;
                    do {
                        System.out.print("Nova Descrição do Animal/Ocorrência: ");
                        novaDescricao = sc.nextLine();
                        if (novaDescricao.trim().isEmpty() || novaDescricao.length() < 10) {
                            System.out.println("Descrição inválida. Deve ter no mínimo 10 caracteres.");
                        }
                    } while (novaDescricao.trim().isEmpty() || novaDescricao.length() < 10);
                    descricaoOcorrencia[indiceOcorrencia] = novaDescricao;
                    System.out.println("Descrição da ocorrência atualizada com sucesso!");
                    break;
                case 5:
                    int novoIdAnimal = -1;
                    System.out.print("Deseja relacionar a um animal existente? (S/N): ");
                    char relacionar = sc.next().charAt(0);
                    sc.nextLine();

                    if (relacionar == 'S') {
                        boolean idValido = false;
                        while (!idValido) {
                            System.out.print("Digite o NOVO ID do animal cadastrado para relacionar: ");
                            if (sc.hasNextInt()) {
                                int tempId = sc.nextInt();
                                sc.nextLine();
                                if (buscarAnimalPorID(tempId)) {
                                    novoIdAnimal = tempId;
                                    idValido = true;
                                } else {
                                    System.out.println("Animal com ID " + tempId + " não encontrado. Tente novamente.");
                                }
                            } else {
                                System.out.println("ID inválido. Por favor, digite um número.");
                                sc.nextLine();
                            }
                        }
                    }
                    idAnimalRelacionado[indiceOcorrencia] = novoIdAnimal;
                    System.out.println("Animal relacionado atualizado com sucesso!");
                    break;
                case 6:
                    String novoStatus;
                    do {
                        System.out.print("Novo Status da Ocorrência (Ex: Aberta, Resolvida, Fechada): ");
                        novoStatus = sc.nextLine();
                        if (novoStatus.trim().isEmpty() || novoStatus.length() < 3) {
                            System.out.println("Status inválido. Deve ter no mínimo 3 caracteres.");
                        }
                    } while (novoStatus.trim().isEmpty() || novoStatus.length() < 3);
                    statusOcorrencia[indiceOcorrencia] = novoStatus;
                    System.out.println("Status da ocorrência atualizado com sucesso!");
                    break;
                case 7:
                    System.out.println("Voltando ao menu de Ocorrências.");
                    s.nextLine();
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
            System.out.println("Pressione Enter para continuar...");
            s.nextLine();
        }
    }

    public static void deletarOcorrencia(Scanner sc) {
        if (totalOcorrencias == 0) {
            System.out.println("Nenhuma ocorrência cadastrada.");
            s.nextLine();
            return;
        }

        System.out.print("Digite o ID da ocorrência que deseja deletar: ");
        int idParaDeletar = sc.nextInt();
        sc.nextLine();

        int indiceOcorrencia = -1;
        for (int i = 0; i < totalOcorrencias; i++) {
            if (id_ocorrencia[i] == idParaDeletar) {
                indiceOcorrencia = i;
                break;
            }
        }

        if (indiceOcorrencia == -1) {
            System.out.println("Ocorrência com ID " + idParaDeletar + " não encontrada.");
            s.nextLine();
            return;
        }

        System.out.println("\n--- Detalhes da Ocorrência a Ser Deletada ---");
        System.out.println("ID Ocorrência: " + id_ocorrencia[indiceOcorrencia]);
        System.out.println("Tipo: " + tipoOcorrencia[indiceOcorrencia]);
        System.out.println("Data: " + dataOcorrencia[indiceOcorrencia]);
        System.out.println("Local: " + localOcorrencia[indiceOcorrencia]);
        System.out.println("Descrição: " + descricaoOcorrencia[indiceOcorrencia]);
        System.out.println("Status: " + statusOcorrencia[indiceOcorrencia]);
        if (idAnimalRelacionado[indiceOcorrencia] != -1) {
            System.out.println("Animal Relacionado (ID): " + idAnimalRelacionado[indiceOcorrencia]);
        } else {
            System.out.println("Animal Relacionado: N/A");
        }
        System.out.println("---------------------------------------------");

        System.out.print("Deseja continuar com a exclusão desta ocorrência? (S/N): ");
        char confirmacao = sc.next().charAt(0);
        sc.nextLine();

        if (confirmacao == 'S') {
            for (int i = indiceOcorrencia; i < totalOcorrencias - 1; i++) {
                id_ocorrencia[i] = id_ocorrencia[i + 1];
                tipoOcorrencia[i] = tipoOcorrencia[i + 1];
                dataOcorrencia[i] = dataOcorrencia[i + 1];
                localOcorrencia[i] = localOcorrencia[i + 1];
                descricaoOcorrencia[i] = descricaoOcorrencia[i + 1];
                idAnimalRelacionado[i] = idAnimalRelacionado[i + 1];
                statusOcorrencia[i] = statusOcorrencia[i + 1];
            }
            totalOcorrencias--;
            System.out.println("Ocorrência deletada com sucesso!");
        } else {
            System.out.println("Operação de exclusão de ocorrência cancelada.");
        }
        s.nextLine();
    }

    // Função auxiliar para verificar se um animal existe pelo ID
    public static boolean buscarAnimalPorID(int id){
        for(int i = 0; i < qtdadeAnimal; i++){
            if(id_animal[i] == id){
                return true;
            }
        }
        return false;
    }
}


//CLASSES e SUBCLASSES
//Responsável: Thiago Ferreira Rocha
class TutorData {

        static int proximoid = 1;
        int id;

        String nomeCompleto;
        String nomeUsuario;
        String genero;
        String email;
        int dia; int mes; int ano;
        int enderecoCEP;
        long telefone;
        int senha;

        public TutorData(String nomeCompleto, String nomeUsuario, String genero, String email, int dia, int mes, int ano, int enderecoCEP, long telefone,
        int senha){
            this.id = proximoid++;
            this.nomeCompleto = nomeCompleto;
            this.nomeUsuario = nomeUsuario;
            this.genero = genero;
            this.email = email;
            this.dia = dia;
            this.mes = mes;
            this.ano = ano;
            this.enderecoCEP = enderecoCEP;
            this.telefone = telefone;
            this.senha = senha;
        }

        @Override
        public String toString() {
            return " | ID: " + id + " | Tutor: " + nomeCompleto + " | Usuário: " + nomeUsuario + " | Gênero: " + genero +
               " | Data Nasc: " + dia + "/" + mes + "/" + ano + " | CEP: " + enderecoCEP + " | E-mail: " + email + " | Telefone: " + telefone;
        }
}