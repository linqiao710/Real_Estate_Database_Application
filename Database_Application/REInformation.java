
/**
 * @subject cs370
 * @author Qiao Lin
 * 
 * Real Estate Information Management System
 * This software is created by Java programming language and stores data through MYSQL
 * This software is used to electronically manipulate real estate listings. The table of real estate listings includes columns:
 * "ID", "Type", "Address", "City", "State", "Zip", "Price", "Beds", "Baths", "SQFT", "Year_built", "Parking_spot", "Days_on_Market", "Status", "Agency".
 * The operations includes: insert, change, delete, search, export table. Plus there is one feature added into this software,
 * which provides users with desired web sites through corresponding key words. 
 * For those operations,which can be used to change original data, 
 * logfile.txt would automatically recode corresponding commands and time stamp at that moment, for future data restore.
 * 
 *
 */

/*
 * This class is used to start this software.
 */

public class REInformation {
    //Main function is used to start this software. 
	public static void main(String[] args){
		try{
			//create the login GUI, which needs user to input user name and password
			Login_Panel login_Gui=new Login_Panel();
		}
		//catches any possible exception, and displays the corresponding exception message.
		catch(Exception e){e.printStackTrace();}
	}//end of main	

}//end of class
