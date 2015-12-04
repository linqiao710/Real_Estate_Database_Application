import java.awt.*;
import java.awt.event.*;
import java.io.FileWriter;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 * This class is used to provide main manipulation GUI to users
 * @author Qiao Lin
 *
 */
public class DataGUI  {
	  //Static variables provide frame and panel to display operation buttons and table
	  static JFrame dataFrame;
      static DataManipulation data;
      static DefaultTableModel model;
      static JTable table;
      static Insert_Modify_Delete_Panel imdPanel;
      static Search_Panel sPanel;
      
      //variables provide menu and menu items
      JMenuBar menuBar;
      JMenu menu1,menu2,menu3;
      JMenuItem item1_1_Search, item1_2_AllListings,item1_3_Price_Asc,item1_4_Price_Desc,item1_5_Days_Asc,item1_6_Days_Desc;
      JMenuItem item2_1_Insert, item2_2_Modify, item2_3_Delete,item2_4_Export;
      JMenuItem item3_1_Internet;
      
      
	  //constructor
      DataGUI() {
    	  setDataGUI();
  	  }
      
      //Initiate frame, table, and operation panels
      void setDataGUI(){
    	   dataFrame=new JFrame();
		   set_Frame();
		   
		   set_TopMenu();
		   dataFrame.setJMenuBar(menuBar);
		  
		   set_Search_Panel();
		   dataFrame.add(sPanel,BorderLayout.NORTH);
		   
		   set_Table();
		   dataFrame.add(new JScrollPane(table),BorderLayout.CENTER);
		   
		   set_Create_Modify_Panel();
		   dataFrame.add(imdPanel,BorderLayout.SOUTH);  
		   
		   
		   set_close();
		   dataFrame.setVisible(true);
       }//end of setDataGUI    
    	  
	  //Initiate Jframe of entire GUI
	  void set_Frame(){
		  dataFrame.setTitle("Real Estate Listings Information System");
		  dataFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		  dataFrame.setBounds(160, 50, 1600, 950);
	  }//end of set_Frame
	  
	  //Add action to close button of JFrame
	  void set_close(){
		  dataFrame.addWindowListener(new WindowAdapter(){
              public void windowClosing(WindowEvent e){
              	    data.close_Connection();
                  	JOptionPane.showMessageDialog(null, "Disconnected" );
                  	System.exit(0);
                 
              }  
           });
	  }//end of set_close
	  
	  //Set menu bar,menus and menu items
	  void set_TopMenu(){
		  menuBar=new JMenuBar();
		  
		  //set "user operation" menu
		  menu1=new JMenu("Search");
		  
		  item1_1_Search=new JMenuItem("Search");
		  item1_2_AllListings=new JMenuItem("Display all Data Listings");
		  item1_3_Price_Asc=new JMenuItem("Display by Price Lowest to Highest");
		  item1_4_Price_Desc=new JMenuItem("Display by Price Highest to Lowest");
		  item1_5_Days_Asc=new JMenuItem("Display by Days On Market Shortest to Longest");
		  item1_6_Days_Desc=new JMenuItem("Display by Days On Market Longest to Shortest");
		  
		  menu1.add(item1_1_Search);
		  menu1.addSeparator();
		  menu1.add(item1_2_AllListings);
		  menu1.addSeparator();
		  menu1.add(item1_3_Price_Asc);
		  menu1.add(item1_4_Price_Desc);
		  menu1.add(item1_5_Days_Asc);
		  menu1.add(item1_6_Days_Desc);
		  menuBar.add(menu1);
  		  
		  //set "advanced operations" menu
		  menu2=new JMenu("Advanced Operations");
		  item2_1_Insert=new JMenuItem("Insert");
  		  item2_2_Modify=new JMenuItem("Modify Listing");
		  item2_3_Delete=new JMenuItem("Delete Listing");
		  item2_4_Export=new JMenuItem("Export Table");
		  menu2.add(item2_1_Insert);
		  menu2.add(item2_2_Modify);
		  menu2.add(item2_3_Delete);
		  menu2.addSeparator();
		  menu2.add(item2_4_Export);
  		  menuBar.add(menu2);
  		  
  		  //set "feature" menu
  		  menu3=new JMenu("Feature");
  		  item3_1_Internet=new JMenuItem("Search Internet");
  		  menu3.add(item3_1_Internet);
  		  menuBar.add(menu3);
  		  
  		  //Add action on menu Items
  		  set_item1_1_Search();
  		  set_item1_2_AllListings();
  		  set_item1_3_Price_Asc();
  		  set_item1_4_Price_Desc();
  		  set_item1_5_Days_Asc();
  		  set_item1_6_Days_Desc();
  		  
  		  set_item2_1_Insert();
  		  set_item2_2_Modify();
  		  set_item2_3_Delete();
  		  set_item2_4_Export();
  		  
  		  set_item3_1_Internet();
  		  
	  }//end of set_TopMenu
	 
	 //Add action on search item
	 void set_item1_1_Search(){
		 item1_1_Search.addActionListener(new ActionListener() {
	             public void actionPerformed(ActionEvent e) {
	            	 //set "insert" and "modify" panel invisible
	            	 imdPanel.setVisible(false);
	            	 //set "search" Panel visible
	            	 sPanel.setVisible(true);
	            	
	             }

	       });
	 }// end of set_item1_1_Search
	 
	 //Add action on "Display all Data Listings" item
	 void set_item1_2_AllListings(){
		item1_2_AllListings.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	//retrieve data
            	data.all_Data_retrieve();
            	//reset table model
       		    table.setModel(DataGUI.model);
       	        
           	 }

      });
   }// end of set_item1_2_AllListings
	
	 void set_item1_3_Price_Asc(){
		 item1_3_Price_Asc.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	//retrieve data
	            	data.all_Data_retrieve_Price_Asc();
	            	//reset table model
	       		    table.setModel(DataGUI.model);
	       	        
	           	 }

	      });
	 }	
	 
	 void set_item1_4_Price_Desc(){
		 item1_4_Price_Desc.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	//retrieve data
	            	data.all_Data_retrieve_Price_Desc();
	            	//reset table model
	       		    table.setModel(DataGUI.model);
	       	        
	           	 }

	      });
	 }
	 
	 void set_item1_5_Days_Asc(){
		 item1_5_Days_Asc.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	//retrieve data
	            	data.all_Data_retrieve_Days_asc();
	            	//reset table model
	       		    table.setModel(DataGUI.model);
	       	        
	           	 }

	      });
	 }
	 
	 void set_item1_6_Days_Desc(){
		 item1_6_Days_Desc.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	//retrieve data
	            	data.all_Data_retrieve_Days_Desc();
	            	//reset table model
	       		    table.setModel(DataGUI.model);
	       	        
	           	 }

	      });
	 }		
	 
	
	 //Add action on "Insert" item
	 void set_item2_1_Insert(){
		 item2_1_Insert.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent e) {
            	 //set "search" panel invisible
            	 sPanel.setVisible(false);
            	 //set "insert" and "modify" panel visible
            	 imdPanel.setVisible(true);
            	 
            	 //set "insert" button visible, set "modify" and "delete" buttons invisible
            	 DataGUI.imdPanel.modify_Button.setVisible(false);
        		 DataGUI.imdPanel.insert_Button.setVisible(true);
        		 DataGUI.imdPanel.delete_Button.setVisible(false);
             }

       });
    }// end of set_item2_1_Insert
	
	 //Add action on "Modify Listing" item
	void set_item2_2_Modify(){
		item2_2_Modify.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	//set "insert" and "modify" panel visible
            	DataGUI.imdPanel.setVisible(true);
            	//set "search" panel invisible
       	        DataGUI.sPanel.setVisible(false);
           	    
       	        //set "modify" button visible, set "insert" and "delete" buttons invisible
       		    DataGUI.imdPanel.modify_Button.setVisible(true);
       		    DataGUI.imdPanel.insert_Button.setVisible(false);
       		    DataGUI.imdPanel.delete_Button.setVisible(false);
           	 
            }

      });
   }//end of set_item2_2_Modify
	
	//Add action on "Delete Listing" item
	void set_item2_3_Delete(){
		item2_3_Delete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	//set "insert" and "modify" panel visible
            	DataGUI.imdPanel.setVisible(true);
            	//set "search" Panel visible
       	        DataGUI.sPanel.setVisible(false);
           	    
       	        //set "delete" button visible, set "modify" and "insert" buttons invisible
       		    DataGUI.imdPanel.modify_Button.setVisible(false);
       		    DataGUI.imdPanel.insert_Button.setVisible(false);
       		    DataGUI.imdPanel.delete_Button.setVisible(true);
            }

      });
   }//end of set_item2_3_Delete
	
	//Add action on "Export Table"
	void set_item2_4_Export(){
		item2_4_Export.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	//display JChooser
            	JFileChooser chooser = new JFileChooser();
            	FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT FILES", "txt", "text");
            	chooser.setFileFilter(filter);
               
            	int retrival = chooser.showSaveDialog(null);
                if (retrival == JFileChooser.APPROVE_OPTION) {
                    try {
                    	//Create text file
                        FileWriter fw = new FileWriter(chooser.getSelectedFile()+".txt");
                        //output data table
                        for(int i = 0 ; i < table.getColumnCount() ; i++){
                             fw.write(table.getColumnName(i));
                             if(i!=(table.getColumnCount()-1))  fw.write(",");
                         }
                        fw.write(String.format("%n"));
                        for (int i = 0 ; i < table.getRowCount(); i++){
                            for(int j = 0 ; j < table.getColumnCount();j++){
                                fw.write((table.getValueAt(i,j)).toString());
                                if(j!=(table.getColumnCount()-1))  fw.write(",");
                                
                            }
                            fw.write(String.format("%n"));
                        }
                        fw.flush();
                        fw.close();
                     // catch exception
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }

      });
   }//end of set_item2_4_Export
	
	//Add action on "Search Internet" item
	void set_item3_1_Internet(){
		item3_1_Internet.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	//creates feature panel
           	      Feature_Panel ftPanel=new Feature_Panel();
            }

      });
   }//end of set_item3_1_Internet
		
	//creates panel for "insert" and "change" operations 
	 void set_Create_Modify_Panel(){
		 //creates "insert" and "modify" panel, and set it invisible
		 imdPanel=new Insert_Modify_Delete_Panel();
		 imdPanel.setVisible(false);
	 }//end of 	set_Create_Modify_Panel	
	 
	 //create table and table model to display data
	 void set_Table(){
		  
		  table = new JTable();
		  model = new DefaultTableModel();
 		  for(int i=0;i<DataManipulation.colNum;i++)
 			   model.addColumn(DataManipulation.colName[i]);
 		  data=new DataManipulation();
          data.all_Data_retrieve();
 		  table.setModel(model);
 		  set_Table_Action();
          
 	  }//end of set_Table
	 
	 //creates panel for "Search" operation
	 void set_Search_Panel(){
		 //creates new "search" panel and set it invisible
		 sPanel=new Search_Panel();
		 sPanel.setVisible(false);
	 }//end of set_Search_Panel
	 
	 //Add action to table, to select a specific row
	 void set_Table_Action(){
		 table.addMouseListener(new MouseAdapter(){
			 public void mouseClicked(MouseEvent e){
				// if(e.getClickCount()==1){
				     // get the selected Row ID 
					 int row=table.getSelectedRow();
					 //get the string value of each cell in the selected roe
					 for(int i=0;i<DataManipulation.colNum;i++)
						 Insert_Modify_Delete_Panel.panel_row_values[i]=(model.getValueAt(row, i)).toString();
					 Insert_Modify_Delete_Panel.set_Panel_row_values(row);
					 
				  //}
			 }
		 });
	 }//end of set_Table_Action
	 
	
}//end of class
