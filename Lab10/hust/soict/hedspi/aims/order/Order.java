package hust.soict.hedspi.aims.order;

import hust.soict.hedspi.aims.exceptions.AddMediaException;
import hust.soict.hedspi.aims.exceptions.CreateOrderException;
import hust.soict.hedspi.aims.exceptions.LimitExceededException;
import hust.soict.hedspi.aims.exceptions.LuckyItemException;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.utils.MyDate;

import java.util.ArrayList;


public class Order {
    public static final int MAX_NUMBERS_ORDERED = 10;
    public static final int MAX_LIMITED_ORDERS = 5;
    public static final double XS = 0.8;
    private static int nbOrders = 0;
    private float thresholdsTotal = 300;
    private float thresholdsSale = 100;
    private int thresholdsNumOfOrders = 5;

    private ArrayList<Media> itemsOrdered = new ArrayList<Media>();
    private MyDate dateOrdered;

    public Order() throws LimitExceededException {
        if (nbOrders < MAX_LIMITED_ORDERS) {
            dateOrdered = new MyDate();
            nbOrders++;
        } else {
            throw new LimitExceededException("ERROR: The number of orders has reached its limit!");
        }
    }

    public float getThresholdsTotal() {
        return thresholdsTotal;
    }

    public void setThresholdsTotal(float thresholdsTotal) {
        this.thresholdsTotal = thresholdsTotal;
    }

    public float getThresholdsSale() {
        return thresholdsSale;
    }

    public void setThresholdsSale(float thresholdsSale) {
        this.thresholdsSale = thresholdsSale;
    }

    public int getThresholdsNumOfOrders() {
        return thresholdsNumOfOrders;
    }

    public void setThresholdsNumOfOrders(int thresholdsNumOfOrders) {
        this.thresholdsNumOfOrders = thresholdsNumOfOrders;
    }

    public ArrayList<Media> getItemsOrdered() {
        return itemsOrdered;
    }

    public void addMedia(Media media) throws AddMediaException {
        if(itemsOrdered.size() < MAX_NUMBERS_ORDERED )
            this.itemsOrdered.add(media);
        else
            throw new AddMediaException("ERROR: The list media is full !");
    }

    public void removeMedia(int id){
        this.itemsOrdered.removeIf(o->o.getId()==id);
    }

    public Media searchById(int id){
        Media media =  this.itemsOrdered.stream().filter(o->o.getId()==id).findFirst().orElse(null);
        return media;
    }

    public float totalCost() {
        float cost = 0;
        for (Media o : itemsOrdered) {
            cost += o.getCost();
        }
        return cost;
    }
    public Media getALuckyItem() throws LuckyItemException {
        if(itemsOrdered.size() >= thresholdsNumOfOrders && this.totalCost() >= thresholdsTotal) {
            if(checkOrder(this)) {
                double xs = Math.random();
                if(xs <= XS){
                    int item = 0;
                    do {
                        double rand = Math.random();
                        rand *= itemsOrdered.size();
                        item = (int)rand;
                    } while (itemsOrdered.get(item).getCost() <= this.totalCost()*thresholdsSale);
                    return itemsOrdered.get(item);
                }
                else{
                    throw new LuckyItemException("Gía trị ngẫu nhiên bé hơn xác xuất "+XS);
                }
            }else {
                throw new LuckyItemException("Tất cả hàng đều lớn hơn ngưỡng quà tặng (" +thresholdsSale + ")");
            }
        }else {
            throw new LuckyItemException("Không đủ điều kiện nhận sản phẩm may mắn\nSố sản phẩm >= " + thresholdsNumOfOrders + "\nTổng đơn hàng >= " + thresholdsTotal);
        }
    }
    public int getNumItem(){
        return itemsOrdered.size();
    }
    public void display(){
        this.itemsOrdered.forEach(o -> System.out.println(o.toString()));
    }
    private boolean checkOrder(Order order) {
        for(Media media: order.itemsOrdered) {
            if(media.getCost() <= thresholdsSale)
                return true;
        }
        return false;
    }
}



