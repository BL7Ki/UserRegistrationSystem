package com.example.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.example.dao.DataBaseConnection;

public class CreateUserService {

    public void create(String nome) {
        String sql = "INSERT INTO usuarios (nome) VALUES (?)";
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
