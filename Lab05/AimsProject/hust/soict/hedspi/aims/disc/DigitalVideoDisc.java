package hust.soict.hedspi.aims.disc;

public class DigitalVideoDisc {
    private String title;
    private String category;
    private String director;
    private int length;
    private float cost;

    public DigitalVideoDisc(){};

    public DigitalVideoDisc(String title){
        this.title = title;
    }

    public DigitalVideoDisc(String title, String category){
        this.title = title;
        this.category = category;
    }

    public DigitalVideoDisc(String title, String category, String director){
        this.title = title;
        this.category = category;
        this.director = director;
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost){
        this.title = title;
        this.category = category;
        this.director = director;
        this.length = length;
        this.cost = cost;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    @Override
    public String toString(){
        return "DVD - "+this.getTitle()+" - "+this.getCategory()+" - "+this.getDirector()+" - "+this.getLength()+" : "+this.getCost()+" $";
    }

    public boolean search (String title){
        String[] token_search = title.toLowerCase().split(" ");
        String[] token_title = this.title.toLowerCase().split(" ");
        int flag = 0;
        for(int i = 0 ; i < token_search.length; i ++){
            for (int j = 0; j < token_title.length ; j++){
                if(token_search[i].equals(token_title[j])){
                    flag ++ ;
                    break;
                }
            }
        }
        if(flag == token_search.length)
            return true;
        else
            return false;
    }
}
