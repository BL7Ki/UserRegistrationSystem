package com.example.services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.example.dao.DataBaseConnection;

public class ReadUserService {

    public void read() {
        String sql = "SELECT * FROM usuarios";
        try (Connection conexao = DataBaseConnection.getConnection();
             Statement stmt = conexao.createStatement();
             ResultSet resultSet = stmt.executeQuery(sql)) {

            while (resultSet.next()) {
                System.out.println("Nome: " + resultSet.getString("nome"));
                System.out.println("Email: " + resultSet.getString("email"));
                System.out.println("Senha: " + resultSet.getString("senha"));
                System.out.println("--------------------");
            }

        } catch (SQLException ex) {
            System.err.println("Erro ao buscar registros: " + ex.getMessage());
        }
    }
}