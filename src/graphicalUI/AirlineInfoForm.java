package graphicalUI;

import airlinePkg.Airline;
import airplanePkg.Airplane;
import airplanePkg.Airport;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by User on 2016-11-24.
 */
public class AirlineInfoForm {
    private JTextArea planeTextArea;
    private JTextArea companyTextArea;
    private JButton companyInfoButton;
    private JButton planeInfoButton;
    private JComboBox cboDestinations;
    private JButton backButton;
    private JPanel airlineMainPanel;

    ArrayList<Airplane> planes = new ArrayList<>(4);
    Airline airline;

    JFrame thisAirlineInfoFrame;

    Airport arlanda = new Airport();

    public AirlineInfoForm(){

        planeInfoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                planeTextArea.setText("");
                String selectedDestination = cboDestinations.getSelectedItem().toString();
                if(planes.size() > 0){
                    for (int i = 0; i < 4; i++) {
                        String planesDestination = planes.get(i).getDestination();
                        if(selectedDestination.equalsIgnoreCase(planesDestination) == true){
                            String planePrintout = "Plane's name: " + planes.get(i).getName() + "\n";
                            planePrintout = planePrintout + "Plane's destination: " + planes.get(i).getDestination() + "\n";
                            planePrintout = planePrintout + "Plane's passengers are: " + planes.get(i).returnPassengerList();
                            planeTextArea.setText(planePrintout);

                            //if there are no passengers assigned to this plane yet
                            if(planes.get(i).returnPassengerList().equalsIgnoreCase("") == true){
                                planeTextArea.setText("This plane has no passengers to list here yet.");
                            }
                            break;
                        }
                    }
                }
                else {
                    //planeTextArea.setText("Plane to " + selectedDestination + " has no passengers to list here yet.");
                    planeTextArea.setText("Planes cannot be found and thus cannot be listed here right now");
                }
            }
        });
        companyInfoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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
                if(planes.size() > 0){
                    for (int i = 0; i < 4; i++) {
                        planeIncomes = airline.calculatePlaneIncomeProfit(planes.get(i));
                        companyTextArea.setText(companyTextArea.getText() + "Plane to " + planes.get(i).getDestination() + "'s total income: "
                                + planeIncomes[0] + "\n");
                        companyTextArea.setText(companyTextArea.getText() + "Plane to " + planes.get(i).getDestination() + "'s total profit: "
                                + planeIncomes[1] + "\n");
                        companyTextArea.setText(companyTextArea.getText() + "Plane to " + planes.get(i).getDestination() + "'s total food income: "
                                + planeIncomes[2] + "\n" + "\n");
                    }
                }
                else{
                    companyTextArea.setText("Airline has no income yet.");
                }
            }
        });
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //stäng
                getThisAirlineInfoFrame().setVisible(false);
            }
        });
        /*backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                airlineMainPanel.setVisible(false);
            }
        });*/
    }

    public void setPlanes(ArrayList<Airplane> planes) {
        this.planes = planes;
    }

    public void setAirline(Airline airline) {
        this.airline = airline;
    }

    private void createUIComponents() {
        String[] orter = {"London", "Paris", "Rome", "Miami"};
        cboDestinations = new JComboBox(orter);
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
}
