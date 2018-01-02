package graphicalUI;

import airlinePkg.Airline;
import airplanePkg.Airplane;
import airplanePkg.Seat;
import foodPkg.FoodMenu;
import peoplePkg.Passenger;
import servicesPkg.CheckingPlane;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by Jimmy on 2016-11-22.
 * edited 28-30/11 + 1-2/12
 */
public class MainMenuGraphical extends JFrame{
    private JButton btnAddPass;
    private JButton btnAirlineInfo;
    private JButton btnFlyAirplanes;
    private JButton btnExit;
    private JPanel mainPanel;
    private JComboBox cboDestination;
    private JLabel lblDestination;
    private JButton fillPlaneButton;
    private JButton fillPlaneWithRealButton;

    ArrayList<Airplane> planes = new ArrayList<>(4);
    Passenger passenger;
    Seat s;

    Airline aLine = new Airline();

    CheckingPlane checkPlane = new CheckingPlane();

    JFrame graficalFrame;

    public MainMenuGraphical(){
        /*planes.add(new Airplane("London"));//Londons fylls inte på, men dom andras gör det med destination
        planes.add(new Airplane(true));//fyller
        planes.add(new Airplane("Rome"));
        planes.add(new Airplane("Miami"));*/

        planes.add(new Airplane());
        planes.add(new Airplane());
        planes.add(new Airplane());
        planes.add(new Airplane());

        planes.get(0).setDestination("London");
        planes.get(1).setDestination("Paris");
        planes.get(2).setDestination("Rome");
        planes.get(3).setDestination("Miami");

        planes.get(0).setName("AA11");
        planes.get(1).setName("UA175");
        planes.get(2).setName("AA77");
        planes.get(3).setName("UA93");

        fillPlaneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String dest = cboDestination.getSelectedItem().toString();
                if(dest.equalsIgnoreCase("London") == true){
                    //planes.get(0).fillPassengersWithRealPeople();
                    planes.get(0).fillPassengersOnPlane();
                }
                else if(dest.equalsIgnoreCase("Paris") == true) {
                    planes.get(1).fillPassengersOnPlane();
                }
                else if(dest.equalsIgnoreCase("Rome") == true) {
                    planes.get(2).fillPassengersOnPlane();
                }
                else if(dest.equalsIgnoreCase("Miami") == true){
                    planes.get(3).fillPassengersOnPlane();
                }
            }
        });

        fillPlaneWithRealButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //String dest = cboDestination.getSelectedItem().toString();
                //if(dest.equalsIgnoreCase("London") == true) {
                    planes.get(0).fillPassengersWithRealPeople();
                //}
            }
        });

        btnFlyAirplanes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //skicka plan-arraylist
                FlyingForm ff = new FlyingForm();
                ff.setPlanes(planes);

                //öppna nytt fönster för flygning
                //FlyingForm ff = new FlyingForm();
                JFrame frame = new JFrame("Fly airplanes");
                frame.setContentPane(ff.getFlyingFormWindow());//.getFlygPanel()//new FlyingForm()

                //frame.add(new FlyingForm().getFlygPanel());
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.setSize(600, 700);
                //frame.pack();
                frame.setLocation(750,0);
                frame.setVisible(true);
            }
        });

        btnAirlineInfo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AirlineInfoForm aiForm = new AirlineInfoForm();
                aiForm.setAirline(aLine);
                aiForm.setPlanes(planes);

                JFrame jf = new JFrame();
                jf.setContentPane(aiForm.getAirlineMainPanel());
                jf.setSize(400, 700);
                jf.setLocation(750, 0);
                jf.setVisible(true);

                aiForm.setThisAirlineInfoFrame(jf);
            }
        });

        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        btnAddPass.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getGraficalFrame().setVisible(true);
            }
        });
    }

    public void addPassAndSeat(Passenger p, FoodMenu fm){
        passenger = p;

        // = new Passenger(firstName, surname, totalTicketPrice, seat.getSeatNumber(), airPlanes[noOfPlane].getDestination(), age);
        //seat.setPassenger(p);
        //airPlanes[noOfPlane].addSeatAndPass(seat, p);

        s = new Seat(p.getSeatNr(), p, fm);
        //s.setPassenger(passenger);//gör allt i Seat
        if(p.getDestination().equalsIgnoreCase("London") == true){
            planes.get(0).addSeatAndPass(s, passenger);

            boolean full = checkPlane.isPlaneFullyBooked(planes.get(0));

            if(full == true){
                btnAddPass.setEnabled(false);//kan inte boka om planet är fullt
            }
        }
        else if(p.getDestination().equalsIgnoreCase("Paris") == true){
            planes.get(1).addSeatAndPass(s, passenger);
            boolean full = checkPlane.isPlaneFullyBooked(planes.get(1));

            if(full == true){
                btnAddPass.setEnabled(false);//kan inte boka om planet är fullt
            }
        }
        else if(p.getDestination().equalsIgnoreCase("Rome") == true){
            planes.get(2).addSeatAndPass(s, passenger);
            boolean full = checkPlane.isPlaneFullyBooked(planes.get(2));

            if(full == true){
                btnAddPass.setEnabled(false);//kan inte boka om planet är fullt
            }
        }
        else if(p.getDestination().equalsIgnoreCase("Miami") == true){
            planes.get(3).addSeatAndPass(s, passenger);
            boolean full = checkPlane.isPlaneFullyBooked(planes.get(3));

            if(full == true){
                btnAddPass.setEnabled(false);//kan inte boka om planet är fullt
            }
        }

        this.setPlanes(planes);
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public ArrayList<Airplane> getPlanes() {
        return planes;
    }

    public void setPlanes(ArrayList<Airplane> planes) {
        this.planes = planes;
    }

    public void setaLine(Airline aLine) {
        this.aLine = aLine;
    }

    private void createUIComponents() {
        String[] orter = {"London", "Paris", "Rome", "Miami"};
        cboDestination = new JComboBox(orter);
    }

    public JFrame getGraficalFrame() {
        return graficalFrame;
    }

    public void setGraficalFrame(JFrame graficalFrame) {
        this.graficalFrame = graficalFrame;
    }
}
