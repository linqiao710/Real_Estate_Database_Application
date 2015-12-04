
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;

/**
 * This class is used to provide "search Internet" panel  
 * @author Qiao Lin
 *
 */

public class Feature_Panel extends JFrame {
    //variables provide GUI elements for "search Internet" panel
	JPanel contentPane;
	JTextField textField;
	JTextArea resultText;
	JButton searchButton;
	Pattern htmlPattern;
	//static variable gives pattern to extract links
	static String html_Pattern="(www\\.[^/<>&%\"']+)([/\"']+)"; 
	

	//constructor
   public Feature_Panel() {
	   //initialize JFrame
		setTitle("Search Internet");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(580, 200, 528, 552);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Add input label
		JLabel inputLabel = new JLabel("Input Keyword: ");
		inputLabel.setBounds(19, 30, 102, 38);
		inputLabel.setHorizontalAlignment(SwingConstants.CENTER);
		inputLabel.setFont(new Font("Times New Roman", Font.BOLD, 12));
		contentPane.add(inputLabel);
		
		//Add input text field
		textField = new JTextField();
		textField.setBounds(120, 34, 265, 30);
		contentPane.add(textField);
		textField.setColumns(10);
		
		//Add "search" button
		searchButton = new JButton("Search");
		searchButton.setBounds(401, 33, 85, 30);
		contentPane.add(searchButton);
		
		
		//Add panel to display searching results
		JScrollPane scrollPane = new JScrollPane();
		
		scrollPane.setBounds(9, 93, 495, 412);
		contentPane.add(scrollPane);
		
		resultText = new JTextArea();
		scrollPane.setViewportView(resultText);
		resultText.setColumns(10);
		
		setVisible(true);
		
		
		htmlPattern= Pattern.compile(html_Pattern);
		set_SearchButton();
		
	}//end of constructor
	
   
   //Add action on "search" button
	void set_SearchButton(){
	      searchButton.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    	  String keyword=textField.getText();
		    	  //Search Internet to get links with key words
		    	  if(!keyword.isEmpty()){
		    		    //Variable result is used to store results 
		    		    Set<String> result=new HashSet<String>();
		    		    //remove space characters
		    		    String searchWord=keyword.replaceAll("\\s*", "");
		    		    String seachSite="https://www.google.com/search?q=" + searchWord + "&num=20";
		    		    resultText.setText("WebSites with keyword (" + keyword+"): "+'\n');
		    		    try{ 
		    		    	//establish connection  
		    			     URLConnection oConnection = (new URL(seachSite)).openConnection();
		    			     //set user agent
		    		         String USER_AGENT="Mozilla/5.0 (compatible; Googlebot/2.1; +http://www.google.com/bot.html)";
		    		         oConnection.setRequestProperty("User-Agent", USER_AGENT);
		    		         
		    		         
		    		         BufferedReader br=new BufferedReader (new InputStreamReader(oConnection.getInputStream()));
		    		         String line = br.readLine();
		    		    	  //read HTML until no line left
		    		          while (line != null) {  
		    		        	  //to find matches with given pattern
		    		        	  Matcher matcher=htmlPattern.matcher(line);
		    	        	      while(matcher.find())
		    	        		         result.add(matcher.group(1)); 
		    	                  line = br.readLine();
		    	              }//end of while
		    		      //catch I/O exception    
		    		      } catch(IOException ioe){ ioe.printStackTrace();}	
		    		   //display results
		    		   for(String temp : result){
		    			      resultText.append(temp+"\n");
		    		   }//end of for loop
		    	   }//end of if	  
		      }
	      });
	       
	}//end of set_SearchButton  
	
	
}//end of class

