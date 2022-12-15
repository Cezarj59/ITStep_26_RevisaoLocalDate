package classroom_26.views;

import classroom_26.Models.Boleto;
import classroom_26.controllers.BoletoController;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public class Views {

    public static void todosBoletos() {
        ArrayList<Boleto> lista = BoletoController.getAll();

        for (Boleto b : lista) {
            if (b.getData().isAfter(LocalDate.now())) {
                System.out.println(b.toString());
                System.out.println("Total de Dias para o Vencimento: " + contaDias(b.getData()));
                System.out.println("Periodo para o Vencimento: " + periodoData(b.getData()));
                System.out.println("-------------------------");
            } else {
                System.out.println(b.toString());
                System.out.println("Total de Dias em atraso: " + contaDias(b.getData()));
                System.out.println("Periodo em Atraso: " + periodoData(b.getData()));
                System.out.println("-------------------------");
            }

        }

    }

    public static void boletoEmAtraso() {
        ArrayList<Boleto> lista = BoletoController.getAll();

        for (Boleto b : lista) {
            if (b.getData().isBefore(LocalDate.now())) {
                System.out.println(b.toString());
                System.out.println("Total de Dias em atraso: " + contaDias(b.getData()));
                System.out.println("Periodo em Atraso: " + periodoData(b.getData()));
                System.out.println("-------------------------");

            }
        }

    }

    public static void boletoEmDia() {
        ArrayList<Boleto> lista = BoletoController.getAll();

        for (Boleto b : lista) {
            if (b.getData().isAfter(LocalDate.now())) {

                System.out.println(b.toString());
                System.out.println("Total de Dias para o Vencimento: " + contaDias(b.getData()));
                System.out.println("Periodo para o Vencimento: " + periodoData(b.getData()));
                System.out.println("-------------------------");

            }
        }

    }

    private static int contaDias(LocalDate dataBoleto) {
        LocalDate hoje = LocalDate.now();
        dataBoleto.getDayOfYear();//Dia do ano da data do Boleto. 
        hoje.getDayOfYear();//Dia do ano data Atual.

        if (dataBoleto.isAfter(hoje)) {
            LocalDate aux = dataBoleto;
            dataBoleto = hoje;
            hoje = aux;
        }

        int dias = hoje.getDayOfYear() - dataBoleto.getDayOfYear();

        if (dias < 0) {
            dias *= -1; // só para garantir dias positivos;
        }

        for (int ano = dataBoleto.getYear(); ano < hoje.getYear(); ano++) {
            dias += 365;
            LocalDate dia = LocalDate.of(ano, 01, 01);
            if (dia.isLeapYear()) {//verificando se o ano é bissexto
                dias++; //adicionando o dia 29/02 na contagem
            }
        }

        return dias;
    }

    private static String periodoData(LocalDate dataBoleto) {
        LocalDate hoje = LocalDate.now();

        if (dataBoleto.isAfter(hoje)) {
            LocalDate aux = dataBoleto;
            dataBoleto = hoje;
            hoje = aux;
        }

        Period periodo = Period.between(dataBoleto, hoje);

        return periodo.getDays() + " Dias" + ", " + periodo.getMonths() + " Meses" + ", " + periodo.getYears() + " Anos";
    }
}
