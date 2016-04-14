package application;


import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class QuoteController  {
	@FXML private Label showPrice;
	@FXML private Button Submit;
	@FXML private Button Package1,Package2,Package3,Package4;
	@FXML private Button show;
	@FXML private TextField Title;
	@FXML private TextField quoteFirstName;
	@FXML private TextField quoteLastName;
	@FXML private TextField quoteContactNum;
	@FXML private TextField quoteWeddingDate;
	@FXML private TextField quoteChairCover;
	@FXML private TextField quoteSashe;
	@FXML private TextField quoteCover_Sashe;
	@FXML private TextField quoteTableRun;
	@FXML private TextField quoteTableLin;
	@FXML private TextField quoteTallCenter;
	@FXML private TextField quoteSmallVase;
	@FXML private TextField quoteRoseRunner;
	@FXML private TextField quoteRoseSkirt;
	@FXML private TextField quoteLaceCloth;
	@FXML private TextField quoteTableSkirt;
	@FXML private TextField quotePillars;
	@FXML private TextField quoteGlassVase;
	@FXML private TextField quoteGuest;
	@FXML private CheckBox cb1;
	@FXML private CheckBox cb2;
	@FXML private CheckBox cb3;
	@FXML private CheckBox cb4;
	@FXML private CheckBox cb5;
	@FXML private CheckBox cb6;
	@FXML private CheckBox cb7;
	@FXML private CheckBox cb8;
	@FXML private CheckBox cb9;
	@FXML private CheckBox cb10;
	@FXML private CheckBox cb11;
	@FXML private CheckBox cb12;
	@FXML private CheckBox cb13;
	
	
	@FXML
	public void printCost(ActionEvent event)throws IOException{
	
	// Array List for Items to be added	
	ArrayList<Double> list = new ArrayList<>();
	
	double sum = 0;
	double pack1 = 1500;
	double pack2 = 2500;
	double pack3 = 3500;
	double pack4 = 4500;
	String grandtotal;
	
	// if Packages is selected it adds the price to the the array list
	if (Package1.isArmed()){	
		list.add(pack1);
	}
	else if(Package2.isArmed()){
		list.add(pack2);
	}
	else if(Package3.isArmed()){
		list.add(pack3);
	}
	else if(Package4.isArmed()){
		list.add(pack4);
	}
	
	/* if the check box is selected and quantity entered into 
	 * it calculates the total for that item and adds it
	 * to the array list
	 */
	if(cb1.isSelected())
	{
		double total;
	
		String text = quoteChairCover.getText();
		double qty1 = Double.parseDouble(text);
	
		total = qty1 * 2.5;
	 		
		list.add(total);
	}
	
	if(cb2.isSelected())
	{
		double total2;
	
		String text2 = quoteSashe.getText();
		double qty2 = Double.parseDouble(text2);
	
		total2 = qty2 * 1.5;
	 		
		list.add(total2);
	}
	
	if(cb3.isSelected())
	{
		double total3;
	
		String text3 = quoteCover_Sashe.getText();
		double qty3 = Double.parseDouble(text3);
	
		total3 = qty3 * 3.5;
	 		
		list.add(total3);
	}
	
	if(cb4.isSelected())
	{
		double total4;
	
		String text4 = quoteTableRun.getText();
		double qty4 = Double.parseDouble(text4);
	
		total4 = qty4 * 3.5;
	 		
		list.add(total4);
	}
	
	if(cb5.isSelected())
	{
		double total5;
	
		String text5 = quoteTableLin.getText();
		double qty5 = Double.parseDouble(text5);
	
		total5 = qty5 * 10;
	 		
		list.add(total5);
	}
	
	if(cb6.isSelected())
	{
		double total6;
	
		String text6 = quoteTallCenter.getText();
		double qty6 = Double.parseDouble(text6);
	
		total6 = qty6 * 5;
	 		
		list.add(total6);
	
	}
	if(cb7.isSelected())
	{
		double total7;
	
		String text7 = quoteSmallVase.getText();
		double qty7 = Double.parseDouble(text7);
	
		total7 = qty7 * 3;
	 		
		list.add(total7);
	}
	
	if(cb8.isSelected())
	{
	 double total8;
	
	String text8 = quoteRoseRunner.getText();
	double xaxis8 = Double.parseDouble(text8);
	
	total8 = xaxis8 * 8;
	 		
	list.add(total8);
	}
	if(cb9.isSelected())
	{
	 double total9;
	
	String text9 = quoteRoseSkirt.getText();
	double xaxis9 = Double.parseDouble(text9);
	
	total9 = xaxis9 * 20;
	 		
	list.add(total9);
	}
	if(cb10.isSelected())
	{
	 double total10;
	
	String text10 = quoteLaceCloth.getText();
	double xaxis10 = Double.parseDouble(text10);
	
	total10 = xaxis10 * 25;
	 		
	list.add(total10);
	}
	
	if(cb11.isSelected())
	{
		double total11;
	
		String text11 = quoteTableSkirt.getText();
		double qty11 = Double.parseDouble(text11);
	
		total11 = qty11 * 7.5;
	 		
		list.add(total11);
	}
	
	if(cb12.isSelected())
	{
		double total12;
	
		String text12 = quotePillars.getText();
		double qty12 = Double.parseDouble(text12);
	
		total12 = qty12 * 10;
	 		
		list.add(total12);
	}
	
	if(cb13.isSelected())
	{
		double total13;
	
		String text13 = quoteGlassVase.getText();
		double qty13 = Double.parseDouble(text13);
	
		total13 = qty13 * 12;
	 		
		list.add(total13);
	}
	// adds all items in the item list
	for (int i = 0; i < list.size();i++)
	{
		sum = sum +list.get(i); // gets the total sum
	}
	
   grandtotal = Double.toString(sum); //changes the sum to a string

   showPrice.setText(grandtotal); // displays the total to the screen

	}
	
	// goes to Menu on button click
	@FXML
	private void goHome() throws IOException{
		
		Main.showMenu();
	}
}
