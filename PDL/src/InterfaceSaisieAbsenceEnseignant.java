import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class InterfaceSaisieAbsenceEnseignant extends JFrame{
	
	private Enseignant enseignant;
	private JPanel jpContainer;
	private JLabel jlMessageInformation;
	private JPanel jpContainerDebut;
	private JLabel jlMessageDebut;
	private JFormattedTextField jfSaisieDebut;
	private JPanel jpContainerFin;
	private JLabel jlMessageFin;
	private JFormattedTextField jfSaisieFin;
	private JPanel jpContainerBoutons;
	private JButton jbRetour;
	private JButton jbInsertionAbsence;
	
	public InterfaceSaisieAbsenceEnseignant(String titre, int width, int height, Enseignant enseignant)
	{
		this.setTitle(titre);
		this.setSize(width, height);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		
		jpContainer = new JPanel();
		jpContainer.setLayout(new GridLayout(4, 1));
		
		jlMessageInformation = new JLabel();
		jlMessageInformation.setText("Veuillez saisir les dates de debut et de fin de votre absence");
		jlMessageInformation.setHorizontalAlignment(SwingConstants.CENTER);
		jpContainer.add(jlMessageInformation);
		
		jpContainerDebut = new JPanel();
		jpContainerDebut.setLayout(new GridLayout(1, 2));
		
		jlMessageDebut = new JLabel();
		jlMessageDebut.setText("Date debut :");
		jlMessageDebut.setHorizontalAlignment(SwingConstants.CENTER);
		jpContainerDebut.add(jlMessageDebut);
		
		jfSaisieDebut = new JFormattedTextField(dateFormat);
        jfSaisieDebut.setValue(new Date());
        jfSaisieDebut.setHorizontalAlignment(SwingConstants.CENTER);
        jpContainerDebut.add(jfSaisieDebut);
        
        jpContainer.add(jpContainerDebut);
        
        jpContainerFin = new JPanel();
		jpContainerFin.setLayout(new GridLayout(1, 2));
		
		jlMessageFin = new JLabel();
		jlMessageFin.setText("Date fin :");
		jlMessageFin.setHorizontalAlignment(SwingConstants.CENTER);
		jpContainerFin.add(jlMessageFin);
		
		jfSaisieFin = new JFormattedTextField(dateFormat);
        jfSaisieFin.setValue(new Date());
        jfSaisieFin.setHorizontalAlignment(SwingConstants.CENTER);
        jpContainerFin.add(jfSaisieFin);
        
        jpContainer.add(jpContainerFin);
        
        jpContainerBoutons = new JPanel();
        jpContainerBoutons.setLayout(new GridLayout(1, 2));
        
        jbRetour = new JButton();
		jbRetour.setText("Retour");
		jbRetour.setHorizontalAlignment(SwingConstants.CENTER);
		jpContainerBoutons.add(jbRetour);
		
		jbInsertionAbsence = new JButton();
		jbInsertionAbsence.setText("Inserer l'absence");
		jbInsertionAbsence.setHorizontalAlignment(SwingConstants.CENTER);
		jpContainerBoutons.add(jbInsertionAbsence);
		
		jpContainer.add(jpContainerBoutons);
		
		jbRetour.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
				new InterfaceEnseignant("EsigServices", 800, 800, enseignant);
				
			}
		});
        
        
        
        this.setContentPane(jpContainer);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
        
	}

}
