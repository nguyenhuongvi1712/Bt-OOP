package hust.soict.hedspi.aims.media;

import hust.soict.hedspi.aims.disc.DigitalVideoDisc;

public abstract class Media implements Comparable<Media>{
    private String title;
    private String category;
    private float cost;
    private int id;

    public Media(){};


    public Media(int id, String title){
        this.id = id;
        this.title = title;
    }
    public Media(int id,String title,String category){
        this.id = id;
        this.title = title;
        this.category = category;
    }
    public Media(int id,String title,String category,float cost){
        this.id = id;
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public float getCost() {
        return cost;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o){
        if(o instanceof Media) {
            if(id == ((Media) o).getId()){
                return true;
            }
            else
                return false;
        }
        else
            return false;
    }

    public int compareTo(Media o) {
        // Convention : DVDs > CD > Book
//        if(this instanceof DigitalVideoDisc){
//            if(o instanceof Book || o instanceof CompactDisc)
//                return 1;
//            else
//                return this.title.compareTo(((DigitalVideoDisc)o).getTitle());
//        }
//        else if (this instanceof CompactDisc){
//            if(o instanceof DigitalVideoDisc)
//                return -1;
//            else if(this instanceof Book)
//                return 1;
//            else
//                return this.title.compareTo(((CompactDisc)o).getTitle());
//        }
//        else {
//            if(o instanceof DigitalVideoDisc || o instanceof CompactDisc)
//                return -1;
//            else
//                return this.title.compareTo(((Book)o).getTitle());
//        }
        return this.title.compareTo(o.getTitle());
    }
}
