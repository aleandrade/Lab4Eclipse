package alunos;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class ErroVerificacao extends JDialog {

	private final JPanel contentPanel = new JPanel();
	JLabel lblErroNoCampo = new JLabel("Erro no campo");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ErroVerificacao dialog = new ErroVerificacao();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ErroVerificacao() {
		setBounds(100, 100, 736, 85);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.NORTH);
		lblErroNoCampo.setFont(new Font("Dialog", Font.BOLD, 20));
		
		contentPanel.add(lblErroNoCampo);
	}
}
