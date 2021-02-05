package logic;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.event.*;
public class Controller{
	
	@FXML
	public Label result;
	private float num1 = 0;
	private boolean start = true;
	private String operator = "";
	private Calculation calculate = new Calculation();
	
	@FXML
	public void controlNumbers(ActionEvent event) {
		if(operator.equals(".")) 
			result.setText(result.getText() + ".");
		if(result.getText().contains(".."))
		{
			operator = "";
			result.setText("NaN");
			start = true;
			return;
		}
		if(start) 
		{
			result.setText("");
			start = false;
		}
		String value = ((Button)event.getSource()).getText();
		result.setText(result.getText() + value);
	}
	
	@FXML
	public void controlOperators(ActionEvent event) {
		String value = ((Button)event.getSource()).getText();
		if(value.equals("SQRT")) 
		{
			num1 = Float.parseFloat(result.getText());
			result.setText(String.valueOf((float) Math.sqrt(num1)));
			operator = "";
			start = true;
			return;
		}
		if(!"=".equals(value)) 
		{
			if(!operator.isEmpty() && value.equals("C"){
                result.setText("");
                this.num1 = 0;
                operator="";
            }
			operator = value;
			num1 = Float.parseFloat(result.getText());
			result.setText("");
		}
		else 
		{
			if(operator.isEmpty())
				return;
			double output = calculate.calculate(num1,Float.parseFloat(result.getText()) , operator);
			result.setText(String.valueOf(output));
			operator = "";
			start = true;
		}
	}
}
