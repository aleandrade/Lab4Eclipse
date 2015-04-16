/*Alexandre Gomes Andrade RA134762
 * Código que gera um formulario com 13 campos, dos quais alguns são obrigatorios e outros opcionais de serem preenchidos.
 * Se um obrigatório não é preenchido ou é preenchido errado, abre uma janela de aviso e não se abre a tela de impressão.
 * Se um opcional é preenchido errado, abre a janela de aviso mas abre a tela de impressão também.
 * */

package alunos;

import java.awt.BorderLayout;
import java.util.regex.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;
import java.awt.Font;
import java.awt.Canvas;

public class form extends JFrame {

	/*Variaveis usadas e TextFields que receberão as entradas*/
	int valor;
	String novo;
	public JPanel contentPane;
	public JTextField textfirstName;
	public JTextField textlastName;
	private JTextField txtDdmmaaaa;
	private JTextField textEmail;
	private JTextField textCPF;
	private JTextField txtPhone;
	private JTextField textAddress1;
	private JTextField txtAddress2;
	private JTextField textCEP;
	private JTextField textCity;
	private JTextField textState;
	private JTextField textCountry;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					form frame = new form();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/*Funcoes de verificacao: testam se o texto colocado é valido/está presente usando Patterns*/
	int VerifyFirstName(print printForm){
		novo = textfirstName.getText();
		if(Pattern.matches("[A-Za-z0-9]+", novo)){
			printForm.firstNameLabel.setText(novo);
			return 0;
		} else {
			printForm.firstNameLabel.setText(novo);
			ErroVerificacao aviso = new ErroVerificacao();
			aviso.lblErroNoCampo.setText("Campo First Name obrigatório!");
			aviso.show();
			return 1;
		}		
	}
	
	int VerifyLastName(print printForm){
		novo = textlastName.getText();
		if(Pattern.matches("[A-Za-z0-9]+", novo)){
			printForm.lastNameLabel.setText(novo);
			return 0;
		} else {
			ErroVerificacao aviso = new ErroVerificacao();
			aviso.lblErroNoCampo.setText("Campo Last Name obrigatório!");
			aviso.show();
			return 1;
		}		
	}
	
	int VerifyDate(print printForm){
		novo = txtDdmmaaaa.getText();
		if(Pattern.matches("[0-9][0-9]/[0-9][0-9]/[0-9][0-9][0-9][0-9]", novo)){
			printForm.DataNascimentoLabel.setText(novo);
			return 0;
		} else {
			ErroVerificacao aviso = new ErroVerificacao();
			aviso.lblErroNoCampo.setText("Campo Data Nascimento obrigatório no formato DD/MM/AAAA");
			aviso.show();
			return 1;
		}		
	}
	
	int VerifyEmail(print printForm){
		novo = textEmail.getText();
		if(Pattern.matches("[A-Za-z0-9.@]+", novo)){
			printForm.EmailLabel.setText(novo);
			return 0;
		} else {
			ErroVerificacao aviso = new ErroVerificacao();
			aviso.lblErroNoCampo.setText("Campo email obrigatório!");
			aviso.show();
			return 1;
		}		
	}
	
	int VerifyCPF(print printForm){
		novo = textCPF.getText();
		if(Pattern.matches("[0-9][0-9][0-9][.]?[0-9][0-9][0-9][.]?[0-9][0-9][0-9][-]?[0-9][0-9]", novo)){
			VerificaCPF verificador = new VerificaCPF();
			if(verificador.CPF(novo)){
				printForm.CPFLabel.setText(novo);
				return 0;
			} else {
				ErroVerificacao aviso = new ErroVerificacao();
				aviso.lblErroNoCampo.setText("CPF inválido!"); // Formato valido mas valor invalido!
				aviso.show();
				return 1;
			}
		} else {
			ErroVerificacao aviso = new ErroVerificacao();
			aviso.lblErroNoCampo.setText("Campo CPF obrigatório/Formato CPF incorreto!"); // Formato invalido
			aviso.show();
			return 1;
		}		
	}
	
	int VerifyCEP(print printForm){
		novo = textCEP.getText();
		if(Pattern.matches("[0-9][0-9][.]?[0-9][0-9][0-9][-]?[0-9][0-9][0-9]", novo)){
			printForm.CEPLabel.setText(novo);
			return 0;
		} else {
			ErroVerificacao aviso = new ErroVerificacao();
			aviso.lblErroNoCampo.setText("Campo CEP incorreto!");
			aviso.show();
			return 0;
		}		
	}

	/**
	 * Create the frame.
	 */
	public form() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 10, 450, 572);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textfirstName = new JTextField();
		textfirstName.setBounds(164, 118, 185, 19);
		contentPane.add(textfirstName);
		textfirstName.setColumns(10);
		
		textlastName = new JTextField();
		textlastName.setBounds(164, 149, 185, 19);
		contentPane.add(textlastName);
		textlastName.setColumns(10);
		
		final JComboBox comboTitle = new JComboBox();
		comboTitle.setModel(new DefaultComboBoxModel(new String[] {"Mr.", "Mrs.", "Miss.", "Ms.", "Dr.", "Other"}));
		comboTitle.setToolTipText("");
		comboTitle.setBounds(164, 82, 81, 24);
		contentPane.add(comboTitle);
		
		JLabel lblFirstName = new JLabel("First Name*");
		lblFirstName.setBounds(12, 120, 90, 15);
		contentPane.add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name*");
		lblLastName.setBounds(12, 151, 90, 15);
		contentPane.add(lblLastName);
		
		JLabel lblTitle = new JLabel("Title:");
		lblTitle.setBounds(12, 87, 90, 15);
		contentPane.add(lblTitle);
		
		JButton btnPrint = new JButton("Print");
		btnPrint.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {		
				//contentPane.setVisible(false);
				print printForm = new print();
				printForm.titleLabel.setText((String) comboTitle.getSelectedItem());
				
				/*Chama uma funcao de verificacao, se for obrigatorio e estiver errado nao chama a impressao*/
				valor = VerifyFirstName(printForm);
				if (valor == 1){
					return;
				}
				valor = VerifyLastName(printForm);
				if (valor == 1){
					return;
				}
				valor = VerifyDate(printForm);
				if (valor == 1){
					return;
				}
				valor = VerifyEmail(printForm);
				if (valor == 1){
					return;
				}
				valor = VerifyCPF(printForm);
				if (valor == 1){
					return;
				}
				printForm.PhoneLabel.setText(txtPhone.getText());
				printForm.Address1Label.setText(textAddress1.getText());
				printForm.Address2Label.setText(txtAddress2.getText());
				VerifyCEP(printForm);
				printForm.CityLabel.setText(textCity.getText());
				printForm.StateLabel.setText(textState.getText());
				printForm.CountryLabel.setText(textCountry.getText());
			
				//printForm.contentPane.setVisible(true);				
				printForm.show();	
			}
		});
		btnPrint.setBounds(12, 505, 74, 25);
		contentPane.add(btnPrint);
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setBounds(217, 180, -115, 19);
		contentPane.add(formattedTextField);
		
		txtDdmmaaaa = new JTextField();
		txtDdmmaaaa.setText("DD/MM/AAAA");
		txtDdmmaaaa.setToolTipText("DD/MM/AAAA");
		txtDdmmaaaa.setColumns(10);
		txtDdmmaaaa.setBounds(164, 180, 185, 19);
		contentPane.add(txtDdmmaaaa);
		
		textEmail = new JTextField();
		textEmail.setColumns(10);
		textEmail.setBounds(164, 211, 185, 19);
		contentPane.add(textEmail);
		
		JLabel lblDate = new JLabel("Data Nascimento*");
		lblDate.setBounds(12, 180, 134, 15);
		contentPane.add(lblDate);
		
		JLabel lblEmail = new JLabel("Email*");
		lblEmail.setBounds(12, 213, 90, 15);
		contentPane.add(lblEmail);
		
		textCPF = new JTextField();
		textCPF.setColumns(10);
		textCPF.setBounds(164, 242, 185, 19);
		contentPane.add(textCPF);
		
		JLabel lblCpf = new JLabel("CPF*");
		lblCpf.setBounds(12, 244, 90, 15);
		contentPane.add(lblCpf);
		
		txtPhone = new JTextField();
		txtPhone.setToolTipText("Including international country code and DDD");
		txtPhone.setColumns(10);
		txtPhone.setBounds(164, 273, 185, 19);
		contentPane.add(txtPhone);
		
		textAddress1 = new JTextField();
		textAddress1.setColumns(10);
		textAddress1.setBounds(164, 304, 185, 19);
		contentPane.add(textAddress1);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setToolTipText("Including international country code and DDD");
		lblPhone.setBounds(12, 275, 90, 15);
		contentPane.add(lblPhone);
		
		JLabel lblAddress = new JLabel("Address 1");
		lblAddress.setBounds(12, 304, 90, 15);
		contentPane.add(lblAddress);
		
		txtAddress2 = new JTextField();
		txtAddress2.setText("\nApt, floor, suite, etc.");
		txtAddress2.setColumns(10);
		txtAddress2.setBounds(164, 335, 185, 19);
		contentPane.add(txtAddress2);
		
		JLabel lblAddress_1 = new JLabel("Address 2");
		lblAddress_1.setToolTipText("\nApt, floor, suite, etc.");
		lblAddress_1.setBounds(12, 337, 90, 15);
		contentPane.add(lblAddress_1);
		
		textCEP = new JTextField();
		textCEP.setColumns(10);
		textCEP.setBounds(164, 366, 185, 19);
		contentPane.add(textCEP);
		
		textCity = new JTextField();
		textCity.setColumns(10);
		textCity.setBounds(164, 397, 185, 19);
		contentPane.add(textCity);
		
		textState = new JTextField();
		textState.setColumns(10);
		textState.setBounds(164, 429, 185, 19);
		contentPane.add(textState);
		
		textCountry = new JTextField();
		textCountry.setColumns(10);
		textCountry.setBounds(164, 460, 185, 19);
		contentPane.add(textCountry);
		
		JLabel lblCep = new JLabel("CEP");
		lblCep.setBounds(12, 368, 90, 15);
		contentPane.add(lblCep);
		
		JLabel lblCity = new JLabel("City");
		lblCity.setBounds(12, 400, 90, 15);
		contentPane.add(lblCity);
		
		JLabel lblState = new JLabel("State");
		lblState.setBounds(12, 431, 90, 15);
		contentPane.add(lblState);
		
		JLabel lblCountry = new JLabel("Country");
		lblCountry.setBounds(12, 462, 90, 15);
		contentPane.add(lblCountry);
		
		JLabel lblNewLabel = new JLabel("EA975 :: Lab. Eng. SW ::1S/2015");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 18));
		lblNewLabel.setBounds(39, 12, 364, 25);
		contentPane.add(lblNewLabel);
		
		JLabel lblExerccioDesign = new JLabel("Exercício Design & Automated Testing");
		lblExerccioDesign.setBounds(69, 49, 280, 15);
		contentPane.add(lblExerccioDesign);
		
		JLabel lblobrigatrio = new JLabel("*Obrigatório");
		lblobrigatrio.setFont(new Font("Dialog", Font.BOLD, 10));
		lblobrigatrio.setBounds(322, 76, 81, 19);
		contentPane.add(lblobrigatrio);
	}
}
