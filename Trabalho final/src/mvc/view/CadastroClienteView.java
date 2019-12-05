package mvc.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import mvc.control.CadastroClienteControl;
import mvc.model.ClienteModel;
import mvc.util.Observer;
import mvc.util.Subject;

public class CadastroClienteView extends JFrame implements Observer{

	private ClienteModel model;
	private CadastroClienteControl control;
	
	private JTextField idTextField;
	private JTextField nomeTextField;
	private JTextField telefoneTextField;
	private JTextField cpfTextField;
	private JTextField emailTextField;
	private JButton    salvarButton;
	private JButton    limparButton;
	private JButton    deletarButton;
	private JLabel statusLabel;
	
	public CadastroClienteView() {
		// Titulo Janela
		setTitle("Registro de Clientes");
		// Tamanho Janela
		setSize(400,280);
		// Configura local inicial
		setLocation(1366/2 -400/2, 768/2 - 280/2);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		buildLayout();
	}
	
	public void setModel(ClienteModel model) {
		this.model = model;
	}
	
	public void setControl(CadastroClienteControl control) {
		this.control = control;
	}

	private void buildLayout() {
		JPanel root = new JPanel();
		root.setLayout(new BorderLayout());
		
		
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(20, 20, 0, 20), BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("Preencha os dados abaixo"),BorderFactory.createEmptyBorder(10, 10, 10, 10))));

		idTextField = new JTextField(20);
		idTextField.setEnabled(false);
		nomeTextField = new JTextField(20);
		telefoneTextField = new JTextField(20);
		cpfTextField = new JTextField(20);
		emailTextField = new JTextField(20);
		//botão de salvar
		salvarButton = new JButton("Salvar");
		salvarButton.setToolTipText("Cadastrar Cliente");
		salvarButton.addActionListener(e -> salvar());
		//botão de limpar
		limparButton = new JButton("Limpar");
		limparButton.setToolTipText("Limpar Campos");
		limparButton.addActionListener(e -> limpar());
		//botão de deletar
		deletarButton = new JButton("Deletar");
		deletarButton.setToolTipText("Excluir Cliente");
		deletarButton.setEnabled(true);
		deletarButton.addActionListener(e -> deletar());
		
		//Campo ID
		JLabel l = new JLabel("ID",JLabel.RIGHT);
		l.setPreferredSize(new Dimension(70,16));
		panel.add(l);
		panel.add(idTextField);
		
		//Campo Nome
		l = new JLabel("Nome",JLabel.RIGHT);
		l.setPreferredSize(new Dimension(70,16));
		panel.add(l);
		panel.add(nomeTextField);
		
		//Campo Telefone
		l = new JLabel("Telefone",JLabel.RIGHT);
		l.setPreferredSize(new Dimension(70,16));
		panel.add(l);
		panel.add(telefoneTextField);
		
		//Campo CPF
		l = new JLabel("CPF",JLabel.RIGHT);
		l.setPreferredSize(new Dimension(70,16));
		panel.add(l);
		panel.add(cpfTextField);
		
		//Campo E-mail
		l = new JLabel("E-mail",JLabel.RIGHT);
		l.setPreferredSize(new Dimension(70,16));
		panel.add(l);
		panel.add(emailTextField);
		
		panel.add(limparButton);
		panel.add(salvarButton);
		panel.add(deletarButton);
		
		JPanel statusPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		statusPanel.setBorder(BorderFactory.createEmptyBorder(0, 15, 0, 10));
		statusLabel = new JLabel("Olá, cadastre um cliente.");
		statusPanel.add(statusLabel);
		
		
		root.add(statusPanel,BorderLayout.SOUTH);
		root.add(panel,BorderLayout.CENTER);
		
		add(root);
	}
	
	private void exibirDados() {
		idTextField.setText(Integer.toString(model.getIdCliente()));
		nomeTextField.setText(model.getNomeCliente());		
		telefoneTextField.setText(model.getTelefone());
		cpfTextField.setText(model.getCpfCliente());
		emailTextField.setText(model.getEmailCliente());
		
	}
	
	private void salvar() {
		control.salvar();
	}
	
	private void deletar() {
		control.deletar();
	}
	
	private void limpar() {
		control.limpar();
		idTextField.setText("");
		nomeTextField.setText("");		
		telefoneTextField.setText("");
		cpfTextField.setText("");
		emailTextField.setText("");
	}

	public JButton getBotaoDeletar() {
		return deletarButton;
	}

	public void setMensagemStatusBar(String text) {
		statusLabel.setText(text);
	}

	@Override
	public void update(Subject s, Object o) {
		model = (ClienteModel) o;
		exibirDados();
	}
	
	public String getNomeCliente() {
		return nomeTextField.getText();
	}
	
	public String getTelefone() {
		return telefoneTextField.getText();
	}
	
	public String getCpfCliente() {
		return cpfTextField.getText();
	}
	
	public String getEmailCliente() {
		return emailTextField.getText();
	}
	
}
