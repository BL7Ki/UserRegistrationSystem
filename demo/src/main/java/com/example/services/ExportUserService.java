package com.example.services;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.example.dao.DataBaseConnection;

public class ExportUserService {

    public void exportToCSV(String filePath) {
        String sql = "SELECT id, nome, email, senha FROM usuarios";

        try (Connection conexao = DataBaseConnection.getConnection();
             Statement stmt = conexao.createStatement();
             ResultSet resultSet = stmt.executeQuery(sql);
             PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {

            // Cabeçalho do CSV
            writer.println("ID,Name,Email,Password");

            // Itera pelos registros do banco
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("nome");
                String email = resultSet.getString("email");
                String password = resultSet.getString("senha"); // expondo a senha em testes

                // Escreve os dados no arquivo CSV
                writer.printf("%d,%s,%s,%s%n", id, name, email, password);
            }

            System.out.println("Dados exportados para o arquivo CSV com sucesso!");

        } catch (SQLException | IOException e) {
            System.err.println("Erro ao exportar os dados: " + e.getMessage());
        }
    }
}
