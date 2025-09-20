package controllers;

import java.io.IOException;
import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class CalculatorControls extends Calculator {
	
	@FXML
	Button number0;
	
	@FXML
	Button number1;
	
	@FXML
	Button number2;
	
	@FXML
	Button number3;
	
	@FXML
	Button number4;
	
	@FXML
	Button number5;
	
	@FXML
	Button number6;
	
	@FXML
	Button number7;
	
	@FXML
	Button number8;
	
	@FXML
	Button number9;
	
	@FXML
	Button hashSign;
	
	@FXML
	Button equalSign;
	
	@FXML
	public Label textLabel;
		
	@FXML
	private void handlenumber1() {		
		updateText("1");
	}
	
	@FXML
	private void handlenumber2() {
		updateText("2");
	}
	
	@FXML
	private void handlenumber3() {
		updateText("3");
	}
	
	@FXML
	private void handlenumber4() {
		updateText("4");
	}
	
	@FXML
	private void handlenumber5() {
		updateText("5");
	}
	
	@FXML
	private void handlenumber6() {
		updateText("6");
	}
	
	@FXML
	private void handlenumber7() {
		updateText("7");
	}
	
	@FXML
	private void handlenumber8() {
		updateText("8");
	}
	
	@FXML
	private void handlenumber9() {
		updateText("9");
	}
	
	@FXML
	private void handlenumber0() {
		updateText("0");
	}
	
	private void updateText(String s) {
				
		Calculator.currentText = Calculator.currentText + s ;
		
		if (Calculator.controller) {

			Calculator.currentText = s;
			Calculator.controller = false;
		
		}
				
		textLabel.setText(Calculator.currentText);
	}
	
	@FXML
	private void handlehashsign() {
		try {
			FXMLLoader fxml = new FXMLLoader(getClass().getResource("../resources/calculatorFunctions.fxml"));
			Parent root = fxml.load();
			p.close();
			p.setScene(new Scene(root));

			CalculatorFunctionsControls c2 = fxml.getController();
			c2.textLabel2.setText(Calculator.currentText);
			
			p.show();
				
		} catch (IOException e) {
			System.out.print(e.getMessage());
		}
		
	}

	public int Calculation(String[] arr) {
		
		// add way to multiply

	    ArrayList<Integer> v = new ArrayList<>();
	    String stringbuilder = "";
	    Boolean negate = false;
	    int sum = 0;

	    for (int reached = 0; reached < arr.length; reached++) {
	    	
	    	if (reached - 1 >= 0 && arr[reached - 1].contains("-")) {
	    		negate = !negate;
	    	}
	    	
	    	if (!arr[reached].contains("-") && !arr[reached].contains("+")) {
	    		stringbuilder += arr[reached];
	    		
	    		if (reached + 1 >= arr.length || arr[reached + 1].contains("-") || arr[reached + 1].contains("+")) {
	    			
	    			int results = Integer.parseInt(stringbuilder);

	    			if (negate) {
	    				results = -results;
		    			negate = false;
	    			}
	    				    			
	    			v.add(results);
    				stringbuilder = "";
	    			
	    		}
	    	}
	    	
	    }
	    
	    
	    for (int i = 0; i < v.size(); i++) {
	        sum += v.get(i);
	    }

	    return sum;
	}


	
	public void getResult(String[] arr) {
		
		int completed = 0;
		boolean foundNumber = false;
		
		for (int i = 0;i < arr.length;i++) {
			

			if (!(i - 1 < 0 || i + 1 >= arr.length)) {
				continue;
			}
			
			for (int j = 0; j < arr.length;j++) {
				
				if (!foundNumber) {
					
					switch (arr[j]) {
						case "+":
							continue;
							
						case "-":
							continue;
							
						default:
							break;
					}
					
					foundNumber = true;
					completed = 1;
					break;
				}
			}
			
		}
		
		if (completed > 0) {

				int results = Calculation(arr);
				Calculator.currentText = "" + results;
				Calculator.controller = true;
			
		} else {
			Calculator.controller = false;
		}
				
	}
	
	
	
	@FXML
	private void handleequalsign() {
		String[] s = Calculator.currentText.split("");			
		getResult(s);
		textLabel.setText(Calculator.currentText);
		
	}
	
	
}
