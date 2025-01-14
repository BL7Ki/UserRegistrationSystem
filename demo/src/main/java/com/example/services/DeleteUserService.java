package com.example.services;

import com.example.dao.DataBaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteUserService {

    public void delete(int id) {
        String sql = "DELETE FROM nome_da_tabela WHERE id = ?";
        try (Connection conexao = DataBaseConnection.getConnection();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Registro excluído com sucesso!");

        } catch (SQLException ex) {
            System.err.println("Erro ao excluir registro: " + ex.getMessage());
        }
    }
}
