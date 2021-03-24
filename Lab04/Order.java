package Lab04;


public class Order {
    public static final int MAX_NUMBERS_ORDERED = 10;
    public static final int MAX_LIMITED_ORDERS = 5;
    private static int nbOrders = 0 ;
    private DigitalVideoDisc itemOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    private int qtyOrdered = 0  ;
    private MyDate dateOrdered ;

    public Order(){
        if(nbOrders < MAX_LIMITED_ORDERS) {
            dateOrdered = new MyDate();
            nbOrders ++ ;
        }
        else{
            System.out.println("The current number of orders is over this limited number,cannot make any new order.");
        }
    }
    public int getQtyOrdered(){
        return this.qtyOrdered;
    }

    public void setQtyOrdered(int qtyOrdered){
        this.qtyOrdered = qtyOrdered;
    }

    public void addDigitalVideoDisc(DigitalVideoDisc disc){
        if(qtyOrdered >= MAX_NUMBERS_ORDERED )
            System.out.println("The item quantity has reached its limit");
        else{
            int i = this.qtyOrdered;
            itemOrdered[i] = disc;
            this.setQtyOrdered(++i);
            System.out.println("The disc "+ disc.getTitle()+ " has been added .");
        }
    }
    public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList){
        if((dvdList.length > MAX_NUMBERS_ORDERED - qtyOrdered) && dvdList != null){
           System.out.println("The list of items that cannot be added to the current order because of full ordered items");
        }
        else{
            for(int i = 0 ; i < dvdList.length ; i++){
               addDigitalVideoDisc(dvdList[i]);
            }
        }
    }
    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2){
        if(MAX_NUMBERS_ORDERED - qtyOrdered < 2){
            if(MAX_NUMBERS_ORDERED - qtyOrdered == 1){
                addDigitalVideoDisc(dvd1);
                System.out.println("The dvd "+ dvd2.getTitle()+" could not be added . ");
            }
            else {
                System.out.println("The item quantity has reached its limit");
            }
        }
        else{
            addDigitalVideoDisc(dvd1);
            addDigitalVideoDisc(dvd2);
        }
    }
    public void removeDigitalVideoDisc(DigitalVideoDisc disc){
        for(int i =0 ; i < qtyOrdered ; i++){
            if(itemOrdered[i].getTitle().equals(disc.getTitle())){
                itemOrdered[i] = itemOrdered[i+1];
                qtyOrdered --;
                break;
            }
        }
    }

    public float totalCost(){
        float cost = 0;
        for(int i = 0 ; i < this.qtyOrdered ; i++){
                cost += this.itemOrdered[i].getCost();
        }
        return cost;
    }

    public void print(){
        System.out.println("Date: " +dateOrdered.toString());
        System.out.println("Ordered Items : ");
        for (int i = 0 ; i < qtyOrdered;i++){
            System.out.println(i+1+" "+itemOrdered[i].toString());
        }
        System.out.println("Total cost: "+totalCost());
    }

    public DigitalVideoDisc searchDiscByTitle(String title){
        for(int i =0 ; i < qtyOrdered ; i++){
            if(itemOrdered[i].getTitle().equals(title)){
               return itemOrdered[i];
            }
        }
        return null;
    }

    public int getCountOfSearchTitle(String title){
        int cnt = 0;
        for(int i =0 ; i < qtyOrdered ; i++){
            if(itemOrdered[i].getTitle().equals(title)){
                cnt ++;
            }
        }
        return cnt;
    }

}
