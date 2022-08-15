package mememagic2;
import static org.junit.Assert.*;
import java.util.ArrayList;

import org.junit.Test;
import org.junit.Before;


public class UserTest {
	private User myUser;

	
	@Before
	public void setUp() throws Exception {
		//System.out.println("Before");
		this.myUser = new User();

	}
	
	@Test
	public void setAndGetUserNameTest() {
		String userName = "Peter";
		myUser.setUserName(userName);
		assertEquals(userName, myUser.getUserName());
	}
	
	@Test
	public void setAndGetMemesCreatedTest() {
		ArrayList<Meme> meme1 = new ArrayList<Meme>();
		myUser.setMemesCreated(meme1);
		assertEquals(meme1, myUser.getMemesCreated());
	}
	
	@Test
	public void setAndGetMemesViewedTest() {
		ArrayList<Meme> memes1 = new ArrayList<Meme>();
		myUser.setMemesViewed(memes1); 
		assertEquals(memes1, myUser.getMemesViewed()); 
	}
	@Test 
	public void rateMemeTest() {
		BackgroundImage image = new BackgroundImage("x", "y", "z");
	    User Peter = new User("Peter");
		Meme meme = new Meme(Peter, image, "caption");
		int score = 1;
		Rating rating = new Rating(Peter, score);
		Peter.rateMeme(meme, score); 
		meme.addRating(rating); 
	
		assertEquals(rating, meme.getRatings()[2]);
	}
	
	@Test
	public void createMemeTest() {
		BackgroundImage image = new BackgroundImage("x", "y", "z");
	    Meme meme = myUser.createMeme(image, "caption");
	    ArrayList<Meme> memes100 = new ArrayList<Meme>();
	    memes100.add(meme);
	    
	    assertEquals(meme, memes100.get(0));  
	}

	@Test
	public void deleteMemeTest() {
		BackgroundImage image = new BackgroundImage("x", "y", "z");
	    Meme meme = myUser.createMeme(image, "caption");
	    //ArrayList<Meme> memesCreatedTest = new ArrayList<Meme>();
	    //memesCreatedTest.add(Meme1);
	    
	    
	    assertEquals(true, myUser.deleteMeme(meme));
	}
	
	@Test
	public void deleteMemeTestv2() {
		BackgroundImage image = new BackgroundImage("x", "y", "z");
		User Peter = new User("Peter");
	    Meme Meme1 = new Meme(Peter, image, "dfr");
	    //ArrayList<Meme> memesCreatedTest = new ArrayList<Meme>();
	    
	    assertEquals(false, myUser.deleteMeme(Meme1));
	}
		
	@Test
	public void shareMemeTest() {
		Feed feed1 = new Feed();
		User Peter = new User("Peter");
		BackgroundImage image = new BackgroundImage("x", "y", "z");
		Meme meme = new Meme(Peter, image, "caption");
		myUser.shareMeme(meme, feed1);
		
		assertEquals(meme, feed1.getMemes().get(0));
	}
	
	@Test
	public void rateNextMemeFromFeedTest() {
		Feed feed1 = new Feed();
		User Peter = new User("Peter");
		BackgroundImage image1 = new BackgroundImage("x", "y", "z");
	    BackgroundImage image2 = new BackgroundImage("x", "y", "z");
	    Meme meme1 = new Meme(Peter, image1, "caption");
	    Meme meme2 = new Meme(Peter, image2, "caption");
		Peter.shareMeme(meme1, feed1);
		Peter.shareMeme(meme2, feed1);
		
		myUser.rateNextMemeFromFeed(feed1, -1);
		myUser.rateNextMemeFromFeed(feed1, 1);
		
		assertEquals(meme1.getRatings()[0].getScore(), -1);
		//assertEquals(meme2.getRatings()[0].getScore(), 1);
		
		
	}
	
	@Test
	public void calculateReputationTest() {
		User tester = new User("tester");
		User Peter = new User("Peter");
		User Zachary = new User("Zachary");
		BackgroundImage image = new BackgroundImage("x","y","z");
		Meme test = new Meme(tester, image, "abc");
		
		Peter.rateMeme(test,1);
		Zachary.rateMeme(test, 1);
		 
		ArrayList<Meme> created = new ArrayList<Meme>();
		created.add(test);
		tester.setMemesCreated(created);
		
		
		assertEquals(1.0, tester.calculateReputation(), .0001);
		
	}
	
	@Test
	public void toStringTest() {
		User Peter = new User("Peter");
	    User Zachary = new User("Zachary");
		BackgroundImage image1 = new BackgroundImage("x", "y", "z");
	    BackgroundImage image2 = new BackgroundImage("x", "y", "z");
	    Meme Meme1 = myUser.createMeme(image2, "caption");
	    Meme Meme2 = myUser.createMeme(image1, "caption");
	    Meme Meme3 = myUser.createMeme(image1, "caption");
	    Meme Meme4 = myUser.createMeme(image2, "caption");
	   
	    Peter.rateMeme(Meme1, 1);
	    Peter.rateMeme(Meme2, 1);
	    Peter.rateMeme(Meme3, 1);
	    Peter.rateMeme(Meme4, 1);
	    Zachary.rateMeme(Meme1, 1);
	    Zachary.rateMeme(Meme2, 1);
	    Zachary.rateMeme(Meme3, 1);
	    Zachary.rateMeme(Meme4, 1);
	    
	    
	    assertEquals(myUser.toString(), "null has rated 0 memes, 2.0");
	}
	
	@Test
	public void equalsTest() {
		assertEquals(myUser.equals(myUser), true);
	}
	
			
			
			
			
			
	
	
	
}