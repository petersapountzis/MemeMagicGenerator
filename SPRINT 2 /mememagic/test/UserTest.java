import junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import org.junit.Test;

public class UserTest {

	@Before
	public void setUp() {
		User myUser = new User();

	}
	
	@Test
	public void setAndGetUserNameTest() {
		String userName = "Peter";
		myUser.setUserName(userName);
		assertEquals(userName, myUser.getUserName());
	}
	
	@Test
	public void setAndGetMemesCreatedTest() {
		ArrayList<Meme> memes = new ArrayList<Meme>();
		myUser.setMemesCreated(memes);
		assertEquals(memes, myUser.getMemesCreated());
	}
	
	@Test
	public void setAndGetMemesViewedTest() {
		ArrayList<Meme> memes1 = new ArrayList<Meme>();
		myUser.setMemesViewed(memes1);
		assertEquals(memes1, myUser.getMemesViewed());
	}

	@Test
	public void rateMemeTest() {
		int rating = 1;
		Meme meme1 = new Meme();
		myUser.rateMeme(meme1, rating);
		assertEquals(myUser.getScore(),rating )
	}
	
	@Test
	public void createMemeTest() {
		
	}

	@Test
	public void deleteMemeTest() {
		
	}
	
	@Test
	public void shareMemeTest() {
		
	}
	
	@Test
	public void rateNextMemeFromFeedTest() {
		
	}
	
	@Test
	public void calculateReputationTest() {
		
	}
	
	@Test
	public void toStringTest() {
		
	}
	
	@Test
	public void equalsTest() {
		
	}
			
			
			
			
			
			
			
	
	