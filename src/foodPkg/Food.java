package foodPkg;

/**
 * Created by Jimmy on 2016-11-23.
 */

//ny av mig för grafiska
public class Food {

    private int price;
    private String foodTitel;

    public Food(){

    }

    public Food(int price, String foodTitel){
        this.price = price;
        this.foodTitel = foodTitel;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getFoodTitel() {
        return foodTitel;
    }

    public void setFoodTitel(String foodTitel) {
        this.foodTitel = foodTitel;
    }
}
