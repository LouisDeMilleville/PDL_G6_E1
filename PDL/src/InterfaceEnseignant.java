import java.awt.GridLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class InterfaceEnseignant extends JFrame {
	
	private Enseignant enseignant;
	
	private JPanel jpContainer;
	private JLabel jlMessageBienvenue;
	private JLabel jlMessageFermeture;
	private JPanel jpSousContainer;
	private JButton jbPlanning;
	private JButton jbAppel;
	private JButton jbDeclarationAbsence;
	private JButton jbMesJustifs;
	private JButton jbDeconnexion;
	private JButton jbMesAbsences;
	private String idEnseignant;
	
	public InterfaceEnseignant(String titre, int width, int height, Enseignant enseignant/*,String idEnseignant*/)
	{
		this.setTitle(titre);
		this.setSize(width, height);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.enseignant = enseignant;
		//this.idEnseignant=idEnseignant;
		
		jpContainer = new JPanel();
		jpContainer.setLayout(new GridLayout(3, 1));
		
		jlMessageBienvenue = new JLabel();
		jlMessageBienvenue.setText("Bonjour, "+ enseignant.getPrenom()+" "+enseignant.getNom());
		jlMessageBienvenue.setHorizontalAlignment(SwingConstants.CENTER);
		jpContainer.add(jlMessageBienvenue);
		
		jlMessageFermeture = new JLabel();
		jlMessageFermeture.setText("Pas de fermeture de prevue");
		jlMessageFermeture.setHorizontalAlignment(SwingConstants.CENTER);
		jpContainer.add(jlMessageFermeture);
		
		jpSousContainer = new JPanel();
		jpSousContainer.setLayout(new GridLayout(3, 2));
		
		jbPlanning = new JButton();
		jbPlanning.setText("Mon planning");
		jbPlanning.setHorizontalAlignment(SwingConstants.CENTER);
		jpSousContainer.add(jbPlanning);
		
		jbAppel = new JButton();
		jbAppel.setText("Faire l'appel");
		jbAppel.setHorizontalAlignment(SwingConstants.CENTER);
		jpSousContainer.add(jbAppel);
		
		jbDeclarationAbsence = new JButton();
		jbDeclarationAbsence.setText("Déclarer une absence");
		jbDeclarationAbsence.setHorizontalAlignment(SwingConstants.CENTER);
		jpSousContainer.add(jbDeclarationAbsence);
		
		jbMesAbsences = new JButton();
		jbMesAbsences.setText("Consulter mes absences");
		jbMesAbsences.setHorizontalAlignment(SwingConstants.CENTER);
		jpSousContainer.add(jbMesAbsences);
		
		jbMesJustifs = new JButton();
		jbMesJustifs.setText("Consulter mes justificatifs ");
		jbMesJustifs.setHorizontalAlignment(SwingConstants.CENTER);
		jpSousContainer.add(jbMesJustifs);
		
		jbDeconnexion = new JButton();
		jbDeconnexion.setText("Deconnexion");
		jbDeconnexion.setHorizontalAlignment(SwingConstants.CENTER);
		jpSousContainer.add(jbDeconnexion);
		
		jpContainer.add(jpSousContainer);
		
		
		
		//Ajouter verification dans table fermeture
		
		this.setContentPane(jpContainer);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
		jbDeconnexion.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
				new LoginWindow("EsigServices", 800, 800);
				
			}
		});
		
		jbDeclarationAbsence.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new InterfaceSaisieAbsenceEnseignant("EsigServices", 800, 800, enseignant);
				dispose();
				
			}
		});
		jbPlanning.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new InterfaceMonPlanning("EsigServices", 800, 800, enseignant);
				dispose();
			}
		});
        jbMesJustifs.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new InterfaceConsulterMesJustificatifs("EsigServices", 800, 800, enseignant);
				dispose();
			}
		});
		
		
		
}
}

