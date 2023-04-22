import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class EtudiantGUI {

	private JFrame frame;
	private Etudiant etudiant;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args, Etudiant etudiant) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EtudiantGUI window = new EtudiantGUI(etudiant);
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
	public EtudiantGUI(Etudiant etudiant) {
		this.etudiant = etudiant;
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
		jlPrenom.setText(etudiant.getPrenom());
		jlPrenom.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(jlPrenom);
		
		JLabel jlNom = new JLabel("New label");
		jlNom.setBounds(28, 90, 246, 39);
		jlNom.setText(etudiant.getNom());
		jlNom.setHorizontalAlignment(SwingConstants.CENTER);
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
		jlFermeture.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(jlFermeture);
		
		JButton jbPlanning = new JButton("Bouton Planning");
		ImageIcon imagePlanning = new ImageIcon("Images\\\\bouton_planning.png");
		Image imageP = imagePlanning.getImage();
		jbPlanning.setBounds(28, 228, 259, 94);
		int widthP = jbPlanning.getWidth() +10;
		int heightP = jbPlanning.getHeight();
		Image scaledImageP = imageP.getScaledInstance(widthP, heightP, Image.SCALE_SMOOTH);
		jbPlanning.setIcon(new ImageIcon(scaledImageP));
		System.out.println("Largeur : "+jbPlanning.getWidth());
		System.out.println("Hauteur : "+jbPlanning.getHeight());
		System.out.println("Largeur icon : "+ new ImageIcon(scaledImageP).getIconWidth());
		System.out.println("Hauteur icon : "+ new ImageIcon(scaledImageP).getIconHeight());
		frame.getContentPane().add(jbPlanning);
		
		JButton jbNotes = new JButton("Label Notes");
		ImageIcon imageNotes = new ImageIcon("Images\\\\bouton_notes.png");
		Image imageN = imageNotes.getImage();
		jbNotes.setBounds(28, 342, 259, 94);
		int widthN = jbNotes.getWidth() + 10;
		int heightN = jbNotes.getHeight();
		Image scaledImageN = imageN.getScaledInstance(widthN, heightN, Image.SCALE_SMOOTH);
		jbNotes.setIcon(new ImageIcon(scaledImageN));
		frame.getContentPane().add(jbNotes);
		
		JButton jbAbsenceNormale = new JButton("Bouton Absences Normales");
		ImageIcon imageAbsences = new ImageIcon("Images\\\\bouton_absences.png");
		Image imageA = imageAbsences.getImage();
		jbAbsenceNormale.setBounds(339, 228, 259, 94);
		int widthA = jbAbsenceNormale.getWidth() +10;
		int heightA = jbAbsenceNormale.getHeight();
		Image scaledImageA = imageA.getScaledInstance(widthA, heightA, Image.SCALE_SMOOTH);
		jbAbsenceNormale.setIcon(new ImageIcon(scaledImageA));
		frame.getContentPane().add(jbAbsenceNormale);
		
		JButton jbAbsenceDistanciel = new JButton("Bouton Absences Distanciel");
		ImageIcon imageDistanciel = new ImageIcon("Images\\\\bouton_distanciel.png");
		Image imageD = imageDistanciel.getImage();
		jbAbsenceDistanciel.setBounds(339, 342, 259, 94);
		int widthD = jbAbsenceDistanciel.getWidth() +10;
		int heightD = jbAbsenceDistanciel.getHeight();
		Image scaledImageD = imageD.getScaledInstance(widthD, heightD, Image.SCALE_SMOOTH);
		jbAbsenceDistanciel.setIcon(new ImageIcon(scaledImageD));
		frame.getContentPane().add(jbAbsenceDistanciel);
		
		JButton jbDeconnexion = new JButton("Bouton Deconnexion");
		jbDeconnexion.setBounds(634, 228, 129, 208);
		ImageIcon imageQuitter = new ImageIcon("Images\\\\bouton_quitter.png");
		Image imageQ = imageQuitter.getImage();
		System.out.println("Largeur : "+jbDeconnexion.getWidth());
		System.out.println("Hauteur : "+jbDeconnexion.getHeight());
		int widthQ = jbDeconnexion.getWidth() +10;
		int heightQ = jbDeconnexion.getHeight();
		Image scaledImageQ = imageQ.getScaledInstance(widthQ, heightQ, Image.SCALE_SMOOTH);
		jbDeconnexion.setIcon(new ImageIcon(scaledImageQ));
		frame.getContentPane().add(jbDeconnexion);
		
		
		jbAbsenceDistanciel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new InterfaceMenuAbsenceDistanciel("EsigServices", 800, 800, etudiant);
				frame.dispose();
			}
		});
		
		jbDeconnexion.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new InterfaceLogin("EsigServices").main(null);
				frame.dispose();
			}
		});
	}
}
