package classroom_26.Models;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Boleto {

    private int id;
    private double valor;
    private LocalDate data;

    public Boleto() {
    }

    public Boleto(int id, double valor, LocalDate data) {
        this.id = id;
        this.valor = valor;
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    @Override
    public String toString() {        
        return "\nID Boleto: " + getId() + "\nValor: R$ " + getValor() + "\nData de Vencimento: " + formatData(data);
    }

     public static String formatData(LocalDate data) {
        DateTimeFormatter formatoBr = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG );

        return formatoBr.format(data);
    }
}
