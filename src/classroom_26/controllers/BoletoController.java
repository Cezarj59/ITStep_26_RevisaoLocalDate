package classroom_26.controllers;

import classroom_26.services.BancoDados;
import classroom_26.Models.Boleto;
import classroom_26.services.Receber;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;

public class BoletoController {
    
    
    
    
//     public static Boleto cadastrar() {
//        Boleto b = new Boleto();
//        System.out.println("\nCADASTRAR NOVO BOLETO\n");
//
//        System.out.print("Informe o Valor: ");
//        b.setValor(Receber.numeroDecimal());
//
//      
//
//        return c;
//    }
    
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
