package insurance;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;

public class RegisterGUI extends JFrame{

	JPanel gui;
	JLabel labFirstName;
	JTextField tfFirstName;
	JLabel labLastName;
	JTextField tfLastName;
	JLabel labAddress;
	JTextField tfAddress;
	JLabel labZipCode;
	JTextField tfZipCode;
	JLabel labGender;
	JComboBox jcGender;
	JLabel labMarried;
	JCheckBox cbMarried;
	JLabel labAge;
	JTextField tfAge;	
	JButton checkAmount;
	JButton checkAvailability;
	JButton registerClient;
	JLabel labAmount;
	JLabel labAvailability;
	
	static final String TEMP_FILE = "registrations.csv";
	
	public RegisterGUI()
	{	
		initUI();	//Créer un frame
	}

    public static void setUIFont(FontUIResource f) {
        Enumeration keys = UIManager.getDefaults().keys();
        while (keys.hasMoreElements()) {
            Object key = keys.nextElement();
            Object value = UIManager.get(key);
            if (value instanceof FontUIResource) {
                FontUIResource orig = (FontUIResource) value;
                Font font = new Font(f.getFontName(), orig.getStyle(), f.getSize());
                UIManager.put(key, new FontUIResource(font));
            }
        }
    }
	
	public void initUI()
	{
		//Set les paramêtres du nouveau frame
		
		setTitle("Insurance Registration");
		setSize(1200,800);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);		
		this.getContentPane().setLayout(null);
		createInterface();
	}
	
	public void createInterface()
	{
		gui = new JPanel();
		gui.setLayout(new GridLayout(10,2));
		labFirstName = new JLabel("First Name");
		tfFirstName = new JTextField("",25);
		gui.add(labFirstName);
		gui.add(tfFirstName);
		labLastName = new JLabel("Last Name");
		tfLastName = new JTextField("",25);
		gui.add(labLastName);
		gui.add(tfLastName);
		labAddress = new JLabel("Address");
		tfAddress = new JTextField("",25);
		gui.add(labAddress);
		gui.add(tfAddress);
		labZipCode = new JLabel("ZipCode");
		tfZipCode = new JTextField("",25);
		gui.add(labZipCode);
		gui.add(tfZipCode);		
		labGender = new JLabel("Gender");
		jcGender = new JComboBox();
		jcGender.addItem("Male");
		jcGender.addItem("Female");
		//jcGender.addItem("Other");
		gui.add(labGender);
		gui.add(jcGender);		
		labAge = new JLabel("Age");
		tfAge = new JTextField("",25);
		gui.add(labAge);
		gui.add(tfAge);	
		labMarried = new JLabel("Married");
		cbMarried = new JCheckBox();		
		gui.add(labMarried);
		gui.add(cbMarried);	
		
//		gui.add(new JLabel("__"));
//		gui.add(new JLabel("__"));
		
		
		checkAmount = new JButton("Check Amount");
		labAmount = new JLabel("--");
		checkAvailability = new JButton("Check Availability");
		labAvailability = new JLabel("--");
		registerClient = new JButton("Register Client");
		gui.add(checkAmount);
		gui.add(labAmount);		
		gui.add(checkAvailability);
		gui.add(labAvailability);
		gui.add(registerClient);
		
		checkAmount.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String _gender = (String) jcGender.getSelectedItem();
				int _age = Integer.parseInt(tfAge.getText());
				boolean _married = cbMarried.isSelected();				
				labAmount.setText(""+Person.computePremium(_gender, _age, _married));
			}
			
		});
		
		
	}
	
	//Fonction main qui sera la première fonction par défaut qui sera appellé lors de l'exécution du programme
	public static void main(String[] args)
	{
		setUIFont(new FontUIResource(new Font("Arial", 0, 40)));
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run(){				
				RegisterGUI frame = new RegisterGUI(); //Création du GameFrame
				frame.setContentPane(frame.gui);
				frame.setVisible(true);
				
				//				 gameView = new GameView(game); //Création du GameView lié au nouveau GameFrame
//				 gameModel = new GameModel();  //Création du GameModel lié au nouveau GameFrame
//			     game.setVisible(true); //Rend notre nouveau frame visible
			}		
		});	
	}
	
}
