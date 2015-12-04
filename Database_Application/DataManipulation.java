
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Vector;

/**
 * This class is used to connect MYSQL with JAVA API, execute SQL commands to query and change data in database,
 * and disconnect MYSQL.
 * The operations to data include: retrieve tuples, create tuples, change tuples,delete tuples, search tuples.
 * 
 * @author QiaoLin
 *
 */

public class DataManipulation {
	//variable con is used to connect and disconnect MYSQL
	Connection con=null;
	//variable url: the link of connection to database;user: user name needed to login; password: password needed to login.   
	String url, user, password;
	String dbName="cs370", tableName="queens2";
	//variable logfile: name of logfile used to record SQL commands and time stamp. 
	String logfile="logfile.txt";
	BufferedWriter outfile;
	//String array of column names in the table
	static String[] colName={"Id","Type","Address","City","State","Zip","Price","Beds","Baths","SQFT","Year_built","Parking_spot","Days_on_Market", "Status","Agency"};
	//number of columns in table
	static int colNum=colName.length;
	//Orders of displaying data tuples
	static String[] orderType={"", " order by Price asc ", " order by Price desc ", " order by Days_on_Market asc ", " order by Days_on_Market desc " };
	
	//Constructor
	DataManipulation(){ 
	    data_Connection();
	}
	
	
	 //This method is used to construct connection between MYSQL and JAVA API
	 void data_Connection(){
		try{
	         Class.forName("com.mysql.jdbc.Driver");
	         System.out.println("MySQL JDBC driver loaded.");
	    
	          url="jdbc:mysql://localhost:3306/"+dbName;
	          user="root";
	          password="zhutou6161";
	          con=DriverManager.getConnection(url,user,password);
	          System.out.println("MySQL is connected.");
	          outfile=new BufferedWriter(new FileWriter(logfile,true));
	     }
		//catch Class not Found exception
	    catch(ClassNotFoundException cnfe){
	    	cnfe.printStackTrace();
	    	System.exit(1);
	    }
		//Catch SQL exception
	     catch(SQLException sqle){
	    	  sqle.printStackTrace();
		      System.exit(1);
	     }
		//catch I/O exception
		catch(IOException ioe){ 
			  ioe.printStackTrace();
		      System.exit(1);
		}    
	}//end of data_Connection
	
	
	 //This method is used to retrieve data tuples and display by id in descending order	    
	 void all_Data_retrieve() {
		Statement stm=null;
		ResultSet rs=null;
		try{
			//Retrieve tuples by executing SQL command
		    stm=con.createStatement();
	        String sql="select * from "+tableName+" order by id desc";
		    rs=stm.executeQuery(sql);
		    DataGUI.model.setRowCount(0);
		    //Add rows to table model
		    while (rs.next()) {
                 Vector<Object> newRow = new Vector<Object>();
                 //Add cells to each row
                 for (int i = 1; i <=colNum; i++) 
                      newRow.addElement(rs.getObject(i));
                 DataGUI.model.addRow(newRow);
            }//end of while
		  //Catch SQL exception
        }catch (SQLException e ) {
        	e.printStackTrace();
	    } finally {
	    	try{
	           if (stm != null) stm.close(); 
	         }
	    	catch (SQLException e ) {
	    		e.printStackTrace();
		    }
	    }
	}//end of all_Data_retrieve	
		
	 //This method is used to retrieve data tuples and display by Price in ascending order	
		void all_Data_retrieve_Price_Asc() {
			Statement stm=null;
			ResultSet rs=null;
			try{
				//Retrieve tuples by executing SQL command
			    stm=con.createStatement();
		        String sql="select * from "+tableName+" order by Price asc";
			    rs=stm.executeQuery(sql);
			    DataGUI.model.setRowCount(0);
			    //Add rows to table model
			    while (rs.next()) {
	                 Vector<Object> newRow = new Vector<Object>();
	                 //Add cells to each row
	                 for (int i = 1; i <=colNum; i++) 
	                      newRow.addElement(rs.getObject(i));
	                 DataGUI.model.addRow(newRow);
	            }//end of while
			  //Catch SQL exception
	        }catch (SQLException e ) {
	        	e.printStackTrace();
		    } finally {
		    	try{
		           if (stm != null) stm.close(); 
		         }
		    	catch (SQLException e ) {
		    		e.printStackTrace();
			    }
		    }
	}//end of all_Data_retrieve_Price_Asc
		
		//This method is used to retrieve data tuples and display by Price in descending order	
		void all_Data_retrieve_Price_Desc() {
			Statement stm=null;
			ResultSet rs=null;
			try{
				//Retrieve tuples by executing SQL command
			    stm=con.createStatement();
		        String sql="select * from "+tableName+" order by Price desc";
			    rs=stm.executeQuery(sql);
			    DataGUI.model.setRowCount(0);
			    //Add rows to table model
			    while (rs.next()) {
	                 Vector<Object> newRow = new Vector<Object>();
	                 //Add cells to each row
	                 for (int i = 1; i <=colNum; i++) 
	                      newRow.addElement(rs.getObject(i));
	                 DataGUI.model.addRow(newRow);
	            }//end of while
			  //Catch SQL exception
	        }catch (SQLException e ) {
	        	e.printStackTrace();
		    } finally {
		    	try{
		           if (stm != null) stm.close(); 
		         }
		    	catch (SQLException e ) {
		    		e.printStackTrace();
			    }
		    }
		}//end of all_Data_retrieve_Price_Desc
		
		//This method is used to retrieve data tuples and display by Days on market in ascending order	
		void all_Data_retrieve_Days_asc() {
			Statement stm=null;
			ResultSet rs=null;
			try{
				//Retrieve tuples by executing SQL command
			    stm=con.createStatement();
		        String sql="select * from "+tableName+" order by Days_on_Market asc";
			    rs=stm.executeQuery(sql);
			    DataGUI.model.setRowCount(0);
			    //Add rows to table model
			    while (rs.next()) {
	                 Vector<Object> newRow = new Vector<Object>();
	                 //Add cells to each row
	                 for (int i = 1; i <=colNum; i++) 
	                      newRow.addElement(rs.getObject(i));
	                 DataGUI.model.addRow(newRow);
	            }//end of while
			  //Catch SQL exception
	        }catch (SQLException e ) {
	        	e.printStackTrace();
		    } finally {
		    	try{
		           if (stm != null) stm.close(); 
		         }
		    	catch (SQLException e ) {
		    		e.printStackTrace();
			    }
		    }
		}//end of all_Data_retrieve_Days_asc
		
		//This method is used to retrieve data tuples and display by Days on market in descending order	
		void all_Data_retrieve_Days_Desc() {
			Statement stm=null;
			ResultSet rs=null;
			try{
				//Retrieve tuples by executing SQL command
			    stm=con.createStatement();
		        String sql="select * from "+tableName+" order by Days_on_Market desc";
			    rs=stm.executeQuery(sql);
			    DataGUI.model.setRowCount(0);
			    //Add rows to table model
			    while (rs.next()) {
	                 Vector<Object> newRow = new Vector<Object>();
	                 //Add cells to each row
	                 for (int i = 1; i <=colNum; i++) 
	                      newRow.addElement(rs.getObject(i));
	                 DataGUI.model.addRow(newRow);
	            }//end of while
			  //Catch SQL exception
	        }catch (SQLException e ) {
	        	e.printStackTrace();
		    } finally {
		    	try{
		           if (stm != null) stm.close(); 
		         }
		    	catch (SQLException e ) {
		    		e.printStackTrace();
			    }
		    }
		}//end of all_Data_retrieve_Days_Desc		
		
	/*
	 * This method is used to create one tuple
	 * @param col String array of column names in table
	 */
	void row_Create(String[] col){
		Statement stm=null;
		ResultSet rs=null;
		int currentMaxId=0;
		try{
			//Create one tuple by executing SQL command
			stm=con.createStatement();
			rs=stm.executeQuery("select max(id) from "+tableName);
			if(rs.next())  currentMaxId=rs.getInt(1);
			String sql="insert into "+tableName+ " values("+(currentMaxId+1)+", '"+col[1]+"', '"+col[2]+"', '"+col[3]+"', '"+col[4]+"', '"+col[5]+"', "+col[6]+", "+col[7]+", "+col[8]+", '"+col[9]+"', '"+col[10]+"', "+col[11]+", "+col[12]+", '"+col[13]+"', '"+col[14]+"')";
			System.out.println("sql: "+sql);
			stm.executeUpdate(sql);
			
			//Append commands and time stamp on log file
			outfile.write("TIMESTAMP: "+getTimestamp());
			outfile.newLine();
			outfile.write(sql);
			outfile.newLine();
			outfile.newLine();
		
		//Catch SQL exception
		}catch (SQLException e ) {
			e.printStackTrace();
	    }
		
		//catch I/O exception
		catch(IOException ioe){ 
			  ioe.printStackTrace();
		      System.exit(1);
		} finally {
	    	try{
	           if (stm != null) stm.close(); 
	           if (rs!=null) rs.close();
	        }
	    	catch (SQLException e ) {
	    		e.printStackTrace();
		    }
	    }	
    }//end of row_Create
	
	/*
	 * This method is used to change tuple
	 * @param col String array of column names in table
	 * @param row_id Integer indicates ID index of row
	 * 
	 */
	void row_Modify(String[] col, int row_id){
		String values="";
		Statement stm=null;
		//Change tuple by executing SQL command
		for(int i=1;i<colNum;i++){
			if(col[i]!=""){
				if(i!=1 && values!="") values+=", ";
				if(i==1) values+="Type='"+col[i]+"' ";
				else if(i==2) values+="Address='"+col[i]+"' ";
				else if(i==3) values+="City='"+col[i]+"' ";
				else if(i==4) values+="State='"+col[i]+"' ";
				else if(i==5) values+="Zip='"+col[i]+"' ";
				else if(i==6) values+="Price="+col[i]+" ";
				else if(i==7) values+="Beds="+col[i]+" ";
				else if(i==8) values+="Baths="+col[i]+" ";
				else if(i==9) values+="SQFT="+col[i]+" ";
				else if(i==10) values+="Year_built="+col[i]+" ";
				else if(i==11) values+="Parking_spot="+col[i]+" ";
				else if(i==12) values+="Days_on_market="+col[i]+" ";
				else if(i==13) values+="Status='"+col[i]+"' ";
				else if(i==14) values+="Agency='"+col[i]+"' ";
				
			}
		}//end of for loop
		
		if(values!=""){
		     String sql="update "+tableName+" set "+values+" where id="+row_id;
		     System.out.println("sql: "+sql); 
		     try{
		    	 stm=con.createStatement(); 
		    	 stm.executeUpdate(sql);
		    	 //Append SQL command and time stamp on log file
		    	 outfile.write("TIMESTAMP: "+getTimestamp());
				 outfile.newLine();
				 outfile.write(sql);
				 outfile.newLine();
				 outfile.newLine();
			 //Catch SQL exception	 
		      }catch (SQLException e ) {
		    	  e.printStackTrace();
		     //Catch I/O exception 	  
		      }catch(IOException ioe){ 
		    	  ioe.printStackTrace();
		      }  finally {
		    	  try{
		              if (stm != null) stm.close(); 
		            }
		    	  catch (SQLException e ) {
		    		  e.printStackTrace();
			      }
		      }	
		}
	}//end of row_Modify
	
	/*
	 * This method is used to delete one tuple
	 * @param id Integer indicates ID index of row
	 * 
	 */
	void row_delete(int id){
		//Delete tuple by executing SQL command
		Statement stm=null;
		String sql="delete from "+tableName+" where id="+id;
		try{
	    	 stm=con.createStatement(); 
	    	 System.out.println("sql: "+sql); 
	    	 stm.executeUpdate(sql);
	    	 
	    	 //Append SQL command and time stamp on log file
	    	 outfile.write("TIMESTAMP: "+getTimestamp());
			 outfile.newLine();
			 outfile.write(sql);
			 outfile.newLine();
			 outfile.newLine();
		  
		 //Catch SQL exception	 	 
	      }catch (SQLException e ) {
	    	  e.printStackTrace();
	     //Catch I/O exception
	      } catch(IOException ioe){ 
	    	  ioe.printStackTrace();
	      }finally {
	    	  try{
	              if (stm != null) stm.close(); 
	           }
	    	  catch (SQLException e ) {
	    		  e.printStackTrace();
		      }
	      }	
		 
	 }
	
	/*
	 * This method is used to search tuples by searching criteria
	 * @param col String array of column names in table
	 * @param oderType String indicates displaying data in what oder
	 */
	void row_search(String[] col, String orderType){
		//Search Tuple by executing SQL command
		Statement stm=null;
		ResultSet rs=null;
		String conditions="";
		for(int i=1;i<colNum;i++){
			if(!col[i].isEmpty()){
				if(i!=1 && conditions !="") conditions+=" and ";
				if(i==1)  conditions+="Type='"+col[i]+"' ";
				else if(i==2) conditions+="lower(Address) like lower('%"+col[2]+"%') ";
				else if(i==3) conditions+="lower(City) like lower('%"+col[3]+"%') ";
				else if(i==4) conditions+="State like '"+col[4]+"' ";
				else if(i==5) conditions+="Zip like '"+col[5]+"' ";
				else if(i==6) conditions+="Price<="+col[6]+" ";
				else if(i==7) conditions+="Beds>="+col[7]+" ";
				else if(i==8) conditions+="Baths>="+col[8]+" ";
				//else if(i==9) conditions+="SQFT>="+col[9]+" ";
				//else if(i==10) conditions+="Year_built>="+col[10]+" ";
				else if(i==11) conditions+="Parking_spot>="+col[11]+" ";
				else if(i==12) conditions+="Days_on_Market<="+col[12]+" ";
				else if(i==13) conditions+="Status like '"+col[13]+"' ";
				else if(i==14) conditions+="lower(Agency) like lower('%"+col[14]+"%') ";
			}
		}
		
		String sql="select * from "+tableName;
		if(conditions!="")  sql+=" where "+conditions;
		sql+=orderType;
		System.out.println("sql: "+sql); 
		     try{
		    	 stm=con.createStatement(); 
		    	 rs=stm.executeQuery(sql);
		    	 DataGUI.model.setRowCount(0);
		    	 //Add rows to table model
				 while(rs.next()){
				    	Vector<Object>  tempRow=new Vector<Object>();
				    	//Add cells to each row
				    	for (int i = 1; i <= colNum; i++)
				    		tempRow.addElement(rs.getObject(i));
				    	DataGUI.model.addRow(tempRow);
				  }
			//Catch SQL exception	 
		     }catch (SQLException e ) {
		    	  e.printStackTrace();
		      } finally {
		    	  try{
		              if (stm != null) stm.close(); 
		              if (rs != null) rs.close(); 
		          }
		    	  catch (SQLException e ) {
		    		  e.printStackTrace(); 
			      }
		      }	
	}
	
    /*
     * This method is used to disconnect MYSQL
     */
	void close_Connection(){
		try{
			outfile.close();
			con.close();
			System.out.println("MYSQL is disconnected");
		//Catch SQL exception		
		}catch(SQLException sqle){ 
			sqle.printStackTrace();
			System.exit(1);
		}
		//Catch I/O exception	
		catch(IOException ioe){ 
			ioe.printStackTrace();
			System.exit(1);
		}		
	}
	
	/*
	 * This method is used to get time stamp at certain moment
	 */
	public static String getTimestamp() {
		Calendar cal = Calendar.getInstance();
		//define the format of time stamp
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(cal.getTime());

	}
}	
	  
	


