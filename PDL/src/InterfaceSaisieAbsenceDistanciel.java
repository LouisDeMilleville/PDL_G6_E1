import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 * Cette classe est une interface qui permet à un eleve de saisir une absence distanciel
 * @author Equipe 1 groupe 6
 * 
 * @version 1.0
 *
 */
public class InterfaceSaisieAbsenceDistanciel extends JFrame{
	
	private Etudiant etudiant;
	
	private JPanel jpContainer;
	private JPanel jpSousContainer1;
	private JLabel jlMessageDuree;
	private JTextField jtSaisieDuree;
	private JPanel jpSousContainer2;
	private JLabel jlMessageRaison;
	private JTextField jtSaisieRaison;
	private JPanel jpSousContainer3;
	private JLabel jlMessageMatiere;
	private JTextField jtSaisieMatiere;
	private JPanel jpSousContainer4;
	private JButton jbRetour;
	private JButton jbValider;
	
	
	public InterfaceSaisieAbsenceDistanciel(String titre, int width, int height, Etudiant etudiant)
	{
		this.setTitle(titre);
		this.setSize(width, height);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.etudiant = etudiant;
		
		jpContainer = new JPanel();
		jpContainer.setLayout(new GridLayout(4, 1));
		
		jpSousContainer1 = new JPanel();
		jpSousContainer1.setLayout(new GridLayout(1, 2));
		
		jlMessageDuree = new JLabel();
		jlMessageDuree.setText("Duree de l'absence (en minutes) : ");
		jlMessageDuree.setHorizontalAlignment(SwingConstants.CENTER);
		jpSousContainer1.add(jlMessageDuree);
		
		jtSaisieDuree = new JTextField();
		jtSaisieDuree.setHorizontalAlignment(SwingConstants.CENTER);
		jpSousContainer1.add(jtSaisieDuree);
		
		jpContainer.add(jpSousContainer1);
		
		jpSousContainer2 = new JPanel();
		jpSousContainer2.setLayout(new GridLayout(1, 2));
		
		jlMessageRaison = new JLabel();
		jlMessageRaison.setText("Raison de l'absence : ");
		jlMessageRaison.setHorizontalAlignment(SwingConstants.CENTER);
		jpSousContainer2.add(jlMessageRaison);
		
		jtSaisieRaison = new JTextField();
		jtSaisieRaison.setHorizontalAlignment(SwingConstants.CENTER);
		jpSousContainer2.add(jtSaisieRaison);
		
		jpContainer.add(jpSousContainer2);
		
		jpSousContainer3 = new JPanel();
		jpSousContainer3.setLayout(new GridLayout(1, 2));
		
		jlMessageMatiere = new JLabel();
		jlMessageMatiere.setText("Matiere : ");
		jlMessageMatiere.setHorizontalAlignment(SwingConstants.CENTER);
		jpSousContainer3.add(jlMessageMatiere);
		
		jtSaisieMatiere = new JTextField();
		jtSaisieMatiere.setHorizontalAlignment(SwingConstants.CENTER);
		jpSousContainer3.add(jtSaisieMatiere);
		
		jpContainer.add(jpSousContainer3);
		
		jpSousContainer4 = new JPanel();
		jpSousContainer4.setLayout(new GridLayout(1, 2));
		
		jbRetour = new JButton();
		jbRetour.setText("Retour");
		jbRetour.setHorizontalAlignment(SwingConstants.CENTER);
		jpSousContainer4.add(jbRetour);
		
		jbValider = new JButton();
		jbValider.setText("Valider");
		jbValider.setHorizontalAlignment(SwingConstants.CENTER);
		jpSousContainer4.add(jbValider);
		
		jpContainer.add(jpSousContainer4);
		
		jbRetour.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new InterfaceMenuAbsenceDistanciel("EsigServices", 800, 800, etudiant);
				dispose();
			}
		});
		
		jbValider.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				InteractionBDD moduleBDD = new InteractionBDD();
				int idAbsence = moduleBDD.getCountAbsenceDistanciel();
				idAbsence++;
				int duree = Integer.parseInt(jtSaisieDuree.getText());
				String raison = jtSaisieRaison.getText();
				String matiere = jtSaisieMatiere.getText();
				moduleBDD.insertAbsenceDistanciel(idAbsence, etudiant.getId(), duree, raison, 0, matiere);
				jtSaisieDuree.setText("");
				jtSaisieRaison.setText("");
				jtSaisieMatiere.setText("");
			}
		});
		
		
		this.setContentPane(jpContainer);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

}
