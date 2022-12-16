package classroom_26.controllers;

import classroom_26.services.BancoDados;
import classroom_26.Models.Boleto;
import classroom_26.services.Receber;
import java.sql.*;

import java.util.ArrayList;

public class BoletoController {

    public static Boleto cadastrar() {
        Boleto b = new Boleto();
        System.out.println("\nCADASTRAR NOVO BOLETO\n");

        System.out.print("Informe o Valor: ");
        b.setValor(Receber.numeroDecimal());
        System.out.print("Informe a data de vencimento: ");
        b.setData(Receber.data());

        return b;
    }

    public static void addBoleto(Boleto g) {
        Connection conn = BancoDados.conectar();

        try {
            String sql = "INSERT INTO boleto (valor,dataHora) VALUES (?,?)";

            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setDouble(1, g.getValor());
            statement.setDate(2, java.sql.Date.valueOf(g.getData()));//Converte Localdate para date           
            // statement.setString(2, g.getData().toString());//Converte Localdate para String

            if (statement.executeUpdate() > 0) {
                System.out.println("\nBoleto Cadastrado com Sucesso!!!\n");
            } else {
                System.out.println("\nFalha ao Cadastrar o Boleto!!!\n");
            }

        } catch (SQLException e) {
            System.err.println(e);
        }

        BancoDados.fecha(conn);
    }

    public static ArrayList<Boleto> getAll() {
        ArrayList<Boleto> lista = new ArrayList<Boleto>();
        Connection conn = BancoDados.conectar();

        try {
            String sql = "SELECT * FROM boleto";
            Statement statement = conn.createStatement();

            ResultSet resultado = statement.executeQuery(sql);

            while (resultado.next()) {
                lista.add(new Boleto(
                        resultado.getInt("id"),
                        resultado.getDouble("valor"),
                        resultado.getDate("dataHora").toLocalDate()
                ));

            }

        } catch (SQLException e) {
            System.out.println("ERRO AO BUSCAR: " + e);
        }

        BancoDados.fecha(conn);

        return lista;
    }

}
