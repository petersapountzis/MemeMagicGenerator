package mememagic2;

import java.util.ArrayList;

public class Testing {

    public static void main(String[] args) {
    
        User user = new User();
        user.setUserName("UserName");
                
        BackgroundImage backgroundImage = new BackgroundImage("Image", "Title", "Descr.");
                
        Meme meme = new Meme(user, backgroundImage, "Caption");
                
        Rating rating1 = new Rating(user, 1);
        boolean isScoredAdded = rating1.setScore(-1);
        System.out.println("isScoredAdded: "+isScoredAdded);            
        boolean isRatingAdded = meme.addRating(rating1);
        System.out.println("isRatingAdded: "+isRatingAdded);
        double overAllRating = meme.calculateOverallRating();
        System.out.println("overAllRating: "+overAllRating);
        boolean isCaptionAligned = meme.setCaptionVerticalAlign("top");
        System.out.println("isCaptionAligned: "+isCaptionAligned);
                
                
        Rating rating2 = new Rating(user, 0);
        isScoredAdded = rating2.setScore(1);
        isRatingAdded = meme.addRating(rating2);
        overAllRating = meme.calculateOverallRating();
                
                
        Rating rating3 = new Rating(user, 0);
        isScoredAdded = rating3.setScore(0);    
        isRatingAdded = meme.addRating(rating3);
        overAllRating = meme.calculateOverallRating();
                
        Rating rating4 = new Rating(user, 0);
        isScoredAdded = rating4.setScore(1);    
        isRatingAdded = meme.addRating(rating4);
        overAllRating = meme.calculateOverallRating();
                
        Rating rating5 = new Rating(user, 0);
        isScoredAdded = rating5.setScore(1);    
        isRatingAdded = meme.addRating(rating5);
        overAllRating = meme.calculateOverallRating();
                
        Rating rating6 = new Rating(user, 0);
        isScoredAdded = rating6.setScore(-1);   
        isRatingAdded = meme.addRating(rating6);
        overAllRating = meme.calculateOverallRating();
                
        Rating rating7 = new Rating(user, 0);
        isScoredAdded = rating7.setScore(1);    
        isRatingAdded = meme.addRating(rating7);
        overAllRating = meme.calculateOverallRating();
                
        Rating rating8 = new Rating(user, 0);
        isScoredAdded = rating8.setScore(0);    
        isRatingAdded = meme.addRating(rating8);
        overAllRating = meme.calculateOverallRating();
                
        Rating rating9 = new Rating(user, 0);
        isScoredAdded = rating9.setScore(1);    
        isRatingAdded = meme.addRating(rating9);
        overAllRating = meme.calculateOverallRating();
                
        Rating rating10 = new Rating(user, 0);
        isScoredAdded = rating10.setScore(-1);  
        isRatingAdded = meme.addRating(rating10);
        overAllRating = meme.calculateOverallRating();
                
        System.out.println("*** *** *** *** *** *** *** *** *** ***");
        int ind = 1;
        System.out.println("Before 10 elements: ");
        for (Rating rating: meme.getRatings()) {
            System.out.println((ind++)+"."+rating);
        }
                
        Rating rating11 = new Rating(user, 0);
        isScoredAdded = rating11.setScore(-1);  
        isRatingAdded = meme.addRating(rating11);
        overAllRating = meme.calculateOverallRating();
                
        System.out.println("*** *** *** *** *** *** *** *** *** ***");
        ind = 1;
        System.out.println("Following 11 elements: ");
        for (Rating rating: meme.getRatings()) {
            System.out.println((ind++)+"."+rating);
        }
                //First downvoted rating got discarded as we added 11th element.
                
        Rating rating12 = new Rating(user, 0);
        isScoredAdded = rating12.setScore(5);
        System.out.println("isScoredAdded(expecting FALSE): "+isScoredAdded);                   //Supposed to be false as we tried setting score 5 (which is not in -1, 0, +1)
        isRatingAdded = meme.addRating(rating12);
        overAllRating = meme.calculateOverallRating();
                
        ArrayList<Meme> memesList = new ArrayList<Meme>();
        memesList.add(meme);
        user.setMemesCreated(memesList);
        user.setMemesViewed(memesList);
                
        System.out.println(user);
        System.out.println(backgroundImage);
        System.out.println(meme);    
    	
    	
    }
}

