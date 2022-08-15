/**
 * This is the Feed class. It has methods that pertain new memes and feed. 
 * @author Peter Sapountzis
 * @author Zachary Wiel
 * @version 2.0
 * @since 2022-05-03
 */

import java.util.ArrayList;

public class Feed {
    private ArrayList<Meme> memes;

    public Feed(){
        this.memes=new ArrayList<Meme>();
    }

    
    /** 
     * returns arrayList of all memes
     * @return ArrayList<Meme>
     */
    public ArrayList<Meme> getMemes(){
        return memes;
    }

    
    /** 
     * sets arrayList of all memes
     * @param memes
     */
    public void setMemes(ArrayList<Meme> memes){
        this.memes = memes;
    }

    
    /** 
     * returns a meme that has not been viewed by the user
     * @param user
     * @return Meme
     */
    public Meme getNewMeme(User user){
       for (Meme meme: getMemes()){
           if (!user.getMemesViewed().contains(meme) && !user.getMemesCreated().contains(meme)){
               // if the user didn't create the memne or view it already it will return it
               return meme;
           }
       }
       // or it will create a new meme
        Meme meme1 = new Meme(user, null, null);
        return meme1;
    }

    
    /** 
     * toString
     * @return String
     */
    @Override
    public String toString(){
        String str = null;
        for(Meme meme:memes)
        {
            str=meme.toString()+"\n";
        }
        return str;
    }


    
}

