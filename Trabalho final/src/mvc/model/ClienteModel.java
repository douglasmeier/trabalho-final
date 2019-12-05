package mvc.model;


import java.util.ArrayList;
import java.util.List;

import jdbc.ClienteDAO;
import mvc.util.Observer;
import mvc.util.Subject;

public class ClienteModel implements  Subject{
	
	private int idCliente;
	private String nomeCliente;
	private String telefone;
	private String cpfCliente;
	private String emailCliente;
	
	private List<Observer> list;
	
	public ClienteModel() {
		list = new ArrayList<Observer>();
	}
	
	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCpfCliente() {
		return cpfCliente;
	}

	public void setCpfCliente(String cpfCliente) {
		this.cpfCliente = cpfCliente;
	}

	public String getEmailCliente() {
		return emailCliente;
	}

	public void setEmailCliente(String emailCliente) {
		this.emailCliente = emailCliente;
	}

	public List<Observer> getList() {
		return list;
	}

	public void setList(List<Observer> list) {
		this.list = list;
	}

	public void novoRegistro() {
		idCliente = 0;
		nomeCliente = null;
		telefone = null;
		cpfCliente = null;
		emailCliente = null;
	}

	@Override
	public void attach(Observer o) {
		list.add(o);
	}

	@Override
	public void detach(Observer o) {
		list.remove(o);
	}

	@Override
	public void notifyObservers() {
		// Avisa cada um dos observadores
		for(Observer o : list) {
			// Atualiza a informacao no observador
			o.update(this, this);
		}
	}
	
	//no ato de salvar, fazemos uma verificação nos dados para ver se não está com os dados inconsistentes.
	public void salvar() throws Exception {
		if(nomeCliente == null || nomeCliente.isEmpty()) {
			throw new Exception("Insira o nome do cliente!");
		}
		if(telefone == null || telefone.isEmpty()) {
			throw new Exception("Insira o telefone!");
		}
		if(cpfCliente == null || cpfCliente.isEmpty()) {
			throw new Exception("Insira o CPF do Cliente");
		}
		
		//se igual a zero ele vai inserir no bd, senao irá atualizar.
		if(idCliente == 0) {
			ClienteDAO Clientedao = new ClienteDAO();	
			Clientedao.insert(this);
		}else {
			// Atualiza no banco de dados
			ClienteDAO Clientedao = new ClienteDAO();
			Clientedao.update(this);
		}
		notifyObservers();
	}
	
	public void deletar() {
		//deleta o cliente no banco de dados
		ClienteDAO Clientedao = new ClienteDAO();	
		Clientedao.delete(this);
		
		novoRegistro();
		notifyObservers();
	}
}