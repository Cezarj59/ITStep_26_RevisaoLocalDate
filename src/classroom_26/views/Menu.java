package classroom_26.views;

import classroom_26.services.Receber;

public class Menu {

    protected static void inicio() {
        while (true) {
            System.out.println("\n-----------------------------");
            System.out.println("----------Boletos-----------");
            System.out.println("-----------------------------\n");

            System.out.println("(0) #SAIR#");
            System.out.println("(1) Cadastrar");
            System.out.println("(2) Consultar");
            System.out.print("Informe a opção desejada: ");

            switch (Receber.inteiro()) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    System.out.println("Em desenvolvimento");
                    break;
                case 2:
                    consultar();
                    break;
                default:
                    System.out.println("\nOpção Invalida!!!\n");
                    ;
            }
        }

    }

    private static void consultar() {
        System.out.println("\n-----------------------------");
        System.out.println("----------CONSULTA-----------");
        System.out.println("-----------------------------\n");

        System.out.println("(1) Todos os Boletos");
        System.out.println("(2) Boletos em Dia");
        System.out.println("(3) Boletos em Atraso");
        System.out.print("Informe a opção desejada: ");

        switch (Receber.inteiro()) {

            case 1 -> {

                System.out.println("\n----------Todos os Boletos-----------");
                Views.todosBoletos();

            }
            case 2 -> {

                System.out.println("\n----------Boletos em Dia-----------");
                Views.boletoEmDia();

            }
            case 3 -> {

                System.out.println("\n----------Boletos em Atraso-----------");
                Views.boletoEmAtraso();
            }

            default ->
                System.out.println("\nOpção Invalida!!!\n");

        }
    }


   
}
