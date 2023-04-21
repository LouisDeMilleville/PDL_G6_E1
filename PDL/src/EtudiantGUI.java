import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class EtudiantGUI {

	private JFrame frame;
	private Etudiant etudiant;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EtudiantGUI window = new EtudiantGUI();
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
	public EtudiantGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("EsigServices");
		frame.getContentPane().setLayout(null);
		
		JLabel jlPrenom = new JLabel("New label");
		jlPrenom.setBounds(28, 35, 246, 45);
		frame.getContentPane().add(jlPrenom);
		
		JLabel jlNom = new JLabel("New label");
		jlNom.setBounds(28, 90, 246, 39);
		frame.getContentPane().add(jlNom);
		
		ImageIcon imageIcon = new ImageIcon("Images\\\\logo_esig.png");
		Image image = imageIcon.getImage();
		
		
		
		JLabel jlLogo = new JLabel("New label");
		
		
		jlLogo.setBounds(312, 35, 451, 94);
		int width = jlLogo.getWidth();
		int height = jlLogo.getHeight();
		Image scaledImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		jlLogo.setIcon(new ImageIcon(scaledImage));
		frame.getContentPane().add(jlLogo);
		
		JLabel jlFermeture = new JLabel("Label Fermeture");
		jlFermeture.setBounds(28, 139, 735, 52);
		frame.getContentPane().add(jlFermeture);
		
		JLabel jlPlanning = new JLabel("Label Planning");
		ImageIcon imagePlanning = new ImageIcon("Images\\\\bouton_planning.png");
		Image imageP = imagePlanning.getImage();
		jlPlanning.setBounds(28, 228, 259, 94);
		int widthP = jlPlanning.getWidth();
		int heightP = jlPlanning.getHeight();
		Image scaledImageP = imageP.getScaledInstance(widthP, heightP, Image.SCALE_SMOOTH);
		jlPlanning.setIcon(new ImageIcon(scaledImageP));
		System.out.println("Largeur : "+jlPlanning.getWidth());
		System.out.println("Hauteur : "+jlPlanning.getHeight());
		frame.getContentPane().add(jlPlanning);
		
		JLabel jlNotes = new JLabel("Label Notes");
		ImageIcon imageNotes = new ImageIcon("Images\\\\bouton_notes.png");
		Image imageN = imageNotes.getImage();
		jlNotes.setBounds(28, 342, 259, 94);
		int widthN = jlNotes.getWidth();
		int heightN = jlNotes.getHeight();
		Image scaledImageN = imageN.getScaledInstance(widthN, heightN, Image.SCALE_SMOOTH);
		jlNotes.setIcon(new ImageIcon(scaledImageN));
		frame.getContentPane().add(jlNotes);
		
		JLabel jlAbsenceNormale = new JLabel("Label Absences Normales");
		jlAbsenceNormale.setBounds(339, 228, 259, 94);
		frame.getContentPane().add(jlAbsenceNormale);
		
		JButton jbAbsenceDistanciel = new JButton("Bouton Absences Distanciel");
		jbAbsenceDistanciel.setBounds(339, 342, 259, 94);
		frame.getContentPane().add(jbAbsenceDistanciel);
		
		JLabel jlDeconnexion = new JLabel("Label Deconnexion");
		jlDeconnexion.setBounds(634, 228, 129, 208);
		frame.getContentPane().add(jlDeconnexion);
		
		
		jbAbsenceDistanciel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new InterfaceMenuAbsenceDistanciel("EsigServices", 800, 800, etudiant);
				frame.dispose();
			}
		});
	}
}
