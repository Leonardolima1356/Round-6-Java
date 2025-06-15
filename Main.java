import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Participante> participantes = new ArrayList<>();
    static ArrayList<Local> locais = new ArrayList<>();
    static ArrayList<Desafio> desafios = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int opcao;

        do {
            System.out.println("\n==== MENU ====");
            System.out.println("1 - Cadastrar Participante");
            System.out.println("2 - Cadastrar Local");
            System.out.println("3 - Cadastrar Desafio");
            System.out.println("4 - Editar/Excluir Participante");
            System.out.println("5 - Editar/Excluir Desafio");
            System.out.println("6 - Visualizar Participantes");
            System.out.println("7 - Visualizar Desafios");
            System.out.println("8 - Visualizar Locais");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1: cadastrarParticipante(sc);
                    break;
                case 2: cadastrarLocal(sc);
                    break;
                case 3: cadastrarDesafio(sc);
                    break;
                case 4: editarOuExcluirParticipante(sc);
                    break;
                case 5: editarOuExcluirDesafio(sc);
                    break;
                case 6: visualizarParticipantes();
                    break;
                case 7: visualizarDesafios();
                    break;
                case 8: visualizarLocais();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);

        sc.close();
    }

    public static void cadastrarParticipante(Scanner sc) {
        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("Número: ");
        int numero = sc.nextInt();
        sc.nextLine();
        System.out.print("Idade: ");
        int idade = sc.nextInt();
        sc.nextLine();
        System.out.print("Data de Nascimento: ");
        String dataNascimento = sc.nextLine();
        System.out.print("Gênero (Masculino/Feminino): ");
        String genero = sc.nextLine();
        System.out.print("Endereço: ");
        String endereco = sc.nextLine();

        participantes.add(new Participante(nome, numero, idade, dataNascimento, genero, endereco));
        System.out.println("Participante cadastrado com sucesso!");
    }

    public static void cadastrarLocal(Scanner sc) {
        System.out.print("Nome do Local: ");
        String nome = sc.nextLine();
        System.out.print("Capacidade Máxima: ");
        int capacidade = sc.nextInt();
        sc.nextLine();

        locais.add(new Local(nome, capacidade));
        System.out.println("Local cadastrado com sucesso!");
    }

    public static void cadastrarDesafio(Scanner sc) {
        if (desafios.size() >= 5) {
            System.out.println("Limite de 5 desafios atingido.");
            return;
        }

        System.out.print("Nome do Desafio: ");
        String nome = sc.nextLine();
        System.out.print("Número mínimo de participantes: ");
        int minimo = sc.nextInt();
        System.out.print("Número máximo de aprovados: ");
        int maximo = sc.nextInt();
        sc.nextLine();

        if (locais.isEmpty()) {
            System.out.println("Cadastre pelo menos um local primeiro.");
            return;
        }

        System.out.println("Locais disponíveis:");
        for (int i = 0; i < locais.size(); i++) {
            System.out.println(i + " - " + locais.get(i));
        }

        System.out.print("Escolha o local pelo número: ");
        int indiceLocal = sc.nextInt();
        sc.nextLine();

        if (indiceLocal < 0 || indiceLocal >= locais.size()) {
            System.out.println("Local inválido.");
            return;
        }

        Local localSelecionado = locais.get(indiceLocal);

        if (localSelecionado.getCapacidadeMaxima() < minimo) {
            System.out.println("Capacidade do local é inferior ao mínimo de participantes.");
            return;
        }

        ArrayList<String> regras = new ArrayList<>();
        String regra;
        do {
            System.out.print("Digite uma regra (ou 'fim' para encerrar): ");
            regra = sc.nextLine();
            if (!regra.equalsIgnoreCase("fim")) {
                regras.add(regra);
            }
        } while (!regra.equalsIgnoreCase("fim"));

        desafios.add(new Desafio(nome, minimo, maximo, regras, localSelecionado));
        System.out.println("Desafio cadastrado com sucesso!");
    }

    public static void editarOuExcluirParticipante(Scanner sc) {
        if (participantes.isEmpty()) {
            System.out.println("Nenhum participante cadastrado.");
            return;
        }

        visualizarParticipantes();
        System.out.print("Escolha o número do participante para editar ou excluir: ");
        int numero = sc.nextInt();
        sc.nextLine();

        Participante participante = null;
        for (Participante p : participantes) {
            if (p.getNumero() == numero) {
                participante = p;
                break;
            }
        }

        if (participante == null) {
            System.out.println("Participante não encontrado.");
            return;
        }

        System.out.println("1 - Editar");
        System.out.println("2 - Excluir");
        System.out.print("Escolha uma opção: ");
        int escolha = sc.nextInt();
        sc.nextLine();

        if (escolha == 1) {
            System.out.print("Novo Nome: ");
            participante.setNome(sc.nextLine());
            System.out.print("Nova Idade: ");
            participante.setIdade(sc.nextInt());
            sc.nextLine();
            System.out.print("Nova Data de Nascimento (dd/mm/aaaa): ");
            participante.setDataNascimento(sc.nextLine());
            System.out.print("Novo Gênero (Masculino/Feminino): ");
            participante.setGenero(sc.nextLine());
            System.out.print("Novo Endereço: ");
            participante.setEndereco(sc.nextLine());

            System.out.println("Participante editado com sucesso.");
        } else if (escolha == 2) {
            participantes.remove(participante);
            System.out.println("Participante removido com sucesso.");
        } else {
            System.out.println("Opção inválida.");
        }
    }

    public static void editarOuExcluirDesafio(Scanner sc) {
        if (desafios.isEmpty()) {
            System.out.println("Nenhum desafio cadastrado.");
            return;
        }

        visualizarDesafios();
        System.out.print("Escolha o índice do desafio para editar ou excluir: ");
        int indice = sc.nextInt();
        sc.nextLine();

        if (indice < 0 || indice >= desafios.size()) {
            System.out.println("Desafio não encontrado.");
            return;
        }

        System.out.println("1 - Editar");
        System.out.println("2 - Excluir");
        System.out.print("Escolha uma opção: ");
        int escolha = sc.nextInt();
        sc.nextLine();

        if (escolha == 1) {
            cadastrarDesafio(sc);
            desafios.remove(indice);
            System.out.println("Desafio editado.");
        } else if (escolha == 2) {
            desafios.remove(indice);
            System.out.println("Desafio removido.");
        } else {
            System.out.println("Opção inválida.");
        }
    }

    public static void visualizarParticipantes() {
        System.out.println("\n---- PARTICIPANTES ----");
        for (Participante p : participantes) {
            System.out.println(p);
        }
    }

    public static void visualizarDesafios() {
        System.out.println("\n---- DESAFIOS ----");
        for (int i = 0; i < desafios.size(); i++) {
            System.out.println(i + " - " + desafios.get(i));
        }
    }

    public static void visualizarLocais() {
        System.out.println("\n---- LOCAIS ----");
        for (Local l : locais) {
            System.out.println(l);
        }
    }
}
