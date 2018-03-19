package maquettes;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Statement;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Window.Type;
import javax.swing.JList;
import javax.swing.JComboBox;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


@SuppressWarnings("unused")
public class ClientCommandes extends JFrame {
//essai git
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField TypeField;
	private JTable table;
	
	public Connection conn = null ;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					String id = null;
					ClientCommandes frame = new ClientCommandes(id);
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
	public ClientCommandes(final String id) {
		setResizable(false);
		setType(Type.UTILITY);
		setAutoRequestFocus(false);
		setTitle("VOS COMMANDES");
		setBounds(10, 50, 900, 700);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		textField = new JTextField();
		textField.setBounds(114, 26, 109, 23);
		textField.setColumns(10);
		
		//ajout d'un nouveau champs de recharge
		TypeField = new JTextField();
		TypeField.setBounds(700, 26, 109, 23);
		
		
		
		
		JLabel lblListe = new JLabel("Liste :");
		lblListe.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblListe.setBounds(11, 122, 80, 15);
		
		JLabel TypeLabel = new JLabel("Type :");
		TypeLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		TypeLabel.setBounds(650, 26, 109, 23);
		
		JButton btnValider = new JButton("Recherche");
		btnValider.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnValider.setForeground(Color.BLUE);
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String varIDcommandes = textField.getText();
				String vardatecommandes = textField_2.getText();
				String varTypesArticles = TypeField.getText();
				
				// controle de la date du format
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

				if(!vardatecommandes.matches("\\d{4}-[01]\\d-[0-3]\\d")) {
					
					JOptionPane.showMessageDialog(null, "Saisir une date de format : yyyy-MM-dd " );
					return;
				}
				
				     try {
				          format.parse(vardatecommandes);

				     }
				     catch(ParseException e1){
				    	 JOptionPane.showMessageDialog(null, "Saisir une date de format : yyyy-MM-dd " + e1.getMessage());
				          return;
				     }
				
				
				
				try {

				Class.forName("com.mysql.jdbc.Driver");	
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ppe4","root",""); 
				String query = "SELECT * FROM commandes, articles WHERE ((IDcommandes = '"+varIDcommandes+"' OR Datecommandes = '"+vardatecommandes+"' OR TypesArticles = '"+varTypesArticles+"') AND fk_IDClients = '"+id+"') AND articles.IDArticles = fk_IDArticles";
				java.sql.PreparedStatement pstm = ((Connection) conn).prepareStatement(query);
				ResultSet rs = pstm.executeQuery();
				table.setModel(DbUtils.resultSetToTableModel(rs));
				
				} catch(Exception ex){
				JOptionPane.showMessageDialog(null, "Pas de connexion à  la base de donnéees "  + ex.getMessage());
				ex.printStackTrace(); 
			}
			}
		});
		btnValider.setBounds(229, 75, 108, 30);
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnAnnuler.setForeground(Color.BLUE);
		btnAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");textField_2.setText("");
			}
		});
		btnAnnuler.setBounds(421, 75, 90, 30);
		
		JLabel lblRfrence = new JLabel("Referance");
		lblRfrence.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblRfrence.setBounds(11, 29, 90, 15);
		
		textField_2 = new JTextField();
		textField_2.setBounds(398, 26, 140, 23);
		textField_2.setColumns(10);
		contentPane.setLayout(null);
		contentPane.add(lblListe);
		contentPane.add(btnValider);
		contentPane.add(lblRfrence);
		contentPane.add(textField);
		contentPane.add(btnAnnuler);
		contentPane.add(textField_2);
		contentPane.add(TypeField);
		contentPane.add(TypeLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(11, 150, 850, 210);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel modele = (DefaultTableModel) table.getModel();
				int selectedRowIndex = table.getSelectedRow();
				textField.setText(modele.getValueAt(selectedRowIndex, 0).toString());
				textField_2.setText(modele.getValueAt(selectedRowIndex, 1).toString());
			}
		});
		scrollPane.setViewportView(table);
		/* Modification d'une commande
		JButton btnModifier = new JButton("Modifier");
		btnModifier.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnModifier.setForeground(Color.BLUE);
		btnModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String varIDcommandes = textField.getText();
				String vardatecommandes = textField_2.getText();
				try {
					
					Class.forName("com.mysql.jdbc.Driver");	
					conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ppe4","root",""); 
					String query = "UPDATE commandes SET Datecommandes = '" +vardatecommandes+"' WHERE IDcommandes = '" +varIDcommandes+"'  ";
					java.sql.PreparedStatement pstm = ((Connection) conn).prepareStatement(query);
					int i = pstm.executeUpdate();
					if (i != 0) {
						JOptionPane.showMessageDialog(null, "Commande Modifiée");
					}
				} catch(Exception ex){
					JOptionPane.showMessageDialog(null, "Pas de connexion à  la base de donnée " + ex.getMessage());
					ex.printStackTrace();
			}
				
			}
		});
		btnModifier.setBounds(21, 380, 109, 30);
		contentPane.add(btnModifier);*/
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnSupprimer.setForeground(Color.BLUE);
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String varSaisie = textField.getText();
				int n = JOptionPane.showConfirmDialog(null, "Etes-vous sur de vouloir supprimmer ce client ?");
				try {
					if (n == JOptionPane.YES_OPTION) {
					Class.forName("com.mysql.jdbc.Driver");	
					conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ppe4","root",""); 
					String query = "DELETE FROM commandes WHERE IDcommandes = '" +varSaisie+"' ";
					java.sql.PreparedStatement pstm = ((Connection) conn).prepareStatement(query);
					int i = pstm.executeUpdate();
					if (i != 0) {
						JOptionPane.showMessageDialog(null, "Commande supprimÃ©e");
					}
                        
					}
					
				} catch(Exception ex){
					JOptionPane.showMessageDialog(null, "Pas de connexion Ã  la base de donnÃ©es " + ex.getMessage());
					ex.printStackTrace();
			}
			}
		});
		btnSupprimer.setBounds(142, 380, 109, 30);
		contentPane.add(btnSupprimer);
		
		JButton btnImprimer = new JButton("Imprimer");
		btnImprimer.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnImprimer.setForeground(Color.BLUE);
		btnImprimer.setBounds(263, 380, 109, 30);
		contentPane.add(btnImprimer);
		
		JLabel lblDateCommande = new JLabel("Date Commande");
		lblDateCommande.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDateCommande.setBounds(255, 29, 121, 15);
		contentPane.add(lblDateCommande);
		
		JButton btnChargeTable = new JButton("Charger Table");
		btnChargeTable.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnChargeTable.setForeground(Color.BLUE);
		btnChargeTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try {

				Class.forName("com.mysql.jdbc.Driver");	
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ppe4","root",""); 
				String query = "SELECT IDcommandes AS Identifiant, Datecommandes AS Date_de_la_commande, TypesArticles, RefArticles, NomClients FROM commandes, articles, clients WHERE fk_IDClients = ? AND articles.IDArticles = fk_IDArticles AND clients.IDClients = fk_IDClients";
				java.sql.PreparedStatement pstm = ((Connection) conn).prepareStatement(query);
				pstm.setString(1, id); // donne une valeur à fk_IDClients
				ResultSet rs = pstm.executeQuery();
				
				table.setModel(DbUtils.resultSetToTableModel(rs));
				
				} catch(Exception ex){
				JOptionPane.showMessageDialog(null, "Pas de connexion à  la base de données "  + ex.getMessage());
				ex.printStackTrace();
			}
			} 
		});
		btnChargeTable.setBounds(11, 72, 132, 37);
		contentPane.add(btnChargeTable);
		
		JButton btnRetour = new JButton("Retour");
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnRetour.setForeground(Color.BLUE);
		btnRetour.setBounds(461, 379, 109, 30);
		contentPane.add(btnRetour);
		
		JLabel lblNewLabel = new JLabel("Article :");
		lblNewLabel.setBounds(11, 490, 140, 30);
		contentPane.add(lblNewLabel);
		
		JButton label = new JButton("Nouvelle commande :");
		label.setBounds(11, 450, 170, 30);
		contentPane.add(label);
		
	
		final JComboBox<String> combo = new JComboBox<String>();
		
		label.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
								
				try {

				Class.forName("com.mysql.jdbc.Driver");	
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ppe4","root",""); 
				String query = "SELECT * FROM articles";
				java.sql.PreparedStatement pstm = ((Connection) conn).prepareStatement(query);
				ResultSet rs = pstm.executeQuery();
				
				while(rs.next()) {
					combo.addItem(rs.getString("RefArticles"));
				}
				
				} catch(Exception ex){
				JOptionPane.showMessageDialog(null, "Pas de connexion à  la base de donnéees "  + ex.getMessage());
				ex.printStackTrace(); 
			}
			}
		});
		
		combo.setBounds(192, 494, 272, 22);
		contentPane.add(combo);
		
		JComboBox<String> QttBox = new JComboBox<String>();
		QttBox.addItem("1");
		QttBox.addItem("2");
		QttBox.addItem("3");
		QttBox.addItem("4");
		QttBox.addItem("5");
		QttBox.setBounds(662, 494, 45, 22);
		contentPane.add(QttBox);
		
		JLabel lblQantits = new JLabel("Qantit\u00E9s :");
		lblQantits.setBounds(570, 490, 80, 30);
		contentPane.add(lblQantits);
		
		JButton btnValider_1 = new JButton("Valider");
		btnValider_1.setForeground(Color.BLUE);
		btnValider_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnValider_1.setBounds(11, 555, 109, 30);
		contentPane.add(btnValider_1);
		btnValider_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			    SimpleDateFormat formater = null;
			    
			    Date aujourdhui = new Date();
			    
			    formater = new SimpleDateFormat("dd-MM-yy");
			    String date = formater.format(aujourdhui);
			    
			    String RefCombo = (String) combo.getSelectedItem();
				
				try {
				
				Class.forName("com.mysql.jdbc.Driver");	
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ppe4","root",""); 
				Statement stmt = (Statement) conn.createStatement();
				stmt.executeUpdate("INSERT INTO commandes(Datecommandes,fk_IDClients,fk_IDArticles) SELECT '11-04-18','"+id+"',IDArticles FROM articles WHERE RefArticles = '"+RefCombo+"'");
				JOptionPane.showMessageDialog(null, "Commande ajoutée ");
				} catch(Exception ex){
				JOptionPane.showMessageDialog(null, "Pas de connexion à  la base de données "  + ex.getMessage());
				ex.printStackTrace();
			}
				charge(id);
			} 
		});
		
	}

	public void charge(final String id) {
		// TODO Auto-generated method stub
		try {

			Class.forName("com.mysql.jdbc.Driver");	
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ppe4","root",""); 
			String query = "SELECT IDcommandes AS Identifiant, Datecommandes AS Date_de_la_commande, TypesArticles, RefArticles, NomClients FROM commandes, articles, clients WHERE fk_IDClients = ? AND articles.IDArticles = fk_IDArticles AND clients.IDClients = fk_IDClients";
			java.sql.PreparedStatement pstm = ((Connection) conn).prepareStatement(query);
			pstm.setString(1, id); // donne une valeur à fk_IDClients
			ResultSet rs = pstm.executeQuery();
			
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
			} catch(Exception ex){
			JOptionPane.showMessageDialog(null, "Pas de connexion à  la base de données "  + ex.getMessage());
			ex.printStackTrace();
		}
		
	}
}
