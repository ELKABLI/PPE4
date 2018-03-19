package maquettes;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.text.MessageFormat;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;

public class AdminArticles extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_6;
	
	public Connection conn = null ;
	private JTable table;
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminArticles frame = new AdminArticles();
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
	public AdminArticles() {
		setTitle("GESTION DES ARTICLES");
		setResizable(false);
		setBounds(10, 300, 600, 470);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		
		textField_1 = new JTextField();
		textField_1.setBounds(86, 16, 187, 23);
		textField_1.setColumns(10);
		
		JLabel lblCatgorie = new JLabel("Code");
		lblCatgorie.setBounds(303, 23, 82, 15);
		
		textField_2 = new JTextField();
		textField_2.setBounds(350, 16, 187, 23);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(86, 55, 187, 23);
		textField_3.setColumns(10);
		
		JLabel lblPrix = new JLabel("Prix");
		lblPrix.setBounds(303, 58, 82, 15);
		
		textField_4 = new JTextField();
		textField_4.setBounds(350, 54, 187, 23);
		textField_4.setColumns(10);
		
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnAjouter.setForeground(Color.BLUE);
		btnAjouter.setBounds(8, 130, 104, 23);
		
		//Ajouter un article
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				@SuppressWarnings("unused")
				String varIDArticles = textField_6.getText();
				String varRefArticles = textField_1.getText();
				String varCodeArticles = textField_2.getText();
				String varTypesArticles = textField_3.getText();
				String varPrixHtArticles = textField_4.getText();
					
				try {
						
						Class.forName("com.mysql.jdbc.Driver");	
						conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ppe4","root",""); 
						String query = "INSERT INTO articles(RefArticles,CodeArticles,TypesArticles,PrixHtArticles)"+ " VALUES ('"+varRefArticles+"','"+varCodeArticles+"','"+varTypesArticles+"','"+varPrixHtArticles+"')";
						java.sql.PreparedStatement pstm = ((Connection) conn).prepareStatement(query);
						int i = pstm.executeUpdate();
						if (i != 0) {
							JOptionPane.showMessageDialog(null, "Article Ajouté");
						}
					} catch(Exception ex){
						JOptionPane.showMessageDialog(null, "Pas de connexion à la base de données " + ex.getMessage());
						ex.printStackTrace();
					}
			}
		});
	
		
		//modifier un article
		JButton btnModifier = new JButton("Modifier");
		btnModifier.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnModifier.setForeground(Color.BLUE);
		btnModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String varIDArticles = textField_6.getText();
				String varRefArticles = textField_1.getText();
				String varCodeArticles = textField_2.getText();
				String varTypesArticles = textField_3.getText();
				String varPrixHtArticles = textField_4.getText();
					try {
						
						Class.forName("com.mysql.jdbc.Driver");	
						conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ppe4","root",""); 
						String query = "UPDATE articles SET RefArticles = '" +varRefArticles+"', CodeArticles = '" +varCodeArticles+"', TypesArticles = '" +varTypesArticles+"', PrixHtArticles = '" +varPrixHtArticles+"' WHERE IDArticles = '" +varIDArticles+"'  ";
						java.sql.PreparedStatement pstm = ((Connection) conn).prepareStatement(query);
						int i = pstm.executeUpdate();
						if (i != 0) {
							JOptionPane.showMessageDialog(null, "Commande Modifiï¿½e");
						}
					} catch(Exception ex){
						JOptionPane.showMessageDialog(null, "Pas de connexion Ã  la base de donnï¿½es " + ex.getMessage());
						ex.printStackTrace();
					}	
			}
		});
		btnModifier.setBounds(236, 130, 104, 23);
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnSupprimer.setForeground(Color.BLUE);
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int n = JOptionPane.showConfirmDialog(null, "Etes-vous sur de vouloir supprimmer cette article ?");
				try {
					if (n == JOptionPane.YES_OPTION) {
					Class.forName("com.mysql.jdbc.Driver");	
					conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ppe4","root",""); 
					String query = "DELETE FROM articles WHERE IDArticles = '" +textField_6.getText()+"' ";
					java.sql.PreparedStatement pstm = ((Connection) conn).prepareStatement(query);
					int i = pstm.executeUpdate();
					if (i != 0) {
						JOptionPane.showMessageDialog(null, "Article supprimé");
					}
					}
				} catch(Exception ex){
					JOptionPane.showMessageDialog(null, "La suppression à échoué : " + ex.getMessage());
					ex.printStackTrace();
			}
			}
		});
		btnSupprimer.setBounds(350, 130, 104, 23);
		
		JLabel lblListe = new JLabel("Liste :");
		lblListe.setBounds(8, 169, 77, 15);
		
		JButton btnImprimer = new JButton("Imprimer");
		btnImprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MessageFormat header = new MessageFormat ("titre");
                MessageFormat footer = new MessageFormat ("Page {0,number,integer}");
                
                try{table.print(JTable.PrintMode.FIT_WIDTH, header, footer);}
                
                catch (Exception eP){JOptionPane.showMessageDialog(null, eP.getMessage());}
			}
		});
		btnImprimer.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnImprimer.setForeground(Color.BLUE);
		btnImprimer.setBounds(164, 398, 115, 23);
		
		JButton btnAperu = new JButton("Charger table");
		btnAperu.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnAperu.setForeground(Color.BLUE);
		btnAperu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

				Class.forName("com.mysql.jdbc.Driver");	
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ppe4","root",""); 
				String query = "SELECT * FROM articles ";
				java.sql.PreparedStatement pstm = ((Connection) conn).prepareStatement(query);
				ResultSet rs = pstm.executeQuery();
				table.setModel(DbUtils.resultSetToTableModel(rs));
				
				} catch(Exception ex){
				JOptionPane.showMessageDialog(null, "Pas de connexion à  la base de données "  + ex.getMessage());
				ex.printStackTrace();
			}
			} 
		});
		btnAperu.setBounds(8, 376, 144, 45);
		
		JButton btnExport = new JButton("Export");
		btnExport.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnExport.setForeground(Color.BLUE);
		btnExport.setBounds(291, 398, 115, 23);
		
		JButton btnAccueil = new JButton("Retour");
		btnAccueil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnAccueil.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnAccueil.setForeground(Color.BLUE);
		btnAccueil.setBounds(451, 398, 115, 23);
		
		final JButton btnRechercher = new JButton("Rechercher");
		btnRechercher.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnRechercher.setForeground(Color.BLUE);
		btnRechercher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String varIDArticles = textField_6.getText();
				String varRefArticles = textField_1.getText();
				String varCodeArticles = textField_2.getText();
				String varTypesArticles = textField_3.getText();
				String varPrixHtArticles = textField_4.getText();
				
				try{
                    Class.forName("com.mysql.jdbc.Driver"); 
                    conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/ppe4","root","");
                    String query= "SELECT * FROM  articles WHERE IDArticles LIKE ? AND RefArticles LIKE ? AND CodeArticles LIKE ? AND TypesArticles LIKE ? AND PrixHtArticles LIKE ?";
                    java.sql.PreparedStatement pstm = conn.prepareStatement(query);
                    pstm.setString(1,"%"+ varIDArticles + "%");pstm.setString(2,"%"+ varRefArticles + "%");pstm.setString(3,"%"+ varCodeArticles + "%");pstm.setString(4,"%"+ varTypesArticles + "%");pstm.setString(5,"%"+ varPrixHtArticles + "%");
                    ResultSet rs = pstm.executeQuery();
                    table.setModel(DbUtils.resultSetToTableModel(rs));

            }

            catch(Exception ex){
                    JOptionPane.showMessageDialog(null, "Pas de connexion à la base de données" + "\t" +
            ex.getMessage());
                    ex.printStackTrace();
                  btnRechercher.setBounds(5,237,188,51);
            }
			}
		});
		btnRechercher.setBounds(122, 130, 104, 23);
		
		JLabel lblRfrence = new JLabel("Reference");
		lblRfrence.setBounds(6, 20, 75, 15);
		
		JLabel lblNom = new JLabel("Type");
		lblNom.setBounds(6, 58, 73, 15);
		contentPane.setLayout(null);
		contentPane.add(lblListe);
		contentPane.add(btnImprimer);
		contentPane.add(btnAperu);
		contentPane.add(btnExport);
		contentPane.add(btnAccueil);
		contentPane.add(btnRechercher);
		contentPane.add(btnAjouter);
		contentPane.add(btnModifier);
		contentPane.add(lblRfrence);
		contentPane.add(lblNom);
		contentPane.add(textField_3);
		contentPane.add(textField_1);
		contentPane.add(lblPrix);
		contentPane.add(lblCatgorie);
		contentPane.add(textField_2);
		contentPane.add(textField_4);
		contentPane.add(btnSupprimer);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(8, 196, 566, 169);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
					DefaultTableModel modele = (DefaultTableModel) table.getModel();
					int selectedRowIndex = table.getSelectedRow();
					textField_1.setText(modele.getValueAt(selectedRowIndex, 1).toString());
					textField_2.setText(modele.getValueAt(selectedRowIndex, 2).toString());
					textField_3.setText(modele.getValueAt(selectedRowIndex, 3).toString());
					textField_4.setText(modele.getValueAt(selectedRowIndex, 4).toString());
					textField_6.setText(modele.getValueAt(selectedRowIndex, 0).toString());
				}
			
		});
		scrollPane.setViewportView(table);
		
		JLabel lblIdArticles = new JLabel("ID Articles");
		lblIdArticles.setBounds(6, 95, 82, 15);
		contentPane.add(lblIdArticles);
		
		textField_6 = new JTextField();
		textField_6.setBounds(86, 90, 187, 23);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnAnnuler.setForeground(Color.BLUE);
		btnAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_1.setText("");textField_2.setText("");textField_3.setText("");textField_4.setText("");textField_6.setText("");
			}
		});
		btnAnnuler.setBounds(464, 130, 104, 23);
		contentPane.add(btnAnnuler);
	}

}
