package com.example.services;

import com.example.dao.DataBaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreateUserService {

    public void create(String nome) {
        String sql = "INSERT INTO nome_da_tabela (nome) VALUES (?)";
        try (Connection conexao = DataBaseConnection.getConnection();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, nome);
            stmt.executeUpdate();
            System.out.println("Registro inserido com sucesso!");

        } catch (SQLException ex) {
            System.err.println("Erro ao inserir registro: " + ex.getMessage());
        }
    }
}
