package Calculator;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
   A class that solves infix expressions through a GUI created
   using Java's swing libraries.
   @author Jesse Grabowski
   @author Joseph Erickson
   @version 5.0
 */
public class CalculatorGUI extends JFrame implements ActionListener
{
	// JFrames are a container that represents a window.
	// Buttons are declared here so they can be referred to by any method in the class.
	private JButton zero_button, one_button, two_button, three_button,
					four_button, five_button, six_button, seven_button,
					eight_button, nine_button, add_button, subtract_button,
					multiply_button, divide_button, clear_button, quit_button,
					equals_button, open_button, close_button, back_button;
	
	// The place where the infix expression is displayed.
	private JLabel display = new JLabel("                                "); 
	private JPanel button_holder = new JPanel();

	String currentInfix = "";
	String empty_string = "                                ";

	public CalculatorGUI()
	{
		super("Infix Calc"); // Changes the text in the title bar of the window
		setSize(new Dimension(200, 200)); // Sets the size of the window
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());

		// Instantiates all 20 buttons
		zero_button = new JButton("0");
		one_button = new JButton("1");
		two_button = new JButton("2");
		three_button = new JButton("3");
		four_button = new JButton("4");
		five_button = new JButton("5");
		six_button = new JButton("6");
		seven_button = new JButton("7");
		eight_button = new JButton("8");
		nine_button = new JButton("9");
		add_button = new JButton("+");
		subtract_button = new JButton("-");
		multiply_button = new JButton("*");
		divide_button = new JButton("/");
		clear_button = new JButton("C");
		quit_button = new JButton("Q");
		equals_button = new JButton("=");
		open_button = new JButton("(");
		close_button = new JButton(")");
		back_button = new JButton("<");

		// ActionListener definitions
		zero_button.addActionListener(this);
		one_button.addActionListener(this);
		two_button.addActionListener(this);
		three_button.addActionListener(this);
		four_button.addActionListener(this);
		five_button.addActionListener(this);
		six_button.addActionListener(this);
		seven_button.addActionListener(this);
		eight_button.addActionListener(this);
		nine_button.addActionListener(this);
		add_button.addActionListener(this);
		subtract_button.addActionListener(this);
		multiply_button.addActionListener(this);
		divide_button.addActionListener(this);
		clear_button.addActionListener(this);
		quit_button.addActionListener(this);
		equals_button.addActionListener(this);
		open_button.addActionListener(this);
		close_button.addActionListener(this);
		back_button.addActionListener(this);
		
		// Setting action commands
		zero_button.setActionCommand("0");
		one_button.setActionCommand("1");
		two_button.setActionCommand("2");
		three_button.setActionCommand("3");
		four_button.setActionCommand("4");
		five_button.setActionCommand("5");
		six_button.setActionCommand("6");
		seven_button.setActionCommand("7");
		eight_button.setActionCommand("8");
		nine_button.setActionCommand("9");
		add_button.setActionCommand("+");
		subtract_button.setActionCommand("-");
		multiply_button.setActionCommand("*");
		divide_button.setActionCommand("/");
		clear_button.setActionCommand("C");
		quit_button.setActionCommand("Q");
		equals_button.setActionCommand("=");
		open_button.setActionCommand("(");
		close_button.setActionCommand(")");
		back_button.setActionCommand("<");

		display.setMinimumSize(new Dimension(180, 20));
		add(display, BorderLayout.NORTH);
		
		// Creates a 5-high, 4-wide grid for the buttons.
		button_holder.setLayout(new GridLayout(5, 4));
		setVisible(true);
		
		// Adding our buttons into the JFrame
		button_holder.add(clear_button);
		button_holder.add(back_button);
		button_holder.add(quit_button);
		button_holder.add(divide_button);
		button_holder.add(seven_button);
		button_holder.add(eight_button);
		button_holder.add(nine_button);
		button_holder.add(multiply_button);
		button_holder.add(four_button);
		button_holder.add(five_button);
		button_holder.add(six_button);
		button_holder.add(subtract_button);
		button_holder.add(one_button);
		button_holder.add(two_button);
		button_holder.add(three_button);
		button_holder.add(add_button);
		button_holder.add(zero_button);
		button_holder.add(open_button);
		button_holder.add(close_button);
		button_holder.add(equals_button);
		
		add(button_holder, BorderLayout.CENTER);
		
		

		//Add code here make the calculator visable // So that we can see the calculator
	} // end constructor

	public void actionPerformed(ActionEvent e)
	{
		String cmd = e.getActionCommand();
		if (cmd.equals("Q"))
			System.exit(0);
		else if (cmd.equals("<") && currentInfix.length() > 0)
			currentInfix = currentInfix.substring(0, currentInfix.length()-1);
		else if (cmd.equals("C"))
			currentInfix = "";
		else if (cmd.equals("="))
		{
			System.out.println(currentInfix);
			//Add code here evaluate infix operator and operands to the valuable answer
			double answer = 0;
			System.out.println(answer);
			if (answer == Double.NaN)
			{
				currentInfix = "";
				display.setText("ERROR");
				return;
			} // end if
			else if (answer == Double.POSITIVE_INFINITY ||
					answer == Double.NEGATIVE_INFINITY)
			{
				currentInfix = "";
				display.setText("DIVISION BY ZERO");
				return;
			} // end else if
			else
			{
				currentInfix = "";
				display.setText(Integer.toString((int)answer));
				return;
			} // end else
		} // end else if
		else
			currentInfix += cmd;
		if (currentInfix.length() > 0)
			display.setText(currentInfix);
		else
			display.setText(empty_string);
	} // end actionPerformed

	public static void main(String[] args)
	{
		CalculatorGUI gui = new CalculatorGUI();
	} // end main
} // end CalculatorGUI
