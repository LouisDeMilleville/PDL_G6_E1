import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class InterfaceMenuAbsenceDistanciel extends JFrame {
	
	private Etudiant etudiant;
	
	private JPanel jpContainer;
	private JButton jbListeAbsences;
	private JButton jbSaisirAbsence;
	private JButton jbRetour;

	
	public InterfaceMenuAbsenceDistanciel(String titre, int width, int height, Etudiant etudiant)
	{
		this.setTitle(titre);
		this.setSize(width, height);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.etudiant = etudiant;
		
		jpContainer = new JPanel();
		jpContainer.setLayout(new GridLayout(3, 1));
		
		jbListeAbsences = new JButton();
		jbListeAbsences.setText("Consulter mes absences en distanciel");
		jbListeAbsences.setHorizontalAlignment(SwingConstants.CENTER);
		jpContainer.add(jbListeAbsences);
		
		jbSaisirAbsence = new JButton();
		jbSaisirAbsence.setText("Saisir une absence en distanciel");
		jbSaisirAbsence.setHorizontalAlignment(SwingConstants.CENTER);
		jpContainer.add(jbSaisirAbsence);
		
		jbRetour = new JButton();
		jbRetour.setText("Retour");
		jbRetour.setHorizontalAlignment(SwingConstants.CENTER);
		jpContainer.add(jbRetour);
		
		jbRetour.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new InterfaceEleve("EsigServices", 800, 800, etudiant);
				dispose();
			}
		});
		
		jbListeAbsences.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new InterfaceAffichageAbsenceDistanciel("EsigServices", 800, 800, etudiant);
				dispose();
				
			}
		});
		
		jbSaisirAbsence.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new InterfaceSaisieAbsenceDistanciel("EsigServices", 800, 800, etudiant);
				dispose();
			}
		});
		
		this.setContentPane(jpContainer);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
