package application;


import javafx.beans.property.SimpleStringProperty;

public class Table2 {
	
	private final SimpleStringProperty Title;
	private final SimpleStringProperty firstname;
	private final SimpleStringProperty lastname;
	
	public Table2(String Title, String firstname, String lastname){
		
		this.Title = new SimpleStringProperty (Title);
		this.firstname =new SimpleStringProperty (firstname);
		this.lastname =new SimpleStringProperty (lastname);
	}

	public String getTitle() {
		return Title.get();
	}

	public String getFirstname() {
		return firstname.get();
	}

	public String getLastname() {
		return lastname.get();
	}

}
