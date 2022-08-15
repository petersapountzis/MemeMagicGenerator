/**
 * <h1>Feed</h1>
 * This is the Feed class. It has methods that pertain new memes and feed. 
 * @author PeterSapountzis
 * @author ZacharyWiel
 * @version 2.0
 * @since 2022-05-03
 */
 
package mememagic2;
import java.util.ArrayList;

public class Feed {
    private ArrayList<Meme> memes;

    public Feed(){
        this.memes=new ArrayList<Meme>();
    }

    
    /** 
     * returns arrayList of all memes
     * @return ArrayList (type: meme)
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
                 return meme;
             }
         }
         return null;
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

