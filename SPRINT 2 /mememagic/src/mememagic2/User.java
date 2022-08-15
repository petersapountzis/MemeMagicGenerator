/**
 * <h1>User</h1>
 * This is the User class. It has methods for users to rate memes, store whether they have viewed a meme, etc. 
 * @author PeterSapountzis
 * @author ZacharyWiel
 * @version 2.0
 * @since 2022-05-03
 */

package mememagic2;
import java.util.ArrayList;

public class User {
    private String userName;
    protected ArrayList<Meme> memesCreated;
    protected ArrayList<Meme> memesViewed;

    public User(){
        this.userName=null;
        this.memesCreated = new ArrayList<Meme>();
        this.memesViewed = new ArrayList<Meme>();
    }

    public User(String userName){
        this.userName=userName;
        this.memesCreated = new ArrayList<Meme>();
        this.memesViewed = new ArrayList<Meme>();
    }

    
    /** 
     * getter method for userName
     * @return String
     */
    public String getUserName(){
        return userName;
    } 

    
    /** 
     * setter method for userName
     * @param userName
     */
    public void setUserName(String userName){
        this.userName=userName;
    }

    
    /** 
     * returns an ArrayList of all created memes
     * @return ArrayList<Meme>
     */
    public ArrayList<Meme> getMemesCreated(){
        return memesCreated;
    }

    
    /** 
     * sets an ArrayList of all memes created
     * @param memesCreated
     */
    public void setMemesCreated(ArrayList<Meme> memesCreated){
        this.memesCreated = memesCreated;
    }

    
    /** 
     * returns an ArrayList of all viewed memes
     * @return ArrayList<Meme>
     */
    public ArrayList<Meme> getMemesViewed(){
        return memesViewed;
    }

    
    /** 
     * sets an ArrayList of all viewed memes
     * @param memesViewed
     */
    public void setMemesViewed(ArrayList<Meme> memesViewed){
        this.memesViewed = new ArrayList<Meme>(memesViewed);
    }

    
    /** 
     * allows a user to rate a meme
     * @param meme
     * @param rating
     */
    public void rateMeme(Meme meme, int rating){
        Rating ratingObj = new Rating(this, rating);
        ratingObj.setScore(rating);
        meme.addRating(ratingObj); 
        memesViewed.add(meme);
    }
    
    /** 
     * creates an instance of a meme
     * @param backGroundImage
     * @param title
     * @return Meme
     */
    public Meme createMeme(BackgroundImage backGroundImage, String title){
        Meme meme = new Meme (this, backGroundImage, title);
        memesCreated.add(meme);
        return meme;
    }
    
    /** 
     * deletes instance of meme
     * @param meme
     * @return boolean
     */
    public boolean deleteMeme(Meme meme){
        if(memesCreated !=  null && memesCreated.contains(meme) && meme.getShared() == false){
            memesCreated.remove(meme);
            return true;
        }
        return false;
    }

    
    /** 
     * adds meme to arrayList of memes
     * @param meme
     * @param feed
     */
    public void shareMeme(Meme meme, Feed feed){
        meme.setShared(true); //shares meme
        feed.getMemes().add(meme); //adds meme to memes arrayList and sets feed to new arrayList
    }

    
    /** 
     * rates the next meme
     * @param feed
     * @param num
     * @return boolean
     */
    public boolean rateNextMemeFromFeed(Feed feed, int num){ 
        try {
            rateMeme(feed.getNewMeme(this),num);
            return true;
        } catch (Exception e) {
            return false;
        }
        //error handling if there are no more memes
    }

    
    /** 
     * returns the average rating for all memes created by user
     * @return double
     */
    public double calculateReputation(){
        double sum =  0.0;
        if (memesCreated != null){
            for (Meme meme: memesCreated)
                sum = sum + meme.calculateOverallRating();
        }
        return sum / memesCreated.size();
    }

    
    /** 
     * toString
     * @return String
     */
    @Override
    public String toString(){
        String s = String.format("%s,has rated (%d) memes, (%f)", userName,memesViewed.size(),calculateReputation());
        return s;
    }
    
    
    /** 
     * inherited equals method
     * @param obj
     * @return boolean
     */
    @Override
    public boolean equals (Object obj){
        return super.equals(obj);
    }

}
