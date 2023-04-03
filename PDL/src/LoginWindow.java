import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


public class LoginWindow extends JFrame{
	
	private JPanel jlContainer;
	private JLabel jlMessageBienvenue;
	private JTextField jtIdentifiant, jtMotDePasse;
	private JComboBox<String> menu;
	private int selectedIndex;
	private JButton jBoutonConnexion;
	private InteractionBDD moduleBDD;


	public LoginWindow(String titre, int width, int height) {
		this.setTitle(titre);
		this.setSize(width, height);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		moduleBDD = new InteractionBDD();
		
		jlContainer = new JPanel();
		jlContainer.setLayout(new GridLayout(5, 1));
		
		jlMessageBienvenue = new JLabel();
		jlMessageBienvenue.setText("Bienvenue, veuillez vous connecter...");
		jlMessageBienvenue.setHorizontalAlignment(SwingConstants.CENTER);
		jlContainer.add(jlMessageBienvenue);
		
		jtIdentifiant = new JTextField();
		jtIdentifiant.setText("Saisissez votre identifiant");
		jtIdentifiant.setHorizontalAlignment(SwingConstants.CENTER);
		jlContainer.add(jtIdentifiant);
		
		jtMotDePasse = new JTextField();
		jtMotDePasse.setText("Saisissez votre mot de passe");
		jtMotDePasse.setHorizontalAlignment(SwingConstants.CENTER);
		jlContainer.add(jtMotDePasse);
		
		String[] choices = { "Etudiant", "Enseignant", "Scolarite" };
		menu = new JComboBox<>(choices);
		menu.addActionListener(e -> {
	         // Obtention de l'indice du choix sélectionné dans le menu déroulant
	         selectedIndex = menu.getSelectedIndex();
	      });
		
		jlContainer.add(menu);
		jBoutonConnexion = new JButton("Se connecter");
		jBoutonConnexion.setHorizontalAlignment(SwingConstants.CENTER);
		jlContainer.add(jBoutonConnexion);
		
		jBoutonConnexion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean verifId = false;
				switch(selectedIndex) {
					case 0:
						String id=jtIdentifiant.getText();
						verifId = moduleBDD.verificationConnexion(0, id , jtMotDePasse.getText());
						break;
					case 1:
						verifId = moduleBDD.verificationConnexion(1, jtIdentifiant.getText(), jtMotDePasse.getText());
						break;
					case 2:
						verifId = moduleBDD.verificationConnexion(2, jtIdentifiant.getText(), jtMotDePasse.getText());
						break;
					default:
						System.out.println("Normalement c'est pas cens� arriver vu qu'il n'y a que 3 choix possibles mais eclipse va bouder si je le fais pas donc je pose ca l�");
				}
				
				if(verifId == true)
				{
					System.out.println("Identifiants corrects !");
					jlMessageBienvenue.setText("Identifiants corrects ! Connexion en cours...");
					dispose();
				}
				else {
					System.out.println("Bordel ca marche pas");
					jlMessageBienvenue.setText("Identifiant ou mot de passe incorrect, v�rifiez que vous avez s�lectionn� le bon type de compte");
				}
			}
		});
		
		this.setContentPane(jlContainer);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
}
