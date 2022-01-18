import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.plaf.synth.ColorType;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPage implements ActionListener{
	
	JFrame frame = new JFrame();
	JButton loginButton = new JButton("Login");
	JButton resetButton = new JButton("Reset");
	JTextField UserIDField = new JTextField();
	JPasswordField UserPasswordField = new JPasswordField();
	JLabel userIDLabel = new JLabel("User ID:");
	JLabel userPasswordLabel = new JLabel("Password");
	JLabel messageLabel = new JLabel();
	
	
	HashMap <String, String> logininfo = new HashMap <String, String>();
	
	public LoginPage(HashMap<String, String> logInforOriginal) {
		
		logininfo = logInforOriginal;
		
		userIDLabel.setBounds(50, 100, 75, 25);
		userPasswordLabel.setBounds(50, 150, 75, 25);
		
		messageLabel.setBounds(125,250,250,35);
		messageLabel.setFont(new Font(null,Font.ITALIC,25));
		
		UserIDField.setBounds(125,100,200,25);
		UserPasswordField.setBounds(125,150,200,25);
		
		loginButton.setBounds(125,200,100,25);
		loginButton.setFocusable(false); //Remove box around text in buttons
		loginButton.addActionListener(this);
		
		resetButton.setBounds(225,200,100,25);
		resetButton.setFocusable(false); //Remove box around text in buttons
		resetButton.addActionListener(this);
		
		frame.add(userIDLabel);
		frame.add(userPasswordLabel);
		frame.add(messageLabel);
		frame.add(UserIDField);
		frame.add(UserPasswordField);
		frame.add(loginButton);
		frame.add(resetButton);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420, 420);
		frame.setLayout(null);
		frame.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource()==resetButton) {
			UserIDField.setText("");
			UserPasswordField.setText("");
			messageLabel.setText("");
		}
		
		if (e.getSource()==loginButton) {
			
			String userID = UserIDField.getText();
			String password = String.valueOf(UserPasswordField.getPassword());
			
			if (logininfo.containsKey(userID)) {
				
				if (logininfo.get(userID).equals(password)) {
					
					//messageLabel.setForeground(Color.green); SET COLOR AFTER LOGIN
					messageLabel.setText("Login Succesful");
					frame.dispose();
					WelcomePage welcomePage = new WelcomePage(userID);
					
				}
				else {
					
					//messageLabel.setForeground(Color.red); SET COLOR AFTER LOGIN
					messageLabel.setText("Wrong password");
					
				}
				
			}
			else {
				//messageLabel.setForeground(Color.red); SET COLOR AFTER LOGIN
				messageLabel.setText("Username not found");
			}
			
			
		}
		
	}

}
