/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package budgettracker;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.util.Random;
import javafx.scene.text.Text;
import javafx.scene.Group;
import javafx.scene.control.*;
import javafx.scene.shape.*;
import javafx.scene.paint.Color;
import java.time.LocalDate;
import javafx.scene.control.Alert.AlertType;

/**
 *
 * @author henrydare
 */
public class BudgetTracker extends Application {

    public DatePicker date;
    public TextField incomeAmount;
    public ComboBox savingTarget;
    public TextField amount;
    public ComboBox flowDirection;
    public ComboBox expenseCategory;
    public ComboBox savingCategory;
    public Button update;
    public Button save;
    public Button load;
    public Button delete;
    public TextArea goal1;
    public TextArea goal2;
    public TextArea goal3;
    public Text underperforming;
    public Text overperforming;
    public Text meeting;

    @Override
    public void start(Stage primaryStage) {

        Rectangle backgroundBox = new Rectangle(25, 25, 250, 115);
        backgroundBox.setStroke(Color.BLACK);
        backgroundBox.setFill(null);
        Text backgroundLabel = new Text(100, 50, "Cash Flow Plan");
        backgroundLabel.setFill(Color.BLUE);
        Text incomeLabel = new Text(50, 80, "Bi-weekly Income:");
        incomeAmount = new TextField("0");
        incomeAmount.setPrefWidth(65);
        incomeAmount.setPrefHeight(5);
        incomeAmount.setLayoutX(165);
        incomeAmount.setLayoutY(62);
        Text saveTargetLabel = new Text(50, 110, "Savings Target:");
        savingTarget = new ComboBox();
        savingTarget.getItems().addAll("0%", "5%", "10%", "15%", "20%", "25%", "30%", "35%", "40%", "45%", "50%",
                "55%", "60%", "65%", "70%", "75%", "80%", "85%", "90%", "95%", "100%");
        savingTarget.setValue("0%");
        savingTarget.setLayoutX(165);
        savingTarget.setLayoutY(94);
        savingTarget.setPrefWidth(80);

        Rectangle trackingBox = new Rectangle(25, 165, 250, 300);
        trackingBox.setStroke(Color.BLACK);
        trackingBox.setFill(null);
        Text trackingLabel = new Text(115, 190, "Transaction");
        trackingLabel.setFill(Color.BLUE);
        Text dateLabel = new Text(50, 220, "Date:");
        date = new DatePicker();
        date.setPrefWidth(110);
        date.setPrefHeight(5);
        date.setLayoutX(85);
        date.setLayoutY(202);
        Text amountLabel = new Text(50, 252, "Amount in Dollars:");
        amount = new TextField("0");
        amount.setPrefWidth(65);
        amount.setPrefHeight(5);
        amount.setLayoutX(155);
        amount.setLayoutY(234);
        Text directionLabel = new Text(50, 282, "Direction:");
        flowDirection = new ComboBox();
        flowDirection.getItems().addAll("Deposit", "Withdrawl");
        flowDirection.setValue("Choose");
        flowDirection.setLayoutX(110);
        flowDirection.setLayoutY(266);
        flowDirection.setPrefWidth(110);
        Text expenseTypeLabel = new Text(50, 314, "Expense Type:");
        expenseCategory = new ComboBox();
        expenseCategory.getItems().addAll("Housing Mortgage", "Housing Rent", "Home Insurance", "Property Taxes", "Utilities", "Food - Groceries", "Food - Resturaunts",
                "Transportation - Car Payment", "Transportation - Fuel", "Transportation - Repairs", "Transportation - Insurance", "Transportation - licenses / Fees",
                "Clothing", "Medical - Doctor Bills", "Medical - Medications", "Medical - Insurance", "Medical - Miscellaneous", "Personal", "Other");
        expenseCategory.setValue("Choose");
        expenseCategory.setLayoutX(50);
        expenseCategory.setLayoutY(324);
        expenseCategory.setPrefWidth(220);
        expenseCategory.setPrefHeight(5);
        Text savingTypeLabel = new Text(50, 372, "Deposit Type:");
        savingCategory = new ComboBox();
        savingCategory.getItems().addAll("Savings - General", "Emergency Fund", "College Fund", "Retirement Fund");
        savingCategory.setValue("Choose");
        savingCategory.setLayoutX(50);
        savingCategory.setLayoutY(382);
        savingCategory.setPrefWidth(220);
        update = new Button("Update");
        update.setId("update");
        update.setLayoutX(50);
        update.setLayoutY(420);
        update.setOnAction(this::update);
        save = new Button("Save");
        save.setId("save");
        save.setLayoutX(114);
        save.setLayoutY(420);
        save.setOnAction(this::save);
        load = new Button("Load");
        load.setId("load");
        load.setLayoutX(165);
        load.setLayoutY(420);
        load.setOnAction(this::load);
        delete = new Button("Delete");
        delete.setId("delete");
        delete.setLayoutX(215);
        delete.setLayoutY(420);
        delete.setOnAction(this::delete);

        Rectangle goalBox = new Rectangle(300, 25, 1100, 232);
        goalBox.setStroke(Color.BLACK);
        goalBox.setFill(null);
        Text goalLabel = new Text(800, 50, "Top Budget Goals");
        goalLabel.setFill(Color.BLUE);
        Text goal1Label = new Text(325, 85, "Goal 1:");
        goal1 = new TextArea();
        goal1.setPrefWidth(1000);
        goal1.setPrefHeight(5);
        goal1.setLayoutX(375);
        goal1.setLayoutY(62);
        Text goal2Label = new Text(325, 150, "Goal 2:");
        goal2 = new TextArea();
        goal2.setPrefWidth(1000);
        goal2.setPrefHeight(5);
        goal2.setLayoutX(375);
        goal2.setLayoutY(127);
        Text goal3Label = new Text(325, 215, "Goal 3:");
        goal3 = new TextArea();
        goal3.setPrefWidth(1000);
        goal3.setPrefHeight(5);
        goal3.setLayoutX(375);
        goal3.setLayoutY(192);

        Rectangle budgetStandingBox = new Rectangle(300, 282, 1100, 183);
        budgetStandingBox.setStroke(Color.BLACK);
        budgetStandingBox.setFill(null);
        Text budgetStandingLabel = new Text(800, 307, "Budget Goal Standing");
        budgetStandingLabel.setFill(Color.BLUE);
        underperforming = new Text(475, 380, "Underperforming");
        underperforming.setStyle("-fx-font-size: 24");
        underperforming.setFill(null);
        underperforming.setStroke(Color.BLACK);
        meeting = new Text(800, 380, "Meeting");
        meeting.setStyle("-fx-font-size: 24");
        meeting.setFill(null);
        meeting.setStroke(Color.BLACK);
        overperforming = new Text(1025, 380, "Overperforming");
        overperforming.setStyle("-fx-font-size: 24");
        overperforming.setFill(null);
        overperforming.setStroke(Color.BLACK);

        Rectangle budgetChartBox = new Rectangle(25, 490, 1377, 380);
        budgetChartBox.setStroke(Color.BLACK);
        budgetChartBox.setFill(null);
        Text budgetChartBoxLabel = new Text(690, 515, "Budget Chart");
        budgetChartBoxLabel.setFill(Color.BLUE);

        Group backgroundItems = new Group(backgroundBox, backgroundLabel, incomeLabel, incomeAmount, saveTargetLabel, savingTarget);

        Group trackingItems = new Group(trackingBox, trackingLabel, dateLabel, date, amountLabel, amount, directionLabel, flowDirection, expenseTypeLabel, expenseCategory, savingTypeLabel, savingCategory, update, save, load, delete);

        Group budgetGoalItems = new Group(goalBox, goalLabel, goal1Label, goal1, goal2Label, goal2, goal3Label, goal3);

        Group budgetStandingItems = new Group(budgetStandingBox, budgetStandingLabel, underperforming, meeting, overperforming);

        Group budgetChartItems = new Group(budgetChartBox, budgetChartBoxLabel);

        Group root = new Group(backgroundItems, trackingItems, budgetGoalItems, budgetStandingItems, budgetChartItems);

        Scene scene = new Scene(root, 1000, 1000);

        primaryStage.setTitle("Budget Tracker");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void update(ActionEvent event) {
        String incomeTest = incomeAmount.getText();
        boolean incorrect = true;
        while (incorrect) {
            try {
                Double.parseDouble(incomeTest);
                incorrect = false;
            } catch (NumberFormatException nfe) {
                incomeTest = "0";
                Alert a = new Alert(AlertType.ERROR);
                a.setContentText("Invalid data type");
                a.show();
            }
        }

        String amountTest = amount.getText();
        boolean incorrect2 = true;
        while (incorrect2) {
            try {
                Double.parseDouble(amountTest);
                incorrect2 = false;
            } catch (NumberFormatException nfe) {
                amountTest = "0";
                Alert a = new Alert(AlertType.ERROR);
                a.setContentText("Invalid data type");
                a.show();
            }
        }

        int biweekIncome = Integer.parseInt(incomeAmount.getText());
        String targets = savingTarget.getValue().toString();
        String noPercentT = targets.replace("%", "");
        int targetSaved = Integer.parseInt(noPercentT);
        int monthlyInc = biweekIncome * 2;
        double actualTSaved = .01 * targetSaved;
        double goal = monthlyInc * actualTSaved;
        System.out.println(goal);
        /* double currentAmount = monthly inc - expenses array total;
        if(goal < currentAmount){
        underperforming.setFill(Color.RED);  
        }else if(goal == currentAmount){
        meeting.setFill(Color.GREEN);
        }else if(goal > currentAmount){
        overperforming.setFill(Color.GREEN);
        }
        
        
        waiting on update array to accuratley depict expenses
         */
    }

    public void save(ActionEvent event) {
        String incomeTest = incomeAmount.getText();
        boolean incorrect = true;
        while (incorrect) {
            try {
                Double.parseDouble(incomeTest);
                incorrect = false;
            } catch (NumberFormatException nfe) {
                incomeTest = "0";
                Alert a = new Alert(AlertType.ERROR);
                a.setContentText("Invalid data type");
                a.show();
            }
        }

        String amountTest = amount.getText();
        boolean incorrect2 = true;
        while (incorrect2) {
            try {
                Double.parseDouble(amountTest);
                incorrect2 = false;
            } catch (NumberFormatException nfe) {
                amountTest = "0";
                Alert a = new Alert(AlertType.ERROR);
                a.setContentText("Invalid data type");
                a.show();
            }
        }
        
        
        
        
    }

    public void load(ActionEvent event) {

    }

    public void delete(ActionEvent event) {

    }

    /*
    update button method
    
    arguably the biggest method.
    
    when clicked this button should pull the income amount, savings target, date (ignore year), dollar amount, direction, expense or deposit type.
    
    this information will likely need to be stored in an array so the user can click update multiple times to have multiple data points. each array line should have all of the above info
    
    The most critical information the chart / status will use are the income, amount, direction, savings target, and date fields. 
    using the critical pieces should allow generation of a data point to be added to the month specified on the line chart. 
    the chart will have a horizontal axis of months and a vertical axis of percents, and as data points are updated, the data point for that specific month will rise or fall.
    the horizontal axis will be the percent towards saving target, with 100% being on targer, and decreasing values below to 0% for underperforming and increasing values to 200% for overperfomring.
    the year is a complication we likely dont have time for so regardless of the year plot the data point on the month specified. 
    It will use the income and targer saving percent to find the dollar amount needed to be at goal, and as expenses are added, the percent data is lowerd and as deposits come it rises.
    
    
    this button will also have a simpiler indication in the budget status field. this field will calculate the current amount saved (initialized to the amount earned in a month)
    and initialises the fill of the text to green for meeting. as expenses are added and the user fails to meet, the fill for meeting is set to null and underperfomring is set to red.
    as user exceeds target, the other fills are null and overperforming is set to green fill.
    
    
     */
 /*
    save button method
    
    This should pull the array items from wherever update stores and puts them in an integrated text file. an example of how to do this is the dungeons and damned application I put in discord
    
     */
 /*
    load button method
    
    this should pull all the lines from the integrated text file and replace them in the array update uses and then restore all the data points and budget status
    an example of loading and saving to integrated text files is in the dungeons and damned app in discord
    
     */
 /*
    delete button method
    
    this should clear all data stored in the integrated text file and clear the update array and set all fields to default values
    
    
     */
    // the budget goals is just to include goals and doesn't link to anything, it is basically finished.
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        launch(args);
    }

}
