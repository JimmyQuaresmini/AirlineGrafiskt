package airplanePkg;

import peoplePkg.Passenger;

import java.util.ArrayList;
import java.util.TimerTask;

/**
 * Created by Jimmy on 2016-10-26.
 * Modified 31 Oct, 1st Nov, 18th of Nov
 */
public class Airplane extends TimerTask implements Runnable{//extends Thread?
    private ArrayList<Seat> seats = new ArrayList<Seat>(10);
    private ArrayList<Passenger> passengers = new ArrayList<Passenger>(10);
    //Masods
    private int businessSeats = 5;

    private int economiSeats = 5;
    public boolean readyToFly = false;
    public int totalTicketSales = 0;

    private boolean readyForTakeOff = false;
    private boolean inTheAir = false;

    private String destination;

    //private String asteriskUtskrift = "";

    private String name = "";

    public Airplane(){
        //la jag till 2:a dec
        //for (Seat s : seats) {
        for (int i = 0; i < 10; i++) {
            seats.add(i, new Seat());//tomma säten
            
            //kommenterar bort raden under igen i april 2018 för passagerare...
            //...är människor som ska åka med och dom finns inte alltid
            //passengers.add(i, new Passenger());//la jag till i feb 2018
        }
    }

    public Airplane(String destination){
        setDestination(destination);
        if(destination.equals("London") == false){
            fillPassengersOnPlane();
        }
    }

    public Airplane(boolean dummyValue){//bara för o ha tredje konstruktor där passagerare fylls på
        //seats 1-5 = first class
        //seats 6-10 = economy class

        fillPassengersOnPlane();
        //seat[0]
    }

    //Masods konstruktor
    public Airplane(ArrayList<Seat> seats) {
        this.seats = seats;
    }

    public void addSeatAndPass(Seat seat, Passenger p) {
        if(seats.size() < 10) {//la jag till 2:a dec
            seats.add(seat);
            if(passengers.size() < 10) {
                passengers.add(p);
            }
        }
        else{//la jag till 2:a dec
            if(seats.get(seat.getSeatNumber()).isBooked() == false){
                seats.set(seat.getSeatNumber() - 1, seat);
                //april 2018
                if(passengers.size() < 10) {
                    passengers.add(p);
                }
                else {
                    passengers.set(seat.getSeatNumber() - 1, p);
                }
            }
        }
    }

    public String takeOff(){
        String takeOffText = "Plane takes off to " + getDestination();
        System.out.println(takeOffText);
        inTheAir = true;
        return takeOffText;
    }

    public String landing(){
        String landingfText = "Plane to " + getDestination() + " lands safely";
        System.out.println(landingfText);
        inTheAir = false;
        readyForTakeOff = false;
        return landingfText;
    }

    public String loadPlane(){
        String loadText = "Plane loads passengers and cargo";
        System.out.println(loadText);
        readyForTakeOff = true;
        return loadText;
    }

    public String checkAndRefuel(){
        String checkText = "Plane to " + getDestination() + " is being checked and refueled";
        System.out.println(checkText);
        return checkText;
    }

    @Override
    public void run(){//extends TimerTask //Detta är inte klart, men ska försöka få klart utskriften
        /*if(isInTheAir() == true){//kanske inte ska ha detta.
            asteriskUtskrift = asteriskUtskrift + "*";
            System.out.println("Plane to " + getDestination() + " is flying " + asteriskUtskrift);
        }
        else{*/
            loadPlane();
            //printPassengerList();
            takeOff();

            System.out.println("Plane flies for 47 seconds");
            try {
                Thread.sleep(47000);//47 second flight.
            } catch (InterruptedException e) {
                System.out.println("Sleep interrupted in Airplane object in run() method.");
                e.printStackTrace();
            }
            landing();
            checkAndRefuel();
        //}

    }

    public boolean isReadyForTakeOff() {
        return readyForTakeOff;
    }

    public void setReadyForTakeOff(boolean readyForTakeOff) {
        this.readyForTakeOff = readyForTakeOff;
    }

    public boolean isInTheAir() {
        return inTheAir;
    }

    public void setInTheAir(boolean inTheAir) {
        this.inTheAir = inTheAir;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void printPassengerList(){
        System.out.println();
        for (Passenger p : passengers) {
            System.out.println(p);
        }
    }

    public String returnPassengerList(){
        //System.out.println();
        String returnList = "";
        for (Passenger p : passengers) {
            returnList = returnList + p + "\n";
            //System.out.println(p);
        }

        return returnList;
    }

    //fill all seats in a plane with bots without having to type them in
    //private function only for inside the Airplane class
    public void fillPassengersOnPlane(){//private, ändrar till public för grafiska
        //int i = 0;
        //for (Passenger p : passengers) {//fel med foreach tror jag
        for(int i = 0; i < 10; i++){
            if (passengers.size() >= 10) {
                passengers.get(i).setFirstName("Passenger");//p
                passengers.get(i).setLastName("Unnamed" + i);
                passengers.get(i).setAge(35 + i);
                passengers.get(i).setDestination(getDestination());
                passengers.get(i).setSeatNr(i + 1);
                if (i < 5) {
                    passengers.get(i).setTicketPrice(21500);
                } else {
                    passengers.get(i).setTicketPrice(5300);
                }
                if (seats.size() >= 10) {
                    seats.get(i).setBooked(true);
                    seats.get(i).setSeatNumber(i + 1);
                    seats.get(i).setPassenger(passengers.get(i));                    
                } else {
                    seats.add(i, new Seat(i + 1, passengers.get(i)));
                }
            }
            else {
                Passenger nyP = new Passenger();
                nyP.setFirstName("Passenger");//p
                nyP.setLastName("Unnamed" + i);
                nyP.setAge(35 + i);
                nyP.setDestination(getDestination());
                nyP.setSeatNr(i + 1);
                if (i < 5) {
                    nyP.setTicketPrice(21500);
                } else {
                    nyP.setTicketPrice(5300);
                }
                passengers.add(nyP);
                
                if (seats.size() >= 10) {
                    seats.get(i).setBooked(true);
                    seats.get(i).setSeatNumber(i + 1);
                    seats.get(i).setPassenger(nyP);                    
                } else {
                    seats.add(i, new Seat(i + 1, nyP));
                }
            }            
        }
    }

    //method to fill with real names from outside the class
    public void fillPassengersWithRealPeople(){
        Passenger p1 = new Passenger("Jimmy", "Quaresmini", 5100, 7, "London", 40);
        Passenger p2 = new Passenger("Masod", "Jalalian", 5200, 9, "London", 60);
        Passenger p8 = new Passenger("Bardia", "Fathi", 5300, 6, "London", 38);
        Passenger p9 = new Passenger("Sami", "Norola", 5300, 8, "London", 37);
        Passenger p10 = new Passenger("Bardias", "Girlfriend", 5200, 10, "London", 35);
        /*seats.add(6, new Seat(7,p1));//Jimmy
        seats.add(8, new Seat(9,p2));//Masod
        seats.add(5, new Seat(6,p8));//Bardia
        seats.add(7, new Seat(8,p9));//Sami
        seats.add(9, new Seat(10,p10));//Bardias Girlfriend*/

        Passenger p3 = new Passenger("Mattias", "Svensson-Nordell", 22000, 1, "London", 29);
        //seats.add(0, new Seat(1,p3));
        Passenger p4 = new Passenger("Bita", "Jabbari", 21000, 3, "London", 43);
        //seats.add(2, new Seat(3,p4));
        Passenger p5 = new Passenger("Marcus", "Lippert", 24000, 2, "London", 45);
        //seats.add(1, new Seat(2,p5));
        Passenger p6 = new Passenger("Christer", "Barousen", 21000, 4, "London", 44);
        //seats.add(3, new Seat(4,p6));
        Passenger p7 = new Passenger("Linda", "Hilding", 21500, 5, "London", 42);
        //seats.add(4, new Seat(5,p7));

        passengers.add(p1);
        passengers.add(p2);
        passengers.add(p3);
        passengers.add(p4);
        passengers.add(p5);

        passengers.add(p6);
        passengers.add(p7);
        passengers.add(p8);
        passengers.add(p9);
        passengers.add(p10);

        seats.add(0, new Seat(1,p3));//Mattias
        seats.add(1, new Seat(2,p5));//Marcus
        seats.add(2, new Seat(3,p4));//Bita
        seats.add(3, new Seat(4,p6));//Christer
        seats.add(4, new Seat(5,p7));//Linda

        seats.add(5, new Seat(6,p8));//Bardia
        seats.add(6, new Seat(7,p1));//Jimmy
        seats.add(7, new Seat(8,p9));//Sami
        seats.add(8, new Seat(9,p2));//Masod
        seats.add(9, new Seat(10,p10));//Bardias Girlfriend
    }

    //metod jag la till med Masods UI för att fylla på övriga passagerare
    public void fillRestOfPassengersOnPlane(){
        for(int i = 0; i < 10; i++){
            if(i < seats.size()) {
                if (seats.get(i).isBooked() == false) {
                    Passenger nyP = new Passenger();
                    nyP.setFirstName("Passenger");
                    nyP.setLastName("Unnamed" + i);
                    nyP.setAge(35 + i);
                    nyP.setDestination(getDestination());
                    nyP.setSeatNr(i + 1);
                    if (i < 5) {
                        nyP.setTicketPrice(21500);
                    } else {
                        nyP.setTicketPrice(5300);
                    }
                    passengers.add(nyP);

                    seats.add(i, new Seat(i + 1, nyP));
                }
            }
            else{//to avoid null pointer exception
                Passenger nyP = new Passenger();
                nyP.setFirstName("Passenger");
                nyP.setLastName("Unnamed" + i);
                nyP.setAge(35 + i);
                nyP.setDestination(getDestination());
                nyP.setSeatNr(i + 1);
                if (i < 5) {
                    nyP.setTicketPrice(21500);
                } else {
                    nyP.setTicketPrice(5300);
                }
                passengers.add(nyP);

                seats.add(i, new Seat(i + 1, nyP));
            }

        }
    }

    //Masods getters o setters
    public void setReadyToFly(boolean readyToFly) {
        this.readyToFly = readyToFly;
    }
    public boolean isReadyToFly() {
        return readyToFly;
    }

    public int getBusinessSeats() {
        return businessSeats;
    }

    public void setBusinessSeats(int businessSeats) {
        this.businessSeats = businessSeats;
    }

    public int getEconomiSeats() {
        return economiSeats;
    }

    public void setEconomiSeats(int economiSeats) {
        this.economiSeats = economiSeats;
    }

    public ArrayList<Seat> getSeats() {
        return seats;
    }

    public void setSeats(ArrayList<Seat> seats) {
        this.seats = seats;
    }

    //ny getter o setter för grafiska
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
