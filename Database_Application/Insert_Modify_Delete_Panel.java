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
 * This class is used to provide "insert" and "modify" and "Delete" operations panel.
 * @author Qiao Lin
 *
 */

public class Insert_Modify_Delete_Panel extends JPanel {
	//static variables provide elements of panel
	static JComboBox<Object> typesList, bedsList, bathsList, parkingList;
	static JTextField  addressText, cityText,stateText,zipText,priceText,sqftText,yearText,agencyText ;
	//row_ID indicates ID index, row_Num indicates the actual row number
	static int row_ID,row_Num;
	//String values of one row
	static String[] panel_row_values=new String[DataManipulation.colNum];
	
	//Variables provide elements of panel 
	JPanel space_Panel_1, space_Panel_2, space_Panel_3, imd_Panel_1,imd_Panel_2, imd_Panel_3,imd_Panel_4,imd_Panel_5;
	JButton modify_Button ,insert_Button,cancel_Button,delete_Button;
	
	//constructor
	Insert_Modify_Delete_Panel(){
		//initialize GUI elements
		space_Panel_1=new JPanel();
		space_Panel_2=new JPanel();
		space_Panel_3=new JPanel();
		imd_Panel_1=new JPanel();
		imd_Panel_2=new JPanel();
		imd_Panel_3=new JPanel();
		imd_Panel_4=new JPanel();
		imd_Panel_5=new JPanel();
		
		FlowLayout fl=new FlowLayout(FlowLayout.LEFT);
		setLayout(fl);
		
		add(space_Panel_1);
		add(imd_Panel_1);
		add(imd_Panel_2);
		
		add(space_Panel_2);
		add(imd_Panel_3);
		add(imd_Panel_4);
		
		add(space_Panel_3);
		add(imd_Panel_5);
		
		set_space_Panel();
		set_imd_Panel_1();
		set_imd_Panel_2();
		set_imd_Panel_3();
		set_imd_Panel_4();
		set_imd_Panel_5();
		
	}//end of constructor
	
	//set space panel to separate columns on panel
	void set_space_Panel(){
		//initialize GUI elements
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
	
	//set "insert" and "modify" panel
	void set_imd_Panel_1(){
		//initialize GUI elements
		imd_Panel_1.setLayout(new GridLayout(6,1,1,5));
		
		JLabel  typeLabel = new JLabel("Type: ");
	    typeLabel.setPreferredSize(new Dimension(200, 30));
	    imd_Panel_1.add(typeLabel);
	    
	    JLabel  addressLabel = new JLabel("Address: (requied*)");
        addressLabel.setPreferredSize(new Dimension(200, 30));
        imd_Panel_1.add(addressLabel);
	    
        JLabel  cityLabel = new JLabel("City: (requied*)");
        cityLabel.setPreferredSize(new Dimension(200, 30));
        imd_Panel_1.add(cityLabel);
        
        JLabel  stateLabel = new JLabel("State: ");
        stateLabel.setPreferredSize(new Dimension(200, 30));
        imd_Panel_1.add(stateLabel);
        
        JLabel  zipLabel = new JLabel("Zip: (requied*, 5 digit numbers)");
        zipLabel.setPreferredSize(new Dimension(200, 30));
        imd_Panel_1.add(zipLabel);
        
        JLabel priceLabel = new JLabel("Price: (requied*, numbers)");
        priceLabel.setPreferredSize(new Dimension(200, 30));
        imd_Panel_1.add(priceLabel);
	} //end of set_imd_Panel_1
	
	//set "insert" and "modify" panel
  void set_imd_Panel_2(){
	//initialize GUI elements
	   imd_Panel_2.setLayout(new GridLayout(6,1,1,5));
		
		String[] types = { "Condo/Coop","Multi-Family", "Single Family", "Townhouse", "Vacant Land" };
        typesList = new JComboBox<Object>(types);
        typesList.setPreferredSize(new Dimension(380, 30));
   	    typesList.setSelectedIndex(0);
   	    imd_Panel_2.add(typesList);
   	 
   	    addressText = new JTextField();
   	    addressText.setPreferredSize(new Dimension(380, 30));
   	    imd_Panel_2.add(addressText);
   	 
   	 
   	    cityText = new JTextField();
   	    cityText.setPreferredSize(new Dimension(380, 30));
   	    imd_Panel_2.add(cityText);
   	 
   	 
   	    stateText = new JTextField("NY");
   	    stateText.setPreferredSize(new Dimension(380, 30));
   	    stateText.setEditable(false);
   	    imd_Panel_2.add(stateText);
   	 
   	    zipText = new JTextField();
   	    zipText.setPreferredSize(new Dimension(380, 30));
   	    imd_Panel_2.add(zipText);
        
   	    priceText = new JTextField();
        priceText.setPreferredSize(new Dimension(380, 30));
        imd_Panel_2.add(priceText);
	} //end of set_imd_Panel_2
  
  
  //set "insert" and "modify" panel
   void set_imd_Panel_3(){
	 //initialize GUI elements
	   imd_Panel_3.setLayout(new GridLayout(6,1,5,5));
	   
	   JLabel  bedsLabel = new JLabel("Bedroom Number: ");
       bedsLabel.setPreferredSize(new Dimension(200, 30));
       imd_Panel_3.add(bedsLabel);
       
       JLabel  bathsLabel = new JLabel("Bathroom Number: ");
       bathsLabel.setPreferredSize(new Dimension(200, 30));
       imd_Panel_3.add(bathsLabel);
       
       JLabel  sqftLabel = new JLabel("Square Feet: (requied*, numbers)");
       sqftLabel.setPreferredSize(new Dimension(200, 30));
       imd_Panel_3.add(sqftLabel);
       
       JLabel  yearLabel = new JLabel("Year Built: (requied*, YYYY)");
       yearLabel.setPreferredSize(new Dimension(200, 30));
       imd_Panel_3.add(yearLabel);
       
       JLabel  parkingLabel = new JLabel("Parking Spots: ");
       parkingLabel.setPreferredSize(new Dimension(200, 30));
       imd_Panel_3.add(parkingLabel);
       
       JLabel  agencyLabel = new JLabel("Agency Name: (requied*)");
       agencyLabel.setPreferredSize(new Dimension(200, 30));
       imd_Panel_3.add(agencyLabel);
   } //end of set_imd_Panel_3
   
 //set "insert" and "modify" panel
   void set_imd_Panel_4(){
	 //initialize GUI elements
	   imd_Panel_4.setLayout(new GridLayout(6,1,5,5));
	   String[] beds = { "0", "1", "2", "3","4","5","6","7","8","9","10","11","12" };
       bedsList = new JComboBox<Object>(beds);
       bedsList.setPreferredSize(new Dimension(380, 30));
       bedsList.setSelectedIndex(0);
       imd_Panel_4.add(bedsList);
       
       String[] baths = { "0","0.5", "1","1.5", "2","2.5", "3","3.5","4","4.5","5","5.5","6"};
       bathsList = new JComboBox<Object>(baths);
       bathsList.setPreferredSize(new Dimension(380, 30));
       bathsList.setSelectedIndex(0);
       imd_Panel_4.add(bathsList);
       
       sqftText = new JTextField();
       sqftText.setPreferredSize(new Dimension(380, 30));
       imd_Panel_4.add(sqftText);
       
       yearText = new JTextField();
       yearText.setPreferredSize(new Dimension(380, 30));
       imd_Panel_4.add(yearText);
       
       String[] parking = { "0", "1", "2", "3","4","5","6","7","8","9","10","11","12" };
       parkingList = new JComboBox<Object>(parking);
       parkingList.setPreferredSize(new Dimension(380, 30));
       parkingList.setSelectedIndex(0);
       imd_Panel_4.add(parkingList);
       
       agencyText = new JTextField();
       agencyText.setPreferredSize(new Dimension(380, 30));
       imd_Panel_4.add(agencyText);
   }//end of set_imd_Panel_4
 
   //set "insert" and "modify" panel
   void set_imd_Panel_5(){
	 //initialize GUI elements
	    imd_Panel_5.setLayout(new GridLayout(4,1,5,20));
	   
	    
	     modify_Button = new JButton("Modify");
	     modify_Button.setSize(80, 25);
	     modify_Button .setVisible(false);
	     imd_Panel_5.add(modify_Button );
		 
		 insert_Button = new JButton("Insert");
		 insert_Button.setSize(80, 25);
		 insert_Button.setVisible(false);
		 imd_Panel_5.add( insert_Button );  
	     
	     delete_Button = new JButton("Delete");
		 delete_Button.setSize(80, 25);
		 imd_Panel_5.add( delete_Button);
		 
		 cancel_Button = new JButton("Cancel");
	     cancel_Button.setSize(80, 25);
	     imd_Panel_5.add( cancel_Button );
	     
	     set_cancel_Button();
	     
	     
		 set_Insert_Button(); 
		 set_modify_Button();
		 set_delete_Button();
   }//end of set_imd_Panel_5
   
   //Add action on "cancel" button
   void set_cancel_Button(){
		 cancel_Button.addActionListener(new ActionListener() {
	             public void actionPerformed(ActionEvent e) {
	            	 //set "insert" and "modify" panel invisible
	            	 DataGUI.imdPanel.setVisible(false);
	            	 //Set data GUI visible
         	         DataGUI.dataFrame.setVisible(true);
         	         //set all button "modify","insert","delete" invisible
         	         modify_Button.setVisible(false);
         	         insert_Button.setVisible(false);
         	         delete_Button.setVisible(false);
         	         //clear all input texts
         	         clear_Panel_row_values();
	            	     
	             }	 
       });
	}//end of set_cancel_Button
   
   //Add action on "delete" button
   void set_delete_Button(){
	   delete_Button.addActionListener(new ActionListener() {
	             public void actionPerformed(ActionEvent e) {
	            	   //get ID of selected row
	            	   DataGUI.data.row_delete(row_ID);
	            	   //Delete selected row
	            	   DataGUI.model.removeRow(row_Num);
	            	   //reset table model
	            	   DataGUI.table.setModel(DataGUI.model);
	            	   //show message dialog
	            	   JOptionPane.showMessageDialog(null, "The data is deleted");
	             }	 
      });
   }//end of set_delete_Button
  
   //Add action on "modify" button
   void set_modify_Button(){
	   modify_Button.addActionListener(new ActionListener() {
	             public void actionPerformed(ActionEvent e) {
	            	//get all input strings from text fields
	            	 String[] values=new String[DataManipulation.colNum];
	            	 
	            	 values[1]=typesList.getSelectedItem().toString();
	            	 values[2]=addressText.getText();
	            	 values[3]=cityText.getText();
	            	 values[4]=stateText.getText();
	            	 values[5]=zipText.getText();
	            	 values[6]=priceText.getText();
	            	 values[7]=bedsList.getSelectedItem().toString();
	            	 values[8]=bathsList.getSelectedItem().toString();
	            	 values[9]=sqftText.getText();
	            	 values[10]=yearText.getText();
	            	 values[11]=parkingList.getSelectedItem().toString();
	            	 values[12]="1";
	            	 values[13]="Active";
	            	 values[14]=agencyText.getText();
	            	 //check if all input strings are valid
	            	 if(check_values_Array(values)){
	            		 DataGUI.data.row_Modify(values, row_ID);
	            		 for(int i=1;i<DataManipulation.colNum; i++)
	            			 DataGUI.model.setValueAt((Object)values[i],row_Num, i);
	            		 DataGUI.table.setModel(DataGUI.model);
	            		 JOptionPane.showMessageDialog(null, "The data is changed");
	            	 }//end of if
	            	 
	             }	 
      });
   }//end of set_modify_Button
   
  
   //Add action on "insert" button
   void set_Insert_Button(){
	   insert_Button.addActionListener(new ActionListener() {
	             public void actionPerformed(ActionEvent e) {
	            	//get all input strings
	            	 String[] values=new String[DataManipulation.colNum];
	            	 
	            	 values[1]=typesList.getSelectedItem().toString();
	            	 values[2]=addressText.getText();
	            	 values[3]=cityText.getText();
	            	 values[4]=stateText.getText();
	            	 values[5]=zipText.getText();
	            	 values[6]=priceText.getText();
	            	 values[7]=bedsList.getSelectedItem().toString();
	            	 values[8]=bathsList.getSelectedItem().toString();
	            	 values[9]=sqftText.getText();
	            	 values[10]=yearText.getText();
	            	 values[11]=parkingList.getSelectedItem().toString();
	            	 values[12]="1";
	            	 values[13]="Active";
	            	 values[14]=agencyText.getText();
	            	 //check if all input strings are valid
	            	 if(check_values_Array(values)){
	            		 DataGUI.data.row_Create(values);
	            	     DataGUI.data.all_Data_retrieve();
	            	     DataGUI.table.setModel(DataGUI.model);
	            	     JOptionPane.showMessageDialog(null, "The data is inserted");
	            	     
	            	 }//end of if
	            	
	            	 
	             } 
	        });
  	 
	  }//end of set_Insert_Button
   
   /*
    * Check if all input strings are valid
    * @param val input string array
    * @return boolean return true if all input strings are valid
    */
boolean check_values_Array(String[] val){
	//check every string in input array
  	 for(int i=1;i<val.length;i++){
  		  //check all input are not empty
  		  if(val[i].isEmpty()){
  			  JOptionPane.showMessageDialog(null, "All Fields are requied to be filled out");
                return false;
  		  } 
  		  //check zip code, which must be 5 digits
  		  if(i==5 && (val[i].length()!=5 || !isNumeric(val[i]))){
  			   JOptionPane.showMessageDialog(null, "Zip code must be 5 digits numbers");
                 return false;
  		  } 
  		  //check price, which must be numbers
  		  if(i==6 && !isNumeric(val[i])){
  			   JOptionPane.showMessageDialog(null, "Price must be numbers");
                 return false;
  		 }
  		  //check square, which must be numbers
  		  if(i==9 && !isNumeric(val[i])){
  			   JOptionPane.showMessageDialog(null, "Square Feet must be numbers");
                 return false;
  		 }
  		  //check year, which must be 4 digits
  		 if(i==10 && (val[i].length()!=4 || !isNumeric(val[i]))){
  			   JOptionPane.showMessageDialog(null, "Year Built must be 4 digits numbers");
                 return false;
  		 }   
  	    
  	 }//end of for loop
  	 return true;
   }//end of  check_values_Array( 
   
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
   
   /*
    * set all input text fields
    * @param row row ID
    */
   static void set_Panel_row_values(int row){
	   row_Num=row;
	   row_ID=Integer.parseInt(panel_row_values[0]);
	   typesList.setSelectedItem((Object)panel_row_values[1]);
	   addressText.setText(panel_row_values[2]);
	   cityText.setText(panel_row_values[3]);
	   zipText.setText(panel_row_values[5]);
	   priceText.setText(panel_row_values[6]);
	   bedsList.setSelectedItem((Object)panel_row_values[7]);
	   bathsList.setSelectedItem((Object)panel_row_values[8]);
	   sqftText.setText(panel_row_values[9]);
	   yearText.setText(panel_row_values[10]);
	   parkingList.setSelectedItem((Object)panel_row_values[11]);
	   agencyText.setText(panel_row_values[14]);
   }//end of set_Panel_row_values
   
   //clear all input text fields
   void clear_Panel_row_values(){
	   typesList.getEditor().setItem("");
	   addressText.setText("");
	   cityText.setText("");
	   zipText.setText("");
	   priceText.setText("");
	   bedsList.getEditor().setItem("");
	   bathsList.getEditor().setItem("");
	   sqftText.setText("");
	   yearText.setText("");
	   parkingList.getEditor().setItem("");
	   agencyText.setText("");
   }//end of clear_Panel_row_values
}//end of class
