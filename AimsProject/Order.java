package AimsProject;

public class Order {
    public static final int MAX_NUMBERS_ORDERED = 10;
    private DigitalVideoDisc itemOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    private int qtyOrdered = 0 ;

    public int getQtyOrdered(){
        return this.qtyOrdered;
    }

    public void setQtyOrdered(int qtyOrdered){
        this.qtyOrdered = qtyOrdered;
    }

    public void addDigitalVideoDisc(DigitalVideoDisc disc){
        if(qtyOrdered >= MAX_NUMBERS_ORDERED -1)
            System.out.println("The order is almost full !");
        else{
            int i = this.qtyOrdered;
            itemOrdered[i] = disc;
            this.setQtyOrdered(++i);
            System.out.println("The disc has been added .");
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
