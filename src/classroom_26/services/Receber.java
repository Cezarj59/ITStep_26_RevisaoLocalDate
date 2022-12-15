package classroom_26.services;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.InputMismatchException;
import java.util.Scanner;
import static javax.print.attribute.Size2DSyntax.MM;

public class Receber {

    public static String texto() {
        Scanner leia = new Scanner(System.in);

        return leia.nextLine();
    }

    public static LocalDate data() {

        while (true) {

            try {
                Scanner leia = new Scanner(System.in);
                String dataRecebida = leia.nextLine();

                DateTimeFormatter formatoBr = DateTimeFormatter.ofPattern("aaaa MM dd");
                
                LocalDate parsedDate = LocalDate.parse(dataRecebida, formatoBr);

                return parsedDate;
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

    }

    public static int inteiro() {

        int valor = 0;

        while (true) {
            try {
                Scanner leia = new Scanner(System.in);
                valor = leia.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Tente novamente, apenas com números!");
                System.out.print("Informe novamente o valor: ");
            }
        }

        return valor;
    }

    public static double numeroDecimal() {

        double valor = 0;

        while (true) {
            try {
                Scanner leia = new Scanner(System.in);
                valor = leia.nextDouble();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Tente novamente, apenas com números!");
                System.out.print("Informe novamente o valor: ");
            }
        }

        return valor;
    }
}
