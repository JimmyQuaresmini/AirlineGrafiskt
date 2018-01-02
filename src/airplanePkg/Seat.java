package airplanePkg;

import foodPkg.FoodItem;
import foodPkg.FoodItemsAmount;
import foodPkg.FoodMenu;
import peoplePkg.ClassType;
import peoplePkg.Passenger;

import java.util.ArrayList;

/**
 * Created by Jimmy on 2016-10-26.
 */
public class Seat {
    private int seatNumber;
    private Passenger passenger;
    private FoodItem foodItem;//överflödig?

    private FoodMenu foodMenu;//ny av mig för grafiska. Getter o setter*

    //Masods
    private ClassType classStatus;
    private boolean booked;

    private ArrayList<FoodItemsAmount> foodItemAmounts = new ArrayList<>();//jag ändra till private. Get?

    public Seat(){

    }

    //utan food
    public Seat(int seatNr, Passenger pass){
        this.seatNumber = seatNr;
        this.passenger = pass;

        //la jag till 23/11 för grafiska
        if(this.getSeatNumber() > 5){
            setClassStatus(ClassType.ECONOMY);
        }
        else{
            setClassStatus(ClassType.BUSINESS);
        }
        setBooked(true);
    }

    public Seat(int seatNr, Passenger pass, FoodItem food){
        this.seatNumber = seatNr;
        this.passenger = pass;
        this.foodItem = food;
    }

    //med food. Ny 23/11 för grafiska
    public Seat(int seatNr, Passenger pass, FoodMenu fm){
        this(seatNr, pass);
        setFoodMenu(fm);
    }

    //Masods konstruktor
    public Seat(int seatNumber) {
        this.seatNumber = seatNumber;
        this.booked = false;//true?
//        this.classStatus = ClassType.BUSINESS;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;

        //la jag till 23:e nov för grafiska
        setSeatNumber(this.getPassenger().getSeatNr());
        if(this.getSeatNumber() > 5){
            setClassStatus(ClassType.ECONOMY);
        }
        else{
            setClassStatus(ClassType.BUSINESS);
        }
        setBooked(true);
    }

    public FoodItem getFoodItem() {
        return foodItem;
    }

    public void setFoodItem(FoodItem foodItem) {
        this.foodItem = foodItem;
    }

    //ny metod jag skapar 3:e nov för att lägga till foodItemAmount
    public void addFoodItemAmount(FoodItemsAmount foodItemAmount){
        foodItemAmounts.add(foodItemAmount);
    }

    //Masods toString()
    @Override
    public String toString() {
        return "Seat{" + "classStatus=" + classStatus + ", seatNumber=" + seatNumber + ", booked=" + booked + ", foodItemAmounts=" + foodItemAmounts + '}';
    }

    //Masods getters o setters
    public boolean isBooked() {
        return booked;
    }

    public void setBooked(boolean booked) {
        this.booked = booked;
    }

    public ClassType getClassStatus() {
        return classStatus;
    }

    public void setClassStatus(ClassType classStatus) {
        this.classStatus = classStatus;
    }

    //nya 23/11 för grafiska
    public FoodMenu getFoodMenu() {
        return foodMenu;
    }

    public void setFoodMenu(FoodMenu foodMenu) {
        this.foodMenu = foodMenu;
    }
}
