package com.example.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.example.dao.DataBaseConnection;

public class CreateUserService {

    public void create(String nome, String email, String password) {
        // Verifique se o email e a senha são válidos antes de inserir
        if (nome == null || nome.trim().isEmpty() || nome.length() < 3 || nome.length() > 50) {
            throw new IllegalArgumentException("Nome inválido.");
        }
        if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException("Email inválido.");
        }
        if (password == null || password.length() < 8) {
            throw new IllegalArgumentException("Senha inválida.");
        }

        String sql = "INSERT INTO usuarios (id, nome, email, senha) VALUES (?, ?, ?, ?)";
        try (Connection conexao = DataBaseConnection.getConnection();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, 0);
            stmt.setString(2, nome);
            stmt.setString(3, email);
            stmt.setString(4, password);

            stmt.executeUpdate();
            System.out.println("Registro inserido com sucesso!");

        } catch (SQLException ex) {
            System.err.println("Erro ao inserir registro: " + ex.getMessage());
        }
    }
}
