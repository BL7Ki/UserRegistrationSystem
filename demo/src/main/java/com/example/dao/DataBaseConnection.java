package com.example.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/nome_do_banco";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public static void main(String[] args) {

        // Tentativa de conexão
        try (Connection conexao = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = conexao.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM nome_da_tabela")) {

            // Iteração no ResultSet
            while (resultSet.next()) {
                System.out.println("Nome: " + resultSet.getString("nome"));
            }

        } catch (SQLException ex) {
            System.err.println("Erro na conexão ou execução da query: " + ex.getMessage());
            ex.printStackTrace(); // Melhor usar um logger em aplicações reais
        }
    }
}
