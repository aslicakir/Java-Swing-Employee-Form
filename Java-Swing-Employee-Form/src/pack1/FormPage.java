package pack1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class FormPage extends JFrame {

	private JPanel contentPane;
	private JTextField txtName;
	private JLabel lblSurname;
	private JTextField txtSurname;
	private JLabel lblAge;

	ArrayList<Employee> employees = new ArrayList<>();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					
					FormPage frame = new FormPage();
					frame.setVisible(true);
					
					
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FormPage() {
		setTitle("Form Page");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(10, 32, 84, 14);
		contentPane.add(lblName);
		
		txtName = new JTextField();
		txtName.setBounds(104, 29, 86, 20);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		lblSurname = new JLabel("Surname");
		lblSurname.setBounds(10, 74, 84, 14);
		contentPane.add(lblSurname);
		
		txtSurname = new JTextField();
		txtSurname.setBounds(104, 71, 86, 20);
		contentPane.add(txtSurname);
		txtSurname.setColumns(10);
		
		lblAge = new JLabel("Age");
		lblAge.setBounds(10, 123, 46, 14);
		contentPane.add(lblAge);
		
		JComboBox cbAge = new JComboBox();
		cbAge.setBounds(104, 119, 51, 22);
		contentPane.add(cbAge);
				
		for (int i = 18; i < 66; i++) {
			cbAge.addItem(i);
		}
		
		JLabel City = new JLabel("City");
		City.setBounds(10, 166, 46, 14);
		contentPane.add(City);
		
		String [] cities = {"Ankara","Antalya","Bursa","Istanbul"};
		
		JComboBox cbCity = new JComboBox(cities);
		cbCity.setBounds(104, 162, 86, 22);
		contentPane.add(cbCity);
		
		
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setBounds(222, 32, 46, 14);
		contentPane.add(lblGender);
		
		JRadioButton rdMale = new JRadioButton("Male");
		rdMale.setBounds(213, 53, 73, 23);
		contentPane.add(rdMale);
		rdMale.setActionCommand("Male");
		
		JRadioButton rdFemale = new JRadioButton("Female");
		rdFemale.setBounds(213, 79, 67, 23);
		contentPane.add(rdFemale);
		rdFemale.setActionCommand("Female");
		
		ButtonGroup genderGroup = new ButtonGroup();
		genderGroup.add(rdFemale);
		genderGroup.add(rdMale);
		
		JLabel lblLanguage = new JLabel("Languages");
		lblLanguage.setBounds(301, 32, 91, 14);
		contentPane.add(lblLanguage);
		
		JCheckBox chEnglish = new JCheckBox("English");
		chEnglish.setBounds(295, 53, 97, 23);
		contentPane.add(chEnglish);
		chEnglish.setActionCommand("English");
		
		JCheckBox chSpanish = new JCheckBox("Spanish");
		chSpanish.setBounds(295, 79, 97, 23);
		contentPane.add(chSpanish);
		chSpanish.setActionCommand("Spanish");
		
		JCheckBox chGerman = new JCheckBox("German");
		chGerman.setBounds(295, 105, 97, 23);
		contentPane.add(chGerman);
		chGerman.setActionCommand("German");
		
		ArrayList<JCheckBox> boxes = new ArrayList<>();
		boxes.add(chGerman);
		boxes.add(chEnglish);
		boxes.add(chSpanish);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Employee emp = new Employee();
				emp.setName( txtName.getText() );
				emp.setSurname( txtSurname.getText() );
				emp.setAge( Integer.parseInt( cbAge.getSelectedItem().toString() ) );
				emp.setCity( cbCity.getSelectedItem().toString() );
				emp.setGender( genderGroup.getSelection().getActionCommand() );
				
				emp.languages = new ArrayList<>();
				
				for (JCheckBox box : boxes) {
					if(box.isSelected()) { emp.languages.add( box.getActionCommand() ); }
				}
				
				employees.add(emp);
				
				JOptionPane.showMessageDialog(null, "Employee Saved!");
				
				System.out.println(employees);
				
			}
		});
		btnSubmit.setBounds(276, 162, 89, 23);
		contentPane.add(btnSubmit);
	}
}
