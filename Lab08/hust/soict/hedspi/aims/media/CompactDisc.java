package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Disc{
    private String artist;
    private List<Track> tracks = new ArrayList<Track>();

    public CompactDisc(String artist, List<Track> tracks) {
        this.artist = artist;
        this.tracks = tracks;
    }

    public CompactDisc(int id, String title, String artist, List<Track> tracks) {
        super(id, title);
        this.artist = artist;
        this.tracks = tracks;
    }

    public CompactDisc(int id, String title, String category, String artist, List<Track> tracks) {
        super(id, title, category);
        this.artist = artist;
        this.tracks = tracks;
    }

    public CompactDisc(int id, String title, String category, float cost, String artist, List<Track> tracks) {
        super(id, title, category, cost);
        this.artist = artist;
        this.tracks = tracks;
    }
    public CompactDisc(int id,String title,String category,float cost ,String artist){
        super(id,title,category,cost);
        this.artist = artist;
    }
    public CompactDisc(int id, String title, String category, float cost,String director, String artist,int length) {
        super(id, title, category, cost,director,length);
        this.artist = artist;
    }

    public String getArtist() {
        return artist;
    }

    public void addTrack(Track track){
        int flag = 0;
        for(Track o : tracks){
            if(o.getTitle().equals(track.getTitle()) && o.getLength() == track.getLength()){
                flag = 1;
                break;
            }
        }
        if(flag == 0)
            tracks.add(track);
        else
            System.out.println("This track already exists in the track list");
    }

    public void removeTrack(Track track){
        int flag = 0;
        for(Track o : tracks){
            if(o.getTitle().equals(track.getTitle()) && o.getLength() == track.getLength()){
                flag = 1;
                break;
            }
        }
        if(flag == 1)
            tracks.remove(track);
        else
            System.out.println("This track not found in the track list");
    }

    public int getTracksLength(){
        int sumLength = 0 ;
        for(Track o : tracks){
            sumLength += o.getLength();
        }
        return sumLength;
    }
    public int getNumOfTrack(){
       return tracks.size();

    }

    public void play() {
        for(Track o : tracks){
            o.play();
        }
    }

    public String toString(){
        return "CV - "+super.getTitle()+" - "+super.getCategory()+" - "+this.getArtist()+" - "+this.getTracksLength()+" : "+super.getCost()+" $";
    }


    public int compareTo(Media o) {
        if(o instanceof CompactDisc){
            if(this.getNumOfTrack() > ((CompactDisc) o).getNumOfTrack())
                return 1;
            else if (this.getNumOfTrack() < ((CompactDisc) o).getNumOfTrack())
                return -1;
            else{
                if(this.getLength() > ((CompactDisc) o).getLength())
                    return 1;
                else if (this.getLength() > ((CompactDisc) o).getLength())
                    return -1;
                else
                    return super.compareTo(o);
            }
        }
        else
            return super.compareTo(o);
    }
}
