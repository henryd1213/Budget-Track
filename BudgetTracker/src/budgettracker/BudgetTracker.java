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
import javafx.scene.shape.Shape;
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
import java.lang.Exception;

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
    private static double numbers;
    public double monthlyTotal;

    public static Line janFeb;
    public static Line febMar;
    public static Line marApr;
    public static Line aprMay;
    public static Line mayJun;
    public static Line junJul;
    public static Line julAug;
    public static Line augSep;
    public static Line sepOct;
    public static Line octNov;
    public static Line novDec;

    private static Circle janPoint;
    private static Circle febPoint;
    private static Circle marPoint;
    private static Circle aprPoint;
    private static Circle mayPoint;
    private static Circle junPoint;
    private static Circle julPoint;
    private static Circle augPoint;
    private static Circle sepPoint;
    private static Circle octPoint;
    private static Circle novPoint;
    private static Circle decPoint;

    public Text janAmount;
    public Text febAmount;
    public Text marAmount;
    public Text aprAmount;
    public Text mayAmount;
    public Text junAmount;
    public Text julAmount;
    public Text augAmount;
    public Text sepAmount;
    public Text octAmount;
    public Text novAmount;
    public Text decAmount;

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
        incomeAmount.setLayoutX(175);
        incomeAmount.setLayoutY(62);
        Text saveTargetLabel = new Text(50, 110, "Savings Target:");
        savingTarget = new ComboBox();
        savingTarget.getItems().addAll("0%", "5%", "10%", "15%", "20%", "25%", "30%", "35%", "40%", "45%", "50%",
                "55%", "60%", "65%", "70%", "75%", "80%", "85%", "90%", "95%", "100%");
        savingTarget.setValue("0%");
        savingTarget.setLayoutX(175);
        savingTarget.setLayoutY(94);
        savingTarget.setPrefWidth(90);

        Rectangle trackingBox = new Rectangle(25, 165, 250, 300);
        trackingBox.setStroke(Color.BLACK);
        trackingBox.setFill(null);
        Text trackingLabel = new Text(115, 190, "Transaction");
        trackingLabel.setFill(Color.BLUE);
        Text dateLabel = new Text(50, 220, "Date:");
        date = new DatePicker();
        date.setPrefWidth(110);
        date.setPrefHeight(5);
        date.setLayoutX(95);
        date.setLayoutY(202);
        date.setValue(LocalDate.now());
        Text amountLabel = new Text(50, 252, "Amount in Dollars:");
        amount = new TextField("0");
        amount.setPrefWidth(65);
        amount.setPrefHeight(5);
        amount.setLayoutX(175);
        amount.setLayoutY(234);
        Text directionLabel = new Text(50, 282, "Direction:");
        flowDirection = new ComboBox();
        flowDirection.getItems().addAll("Deposit", "Withdrawl");
        flowDirection.setValue("Choose");
        flowDirection.setLayoutX(120);
        flowDirection.setLayoutY(266);
        flowDirection.setPrefWidth(130);
        Text expenseTypeLabel = new Text(50, 314, "Expense Type:");
        expenseCategory = new ComboBox();
        expenseCategory.getItems().addAll("Choose", "Housing Mortgage", "Housing Rent", "Home Insurance", "Property Taxes", "Utilities", "Food - Groceries", "Food - Resturaunts",
                "Transportation - Car Payment", "Transportation - Fuel", "Transportation - Repairs", "Transportation - Insurance", "Transportation - licenses / Fees",
                "Clothing", "Medical - Doctor Bills", "Medical - Medications", "Medical - Insurance", "Medical - Miscellaneous", "Personal", "Other");
        expenseCategory.setValue("Choose");
        expenseCategory.setLayoutX(50);
        expenseCategory.setLayoutY(324);
        expenseCategory.setPrefWidth(220);
        expenseCategory.setPrefHeight(5);
        Text savingTypeLabel = new Text(50, 372, "Deposit Type:");
        savingCategory = new ComboBox();
        savingCategory.getItems().addAll("Choose", "Savings - General", "Emergency Fund", "College Fund", "Retirement Fund");
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
        Text budgetStandingLabel = new Text(800, 307, "Savings Goal Status");
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
        Text budgetChartBoxLabel = new Text(550, 515, "Goal Achievement YTD - Current Balance and Percent of Goal Attained");
        budgetChartBoxLabel.setFill(Color.BLUE);

        Line horizAxis = new Line();
        horizAxis.setStartX(75);
        horizAxis.setStartY(820);
        horizAxis.setEndX(1377);
        horizAxis.setEndY(820);

        Line vertAxis = new Line();
        vertAxis.setStartX(75);
        vertAxis.setStartY(820);
        vertAxis.setEndX(75);
        vertAxis.setEndY(515);

        Text zeroPercentLabel = new Text(50, 820, "0");

        Text tenPercentLabel = new Text(50, 805, "10");

        Text twentyPercentLabel = new Text(50, 790, "20");

        Text thirtyPercentLabel = new Text(50, 775, "30");

        Text fourtyPercentLabel = new Text(50, 760, "40");

        Text fiftyPercentLabel = new Text(50, 745, "50");

        Text sixtyPercentLabel = new Text(50, 730, "60");

        Text seventyPercentLabel = new Text(50, 715, "70");

        Text eightyPercentLabel = new Text(50, 700, "80");

        Text ninetyPercentLabel = new Text(50, 685, "90");

        Text oneHundredPercentLabel = new Text(50, 670, "100");

        Text oneHundredTenPercentLabel = new Text(50, 655, "110");

        Text oneHundredTwentyPercentLabel = new Text(50, 640, "120");

        Text oneHundredThirtyPercentLabel = new Text(50, 625, "130");

        Text oneHundredFourtyPercentLabel = new Text(50, 610, "140");

        Text oneHundredFiftyPercentLabel = new Text(50, 595, "150");

        Text oneHundredSixtyPercentLabel = new Text(50, 580, "160");

        Text oneHundredSeventyPercentLabel = new Text(50, 565, "170");

        Text oneHundredEightyPercentLabel = new Text(50, 550, "180");

        Text oneHundredNinetyPercentLabel = new Text(50, 535, "190");

        Text twoHundredPercentLabel = new Text(50, 520, "200");

        Text janLabel = new Text(100, 845, "January");
        Text febLabel = new Text(208, 845, "February");
        Text marLabel = new Text(316, 845, "March");
        Text aprLabel = new Text(424, 845, "April");
        Text mayLabel = new Text(532, 845, "May");
        Text junLabel = new Text(640, 845, "June");
        Text julLabel = new Text(748, 845, "July");
        Text augLabel = new Text(856, 845, "August");
        Text sepLabel = new Text(964, 845, "September");
        Text octLabel = new Text(1072, 845, "October");
        Text novLabel = new Text(1180, 845, "November");
        Text decLabel = new Text(1288, 845, "December");

        janPoint = new Circle();
        janPoint.setCenterX(120.0);
        janPoint.setCenterY(670.0);
        janPoint.setRadius(5.0);
        janPoint.setStroke(null);
        janPoint.setFill(null);

        febPoint = new Circle();
        febPoint.setCenterX(228.0);
        febPoint.setCenterY(670.0);
        febPoint.setRadius(5.0);
        febPoint.setStroke(null);
        febPoint.setFill(null);

        marPoint = new Circle();
        marPoint.setCenterX(336.0);
        marPoint.setCenterY(670.0);
        marPoint.setRadius(5.0);
        marPoint.setStroke(null);
        marPoint.setFill(null);

        aprPoint = new Circle();
        aprPoint.setCenterX(444.0);
        aprPoint.setCenterY(670.0);
        aprPoint.setRadius(5.0);
        aprPoint.setStroke(null);
        aprPoint.setFill(null);

        mayPoint = new Circle();
        mayPoint.setCenterX(572.0);
        mayPoint.setCenterY(670.0);
        mayPoint.setRadius(5.0);
        mayPoint.setStroke(null);
        mayPoint.setFill(null);

        junPoint = new Circle();
        junPoint.setCenterX(660.0);
        junPoint.setCenterY(670.0);
        junPoint.setRadius(5.0);
        junPoint.setStroke(null);
        junPoint.setFill(null);

        julPoint = new Circle();
        julPoint.setCenterX(768.0);
        julPoint.setCenterY(670.0);
        julPoint.setRadius(5.0);
        julPoint.setStroke(null);
        julPoint.setFill(null);

        augPoint = new Circle();
        augPoint.setCenterX(876.0);
        augPoint.setCenterY(670.0);
        augPoint.setRadius(5.0);
        augPoint.setStroke(null);
        augPoint.setFill(null);

        sepPoint = new Circle();
        sepPoint.setCenterX(984.0);
        sepPoint.setCenterY(670.0);
        sepPoint.setRadius(5.0);
        sepPoint.setStroke(null);
        sepPoint.setFill(null);

        octPoint = new Circle();
        octPoint.setCenterX(1092.0);
        octPoint.setCenterY(670.0);
        octPoint.setRadius(5.0);
        octPoint.setStroke(null);
        octPoint.setFill(null);

        novPoint = new Circle();
        novPoint.setCenterX(1200.0);
        novPoint.setCenterY(670.0);
        novPoint.setRadius(5.0);
        novPoint.setStroke(null);
        novPoint.setFill(null);

        decPoint = new Circle();
        decPoint.setCenterX(1308.0);
        decPoint.setCenterY(670.0);
        decPoint.setRadius(5.0);
        decPoint.setStroke(null);
        decPoint.setFill(null);

        janFeb = new Line();
        janFeb.setStartX(120);
        janFeb.setStartY(670);
        janFeb.setEndX(228);
        janFeb.setEndY(670);
        janFeb.setStroke(null);

        febMar = new Line();
        febMar.setStartX(228);
        febMar.setStartY(670);
        febMar.setEndX(336);
        febMar.setEndY(670);
        febMar.setStroke(null);

        marApr = new Line();
        marApr.setStartX(336);
        marApr.setStartY(670);
        marApr.setEndX(444);
        marApr.setEndY(670);
        marApr.setStroke(null);

        aprMay = new Line();
        aprMay.setStartX(444);
        aprMay.setStartY(670);
        aprMay.setEndX(572);
        aprMay.setEndY(670);
        aprMay.setStroke(null);

        mayJun = new Line();
        mayJun.setStartX(572);
        mayJun.setStartY(670);
        mayJun.setEndX(660);
        mayJun.setEndY(670);
        mayJun.setStroke(null);

        junJul = new Line();
        junJul.setStartX(660);
        junJul.setStartY(670);
        junJul.setEndX(768);
        junJul.setEndY(670);
        junJul.setStroke(null);

        julAug = new Line();
        julAug.setStartX(768);
        julAug.setStartY(670);
        julAug.setEndX(876);
        julAug.setEndY(670);
        julAug.setStroke(null);

        augSep = new Line();
        augSep.setStartX(876);
        augSep.setStartY(670);
        augSep.setEndX(984);
        augSep.setEndY(670);
        augSep.setStroke(null);

        sepOct = new Line();
        sepOct.setStartX(984);
        sepOct.setStartY(670);
        sepOct.setEndX(1092);
        sepOct.setEndY(670);
        sepOct.setStroke(null);

        octNov = new Line();
        octNov.setStartX(1092);
        octNov.setStartY(670);
        octNov.setEndX(1200);
        octNov.setEndY(670);
        octNov.setStroke(null);

        novDec = new Line();
        novDec.setStartX(1200);
        novDec.setStartY(670);
        novDec.setEndX(1308);
        novDec.setEndY(670);
        novDec.setStroke(null);

        janAmount = new Text(100, 800, "");
        janAmount.setFill(null);

        febAmount = new Text(208, 800, "");
        febAmount.setFill(null);

        marAmount = new Text(316, 800, "");
        marAmount.setFill(null);

        aprAmount = new Text(424, 800, "");
        aprAmount.setFill(null);

        mayAmount = new Text(532, 800, "");
        mayAmount.setFill(null);

        junAmount = new Text(640, 800, "");
        junAmount.setFill(null);

        julAmount = new Text(748, 800, "");
        julAmount.setFill(null);

        augAmount = new Text(856, 800, "");
        augAmount.setFill(null);

        sepAmount = new Text(964, 800, "");
        sepAmount.setFill(null);

        octAmount = new Text(1072, 800, "");
        octAmount.setFill(null);

        novAmount = new Text(1180, 800, "");
        novAmount.setFill(null);

        decAmount = new Text(1288, 800, "");
        decAmount.setFill(null);

        Group backgroundItems = new Group(backgroundBox, backgroundLabel, incomeLabel, incomeAmount, saveTargetLabel, savingTarget);

        Group trackingItems = new Group(trackingBox, trackingLabel, dateLabel, date, amountLabel, amount, directionLabel, flowDirection, expenseTypeLabel, expenseCategory, savingTypeLabel, savingCategory, update, save, load, delete);

        Group budgetGoalItems = new Group(goalBox, goalLabel, goal1Label, goal1, goal2Label, goal2, goal3Label, goal3);

        Group budgetStandingItems = new Group(budgetStandingBox, budgetStandingLabel, underperforming, meeting, overperforming);

        Group budgetChartItems = new Group(budgetChartBox, budgetChartBoxLabel, horizAxis, vertAxis, zeroPercentLabel, tenPercentLabel, twentyPercentLabel, thirtyPercentLabel,
                fourtyPercentLabel, fiftyPercentLabel, sixtyPercentLabel, seventyPercentLabel, eightyPercentLabel, ninetyPercentLabel, oneHundredPercentLabel,
                oneHundredTenPercentLabel, oneHundredTwentyPercentLabel, oneHundredThirtyPercentLabel, oneHundredFourtyPercentLabel, oneHundredFiftyPercentLabel,
                oneHundredSixtyPercentLabel, oneHundredSeventyPercentLabel, oneHundredEightyPercentLabel, oneHundredNinetyPercentLabel, twoHundredPercentLabel,
                janLabel, febLabel, marLabel, aprLabel, mayLabel, junLabel, julLabel, augLabel, sepLabel, octLabel, novLabel, decLabel,
                janPoint, febPoint, marPoint, aprPoint, mayPoint, junPoint, julPoint, augPoint, sepPoint, octPoint, novPoint, decPoint,
                janFeb, febMar, marApr, aprMay, mayJun, junJul, julAug, augSep, sepOct, octNov, novDec,
                janAmount, febAmount, marAmount, aprAmount, mayAmount, junAmount, julAmount, augAmount, sepAmount, octAmount, novAmount, decAmount);

        Group root = new Group(backgroundItems, trackingItems, budgetGoalItems, budgetStandingItems, budgetChartItems);

        ScrollPane sp = new ScrollPane();

        sp.setContent(root);

        Scene scene = new Scene(sp, 1000, 1000);

        primaryStage.setTitle("Budget Tracker");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void update(ActionEvent event) {
        String chosenExpense = expenseCategory.getValue().toString();
        String chosenSavings = savingCategory.getValue().toString();
        String chosenDirection = flowDirection.getValue().toString();
        double enteredAmount = Double.parseDouble(amount.getText());

        if (chosenDirection == "Choose") {
            Alert a = new Alert(AlertType.ERROR);
            a.setContentText("Please select Deposit or Withdrawl");
            a.show();
        } else if (chosenExpense != "Choose" && chosenSavings != "Choose") {
            expenseCategory.setValue("Choose");
            savingCategory.setValue("Choose");
            enteredAmount = 0;
            Alert a = new Alert(AlertType.ERROR);
            a.setContentText("Cannot select both save and deposit");
            a.show();
        } else if (chosenDirection == "Withdrawl" && chosenExpense == "Choose") {
            savingCategory.setValue("Choose");
            Alert a = new Alert(AlertType.ERROR);
            a.setContentText("Please select expense type");
            a.show();
        } else if (chosenDirection == "Deposit" && chosenSavings == "Choose") {
            expenseCategory.setValue("Choose");
            Alert a = new Alert(AlertType.ERROR);
            a.setContentText("Please select deposit type");
            a.show();
        }

        int biweekIncome = Integer.parseInt(incomeAmount.getText());
        String targets = savingTarget.getValue().toString();
        String noPercentT = targets.replace("%", "");
        int targetSaved = Integer.parseInt(noPercentT);
        int monthlyInc = biweekIncome * 2;
        double actualTSaved = .01 * targetSaved;
        double goal = monthlyInc * actualTSaved;

        String uneditDate = date.getValue().toString();
        char dateMonthOne = uneditDate.charAt(5);
        char dateMonthTwo = uneditDate.charAt(6);
        String bruh = String.valueOf(dateMonthOne);
        String bruh2 = String.valueOf(dateMonthTwo);
        String dateMonth = bruh + bruh2;
        int dateMonthInt = Integer.parseInt(dateMonth);

        // System.out.println(monthlyTotal);
        //  System.out.println(numbers);
        //System.out.println(goalPercentRounded);
        //nested if statement, first is associating percent to goal percent and plotting y value. inside if is associating dateMonthInt with x value according to month
        if (chosenDirection == "Withdrawl" && chosenExpense != "Choose") {
            numbers -= enteredAmount;
        } else if (chosenDirection == "Deposit" && chosenSavings != "Choose") {
            numbers += enteredAmount;
        }

        monthlyTotal = monthlyInc + numbers;
        double goalPercent;
        double goalPercentRounded;

        goalPercent = (monthlyTotal / goal) * 100;
        if (targetSaved == 0) {
            goalPercentRounded = 100;
        } else {
            goalPercentRounded = Math.round(goalPercent / 10.0) * 10;
        }

        if (dateMonthInt == 1) {
            janAmount.setText("$" + monthlyTotal + ", " + String.valueOf(goalPercentRounded) + "%");

            if (goalPercentRounded <= 0) {
                janPoint.setCenterY(820.0);
                janFeb.setStartY(820);
                janAmount.setY(835);
                janAmount.setFill(Color.BLACK);
                janPoint.setStroke(Color.RED);
                janPoint.setFill(Color.RED);
            } else if (goalPercentRounded == 10) {
                janPoint.setCenterY(805.0);
                janFeb.setStartY(805);
                janAmount.setY(820);
                janAmount.setFill(Color.BLACK);
                janPoint.setStroke(Color.RED);
                janPoint.setFill(Color.RED);
            } else if (goalPercentRounded == 20) {
                janPoint.setCenterY(790.0);
                janFeb.setStartY(790);
                janAmount.setY(805);
                janAmount.setFill(Color.BLACK);
                janPoint.setStroke(Color.RED);
                janPoint.setFill(Color.RED);
            } else if (goalPercentRounded == 30) {
                janPoint.setCenterY(775.0);
                janFeb.setStartY(775);
                janAmount.setY(790);
                janAmount.setFill(Color.BLACK);
                janPoint.setStroke(Color.RED);
                janPoint.setFill(Color.RED);
            } else if (goalPercentRounded == 40) {
                janPoint.setCenterY(760.0);
                janFeb.setStartY(760);
                janAmount.setY(775);
                janAmount.setFill(Color.BLACK);
                janPoint.setStroke(Color.RED);
                janPoint.setFill(Color.RED);
            } else if (goalPercentRounded == 50) {
                janPoint.setCenterY(745.0);
                janFeb.setStartY(745);
                janAmount.setY(760);
                janAmount.setFill(Color.BLACK);
                janPoint.setStroke(Color.RED);
                janPoint.setFill(Color.RED);
            } else if (goalPercentRounded == 60) {
                janPoint.setCenterY(730.0);
                janFeb.setStartY(730);
                janAmount.setY(745);
                janAmount.setFill(Color.BLACK);
                janPoint.setStroke(Color.RED);
                janPoint.setFill(Color.RED);
            } else if (goalPercentRounded == 70) {
                janPoint.setCenterY(715.0);
                janFeb.setStartY(715);
                janAmount.setY(730);
                janAmount.setFill(Color.BLACK);
                janPoint.setStroke(Color.RED);
                janPoint.setFill(Color.RED);
            } else if (goalPercentRounded == 80) {
                janPoint.setCenterY(700.0);
                janFeb.setStartY(700);
                janAmount.setY(715);
                janAmount.setFill(Color.BLACK);
                janPoint.setStroke(Color.RED);
                janPoint.setFill(Color.RED);
            } else if (goalPercentRounded == 90) {
                janPoint.setCenterY(685.0);
                janFeb.setStartY(685);
                janAmount.setY(700);
                janAmount.setFill(Color.BLACK);
                janPoint.setStroke(Color.RED);
                janPoint.setFill(Color.RED);
            } else if (goalPercentRounded == 100) {
                janPoint.setCenterY(670.0);
                janFeb.setStartY(670);
                janAmount.setY(685);
                janAmount.setFill(Color.BLACK);
                janPoint.setStroke(Color.GREEN);
                janPoint.setFill(Color.GREEN);
            } else if (goalPercentRounded == 110) {
                janPoint.setCenterY(655.0);
                janFeb.setStartY(655);
                janAmount.setY(670);
                janAmount.setFill(Color.BLACK);
                janPoint.setStroke(Color.GREEN);
                janPoint.setFill(Color.GREEN);
            } else if (goalPercentRounded == 120) {
                janPoint.setCenterY(640.0);
                janFeb.setStartY(640);
                janAmount.setY(655);
                janAmount.setFill(Color.BLACK);
                janPoint.setStroke(Color.GREEN);
                janPoint.setFill(Color.GREEN);
            } else if (goalPercentRounded == 130) {
                janPoint.setCenterY(625.0);
                janFeb.setStartY(625);
                janAmount.setY(640);
                janAmount.setFill(Color.BLACK);
                janPoint.setStroke(Color.GREEN);
                janPoint.setFill(Color.GREEN);
            } else if (goalPercentRounded == 140) {
                janPoint.setCenterY(610.0);
                janFeb.setStartY(610);
                janAmount.setY(625);
                janAmount.setFill(Color.BLACK);
                janPoint.setStroke(Color.GREEN);
                janPoint.setFill(Color.GREEN);
            } else if (goalPercentRounded == 150) {
                janPoint.setCenterY(595.0);
                janFeb.setStartY(595);
                janAmount.setY(610);
                janAmount.setFill(Color.BLACK);
                janPoint.setStroke(Color.GREEN);
                janPoint.setFill(Color.GREEN);
            } else if (goalPercentRounded == 160) {
                janPoint.setCenterY(580.0);
                janFeb.setStartY(580);
                janAmount.setY(595);
                janAmount.setFill(Color.BLACK);
                janPoint.setStroke(Color.GREEN);
                janPoint.setFill(Color.GREEN);
            } else if (goalPercentRounded == 170) {
                janPoint.setCenterY(565.0);
                janFeb.setStartY(565);
                janAmount.setY(580);
                janAmount.setFill(Color.BLACK);
                janPoint.setStroke(Color.GREEN);
                janPoint.setFill(Color.GREEN);
            } else if (goalPercentRounded == 180) {
                janPoint.setCenterY(550.0);
                janFeb.setStartY(550);
                janAmount.setY(565);
                janAmount.setFill(Color.BLACK);
                janPoint.setStroke(Color.GREEN);
                janPoint.setFill(Color.GREEN);
            } else if (goalPercentRounded == 190) {
                janPoint.setCenterY(535.0);
                janFeb.setStartY(535);
                janAmount.setY(550);
                janAmount.setFill(Color.BLACK);
                janPoint.setStroke(Color.GREEN);
                janPoint.setFill(Color.GREEN);
            } else {
                janPoint.setCenterY(520.0);
                janFeb.setStartY(520);
                janAmount.setY(535);
                janAmount.setFill(Color.BLACK);
                janPoint.setStroke(Color.GREEN);
                janPoint.setFill(Color.GREEN);
            }
        } else if (dateMonthInt == 2) {
            if (janAmount.getFill() != null) {
                monthlyTotal += monthlyInc;
                goalPercent = (monthlyTotal / goal) * 100;
                goalPercentRounded = Math.round(goalPercent / 10.0) * 10;
            }
            febAmount.setText("$" + monthlyTotal + ", " + String.valueOf(goalPercentRounded) + "%");

            if (goalPercentRounded <= 0) {
                febPoint.setCenterY(820.0);
                janFeb.setEndY(820);
                febMar.setStartY(820);
                febAmount.setY(835);
                febAmount.setFill(Color.BLACK);
                febPoint.setStroke(Color.RED);
                febPoint.setFill(Color.RED);
            } else if (goalPercentRounded == 10) {
                febPoint.setCenterY(805.0);
                janFeb.setEndY(805);
                febMar.setStartY(805);
                febAmount.setY(820);
                febAmount.setFill(Color.BLACK);
                febPoint.setStroke(Color.RED);
                febPoint.setFill(Color.RED);
            } else if (goalPercentRounded == 20) {
                febPoint.setCenterY(790.0);
                janFeb.setEndY(790);
                febMar.setStartY(790);
                febAmount.setY(805);
                febAmount.setFill(Color.BLACK);
                febPoint.setStroke(Color.RED);
                febPoint.setFill(Color.RED);
            } else if (goalPercentRounded == 30) {
                febPoint.setCenterY(775.0);
                janFeb.setEndY(775);
                febMar.setStartY(775);
                febAmount.setY(790);
                febAmount.setFill(Color.BLACK);
                febPoint.setStroke(Color.RED);
                febPoint.setFill(Color.RED);
            } else if (goalPercentRounded == 40) {
                febPoint.setCenterY(760.0);
                janFeb.setEndY(760);
                febMar.setStartY(760);
                febAmount.setY(775);
                febAmount.setFill(Color.BLACK);
                febPoint.setStroke(Color.RED);
                febPoint.setFill(Color.RED);
            } else if (goalPercentRounded == 50) {
                febPoint.setCenterY(745.0);
                janFeb.setEndY(745);
                febMar.setStartY(745);
                febAmount.setY(760);
                febAmount.setFill(Color.BLACK);
                febPoint.setStroke(Color.RED);
                febPoint.setFill(Color.RED);
            } else if (goalPercentRounded == 60) {
                febPoint.setCenterY(730.0);
                janFeb.setEndY(730);
                febMar.setStartY(730);
                febAmount.setY(745);
                febAmount.setFill(Color.BLACK);
                febPoint.setStroke(Color.RED);
                febPoint.setFill(Color.RED);
            } else if (goalPercentRounded == 70) {
                febPoint.setCenterY(715.0);
                janFeb.setEndY(715);
                febMar.setStartY(715);
                febAmount.setY(730);
                febAmount.setFill(Color.BLACK);
                febPoint.setStroke(Color.RED);
                febPoint.setFill(Color.RED);
            } else if (goalPercentRounded == 80) {
                febPoint.setCenterY(700.0);
                janFeb.setEndY(700);
                febMar.setStartY(700);
                febAmount.setY(715);
                febAmount.setFill(Color.BLACK);
                febPoint.setStroke(Color.RED);
                febPoint.setFill(Color.RED);
            } else if (goalPercentRounded == 90) {
                febPoint.setCenterY(685.0);
                janFeb.setEndY(685);
                febMar.setStartY(685);
                febAmount.setY(700);
                febAmount.setFill(Color.BLACK);
                febPoint.setStroke(Color.RED);
                febPoint.setFill(Color.RED);
            } else if (goalPercentRounded == 100) {
                febPoint.setCenterY(670.0);
                janFeb.setEndY(670);
                febMar.setStartY(670);
                febAmount.setY(685);
                febAmount.setFill(Color.BLACK);
                febPoint.setStroke(Color.GREEN);
                febPoint.setFill(Color.GREEN);
            } else if (goalPercentRounded == 110) {
                febPoint.setCenterY(655.0);
                janFeb.setEndY(655);
                febMar.setStartY(655);
                febAmount.setY(670);
                febAmount.setFill(Color.BLACK);
                febPoint.setStroke(Color.GREEN);
                febPoint.setFill(Color.GREEN);
            } else if (goalPercentRounded == 120) {
                febPoint.setCenterY(640.0);
                janFeb.setEndY(640);
                febMar.setStartY(640);
                febAmount.setY(655);
                febAmount.setFill(Color.BLACK);
                febPoint.setStroke(Color.GREEN);
                febPoint.setFill(Color.GREEN);
            } else if (goalPercentRounded == 130) {
                febPoint.setCenterY(625.0);
                janFeb.setEndY(625);
                febMar.setStartY(625);
                febAmount.setY(640);
                febAmount.setFill(Color.BLACK);
                febPoint.setStroke(Color.GREEN);
                febPoint.setFill(Color.GREEN);
            } else if (goalPercentRounded == 140) {
                febPoint.setCenterY(610.0);
                janFeb.setEndY(610);
                febMar.setStartY(610);
                febAmount.setY(625);
                febAmount.setFill(Color.BLACK);
                febPoint.setStroke(Color.GREEN);
                febPoint.setFill(Color.GREEN);
            } else if (goalPercentRounded == 150) {
                febPoint.setCenterY(595.0);
                janFeb.setEndY(595);
                febMar.setStartY(595);
                febAmount.setY(610);
                febAmount.setFill(Color.BLACK);
                febPoint.setStroke(Color.GREEN);
                febPoint.setFill(Color.GREEN);
            } else if (goalPercentRounded == 160) {
                febPoint.setCenterY(580.0);
                janFeb.setEndY(580);
                febMar.setStartY(580);
                febAmount.setY(595);
                febAmount.setFill(Color.BLACK);
                febPoint.setStroke(Color.GREEN);
                febPoint.setFill(Color.GREEN);
            } else if (goalPercentRounded == 170) {
                febPoint.setCenterY(565.0);
                janFeb.setEndY(565);
                febMar.setStartY(565);
                febAmount.setY(580);
                febAmount.setFill(Color.BLACK);
                febPoint.setStroke(Color.GREEN);
                febPoint.setFill(Color.GREEN);
            } else if (goalPercentRounded == 180) {
                febPoint.setCenterY(550.0);
                janFeb.setEndY(550);
                febMar.setStartY(550);
                febAmount.setY(565);
                febAmount.setFill(Color.BLACK);
                febPoint.setStroke(Color.GREEN);
                febPoint.setFill(Color.GREEN);
            } else if (goalPercentRounded == 190) {
                febPoint.setCenterY(535.0);
                janFeb.setEndY(535);
                febMar.setStartY(535);
                febAmount.setY(550);
                febAmount.setFill(Color.BLACK);
                febPoint.setStroke(Color.GREEN);
                febPoint.setFill(Color.GREEN);
            } else {
                febPoint.setCenterY(520.0);
                janFeb.setEndY(520);
                febMar.setStartY(520);
                febAmount.setY(535);
                febAmount.setFill(Color.BLACK);
                febPoint.setStroke(Color.GREEN);
                febPoint.setFill(Color.GREEN);
            }
        } else if (dateMonthInt == 3) {
            if (febAmount.getFill() != null) {
                monthlyTotal += monthlyInc;
                goalPercent = (monthlyTotal / goal) * 100;
                goalPercentRounded = Math.round(goalPercent / 10.0) * 10;
            }
            if (janAmount.getFill() != null && febAmount.getFill() != null) {
                monthlyTotal += monthlyInc;
                goalPercent = (monthlyTotal / goal) * 100;
                goalPercentRounded = Math.round(goalPercent / 10.0) * 10;
            }
            marAmount.setText("$" + monthlyTotal + ", " + String.valueOf(goalPercentRounded) + "%");

            if (goalPercentRounded <= 0) {
                marPoint.setCenterY(820.0);
                febMar.setEndY(820);
                marApr.setStartY(820);
                marAmount.setY(835);
                marAmount.setFill(Color.BLACK);
                marPoint.setStroke(Color.RED);
                marPoint.setFill(Color.RED);
            } else if (goalPercentRounded == 10) {
                marPoint.setCenterY(805.0);
                febMar.setEndY(805);
                marApr.setStartY(805);
                marAmount.setY(820);
                marAmount.setFill(Color.BLACK);
                marPoint.setStroke(Color.RED);
                marPoint.setFill(Color.RED);
            } else if (goalPercentRounded == 20) {
                marPoint.setCenterY(790.0);
                febMar.setEndY(790);
                marApr.setStartY(790);
                marAmount.setY(805);
                marAmount.setFill(Color.BLACK);
                marPoint.setStroke(Color.RED);
                marPoint.setFill(Color.RED);
            } else if (goalPercentRounded == 30) {
                marPoint.setCenterY(775.0);
                febMar.setEndY(775);
                marApr.setStartY(775);
                marAmount.setY(790);
                marAmount.setFill(Color.BLACK);
                marPoint.setStroke(Color.RED);
                marPoint.setFill(Color.RED);
            } else if (goalPercentRounded == 40) {
                marPoint.setCenterY(760.0);
                febMar.setEndY(760);
                marApr.setStartY(760);
                marAmount.setY(775);
                marAmount.setFill(Color.BLACK);
                marPoint.setStroke(Color.RED);
                marPoint.setFill(Color.RED);
            } else if (goalPercentRounded == 50) {
                marPoint.setCenterY(745.0);
                febMar.setEndY(745);
                marApr.setStartY(745);
                marAmount.setY(760);
                marAmount.setFill(Color.BLACK);
                marPoint.setStroke(Color.RED);
                marPoint.setFill(Color.RED);
            } else if (goalPercentRounded == 60) {
                marPoint.setCenterY(730.0);
                febMar.setEndY(730);
                marApr.setStartY(730);
                marAmount.setY(745);
                marAmount.setFill(Color.BLACK);
                marPoint.setStroke(Color.RED);
                marPoint.setFill(Color.RED);
            } else if (goalPercentRounded == 70) {
                marPoint.setCenterY(715.0);
                febMar.setEndY(715);
                marApr.setStartY(715);
                marAmount.setY(730);
                marAmount.setFill(Color.BLACK);
                marPoint.setStroke(Color.RED);
                marPoint.setFill(Color.RED);
            } else if (goalPercentRounded == 80) {
                marPoint.setCenterY(700.0);
                febMar.setEndY(700);
                marApr.setStartY(700);
                marAmount.setY(715);
                marAmount.setFill(Color.BLACK);
                marPoint.setStroke(Color.RED);
                marPoint.setFill(Color.RED);
            } else if (goalPercentRounded == 90) {
                marPoint.setCenterY(685.0);
                febMar.setEndY(685);
                marApr.setStartY(685);
                marAmount.setY(700);
                marAmount.setFill(Color.BLACK);
                marPoint.setStroke(Color.RED);
                marPoint.setFill(Color.RED);
            } else if (goalPercentRounded == 100) {
                marPoint.setCenterY(670.0);
                febMar.setEndY(670);
                marApr.setStartY(670);
                marAmount.setY(685);
                marAmount.setFill(Color.BLACK);
                marPoint.setStroke(Color.GREEN);
                marPoint.setFill(Color.GREEN);
            } else if (goalPercentRounded == 110) {
                marPoint.setCenterY(655.0);
                febMar.setEndY(655);
                marApr.setStartY(655);
                marAmount.setY(670);
                marAmount.setFill(Color.BLACK);
                marPoint.setStroke(Color.GREEN);
                marPoint.setFill(Color.GREEN);
            } else if (goalPercentRounded == 120) {
                marPoint.setCenterY(640.0);
                febMar.setEndY(640);
                marApr.setStartY(640);
                marAmount.setY(655);
                marAmount.setFill(Color.BLACK);
                marPoint.setStroke(Color.GREEN);
                marPoint.setFill(Color.GREEN);
            } else if (goalPercentRounded == 130) {
                marPoint.setCenterY(625.0);
                febMar.setEndY(625);
                marApr.setStartY(625);
                marAmount.setY(640);
                marAmount.setFill(Color.BLACK);
                marPoint.setStroke(Color.GREEN);
                marPoint.setFill(Color.GREEN);
            } else if (goalPercentRounded == 140) {
                marPoint.setCenterY(610.0);
                febMar.setEndY(610);
                marApr.setStartY(610);
                marAmount.setY(625);
                marAmount.setFill(Color.BLACK);
                marPoint.setStroke(Color.GREEN);
                marPoint.setFill(Color.GREEN);
            } else if (goalPercentRounded == 150) {
                marPoint.setCenterY(595.0);
                febMar.setEndY(595);
                marApr.setStartY(595);
                marAmount.setY(610);
                marAmount.setFill(Color.BLACK);
                marPoint.setStroke(Color.GREEN);
                marPoint.setFill(Color.GREEN);
            } else if (goalPercentRounded == 160) {
                marPoint.setCenterY(580.0);
                febMar.setEndY(580);
                marApr.setStartY(580);
                marAmount.setY(595);
                marAmount.setFill(Color.BLACK);
                marPoint.setStroke(Color.GREEN);
                marPoint.setFill(Color.GREEN);
            } else if (goalPercentRounded == 170) {
                marPoint.setCenterY(565.0);
                febMar.setEndY(565);
                marApr.setStartY(565);
                marAmount.setY(580);
                marAmount.setFill(Color.BLACK);
                marPoint.setStroke(Color.GREEN);
                marPoint.setFill(Color.GREEN);
            } else if (goalPercentRounded == 180) {
                marPoint.setCenterY(550.0);
                febMar.setEndY(550);
                marApr.setStartY(550);
                marAmount.setY(565);
                marAmount.setFill(Color.BLACK);
                marPoint.setStroke(Color.GREEN);
                marPoint.setFill(Color.GREEN);
            } else if (goalPercentRounded == 190) {
                marPoint.setCenterY(535.0);
                febMar.setEndY(535);
                marApr.setStartY(535);
                marAmount.setY(550);
                marAmount.setFill(Color.BLACK);
                marPoint.setStroke(Color.GREEN);
                marPoint.setFill(Color.GREEN);
            } else {
                marPoint.setCenterY(520.0);
                febMar.setEndY(520);
                marApr.setStartY(520);
                marAmount.setY(535);
                marAmount.setFill(Color.BLACK);
                marPoint.setStroke(Color.GREEN);
                marPoint.setFill(Color.GREEN);
            }
        } else if (dateMonthInt == 4) {
            if (marAmount.getFill() != null) {
                monthlyTotal += monthlyInc;
                goalPercent = (monthlyTotal / goal) * 100;
                goalPercentRounded = Math.round(goalPercent / 10.0) * 10;
            }
            if (febAmount.getFill() != null && marAmount.getFill() != null) {
                monthlyTotal += monthlyInc;
                goalPercent = (monthlyTotal / goal) * 100;
                goalPercentRounded = Math.round(goalPercent / 10.0) * 10;
            }

            if (janAmount.getFill() != null && febAmount.getFill() != null && marAmount.getFill() != null) {
                monthlyTotal += monthlyInc;
                goalPercent = (monthlyTotal / goal) * 100;
                goalPercentRounded = Math.round(goalPercent / 10.0) * 10;
            }
            aprAmount.setText("$" + monthlyTotal + ", " + String.valueOf(goalPercentRounded) + "%");

            if (goalPercentRounded <= 0) {
                aprPoint.setCenterY(820.0);
                marApr.setEndY(820);
                aprMay.setStartY(820);
                aprAmount.setY(835);
                aprAmount.setFill(Color.BLACK);
                aprPoint.setStroke(Color.RED);
                aprPoint.setFill(Color.RED);
            } else if (goalPercentRounded == 10) {
                aprPoint.setCenterY(805.0);
                marApr.setEndY(805);
                aprMay.setStartY(805);
                aprAmount.setY(820);
                aprAmount.setFill(Color.BLACK);
                aprPoint.setStroke(Color.RED);
                aprPoint.setFill(Color.RED);
            } else if (goalPercentRounded == 20) {
                aprPoint.setCenterY(790.0);
                marApr.setEndY(790);
                aprMay.setStartY(790);
                aprAmount.setY(805);
                aprAmount.setFill(Color.BLACK);
                aprPoint.setStroke(Color.RED);
                aprPoint.setFill(Color.RED);
            } else if (goalPercentRounded == 30) {
                aprPoint.setCenterY(775.0);
                marApr.setEndY(775);
                aprMay.setStartY(775);
                aprAmount.setY(790);
                aprAmount.setFill(Color.BLACK);
                aprPoint.setStroke(Color.RED);
                aprPoint.setFill(Color.RED);
            } else if (goalPercentRounded == 40) {
                aprPoint.setCenterY(760.0);
                marApr.setEndY(760);
                aprMay.setStartY(760);
                aprAmount.setY(775);
                aprAmount.setFill(Color.BLACK);
                aprPoint.setStroke(Color.RED);
                aprPoint.setFill(Color.RED);
            } else if (goalPercentRounded == 50) {
                aprPoint.setCenterY(745.0);
                marApr.setEndY(745);
                aprMay.setStartY(745);
                aprAmount.setY(760);
                aprAmount.setFill(Color.BLACK);
                aprPoint.setStroke(Color.RED);
                aprPoint.setFill(Color.RED);
            } else if (goalPercentRounded == 60) {
                aprPoint.setCenterY(730.0);
                marApr.setEndY(730);
                aprMay.setStartY(730);
                aprAmount.setY(745);
                aprAmount.setFill(Color.BLACK);
                aprPoint.setStroke(Color.RED);
                aprPoint.setFill(Color.RED);
            } else if (goalPercentRounded == 70) {
                aprPoint.setCenterY(715.0);
                marApr.setEndY(715);
                aprMay.setStartY(715);
                aprAmount.setY(730);
                aprAmount.setFill(Color.BLACK);
                aprPoint.setStroke(Color.RED);
                aprPoint.setFill(Color.RED);
            } else if (goalPercentRounded == 80) {
                aprPoint.setCenterY(700.0);
                marApr.setEndY(700);
                aprMay.setStartY(700);
                aprAmount.setY(715);
                aprAmount.setFill(Color.BLACK);
                aprPoint.setStroke(Color.RED);
                aprPoint.setFill(Color.RED);
            } else if (goalPercentRounded == 90) {
                aprPoint.setCenterY(685.0);
                marApr.setEndY(685);
                aprMay.setStartY(685);
                aprAmount.setY(700);
                aprAmount.setFill(Color.BLACK);
                aprPoint.setStroke(Color.RED);
                aprPoint.setFill(Color.RED);
            } else if (goalPercentRounded == 100) {
                aprPoint.setCenterY(670.0);
                marApr.setEndY(670);
                aprMay.setStartY(670);
                aprAmount.setY(685);
                aprAmount.setFill(Color.BLACK);
                aprPoint.setStroke(Color.GREEN);
                aprPoint.setFill(Color.GREEN);
            } else if (goalPercentRounded == 110) {
                aprPoint.setCenterY(655.0);
                marApr.setEndY(655);
                aprMay.setStartY(655);
                aprAmount.setY(670);
                aprAmount.setFill(Color.BLACK);
                aprPoint.setStroke(Color.GREEN);
                aprPoint.setFill(Color.GREEN);
            } else if (goalPercentRounded == 120) {
                aprPoint.setCenterY(640.0);
                marApr.setEndY(640);
                aprMay.setStartY(640);
                aprAmount.setY(655);
                aprAmount.setFill(Color.BLACK);
                aprPoint.setStroke(Color.GREEN);
                aprPoint.setFill(Color.GREEN);
            } else if (goalPercentRounded == 130) {
                aprPoint.setCenterY(625.0);
                marApr.setEndY(625);
                aprMay.setStartY(625);
                aprAmount.setY(640);
                aprAmount.setFill(Color.BLACK);
                aprPoint.setStroke(Color.GREEN);
                aprPoint.setFill(Color.GREEN);
            } else if (goalPercentRounded == 140) {
                aprPoint.setCenterY(610.0);
                marApr.setEndY(610);
                aprMay.setStartY(610);
                aprAmount.setY(625);
                aprAmount.setFill(Color.BLACK);
                aprPoint.setStroke(Color.GREEN);
                aprPoint.setFill(Color.GREEN);
            } else if (goalPercentRounded == 150) {
                aprPoint.setCenterY(595.0);
                marApr.setEndY(595);
                aprMay.setStartY(595);
                aprAmount.setY(610);
                aprAmount.setFill(Color.BLACK);
                aprPoint.setStroke(Color.GREEN);
                aprPoint.setFill(Color.GREEN);
            } else if (goalPercentRounded == 160) {
                aprPoint.setCenterY(580.0);
                marApr.setEndY(580);
                aprMay.setStartY(580);
                aprAmount.setY(595);
                aprAmount.setFill(Color.BLACK);
                aprPoint.setStroke(Color.GREEN);
                aprPoint.setFill(Color.GREEN);
            } else if (goalPercentRounded == 170) {
                aprPoint.setCenterY(565.0);
                marApr.setEndY(565);
                aprMay.setStartY(565);
                aprAmount.setY(580);
                aprAmount.setFill(Color.BLACK);
                aprPoint.setStroke(Color.GREEN);
                aprPoint.setFill(Color.GREEN);
            } else if (goalPercentRounded == 180) {
                aprPoint.setCenterY(550.0);
                marApr.setEndY(550);
                aprMay.setStartY(550);
                aprAmount.setY(565);
                aprAmount.setFill(Color.BLACK);
                aprPoint.setStroke(Color.GREEN);
                aprPoint.setFill(Color.GREEN);
            } else if (goalPercentRounded == 190) {
                aprPoint.setCenterY(535.0);
                marApr.setEndY(535);
                aprMay.setStartY(535);
                aprAmount.setY(550);
                aprAmount.setFill(Color.BLACK);
                aprPoint.setStroke(Color.GREEN);
                aprPoint.setFill(Color.GREEN);
            } else {
                aprPoint.setCenterY(520.0);
                marApr.setEndY(520);
                aprMay.setStartY(520);
                aprAmount.setY(535);
                aprAmount.setFill(Color.BLACK);
                aprPoint.setStroke(Color.GREEN);
                aprPoint.setFill(Color.GREEN);
            }
        } else if (dateMonthInt == 5) {
            if (aprAmount.getFill() != null) {
                monthlyTotal += monthlyInc;
                goalPercent = (monthlyTotal / goal) * 100;
                goalPercentRounded = Math.round(goalPercent / 10.0) * 10;
            }
            if (marAmount.getFill() != null && aprAmount.getFill()!= null) {
                monthlyTotal += monthlyInc;
                goalPercent = (monthlyTotal / goal) * 100;
                goalPercentRounded = Math.round(goalPercent / 10.0) * 10;
            }
            if (febAmount.getFill() != null && marAmount.getFill() != null && aprAmount.getFill() != null) {
                monthlyTotal += monthlyInc;
                goalPercent = (monthlyTotal / goal) * 100;
                goalPercentRounded = Math.round(goalPercent / 10.0) * 10;
            }
            if (janAmount.getFill() != null && febAmount.getFill() != null && marAmount.getFill() != null && aprAmount.getFill() != null) {
                monthlyTotal += monthlyInc;
                goalPercent = (monthlyTotal / goal) * 100;
                goalPercentRounded = Math.round(goalPercent / 10.0) * 10;
            }
            mayAmount.setText("$" + monthlyTotal + ", " + String.valueOf(goalPercentRounded) + "%");

            if (goalPercentRounded <= 0) {
                mayPoint.setCenterY(820.0);
                aprMay.setEndY(820);
                mayJun.setStartY(820);
                mayAmount.setY(835);
                mayAmount.setFill(Color.BLACK);
                mayPoint.setStroke(Color.RED);
                mayPoint.setFill(Color.RED);
            } else if (goalPercentRounded == 10) {
                mayPoint.setCenterY(805.0);
                aprMay.setEndY(805);
                mayJun.setStartY(805);
                mayAmount.setY(820);
                mayAmount.setFill(Color.BLACK);
                mayPoint.setStroke(Color.RED);
                mayPoint.setFill(Color.RED);
            } else if (goalPercentRounded == 20) {
                mayPoint.setCenterY(790.0);
                aprMay.setEndY(790);
                mayJun.setStartY(790);
                mayAmount.setY(805);
                mayAmount.setFill(Color.BLACK);
                mayPoint.setStroke(Color.RED);
                mayPoint.setFill(Color.RED);
            } else if (goalPercentRounded == 30) {
                mayPoint.setCenterY(775.0);
                aprMay.setEndY(775);
                mayJun.setStartY(775);
                mayAmount.setY(790);
                mayAmount.setFill(Color.BLACK);
                mayPoint.setStroke(Color.RED);
                mayPoint.setFill(Color.RED);
            } else if (goalPercentRounded == 40) {
                mayPoint.setCenterY(760.0);
                aprMay.setEndY(760);
                mayJun.setStartY(760);
                mayAmount.setY(775);
                mayAmount.setFill(Color.BLACK);
                mayPoint.setStroke(Color.RED);
                mayPoint.setFill(Color.RED);
            } else if (goalPercentRounded == 50) {
                mayPoint.setCenterY(745.0);
                aprMay.setEndY(745);
                mayJun.setStartY(745);
                mayAmount.setY(760);
                mayAmount.setFill(Color.BLACK);
                mayPoint.setStroke(Color.RED);
                mayPoint.setFill(Color.RED);
            } else if (goalPercentRounded == 60) {
                mayPoint.setCenterY(730.0);
                aprMay.setEndY(730);
                mayJun.setStartY(730);
                mayAmount.setY(745);
                mayAmount.setFill(Color.BLACK);
                mayPoint.setStroke(Color.RED);
                mayPoint.setFill(Color.RED);
            } else if (goalPercentRounded == 70) {
                mayPoint.setCenterY(715.0);
                aprMay.setEndY(715);
                mayJun.setStartY(715);
                mayAmount.setY(730);
                mayAmount.setFill(Color.BLACK);
                mayPoint.setStroke(Color.RED);
                mayPoint.setFill(Color.RED);
            } else if (goalPercentRounded == 80) {
                mayPoint.setCenterY(700.0);
                aprMay.setEndY(700);
                mayJun.setStartY(700);
                mayAmount.setY(715);
                mayAmount.setFill(Color.BLACK);
                mayPoint.setStroke(Color.RED);
                mayPoint.setFill(Color.RED);
            } else if (goalPercentRounded == 90) {
                mayPoint.setCenterY(685.0);
                aprMay.setEndY(685);
                mayJun.setStartY(685);
                mayAmount.setY(700);
                mayAmount.setFill(Color.BLACK);
                mayPoint.setStroke(Color.RED);
                mayPoint.setFill(Color.RED);
            } else if (goalPercentRounded == 100) {
                mayPoint.setCenterY(670.0);
                aprMay.setEndY(670);
                mayJun.setStartY(670);
                mayAmount.setY(685);
                mayAmount.setFill(Color.BLACK);
                mayPoint.setStroke(Color.GREEN);
                mayPoint.setFill(Color.GREEN);
            } else if (goalPercentRounded == 110) {
                mayPoint.setCenterY(655.0);
                aprMay.setEndY(655);
                mayJun.setStartY(655);
                mayAmount.setY(670);
                mayAmount.setFill(Color.BLACK);
                mayPoint.setStroke(Color.GREEN);
                mayPoint.setFill(Color.GREEN);
            } else if (goalPercentRounded == 120) {
                mayPoint.setCenterY(640.0);
                aprMay.setEndY(640);
                mayJun.setStartY(640);
                mayAmount.setY(655);
                mayAmount.setFill(Color.BLACK);
                mayPoint.setStroke(Color.GREEN);
                mayPoint.setFill(Color.GREEN);
            } else if (goalPercentRounded == 130) {
                mayPoint.setCenterY(625.0);
                aprMay.setEndY(625);
                mayJun.setStartY(625);
                mayAmount.setY(640);
                mayAmount.setFill(Color.BLACK);
                mayPoint.setStroke(Color.GREEN);
                mayPoint.setFill(Color.GREEN);
            } else if (goalPercentRounded == 140) {
                mayPoint.setCenterY(610.0);
                aprMay.setEndY(610);
                mayJun.setStartY(610);
                mayAmount.setY(625);
                mayAmount.setFill(Color.BLACK);
                mayPoint.setStroke(Color.GREEN);
                mayPoint.setFill(Color.GREEN);
            } else if (goalPercentRounded == 150) {
                mayPoint.setCenterY(595.0);
                aprMay.setEndY(595);
                mayJun.setStartY(595);
                mayAmount.setY(610);
                mayAmount.setFill(Color.BLACK);
                mayPoint.setStroke(Color.GREEN);
                mayPoint.setFill(Color.GREEN);
            } else if (goalPercentRounded == 160) {
                mayPoint.setCenterY(580.0);
                aprMay.setEndY(580);
                mayJun.setStartY(580);
                mayAmount.setY(595);
                mayAmount.setFill(Color.BLACK);
                mayPoint.setStroke(Color.GREEN);
                mayPoint.setFill(Color.GREEN);
            } else if (goalPercentRounded == 170) {
                mayPoint.setCenterY(565.0);
                aprMay.setEndY(565);
                mayJun.setStartY(565);
                mayAmount.setY(580);
                mayAmount.setFill(Color.BLACK);
                mayPoint.setStroke(Color.GREEN);
                mayPoint.setFill(Color.GREEN);
            } else if (goalPercentRounded == 180) {
                mayPoint.setCenterY(550.0);
                aprMay.setEndY(550);
                mayJun.setStartY(550);
                mayAmount.setY(565);
                mayAmount.setFill(Color.BLACK);
                mayPoint.setStroke(Color.GREEN);
                mayPoint.setFill(Color.GREEN);
            } else if (goalPercentRounded == 190) {
                mayPoint.setCenterY(535.0);
                aprMay.setEndY(535);
                mayJun.setStartY(535);
                mayAmount.setY(550);
                mayAmount.setFill(Color.BLACK);
                mayPoint.setStroke(Color.GREEN);
                mayPoint.setFill(Color.GREEN);
            } else {
                mayPoint.setCenterY(520.0);
                aprMay.setEndY(520);
                mayJun.setStartY(520);
                mayAmount.setY(535);
                mayAmount.setFill(Color.BLACK);
                mayPoint.setStroke(Color.GREEN);
                mayPoint.setFill(Color.GREEN);
            }
        } else if (dateMonthInt == 6) {
            if (mayAmount.getFill() != null) {
                monthlyTotal += monthlyInc;
                goalPercent = (monthlyTotal / goal) * 100;
                goalPercentRounded = Math.round(goalPercent / 10.0) * 10;
            }
            if (aprAmount.getFill() != null && mayAmount.getFill()!= null) {
                monthlyTotal += monthlyInc;
                goalPercent = (monthlyTotal / goal) * 100;
                goalPercentRounded = Math.round(goalPercent / 10.0) * 10;
            }
            if (marAmount.getFill() != null && aprAmount.getFill() != null && mayAmount.getFill() != null) {
                monthlyTotal += monthlyInc;
                goalPercent = (monthlyTotal / goal) * 100;
                goalPercentRounded = Math.round(goalPercent / 10.0) * 10;
            }
            if (febAmount.getFill() != null && marAmount.getFill() != null && aprAmount.getFill() != null && mayAmount.getFill() != null) {
                monthlyTotal += monthlyInc;
                goalPercent = (monthlyTotal / goal) * 100;
                goalPercentRounded = Math.round(goalPercent / 10.0) * 10;
            }
            if (janAmount.getFill()!= null && febAmount.getFill() != null && marAmount.getFill() != null && aprAmount.getFill() != null && mayAmount.getFill() != null) {
                monthlyTotal += monthlyInc;
                goalPercent = (monthlyTotal / goal) * 100;
                goalPercentRounded = Math.round(goalPercent / 10.0) * 10;
            }
            junAmount.setText("$" + monthlyTotal + ", " + String.valueOf(goalPercentRounded) + "%");

            if (goalPercentRounded <= 0) {
                junPoint.setCenterY(820.0);
                mayJun.setEndY(820);
                junJul.setStartY(820);
                junAmount.setY(835);
                junAmount.setFill(Color.BLACK);
                junPoint.setStroke(Color.RED);
                junPoint.setFill(Color.RED);
            } else if (goalPercentRounded == 10) {
                junPoint.setCenterY(805.0);
                mayJun.setEndY(805);
                junJul.setStartY(805);
                junAmount.setY(820);
                junAmount.setFill(Color.BLACK);
                junPoint.setStroke(Color.RED);
                junPoint.setFill(Color.RED);
            } else if (goalPercentRounded == 20) {
                junPoint.setCenterY(790.0);
                mayJun.setEndY(790);
                junJul.setStartY(790);
                junAmount.setY(805);
                junAmount.setFill(Color.BLACK);
                junPoint.setStroke(Color.RED);
                junPoint.setFill(Color.RED);
            } else if (goalPercentRounded == 30) {
                junPoint.setCenterY(775.0);
                mayJun.setEndY(775);
                junJul.setStartY(775);
                junAmount.setY(790);
                junAmount.setFill(Color.BLACK);
                junPoint.setStroke(Color.RED);
                junPoint.setFill(Color.RED);
            } else if (goalPercentRounded == 40) {
                junPoint.setCenterY(760.0);
                mayJun.setEndY(760);
                junJul.setStartY(760);
                junAmount.setY(775);
                junAmount.setFill(Color.BLACK);
                junPoint.setStroke(Color.RED);
                junPoint.setFill(Color.RED);
            } else if (goalPercentRounded == 50) {
                junPoint.setCenterY(745.0);
                mayJun.setEndY(745);
                junJul.setStartY(745);
                junAmount.setY(760);
                junAmount.setFill(Color.BLACK);
                junPoint.setStroke(Color.RED);
                junPoint.setFill(Color.RED);
            } else if (goalPercentRounded == 60) {
                junPoint.setCenterY(730.0);
                mayJun.setEndY(730);
                junJul.setStartY(730);
                junAmount.setY(745);
                junAmount.setFill(Color.BLACK);
                junPoint.setStroke(Color.RED);
                junPoint.setFill(Color.RED);
            } else if (goalPercentRounded == 70) {
                junPoint.setCenterY(715.0);
                mayJun.setEndY(715);
                junJul.setStartY(715);
                junAmount.setY(730);
                junAmount.setFill(Color.BLACK);
                junPoint.setStroke(Color.RED);
                junPoint.setFill(Color.RED);
            } else if (goalPercentRounded == 80) {
                junPoint.setCenterY(700.0);
                mayJun.setEndY(700);
                junJul.setStartY(700);
                junAmount.setY(715);
                junAmount.setFill(Color.BLACK);
                junPoint.setStroke(Color.RED);
                junPoint.setFill(Color.RED);
            } else if (goalPercentRounded == 90) {
                junPoint.setCenterY(685.0);
                mayJun.setEndY(685);
                junJul.setStartY(685);
                junAmount.setY(700);
                junAmount.setFill(Color.BLACK);
                junPoint.setStroke(Color.RED);
                junPoint.setFill(Color.RED);
            } else if (goalPercentRounded == 100) {
                junPoint.setCenterY(670.0);
                mayJun.setEndY(670);
                junJul.setStartY(670);
                junAmount.setY(685);
                junAmount.setFill(Color.BLACK);
                junPoint.setStroke(Color.GREEN);
                junPoint.setFill(Color.GREEN);
            } else if (goalPercentRounded == 110) {
                junPoint.setCenterY(655.0);
                mayJun.setEndY(655);
                junJul.setStartY(655);
                junAmount.setY(670);
                junAmount.setFill(Color.BLACK);
                junPoint.setStroke(Color.GREEN);
                junPoint.setFill(Color.GREEN);
            } else if (goalPercentRounded == 120) {
                junPoint.setCenterY(640.0);
                mayJun.setEndY(640);
                junJul.setStartY(640);
                junAmount.setY(655);
                junAmount.setFill(Color.BLACK);
                junPoint.setStroke(Color.GREEN);
                junPoint.setFill(Color.GREEN);
            } else if (goalPercentRounded == 130) {
                junPoint.setCenterY(625.0);
                mayJun.setEndY(625);
                junJul.setStartY(625);
                junAmount.setY(640);
                junAmount.setFill(Color.BLACK);
                junPoint.setStroke(Color.GREEN);
                junPoint.setFill(Color.GREEN);
            } else if (goalPercentRounded == 140) {
                junPoint.setCenterY(610.0);
                mayJun.setEndY(610);
                junJul.setStartY(610);
                junAmount.setY(625);
                junAmount.setFill(Color.BLACK);
                junPoint.setStroke(Color.GREEN);
                junPoint.setFill(Color.GREEN);
            } else if (goalPercentRounded == 150) {
                junPoint.setCenterY(595.0);
                mayJun.setEndY(595);
                junJul.setStartY(595);
                junAmount.setY(610);
                junAmount.setFill(Color.BLACK);
                junPoint.setStroke(Color.GREEN);
                junPoint.setFill(Color.GREEN);
            } else if (goalPercentRounded == 160) {
                junPoint.setCenterY(580.0);
                mayJun.setEndY(580);
                junJul.setStartY(580);
                junAmount.setY(595);
                junAmount.setFill(Color.BLACK);
                junPoint.setStroke(Color.GREEN);
                junPoint.setFill(Color.GREEN);
            } else if (goalPercentRounded == 170) {
                junPoint.setCenterY(565.0);
                mayJun.setEndY(565);
                junJul.setStartY(565);
                junAmount.setY(580);
                junAmount.setFill(Color.BLACK);
                junPoint.setStroke(Color.GREEN);
                junPoint.setFill(Color.GREEN);
            } else if (goalPercentRounded == 180) {
                junPoint.setCenterY(550.0);
                mayJun.setEndY(550);
                junJul.setStartY(550);
                junAmount.setY(565);
                junAmount.setFill(Color.BLACK);
                junPoint.setStroke(Color.GREEN);
                junPoint.setFill(Color.GREEN);
            } else if (goalPercentRounded == 190) {
                junPoint.setCenterY(520.0);
                mayJun.setEndY(520);
                junJul.setStartY(520);
                junAmount.setY(550);
                junAmount.setFill(Color.BLACK);
                junPoint.setStroke(Color.GREEN);
                junPoint.setFill(Color.GREEN);
            } else {
                junPoint.setCenterY(520.0);
                mayJun.setEndY(520);
                junJul.setStartY(520);
                junAmount.setY(535);
                junAmount.setFill(Color.BLACK);
                junPoint.setStroke(Color.GREEN);
                junPoint.setFill(Color.GREEN);
            }
        } else if (dateMonthInt == 7) {
            if (junAmount.getFill() != null) {
                monthlyTotal += monthlyInc;
                goalPercent = (monthlyTotal / goal) * 100;
                goalPercentRounded = Math.round(goalPercent / 10.0) * 10;
            }
            if (mayAmount.getFill() != null && junAmount.getFill()!= null) {
                monthlyTotal += monthlyInc;
                goalPercent = (monthlyTotal / goal) * 100;
                goalPercentRounded = Math.round(goalPercent / 10.0) * 10;
            }
            if (aprAmount.getFill() != null && mayAmount.getFill() != null && junAmount.getFill() != null) {
                monthlyTotal += monthlyInc;
                goalPercent = (monthlyTotal / goal) * 100;
                goalPercentRounded = Math.round(goalPercent / 10.0) * 10;
            }
            if (marAmount.getFill() != null && aprAmount.getFill() != null && mayAmount.getFill() != null && junAmount.getFill() != null) {
                monthlyTotal += monthlyInc;
                goalPercent = (monthlyTotal / goal) * 100;
                goalPercentRounded = Math.round(goalPercent / 10.0) * 10;
            }
            if (febAmount.getFill()!= null && marAmount.getFill() != null && aprAmount.getFill() != null && mayAmount.getFill() != null && junAmount.getFill() != null) {
                monthlyTotal += monthlyInc;
                goalPercent = (monthlyTotal / goal) * 100;
                goalPercentRounded = Math.round(goalPercent / 10.0) * 10;
            } if (janAmount.getFill()!= null && febAmount.getFill() != null && marAmount.getFill() != null && aprAmount.getFill() != null && mayAmount.getFill() != null && junAmount.getFill() != null) {
                monthlyTotal += monthlyInc;
                goalPercent = (monthlyTotal / goal) * 100;
                goalPercentRounded = Math.round(goalPercent / 10.0) * 10;
            }
            julAmount.setText("$" + monthlyTotal + ", " + String.valueOf(goalPercentRounded) + "%");

            if (goalPercentRounded <= 0) {
                julPoint.setCenterY(820.0);
                junJul.setEndY(820);
                julAug.setStartY(820);
                julAmount.setY(835);
                julAmount.setFill(Color.BLACK);
                julPoint.setStroke(Color.RED);
                julPoint.setFill(Color.RED);
            } else if (goalPercentRounded == 10) {
                julPoint.setCenterY(805.0);
                junJul.setEndY(805);
                julAug.setStartY(805);
                julAmount.setY(820);
                julAmount.setFill(Color.BLACK);
                julPoint.setStroke(Color.RED);
                julPoint.setFill(Color.RED);
            } else if (goalPercentRounded == 20) {
                julPoint.setCenterY(790.0);
                junJul.setEndY(790);
                julAug.setStartY(790);
                julAmount.setY(805);
                julAmount.setFill(Color.BLACK);
                julPoint.setStroke(Color.RED);
                julPoint.setFill(Color.RED);
            } else if (goalPercentRounded == 30) {
                julPoint.setCenterY(775.0);
                junJul.setEndY(775);
                julAug.setStartY(775);
                julAmount.setY(790);
                julAmount.setFill(Color.BLACK);
                julPoint.setStroke(Color.RED);
                julPoint.setFill(Color.RED);
            } else if (goalPercentRounded == 40) {
                julPoint.setCenterY(760.0);
                junJul.setEndY(760);
                julAug.setStartY(760);
                julAmount.setY(775);
                julAmount.setFill(Color.BLACK);
                julPoint.setStroke(Color.RED);
                julPoint.setFill(Color.RED);
            } else if (goalPercentRounded == 50) {
                julPoint.setCenterY(745.0);
                junJul.setEndY(745);
                julAug.setStartY(745);
                julAmount.setY(760);
                julAmount.setFill(Color.BLACK);
                julPoint.setStroke(Color.RED);
                julPoint.setFill(Color.RED);
            } else if (goalPercentRounded == 60) {
                julPoint.setCenterY(730.0);
                junJul.setEndY(730);
                julAug.setStartY(730);
                julAmount.setY(745);
                julAmount.setFill(Color.BLACK);
                julPoint.setStroke(Color.RED);
                julPoint.setFill(Color.RED);
            } else if (goalPercentRounded == 70) {
                julPoint.setCenterY(715.0);
                junJul.setEndY(715);
                julAug.setStartY(715);
                julAmount.setY(730);
                julAmount.setFill(Color.BLACK);
                julPoint.setStroke(Color.RED);
                julPoint.setFill(Color.RED);
            } else if (goalPercentRounded == 80) {
                julPoint.setCenterY(700.0);
                junJul.setEndY(700);
                julAug.setStartY(700);
                julAmount.setY(715);
                julAmount.setFill(Color.BLACK);
                julPoint.setStroke(Color.RED);
                julPoint.setFill(Color.RED);
            } else if (goalPercentRounded == 90) {
                julPoint.setCenterY(685.0);
                junJul.setEndY(685);
                julAug.setStartY(685);
                julAmount.setY(700);
                julAmount.setFill(Color.BLACK);
                julPoint.setStroke(Color.RED);
                julPoint.setFill(Color.RED);
            } else if (goalPercentRounded == 100) {
                julPoint.setCenterY(670.0);
                junJul.setEndY(670);
                julAug.setStartY(670);
                julAmount.setY(685);
                julAmount.setFill(Color.BLACK);
                julPoint.setStroke(Color.GREEN);
                julPoint.setFill(Color.GREEN);
            } else if (goalPercentRounded == 110) {
                julPoint.setCenterY(655.0);
                junJul.setEndY(655);
                julAug.setStartY(655);
                julAmount.setY(670);
                julAmount.setFill(Color.BLACK);
                julPoint.setStroke(Color.GREEN);
                julPoint.setFill(Color.GREEN);
            } else if (goalPercentRounded == 120) {
                julPoint.setCenterY(640.0);
                junJul.setEndY(640);
                julAug.setStartY(640);
                julAmount.setY(655);
                julAmount.setFill(Color.BLACK);
                julPoint.setStroke(Color.GREEN);
                julPoint.setFill(Color.GREEN);
            } else if (goalPercentRounded == 130) {
                julPoint.setCenterY(625.0);
                junJul.setEndY(625);
                julAug.setStartY(625);
                julAmount.setY(640);
                julAmount.setFill(Color.BLACK);
                julPoint.setStroke(Color.GREEN);
                julPoint.setFill(Color.GREEN);
            } else if (goalPercentRounded == 140) {
                julPoint.setCenterY(610.0);
                junJul.setEndY(610);
                julAug.setStartY(610);
                julAmount.setY(625);
                julAmount.setFill(Color.BLACK);
                julPoint.setStroke(Color.GREEN);
                julPoint.setFill(Color.GREEN);
            } else if (goalPercentRounded == 150) {
                julPoint.setCenterY(595.0);
                junJul.setEndY(595);
                julAug.setStartY(595);
                julAmount.setY(610);
                julAmount.setFill(Color.BLACK);
                julPoint.setStroke(Color.GREEN);
                julPoint.setFill(Color.GREEN);
            } else if (goalPercentRounded == 160) {
                julPoint.setCenterY(580.0);
                junJul.setEndY(580);
                julAug.setStartY(580);
                julAmount.setY(595);
                julAmount.setFill(Color.BLACK);
                julPoint.setStroke(Color.GREEN);
                julPoint.setFill(Color.GREEN);
            } else if (goalPercentRounded == 170) {
                julPoint.setCenterY(565.0);
                junJul.setEndY(565);
                julAug.setStartY(565);
                julAmount.setY(580);
                julAmount.setFill(Color.BLACK);
                julPoint.setStroke(Color.GREEN);
                julPoint.setFill(Color.GREEN);
            } else if (goalPercentRounded == 180) {
                julPoint.setCenterY(550.0);
                junJul.setEndY(550);
                julAug.setStartY(550);
                julAmount.setY(565);
                julAmount.setFill(Color.BLACK);
                julPoint.setStroke(Color.GREEN);
                julPoint.setFill(Color.GREEN);
            } else if (goalPercentRounded == 190) {
                julPoint.setCenterY(535.0);
                junJul.setEndY(535);
                julAug.setStartY(535);
                julAmount.setY(550);
                julAmount.setFill(Color.BLACK);
                julPoint.setStroke(Color.GREEN);
                julPoint.setFill(Color.GREEN);
            } else {
                julPoint.setCenterY(520.0);
                junJul.setEndY(520);
                julAug.setStartY(520);
                julAmount.setY(535);
                julAmount.setFill(Color.BLACK);
                julPoint.setStroke(Color.GREEN);
                julPoint.setFill(Color.GREEN);
            }
        } else if (dateMonthInt == 8) {
            if (julAmount.getFill() != null) {
                monthlyTotal += monthlyInc;
                goalPercent = (monthlyTotal / goal) * 100;
                goalPercentRounded = Math.round(goalPercent / 10.0) * 10;
            }
            if (junAmount.getFill() != null && julAmount.getFill()!= null) {
                monthlyTotal += monthlyInc;
                goalPercent = (monthlyTotal / goal) * 100;
                goalPercentRounded = Math.round(goalPercent / 10.0) * 10;
            }
            if (mayAmount.getFill() != null && junAmount.getFill() != null && julAmount.getFill() != null) {
                monthlyTotal += monthlyInc;
                goalPercent = (monthlyTotal / goal) * 100;
                goalPercentRounded = Math.round(goalPercent / 10.0) * 10;
            }
            if (aprAmount.getFill() != null && mayAmount.getFill() != null && junAmount.getFill() != null && julAmount.getFill() != null) {
                monthlyTotal += monthlyInc;
                goalPercent = (monthlyTotal / goal) * 100;
                goalPercentRounded = Math.round(goalPercent / 10.0) * 10;
            }
            if (marAmount.getFill()!= null && aprAmount.getFill() != null && mayAmount.getFill() != null && junAmount.getFill() != null && julAmount.getFill() != null) {
                monthlyTotal += monthlyInc;
                goalPercent = (monthlyTotal / goal) * 100;
                goalPercentRounded = Math.round(goalPercent / 10.0) * 10;
            } if (febAmount.getFill()!= null && marAmount.getFill() != null && aprAmount.getFill() != null && mayAmount.getFill() != null && junAmount.getFill() != null && julAmount.getFill() != null) {
                monthlyTotal += monthlyInc;
                goalPercent = (monthlyTotal / goal) * 100;
                goalPercentRounded = Math.round(goalPercent / 10.0) * 10;
            }
            if (janAmount.getFill()!= null && febAmount.getFill() != null && marAmount.getFill() != null && aprAmount.getFill() != null && mayAmount.getFill() != null && junAmount.getFill() != null && julAmount.getFill()!=null) {
                monthlyTotal += monthlyInc;
                goalPercent = (monthlyTotal / goal) * 100;
                goalPercentRounded = Math.round(goalPercent / 10.0) * 10;
            }
            augAmount.setText("$" + monthlyTotal + ", " + String.valueOf(goalPercentRounded) + "%");

            if (goalPercentRounded <= 0) {
                augPoint.setCenterY(820.0);
                julAug.setEndY(820);
                augSep.setStartY(820);
                augAmount.setY(835);
                augAmount.setFill(Color.BLACK);
                augPoint.setStroke(Color.RED);
                augPoint.setFill(Color.RED);
            } else if (goalPercentRounded == 10) {
                augPoint.setCenterY(805.0);
                julAug.setEndY(805);
                augSep.setStartY(805);
                augAmount.setY(820);
                augAmount.setFill(Color.BLACK);
                augPoint.setStroke(Color.RED);
                augPoint.setFill(Color.RED);
            } else if (goalPercentRounded == 20) {
                augPoint.setCenterY(790.0);
                julAug.setEndY(790);
                augSep.setStartY(790);
                augAmount.setY(805);
                augAmount.setFill(Color.BLACK);
                augPoint.setStroke(Color.RED);
                augPoint.setFill(Color.RED);
            } else if (goalPercentRounded == 30) {
                augPoint.setCenterY(775.0);
                julAug.setEndY(775);
                augSep.setStartY(775);
                augAmount.setY(790);
                augAmount.setFill(Color.BLACK);
                augPoint.setStroke(Color.RED);
                augPoint.setFill(Color.RED);
            } else if (goalPercentRounded == 40) {
                augPoint.setCenterY(760.0);
                julAug.setEndY(760);
                augSep.setStartY(760);
                augAmount.setY(775);
                augAmount.setFill(Color.BLACK);
                augPoint.setStroke(Color.RED);
                augPoint.setFill(Color.RED);
            } else if (goalPercentRounded == 50) {
                augPoint.setCenterY(745.0);
                julAug.setEndY(745);
                augSep.setStartY(745);
                augAmount.setY(760);
                augAmount.setFill(Color.BLACK);
                augPoint.setStroke(Color.RED);
                augPoint.setFill(Color.RED);
            } else if (goalPercentRounded == 60) {
                augPoint.setCenterY(730.0);
                julAug.setEndY(730);
                augSep.setStartY(730);
                augAmount.setY(745);
                augAmount.setFill(Color.BLACK);
                augPoint.setStroke(Color.RED);
                augPoint.setFill(Color.RED);
            } else if (goalPercentRounded == 70) {
                augPoint.setCenterY(715.0);
                julAug.setEndY(715);
                augSep.setStartY(715);
                augAmount.setY(730);
                augAmount.setFill(Color.BLACK);
                augPoint.setStroke(Color.RED);
                augPoint.setFill(Color.RED);
            } else if (goalPercentRounded == 80) {
                augPoint.setCenterY(700.0);
                julAug.setEndY(700);
                augSep.setStartY(700);
                augAmount.setY(715);
                augAmount.setFill(Color.BLACK);
                augPoint.setStroke(Color.RED);
                augPoint.setFill(Color.RED);
            } else if (goalPercentRounded == 90) {
                augPoint.setCenterY(685.0);
                julAug.setEndY(685);
                augSep.setStartY(685);
                augAmount.setY(700);
                augAmount.setFill(Color.BLACK);
                augPoint.setStroke(Color.RED);
                augPoint.setFill(Color.RED);
            } else if (goalPercentRounded == 100) {
                augPoint.setCenterY(670.0);
                julAug.setEndY(670);
                augSep.setStartY(670);
                augAmount.setY(685);
                augAmount.setFill(Color.BLACK);
                augPoint.setStroke(Color.GREEN);
                augPoint.setFill(Color.GREEN);
            } else if (goalPercentRounded == 110) {
                augPoint.setCenterY(655.0);
                julAug.setEndY(655);
                augSep.setStartY(655);
                augAmount.setY(670);
                augAmount.setFill(Color.BLACK);
                augPoint.setStroke(Color.GREEN);
                augPoint.setFill(Color.GREEN);
            } else if (goalPercentRounded == 120) {
                augPoint.setCenterY(640.0);
                julAug.setEndY(640);
                augSep.setStartY(640);
                augAmount.setY(655);
                augAmount.setFill(Color.BLACK);
                augPoint.setStroke(Color.GREEN);
                augPoint.setFill(Color.GREEN);
            } else if (goalPercentRounded == 130) {
                augPoint.setCenterY(625.0);
                julAug.setEndY(625);
                augSep.setStartY(625);
                augAmount.setY(640);
                augAmount.setFill(Color.BLACK);
                augPoint.setStroke(Color.GREEN);
                augPoint.setFill(Color.GREEN);
            } else if (goalPercentRounded == 140) {
                augPoint.setCenterY(610.0);
                julAug.setEndY(610);
                augSep.setStartY(610);
                augAmount.setY(625);
                augAmount.setFill(Color.BLACK);
                augPoint.setStroke(Color.GREEN);
                augPoint.setFill(Color.GREEN);
            } else if (goalPercentRounded == 150) {
                augPoint.setCenterY(595.0);
                julAug.setEndY(595);
                augSep.setStartY(595);
                augAmount.setY(610);
                augAmount.setFill(Color.BLACK);
                augPoint.setStroke(Color.GREEN);
                augPoint.setFill(Color.GREEN);
            } else if (goalPercentRounded == 160) {
                augPoint.setCenterY(580.0);
                julAug.setEndY(580);
                augSep.setStartY(580);
                augAmount.setY(595);
                augAmount.setFill(Color.BLACK);
                augPoint.setStroke(Color.GREEN);
                augPoint.setFill(Color.GREEN);
            } else if (goalPercentRounded == 170) {
                augPoint.setCenterY(565.0);
                julAug.setEndY(565);
                augSep.setStartY(565);
                augAmount.setY(580);
                augAmount.setFill(Color.BLACK);
                augPoint.setStroke(Color.GREEN);
                augPoint.setFill(Color.GREEN);
            } else if (goalPercentRounded == 180) {
                augPoint.setCenterY(550.0);
                julAug.setEndY(550);
                augSep.setStartY(550);
                augAmount.setY(565);
                augAmount.setFill(Color.BLACK);
                augPoint.setStroke(Color.GREEN);
                augPoint.setFill(Color.GREEN);
            } else if (goalPercentRounded == 190) {
                augPoint.setCenterY(535.0);
                julAug.setEndY(535);
                augSep.setStartY(535);
                augAmount.setY(550);
                augAmount.setFill(Color.BLACK);
                augPoint.setStroke(Color.GREEN);
                augPoint.setFill(Color.GREEN);
            } else {
                augPoint.setCenterY(520.0);
                julAug.setEndY(520);
                augSep.setStartY(520);
                augAmount.setY(535);
                augAmount.setFill(Color.BLACK);
                augPoint.setStroke(Color.GREEN);
                augPoint.setFill(Color.GREEN);
            }
        } else if (dateMonthInt == 9) {
            if (augAmount.getFill() != null) {
                monthlyTotal += monthlyInc;
                goalPercent = (monthlyTotal / goal) * 100;
                goalPercentRounded = Math.round(goalPercent / 10.0) * 10;
            }
            if (julAmount.getFill() != null && augAmount.getFill()!= null) {
                monthlyTotal += monthlyInc;
                goalPercent = (monthlyTotal / goal) * 100;
                goalPercentRounded = Math.round(goalPercent / 10.0) * 10;
            }
            if (junAmount.getFill() != null && julAmount.getFill() != null && augAmount.getFill() != null) {
                monthlyTotal += monthlyInc;
                goalPercent = (monthlyTotal / goal) * 100;
                goalPercentRounded = Math.round(goalPercent / 10.0) * 10;
            }
            if (mayAmount.getFill() != null && junAmount.getFill() != null && julAmount.getFill() != null && augAmount.getFill() != null) {
                monthlyTotal += monthlyInc;
                goalPercent = (monthlyTotal / goal) * 100;
                goalPercentRounded = Math.round(goalPercent / 10.0) * 10;
            }
            if (aprAmount.getFill()!= null && mayAmount.getFill() != null && junAmount.getFill() != null && julAmount.getFill() != null && augAmount.getFill() != null) {
                monthlyTotal += monthlyInc;
                goalPercent = (monthlyTotal / goal) * 100;
                goalPercentRounded = Math.round(goalPercent / 10.0) * 10;
            } if (marAmount.getFill()!= null && aprAmount.getFill() != null && mayAmount.getFill() != null && junAmount.getFill() != null && julAmount.getFill() != null && augAmount.getFill() != null) {
                monthlyTotal += monthlyInc;
                goalPercent = (monthlyTotal / goal) * 100;
                goalPercentRounded = Math.round(goalPercent / 10.0) * 10;
            }
            if (febAmount.getFill()!= null && marAmount.getFill() != null && aprAmount.getFill() != null && mayAmount.getFill() != null && junAmount.getFill() != null && julAmount.getFill() != null && augAmount.getFill()!=null) {
                monthlyTotal += monthlyInc;
                goalPercent = (monthlyTotal / goal) * 100;
                goalPercentRounded = Math.round(goalPercent / 10.0) * 10;
            }
            if (janAmount.getFill()!= null && febAmount.getFill() != null && marAmount.getFill() != null && aprAmount.getFill() != null && mayAmount.getFill() != null && junAmount.getFill() != null && julAmount.getFill()!=null && augAmount.getFill() != null) {
                monthlyTotal += monthlyInc;
                goalPercent = (monthlyTotal / goal) * 100;
                goalPercentRounded = Math.round(goalPercent / 10.0) * 10;
            }
            sepAmount.setText("$" + monthlyTotal + ", " + String.valueOf(goalPercentRounded) + "%");

            if (goalPercentRounded <= 0) {
                sepPoint.setCenterY(820.0);
                augSep.setEndY(820);
                sepOct.setStartX(820);
                sepAmount.setY(835);
                sepAmount.setFill(Color.BLACK);
                sepPoint.setStroke(Color.RED);
                sepPoint.setFill(Color.RED);
            } else if (goalPercentRounded == 10) {
                sepPoint.setCenterY(805.0);
                augSep.setEndY(805);
                sepOct.setStartX(805);
                sepAmount.setY(820);
                sepAmount.setFill(Color.BLACK);
                sepPoint.setStroke(Color.RED);
                sepPoint.setFill(Color.RED);
            } else if (goalPercentRounded == 20) {
                sepPoint.setCenterY(790.0);
                augSep.setEndY(790);
                sepOct.setStartX(790);
                sepAmount.setY(805);
                sepAmount.setFill(Color.BLACK);
                sepPoint.setStroke(Color.RED);
                sepPoint.setFill(Color.RED);
            } else if (goalPercentRounded == 30) {
                sepPoint.setCenterY(775.0);
                augSep.setEndY(775);
                sepOct.setStartX(775);
                sepAmount.setY(790);
                sepAmount.setFill(Color.BLACK);
                sepPoint.setStroke(Color.RED);
                sepPoint.setFill(Color.RED);
            } else if (goalPercentRounded == 40) {
                sepPoint.setCenterY(760.0);
                augSep.setEndY(760);
                sepOct.setStartX(760);
                sepAmount.setY(775);
                sepAmount.setFill(Color.BLACK);
                sepPoint.setStroke(Color.RED);
                sepPoint.setFill(Color.RED);
            } else if (goalPercentRounded == 50) {
                sepPoint.setCenterY(745.0);
                augSep.setEndY(745);
                sepOct.setStartX(745);
                sepAmount.setY(760);
                sepAmount.setFill(Color.BLACK);
                sepPoint.setStroke(Color.RED);
                sepPoint.setFill(Color.RED);
            } else if (goalPercentRounded == 60) {
                sepPoint.setCenterY(730.0);
                augSep.setEndY(730);
                sepOct.setStartX(730);
                sepAmount.setY(745);
                sepAmount.setFill(Color.BLACK);
                sepPoint.setStroke(Color.RED);
                sepPoint.setFill(Color.RED);
            } else if (goalPercentRounded == 70) {
                sepPoint.setCenterY(715.0);
                augSep.setEndY(715);
                sepOct.setStartX(715);
                sepAmount.setY(730);
                sepAmount.setFill(Color.BLACK);
                sepPoint.setStroke(Color.RED);
                sepPoint.setFill(Color.RED);
            } else if (goalPercentRounded == 80) {
                sepPoint.setCenterY(700.0);
                augSep.setEndY(700);
                sepOct.setStartX(700);
                sepAmount.setY(715);
                sepAmount.setFill(Color.BLACK);
                sepPoint.setStroke(Color.RED);
                sepPoint.setFill(Color.RED);
            } else if (goalPercentRounded == 90) {
                sepPoint.setCenterY(685.0);
                augSep.setEndY(685);
                sepOct.setStartX(685);
                sepAmount.setY(700);
                sepAmount.setFill(Color.BLACK);
                sepPoint.setStroke(Color.RED);
                sepPoint.setFill(Color.RED);
            } else if (goalPercentRounded == 100) {
                sepPoint.setCenterY(670.0);
                augSep.setEndY(670);
                sepOct.setStartX(670);
                sepAmount.setY(685);
                sepAmount.setFill(Color.BLACK);
                sepPoint.setStroke(Color.GREEN);
                sepPoint.setFill(Color.GREEN);
            } else if (goalPercentRounded == 110) {
                sepPoint.setCenterY(655.0);
                augSep.setEndY(655);
                sepOct.setStartX(655);
                sepAmount.setY(670);
                sepAmount.setFill(Color.BLACK);
                sepPoint.setStroke(Color.GREEN);
                sepPoint.setFill(Color.GREEN);
            } else if (goalPercentRounded == 120) {
                sepPoint.setCenterY(640.0);
                augSep.setEndY(640);
                sepOct.setStartX(640);
                sepAmount.setY(655);
                sepAmount.setFill(Color.BLACK);
                sepPoint.setStroke(Color.GREEN);
                sepPoint.setFill(Color.GREEN);
            } else if (goalPercentRounded == 130) {
                sepPoint.setCenterY(625.0);
                augSep.setEndY(625);
                sepOct.setStartX(625);
                sepAmount.setY(640);
                sepAmount.setFill(Color.BLACK);
                sepPoint.setStroke(Color.GREEN);
                sepPoint.setFill(Color.GREEN);
            } else if (goalPercentRounded == 140) {
                sepPoint.setCenterY(610.0);
                augSep.setEndY(610);
                sepOct.setStartX(610);
                sepAmount.setY(625);
                sepAmount.setFill(Color.BLACK);
                sepPoint.setStroke(Color.GREEN);
                sepPoint.setFill(Color.GREEN);
            } else if (goalPercentRounded == 150) {
                sepPoint.setCenterY(595.0);
                augSep.setEndY(595);
                sepOct.setStartX(595);
                sepAmount.setY(610);
                sepAmount.setFill(Color.BLACK);
                sepPoint.setStroke(Color.GREEN);
                sepPoint.setFill(Color.GREEN);
            } else if (goalPercentRounded == 160) {
                sepPoint.setCenterY(580.0);
                augSep.setEndY(580);
                sepOct.setStartX(580);
                sepAmount.setY(595);
                sepAmount.setFill(Color.BLACK);
                sepPoint.setStroke(Color.GREEN);
                sepPoint.setFill(Color.GREEN);
            } else if (goalPercentRounded == 170) {
                sepPoint.setCenterY(565.0);
                augSep.setEndY(565);
                sepOct.setStartX(565);
                sepAmount.setY(580);
                sepAmount.setFill(Color.BLACK);
                sepPoint.setStroke(Color.GREEN);
                sepPoint.setFill(Color.GREEN);
            } else if (goalPercentRounded == 180) {
                sepPoint.setCenterY(550.0);
                augSep.setEndY(550);
                sepOct.setStartX(550);
                sepAmount.setY(565);
                sepAmount.setFill(Color.BLACK);
                sepPoint.setStroke(Color.GREEN);
                sepPoint.setFill(Color.GREEN);
            } else if (goalPercentRounded == 190) {
                sepPoint.setCenterY(535.0);
                augSep.setEndY(535);
                sepOct.setStartX(535);
                sepAmount.setY(550);
                sepAmount.setFill(Color.BLACK);
                sepPoint.setStroke(Color.GREEN);
                sepPoint.setFill(Color.GREEN);
            } else {
                sepPoint.setCenterY(520.0);
                augSep.setEndY(520);
                sepOct.setStartX(520);
                sepAmount.setY(535);
                sepAmount.setFill(Color.BLACK);
                sepPoint.setStroke(Color.GREEN);
                sepPoint.setFill(Color.GREEN);
            }
        } else if (dateMonthInt == 10) {
            if (sepAmount.getFill() != null) {
                monthlyTotal += monthlyInc;
                goalPercent = (monthlyTotal / goal) * 100;
                goalPercentRounded = Math.round(goalPercent / 10.0) * 10;
            }
            if (augAmount.getFill() != null && sepAmount.getFill()!= null) {
                monthlyTotal += monthlyInc;
                goalPercent = (monthlyTotal / goal) * 100;
                goalPercentRounded = Math.round(goalPercent / 10.0) * 10;
            }
            if (julAmount.getFill() != null && augAmount.getFill() != null && sepAmount.getFill() != null) {
                monthlyTotal += monthlyInc;
                goalPercent = (monthlyTotal / goal) * 100;
                goalPercentRounded = Math.round(goalPercent / 10.0) * 10;
            }
            if (junAmount.getFill() != null && julAmount.getFill() != null && augAmount.getFill() != null && sepAmount.getFill() != null) {
                monthlyTotal += monthlyInc;
                goalPercent = (monthlyTotal / goal) * 100;
                goalPercentRounded = Math.round(goalPercent / 10.0) * 10;
            }
            if (mayAmount.getFill()!= null && junAmount.getFill() != null && julAmount.getFill() != null && augAmount.getFill() != null && sepAmount.getFill() != null) {
                monthlyTotal += monthlyInc;
                goalPercent = (monthlyTotal / goal) * 100;
                goalPercentRounded = Math.round(goalPercent / 10.0) * 10;
            } if (aprAmount.getFill()!= null && mayAmount.getFill() != null && junAmount.getFill() != null && julAmount.getFill() != null && augAmount.getFill() != null && sepAmount.getFill() != null) {
                monthlyTotal += monthlyInc;
                goalPercent = (monthlyTotal / goal) * 100;
                goalPercentRounded = Math.round(goalPercent / 10.0) * 10;
            }
            if (marAmount.getFill()!= null && aprAmount.getFill() != null && mayAmount.getFill() != null && junAmount.getFill() != null && julAmount.getFill() != null && augAmount.getFill() != null && sepAmount.getFill()!=null) {
                monthlyTotal += monthlyInc;
                goalPercent = (monthlyTotal / goal) * 100;
                goalPercentRounded = Math.round(goalPercent / 10.0) * 10;
            }
            if (febAmount.getFill()!= null && marAmount.getFill() != null && aprAmount.getFill() != null && mayAmount.getFill() != null && junAmount.getFill() != null && julAmount.getFill() != null && augAmount.getFill()!=null && sepAmount.getFill() != null) {
                monthlyTotal += monthlyInc;
                goalPercent = (monthlyTotal / goal) * 100;
                goalPercentRounded = Math.round(goalPercent / 10.0) * 10;
            }
            if (janAmount.getFill()!= null && febAmount.getFill() != null && marAmount.getFill() != null && aprAmount.getFill() != null && mayAmount.getFill() != null && junAmount.getFill() != null && julAmount.getFill()!=null && augAmount.getFill() != null && sepAmount.getFill() != null) {
                monthlyTotal += monthlyInc;
                goalPercent = (monthlyTotal / goal) * 100;
                goalPercentRounded = Math.round(goalPercent / 10.0) * 10;
            }
            octAmount.setText("$" + monthlyTotal + ", " + String.valueOf(goalPercentRounded) + "%");

            if (goalPercentRounded <= 0) {
                octPoint.setCenterY(820.0);
                sepOct.setEndY(820);
                octNov.setStartY(820);
                octAmount.setY(835);
                octAmount.setFill(Color.BLACK);
                octPoint.setStroke(Color.RED);
                octPoint.setFill(Color.RED);
            } else if (goalPercentRounded == 10) {
                octPoint.setCenterY(805.0);
                sepOct.setEndY(805);
                octNov.setStartY(805);
                octAmount.setY(820);
                octAmount.setFill(Color.BLACK);
                octPoint.setStroke(Color.RED);
                octPoint.setFill(Color.RED);
            } else if (goalPercentRounded == 20) {
                octPoint.setCenterY(790.0);
                sepOct.setEndY(790);
                octNov.setStartY(790);
                octAmount.setY(805);
                octAmount.setFill(Color.BLACK);
                octPoint.setStroke(Color.RED);
                octPoint.setFill(Color.RED);
            } else if (goalPercentRounded == 30) {
                octPoint.setCenterY(775.0);
                sepOct.setEndY(775);
                octNov.setStartY(775);
                octAmount.setY(790);
                octAmount.setFill(Color.BLACK);
                octPoint.setStroke(Color.RED);
                octPoint.setFill(Color.RED);
            } else if (goalPercentRounded == 40) {
                octPoint.setCenterY(760.0);
                sepOct.setEndY(760);
                octNov.setStartY(760);
                octAmount.setY(775);
                octAmount.setFill(Color.BLACK);
                octPoint.setStroke(Color.RED);
                octPoint.setFill(Color.RED);
            } else if (goalPercentRounded == 50) {
                octPoint.setCenterY(745.0);
                sepOct.setEndY(745);
                octNov.setStartY(745);
                octAmount.setY(760);
                octAmount.setFill(Color.BLACK);
                octPoint.setStroke(Color.RED);
                octPoint.setFill(Color.RED);
            } else if (goalPercentRounded == 60) {
                octPoint.setCenterY(730.0);
                sepOct.setEndY(730);
                octNov.setStartY(730);
                octAmount.setY(745);
                octAmount.setFill(Color.BLACK);
                octPoint.setStroke(Color.RED);
                octPoint.setFill(Color.RED);
            } else if (goalPercentRounded == 70) {
                octPoint.setCenterY(715.0);
                sepOct.setEndY(715);
                octNov.setStartY(715);
                octAmount.setY(730);
                octAmount.setFill(Color.BLACK);
                octPoint.setStroke(Color.RED);
                octPoint.setFill(Color.RED);
            } else if (goalPercentRounded == 80) {
                octPoint.setCenterY(700.0);
                sepOct.setEndY(700);
                octNov.setStartY(700);
                octAmount.setY(715);
                octAmount.setFill(Color.BLACK);
                octPoint.setStroke(Color.RED);
                octPoint.setFill(Color.RED);
            } else if (goalPercentRounded == 90) {
                octPoint.setCenterY(685.0);
                sepOct.setEndY(685);
                octNov.setStartY(685);
                octAmount.setY(700);
                octAmount.setFill(Color.BLACK);
                octPoint.setStroke(Color.RED);
                octPoint.setFill(Color.RED);
            } else if (goalPercentRounded == 100) {
                octPoint.setCenterY(670.0);
                sepOct.setEndY(670);
                octNov.setStartY(670);
                octAmount.setY(685);
                octAmount.setFill(Color.BLACK);
                octPoint.setStroke(Color.GREEN);
                octPoint.setFill(Color.GREEN);
            } else if (goalPercentRounded == 110) {
                octPoint.setCenterY(655.0);
                sepOct.setEndY(655);
                octNov.setStartY(655);
                octAmount.setY(670);
                octAmount.setFill(Color.BLACK);
                octPoint.setStroke(Color.GREEN);
                octPoint.setFill(Color.GREEN);
            } else if (goalPercentRounded == 120) {
                octPoint.setCenterY(640.0);
                sepOct.setEndY(640);
                octNov.setStartY(640);
                octAmount.setY(655);
                octAmount.setFill(Color.BLACK);
                octPoint.setStroke(Color.GREEN);
                octPoint.setFill(Color.GREEN);
            } else if (goalPercentRounded == 130) {
                octPoint.setCenterY(625.0);
                sepOct.setEndY(625);
                octNov.setStartY(625);
                octAmount.setY(640);
                octAmount.setFill(Color.BLACK);
                octPoint.setStroke(Color.GREEN);
                octPoint.setFill(Color.GREEN);
            } else if (goalPercentRounded == 140) {
                octPoint.setCenterY(610.0);
                sepOct.setEndY(610);
                octNov.setStartY(610);
                octAmount.setY(625);
                octAmount.setFill(Color.BLACK);
                octPoint.setStroke(Color.GREEN);
                octPoint.setFill(Color.GREEN);
            } else if (goalPercentRounded == 150) {
                octPoint.setCenterY(595.0);
                sepOct.setEndY(595);
                octNov.setStartY(595);
                octAmount.setY(610);
                octAmount.setFill(Color.BLACK);
                octPoint.setStroke(Color.GREEN);
                octPoint.setFill(Color.GREEN);
            } else if (goalPercentRounded == 160) {
                octPoint.setCenterY(580.0);
                sepOct.setEndY(580);
                octNov.setStartY(580);
                octAmount.setY(595);
                octAmount.setFill(Color.BLACK);
                octPoint.setStroke(Color.GREEN);
                octPoint.setFill(Color.GREEN);
            } else if (goalPercentRounded == 170) {
                octPoint.setCenterY(565.0);
                sepOct.setEndY(565);
                octNov.setStartY(565);
                octAmount.setY(580);
                octAmount.setFill(Color.BLACK);
                octPoint.setStroke(Color.GREEN);
                octPoint.setFill(Color.GREEN);
            } else if (goalPercentRounded == 180) {
                octPoint.setCenterY(550.0);
                sepOct.setEndY(550);
                octNov.setStartY(550);
                octAmount.setY(565);
                octAmount.setFill(Color.BLACK);
                octPoint.setStroke(Color.GREEN);
                octPoint.setFill(Color.GREEN);
            } else if (goalPercentRounded == 190) {
                octPoint.setCenterY(535.0);
                sepOct.setEndY(535);
                octNov.setStartY(535);
                octAmount.setY(550);
                octAmount.setFill(Color.BLACK);
                octPoint.setStroke(Color.GREEN);
                octPoint.setFill(Color.GREEN);
            } else {
                octPoint.setCenterY(520.0);
                sepOct.setEndY(520);
                octNov.setStartY(520);
                octAmount.setY(535);
                octAmount.setFill(Color.BLACK);
                octPoint.setStroke(Color.GREEN);
                octPoint.setFill(Color.GREEN);
            }
        } else if (dateMonthInt == 11) {
            if (octAmount.getFill() != null) {
                monthlyTotal += monthlyInc;
                goalPercent = (monthlyTotal / goal) * 100;
                goalPercentRounded = Math.round(goalPercent / 10.0) * 10;
            }
            if (sepAmount.getFill() != null && octAmount.getFill()!= null) {
                monthlyTotal += monthlyInc;
                goalPercent = (monthlyTotal / goal) * 100;
                goalPercentRounded = Math.round(goalPercent / 10.0) * 10;
            }
            if (augAmount.getFill() != null && sepAmount.getFill() != null && octAmount.getFill() != null) {
                monthlyTotal += monthlyInc;
                goalPercent = (monthlyTotal / goal) * 100;
                goalPercentRounded = Math.round(goalPercent / 10.0) * 10;
            }
            if (julAmount.getFill() != null && augAmount.getFill() != null && sepAmount.getFill() != null && octAmount.getFill() != null) {
                monthlyTotal += monthlyInc;
                goalPercent = (monthlyTotal / goal) * 100;
                goalPercentRounded = Math.round(goalPercent / 10.0) * 10;
            }
            if (junAmount.getFill()!= null && julAmount.getFill() != null && augAmount.getFill() != null && sepAmount.getFill() != null && octAmount.getFill() != null) {
                monthlyTotal += monthlyInc;
                goalPercent = (monthlyTotal / goal) * 100;
                goalPercentRounded = Math.round(goalPercent / 10.0) * 10;
            } if (mayAmount.getFill()!= null && junAmount.getFill() != null && julAmount.getFill() != null && augAmount.getFill() != null && sepAmount.getFill() != null && octAmount.getFill() != null) {
                monthlyTotal += monthlyInc;
                goalPercent = (monthlyTotal / goal) * 100;
                goalPercentRounded = Math.round(goalPercent / 10.0) * 10;
            }
            if (aprAmount.getFill()!= null && mayAmount.getFill() != null && junAmount.getFill() != null && julAmount.getFill() != null && augAmount.getFill() != null && sepAmount.getFill() != null && octAmount.getFill()!=null) {
                monthlyTotal += monthlyInc;
                goalPercent = (monthlyTotal / goal) * 100;
                goalPercentRounded = Math.round(goalPercent / 10.0) * 10;
            }
            if (marAmount.getFill()!= null && aprAmount.getFill() != null && mayAmount.getFill() != null && junAmount.getFill() != null && julAmount.getFill() != null && augAmount.getFill() != null && sepAmount.getFill()!=null && octAmount.getFill() != null) {
                monthlyTotal += monthlyInc;
                goalPercent = (monthlyTotal / goal) * 100;
                goalPercentRounded = Math.round(goalPercent / 10.0) * 10;
            }
            if (febAmount.getFill()!= null && marAmount.getFill() != null && aprAmount.getFill() != null && mayAmount.getFill() != null && junAmount.getFill() != null && julAmount.getFill() != null && augAmount.getFill()!=null && sepAmount.getFill() != null && octAmount.getFill() != null) {
                monthlyTotal += monthlyInc;
                goalPercent = (monthlyTotal / goal) * 100;
                goalPercentRounded = Math.round(goalPercent / 10.0) * 10;
            }
            if (janAmount.getFill()!= null && febAmount.getFill() != null && marAmount.getFill() != null && aprAmount.getFill() != null && mayAmount.getFill() != null && junAmount.getFill() != null && julAmount.getFill()!=null && augAmount.getFill() != null && sepAmount.getFill() != null && octAmount.getFill() != null) {
                monthlyTotal += monthlyInc;
                goalPercent = (monthlyTotal / goal) * 100;
                goalPercentRounded = Math.round(goalPercent / 10.0) * 10;
            }
            novAmount.setText("$" + monthlyTotal + ", " + String.valueOf(goalPercentRounded) + "%");

            if (goalPercentRounded <= 0) {
                novPoint.setCenterY(820.0);
                octNov.setEndY(820);
                novDec.setStartY(820);
                novAmount.setY(835);
                novAmount.setFill(Color.BLACK);
                novPoint.setStroke(Color.RED);
                novPoint.setFill(Color.RED);
            } else if (goalPercentRounded == 10) {
                novPoint.setCenterY(805.0);
                octNov.setEndY(805);
                novDec.setStartY(805);
                novAmount.setY(820);
                novAmount.setFill(Color.BLACK);
                novPoint.setStroke(Color.RED);
                novPoint.setFill(Color.RED);
            } else if (goalPercentRounded == 20) {
                novPoint.setCenterY(790.0);
                octNov.setEndY(790);
                novDec.setStartY(790);
                novAmount.setY(805);
                novAmount.setFill(Color.BLACK);
                novPoint.setStroke(Color.RED);
                novPoint.setFill(Color.RED);
            } else if (goalPercentRounded == 30) {
                novPoint.setCenterY(775.0);
                octNov.setEndY(775);
                novDec.setStartY(775);
                novAmount.setY(790);
                novAmount.setFill(Color.BLACK);
                novPoint.setStroke(Color.RED);
                novPoint.setFill(Color.RED);
            } else if (goalPercentRounded == 40) {
                novPoint.setCenterY(760.0);
                octNov.setEndY(760);
                novDec.setStartY(760);
                novAmount.setY(775);
                novAmount.setFill(Color.BLACK);
                novPoint.setStroke(Color.RED);
                novPoint.setFill(Color.RED);
            } else if (goalPercentRounded == 50) {
                novPoint.setCenterY(745.0);
                octNov.setEndY(745);
                novDec.setStartY(745);
                novAmount.setY(760);
                novAmount.setFill(Color.BLACK);
                novPoint.setStroke(Color.RED);
                novPoint.setFill(Color.RED);
            } else if (goalPercentRounded == 60) {
                novPoint.setCenterY(730.0);
                octNov.setEndY(730);
                novDec.setStartY(730);
                novAmount.setY(745);
                novAmount.setFill(Color.BLACK);
                novPoint.setStroke(Color.RED);
                novPoint.setFill(Color.RED);
            } else if (goalPercentRounded == 70) {
                novPoint.setCenterY(715.0);
                octNov.setEndY(715);
                novDec.setStartY(715);
                novAmount.setY(730);
                novAmount.setFill(Color.BLACK);
                novPoint.setStroke(Color.RED);
                novPoint.setFill(Color.RED);
            } else if (goalPercentRounded == 80) {
                novPoint.setCenterY(700.0);
                octNov.setEndY(700);
                novDec.setStartY(700);
                novAmount.setY(715);
                novAmount.setFill(Color.BLACK);
                novPoint.setStroke(Color.RED);
                novPoint.setFill(Color.RED);
            } else if (goalPercentRounded == 90) {
                novPoint.setCenterY(685.0);
                octNov.setEndY(685);
                novDec.setStartY(685);
                novAmount.setY(700);
                novAmount.setFill(Color.BLACK);
                novPoint.setStroke(Color.RED);
                novPoint.setFill(Color.RED);
            } else if (goalPercentRounded == 100) {
                novPoint.setCenterY(670.0);
                octNov.setEndY(670);
                novDec.setStartY(670);
                novAmount.setY(685);
                novAmount.setFill(Color.BLACK);
                novPoint.setStroke(Color.GREEN);
                novPoint.setFill(Color.GREEN);
            } else if (goalPercentRounded == 110) {
                novPoint.setCenterY(655.0);
                octNov.setEndY(655);
                novDec.setStartY(655);
                novAmount.setY(670);
                novAmount.setFill(Color.BLACK);
                novPoint.setStroke(Color.GREEN);
                novPoint.setFill(Color.GREEN);
            } else if (goalPercentRounded == 120) {
                novPoint.setCenterY(640.0);
                octNov.setEndY(640);
                novDec.setStartY(640);
                novAmount.setY(655);
                novAmount.setFill(Color.BLACK);
                novPoint.setStroke(Color.GREEN);
                novPoint.setFill(Color.GREEN);
            } else if (goalPercentRounded == 130) {
                novPoint.setCenterY(625.0);
                octNov.setEndY(625);
                novDec.setStartY(625);
                novAmount.setY(640);
                novAmount.setFill(Color.BLACK);
                novPoint.setStroke(Color.GREEN);
                novPoint.setFill(Color.GREEN);
            } else if (goalPercentRounded == 140) {
                novPoint.setCenterY(610.0);
                octNov.setEndY(610);
                novDec.setStartY(610);
                novAmount.setY(625);
                novAmount.setFill(Color.BLACK);
                novPoint.setStroke(Color.GREEN);
                novPoint.setFill(Color.GREEN);
            } else if (goalPercentRounded == 150) {
                novPoint.setCenterY(595.0);
                octNov.setEndY(595);
                novDec.setStartY(595);
                novAmount.setY(610);
                novAmount.setFill(Color.BLACK);
                novPoint.setStroke(Color.GREEN);
                novPoint.setFill(Color.GREEN);
            } else if (goalPercentRounded == 160) {
                novPoint.setCenterY(580.0);
                octNov.setEndY(580);
                novDec.setStartY(580);
                novAmount.setY(595);
                novAmount.setFill(Color.BLACK);
                novPoint.setStroke(Color.GREEN);
                novPoint.setFill(Color.GREEN);
            } else if (goalPercentRounded == 170) {
                novPoint.setCenterY(565.0);
                octNov.setEndY(565);
                novDec.setStartY(565);
                novAmount.setY(580);
                novAmount.setFill(Color.BLACK);
                novPoint.setStroke(Color.GREEN);
                novPoint.setFill(Color.GREEN);
            } else if (goalPercentRounded == 180) {
                novPoint.setCenterY(550.0);
                octNov.setEndY(550);
                novDec.setStartY(550);
                novAmount.setY(565);
                novAmount.setFill(Color.BLACK);
                novPoint.setStroke(Color.GREEN);
                novPoint.setFill(Color.GREEN);
            } else if (goalPercentRounded == 190) {
                novPoint.setCenterY(535.0);
                octNov.setEndY(535);
                novDec.setStartY(535);
                novAmount.setY(550);
                novAmount.setFill(Color.BLACK);
                novPoint.setStroke(Color.GREEN);
                novPoint.setFill(Color.GREEN);
            } else {
                novPoint.setCenterY(520.0);
                octNov.setEndY(520);
                novDec.setStartY(520);
                novAmount.setY(535);
                novAmount.setFill(Color.BLACK);
                novPoint.setStroke(Color.GREEN);
                novPoint.setFill(Color.GREEN);
            }
        } else if (dateMonthInt == 12) {
            if (novAmount.getFill() != null) {
                monthlyTotal += monthlyInc;
                goalPercent = (monthlyTotal / goal) * 100;
                goalPercentRounded = Math.round(goalPercent / 10.0) * 10;
            }
            if (octAmount.getFill() != null && novAmount.getFill()!= null) {
                monthlyTotal += monthlyInc;
                goalPercent = (monthlyTotal / goal) * 100;
                goalPercentRounded = Math.round(goalPercent / 10.0) * 10;
            }
            if (sepAmount.getFill() != null && octAmount.getFill() != null && novAmount.getFill() != null) {
                monthlyTotal += monthlyInc;
                goalPercent = (monthlyTotal / goal) * 100;
                goalPercentRounded = Math.round(goalPercent / 10.0) * 10;
            }
            if (augAmount.getFill() != null && sepAmount.getFill() != null && octAmount.getFill() != null && novAmount.getFill() != null) {
                monthlyTotal += monthlyInc;
                goalPercent = (monthlyTotal / goal) * 100;
                goalPercentRounded = Math.round(goalPercent / 10.0) * 10;
            }
            if (julAmount.getFill()!= null && augAmount.getFill() != null && sepAmount.getFill() != null && octAmount.getFill() != null && novAmount.getFill() != null) {
                monthlyTotal += monthlyInc;
                goalPercent = (monthlyTotal / goal) * 100;
                goalPercentRounded = Math.round(goalPercent / 10.0) * 10;
            } if (junAmount.getFill()!= null && julAmount.getFill() != null && augAmount.getFill() != null && sepAmount.getFill() != null && octAmount.getFill() != null && novAmount.getFill() != null) {
                monthlyTotal += monthlyInc;
                goalPercent = (monthlyTotal / goal) * 100;
                goalPercentRounded = Math.round(goalPercent / 10.0) * 10;
            }
            if (mayAmount.getFill()!= null && junAmount.getFill() != null && julAmount.getFill() != null && augAmount.getFill() != null && sepAmount.getFill() != null && octAmount.getFill() != null && novAmount.getFill()!=null) {
                monthlyTotal += monthlyInc;
                goalPercent = (monthlyTotal / goal) * 100;
                goalPercentRounded = Math.round(goalPercent / 10.0) * 10;
            }
            if (aprAmount.getFill()!= null && mayAmount.getFill() != null && junAmount.getFill() != null && julAmount.getFill() != null && augAmount.getFill() != null && sepAmount.getFill() != null && octAmount.getFill()!=null && novAmount.getFill() != null) {
                monthlyTotal += monthlyInc;
                goalPercent = (monthlyTotal / goal) * 100;
                goalPercentRounded = Math.round(goalPercent / 10.0) * 10;
            }
            if (marAmount.getFill()!= null && aprAmount.getFill() != null && mayAmount.getFill() != null && junAmount.getFill() != null && julAmount.getFill() != null && augAmount.getFill() != null && sepAmount.getFill()!=null && octAmount.getFill() != null && novAmount.getFill() != null) {
                monthlyTotal += monthlyInc;
                goalPercent = (monthlyTotal / goal) * 100;
                goalPercentRounded = Math.round(goalPercent / 10.0) * 10;
            }
            if (janAmount.getFill()!= null && febAmount.getFill() != null && marAmount.getFill() != null && aprAmount.getFill() != null && mayAmount.getFill() != null && junAmount.getFill() != null && julAmount.getFill()!=null && augAmount.getFill() != null && sepAmount.getFill() != null && octAmount.getFill() != null && novAmount.getFill() != null) {
                monthlyTotal += monthlyInc;
                goalPercent = (monthlyTotal / goal) * 100;
                goalPercentRounded = Math.round(goalPercent / 10.0) * 10;
            }
            decAmount.setText("$" + monthlyTotal + ", " + String.valueOf(goalPercentRounded) + "%");

            if (goalPercentRounded <= 0) {
                decPoint.setCenterY(820.0);
                novDec.setEndY(820);
                decAmount.setY(835);
                decAmount.setFill(Color.BLACK);
                decPoint.setStroke(Color.RED);
                decPoint.setFill(Color.RED);
            } else if (goalPercentRounded == 10) {
                decPoint.setCenterY(805.0);
                novDec.setEndY(805);
                decAmount.setY(820);
                decAmount.setFill(Color.BLACK);
                decPoint.setStroke(Color.RED);
                decPoint.setFill(Color.RED);
            } else if (goalPercentRounded == 20) {
                decPoint.setCenterY(790.0);
                novDec.setEndY(790);
                decAmount.setY(805);
                decAmount.setFill(Color.BLACK);
                decPoint.setStroke(Color.RED);
                decPoint.setFill(Color.RED);
            } else if (goalPercentRounded == 30) {
                decPoint.setCenterY(775.0);
                novDec.setEndY(775);
                decAmount.setY(790);
                decAmount.setFill(Color.BLACK);
                decPoint.setStroke(Color.RED);
                decPoint.setFill(Color.RED);
            } else if (goalPercentRounded == 40) {
                decPoint.setCenterY(760.0);
                novDec.setEndY(760);
                decAmount.setY(775);
                decAmount.setFill(Color.BLACK);
                decPoint.setStroke(Color.RED);
                decPoint.setFill(Color.RED);
            } else if (goalPercentRounded == 50) {
                decPoint.setCenterY(745.0);
                novDec.setEndY(745);
                decAmount.setY(760);
                decAmount.setFill(Color.BLACK);
                decPoint.setStroke(Color.RED);
                decPoint.setFill(Color.RED);
            } else if (goalPercentRounded == 60) {
                decPoint.setCenterY(730.0);
                novDec.setEndY(730);
                decAmount.setY(745);
                decAmount.setFill(Color.BLACK);
                decPoint.setStroke(Color.RED);
                decPoint.setFill(Color.RED);
            } else if (goalPercentRounded == 70) {
                decPoint.setCenterY(715.0);
                novDec.setEndY(715);
                decAmount.setY(730);
                decAmount.setFill(Color.BLACK);
                decPoint.setStroke(Color.RED);
                decPoint.setFill(Color.RED);
            } else if (goalPercentRounded == 80) {
                decPoint.setCenterY(700.0);
                novDec.setEndY(700);
                decAmount.setY(715);
                decAmount.setFill(Color.BLACK);
                decPoint.setStroke(Color.RED);
                decPoint.setFill(Color.RED);
            } else if (goalPercentRounded == 90) {
                decPoint.setCenterY(685.0);
                novDec.setEndY(685);
                decAmount.setY(700);
                decAmount.setFill(Color.BLACK);
                decPoint.setStroke(Color.RED);
                decPoint.setFill(Color.RED);
            } else if (goalPercentRounded == 100) {
                decPoint.setCenterY(670.0);
                novDec.setEndY(670);
                decAmount.setY(685);
                decAmount.setFill(Color.BLACK);
                decPoint.setStroke(Color.GREEN);
                decPoint.setFill(Color.GREEN);
            } else if (goalPercentRounded == 110) {
                decPoint.setCenterY(655.0);
                novDec.setEndY(655);
                decAmount.setY(670);
                decAmount.setFill(Color.BLACK);
                decPoint.setStroke(Color.GREEN);
                decPoint.setFill(Color.GREEN);
            } else if (goalPercentRounded == 120) {
                decPoint.setCenterY(640.0);
                novDec.setEndY(640);
                decAmount.setY(655);
                decAmount.setFill(Color.BLACK);
                decPoint.setStroke(Color.GREEN);
                decPoint.setFill(Color.GREEN);
            } else if (goalPercentRounded == 130) {
                decPoint.setCenterY(625.0);
                novDec.setEndY(625);
                decAmount.setY(640);
                decAmount.setFill(Color.BLACK);
                decPoint.setStroke(Color.GREEN);
                decPoint.setFill(Color.GREEN);
            } else if (goalPercentRounded == 140) {
                decPoint.setCenterY(610.0);
                novDec.setEndY(610);
                decAmount.setY(625);
                decAmount.setFill(Color.BLACK);
                decPoint.setStroke(Color.GREEN);
                decPoint.setFill(Color.GREEN);
            } else if (goalPercentRounded == 150) {
                decPoint.setCenterY(595.0);
                novDec.setEndY(595);
                decAmount.setY(610);
                decAmount.setFill(Color.BLACK);
                decPoint.setStroke(Color.GREEN);
                decPoint.setFill(Color.GREEN);
            } else if (goalPercentRounded == 160) {
                decPoint.setCenterY(580.0);
                novDec.setEndY(580);
                decAmount.setY(595);
                decAmount.setFill(Color.BLACK);
                decPoint.setStroke(Color.GREEN);
                decPoint.setFill(Color.GREEN);
            } else if (goalPercentRounded == 170) {
                decPoint.setCenterY(565.0);
                novDec.setEndY(565);
                decAmount.setY(580);
                decAmount.setFill(Color.BLACK);
                decPoint.setStroke(Color.GREEN);
                decPoint.setFill(Color.GREEN);
            } else if (goalPercentRounded == 180) {
                decPoint.setCenterY(550.0);
                novDec.setEndY(550);
                decAmount.setY(565);
                decAmount.setFill(Color.BLACK);
                decPoint.setStroke(Color.GREEN);
                decPoint.setFill(Color.GREEN);
            } else if (goalPercentRounded == 190) {
                decPoint.setCenterY(535.0);
                novDec.setEndY(535);
                decAmount.setY(550);
                decAmount.setFill(Color.BLACK);
                decPoint.setStroke(Color.GREEN);
                decPoint.setFill(Color.GREEN);
            } else {
                decPoint.setCenterY(520.0);
                novDec.setEndY(520);
                decAmount.setY(535);
                decAmount.setFill(Color.BLACK);
                decPoint.setStroke(Color.GREEN);
                decPoint.setFill(Color.GREEN);
            }
        }

        if (janPoint.getFill() != null && febPoint.getFill() != null) {
            janFeb.setStroke(Color.BLACK);
        }
        if (febPoint.getFill() != null && marPoint.getFill() != null) {
            febMar.setStroke(Color.BLACK);
        }
        if (marPoint.getFill() != null && aprPoint.getFill() != null) {
            marApr.setStroke(Color.BLACK);
        }
        if (aprPoint.getFill() != null && mayPoint.getFill() != null) {
            aprMay.setStroke(Color.BLACK);
        }
        if (mayPoint.getFill() != null && junPoint.getFill() != null) {
            mayJun.setStroke(Color.BLACK);
        }
        if (junPoint.getFill() != null && julPoint.getFill() != null) {
            junJul.setStroke(Color.BLACK);
        }
        if (julPoint.getFill() != null && augPoint.getFill() != null) {
            julAug.setStroke(Color.BLACK);
        }
        if (augPoint.getFill() != null && sepPoint.getFill() != null) {
            augSep.setStroke(Color.BLACK);
        }
        if (sepPoint.getFill() != null && octPoint.getFill() != null) {
            sepOct.setStroke(Color.BLACK);
        }
        if (octPoint.getFill() != null && novPoint.getFill() != null) {
            octNov.setStroke(Color.BLACK);
        }
        if (novPoint.getFill() != null && decPoint.getFill() != null) {
            novDec.setStroke(Color.BLACK);
        }

        // double allNumbers = (monthlyInc * 12) - (janNumbers + febNumbers + marNumbers + aprNumbers + mayNumbers + junNumbers + julNumbers + augNumbers + sepNumbers + octNumbers + novNumbers + decNumbers);
        if (goal > monthlyTotal) {
            underperforming.setStroke(Color.RED);
            underperforming.setFill(Color.RED);
            meeting.setStroke(Color.BLACK);
            meeting.setFill(null);
            overperforming.setStroke(Color.BLACK);
            overperforming.setFill(null);
        } else if (goal == monthlyTotal) {
            meeting.setStroke(Color.GREEN);
            meeting.setFill(Color.GREEN);
            underperforming.setStroke(Color.BLACK);
            underperforming.setFill(null);
            overperforming.setStroke(Color.BLACK);
            overperforming.setFill(null);
        } else if (goal < monthlyTotal) {
            overperforming.setStroke(Color.GREEN);
            overperforming.setFill(Color.GREEN);
            underperforming.setStroke(Color.BLACK);
            underperforming.setFill(null);
            meeting.setStroke(Color.BLACK);
            meeting.setFill(null);
        }
    }

    public void dataCheck(ActionEvent event) {
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

        if (incorrect == false && incorrect2 == false) {
            if ((event.getSource()).toString().contains("update")) {
                update.setOnAction(this::update);

            } else if ((event.getSource()).toString().contains("save")) {
                save.setOnAction(this::save);

            }
        }
    }

    public void save(ActionEvent event) {

    }

    public void load(ActionEvent event) {

    }

    public void delete(ActionEvent event) {
        numbers = 0;
        janPoint.setStroke(null);
        janPoint.setFill(null);
        febPoint.setStroke(null);
        febPoint.setFill(null);
        marPoint.setStroke(null);
        marPoint.setFill(null);
        aprPoint.setStroke(null);
        aprPoint.setFill(null);
        mayPoint.setStroke(null);
        mayPoint.setFill(null);
        junPoint.setStroke(null);
        junPoint.setFill(null);
        julPoint.setStroke(null);
        julPoint.setFill(null);
        augPoint.setStroke(null);
        augPoint.setFill(null);
        sepPoint.setStroke(null);
        sepPoint.setFill(null);
        octPoint.setStroke(null);
        octPoint.setFill(null);
        novPoint.setStroke(null);
        novPoint.setFill(null);
        decPoint.setStroke(null);
        decPoint.setFill(null);

        janFeb.setStroke(null);
        febMar.setStroke(null);
        marApr.setStroke(null);
        aprMay.setStroke(null);
        mayJun.setStroke(null);
        junJul.setStroke(null);
        julAug.setStroke(null);
        augSep.setStroke(null);
        sepOct.setStroke(null);
        octNov.setStroke(null);
        novDec.setStroke(null);

        underperforming.setStroke(Color.BLACK);
        underperforming.setFill(null);
        meeting.setStroke(Color.BLACK);
        meeting.setFill(null);
        overperforming.setStroke(Color.BLACK);
        overperforming.setFill(null);

        janAmount.setFill(null);
        febAmount.setFill(null);
        marAmount.setFill(null);
        aprAmount.setFill(null);
        mayAmount.setFill(null);
        junAmount.setFill(null);
        julAmount.setFill(null);
        augAmount.setFill(null);
        sepAmount.setFill(null);
        octAmount.setFill(null);
        novAmount.setFill(null);
        decAmount.setFill(null);

    }

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
    
    this should clear all data stored in the integrated text file
    
    
     */
    // the budget goals is just to include goals and doesn't link to anything, it is basically finished.
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        launch(args);
    }

}
