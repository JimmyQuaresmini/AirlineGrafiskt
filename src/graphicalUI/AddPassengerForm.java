package graphicalUI;

import airlinePkg.Airline;
import foodPkg.Food;
import foodPkg.FoodMenu;
import peoplePkg.Passenger;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by Jimmy on 2016-11-01.
 */
public class AddPassengerForm extends JFrame{
    //alla dessa skapas automatiskt
    private JTextField textfieldFirstName;
    private JComboBox cboDestinations; //= new JComboBox(
    private JSpinner spnAge;
    private JButton btnSave;
    private JButton btnBack;
    private JTextField textfSurname;
    private JRadioButton firstClassRadioButton;
    private JCheckBox köttbullarCheckBox;
    private JTextArea txtTicket;
    private JTextArea textAirline;
    private JLabel jmAirlinesLabel;
    private JPanel huvudPanel;
    private JRadioButton economyClassRadioButton;
    private JCheckBox spaghettiCheckBox;
    private JCheckBox hamburgareCheckBox;
    private JCheckBox läskCheckbox;
    private JCheckBox vinCheckBox;
    private JCheckBox kaffeCheckbox;
    private JButton btnTicket;
    private JButton btnAirline;
    private JLabel lblSeatNr;
    private JComboBox cboSeatNr;

    JFrame mainFrame;
    //AddPassengerForm g = new AddPassengerForm();
    MainMenuGraphical mmg = new MainMenuGraphical();

    Food[] foods = new Food[12];
    FoodMenu fMenu;// = new FoodMenu();
    ArrayList<Food> foodlist = new ArrayList<>(6);

    Airline airline = new Airline();

    JFrame thisGraficalFrame;

    public AddPassengerForm(){

        foods[0] = new Food(110, "Entrecote");
        foods[1] = new Food(95, "Jasmineris");
        foods[2] = new Food(85, "Angusburger");
        foods[3] = new Food(20, "Monster energy drink");
        foods[4] = new Food(115, "Champagne");
        foods[5] = new Food(40, "Café au lait");

        foods[6] = new Food(55, "Meatballs");
        foods[7] = new Food(65, "Spaghetti");
        foods[8] = new Food(50, "Hamburger");
        foods[9] = new Food(15, "Soft drink");
        foods[10] = new Food(85, "Wine");
        foods[11] = new Food(30, "Coffee");

        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fName = textfieldFirstName.getText();
                String lName = textfSurname.getText();
                int age = (int) spnAge.getValue();
                int seatNr = Integer.parseInt(cboSeatNr.getSelectedItem().toString());
                String dest = cboDestinations.getSelectedItem().toString();
                int totP = 0;

                makeMenu();
                airline.addFoodIncome(fMenu.getTotalFoodPrice());

                if(seatNr < 6){
                    totP = 20000 + fMenu.getTotalFoodPrice();
                }
                else {
                    totP = 5000 + fMenu.getTotalFoodPrice();
                }
                Passenger p = new Passenger(fName, lName, totP, seatNr, dest, age);
                mmg.addPassAndSeat(p, fMenu);

                airline.calculateProfitAndIncome(totP);
                mmg.setaLine(airline);
            }
        });

        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getThisGraficalFrame().setVisible(false);
            }
        });

        firstClassRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                köttbullarCheckBox.setText("Entrecote");
                spaghettiCheckBox.setText("Jasminerice");
                hamburgareCheckBox.setText("Angusburger");

                läskCheckbox.setText("Monster energy drink");
                vinCheckBox.setText("Champagne");
                kaffeCheckbox.setText("Café au lait");
            }
        });

        economyClassRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                köttbullarCheckBox.setText("Meatballs");
                spaghettiCheckBox.setText("Spaghetti");
                hamburgareCheckBox.setText("Hamburger");

                läskCheckbox.setText("Soft drink");
                vinCheckBox.setText("Wine");
                kaffeCheckbox.setText("Coffee");
            }
        });

        btnTicket.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String firstName = textfieldFirstName.getText();
                String surName = textfSurname.getText();
                String name = firstName + " " + surName;
                int age = (int) spnAge.getValue();
                String flightClass = "";
                if (firstClassRadioButton.isSelected() == true){
                    flightClass = "First Class";
                }
                else {
                    flightClass = "Economy Class";
                }

                int seatNr = Integer.parseInt(cboSeatNr.getSelectedItem().toString());
                makeMenu();

                String ticket = "Ticket to: " + cboDestinations.getSelectedItem().toString() +  "\n";
                ticket = ticket + "Name: " + name + "\n";
                ticket = ticket + "Age: " + age + "\n";
                ticket = ticket + "Seat number: " + seatNr + "\n";
                ticket = ticket + "Class: " + flightClass + "\n";
                ticket = ticket + "Food: " + "\n";
                for(Food f : fMenu.getFoodList()){
                    ticket = ticket + f.getFoodTitel() + ": " + f.getPrice() + " SEK" + "\n";
                }
                txtTicket.setText(ticket);
            }
        });

        btnAirline.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textAirline.setText("");
                String printOut =  "JM Airlines " + "\n";
                printOut = printOut + "Airline's income: " + airline.getAirlineIncome() + "\n";
                printOut = printOut + "Airline's profit: " + airline.getAirlineProfit();
                textAirline.setText(printOut);
            }
        });
    }

    public static void main(String[] args) {
        AddPassengerForm g = new AddPassengerForm();

        JFrame frame = new JFrame("Add passenger");
        frame.setContentPane(g.huvudPanel);//new AddPassengerForm()
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(400, 600);
        frame.setLocation(350, 0);
        frame.setVisible(false);

        g.mmg.setGraficalFrame(frame);//la jag till så man kan öppna detta fönster från huvudfönstret
        g.setThisGraficalFrame(frame);

        //kan göra "JFrame mainFrame" på klass-nivå så jag kommer åt den från btnSave
        //MainMenuGraphical mmg = new MainMenuGraphical();
        g.mainFrame = new JFrame("Airline project graphical");//JFrame
        g.mainFrame.setContentPane(g.mmg.getMainPanel());//new MainMenuGraphical()
        g.mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        g.mainFrame.pack();
        g.mainFrame.setVisible(true);
    }

    //alla "grejer" med alternativet "Custom create" måste jag skapa här
    private void createUIComponents() {
        // TODO: place custom component creation code here

        huvudPanel = new JPanel();//JScrollPane
        //huvudPanel.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        /*jmAirlinesLabel = new JLabel("JM Airlines");
        huvudPanel.add(jmAirlinesLabel);*/

        //JOptionPane.showConfirmDialog(AddPassengerForm.this, "Ny dialog form");
        /*cboDestinations.addItem("London");
        cboDestinations.addItem("Paris");
        cboDestinations.addItem("Rome");
        cboDestinations.addItem("Miami");*/

        textfieldFirstName = new JTextField("");
        textfSurname = new JTextField("");
        SpinnerModel model = new SpinnerNumberModel(25, 1, 120, 1);
        spnAge = new JSpinner(model);
        spnAge.setSize(10, 8);

        /*firstClassRadioButton = new JRadioButton();
        economyClassRadioButton = new JRadioButton();
        köttbullarCheckBox = new JCheckBox();*/

        //denna valde jag inte "custom create" på, men ska kanske
        String[] orter = {"London", "Paris", "Rome", "Miami"};
        cboDestinations = new JComboBox(orter);

        String[] nrs = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        cboSeatNr = new JComboBox(nrs);
    }

    private void makeMenu(){
        foodlist.clear();
        if(köttbullarCheckBox.isSelected() == true && firstClassRadioButton.isSelected() == true){
            //fMenu //add food
            foodlist.add(foods[0]);
        }

        if(spaghettiCheckBox.isSelected() == true && firstClassRadioButton.isSelected() == true){
            foodlist.add(foods[1]);
        }

        if(hamburgareCheckBox.isSelected() == true && firstClassRadioButton.isSelected() == true){
            foodlist.add(foods[2]);
        }

        if(läskCheckbox.isSelected() == true && firstClassRadioButton.isSelected() == true){
            foodlist.add(foods[3]);
        }

        if(vinCheckBox.isSelected() == true && firstClassRadioButton.isSelected() == true){
            foodlist.add(foods[4]);
        }

        if(kaffeCheckbox.isSelected() == true && firstClassRadioButton.isSelected() == true){
            foodlist.add(foods[5]);
        }

        if(köttbullarCheckBox.isSelected() == true && firstClassRadioButton.isSelected() == false){
            foodlist.add(foods[6]);
        }

        if(spaghettiCheckBox.isSelected() == true && firstClassRadioButton.isSelected() == false){
            foodlist.add(foods[7]);
        }

        if(hamburgareCheckBox.isSelected() == true && firstClassRadioButton.isSelected() == false){
            foodlist.add(foods[8]);
        }

        if(läskCheckbox.isSelected() == true && firstClassRadioButton.isSelected() == false){
            foodlist.add(foods[9]);
        }

        if(vinCheckBox.isSelected() == true && firstClassRadioButton.isSelected() == false){
            foodlist.add(foods[10]);
        }

        if(kaffeCheckbox.isSelected() == true && firstClassRadioButton.isSelected() == false){
            foodlist.add(foods[11]);
        }

        fMenu = new FoodMenu(foodlist);
    }

    public JPanel getHuvudPanel() {
        return huvudPanel;
    }

    public void showGrafical(){
        this.setVisible(true);
    }

    public JFrame getThisGraficalFrame() {
        return thisGraficalFrame;
    }

    public void setThisGraficalFrame(JFrame thisGraficalFrame) {
        this.thisGraficalFrame = thisGraficalFrame;
    }
}
