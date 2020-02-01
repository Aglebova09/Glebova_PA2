import java.util.Scanner;
import java.lang.Math;


public class BMICalculator {
	
	Scanner scanner = new Scanner(System.in);
	
	private double weight;
	private double height; 
	private double BMI;
	
	private String BmiCategory;
	private String unitType;
	

	public static void main(String[] args)
	{
		BMICalculator app = new BMICalculator();
	    app.readUserData();
	    app.calculateBmi();
	    app.displayBmi();
	}
	
	public void readUserData()
	{
		//makes use of readUnitType and readMeasurementData
		do   //do while makes sure that the user chooses a valid unit type
		{
		readUnitType();
		} while (!this.unitType.equals("M") && !this.unitType.equals("I"));
		
		readMeasurementData(unitType);
		
	}
	
	private void readUnitType()
	{
		//reads which units the user wants to use
		System.out.print("Input M to use the metric system or input I to use the imperial system: ");
		unitType = scanner.nextLine();
	}
	
	private void readMeasurementData(String unitType)
	{
		//calls either readMetricData or readImperialData, depending on the unit type
		if (unitType.equals("M"))
		{
			readMetricData();
		}
		else if(unitType.equals("I"))
		{
			readImperialData();
		}
		
	}
	
	private void readMetricData()
	{
		//called if the user chooses metric data
		System.out.print("Put in your height in meters and then your weight in kilograms: ");
		setHeight(scanner.nextDouble());
		setWeight(scanner.nextDouble());
	}
	
	private void readImperialData()
	{
		//called if user chooses imperial data
		System.out.print("Put in your height in inches and then your weight in pounds: ");
		setHeight(scanner.nextDouble());
		setWeight(scanner.nextDouble());
	}
	
	public void calculateBmi()
	{
		//calculates the user's BMI and BMI category
		if (unitType.equals("M"))  //checks which formula to use
		{
			this.BMI = getWeight()/Math.pow(getHeight(), 2);
			calculateBmiCategory(this.BMI);
		}
		else if(unitType.equals("I"))
		{
			this.BMI = (703 * getWeight())/Math.pow(getHeight(), 2);
			calculateBmiCategory(this.BMI);
		}
	}
	
	private void calculateBmiCategory(double BMI)
	{
		//calculates the users BMI Category
		if (BMI < 18.50)
		{
			this.BmiCategory = "Underweight";
		}
		else if (BMI <= 24.99 && BMI >= 18.50)
		{
			this.BmiCategory = "Normal Weight";
		}
		else if (BMI >= 25.0 && BMI <= 29.99)
		{
			this.BmiCategory = "Overweight";
		}
		else
		{
			this.BmiCategory = "Obese"; 
		}
	}
	
	public void displayBmi()
	{
		//prints the BMI value and category to standard output
		System.out.printf("Your BMI is %.2f%nYour BMI category is %s", getBmi(), getBmiCategory());
	}
	
	public double getWeight()
	{
		//returns the weight
		return this.weight;
	}
	
	private void setWeight(double weight)
	{
		//sets the weight 
		this.weight = weight;
		
		//if the weight entered is negative or zero then exit
		if (weight <= 0)
		{
			System.exit(0);
		}
		
	}
	
	public double getHeight()
	{
		//returns the height
		return this.height;
	}
	
	private void setHeight(double height)
	{
		//sets the height
		this.height = height;
		
		//if height entered is negative or zero then exit
		if (height <= 0)
		{
			System.exit(0);
		}
	}
	
	public double getBmi()
	{
		//returns the BMI
		return this.BMI;
	}
	
	public String getBmiCategory()
	{
		//return the BMI Category
		return this.BmiCategory;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
