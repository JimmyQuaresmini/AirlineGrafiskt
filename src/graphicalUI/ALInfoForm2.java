package graphicalUI;

import airlinePkg.Airline;
import airplanePkg.Airplane;
import airplanePkg.Airport;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Jimmy
 * //kör inte extends i originalfilen, men kan inte fixa fel om jag tar bort
 */
public class ALInfoForm2 extends javax.swing.JFrame {

    /**
     * Creates new form ALInfoForm2
     */
    
    ArrayList<Airplane> planes = new ArrayList<>(4);
    Airline airline;

    JFrame thisAirlineInfoFrame;

    Airport arlanda = new Airport();
    
    public ALInfoForm2() {
        initComponents();
        createUIComponents();
        //this.setSize(700, 500);
        //jScrollPane1.add(companyTextArea);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        airlineMainPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        planeInfoButton = new javax.swing.JButton();
        companyInfoButton = new javax.swing.JButton();
        cboDestinations = new javax.swing.JComboBox<>();
        backButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        companyTextArea = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        planeTextArea = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(700, 500));

        airlineMainPanel.setMinimumSize(new java.awt.Dimension(500, 300));
        airlineMainPanel.setPreferredSize(new java.awt.Dimension(700, 450));
        airlineMainPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel1.setText("Airline information");
        airlineMainPanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 10, -1, -1));

        planeInfoButton.setText("Plane info");
        planeInfoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                planeInfoButtonActionPerformed(evt);
            }
        });
        airlineMainPanel.add(planeInfoButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, -1, -1));

        companyInfoButton.setText("Company info");
        companyInfoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                companyInfoButtonActionPerformed(evt);
            }
        });
        airlineMainPanel.add(companyInfoButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, -1, -1));

        cboDestinations.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        airlineMainPanel.add(cboDestinations, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 460, -1, -1));

        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        airlineMainPanel.add(backButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 510, -1, -1));

        companyTextArea.setColumns(20);
        companyTextArea.setLineWrap(true);
        companyTextArea.setRows(5);
        companyTextArea.setWrapStyleWord(true);
        companyTextArea.setAutoscrolls(false);
        companyTextArea.setPreferredSize(new java.awt.Dimension(250, 150));
        jScrollPane1.setViewportView(companyTextArea);

        airlineMainPanel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 290, 680, 200));

        jScrollPane2.setAutoscrolls(true);

        planeTextArea.setColumns(20);
        planeTextArea.setLineWrap(true);
        planeTextArea.setRows(5);
        planeTextArea.setWrapStyleWord(true);
        planeTextArea.setPreferredSize(new java.awt.Dimension(250, 150));
        jScrollPane2.setViewportView(planeTextArea);

        airlineMainPanel.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 60, 680, 210));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(airlineMainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 997, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(148, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(airlineMainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void planeInfoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_planeInfoButtonActionPerformed
        planeTextArea.setText("");
        String selectedDestination = cboDestinations.getSelectedItem().toString();
        if (planes.size() > 0) {
            for (int i = 0; i < 4; i++) {
                String planesDestination = planes.get(i).getDestination();
                if (selectedDestination.equalsIgnoreCase(planesDestination) == true) {
                    String planePrintout = "Plane's name: " + planes.get(i).getName() + "\n";
                    planePrintout = planePrintout + "Plane's destination: " + planes.get(i).getDestination() + "\n";
                    planePrintout = planePrintout + "Plane's passengers are: " + "\n" 
                            + planes.get(i).returnPassengerList();
                    planeTextArea.setText(planePrintout);

                    //if there are no passengers assigned to this plane yet
                    if (planes.get(i).returnPassengerList().equalsIgnoreCase("") == true) {
                        planeTextArea.setText("This plane has no passengers to list here yet.");
                    }
                    break;
                }
            }
        } else {
            //planeTextArea.setText("Plane to " + selectedDestination + " has no passengers to list here yet.");
            planeTextArea.setText("Planes cannot be found and thus cannot be listed here right now");
        }
    }//GEN-LAST:event_planeInfoButtonActionPerformed

    private void companyInfoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_companyInfoButtonActionPerformed
        companyTextArea.setText("");

        //visa totala bolagets inkomst o vinst
        //visa per plan också
        //kanske även matintäkter
        companyTextArea.setText("This airline has the following airport: " + arlanda.getName() + "\n" + "\n");

        companyTextArea.setText(companyTextArea.getText() + "Airline's total income = " + airline.getAirlineIncome() + "\n");
        companyTextArea.setText(companyTextArea.getText() + "Airline's total profit = " + airline.getAirlineProfit() + "\n");
        companyTextArea.setText(companyTextArea.getText() + "Airline's total food income = " + airline.getFoodIncome() + "\n");
        companyTextArea.setText(companyTextArea.getText() + "\n");
        int[] planeIncomes = new int[3];//airline.calculatePlaneIncomeProfit(planes.get(0));
        if (planes.size() > 0) {
            for (int i = 0; i < 4; i++) {
                planeIncomes = airline.calculatePlaneIncomeProfit(planes.get(i));
                companyTextArea.setText(companyTextArea.getText() + "Plane to " + planes.get(i).getDestination() + "'s total income: "
                        + planeIncomes[0] + "\n");
                companyTextArea.setText(companyTextArea.getText() + "Plane to " + planes.get(i).getDestination() + "'s total profit: "
                        + planeIncomes[1] + "\n");
                companyTextArea.setText(companyTextArea.getText() + "Plane to " + planes.get(i).getDestination() + "'s total food income: "
                        + planeIncomes[2] + "\n" + "\n");
            }
        } else {
            companyTextArea.setText("Airline has no income yet.");
        }
    }//GEN-LAST:event_companyInfoButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        //stäng
        getThisAirlineInfoFrame().setVisible(false);
    }//GEN-LAST:event_backButtonActionPerformed

    public void setPlanes(ArrayList<Airplane> planes) {
        this.planes = planes;
    }

    public void setAirline(Airline airline) {
        this.airline = airline;
    }

    private void createUIComponents() {
        String[] orter = {"London", "Paris", "Rome", "Miami"};
        //cboDestinations = new JComboBox(orter);
        
        cboDestinations.removeAllItems();
        for (int i = 0; i < 4; i++) {
            cboDestinations.addItem(orter[i]);
        }
    }

    public JPanel getAirlineMainPanel() {
        return airlineMainPanel;
    }

    public JFrame getThisAirlineInfoFrame() {
        return thisAirlineInfoFrame;
    }

    public void setThisAirlineInfoFrame(JFrame thisAirlineInfoFrame) {
        this.thisAirlineInfoFrame = thisAirlineInfoFrame;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel airlineMainPanel;
    private javax.swing.JButton backButton;
    private javax.swing.JComboBox<String> cboDestinations;
    private javax.swing.JButton companyInfoButton;
    private javax.swing.JTextArea companyTextArea;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton planeInfoButton;
    private javax.swing.JTextArea planeTextArea;
    // End of variables declaration//GEN-END:variables
}