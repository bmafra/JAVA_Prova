package prova.view;

import prova.controller.PlanosController;
import prova.model.entities.Operadora;
import prova.model.entities.Planos;
import prova.model.factory.OperadoraFactory;

import java.util.Scanner;

/**
 * Esse sistema é uma aplicação para operadoras de telecomunicação, onde podem
 * registar seus planos, atualizar, remover e listar.
 *
 * @author bruna_a_mafra
 */

public class Main {
    static Scanner sc = new Scanner(System.in);
    static PlanosController planosController = new PlanosController();

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        System.out.println("O que deseja fazer?" +
                "\n1 - Cadastrar plano" +
                "\n2 - Atualizar plano" +
                "\n3 - Remover plano" +
                "\n4 - Listar planos");

        int opcao = sc.nextInt();

        switch (opcao) {
            case 1 -> {
                cadastrarPlanos();
            }
            case 2 -> {
                atualizarPlanos();
            }
            case 3 -> {
                removerPlanos();
            }
            case 4 -> {
                listarPlanos();
            }
        }
    }

    public static void cadastrarPlanos() {
        System.out.println("\nInforme os dados:" +
                "\nOperadora: " +
                "\n1 - vivo" +
                "\n2 - tim" +
                "\n3 - oi" +
                "\n4 - claro");
        int opcao = sc.nextInt();

        if (!(opcao > 1) && !(opcao < 4)) {
            System.out.print("\nNúmero inválido!");
        }

        Operadora operadora = new OperadoraFactory().getOperadora(opcao);

        System.out.print("ID: ");
        Integer id = sc.nextInt();

        System.out.print("Nome: ");
        String nome = sc.next();

        System.out.print("Quantidade de dados: ");
        Integer qtdDados = sc.nextInt();

        System.out.print("Quantidade de dados bônus: ");
        Integer qtdBonus = sc.nextInt();

        System.out.print("Beneficios: ");
        String beneficios = sc.next();

        System.out.print("Valor: ");
        Double valor = sc.nextDouble();

        try {
            planosController.cadastrarPlanos(id, qtdDados, qtdBonus, nome, operadora, beneficios, valor);
        } catch (RuntimeException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public static void atualizarPlanos() {
        System.out.println("\nQual o ID do plano: ");
        Integer id = sc.nextInt();

        System.out.println("\nAtualiza os dados:" +
                "\nOperadora: " +
                "\n1 - vivo" +
                "\n2 - tim" +
                "\n3 - oi" +
                "\n4 - claro");
        int opcao = sc.nextInt();

        if (!(opcao > 1) && !(opcao < 4)) {
            System.out.print("\nNúmero inválido!");
        }

        Operadora operadora = new OperadoraFactory().getOperadora(opcao);

        System.out.print("Nome: ");
        String nome = sc.next();

        System.out.print("Quantidade de dados: ");
        Integer qtdDados = sc.nextInt();

        System.out.print("Quantidade de dados bônus: ");
        Integer qtdBonus = sc.nextInt();

        System.out.print("Beneficios: ");
        String beneficios = sc.next();

        System.out.print("Valor: ");
        Double valor = sc.nextDouble();

        try {
            planosController.atualizarPlanos(id, qtdDados, qtdBonus, nome, operadora, beneficios, valor);
        } catch (RuntimeException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public static void removerPlanos() {
        System.out.println("\nInforme o identificador do planos que deseja remover: ");
        Integer id = sc.nextInt();

        try {
            planosController.removerPlanos(id);
        } catch (RuntimeException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public static void listarPlanos() {
        System.out.println("\nDeseja lista:" +
                "\n1 - Todos os planos de uma operadora" +
                "\n2 - Todos planos de todas operadoras" +
                "\n3 - Por identificador");
        int opcao = sc.nextInt();
        
        switch (opcao) {
            case 1 -> {
                listarPlanosOperadora();
            }
            case 2 -> {
                listarTodosPlanos();
            }
            case 3 -> {
                listarPlanoID();
            }
        }
    }

    public static void listarPlanosOperadora() {
        System.out.println("Informe operadora dejesa listar: " +
                "\n1 - vivo" +
                "\n2 - tim" +
                "\n3 - oi" +
                "\n4 - claro");
        String operadora = sc.next();

        try {
            planosController.listarPlanosOperadora(operadora);
        } catch (RuntimeException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public static void listarTodosPlanos() {
        try {
            planosController.listarTodosPlanos();
        } catch (RuntimeException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public static void listarPlanoID() {
        System.out.println("\nQual ID deseja listar: ");
        Integer id = sc.nextInt();

        try {
            planosController.listarPlanoID(id);
        } catch (RuntimeException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
