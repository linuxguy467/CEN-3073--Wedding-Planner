package planner.Controller;

/* this class sets up the Table View so that Items can be added
 * to the table or deleted from the table
 * 
 */

import javafx.beans.property.SimpleStringProperty;

public class Party {
	
	private final SimpleStringProperty Titlename;
	private final SimpleStringProperty firstname;
	private final SimpleStringProperty lastname;
	
	public Party(String fTitle, String fFirstname, String fLastname){
		
		this.Titlename = new SimpleStringProperty (fTitle);
		this.firstname =new SimpleStringProperty (fFirstname);
		this.lastname =new SimpleStringProperty (fLastname);
	}

	public String getTitle() {
		return Titlename.get();
	}

	public String getFirstname() {
		return firstname.get();
	}

	public String getLastname() {
		return lastname.get();
	}
	public void setTitle(String fTitle){
		
		Titlename.set(fTitle);
	}
	public void setfirstname(String fFirstname){
		
		firstname.set(fFirstname);
	}
	public void setlastname (String fLastname){
		
		lastname.set(fLastname);
	}
}
