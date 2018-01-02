package airlinePkg;

import airplanePkg.Airplane;
import airplanePkg.Airport;
import airplanePkg.Seat;

/**
 * Created by Jimmy on 2016-10-31.
 * edited on 23/11
 */
public class Airline {
    double airlineIncome;
    double airlineProfit;

    int foodIncome;

    //public static void main(String[] args) {
        //Airport aPort = new Airport();
    //}

    public double calculateProfitAndIncome(int money){
        airlineIncome = airlineIncome + money;
        double profit = 0;
        profit = money * 0.3;
        airlineProfit = airlineProfit + profit;
        return profit;
    }

    public void addFoodIncome(int foodIncome){
        this.foodIncome = this.foodIncome + foodIncome;
    }

    public int[] calculatePlaneIncomeProfit(Airplane plane){
        double planeIncome = 0.0;
        double planeProfit = 0.0;
        int planeFoodIncome = 0;

        int[] incomesProfits = {0,0,0};

        for (Seat s : plane.getSeats() ) {
            int seatNr = 0;
            seatNr = s.getSeatNumber();
            if(seatNr < 6 && s.isBooked() == true){
                if(s.getFoodMenu() != null){
                    planeIncome = planeIncome + 20000 + s.getFoodMenu().getTotalFoodPrice();
                    planeProfit = planeProfit + (planeIncome * 0.3);
                    planeFoodIncome = planeFoodIncome + s.getFoodMenu().getTotalFoodPrice();
                }
                else{
                    planeIncome = planeIncome + 20000;
                    planeProfit = planeProfit + (planeIncome * 0.3);
                }
            }
            else if(seatNr > 6 && s.isBooked() == true){
                if(s.getFoodMenu() != null){
                    planeIncome = planeIncome + 5000 + s.getFoodMenu().getTotalFoodPrice();
                    planeProfit = planeProfit + (planeIncome * 0.3);
                    planeFoodIncome = planeFoodIncome + s.getFoodMenu().getTotalFoodPrice();
                }
                else{
                    planeIncome = planeIncome + 5000;
                    planeProfit = planeProfit + (planeIncome * 0.3);
                }

            }
        }

        incomesProfits[0] = (int) planeIncome;
        incomesProfits[1] = (int) planeProfit;
        incomesProfits[2] = planeFoodIncome;

        return incomesProfits;
    }

    public double getAirlineIncome() {
        return airlineIncome;
    }

    public double getAirlineProfit() {
        return airlineProfit;
    }

    public int getFoodIncome() {
        return foodIncome;
    }

    public void setFoodIncome(int foodIncome) {
        this.foodIncome = foodIncome;
    }
}
