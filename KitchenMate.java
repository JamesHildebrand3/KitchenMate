import javafx.application.Application;
import java.math.BigDecimal;
import javafx.scene.Node;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.scene.control.Label;
import javafx.geometry.Pos;
import javafx.scene.text.FontWeight;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.shape.Shape;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
public class KitchenMate extends Application implements EventHandler<ActionEvent>
{
   public static void main(String [] args)
   {
      launch(args);
   }
   //declare labels private
   private Label messageLabel;
   private Label UnitsFrom; 
   private Label UnitsTo;
   //declare combo boxes private
   private ComboBox<String> UnitDisplay;
   private ComboBox<String> UnitDisplay1;
   //declare textFeilds private
   private TextField UnitInput;
   private TextField ConvertedUnit;
   //declare buttons private
   private Button ConversionButton;
   private Button RefreshButton;
   @Override
   public void start(Stage stage) throws Exception 
   {
      //set title
      stage.setTitle("KITCHENMATE");
      //set Labels that are needed
      messageLabel = new Label("The Unit Converter");
      UnitsFrom = new Label("Base Unit:");
      UnitsTo = new Label("Converted Unit:");
      
      //set font type, size, and to bold
      messageLabel.setFont(Font.font("Arial Black", FontWeight.BOLD, 25));
      UnitsFrom.setFont(Font.font("Arial", FontWeight.MEDIUM, 15));
      UnitsTo.setFont(Font.font("Arial", FontWeight.MEDIUM, 15));
      
      //Combo box or drop box to select unit to be converted 
      UnitDisplay = new ComboBox<>();
      UnitDisplay.getItems().addAll("Cups", "Liters", "Milliliters",
      "Fluid Ounces", "Quarts", "Gallons", "Pints",  "Centiliters");
      UnitDisplay.setValue("Cups");
      
      //String BaseValue = UnitDisplay.getValue();      *****
      
      //Drop box to select unit to be converted to
      UnitDisplay1 = new ComboBox<>();
      UnitDisplay1.getItems().addAll("Cups", "Liters", "Milliliters",
      "Fluid Ounces", "Quarts", "Gallons", "Pints",  "Centiliters");
      UnitDisplay1.setValue("Cups");
      
      //String ConvertedValue = UnitDisplay1.getValue();
      
      //create textFeilds
      UnitInput = new TextField();
      ConvertedUnit = new TextField();
      
      //create conversion button
      ConversionButton = new Button("CONVERT");
      //set action to button so it works when clicked
      ConversionButton.setOnAction(this);
      //create refresh button
      RefreshButton = new Button("Refresh");
      //set action so that the button works when pressed
      RefreshButton.setOnAction(this);

      //Create layout
      GridPane Layout = new GridPane();
      Layout.setAlignment(Pos.TOP_CENTER);
      Layout.setVgap(1);
      Layout.setHgap(1);
      Layout.add(messageLabel, 3, 0, 50, 1);
      Layout.add(UnitInput, 3, 197);
      Layout.add(UnitsFrom, 2, 200);
      Layout.add(UnitDisplay, 3, 200);
      Layout.add(UnitsTo, 7, 200);
      Layout.add(UnitDisplay1, 9, 200);
      Layout.add(ConversionButton, 4, 250);
      Layout.add(RefreshButton, 4, 253);
      Layout.add(ConvertedUnit, 9, 197); 
      //Layout.add(ConvertedUnit, 2, 197);
      Scene scene = new Scene(Layout);
      //scene.setFill(Color.RED);
      stage.setScene(scene);
      stage.show();
   }
   @Override
   public void handle(ActionEvent event)
   {
       if(event.getSource() == ConversionButton)
      {
         double UserInput;
         double FinalUnit;
         String BaseUnit = UnitDisplay.getValue();
         String ConvertedValue = UnitDisplay1.getValue();
         UserInput = Double.parseDouble(UnitInput.getText());
         FinalUnit = conversion(BaseUnit, ConvertedValue, UserInput);
         //Show result in ConvertedUnit text field
         ConvertedUnit.setText(String.valueOf(FinalUnit));    
      }
      else if(event.getSource() == RefreshButton)
      {
         //refresh both UnitInput and ConvertedValue textFields
         UnitInput.clear();
         ConvertedUnit.clear();
         //set both combo boxes back to selected default unit
         UnitDisplay.setValue("Cups");
         UnitDisplay1.setValue("Cups");
      }
   }
   //create toCups conversion methods
   public double getCupsToCups(double BaseUnit)
   {
      return BaseUnit * 1.0;
   }
   public double getPintsToCups(double BaseUnit)
   {
      return BaseUnit * 2.0;
   }
   public double getQuartsToCups(double BaseUnit)
   {
      return BaseUnit * 4.0;
   }
   public double getGallonsToCups(double BaseUnit)
   {
      return BaseUnit * 16.0;
   }
   public double getFluidOuncesToCups(double BaseUnit)
   {
      return BaseUnit * 0.125;
   }
   public double getLitersToCups(double BaseUnit)
   {
      return BaseUnit * 4.22675284;
   }
   public double getMillilitersToCups(double BaseUnit)
   {
      return BaseUnit * 0.00422675;
   }
   public double getCentilitersToCups(double BaseUnit)
   {
      return BaseUnit * 0.04226753;
   }
   //create toQuarts conversion methods
   public double getCupsToQuarts(double BaseUnit)
   {
      return BaseUnit * 0.25; 
   }
   public double getPintsToQuarts(double BaseUnit)
   {
      return BaseUnit * 0.5;
   }
   public double getQuartsToQuarts(double BaseUnit)
   {
      return BaseUnit * 1.0;
   }
   public double getGallonsToQuarts(double BaseUnit)
   {
      return BaseUnit * 4.0;
   }
   public double getFluidOuncesToQuarts(double BaseUnit)
   {
      return BaseUnit * 0.03125;
   }
   public double getLitersToQuarts(double BaseUnit)
   {
      return BaseUnit * 1.05668821;
   }
   public double getMillilitersToQuarts(double BaseUnit)
   {
      return BaseUnit * 0.00105669;
   }
   public double getCentilitersToQuarts(double BaseUnit)
   {
      return BaseUnit * 0.01056688;
   } 
   
   //to pint conversion methods
   public double getCupsToPints(double BaseUnit)
   {
      return BaseUnit * 0.5;
   }
   public double getGallonsToPints(double BaseUnit)
   {
      return BaseUnit * 8.0;
   }
   public double getPintsToPints(double BaseUnit)
   {
      return BaseUnit * 1.0;
   }
   public double getQuartsToPints(double BaseUnit)
   {
      return BaseUnit * 2.0;
   }
   public double getFluidOuncesToPints(double BaseUnit)
   {
      return BaseUnit * 0.0625;
   }
   public double getLitersToPints(double BaseUnit)
   {
      return BaseUnit * 2.11337642;
   }
   public double getMillilitersToPints(double BaseUnit)
   {
      //create big decimal since number is too small for double
      BigDecimal x = new BigDecimal("0.00211338");
      BigDecimal UnitAmount = BigDecimal.valueOf(BaseUnit);
      BigDecimal product = UnitAmount.multiply(x);
      return product.doubleValue();
   }
   public double getCentilitersToPints(double BaseUnit)
   {
      return BaseUnit * 0.02113376;
   }
   
   //create toGallon conversion methods
   public double getCupsToGallons(double BaseUnit)
   {
      return BaseUnit * 0.0625;
   }
   public double getPintsToGallons(double BaseUnit)
   {
      return BaseUnit * 0.125;
   }
   public double getQuartsToGallons(double BaseUnit)
   {
      return BaseUnit * 0.25;
   }
   public double getGallonsToGallons(double BaseUnit)
   {
      return BaseUnit * 1.0;
   }
   public double getFluidOuncesToGallons(double BaseUnit)
   {
      return BaseUnit * 0.0078125;
   }
   public double getLitersToGallons(double BaseUnit)
   {
      return BaseUnit * 0.26417205;
   }
   public double getMillilitersToGallons(double BaseUnit)
   {
      return BaseUnit * 0.00026417;
   }
   public double getCentilitersToGallons(double BaseUnit)
   {
      return BaseUnit * 0.00264172;
   }
   
   //create toFluidOunces methods
   public double getCupsToFluidOunces(double BaseUnit)
   {
      return BaseUnit * 8.0;
   }
   public double getPintsToFluidOunces(double BaseUnit)
   {
      return BaseUnit * 16.0;
   }
   public double getQuartsToFluidOunces(double BaseUnit)
   {
      return BaseUnit * 32.0;
   }
   public double getGallonsToFluidOunces(double BaseUnit)
   {
      return BaseUnit * 128.0;
   }
   public double getFluidOuncesToFluidOunces(double BaseUnit)
   {
      return BaseUnit * 1.0;
   }
   public double getLitersToFluidOunces(double BaseUnit)
   {
      return BaseUnit * 33.8140227;
   }
   public double getMillilitersToFluidOunces(double BaseUnit)
   {
      return BaseUnit * 0.03381402;
   }
   public double getCentilitersToFluidOunces(double BaseUnit)
   {
      return BaseUnit * 0.33814023;
   }
   
   //create toLiter conversion methods
   public double getCupsToLiters(double BaseUnit)
   {
      return BaseUnit * 0.23658824;
   }
   public double getPintsToLiters(double BaseUnit)
   {
      return BaseUnit * 0.47317647;
   }
   public double getQuartsToLiters(double BaseUnit)
   {
      return BaseUnit * 0.94635295;
   }
   public double getGallonsToLiters(double BaseUnit)
   {
      return BaseUnit * 3.78541178;
   }
   public double getFluidOuncesToLiters(double BaseUnit)
   {
      return BaseUnit * 0.02957353;
   }
   public double getLitersToLiters(double BaseUnit)
   {
      return BaseUnit * 1.0;
   }
   public double getMillilitersToLiters(double BaseUnit)
   {
      return BaseUnit * 0.001;
   }
   public double getCentilitersToLiters(double BaseUnit)
   {
      return BaseUnit * 0.01;
   }
   
   //create toMilliliter conversion methods
   public double getCupsToMilliliters(double BaseUnit)
   {
      return BaseUnit * 236.588236;
   }
   public double getPintsToMilliliters(double BaseUnit)
   {
      return BaseUnit * 473.176472;
   }
   public double getQuartsToMilliliters(double BaseUnit)
   {
      return BaseUnit * 946.352945;
   }
   public double getGallonsToMilliliters(double BaseUnit)
   {
      return BaseUnit * 3785.41178;
   }
   public double getFluidOuncesToMilliliters(double BaseUnit)
   {
      return BaseUnit * 29.5735295;
   }
   public double getLitersToMilliliters(double BaseUnit)
   {
      return BaseUnit * 1000.0;
   }
   public double getMillilitersToMilliliters(double BaseUnit)
   {
      return BaseUnit * 1.0;
   }
   public double getCentilitersToMilliliters(double BaseUnit)
   {
      return BaseUnit * 10.0;
   }
   
   //create toCentiliter conversion methods
   public double getCupsToCentiliters(double BaseUnit)
   {
      return BaseUnit * 23.6588236;
   }
   public double getPintsToCentiliters(double BaseUnit)
   {
      return BaseUnit * 47.3176473;
   }
   public double getQuartsToCentiliters(double BaseUnit)
   {
      return BaseUnit * 94.6352945;
   }
   public double getGallonsToCentiliters(double BaseUnit)
   {
      return BaseUnit * 378.541178;
   }
   public double getFluidOuncesToCentiliters(double BaseUnit)
   {
      return BaseUnit * 2.95735295;
   }
   public double getLitersToCentiliters(double BaseUnit)
   {
      return BaseUnit * 100.0;
   }
   public double getMillilitersToCentiliters(double BaseUnit)
   {
      return BaseUnit * 0.1;
   }
   public double getCentilitersToCentiliters(double BaseUnit)
   {
      return BaseUnit * 1.0;
   }
   public double conversion(String BaseUnit, String ConvertedValue,
   double UserInput)
   {
     /* switch(BaseValue)
      {
         case "Cups":
            return getCupsToPints;
      }  */
      switch(ConvertedValue)
      {
         case "Cups":
            if("Cups".equals(BaseUnit))
            {
               return getCupsToCups(UserInput);
            }
            else if("Pints".equals(BaseUnit))
            {
               return getPintsToCups(UserInput);
            }
            else if("Gallons".equals(BaseUnit))
            {
               return getGallonsToCups(UserInput);
            }
            else if("Fluid Ounces".equals(BaseUnit))
            {
               return getFluidOuncesToCups(UserInput);
            }
            else if("Liters".equals(BaseUnit))
            {
               return getLitersToCups(UserInput);
            }
            else if("Milliliters".equals(BaseUnit))
            {
               return getMillilitersToCups(UserInput);
            }
            else if("Centiliters".equals(BaseUnit))
            {
               return getCentilitersToCups(UserInput);
            }
         case "Pints": 
            if("Cups".equals(BaseUnit))
            {
               return getCupsToPints(UserInput);
            }
            else if("Gallons".equals(BaseUnit))
            {
               return getGallonsToPints(UserInput);
            }
            else if("Pints".equals(BaseUnit))
            {
               return getPintsToPints(UserInput);
            }
            else if("Quarts".equals(BaseUnit))
            {
               return getQuartsToPints(UserInput);
            }
            else if("Fluid Ounces".equals(BaseUnit))
            {
               return getFluidOuncesToPints(UserInput);
            }
            else if("Liters".equals(BaseUnit))
            {
               return getLitersToPints(UserInput);
            }
            else if("Milliliters".equals(BaseUnit))
            {
               return getMillilitersToPints(UserInput);
            }
            else
            {
               return getCentilitersToPints(UserInput);
            }
         case "Quarts": 
            if("Cups".equals(BaseUnit))
            {
               return getCupsToQuarts(UserInput);
            }
            else if("Pints".equals(BaseUnit))
            {
               return getPintsToQuarts(UserInput);
            }
            else if("Quarts".equals(BaseUnit))
            {
               return getQuartsToQuarts(UserInput);
            }
            else if("Gallons".equals(BaseUnit))
            {
               return getGallonsToQuarts(UserInput);
            }
            else if("Fluid Ounces".equals(BaseUnit))
            {
               return getFluidOuncesToQuarts(UserInput);
            }
            else if("Liters".equals(BaseUnit))
            {
               return getLitersToQuarts(UserInput);
            }
            else if("Milliliters".equals(BaseUnit))
            {
               return getMillilitersToQuarts(UserInput);
            }
            else if("Centiliters".equals(BaseUnit))
            {
               return getCentilitersToQuarts(UserInput);
            }
         case "Gallons": 
            if("Cups".equals(BaseUnit))
            {
               return getCupsToGallons(UserInput);
            }
            else if("Pints".equals(BaseUnit))
            {
               return getPintsToGallons(UserInput);
            }
            else if("Quarts".equals(BaseUnit))
            {
               return getQuartsToGallons(UserInput);
            }
            else if("Gallons".equals(BaseUnit))
            {
               return getGallonsToGallons(UserInput);
            }
            else if("Fluid Ounces".equals(BaseUnit))
            {
               return getFluidOuncesToGallons(UserInput);
            }
            else if("Liters".equals(BaseUnit))
            {
               return getLitersToGallons(UserInput);
            }
            else if("Milliliters".equals(BaseUnit))
            {
               return getMillilitersToGallons(UserInput);
            }
            else if("Centiliters".equals(BaseUnit))
            {
               return getCentilitersToGallons(UserInput);
            }
         case "Fluid Ounces":
            if("Cups".equals(BaseUnit))
            {
               return getCupsToFluidOunces(UserInput);
            }
            else if("Pints".equals(BaseUnit))
            {
               return getPintsToFluidOunces(UserInput);
            }
            else if("Quarts".equals(BaseUnit))
            {
               return getQuartsToFluidOunces(UserInput);
            }
            else if("Gallons".equals(BaseUnit))
            {
               return getGallonsToFluidOunces(UserInput);
            }
            else if("Fluid Ounces".equals(BaseUnit))
            {
               return getFluidOuncesToFluidOunces(UserInput);
            }
            else if("Liters".equals(BaseUnit))
            {
               return getLitersToFluidOunces(UserInput);
            }
            else if("Milliliters".equals(BaseUnit))
            {
               return getMillilitersToFluidOunces(UserInput);
            }
            else if("Centiliters".equals(BaseUnit))
            {
               return getCentilitersToFluidOunces(UserInput);
            }
         case "Liters":
            if("Cups".equals(BaseUnit))
            {
               return getCupsToLiters(UserInput);
            }
            else if("Pints".equals(BaseUnit))
            {
               return getPintsToLiters(UserInput);
            }
            else if("Quarts".equals(BaseUnit))
            {
               return getQuartsToLiters(UserInput);
            }
            else if("Gallons".equals(BaseUnit))
            {
               return getGallonsToLiters(UserInput);
            }
            else if("Fluid Ounces".equals(BaseUnit))
            {
               return getFluidOuncesToLiters(UserInput);
            }
            else if("Liters".equals(BaseUnit))
            {
               return getLitersToLiters(UserInput);
            }
            else if("Milliliters".equals(BaseUnit))
            {
               return getMillilitersToLiters(UserInput);
            }
            else if("Centiliters".equals(BaseUnit))
            {
               return getCentilitersToLiters(UserInput);
            }
         case "Milliliters":
            if("Cups".equals(BaseUnit))
            {
               return getCupsToMilliliters(UserInput);
            }
            else if("Pints".equals(BaseUnit))
            {
               return getPintsToMilliliters(UserInput);
            }
            else if("Quarts".equals(BaseUnit))
            {
               return getQuartsToMilliliters(UserInput);
            }
            else if("Gallons".equals(BaseUnit))
            {
               return getGallonsToMilliliters(UserInput);
            }
            else if("Fluid Ounces".equals(BaseUnit))
            {
               return getFluidOuncesToMilliliters(UserInput);
            }
            else if("Liters".equals(BaseUnit))
            {
               return getLitersToMilliliters(UserInput);
            }
            else if("Milliliters".equals(BaseUnit))
            {
               return getMillilitersToMilliliters(UserInput);
            }
            else if("Centiliters".equals(BaseUnit))
            {
               return getCentilitersToMilliliters(UserInput);
            }
         case "Centiliters":
            if("Cups".equals(BaseUnit))
            {
               return getCupsToCentiliters(UserInput);
            }
            else if("Pints".equals(BaseUnit))
            {
               return getPintsToCentiliters(UserInput);
            }
            else if("Quarts".equals(BaseUnit))
            {
               return getQuartsToCentiliters(UserInput);
            }
            else if("Gallons".equals(BaseUnit))
            {
               return getGallonsToCentiliters(UserInput);
            }
            else if("Fluid Ounces".equals(BaseUnit))
            {
               return getFluidOuncesToCentiliters(UserInput);
            }
            else if("Liters".equals(BaseUnit))
            {
               return getLitersToCentiliters(UserInput);
            }
            else if("Milliliters".equals(BaseUnit))
            {
               return getMillilitersToCentiliters(UserInput);
            }
            else if("Centiliters".equals(BaseUnit))
            {
               return getCentilitersToCentiliters(UserInput);
            }
            
      }
      return 0.0;
   } 
   @Override
   public void stop()
   {
      System.out.println("The KitchenMate Application has been closed.");
   }
  
}
      