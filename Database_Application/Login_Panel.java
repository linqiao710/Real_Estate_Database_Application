
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * This class is used to provide Login panel to users.
 * If user input correct user name and password, then user can connect the database and get into the data windows.
 * @author Qiao Lin
 *
 */
public class Login_Panel {
	//variables provide the GUI elements for login Panel
	JFrame pwframe;
	JPanel pwPanel;
	JTextField userIdText;
	JPasswordField passwordText;
	JButton okButton, helpButton,cancelButton;
	
	//constructor
	public  Login_Panel(){
		//initialize JFrame
		pwframe = new JFrame("Login");
		pwframe.setBounds(650,400,365, 260);
		pwframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pwPanel=new JPanel();
		set_pwPanel();
		
		pwframe.add(pwPanel);
		pwframe.setVisible(true);
	 }//end of constructor
	
	
	//Initialize GUI elements on login panel
	void set_pwPanel(){
		pwPanel.setLayout(null);
		JLabel userIdLabel = new JLabel("User ID");
		userIdLabel.setBounds(40, 40, 60, 25);
		pwPanel.add(userIdLabel);
		
		
		userIdText = new JTextField("cs370");
		userIdText.setBounds(120, 40, 160, 25);
		pwPanel.add(userIdText);
		
		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(40, 90, 60, 25);
		pwPanel.add(passwordLabel);

		passwordText = new JPasswordField("cs370");
		passwordText.setBounds(120, 90, 160, 25);
		pwPanel.add(passwordText);

		okButton = new JButton("OK");
		okButton.setBounds(40, 150, 80, 25);
		pwPanel.add(okButton);
		
		helpButton = new JButton("Help");
		helpButton.setBounds(130, 150, 80, 25);
		pwPanel.add(helpButton);
		
		cancelButton = new JButton("Cancel");
		cancelButton.setBounds(220, 150, 80, 25);
		pwPanel.add(cancelButton);
		
		set_okButton();
		set_helpButton();
		set_cancelButton();
	}// end of set_pwPanel
	
	
	//Add action onto "help" button 
	 void set_helpButton(){
		 helpButton.addActionListener(new ActionListener() {
	             public void actionPerformed(ActionEvent e) {
	            	 //show message dialog
	            	 JOptionPane.showMessageDialog(null, "User ID:cs370"+"\n Password:cs370" );
	            	
	             }

	      });
	 }//end of set_helpButton 
	 
	 //Add action onto "cancel" button 
	 void set_cancelButton(){
		 cancelButton.addActionListener(new ActionListener() {
	             public void actionPerformed(ActionEvent e) {
	            	 //exit
	            	 System.exit(0);
	             }

	      });
	 }// end of set_cancelButton
	
	 //Add action on "OK" button
	 void set_okButton(){
		 okButton.addActionListener(new ActionListener() {
	             public void actionPerformed(ActionEvent e) {
	            	 //If user name and password are true, create data windows
	            	 if(check_Password()){
	            		 DataGUI dtGUI=new DataGUI();
	            		 //Show message "Connected successfully!"
	            		 JOptionPane.showMessageDialog(null, "Connected successfully!\n All commands that change data will be automatically recorded on logfile.txt " ); 
	            		 //close login panel
	            	     pwframe.dispose();
	            	 }else{
	            		 //user name and password are wrong, show wrong message
	            		 JOptionPane.showMessageDialog(null, "Wrong User ID or Wrong Password!!\nPlease click Help button to check the right User ID and Password" ); 
	            	}
	             }	 

	      });
	 }// end of set_okButton
	
	 //Check if user name and password are correct
	 boolean check_Password(){
		 if(userIdText.getText().equals("cs370") && new String(passwordText.getPassword()).equals("cs370") ) return true;
		 else return false;
	 }//end of check_Password	 
	 
}//end of class
