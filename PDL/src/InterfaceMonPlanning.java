import java.awt.*;

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
import com.toedter.calendar.JDayChooser;
import com.toedter.calendar.JMonthChooser;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;


	public class InterfaceMonPlanning extends JFrame{
		
		private Enseignant enseignant;
		private JPanel jpContainer;
		private JPanel jpSousContainer;
		private JLabel jlMessageInformation;
		private JPanel jpContainerDateduCours;
		private JLabel jlDateduCours;
		private JPanel jpContainerHeure;
		private JLabel jlHeure;
		private JPanel jpContainerCours;
		private JLabel jlCours;
		private JPanel jpContainerGroupe;
		private JLabel jlGroupe;
		private JPanel jpContainerBoutons;
		private JButton jbRetour;
		private JDayChooser dayChooser;
		private DateEtHeure datecours;
		
		
		
		
		public InterfaceMonPlanning(String titre, int width, int height, Enseignant enseignant)
		{
			this.setTitle(titre);
			this.setSize(485, 204);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			Panel Calen = new Panel();
			jpContainer = new JPanel();  
	        jpContainer.setLayout(null);
	       JCalendar calendar = new JCalendar();
	       Calen.add(calendar);
	       jpContainer.add(Calen);
	       
	        /*JDateChooser dateChooser = new JDateChooser();
	        dateChooser.setBounds(46, 39, 189, 91);
	        jpContainer.add(dateChooser);
			        JButton button = new JButton("Get Date");
			        button.setHorizontalAlignment(SwingConstants.CENTER);
					jpContainer.add(button);
					//jpContainer.add(jpSousContainer);
					
			        this.setContentPane(jpContainer);
			        this.setLocationRelativeTo(null);
					this.setVisible(true);
					
			        button.addActionListener(new ActionListener() {
			            public void actionPerformed(ActionEvent e) {
			                Date selectedDate = dateChooser.getDate();
			                System.out.println("Selected date: " + selectedDate);
			            }
			        });*/
			
	       this.setContentPane(jpContainer);
	        this.setLocationRelativeTo(null);
			this.setVisible(true);
			
			    
	        
		}
	}
