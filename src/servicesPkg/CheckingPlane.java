package servicesPkg;

import airplanePkg.Airplane;
import airplanePkg.Seat;

/**
 * Created by User on 2016-11-23.
 */
public class CheckingPlane {

    public boolean isPlaneFullyBooked(Airplane plane){
        boolean full = true;
        if(plane.getSeats().size() < 10){
            full = false;
        }
        else{
            for(Seat planeSeat : plane.getSeats()){
                if(planeSeat.isBooked() == false){
                    full = false;
                    break;
                }
            }
        }

        return full;
    }
}
