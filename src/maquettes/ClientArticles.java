package maquettes;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.text.MessageFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class ClientArticles extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtTapezVotreRecherche;
	private JTable table;
	
	 public Connection conn= null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientArticles frame = new ClientArticles();
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
	public ClientArticles() {
		setBackground(Color.WHITE);
		setResizable(false);
		setType(Type.UTILITY);
		getContentPane().setBackground(Color.WHITE);
		/*Code de la fenetre*/
		setBounds(1200, 10, 473, 326);
		setTitle("NOS ARTICLES");
		JButton btnRetour = new JButton("Retour");
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnRetour.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnRetour.setForeground(Color.BLUE);
		btnRetour.setBounds(342, 242, 115, 35);
		
		txtTapezVotreRecherche = new JTextField();
		txtTapezVotreRecherche.setBounds(79, 19, 178, 24);
		txtTapezVotreRecherche.setText("");
//		String valeurRecherche = txtTapezVotreRecherche.getText();
	//		System.out.println(valeurRecherche);
		txtTapezVotreRecherche.setColumns(10);
		
		JButton btnRechercher = new JButton("Rechercher");
		btnRechercher.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnRechercher.setForeground(Color.BLUE);
		btnRechercher.setBounds(297, 19, 103, 24);
		btnRechercher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String valeurRecherche = txtTapezVotreRecherche.getText();
				System.out.println(valeurRecherche);
				try{
                    Class.forName("com.mysql.jdbc.Driver"); 

                    conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/ppe4","root","");

                    String query= "SELECT * FROM  articles WHERE RefArticles LIKE ?";
                    java.sql.PreparedStatement pstm = conn.prepareStatement(query);
                    pstm.setString(1,"%"+ valeurRecherche + "%");
                    ResultSet rs = pstm.executeQuery();
                    table.setModel(DbUtils.resultSetToTableModel(rs));

            }

            catch(Exception ex){
                    JOptionPane.showMessageDialog(null, "Pas de connexion � la base de donn�es" + "\t" +
            ex.getMessage());
                    ex.printStackTrace();
//                    btnRechercher.setBounds(5,237,188,51);
            }
			}
		});
		getContentPane().setLayout(null);
		
		JButton btnImpression = new JButton("Impression");
		btnImpression.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnImpression.setForeground(Color.BLUE);
		btnImpression.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MessageFormat header = new MessageFormat ("titre");
				MessageFormat footer = new MessageFormat ("Page {0,number,integer}");
				
				try{table.print(JTable.PrintMode.FIT_WIDTH, header, footer);}
				
				catch (Exception eP){JOptionPane.showMessageDialog(null, eP.getMessage());}
			}
		});
		btnImpression.setBounds(18, 242, 115, 35);
		btnImpression.setToolTipText("");
		getContentPane().add(btnImpression);
		
		getContentPane().add(btnRetour);
		getContentPane().add(txtTapezVotreRecherche);
		getContentPane().add(btnRechercher);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 66, 451, 158);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		
	}
}
