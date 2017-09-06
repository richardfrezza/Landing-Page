package com.frezza.richard;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ContatoDao {

    private final static String INSERT = "INSERT INTO contatos (nome, email, telefone, mensagem) VALUES (?, ?, ?, ?)";
    private final static String SEQUENCE = "select nextval('seq_produtos')";

    public Contato insert(Contato prod) {
        try (Connection conn = ConnectionUtils.getConnection()) {
            try (PreparedStatement stm = conn.prepareStatement(INSERT)){
            	stm.setString(1, prod.getNome());
                stm.setString(2, prod.getEmail());
                stm.setString(3, prod.getTelefone());
                stm.setString(4, prod.getMensagem());

                stm.execute();
             }        
        } catch (SQLException ex) {
            Logger.getLogger(ContatoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
