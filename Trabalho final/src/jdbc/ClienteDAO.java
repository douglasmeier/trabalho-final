package jdbc;

import mvc.model.ClienteModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO extends BasicoDAO {

    public void insert(ClienteModel Cliente) {

        String sql = "INSERT INTO cliente(nomeCliente, telefone, cpfCliente, emailCliente) values(?,?,?,?)";

        try (Connection conn = getConnection();
             PreparedStatement statement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            statement.setString(1, Cliente.getNomeCliente());
            statement.setString(2, Cliente.getTelefone());
            statement.setString(3, Cliente.getCpfCliente());
            statement.setString(4, Cliente.getEmailCliente());
            statement.execute();
            
            ResultSet id_gerada = statement.getGeneratedKeys();
            if (id_gerada.next()) {
                int id = id_gerada.getInt(1);
                Cliente.setIdCliente(id);
            }
            
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(ClienteModel Cliente) {

        String sql = "DELETE FROM cliente where idCliente = ?";

        try(Connection conn = getConnection();
            PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, Cliente.getIdCliente());
            statement.execute();
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void update(ClienteModel Cliente) {
        String sql = "UPDATE cliente SET nomeCliente = ?, telefone = ?, cpfCliente = ?, emailCliente = ? WHERE idCliente = ?";

        try (Connection conn = getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)){
            statement.setString(1, Cliente.getNomeCliente());
            statement.setString(2, Cliente.getTelefone());
            statement.setString(3, Cliente.getCpfCliente());
            statement.setString(4, Cliente.getEmailCliente());
            statement.setInt(5, Cliente.getIdCliente());
            statement.execute();
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    public List<ClienteModel> getAll(){
        List<ClienteModel> list = new ArrayList<>();
        String sql = "SELECT nomeCliente, telefone, cpfCliente, emailCliente FROM ClienteModel";

        try(Connection conn = getConnection();
            PreparedStatement statement = conn.prepareStatement(sql)) {
            ResultSet resultado = statement.executeQuery();
            while(resultado.next()) {
                ClienteModel cliente = new ClienteModel();
                cliente.setNomeCliente(resultado.getString(1));
                cliente.setTelefone(resultado.getString(2));
                cliente.setCpfCliente(resultado.getString(3));;
                cliente.setEmailCliente(resultado.getString(4));
                
                list.add(cliente);
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
        return list;
    }

}
