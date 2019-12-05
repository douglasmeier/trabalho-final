package jdbc;

import java.sql.Connection;

public abstract class BasicoDAO {
		
	public Connection getConnection() {
		return FabricaDeConexoes.getInstance().getConnection();
	}

}
