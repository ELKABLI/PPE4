package maquettes;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
//import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

@SuppressWarnings("unused")
public class Loguer extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Loguer frame = new Loguer();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Loguer() {
		setResizable(false);
		setType(Type.UTILITY);
		setBackground(Color.WHITE);
		setTitle("GESTCOM");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setBounds(600, 300, 600, 470);
		
		
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		
		
		setContentPane(contentPane);
		
		JLabel lblEmail = new JLabel("Identifiant :");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEmail.setBounds(297, 164, 97, 14);
		
		textField = new JTextField();
		textField.setBounds(449, 163, 125, 20);
		textField.setColumns(10);
		
		JLabel lblMotDePasse = new JLabel("Mot de passe :");
		lblMotDePasse.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMotDePasse.setBounds(297, 214, 111, 14);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(449, 213, 125, 20);
		
		JButton btnClient = new JButton("Clients");
		btnClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String varNomClients = textField.getText();

				try {				
					Class.forName("com.mysql.jdbc.Driver");
					Connection connex = DriverManager.getConnection("jdbc:mysql://localhost:3306/ppe4","root","");
					PreparedStatement sta = (PreparedStatement) connex.prepareStatement("SELECT * FROM clients WHERE NomClients = ? AND MdpClients = ?");
					sta.setString(1, varNomClients);
					sta.setString(2, String.valueOf(passwordField.getPassword()));
					ResultSet etat = sta.executeQuery();
					while (etat.next()){
						String varIDClients = etat.getString("IDClients");
						ClientMenu frame = new ClientMenu(varIDClients);
						frame.setVisible(true);
						dispose();
					}
				}
				catch (Exception e1 ){
					JOptionPane.showConfirmDialog(null, "Identification erronée \n Veuillez recommencer");
				e1.getMessage();
			}	
			}
		});
		btnClient.setForeground(Color.BLUE);
		btnClient.setBounds(458, 281, 116, 23);
		contentPane.setLayout(null);
		contentPane.add(lblMotDePasse);
		contentPane.add(lblEmail);
		contentPane.add(btnClient);
		contentPane.add(textField);
		contentPane.add(passwordField);
		
		JButton btnAdmin = new JButton("Admin");
		btnAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection connex = DriverManager.getConnection("jdbc:mysql://localhost:3306/ppe4","root","");			
					PreparedStatement sta = (PreparedStatement) connex.prepareStatement("SELECT LoginAdmin,MdpAdmin FROM admin WHERE LoginAdmin = ? AND MdpAdmin = ?");
					sta.setString(1, textField.getText());
					sta.setString(2, String.valueOf(passwordField.getPassword()));
					
					ResultSet etat = sta.executeQuery();
					while (etat.next()){
						AdminMenu frame = new AdminMenu();
						frame.setVisible(true);
						dispose();
					}
				}
				catch (Exception e1 ){
					JOptionPane.showConfirmDialog(null, "Connexion not ok");
				e1.getMessage();	
			}		
			}
		});
		
		btnAdmin.setForeground(Color.BLUE);
		btnAdmin.setBounds(297, 281, 116, 23);
		contentPane.add(btnAdmin);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		//lblNewLabel.setIcon(new ImageIcon(Loguer.class.getResource("D:\\workspace\\Ex_PPE4\\src\\main\\resource\\img\\logo1.PNG")));
		lblNewLabel.setBounds(-79, -105, 533, 709);
		contentPane.add(lblNewLabel);
	}
}
