
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * This class provide the "search" panel, which includes searching criteria and "search" button
 * @author Qiao Lin
 *
 */
public class Search_Panel extends JPanel {
	//Variables provide Panel with GUI elements 
	JPanel space_Panel_1, space_Panel_2, space_Panel_3, s_Panel_1,s_Panel_2, s_Panel_3,s_Panel_4,s_Panel_5;
	JButton search_Button,cancel_Button;
	JComboBox<Object> typesList, bedsList, bathsList, parkingList,sortList;
	JTextField  addressText, cityText,stateText,zipText,priceText,bedsText,sqftText,yearText,daysOnMarketText ,agencyText ;
	
	//Constructor
	Search_Panel(){
		//initialize GUI elements
		space_Panel_1=new JPanel();
		space_Panel_2=new JPanel();
		space_Panel_3=new JPanel();
		s_Panel_1=new JPanel();
		s_Panel_2=new JPanel();
		s_Panel_3=new JPanel();
		s_Panel_4=new JPanel();
		s_Panel_5=new JPanel();
		
		FlowLayout fl=new FlowLayout(FlowLayout.LEFT);
		setLayout(fl);
		
		add(space_Panel_1);
		add(s_Panel_1);
		add(s_Panel_2);
		
		add(space_Panel_2);
		add(s_Panel_3);
		add(s_Panel_4);
		
		add(space_Panel_3);
		add(s_Panel_5);
		
		set_space_Panel();
		set_s_Panel_1();
		set_s_Panel_2();
		set_s_Panel_3();
		set_s_Panel_4();
		set_s_Panel_5();
	}//end of constructor
	
	//set space panel to give clear layout
	void set_space_Panel(){
		JLabel  spaceLabel1 = new JLabel();
		spaceLabel1.setPreferredSize(new Dimension(30, 220));
	    space_Panel_1.add(spaceLabel1);
	    
	    JLabel  spaceLabel2 = new JLabel();
		spaceLabel2.setPreferredSize(new Dimension(40, 220));
		space_Panel_2.add(spaceLabel2);
		
		JLabel  spaceLabel3 = new JLabel();
		spaceLabel3.setPreferredSize(new Dimension(40, 220));
		space_Panel_3.add(spaceLabel3);
	} //end of set_space_Panel
	
	//set search panel
	void set_s_Panel_1(){
		//initialize GUI elements
		s_Panel_1.setLayout(new GridLayout(6,1,1,5));
		
		JLabel  typeLabel = new JLabel("Type: ");
	    typeLabel.setPreferredSize(new Dimension(200, 30));
	    s_Panel_1.add(typeLabel);
	    
	    JLabel  addressLabel = new JLabel("Address: (Keywords)");
        addressLabel.setPreferredSize(new Dimension(200, 30));
	    s_Panel_1.add(addressLabel);
	    
        JLabel  cityLabel = new JLabel("City: ");
        cityLabel.setPreferredSize(new Dimension(200, 30));
        s_Panel_1.add(cityLabel);
        
        JLabel  stateLabel = new JLabel("State: ");
        stateLabel.setPreferredSize(new Dimension(200, 30));
        s_Panel_1.add(stateLabel);
        
        JLabel  zipLabel = new JLabel("Zip: ");
        zipLabel.setPreferredSize(new Dimension(200, 30));
        s_Panel_1.add(zipLabel);
        
        JLabel priceLabel = new JLabel("Price: Less than");
        priceLabel.setPreferredSize(new Dimension(200, 30));
        s_Panel_1.add(priceLabel);
	}//end of set_s_Panel_1  
	
  //set search panel	
  void set_s_Panel_2(){
	    //initialize GUI elements
		s_Panel_2.setLayout(new GridLayout(6,1,1,5));
		
		String[] types = {"ALL", "Condo/Coop","Multi-Family", "Single Family", "Townhouse", "Vacant Land" };
        typesList = new JComboBox<Object>(types);
        typesList.setPreferredSize(new Dimension(380, 30));
   	    typesList.setSelectedIndex(0);
   	    s_Panel_2.add(typesList);
   	 
   	    addressText = new JTextField();
   	    addressText.setPreferredSize(new Dimension(380, 30));
   	    s_Panel_2.add(addressText);
   	 
   	 
   	    cityText = new JTextField();
   	    cityText.setPreferredSize(new Dimension(380, 30));
   	    s_Panel_2.add(cityText);
   	 
   	 
   	    stateText = new JTextField("NY");
   	    stateText.setPreferredSize(new Dimension(380, 30));
   	    stateText.setEditable(false);
   	    s_Panel_2.add(stateText);
   	 
   	    zipText = new JTextField();
   	    zipText.setPreferredSize(new Dimension(380, 30));
   	    s_Panel_2.add(zipText);
        
   	    priceText = new JTextField();
        priceText.setPreferredSize(new Dimension(380, 30));
        s_Panel_2.add(priceText);
	}//end of set_s_Panel_2 
  
   //set search panel
   void set_s_Panel_3(){
	   //initialize GUI elements
	   s_Panel_3.setLayout(new GridLayout(6,1,5,5));
	   
	   JLabel  bedsLabel = new JLabel("Bedroom Number: Greater than");
       bedsLabel.setPreferredSize(new Dimension(200, 30));
       s_Panel_3.add(bedsLabel);
       
       JLabel  bathsLabel = new JLabel("Bathroom Number: Greater than");
       bathsLabel.setPreferredSize(new Dimension(200, 30));
       s_Panel_3.add(bathsLabel);
       
       
       JLabel  parkingLabel = new JLabel("Parking Spots: Greater than");
       parkingLabel.setPreferredSize(new Dimension(200, 30));
       s_Panel_3.add(parkingLabel);
       
       JLabel  daysOnMarketLabel = new JLabel("Days on Market: Less than");
       daysOnMarketLabel.setPreferredSize(new Dimension(200, 30));
       s_Panel_3.add(daysOnMarketLabel);
       
       JLabel  agencyLabel = new JLabel("Agency Name: (Keywords)");
       agencyLabel.setPreferredSize(new Dimension(200, 30));
       s_Panel_3.add(agencyLabel);
       
       JLabel  sortLabel = new JLabel("Sort By: ");
       sortLabel.setPreferredSize(new Dimension(200, 30));
       s_Panel_3.add(sortLabel);
   } //end of set_s_Panel_3
   
   //set search panel
   void set_s_Panel_4(){
	  //initialize GUI elements
	   s_Panel_4.setLayout(new GridLayout(6,1,5,5));
	   
	   String[] beds = { "0", "1", "2", "3","4","5","6","7","8","9","10","11","12" };
       bedsList = new JComboBox<Object>(beds);
       bedsList.setPreferredSize(new Dimension(380, 30));
       bedsList.setSelectedIndex(0);
       s_Panel_4.add(bedsList);
       
       String[] baths = { "0","0.5", "1","1.5", "2","2.5", "3","3.5","4","4.5","5","5.5","6"};
       bathsList = new JComboBox<Object>(baths);
       bathsList.setPreferredSize(new Dimension(380, 30));
       bathsList.setSelectedIndex(0);
       s_Panel_4.add(bathsList);
       
      
       String[] parking = { "0", "1", "2", "3","4","5","6","7","8","9","10","11","12" };
       parkingList = new JComboBox<Object>(parking);
       parkingList.setPreferredSize(new Dimension(380, 30));
       parkingList.setSelectedIndex(0);
       s_Panel_4.add(parkingList);
       
       daysOnMarketText = new JTextField();
       daysOnMarketText .setPreferredSize(new Dimension(380, 30));
       s_Panel_4.add(daysOnMarketText);
       
       agencyText = new JTextField();
       agencyText.setPreferredSize(new Dimension(380, 30));
       s_Panel_4.add(agencyText);
       
       String[] sort = { "", "Price(low-high)", "Price(high-low)", "Newest","Oldest", };
       sortList = new JComboBox<Object>(sort);
       sortList.setPreferredSize(new Dimension(380, 30));
       sortList.setSelectedIndex(3);
       s_Panel_4.add(sortList);
   }//end of set_s_Panel_4
   
 //set search panel
   void set_s_Panel_5(){
	     //initialize GUI elements
	     s_Panel_5.setLayout(new GridLayout(4,1,5,20));
	   
	     search_Button = new JButton("Search");
		 search_Button.setSize(80, 25);
		 s_Panel_5.add( search_Button );
		 
		 cancel_Button = new JButton("Cancel");
	     cancel_Button.setSize(80, 25);
	     s_Panel_5.add( cancel_Button );
	     
	     set_cancel_Button();
	     set_Search_Button();
		 
   }//end of set_s_Panel_5
   
   //Add action on "cancel" button
   void set_cancel_Button(){
		 cancel_Button.addActionListener(new ActionListener() {
	             public void actionPerformed(ActionEvent e) {
	            	 //set "search" panel invisible
	            	 DataGUI.sPanel.setVisible(false);
	            	 //set data GUI visible
         	         DataGUI.dataFrame.setVisible(true);
         	         
	             }	 
       });
   }//end of set_cancel_Button
   
   
   //Add action on "Search" button
   void set_Search_Button(){
	   search_Button.addActionListener(new ActionListener() {
	             public void actionPerformed(ActionEvent e) {
	            	 //Get all input strings
	            	 String[] values=new String[DataManipulation.colNum];
	            	 values[1]=typesList.getSelectedItem().toString();
	            	 if(values[1]=="ALL") values[1]="";
	            	 values[2]=addressText.getText();
	            	 values[3]=cityText.getText();
	            	 values[4]=stateText.getText();
	            	 values[5]=zipText.getText();
	            	 values[6]=priceText.getText();
	            	 values[7]=bedsList.getSelectedItem().toString();
	            	 values[8]=bathsList.getSelectedItem().toString();
	            	 values[9]="";
	            	 values[10]="";
	            	 values[11]=parkingList.getSelectedItem().toString();
	            	 values[12]=daysOnMarketText.getText();
	            	 values[13]="Active";
	            	 values[14]=agencyText.getText();
	            	 
	                 String sort=check_SortList();
	                 //Check if all input strings are valid
	            	 if(check_values_Array(values)){
	            		 //search data
	            		 DataGUI.data.row_search(values, sort);
	            		 //reset table model
	            		 DataGUI.table.setModel(DataGUI.model);
	            	     
	            	 }//end of if  
	             } 
	        });
  	 
	  }//end of set_Search_Button
   
   /*
    * Check if all input strings are valid
    * @param val input string array
    * @return boolean return true if all input strings are valid
    */
   boolean check_values_Array(String[] val){
	    //check zip code, which must be 5 digits
  	    if(!val[5].isEmpty() && (val[5].length()!=5 || !isNumeric(val[5]))){
  			   JOptionPane.showMessageDialog(null, "Zip code must be 5 digits numbers, or leave it empty");
                 return false;
  		 }//end of if
  	    //check price, which must be numbers
  		if(!val[6].isEmpty()  && !isNumeric(val[6])){
  			   JOptionPane.showMessageDialog(null, "Price must be numbers,  or leave it empty");
                 return false;
  		 }//end of if 
  	    //check days on market, which must be numbers
  		if(!val[12].isEmpty()  && !isNumeric(val[12])){
  			  JOptionPane.showMessageDialog(null, "Days on Market must be numbers,  or leave it empty");
                return false;
  		}//end of if
  	   return true;
  }//end of check_values_Array
   
   
   /*
    * check if input string is digit
    * @param s string needed to check
    * @return boolean return true if string is digits
    */
   boolean isNumeric(String s){  
       try  {  
          double db = Double.parseDouble(s);  
       } catch(NumberFormatException nfe) {  
         return false;  }  
        return true;  
   }//end of isNumeric
   
   //set displaying order types
   String check_SortList(){
  	 String temp=sortList.getSelectedItem().toString();
  	 String resultSort="";;
  	 if(temp.equals("")) resultSort=DataManipulation.orderType[0];
  	 else if(temp.equals("Price(low-high)")) resultSort=DataManipulation.orderType[1];
  	 else if(temp.equals("Price(high-low)")) resultSort=DataManipulation.orderType[2];
  	 else if(temp.equals("Newest")) resultSort=DataManipulation.orderType[3];
  	 else if(temp.equals("Oldest")) resultSort=DataManipulation.orderType[4];
  	 return resultSort;
   }//end of check_SortList	 
}//end of class
