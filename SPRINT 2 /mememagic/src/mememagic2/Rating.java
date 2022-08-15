/**
 * <h1>Rating</h1>
 * This is the Rating class. It has methods that pertain to returning a rating and scores for each meme. 
 * @author PeterSapountzis
 * @author ZacharyWiel
 * @version 2.0
 * @since 2022-05-03
 */

package mememagic2;
public class Rating {
    private int score;
    private User user;

    
    public Rating(){
        this.user=null;
        this.score=0;
    }
    
    public Rating(User user, int score){
        this.user=user;
        setScore(score);
    }
    
     
    /** 
     * returns rating of meme
     * @return int
     */
    public int getScore(){
        return score;
    }

    
    /** 
     * sets rating of meme
     * @param score
     * @return boolean
     */
    public boolean setScore(int score){
        if (score == -1||score== 0||score == 1){
            this.score=score;
            return true;
        } else{ 
            this.score = 0;
            //if score is incorrect set score to 0
            return false;
        }
    }

    
    /** 
     * returns user
     * @return User
     */
    public User getUser(){
        return user;
    }

    
    /** 
     * sets a user for memne
     * @param user
     */
    public void setUser(User user){
        this.user=user;
    }
    
    /** 
     * toString
     * @return String
     */
    @Override
    public String toString(){
        String type_of_rating;
        if (score==1){
            type_of_rating = "upvote";
        }else if(score==-1){
            type_of_rating = "downvote";
        }else{
            type_of_rating = "pass";
        }
        //rating must be 1,-1, or 0
        return ("Rating was a "+type_of_rating);
    }


   
    
    /** 
     * overriden equals method
     * @param obj
     * @return boolean
     */
    @Override
    public boolean equals(Object obj){
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Rating other = (Rating) obj;
        if(score != other.score)
            return false;
        if (user == null){
            if (other.user!= null)
                return false;
        }
        else if (!user.equals(other.user)){
            return false;
        }
        return true;
    }

}
