import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


/**
 * 
 * @author
 *
 */
public class GuiDesign extends JFrame{
	
	
	private JButton b;
	private JPasswordField p;
	

	@SuppressWarnings("unused")
	public static void dialogBoxes(){
		String s = JOptionPane.showInputDialog("Please enter a number");
		int x = Integer.parseInt(s);
		JOptionPane.showMessageDialog(null, "The number you entered is " + x);
		
	}
	
	public GuiDesign(){
		super("GUI_test");
		super.setSize(500, 600);
		super.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		FlowLayout f = new FlowLayout();
		this.setLayout(f);
		JLabel j = new JLabel("Label ME.");
		this.add(j);
		JTextField t = new JTextField("This is text field", 10);
		t.setEditable(false);
		this.add(t);
		this.p = new JPasswordField("", 10);
		this.add(p);
		this.b = new JButton("click me");
		this.add(b);
		JCheckBox box = new JCheckBox("check me");
		this.add(box);
		gActionListener g = new gActionListener();
		b.addActionListener(g);
		//JLabel
		//JTextField of size 10, with text already inside - uneditable
		//JPassword Field
		//JButton with the text Click Me
		//JCheckBox
		super.setVisible(true);
	}

	
	public static void main(String[] args) {
		
//		dialogBoxes();

		new GuiDesign();
		
	}
	private class gActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			String s = p.getPassword().toString();
			System.out.println(s);
		}
		
	}
	

}
