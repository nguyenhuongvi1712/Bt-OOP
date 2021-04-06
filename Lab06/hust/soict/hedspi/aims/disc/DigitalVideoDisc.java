package hust.soict.hedspi.aims.disc;

import hust.soict.hedspi.aims.media.Media;

public class DigitalVideoDisc extends Media {
    private String director;
    private int length;

    public DigitalVideoDisc(){};

    public DigitalVideoDisc(int id,String title){
        super(id,title);
    }

    public DigitalVideoDisc(int id,String title, String category){
        super(id,title, category);
    }

    public DigitalVideoDisc(int id,String title, String category, String director){
        super(id,title, category);
        this.director = director;
    }

    public DigitalVideoDisc(int id,String title, String category, String director, int length, float cost){
        super(id,title,category,cost);
        this.director = director;
        this.length = length;
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



    @Override
    public String toString(){
        return "DVD - "+super.getTitle()+" - "+super.getCategory()+" - "+this.getDirector()+" - "+this.getLength()+" : "+super.getCost()+" $";
    }

    public boolean search (String title){
        String[] token_search = title.toLowerCase().split(" ");
        String[] token_title = title.toLowerCase().split(" ");
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
