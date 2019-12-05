package mvc.control;

import mvc.model.ClienteModel;
import mvc.view.CadastroClienteView;

public class CadastroClienteControl {
	
	private CadastroClienteView view;
	private ClienteModel model;
	
	public CadastroClienteControl(CadastroClienteView view, ClienteModel model) {
		this.view = view;
		this.model = model;
		model.attach(view);
		view.setModel(model);
		view.setControl(this);
	}
	
	public void exibirTela() {
		view.show();
		model.notifyObservers();
	}
	//deleta o cliente
	public void deletar() {
		model.deletar();
		view.setMensagemStatusBar("Cliente Excluido");
		view.getBotaoDeletar().setEnabled(false);
	} 
	
	//limpa a tela
	public void limpar() {
		model.novoRegistro();
		view.getBotaoDeletar().setEnabled(false);
		view.setMensagemStatusBar("Insira os dados!");
	}
	//salva o cliente
	public void salvar() {
		model.setNomeCliente(view.getNomeCliente());
		model.setTelefone(view.getTelefone());
		model.setCpfCliente(view.getCpfCliente());
		model.setEmailCliente(view.getEmailCliente());

		try {
			model.salvar();
			view.setMensagemStatusBar("Cliente cadastrado com sucesso!");
			view.getBotaoDeletar().setEnabled(true);
		}catch(Exception e) {
			e.printStackTrace();
			view.setMensagemStatusBar("Erro ao Cadastrar: "+e.getMessage());
		}
	}

}
