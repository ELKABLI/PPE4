package maquettes;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Window;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Window.Type;
import java.awt.Color;
import java.awt.Font;



@SuppressWarnings("unused")
public class AdminClients extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtTapezVotreRecherche;
	private JTable table;
	private JTextField VisuNom;
	private JTextField VisuPrenom;
	private JTextField VisuAdresse;
	private JTextField VisuCP;
	private JTextField VisuVille;
	private JTextField VisuTelephone;
	private JTextField VisuEmail;
	private JTextField VisuMdp;
	private JTextField VisuID;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminClients frame = new AdminClients();
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
	@SuppressWarnings("unchecked")
	public AdminClients() {
		setResizable(false);
		setBackground(Color.WHITE);
		setType(Type.UTILITY);
		setTitle("GESTION DES CLIENTS");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(10, 10, 868, 496);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
		JLabel lblNomClient = new JLabel("Nom Client");
		lblNomClient.setBounds(210, 24, 71, 16);
		
		txtTapezVotreRecherche = new JTextField();
		txtTapezVotreRecherche.setBounds(291, 19, 220, 26);
		txtTapezVotreRecherche.setColumns(10);
		
		final String[] TITRES = {"Monsieur", "Madame"}; //variable du Combobox 
		@SuppressWarnings("rawtypes")
		final
		JComboBox civilite = new JComboBox(TITRES); // recuperation et initialisation du ComboBox
		civilite.setFont(new Font("Tahoma", Font.PLAIN, 11));
		civilite.setForeground(Color.BLUE);
		
		JButton btnModifierClient = new JButton("Modifier  Client");
		btnModifierClient.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnModifierClient.setForeground(Color.BLUE);
		btnModifierClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// modification des données du client
				
				String nom = VisuNom.getText();
				String prenom = VisuPrenom.getText();
				String CP = VisuCP.getText();
				String ville = VisuVille.getText();
				String adresse = VisuAdresse.getText();
				String telephone = VisuTelephone.getText();
				String email = VisuEmail.getText();
				String Mdp	= VisuMdp.getText();
				String IDClients	= VisuID.getText();
				
				 
               
				try{
                        
                        Class.forName("com.mysql.jdbc.Driver");    
                        Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/ppe4","root","");
                        
						String query =  "UPDATE clients SET CiviliteClients = '"+civilite.getSelectedItem()+"',NomClients = '" +nom+"', PrenomClients = '" +prenom+"', AdresseClients = '" +adresse+"', CpVilleClients = '" +CP+"',VilleClients = '" +ville+"',TelClients = '" +telephone+"',MailClients = '" +email+"',MdpClients = '" +Mdp+"' WHERE IDClients = '" +IDClients+"' ";
                        java.sql.PreparedStatement pstm = ((Connection) conn).prepareStatement(query);
                        int i = pstm.executeUpdate();
                        System.out.println(i);
                        if (i != 0) {
                            JOptionPane.showMessageDialog(null, "Client Modifiï¿½");
                            raZero();
							charge();
                        }
                    }
						
						catch(Exception ep){
                        JOptionPane.showMessageDialog(null, "Pas de connexion à la base de données" + ep.getMessage());
                        ep.printStackTrace();
						}
			}
                    });
		btnModifierClient.setBounds(264, 342, 141, 29);
		
		JButton btnSupprimerClient = new JButton("Supprimer Client");
		btnSupprimerClient.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnSupprimerClient.setForeground(Color.BLUE);
		btnSupprimerClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
String valeurRecherche = txtTapezVotreRecherche.getText();

					// Suppresion des lignes de la table par le nom du clients aprés selection dans la Jtable
				

				int n = JOptionPane.showConfirmDialog(null, "Etes-vous sur de vouloir supprimmer ce client ?");

				try{
					if (n == JOptionPane.YES_OPTION) {

					Class.forName("com.mysql.jdbc.Driver");
					 Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/ppe4","root","");
					 String query = "DELETE FROM clients WHERE NomClients = '" +valeurRecherche+"' "; 
	                    java.sql.PreparedStatement pstm = ((Connection) conn).prepareStatement(query);
	                    int i = pstm.executeUpdate();
	                    if (i != 0) {
	                    	
	                    	JOptionPane.showMessageDialog(null, "le client à bien été supprimé de la base de données.");
	                    	
	                    	raZero();
							charge();
	                       
	                    }
					 else if (n == JOptionPane.NO_OPTION) {
						 
						 CloseFrame();
						
					 		}
						}
					}	
				
			
				catch(Exception ex){
					JOptionPane.showMessageDialog(null, "Pas de connexion à  la base de données" + "\t" +
				ex.getMessage());
					ex.printStackTrace();
				
				}
			}
		});
		
		btnSupprimerClient.setBounds(446, 342, 149, 29);
		
		JButton btnRechercher = new JButton("Rechercher");
		btnRechercher.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnRechercher.setForeground(Color.BLUE);
		btnRechercher.setBounds(551, 18, 113, 29);
		btnRechercher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String valeurRecherche = txtTapezVotreRecherche.getText();
				String Idclients = VisuID.getText();
					
				// Recherche d'un client par le champs nomClient
					
					try{			
						Class.forName("com.mysql.jdbc.Driver");
						 Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/ppe4","root","");
					 String query= "SELECT * FROM  clients WHERE NomClients LIKE ? AND IDClients LIKE ?";
					 java.sql.PreparedStatement pstm = conn.prepareStatement(query);
					 pstm.setString(1,"%"+ valeurRecherche + "%");
					 pstm.setString(2,"%"+ Idclients + "%");
					 ResultSet rs = pstm.executeQuery();
					 table.setModel(DbUtils.resultSetToTableModel(rs));
					 System.out.println(Idclients);
					 
				}
				
				catch(Exception ex){
					JOptionPane.showMessageDialog(null, "Pas de connexion à  la base de données" + "\t" +
				ex.getMessage());
					ex.printStackTrace();
				
				}
			}
		});
		
		JButton btnImprimerFicheClient = new JButton("Imprimer fiche client");
		btnImprimerFicheClient.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnImprimerFicheClient.setForeground(Color.BLUE);
		btnImprimerFicheClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				MessageFormat header = new MessageFormat("Table \"Impression Fiche Client\"");
				MessageFormat footer = new MessageFormat("Page{0,number,integer}");
				
				try{
					table.print(JTable.PrintMode.FIT_WIDTH,header,footer);
					
				}catch(Exception ep){JOptionPane.showMessageDialog(null, ep.getMessage());}
				
			}	
			
		});
		btnImprimerFicheClient.setBounds(46, 400, 157, 29);
		
	
		
		
		
		
		JButton btnAjoutClient = new JButton("Ajout Client");
		btnAjoutClient.setForeground(Color.BLUE);
		btnAjoutClient.addActionListener(new ActionListener() {
		

			public void actionPerformed(ActionEvent e) {
			
				
				
				
				String nom = VisuNom.getText();
				String prenom = VisuPrenom.getText();
				String CP = VisuCP.getText();
				String ville = VisuVille.getText();
				String adresse = VisuAdresse.getText();
				String telephone = VisuTelephone.getText();
				String email = VisuEmail.getText();
				String Mdp	= VisuMdp.getText();
				
				
				try{			
					Class.forName("com.mysql.jdbc.Driver");
					 Connection conn1 = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/ppe4","root","");
					Statement stmt = (Statement) conn1.createStatement();
					stmt.executeUpdate("INSERT INTO clients(CiviliteClients,NomClients,PrenomClients,AdresseClients,CPVilleClients,VilleClients,TelClients,MailClients,MdpClients)"
							+ " VALUES ('"+civilite.getSelectedItem()+"','"+nom+"','"+prenom+"','"+adresse+"','"+CP+"','"+ville+"','"+telephone+"','"+email+"','"+Mdp+"')");
				}
				
				catch(ClassNotFoundException ex){
					ex.getMessage();
					System.out.println("Classe non OK");
				} 
				catch (SQLException ex) {
				
					ex.printStackTrace();
					System.out.println("SQL non OK");
				}
				
				raZero();
				charge();

				
				
			}
		});
		
		btnAjoutClient.setBounds(106, 342, 119, 29);
		contentPane.setLayout(null);
		contentPane.add(lblNomClient);
		contentPane.add(txtTapezVotreRecherche);
		contentPane.add(btnRechercher);
		contentPane.add(btnImprimerFicheClient);
		contentPane.add(btnAjoutClient);
		contentPane.add(btnSupprimerClient);
		contentPane.add(btnModifierClient);
		
		
		VisuNom = new JTextField();
		VisuNom.setBounds(81, 235, 130, 26);
		contentPane.add(VisuNom);
		VisuNom.setColumns(10);
		
		VisuPrenom = new JTextField();
		VisuPrenom.setBounds(81, 273, 130, 26);
		contentPane.add(VisuPrenom);
		VisuPrenom.setColumns(10);
		
		VisuAdresse = new JTextField();
		VisuAdresse.setBounds(345, 202, 177, 26);
		contentPane.add(VisuAdresse);
		VisuAdresse.setColumns(10);
		
		VisuCP = new JTextField();
		VisuCP.setBounds(345, 235, 177, 26);
		contentPane.add(VisuCP);
		VisuCP.setColumns(10);
		
		JLabel lblNom = new JLabel("Nom");
		lblNom.setBounds(11, 240, 61, 16);
		contentPane.add(lblNom);
		
		JLabel lblPrenom = new JLabel("Prenom");
		lblPrenom.setBounds(11, 278, 61, 16);
		contentPane.add(lblPrenom);
		
		JLabel lblAdresse = new JLabel("Adresse");
		lblAdresse.setBounds(256, 207, 61, 16);
		contentPane.add(lblAdresse);
		
		JLabel lblCodePostal = new JLabel("Code Postal");
		lblCodePostal.setBounds(256, 240, 83, 16);
		contentPane.add(lblCodePostal);
		
		VisuVille = new JTextField();
		VisuVille.setBounds(345, 278, 177, 26);
		contentPane.add(VisuVille);
		VisuVille.setColumns(10);
		
		JLabel lblVille = new JLabel("Ville");
		lblVille.setBounds(256, 278, 61, 16);
		contentPane.add(lblVille);
		
		VisuTelephone = new JTextField();
		VisuTelephone.setBounds(624, 235, 154, 26);
		contentPane.add(VisuTelephone);
		VisuTelephone.setColumns(10);
		
		VisuEmail = new JTextField();
		VisuEmail.setBounds(624, 202, 154, 26);
		contentPane.add(VisuEmail);
		VisuEmail.setColumns(10);
		
		VisuMdp = new JTextField();
		VisuMdp.setBounds(624, 273, 154, 26);
		contentPane.add(VisuMdp);
		VisuMdp.setColumns(10);
		
		JLabel lblTelephone = new JLabel("Telephone");
		lblTelephone.setBounds(534, 240, 83, 16);
		contentPane.add(lblTelephone);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(534, 207, 61, 16);
		contentPane.add(lblEmail);
		
		JLabel lblMotDePasse = new JLabel("Mot de passe");
		lblMotDePasse.setBounds(534, 278, 83, 16);
		contentPane.add(lblMotDePasse);
		
		
		
		JScrollPane scrollPane = new JScrollPane();

		scrollPane.setBounds(11, 52, 826, 138);
		contentPane.add(scrollPane);
		
		//remplissage des fields en fonction de la ligne selectionné
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				DefaultTableModel modele = (DefaultTableModel) table.getModel();
                int selectedRowIndex = table.getSelectedRow();
                VisuID.setText(modele.getValueAt(selectedRowIndex, 0).toString());
                txtTapezVotreRecherche.setText(modele.getValueAt(selectedRowIndex, 2).toString());
                VisuNom.setText(modele.getValueAt(selectedRowIndex, 2).toString());
                VisuPrenom.setText(modele.getValueAt(selectedRowIndex, 3).toString());
                VisuAdresse.setText(modele.getValueAt(selectedRowIndex, 4).toString());
                VisuCP.setText(modele.getValueAt(selectedRowIndex, 5).toString());
                VisuVille.setText(modele.getValueAt(selectedRowIndex, 6).toString());
                VisuTelephone.setText(modele.getValueAt(selectedRowIndex, 7).toString());
                VisuEmail.setText(modele.getValueAt(selectedRowIndex, 8).toString());
                VisuMdp.setText(modele.getValueAt(selectedRowIndex, 9).toString());  
              
			}
		});
		scrollPane.setViewportView(table);
		
		
		
		civilite.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				DefaultTableModel modele = (DefaultTableModel) table.getModel();
                int selectedRowIndex = table.getSelectedRow();
				civilite.setToolTipText(modele.getValueAt(selectedRowIndex, 1).toString());
			}
		});
		civilite.setBounds(81, 203, 113, 27);
		contentPane.add(civilite);
		
		JLabel lblCivilit = new JLabel("Civilit\u00E9");
		lblCivilit.setBounds(11, 207, 61, 16);
		contentPane.add(lblCivilit);
		
		JButton btnAnnuler = new JButton("Annuler ");
		btnAnnuler.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnAnnuler.setForeground(Color.BLUE);
		btnAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				raZero();
				
				charge();
				
			}
		});
		btnAnnuler.setBounds(639, 342, 117, 29);
		contentPane.add(btnAnnuler);
		
		JLabel lblIdClient = new JLabel("ID client");
		lblIdClient.setBounds(26, 25, 46, 14);
		contentPane.add(lblIdClient);
		
		VisuID = new JTextField();
		VisuID.setBounds(81, 22, 86, 20);
		contentPane.add(VisuID);
		VisuID.setColumns(10);
		
		JButton btnQuitter = new JButton("Retour");
		btnQuitter.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnQuitter.setForeground(Color.BLUE);
		btnQuitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				CloseFrame();
			}
		});
		btnQuitter.setBounds(732, 400, 86, 26);
		contentPane.add(btnQuitter);
	
	}
	
	// fermeture d'une fenetre 
	
	public void CloseFrame(){ 
	    super.dispose();
	}
	
	// remise a zero des champs de saisie
	
	public void raZero(){
		
		VisuNom.setText("");VisuPrenom.setText("");VisuCP.setText("");VisuAdresse.setText("");
		VisuVille.setText("");VisuAdresse.setText("");VisuTelephone.setText("");VisuEmail.setText("");
		VisuMdp.setText("");
		
	}
	
	// rechargement de la Jtable
	
	public void charge() {
		
			
				try {
					Class.forName("com.mysql.jdbc.Driver");
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				 Connection conn = null;
				try {
					conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/ppe4","root","");
				} catch (SQLException e) {
					e.printStackTrace();
				}
			 String query= "SELECT * FROM  clients";
			 java.sql.PreparedStatement pstm = null;
			try {
				pstm = conn.prepareStatement(query);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			 ResultSet rs = null;
			try {
				rs = pstm.executeQuery();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			 table.setModel(DbUtils.resultSetToTableModel(rs)); 
			
		
			
	}
	
	
}
