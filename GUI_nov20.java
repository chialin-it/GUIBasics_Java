import javax.swing.JOptionPane; //For messageDialog
import javax.swing.JFrame; // Provides basic window features
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import java.util.Scanner;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.Font; //To modify labels
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.lang.NumberFormatException;


/*import java.awt.GridLayout;
 
 default constructor
 public className()
 {
 	super("JFrame title");
 	setLayout (new GridLayout (row, column));	//setLayout(new FlowLayout());
 
 	Set JFrame
 	setSize (width, height);
 	setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
 	setVisible (true);
 }
*/


/*
textField.setText("");
textField.setEditable(false);

textField.setFont(new Font("", Font.BOLD, 12));
jButton.setBackground (Color.BLUE);
jButton.setForeground(Color.RED); //text color

@Override
public void actionPerformed (ActionEvent e)
{
	jButton.getText();
	e.getSource();
	String.valueOf(e.getActionCommand());
}
JOptionPane.showMessageDialog(null,"Message in the box");
JOptionPane.showMessageDialog(null,"Message", "Title", JOptionPane.PLAIN_MESSAGE);
													i  JOptionPane.INFORMATION_MESSAGE
												red x  JOptionPane.ERROR_MESSAGE
										   triangle i  JOptionPane.WARNING_MESSAGE
*/ 

/*
Icon imageCat1 = new ImageIcon ("blackCat.jpg");
labelCatImage = new JLabel("", imageCat1, SwingConstants.CENTER);
labelCatImage.setToolTipText("I am Cat");
labelCatImage.setIcon(imageCat2);

labelCatImage = new JLabel("", new ImageIcon ("blackCat.jpg"), SwingConstants.CENTER);
*/


class allGUI extends JFrame implements ActionListener
{
	private final JTextField tfWelcome;
	private final JButton [] jbArray = new JButton [4];
	private final JTextField tfTypeSomething = new JTextField ("Enter text");
	private final JPasswordField pwField =  new JPasswordField ("Hidden");
	private final String pw = "abcd";
	
	private Icon imageCat1 = new ImageIcon ("blackCat.jpg");
	private Icon imageCat2 = new ImageIcon ("whiteCat.jpg");
	private final JLabel labelCatImage;
	
	public allGUI()
	{
		super("Test All GUI functions");
		setLayout(new FlowLayout());
		
		tfWelcome = new JTextField ("", 20);
		tfWelcome.setText("Welcome");
		//tfWelcome.setEditable(false);
		tfWelcome.setFont(new Font("", Font.BOLD, 24));
		add(tfWelcome);
		
		jbArray[0] = new JButton ("Hi");
		jbArray[1] = new JButton ("Bye");
		jbArray[2] = new JButton ("Click to open InputDialog");
		jbArray[3] = new JButton ("Change cat");
		
		for(int i = 0; i<jbArray.length; i++)
		{
			jbArray[i].addActionListener(this);
			add(jbArray[i]);
		}
		
		labelCatImage = new JLabel("", imageCat1, SwingConstants.CENTER);
		labelCatImage.setToolTipText("Black Cat");
		
		tfTypeSomething.addActionListener(this);
		pwField.addActionListener(this);
		
		add(tfTypeSomething);
		add(pwField);
		add(labelCatImage);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800,400);
		setVisible (true);
	}
	
	@Override
	public void actionPerformed (ActionEvent e)
	{
		if (e.getSource() == jbArray[0])
			tfWelcome.setText(String.valueOf(jbArray[0].getText()));
			
		else if (e.getSource() == jbArray[1])
			tfWelcome.setText(String.valueOf(jbArray[1].getText()));
			
		else if (e.getSource() == jbArray[2])
		{
			try
			{
				String str = JOptionPane.showInputDialog("Enter your mark");
				int mark = Integer.parseInt(str);
				
				if(mark >= 50)
					str = "You passed";
				else
					str = "You failed";
				
				JOptionPane.showMessageDialog(null, str, "Your grade", JOptionPane.INFORMATION_MESSAGE);
			}
			catch (NumberFormatException ex)
			{
				JOptionPane.showMessageDialog(null,"Number Format Error", "Error", JOptionPane.ERROR_MESSAGE);
			}
			finally
			{
				JOptionPane.showMessageDialog(null,"Work harder in future", "WARNING", JOptionPane.WARNING_MESSAGE);
			}
		}	
			
		else if (e.getSource() == tfTypeSomething)
			JOptionPane.showMessageDialog(null, String.valueOf(e.getActionCommand()));
		
		else if(e.getSource() == pwField)
		{
			if(pw.equals(String.valueOf(e.getActionCommand())))
				JOptionPane.showMessageDialog(null, "Correct password");
			else
				JOptionPane.showMessageDialog(null, "Wrong password");
		}
		else if(e.getSource() == jbArray[3])
		{	
			labelCatImage.setIcon(imageCat2);
			labelCatImage.setToolTipText("White Cat");
		}
	}
}

class GUI_nov20
{
	public static void main (String [] args)
	{
		allGUI ag = new allGUI();
	}
}