/**
 * This is the Meme class. It has methods that pertain to the meme, such as captions and sharing compatibility. 
 * @author Peter Sapountzis
 * @author Zachary Wiel
 * @version 2.0
 * @since 2022-05-03
 */

public class Meme{
    private User creator;
    private BackgroundImage backgroundImage;
    private Rating[] ratings;
    private String caption;
    private String captionVerticalAlign;
    private boolean shared;
    static int elementsCountInRatingArr = 0;


    
    public Meme(User creator, BackgroundImage backgroundImage, String caption){
        super();
        this.creator = creator;
        this.backgroundImage = backgroundImage;
        this.caption = caption;
        this.ratings = new Rating[10];
        this.captionVerticalAlign = "bottom";

    }

    
    /** 
     * returns the creator of the meme
     * @return User
     */
    public User getCreator(){
        return creator;
    }

    
    /** 
     * sets the creator of the meme
     * @param creator
     */
    public void setCreator(User creator){
        this.creator = creator;
    }

    
    /** 
     * returns the background image of the meme
     * @return BackgroundImage
     */
    public BackgroundImage getBackgroundImage(){
        return backgroundImage;
    }

    
    /** 
     * sets the background image of the meme
     * @param backgroundImage
     */
    public void setBackgroundImage(BackgroundImage backgroundImage){
        this.backgroundImage = backgroundImage;
    }

    
    /** 
     * returns an array of ratings
     * @return Rating[]
     */
    public Rating[] getRatings(){
        return ratings;
    }

    
    /** 
     * sets an array of ratings for a meme
     * @param ratings
     */
    public void setRatings(Rating[] ratings){
        this.ratings = ratings;
    }

    
    /** 
     * returns the caption of the meme
     * @return String
     */
    public String getCaption(){
        return caption;
    }

    
    /** 
     * sets the caption for the meme
     * @param caption
     */
    public void setCaption(String caption){
        this.caption = caption;
    }

    
    /** 
     * returns the caption for the string
     * @return String
     */
    public String getCaptionVerticalAlign(){
        return captionVerticalAlign;
    }

    
    /** 
     * sets the caption for the meme
     * @param captionVerticalAlign
     * @return boolean
     */
    public boolean setCaptionVerticalAlign(String captionVerticalAlign) {
        String[] allowedPositions = new String[] {"top", "middle", "bottom"};
        for (String x:allowedPositions){ // if parameter is either top,middle,bottom it will set the variable, else it will return false
            if (x.equals(captionVerticalAlign)){
                this.captionVerticalAlign = captionVerticalAlign;
                return true;
            }
        }
        return false;
    }

    
    /** returns whether the meme has been shared
     * @return boolean
     */
    public boolean getShared(){
        return shared;
    }

    
    /** 
     * sets whether the meme has been shared
     * @param shared
     */
    public void setShared(boolean shared){
        this.shared = shared;
    }

    
    /** 
     * adds a rating to the array of ratings
     * @param rating
     * @return boolean
     */
    public boolean addRating(Rating rating) {
        if (elementsCountInRatingArr >= ratings.length) {
            for (int i=0; i<ratings.length-1; i++) {
                    ratings[i] = ratings[i+1];
            }
            ratings[ratings.length-1] = rating;
        }else {
            ratings[elementsCountInRatingArr++] = rating;
        }
        return true;
    }

    
    /** 
     * sums all ratings in the array of ratings
     * @return double
     */
    public double calculateOverallRating() {
        double result = 0;  
        //parse through all elements and sum up all ratings            
        for (int i=0; i<elementsCountInRatingArr; i++) {
            Rating rating = ratings[i];
            result += rating.getScore();
        }
        return result;
    }

    
    /** 
     * returns the number of upvotes in the array
     * @return int
     */
    private int getPositiveRatings() {
        int result = 0;
        for (Rating rating: ratings) {
            if (rating.getScore() == +1) {
                    result++;
            }
        }
        return result;
    }
    
    /** 
     * returns number of downvotes in array
     * @return int
     */
    //created private functions for negative/positive ratings in order to make my toString easier to read/make
    private int getNegativeRatings() {
        int result = 0;
        for (Rating rating: ratings) {
                if (rating.getScore() == -1) {
                        result++;
                }
        }
        return result;
    }

    
    /** 
     * toString
     * @return String
     */
    @Override
    public String toString(){
        int positiveRatings = getPositiveRatings();
        int negativeRatings = getNegativeRatings();
        return backgroundImage + " " + caption + " " + "[+1: " + positiveRatings + ", " + "-1: " + negativeRatings + "]";
    }

    
    /** 
     * overrriden equals method
     * @param obj
     * @return boolean
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Meme other = (Meme) obj;
        if (backgroundImage == null) {
            if (other.backgroundImage != null)
                return false;
        } else if (!backgroundImage.equals(other.backgroundImage))
            return false;
        if (caption == null) {
            if (other.caption != null)
                return false;
        } else if (!caption.equals(other.caption))
            return false;

        if (creator == null) {
            if (other.creator != null)
                return false;
        } else if (!creator.equals(other.creator))
            return false;

        return true;
    }
}
