package graphicalUI;

import javax.swing.JFrame;
import airlinePkg.Airline;
import foodPkg.Food;
import foodPkg.FoodMenu;
import java.awt.GridBagConstraints;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import peoplePkg.Passenger;

import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;

/**
 *
 * @author Jimmy
 * 
 * som AddPForm2, men så labels hamnar rätt
 * alltså, gridbaglayout
 * 
 */
public class AddPassengerForm3 extends JFrame implements ActionListener {
    private javax.swing.JButton btnAirline;
    private javax.swing.JButton btnBack;
    private javax.swing.ButtonGroup btnGrpClass;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnTicket;
    private javax.swing.JComboBox<String> cboDestinations;
    private javax.swing.JComboBox<String> cboSeatNr;
    private javax.swing.JRadioButton economyClassRadioButton;
    private javax.swing.JRadioButton firstClassRadioButton;
    private javax.swing.JCheckBox hamburgareCheckBox;
    private javax.swing.JPanel huvudPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel jmAirlinesLabel;
    private javax.swing.JCheckBox kaffeCheckbox;
    private javax.swing.JCheckBox köttbullarCheckBox;
    private javax.swing.JLabel lblSeatNr;
    private javax.swing.JCheckBox läskCheckbox;
    private javax.swing.JCheckBox spaghettiCheckBox;
    private javax.swing.JSpinner spnAge;
    private javax.swing.JTextArea textAirline;
    private javax.swing.JTextField textfSurname;
    private javax.swing.JTextField textfieldFirstName;
    private javax.swing.JTextArea txtTicket;
    private javax.swing.JCheckBox vinCheckBox;
    
    JFrame mainFrame;
    //AddPassengerForm g = new AddPassengerForm();
    //MainMenuGraphical mmg = new MainMenuGraphical();
    MainMGraphical2 mmg = new MainMGraphical2();

    Food[] foods = new Food[12];
    FoodMenu fMenu;// = new FoodMenu();
    ArrayList<Food> foodlist = new ArrayList<>(6);

    Airline airline = new Airline();

    JFrame thisGraficalFrame;
    
    //la till denna april 2018 för rull-listans ifyllning beroende på sätena
    boolean seatIsBooked;
    //la också till(flyttade från btnTicket) denna april 2018
    String name;
    
    public AddPassengerForm3() {
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
        
        btnGrpClass = new javax.swing.ButtonGroup();
        huvudPanel = new javax.swing.JPanel();
        jmAirlinesLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblSeatNr = new javax.swing.JLabel();
        btnTicket = new javax.swing.JButton();
        btnAirline = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        economyClassRadioButton = new javax.swing.JRadioButton();
        textfSurname = new javax.swing.JTextField();
        textfieldFirstName = new javax.swing.JTextField();
        cboDestinations = new javax.swing.JComboBox<>();
        firstClassRadioButton = new javax.swing.JRadioButton();
        spnAge = new javax.swing.JSpinner();
        köttbullarCheckBox = new javax.swing.JCheckBox();
        läskCheckbox = new javax.swing.JCheckBox();
        spaghettiCheckBox = new javax.swing.JCheckBox();
        vinCheckBox = new javax.swing.JCheckBox();
        hamburgareCheckBox = new javax.swing.JCheckBox();
        kaffeCheckbox = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtTicket = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        textAirline = new javax.swing.JTextArea();
        cboSeatNr = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        //huvudPanel.setLayout(new java.awt.GridLayout(22, 5));
        huvudPanel.setLayout(new GridBagLayout());
        GridBagConstraints gBagConstraints = new GridBagConstraints();

        gBagConstraints.gridx = 1;
        gBagConstraints.gridy = 0;
        gBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        jmAirlinesLabel.setText("Passenger information");
        huvudPanel.add(jmAirlinesLabel, gBagConstraints);

        gBagConstraints.gridx = 0;
        gBagConstraints.gridy = 1;
        gBagConstraints.fill = GridBagConstraints.NONE;
        jLabel2.setText("Destination");
        huvudPanel.add(jLabel2, gBagConstraints);

        gBagConstraints.gridx = 0;
        gBagConstraints.gridy = 2;
        jLabel1.setText("First name");
        huvudPanel.add(jLabel1, gBagConstraints);

        gBagConstraints.gridx = 0;
        gBagConstraints.gridy = 3;
        jLabel3.setText("Surname");
        huvudPanel.add(jLabel3, gBagConstraints);

        gBagConstraints.gridx = 0;
        gBagConstraints.gridy = 4;
        jLabel4.setText("Age");
        huvudPanel.add(jLabel4, gBagConstraints);

        gBagConstraints.gridx = 0;
        gBagConstraints.gridy = 5;
        jLabel5.setText("Class");
        huvudPanel.add(jLabel5, gBagConstraints);

        gBagConstraints.gridx = 0;
        gBagConstraints.gridy = 6;
        jLabel6.setText("Food");
        huvudPanel.add(jLabel6, gBagConstraints);

        gBagConstraints.gridx = 0;
        gBagConstraints.gridy = 9;
        lblSeatNr.setText("Seat number");
        huvudPanel.add(lblSeatNr, gBagConstraints);

        gBagConstraints.gridx = 0;
        gBagConstraints.gridy = 11;//12
        btnTicket.setText("Print Ticket");
        btnTicket.addActionListener(this);
        huvudPanel.add(btnTicket, gBagConstraints);

        gBagConstraints.gridx = 0;
        gBagConstraints.gridy = 16;
        btnAirline.setText("Airline");
        btnAirline.addActionListener(this);
        huvudPanel.add(btnAirline, gBagConstraints);

        gBagConstraints.gridx = 2;
        gBagConstraints.gridy = 10;
        btnSave.setText("Save");
        btnSave.addActionListener(this);
        huvudPanel.add(btnSave, gBagConstraints);

        gBagConstraints.gridx = 2;
        gBagConstraints.gridy = 17;//16
        btnBack.setText("Back");
        btnBack.addActionListener(this);
        huvudPanel.add(btnBack, gBagConstraints);

        gBagConstraints.gridx = 2;
        gBagConstraints.gridy = 5;
        gBagConstraints.anchor = GridBagConstraints.LINE_START;
        btnGrpClass.add(economyClassRadioButton);
        economyClassRadioButton.setText("Economy class");
        economyClassRadioButton.addActionListener(this);
        huvudPanel.add(economyClassRadioButton, gBagConstraints);

        gBagConstraints.gridx = 1;
        gBagConstraints.gridy = 3;
        gBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gBagConstraints.anchor = GridBagConstraints.CENTER;
        textfSurname.setColumns(1);
        textfSurname.setText("textfSurname");
        //textfSurname.setPreferredSize(new java.awt.Dimension(150, 50));
        huvudPanel.add(textfSurname, gBagConstraints);

        gBagConstraints.gridx = 1;
        gBagConstraints.gridy = 2;
        gBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        textfieldFirstName.setColumns(2);
        textfieldFirstName.setText("textfieldFirstName");
        huvudPanel.add(textfieldFirstName, gBagConstraints);

        cboDestinations.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        gBagConstraints.gridx = 1;
        gBagConstraints.gridy = 1;
        huvudPanel.add(cboDestinations, gBagConstraints);
        
        gBagConstraints.gridx = 1;
        gBagConstraints.gridy = 5;
        gBagConstraints.fill = GridBagConstraints.NONE;
        gBagConstraints.anchor = GridBagConstraints.LINE_START;
        btnGrpClass.add(firstClassRadioButton);
        firstClassRadioButton.setText("First class");
        firstClassRadioButton.addActionListener(this);
        huvudPanel.add(firstClassRadioButton, gBagConstraints);

        gBagConstraints.gridx = 1;
        gBagConstraints.gridy = 6;        
        köttbullarCheckBox.setText("Köttbullar");
        huvudPanel.add(köttbullarCheckBox, gBagConstraints);

        gBagConstraints.gridx = 2;
        gBagConstraints.gridy = 6;
        läskCheckbox.setText("Läsk");
        huvudPanel.add(läskCheckbox, gBagConstraints);

        //nästa rad
        gBagConstraints.gridx = 1;
        gBagConstraints.gridy = 7;
        spaghettiCheckBox.setText("Spaghetti");
        huvudPanel.add(spaghettiCheckBox, gBagConstraints);

        gBagConstraints.gridx = 2;
        gBagConstraints.gridy = 7;
        vinCheckBox.setText("Vin");
        huvudPanel.add(vinCheckBox, gBagConstraints);

        //nästa rad
        gBagConstraints.gridx = 1;
        gBagConstraints.gridy = 8;
        hamburgareCheckBox.setText("Hamburgare");
        huvudPanel.add(hamburgareCheckBox, gBagConstraints);

        gBagConstraints.gridx = 2;
        gBagConstraints.gridy = 8;
        kaffeCheckbox.setText("Kaffe");
        huvudPanel.add(kaffeCheckbox, gBagConstraints);

        jScrollPane1.setPreferredSize(new java.awt.Dimension(200, 125));

        gBagConstraints.gridx = 1;
        gBagConstraints.gridy = 11;
        gBagConstraints.fill = GridBagConstraints.BOTH;
        gBagConstraints.anchor = GridBagConstraints.CENTER;
        txtTicket.setColumns(20);
        txtTicket.setRows(5);
        jScrollPane1.setViewportView(txtTicket);
        huvudPanel.add(jScrollPane1, gBagConstraints);

        jScrollPane2.setPreferredSize(new java.awt.Dimension(200, 125));

        gBagConstraints.gridx = 1;
        gBagConstraints.gridy = 16;//15
        textAirline.setColumns(20);
        textAirline.setRows(5);
        jScrollPane2.setViewportView(textAirline);
        huvudPanel.add(jScrollPane2, gBagConstraints);

        gBagConstraints.gridx = 1;
        gBagConstraints.gridy = 9;
        gBagConstraints.fill = GridBagConstraints.NONE;
        gBagConstraints.anchor = GridBagConstraints.LINE_END;
        cboSeatNr.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        huvudPanel.add(cboSeatNr, gBagConstraints);
        
        gBagConstraints.gridx = 1;
        gBagConstraints.gridy = 4;        
        huvudPanel.add(spnAge, gBagConstraints);

        /*javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(huvudPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cboDestinations, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spnAge, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(firstClassRadioButton, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(economyClassRadioButton))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(textfSurname, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(textfieldFirstName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(köttbullarCheckBox)
                        .addGap(18, 18, 18)
                        .addComponent(läskCheckbox))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(spaghettiCheckBox)
                        .addGap(18, 18, 18)
                        .addComponent(vinCheckBox))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(hamburgareCheckBox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(kaffeCheckbox))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboSeatNr, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1033, 1033, 1033))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(huvudPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 571, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(cboDestinations, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textfieldFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(textfSurname, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spnAge, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(economyClassRadioButton)
                    .addComponent(firstClassRadioButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(köttbullarCheckBox)
                    .addComponent(läskCheckbox))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spaghettiCheckBox)
                    .addComponent(vinCheckBox))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hamburgareCheckBox)
                    .addComponent(kaffeCheckbox))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cboSeatNr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );*/

        this.add(huvudPanel);
        pack();
        
        createUIComponents();
        
        //la till raden under april 2018        
        this.setBounds(500, 0, 500, 650);
        
        this.setTitle("Add passenger");
        this.setVisible(false);

        this.mmg.setGraficalFrame(this);
        this.setThisGraficalFrame(this);
        
        this.mmg.setVisible(true);
        
        //this.mainFrame = new JFrame("Airline project graphical");
        //this.mainFrame.setContentPane(this.mmg.getMainPanel());
        //this.mainFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); 
        
        if (e.getSource() == btnTicket) {
            int age = (int) spnAge.getValue();
            String flightClass = "";
            if (firstClassRadioButton.isSelected() == true) {
                flightClass = "First Class";
            } else {
                flightClass = "Economy Class";
            }

            int seatNr = Integer.parseInt(cboSeatNr.getSelectedItem().toString());
            makeMenu();

            String ticket = "Ticket to: " + cboDestinations.getSelectedItem().toString() + "\n";
            ticket = ticket + "Name: " + name + "\n";
            ticket = ticket + "Age: " + age + "\n";
            ticket = ticket + "Seat number: " + seatNr + "\n";
            ticket = ticket + "Class: " + flightClass + "\n";
            ticket = ticket + "Food: " + "\n";
            for (Food f : fMenu.getFoodList()) {
                ticket = ticket + f.getFoodTitel() + ": " + f.getPrice() + " SEK" + "\n";
            }
            txtTicket.setText(ticket);
        }
        else if (e.getSource() == btnAirline) {
            textAirline.setText("");
            String printOut = "JM Airlines " + "\n";
            printOut = printOut + "Airline's income: " + airline.getAirlineIncome() + "\n";
            printOut = printOut + "Airline's profit: " + airline.getAirlineProfit();
            textAirline.setText(printOut);
        }
        else if (e.getSource() == btnSave) {
            String fName = textfieldFirstName.getText();
            String lName = textfSurname.getText();
            name = fName + " " + lName;//för btnTicket, la till april 2018
            int age = (int) spnAge.getValue();
            int seatNr = Integer.parseInt(cboSeatNr.getSelectedItem().toString());
            String dest = cboDestinations.getSelectedItem().toString();
            int totP = 0;

            makeMenu();
            airline.addFoodIncome(fMenu.getTotalFoodPrice());

            if (seatNr < 6) {
                totP = 20000 + fMenu.getTotalFoodPrice();
            } else {
                totP = 5000 + fMenu.getTotalFoodPrice();
            }
            Passenger p = new Passenger(fName, lName, totP, seatNr, dest, age);
            mmg.addPassAndSeat(p, fMenu);

            airline.calculateProfitAndIncome(totP);
            mmg.setaLine(airline);

            //la jag till april 2018
            resetMenuOptions();
        }
        else if (e.getSource() == btnBack) {
            getThisGraficalFrame().setVisible(false);
        }
        else if (e.getSource() == firstClassRadioButton) {
            //la jag till april 2018
            enableMenuOptions();

            köttbullarCheckBox.setText("Entrecote");
            spaghettiCheckBox.setText("Jasminerice");
            hamburgareCheckBox.setText("Angusburger");

            läskCheckbox.setText("Monster energy drink");
            vinCheckBox.setText("Champagne");
            kaffeCheckbox.setText("Café au lait");

            String dest = cboDestinations.getSelectedItem().toString();
            String[] nrs = {"1", "2", "3", "4", "5"};
            cboSeatNr.removeAllItems();
            for (int j = 0; j < 5; j++) {
                seatIsBooked = mmg.getIfSeatIsBooked(dest, j);
                if (seatIsBooked == false) {
                    cboSeatNr.addItem(nrs[j]);
                }
            }
        }
        else if (e.getSource() == economyClassRadioButton) {
            //la jag till april 2018
            enableMenuOptions();

            köttbullarCheckBox.setText("Meatballs");
            spaghettiCheckBox.setText("Spaghetti");
            hamburgareCheckBox.setText("Hamburger");

            läskCheckbox.setText("Soft drink");
            vinCheckBox.setText("Wine");
            kaffeCheckbox.setText("Coffee");

            String dest = cboDestinations.getSelectedItem().toString();
            String[] nrs = {"6", "7", "8", "9", "10"};
            cboSeatNr.removeAllItems();
            for (int j = 0; j < 5; j++) {
                seatIsBooked = mmg.getIfSeatIsBooked(dest, j + 5);
                if (seatIsBooked == false) {
                    cboSeatNr.addItem(nrs[j]);
                }
            }
        }
    }
    
    private void createUIComponents() {
        //huvudPanel = new JPanel();//JScrollPane
        //huvudPanel.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        /*jmAirlinesLabel = new JLabel("JM Airlines");
        huvudPanel.add(jmAirlinesLabel);*/

        //JOptionPane.showConfirmDialog(AddPassengerForm.this, "Ny dialog form");
        /*cboDestinations.addItem("London");
        cboDestinations.addItem("Paris");
        cboDestinations.addItem("Rome");
        cboDestinations.addItem("Miami");*/

        //textfieldFirstName = new JTextField("");
        //textfSurname = new JTextField("");
        
        //la jag till dessa 2 rader april 2018
        resetMenuOptions();
        btnSave.setText("Book passenger");
        
        SpinnerModel model = new SpinnerNumberModel(25, 1, 120, 1);
        //spnAge = new JSpinner(model);
        spnAge.setModel(model);
        spnAge.setSize(10, 8);

        /*firstClassRadioButton = new JRadioButton();
        economyClassRadioButton = new JRadioButton();
        köttbullarCheckBox = new JCheckBox();*/

        //denna valde jag inte "custom create" på, men ska kanske
        String[] orter = {"London", "Paris", "Rome", "Miami"};
        //cboDestinations = new JComboBox(orter);
        
        cboDestinations.removeAllItems();
        for (int i = 0; i < 4; i++) {
            cboDestinations.addItem(orter[i]);
        }

        //cboSeatNr = new JComboBox(nrs);
        
        /*String[] nrs = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};        
        cboSeatNr.removeAllItems();
        for (int j = 0; j < 10; j++) {
            cboSeatNr.addItem(nrs[j]);
        }*/
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
    
    //ny hjälp-metod april 2018
    private void resetMenuOptions() {
        textfieldFirstName.setText("");
        textfSurname.setText("");
        
        köttbullarCheckBox.setEnabled(false);
        spaghettiCheckBox.setEnabled(false);
        hamburgareCheckBox.setEnabled(false);

        läskCheckbox.setEnabled(false);
        vinCheckBox.setEnabled(false);
        kaffeCheckbox.setEnabled(false);
        
        cboSeatNr.setEnabled(false);
    }
    
    //ny hjälp-metod april 2018
    private void enableMenuOptions() {
        köttbullarCheckBox.setEnabled(true);
        spaghettiCheckBox.setEnabled(true);
        hamburgareCheckBox.setEnabled(true);

        läskCheckbox.setEnabled(true);
        vinCheckBox.setEnabled(true);
        kaffeCheckbox.setEnabled(true);
        
        cboSeatNr.setEnabled(true);
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
        
    public static void main(String args[]) {
                
        
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainMGraphical2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainMGraphical2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainMGraphical2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainMGraphical2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new AddPForm2().setVisible(true);
                
                AddPassengerForm3 g = new AddPassengerForm3(); //g //apf2

                //JFrame frame = new JFrame("Add passenger");
                /*frame.setContentPane(g.huvudPanel);//new AddPassengerForm()
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setSize(400, 600);
                frame.setLocation(350, 0);
                frame.setVisible(false);*/
                
                //g.mmg.setGraficalFrame(frame);//la jag till så man kan öppna detta fönster från huvudfönstret
                //g.setThisGraficalFrame(frame);
                
                //g.mmg.setAPF2(g);//feb 2018

                //kan göra "JFrame mainFrame" på klass-nivå så jag kommer åt den från btnSave
                //MainMenuGraphical mmg = new MainMenuGraphical();
                //g.mainFrame = new JFrame("Airline project graphical");//JFrame
                //g.mainFrame.setContentPane(g.mmg.getMainPanel());//new MainMenuGraphical()
                //g.mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                //g.mainFrame.pack();
                //g.mainFrame.setVisible(true);
            }
        });
    }
}
