package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import connection.SingleConnectionBanco;
import model.ModelLogin;

public class DAOLoginRepository {
	
	private Connection connection;
	
	public DAOLoginRepository() {
		connection = SingleConnectionBanco.getConnection();
	}
	
	public boolean validarAutenticacao (ModelLogin modelLogin) throws Exception {
		String sql = "select * from \"Model_login\" where login = ? and senha = ?";
		
		PreparedStatement statement = connection.prepareStatement(sql);
		
		statement.setString(1, modelLogin.getLogin());
		statement.setString(2, modelLogin.getSenha());
		
		ResultSet rs = statement.executeQuery();
		
		if (rs.next()) {
			return true; // autenticado
		}
		return false; //não-autenticado
	}
}
