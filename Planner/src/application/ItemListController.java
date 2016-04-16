package application;

import java.io.IOException;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ItemListController {
	
	@FXML private CheckBox item1;
	@FXML private CheckBox item2;
	@FXML private CheckBox item3;
	@FXML private CheckBox item4;
	@FXML private CheckBox item5;
	@FXML private CheckBox item6;
	@FXML private CheckBox item7;
	@FXML private CheckBox item8;
	@FXML private CheckBox item9;
	@FXML private CheckBox item10;
	@FXML private CheckBox item11;
	@FXML private CheckBox item12;
	@FXML private CheckBox item13;
	@FXML private TextField itemChairCover;
	@FXML private TextField itemSashe;
	@FXML private TextField itemCover_Sashe;
	@FXML private TextField itemTableRun;
	@FXML private TextField itemTableLin;
	@FXML private TextField itemTallCenter;
	@FXML private TextField itemSmallVase;
	@FXML private TextField itemRoseRunner;
	@FXML private TextField itemRoseSkirt;
	@FXML private TextField itemLaceCloth;
	@FXML private TextField itemTableSkirt;
	@FXML private TextField itemPillars;
	@FXML private TextField itemGlassVase;
	@FXML private Label ShowItem;
	
	
	// selecting additional items
		@FXML
		public void selectItems(ActionEvent event) throws IOException
		{
			// Array List for Items to be added
			ArrayList<Double> ItemList = new ArrayList<>();
			
			Double sum = null;
			String grandtotal;
			
		// if Chair covers $2.50 is selected
		if(item1.isSelected())
		{
			double total;
			String text = itemChairCover.getText(); // gets input from text field
		    double qty = Double.parseDouble(text); // changes string to double
		
		    total = qty * 2.5;
		 		
		    ItemList.add(total); // adds total to Item List
		}
		
		// if Sashes  $1.50 is selected 
		if(item2.isSelected())
		{
			double total2;
		
			String text2 = itemSashe.getText();
			double qty2 = Double.parseDouble(text2);
		
			total2 = qty2 * 1.5;
		 		
			ItemList.add(total2);
		}
		
		// if Chair covers and sashes $ 3.50 is selected
		if(item3.isSelected())
		{
			double total3;
		
			String text3 = itemCover_Sashe.getText();
			double qty3 = Double.parseDouble(text3);
		
			total3 = qty3 * 3.5;
		 		
			ItemList.add(total3);
		}
		
		// if Table runners $ 3.50 is selected
		if(item4.isSelected())
		{
			double total4;
		
			String text4 = itemTableRun.getText();
			double qty4 = Double.parseDouble(text4);
		
			total4 = qty4 * 3.5;
		 		
			ItemList.add(total4);
		}
		
		// if Table linen $10.00 is selected
		if(item5.isSelected())
		{
			double total5;
		
			String text5 = itemTableLin.getText();
			double qty5 = Double.parseDouble(text5);
		
			total5 = qty5 * 10;
		 		
			ItemList.add(total5);
		}
		
		// if 24” Tall centerpieces $ 5.00 is selected
		if(item6.isSelected()) 
		{
			double total6;
		
			String text6 = itemTallCenter.getText();
			double qty6 = Double.parseDouble(text6);
		
			total6 = qty6 * 5;
		 		
			ItemList.add(total6);
		}
		
		// if Small vases $ 3.00 is selected
		if(item7.isSelected())
		{
			double total7;
		
			String text7 = itemSmallVase.getText();
			double qty7 = Double.parseDouble(text7);
		
			total7 = qty7 * 3;
		 		
			ItemList.add(total7);
		}
		
		// if Rosette table runners $ 8.00 is selected
		if(item8.isSelected())
		{
			double total8;
			
			String text8 = itemRoseRunner.getText();
			double qty8 = Double.parseDouble(text8);
		
			total8 = qty8 * 8;
		 		
			ItemList.add(total8);
		}
		
		// if Rosette table skirts $20.00 is selected
		if(item9.isSelected())
		{
			double total9;
		
			String text9 = itemRoseSkirt.getText();
			double qty9 = Double.parseDouble(text9);
		
			total9 = qty9 * 20;
		 		
			ItemList.add(total9);
		}
		
		// if Lace table clothes for the bride $25.00 is selected
		if(item10.isSelected())
		{
			double total10;
		
			String text10 = itemLaceCloth.getText();
			double qty10 = Double.parseDouble(text10);
		
			total10 = qty10 * 25;
		 		
			ItemList.add(total10);
		}
		
		// if Table skirts $ 7.50 is selected
		if(item11.isSelected())
		{
			double total11;
		
			String text11 = itemTableSkirt.getText();
			double qty11 = Double.parseDouble(text11);
		
			total11 = qty11 * 7.5;
		 		
			ItemList.add(total11);
		}
		
		// if Pillars $ 10.00 is selected
		if(item12.isSelected())
		{
			double total12;
		
			String text12 = itemPillars.getText();
			double qty12 = Double.parseDouble(text12);
		
			total12 = qty12 * 10;
		 		
			ItemList.add(total12);
		}
		
		// if Glass Vase $12.00 is selected
		if(item13.isSelected())
		{
			double total13;
		
			String text13 = itemGlassVase.getText();
			double qty13 = Double.parseDouble(text13);
		
			total13 = qty13 * 12;
		 		
			ItemList.add(total13);
		}
		
		// adds all items in the item list
		for (int i = 0; i < ItemList.size();i++)
		{
			sum = sum +ItemList.get(i);
		}
	   grandtotal = Double.toString(sum); // changes items in ItemList to strings

	   ShowItem.setText(grandtotal); // displays the total

		}

}
