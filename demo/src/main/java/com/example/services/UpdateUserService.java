package com.example.services;

import com.example.dao.DataBaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateUserService {

    public void update(int id, String novoNome) {
        String sql = "UPDATE nome_da_tabela SET nome = ? WHERE id = ?";
        try (Connection conexao = DataBaseConnection.getConnection();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, novoNome);
            stmt.setInt(2, id);
            stmt.executeUpdate();
            System.out.println("Registro atualizado com sucesso!");

        } catch (SQLException ex) {
            System.err.println("Erro ao atualizar registro: " + ex.getMessage());
        }
    }
}
