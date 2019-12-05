 package mvc;

import mvc.control.CadastroClienteControl;
import mvc.model.ClienteModel;
import mvc.view.CadastroClienteView;

public class Main {

	public static void main(String[] args) {
		ClienteModel cliente = new ClienteModel();
		
		CadastroClienteControl control = new CadastroClienteControl(new CadastroClienteView(),cliente);
		control.exibirTela();

	}

}