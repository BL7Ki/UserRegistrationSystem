package com.example.dao;

import java.sql.DriverManager;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;

import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.xdevapi.Result;

public class DataBaseConnection {
    public static void main(String[] args) {
        Connection conexao = null;

        try {
            Class.forName("com.mysql.jdbc.Driver"); // Driver do MySQL
            conexao = DriverManager.getConnection( // criando a conexao
            "jdbc:mysql://localhost:3306/nome_do_banco", "root", "root");
            Resultset result = conexao.createStatement().executeQuery("SELECT * FROM nome_da_tabela"); // retornando os dados da tabela
            while (result.next()) {
                System.out.println("Nome: " + result.getString("nome"));
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver não encontrado: " + ex.getMessage());    
        }   
        catch(SQLException ex) {
            System.out.println("Erro de conexão: " + ex.getMessage());
    } finally {
        if (conexao != null) { // diferente de nulo significa que a conexao existe
            try {
                conexao.close();
            } catch (SQLException ex) {
                System.out.println("Erro ao fechar a conexão: " + ex.getMessage());
            }
        }
    }
    }
}
