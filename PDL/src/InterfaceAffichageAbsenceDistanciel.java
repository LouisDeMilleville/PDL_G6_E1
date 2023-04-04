import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class InterfaceAffichageAbsenceDistanciel extends JFrame{
	
	private Etudiant etudiant;
	
	private JPanel jpContainer;
	private JPanel jpContainerDetails;
	private InteractionBDD moduleBDD;
	private ArrayList<AbsenceDistanciel> listAbs;
	private JLabel jlDuree, jlJustif, jlEtat, jlMatiere;
	private JButton jbRetour;
	
	public InterfaceAffichageAbsenceDistanciel(String titre, int width, int height, Etudiant etudiant) {
		// TODO Auto-generated constructor stub
		this.setTitle(titre);
		this.setSize(width, height);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.etudiant = etudiant;
		
		//Recuperer le nombre d'absences pour définir la taille du layout
		
		listAbs = new ArrayList<AbsenceDistanciel>();
		
		moduleBDD = new InteractionBDD();
		
		listAbs = moduleBDD.getListAbsenceDistanciel(etudiant);
		
		jpContainer = new JPanel();
		jpContainer.setLayout(new GridLayout(listAbs.size() + 2, 1));
		
		jpContainerDetails = new JPanel();
		jpContainerDetails.setLayout(new GridLayout(1, 4));
		
		jlDuree = new JLabel();
		jlDuree.setText("Duree");
		jlDuree.setHorizontalAlignment(SwingConstants.CENTER);
		jpContainerDetails.add(jlDuree);
		
		jlJustif = new JLabel();
		jlJustif.setText("Justification");
		jlJustif.setHorizontalAlignment(SwingConstants.CENTER);
		jpContainerDetails.add(jlJustif);
		
		jlEtat = new JLabel();
		jlEtat.setText("Etat");
		jlEtat.setHorizontalAlignment(SwingConstants.CENTER);
		jpContainerDetails.add(jlEtat);
		
		jlMatiere = new JLabel();
		jlMatiere.setText("Matiere");
		jlMatiere.setHorizontalAlignment(SwingConstants.CENTER);
		jpContainerDetails.add(jlMatiere);
		
		jpContainer.add(jpContainerDetails);
		
		for(int i = 0 ; i < listAbs.size() ; i++)
		{
			JLabel jlDur, jlJust, jlEt, jlMat;
			JPanel SousContainer = new JPanel();
			SousContainer.setLayout(new GridLayout(1, 4));
			jlDur = new JLabel();
			jlJust = new JLabel();
			jlEt = new JLabel();
			jlMat = new JLabel();
			jlDur.setText(""+ listAbs.get(i).getDuree());
			jlDur.setHorizontalAlignment(SwingConstants.CENTER);
			SousContainer.add(jlDur);
			
			jlJust.setText(listAbs.get(i).getJustificatif());
			jlJust.setHorizontalAlignment(SwingConstants.CENTER);
			SousContainer.add(jlJust);
			
			switch(listAbs.get(i).getEtat())
			{
			case 0:
				jlEt.setText("En attente");
				break;
			case 1:
				jlEt.setText("Validee");
				break;
			case 2:
				jlEt.setText("Refusee");
				break;
				default:
					jlEt.setText("Erreur");
			}
			
			jlEt.setHorizontalAlignment(SwingConstants.CENTER);
			SousContainer.add(jlEt);
			
			jlMat.setText(listAbs.get(i).getMatiere());
			jlMat.setHorizontalAlignment(SwingConstants.CENTER);
			SousContainer.add(jlMat);
			
			jpContainer.add(SousContainer);
			
			
		}
		
		jbRetour = new JButton();
		jbRetour.setText("Retour");
		jbRetour.setHorizontalAlignment(SwingConstants.CENTER);
		jpContainer.add(jbRetour);
		
		jbRetour.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new InterfaceMenuAbsenceDistanciel("EsigServices", width, height, etudiant);
				dispose();
			}
		});
		
		this.setContentPane(jpContainer);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

}
