package hust.soict.hedspi.aims.media;

import hust.soict.hedspi.aims.exceptions.PlayerException;

import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Disc{
    private String artist;
    private List<Track> tracks = new ArrayList<Track>();
    public String message;
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
    public CompactDisc(int id,String title,String category,float cost ,String artist,int length){
        super(id,title,category,cost,length);
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
    public List<Track> getTracks(){
        return tracks;
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

    public void play() throws PlayerException {
        System.out.println("Playing CD: " + this.getTitle());
        message = "Playing CD: " + this.getTitle() + "\nCD length: " + this.getLength();
        if(this.getLength() > 0) {
            System.out.println("CD length: " + this.getLength());
            for(Track track: tracks) {
                try{
                    track.play();
                    message += track.getMessage();
                }catch (PlayerException e){
                    throw e;
                }
            }
        }else {
            throw new PlayerException("ERROR: CD length is non-positive");
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
