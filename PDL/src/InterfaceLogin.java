import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;

/**
 * Cette classe est l'interface de connexion du programme
 * @author Equipe 1 groupe 6
 * 
 * @version 1.0
 *
 */

public class InterfaceLogin {

	private JFrame frame;
	private String titre;
	private JTextField textField;
	private JPasswordField passwordField;
	
	private InteractionBDD moduleBDD;
	
	private int selectedIndex;

	/**
	 * Demarrage de la fenetre, mettre null en parametre)
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceLogin window = new InterfaceLogin("EsigServices");
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public InterfaceLogin(String title) {
		titre = title;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 500);
		frame.setTitle(titre);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(1, 0, 0, 0));
		
		moduleBDD = new InteractionBDD();
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(313, 180, 146, 39);
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Identifiant");
		lblNewLabel.setBounds(197, 186, 106, 33);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(313, 229, 146, 39);
		passwordField.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(passwordField);
		
		JLabel lblNewLabel_1 = new JLabel("Mot de passe");
		lblNewLabel_1.setBounds(197, 242, 106, 26);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Me connecter");
		btnNewButton.setBounds(313, 343, 146, 39);
		panel.add(btnNewButton);
		
		String[] choices = { "Etudiant", "Enseignant", "Scolarite",};
		
		JComboBox comboBox = new JComboBox(choices);
		comboBox.setBounds(313, 289, 146, 39);
		comboBox.addActionListener(e -> {
	         // Obtention de l'indice du choix sélectionné dans le menu déroulant
	         selectedIndex = comboBox.getSelectedIndex();
	      });
		panel.add(comboBox);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("Images\\logo_esig.png"));
		lblNewLabel_2.setBounds(106, 35, 581, 128);
		panel.add(lblNewLabel_2);
		
		ImageIcon imageIcon = new ImageIcon("Images\\\\logo_esig.png");
		Image image = imageIcon.getImage();

		// Redimensionner l'image pour s'adapter à la taille de JLabel
		int width = lblNewLabel_2.getWidth();
		int height = lblNewLabel_2.getHeight();
		Image scaledImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);

		// Définir l'image redimensionnée dans JLabel
		lblNewLabel_2.setIcon(new ImageIcon(scaledImage));
		
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				boolean verifId = false;
				switch(selectedIndex) {
					case 0:
						verifId = moduleBDD.verificationConnexion(0, textField.getText(), new String(passwordField.getPassword()));
						break;
					case 1:
						verifId = moduleBDD.verificationConnexion(1, textField.getText(), new String(passwordField.getPassword()));
						break;
					case 2:
						verifId = moduleBDD.verificationConnexion(2, textField.getText(), new String(passwordField.getPassword()));
						break;
					default:
						System.out.println("N'est pas cense arriver car selectedIndex choisi par le menu qui ne dispose que de 3 choix possibles");
				}
				
				if(verifId == true)
				{
					/*
					System.out.println("Identifiants corrects !");
					jlMessageBienvenue.setText("Identifiants corrects ! Connexion en cours...");
					dispose();*/
					frame.dispose();
				}
				else {
					//jlMessageBienvenue.setText("Identifiant ou mot de passe incorrect, verifiez que vous avez selectionne le bon type de compte");
				}
				
			}
		});
	}
}
