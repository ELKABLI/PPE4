package maquettes;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ClientClients extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JButton btnModifier;
	private JButton btnAnnuler;
	private String varNomClients;
	private String varPrenomClients;
	private String varAdresseClients;
	private String varCpVilleClients;
	private String varVilleClients;
	private String varTelClients;
	private String varMailClients;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					String title = null;
					ClientClients frame = new ClientClients(title );
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param varNomClients 
	 */
	public ClientClients(final String str) {
		// connexion à la base pour recuperer les element de a fiche client du clients : a continuer
	
		try {				
			Class.forName("com.mysql.jdbc.Driver");
			Connection connex = DriverManager.getConnection("jdbc:mysql://localhost:3306/ppe4","root","");
			PreparedStatement sta = (PreparedStatement) connex.prepareStatement("SELECT * FROM clients WHERE IDClients = ?");
			sta.setString(1, str);
			ResultSet etat = sta.executeQuery();
			while (etat.next()){
				varNomClients = etat.getString("NomClients");
				varPrenomClients = etat.getString("PrenomClients");
				varAdresseClients = etat.getString("AdresseClients");
				varCpVilleClients = etat.getString("CpVilleClients");
				varVilleClients = etat.getString("VilleClients");
				varTelClients = etat.getString("TelClients");
				varMailClients = etat.getString("MailClients");				
			}
			
		}
		catch (Exception e1 ){
			JOptionPane.showConfirmDialog(null, "Identification erronée \n Veuillez recommencer");
		e1.getMessage();
	}	
		
		
		setType(Type.UTILITY);
		setTitle("FICHE CLIENT");
		setResizable(false);
		setBounds(10, 10, 518, 408);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNom = new JLabel("Nom");
		lblNom.setBounds(15, 116, 37, 17);
		lblNom.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblPrenom = new JLabel("Prenom");
		lblPrenom.setBounds(276, 116, 48, 17);
		lblPrenom.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		textField = new JTextField();
		textField.setBounds(72, 116, 145, 20);
		textField.setColumns(10);
		textField.setText(varNomClients);
		
		textField_1 = new JTextField();
		textField_1.setBounds(334, 116, 145, 20);
		textField_1.setColumns(10);
		textField_1.setText(varPrenomClients);
		
		JLabel lblAdresse = new JLabel("Adresse");
		lblAdresse.setBounds(15, 181, 47, 17);
		lblAdresse.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblCodePostal = new JLabel("Code postal");
		lblCodePostal.setBounds(252, 181, 72, 17);
		lblCodePostal.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		//cp
		textField_2 = new JTextField();
		textField_2.setBounds(334, 181, 145, 20);
		textField_2.setColumns(10);
		textField_2.setText(varCpVilleClients);
		
		//adresse
		textField_3 = new JTextField();
		textField_3.setBounds(72, 181, 145, 20);
		textField_3.setColumns(10);
		textField_3.setText(varAdresseClients);
		
		JLabel lblVille = new JLabel("Ville");
		lblVille.setBounds(15, 245, 47, 17);
		lblVille.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(293, 245, 31, 17);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		//ville
		textField_4 = new JTextField();
		textField_4.setBounds(72, 245, 145, 20);
		textField_4.setColumns(10);
		textField_4.setText(varVilleClients);
		
		//email
		textField_5 = new JTextField();
		textField_5.setBounds(334, 245, 145, 20);
		textField_5.setColumns(10);
		textField_5.setText(varMailClients);
		
		btnModifier = new JButton("Modifier");
		btnModifier.setForeground(Color.BLUE);
		btnModifier.setBounds(98, 303, 105, 42);
		//action suite à modification du compte client
		btnModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String varIDClients = str;
				String varNomClients = textField.getText();
				String varPrenomClients = textField_1.getText();
				String varCpVilleClients = textField_2.getText();
				String varAdresseClients = textField_3.getText();
				String varVilleClients = textField_4.getText();
				String varMailClients = textField_5.getText();
				

					try {
						
						Class.forName("com.mysql.jdbc.Driver");	
						Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ppe4","root",""); 
						String query = "UPDATE clients SET NomClients = '" +varNomClients+"', PrenomClients = '" +varPrenomClients+"', AdresseClients = '" +varAdresseClients+"', CpVilleClients = '" +varCpVilleClients+"', VilleClients = '"+varVilleClients+"', TelClients = '"+varTelClients+"', MailClients = '"+varMailClients+"' WHERE IDClients = '" +varIDClients+"'  ";
						java.sql.PreparedStatement pstm = ((Connection) conn).prepareStatement(query);
						int i = pstm.executeUpdate();
						if (i != 0) {
							JOptionPane.showMessageDialog(null, "compte modifié");
						}
					} catch(Exception ex){
						JOptionPane.showMessageDialog(null, "Pas de connexion à  la base de données " + ex.getMessage());
						ex.printStackTrace();
					}	
			}
		});
		
		
		
		btnAnnuler = new JButton("Annuler");
		btnAnnuler.setForeground(Color.BLUE);
		btnAnnuler.setBounds(357, 303, 105, 42);
		btnAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		final String[] TITRES = {"Monsieur", "Madame"}; //variable du Combobox 
		@SuppressWarnings({ "rawtypes", "unchecked" })
		JComboBox comboBox = new JComboBox(TITRES); // recuperation et initialisation du ComboBox
		comboBox.setForeground(Color.BLUE);
		comboBox.setBounds(72, 66, 145, 20);
		
		JLabel lblCivilit = new JLabel("Civilit\u00E9");
		lblCivilit.setBounds(15, 66, 37, 17);
		lblCivilit.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.setLayout(null);
		
		JLabel lblVotreFicheClient = new JLabel("Votre fiche client:");
		lblVotreFicheClient.setBounds(15, 11, 247, 21);
		lblVotreFicheClient.setForeground(Color.BLUE);
		lblVotreFicheClient.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPane.add(lblVotreFicheClient);
		contentPane.add(lblCivilit);
		contentPane.add(lblNom);
		contentPane.add(lblAdresse);
		contentPane.add(lblVille);
		contentPane.add(textField_3);
		contentPane.add(textField_4);
		contentPane.add(textField);
		contentPane.add(comboBox);
		contentPane.add(btnAnnuler);
		contentPane.add(btnModifier);
		contentPane.add(lblPrenom);
		contentPane.add(lblCodePostal);
		contentPane.add(lblEmail);
		contentPane.add(textField_5);
		contentPane.add(textField_2);
		contentPane.add(textField_1);
	}
}
