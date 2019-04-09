package jac444_ws4_5;
import java.awt.*;
import java.awt.FlowLayout;
import java.awt.event.*;
import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class MyJFrame extends JFrame{
	private Student student;
	private final JButton addStudentButton;
	private final JButton showStudentButton;
	private final JButton finishButton;
	private final JButton submitButton;
	private final JButton exitButton;
	private final JButton confirmButton;
	private final JTextField[] fields = {new JTextField(10),new JTextField(10),new JTextField(10)};
	private final JLabel[] labels = {new JLabel("Enter Student ID: "),  new JLabel("Enter First Name: "), 
			new JLabel("Enter Last Name: ")};
	private final JLabel courseLabel;
	private final JTextField courseField;
	
	public static void main(String[] args){
		new MyJFrame();
	}
	
	MyJFrame(){
		super("Student");
		// initialize fields
		student = null;
		courseLabel = new JLabel("Enter courses");
		courseField = new JTextField(20);
		//submit button
		submitButton = new JButton("Save");
		submitButton.setBackground(Color.green);
		submitButton.setOpaque(true);
		submitButton.setBorderPainted(false);
		
		exitButton = new JButton("Done");
		exitButton.setBackground(Color.gray);
		exitButton.setOpaque(true);
		exitButton.setBorderPainted(false);
		
		confirmButton = new JButton("Confirm");
		confirmButton.setBackground(Color.green);
		confirmButton.setOpaque(true);
		confirmButton.setBorderPainted(false);

		addStudentButton = new JButton("Add Student");
		add(addStudentButton, BorderLayout.WEST);
		showStudentButton = new JButton("Show Student");
		add(showStudentButton, BorderLayout.CENTER);
		finishButton = new JButton("Finish");
		finishButton.setBackground(Color.pink);
		finishButton.setOpaque(true);
		finishButton.setBorderPainted(false);
		add(finishButton, BorderLayout.EAST);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(330, 150);
		setResizable(false);
		setVisible(true);
		setLocationRelativeTo(null);
		
		addStudentButton.addActionListener( new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent event){
				addStudent();	
			}
		});
		
		showStudentButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent event){
				showStudent();
			}
		});
		
		finishButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent event){
				System.exit(0);
			}
		});
	}
	
	public void addStudent(){
		StudentObjectOutputStream.openFile();
		
		JFrame studentInfo = new JFrame("Student Infomation");
		studentInfo.setSize(300, 230);
		studentInfo.setVisible(true);
		studentInfo.setLayout(new FlowLayout());
		studentInfo.setLocationRelativeTo(null);
		
		for(int i = 0; i < labels.length; i++){
			studentInfo.add(labels[i]);
			studentInfo.add(fields[i]);
		}

		studentInfo.add(courseLabel);
		studentInfo.add(courseField);
		
		studentInfo.add(submitButton);
		submitButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent event){
				
				getData();

				//clear data and close 
				for(int i = 0; i < fields.length; i++){
					fields[i].setText("");
				}
				courseField.setText("");
				student = null;
				
			}
		});
		
		studentInfo.add(exitButton);
		exitButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent event){
				StudentObjectOutputStream.closeFile();
				studentInfo.dispose();
			}
		});
		
		
	}
	
	public void getData() {
		try {
			student = new Student();
			student.setStID(Integer.parseInt(fields[0].getText()));
			student.setFirstName(fields[1].getText());
			student.setLastName(fields[2].getText());
			
			String courses = courseField.getText();
			String[] tokens = courses.trim().split("\\s+");
			//set the courses
			for(int i = 0; i < tokens.length; i++){
				student.setCourses(tokens[i]);
			}			
			StudentObjectOutputStream.output.writeObject(student);
			
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("Error writing to file!!!");
			return;
		}
	}

	public void showStudent(){
		
		StudentObjectInputStream.openFile();
		
		JFrame showStudentFrame = new JFrame("Show Student");
		JLabel[] labels = { new JLabel("ID"), new JLabel("Name"), new JLabel("Courses")};
		
		showStudentFrame.setSize(200, 400);
		showStudentFrame.setVisible(true);
		showStudentFrame.setLayout(new FlowLayout());
		showStudentFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		showStudentFrame.setLocationRelativeTo(null);
		for(int i = 0; i < labels.length; i++){
			labels[i].setFont(new Font("Calbri", Font.BOLD, 18));
			showStudentFrame.add(labels[i]);
		}

		
		
		try{
			while(true){
				Student student = StudentObjectInputStream.readObject(); //deserialization of object
				JPanel p = new JPanel();
			
//				showStudentFrame.add( new JLabel (String.valueOf(student.getStdID())));
//				showStudentFrame.add( new JLabel (student.getFirstName()));
//				showStudentFrame.add( new JLabel (student.getLastName()));
				p.add(new JLabel (String.valueOf(student.getStdID())));
				p.add(new JLabel (student.getFirstName()));
				p.add(new JLabel (student.getLastName()));
				
				
				ArrayList<String> courses = student.getCourses();
				String[] str = new String[courses.size()];
				JList<String> list = new JList<>(courses.toArray(str));
				p.add(list);
				showStudentFrame.add(p);

			}
		}catch (EOFException endOfFileException) {
			System.out.printf("Read all the file%n");
		}catch (ClassNotFoundException classNotFoundException){
			System.err.println("Invalid object type. Terminating.");
		}catch (IOException err){
			System.err.println("e");
		}finally {
			showStudentFrame.add(confirmButton);
			confirmButton.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent event){
					showStudentFrame.dispose();
				}
			});
			
			StudentObjectInputStream.closeFile();
		}

		
		
	}
}

