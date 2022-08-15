package mememagic2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MemeTest {

private Meme myMeme;
private User testUser;
private BackgroundImage testBackground;
private Rating[] testRatings;
private Rating testRating;

	
	@Before
	public void setUp() throws Exception {
		//System.out.println("Before");
		this.testUser = new User();
		this.testBackground = new BackgroundImage("imageFileName","title","description");
		this.testRatings = new Rating[10];
		this.testRating = new Rating();
		this.myMeme = new Meme(testUser,testBackground,"caption");
		

	}
	
	@Test
	public void setAndGetCreatorTest() {
		myMeme.setCreator(testUser);
		assertEquals(testUser, myMeme.getCreator());
	}
	
	@Test
	public void setAndGetBackgroundImageTest() {
		myMeme.setBackgroundImage(testBackground);
		assertEquals(testBackground, myMeme.getBackgroundImage());
	}
	@SuppressWarnings("deprecation")
	@Test
	public void setAndGetRatingsTest() {
		myMeme.setRatings(testRatings);
		assertEquals(testRatings, myMeme.getRatings());
	}
	
	@Test
	public void setAndGetCaptionTest() {
		String caption = "testCaption";
		myMeme.setCaption(caption);
		assertEquals(caption, myMeme.getCaption());
	}
	
	@Test
	public void setAndGetCaptionVerticalAlignTest() {
		String captionVerticalAlign = "top";
		myMeme.setCaptionVerticalAlign(captionVerticalAlign);
		assertEquals(captionVerticalAlign, myMeme.getCaptionVerticalAlign());
	}
	@Test
	public void setCaptionVerticalAlignTestFalse() {
		String captionVerticalAlignFail = "invalid string";
		assertEquals(false, myMeme.setCaptionVerticalAlign(captionVerticalAlignFail));
	}
	
	@Test
	public void setAndGetSharedTest() {
		myMeme.setShared(true);
		assertEquals(true, myMeme.getShared());
	}
	
	@Test
	public void addRatingTestv1() {
		int numRatings = myMeme.getRatings().length;
		myMeme.addRating(testRating);
		assertEquals(numRatings, myMeme.getRatings().length);
	}
	
	@Test
	public void addRatingTestv2() {
		Meme newMeme = new Meme(testUser,testBackground,"caption");
		int numRatings = newMeme.getRatings().length;
		newMeme.addRating(testRating);
		assertEquals(numRatings, newMeme.getRatings().length);
	}
	
	@Test
	public void calculateOverallRatingTest() {
		User user1 = new User();
		User user2 = new User();
		User user3 = new User();
		Rating testRating1 = new Rating(user1, 1);
		Rating testRating2 = new Rating(user2, 1);
		Rating testRating3 = new Rating(user3, -1);
		myMeme.addRating(testRating1);
		myMeme.addRating(testRating2);
		myMeme.addRating(testRating3);
		
		assertEquals(1.0, myMeme.calculateOverallRating(), 0.001);
	}
	
	@Test
	public void toStringTestv0() {
		assertEquals("testBackground + caption [+1: 2, -1: 1]",myMeme.toString());
	}
	
	
	@Test
	public void equalsTestv0() {
		assertFalse(myMeme.equals(null));
	}
	
	@Test
	public void equalsTestv1() {
		assertTrue(myMeme.equals(myMeme));
	}
	
	@Test
	public void equalsTestv2() {
		assertFalse(myMeme.equals(testUser)); 
	}
	
	@Test
	public void equalsTestv3() {
		Meme nullMeme = new Meme(null,null,null);
		assertFalse(nullMeme.equals(myMeme));
	}
	
	@Test
	public void equalsTestv4() {
		BackgroundImage image1 =  new BackgroundImage("imageFileNames","titles","descriptions");
		Meme nullMeme = new Meme(null,image1,null);
		assertFalse(nullMeme.equals(myMeme));
	}
	
	@Test
	public void equalsTestv5() {
		Meme nullMeme = new Meme(null,testBackground,null);
		assertFalse(nullMeme.equals(myMeme));
	}
	
	@Test
	public void equalsTestv6() {
		Meme nullMeme = new Meme(null,testBackground,"captions");
		assertFalse(nullMeme.equals(myMeme));
	}
	@Test
	public void equalsTestv7() {
		Meme nullMeme = new Meme(null,testBackground,"caption");
		assertFalse(nullMeme.equals(myMeme));
	}
	
	@Test
	public void equalsTestv8() {
		User testUser2 = new User();
		Meme nullMeme = new Meme(testUser2,testBackground,"caption");
		assertFalse(nullMeme.equals(myMeme));
	}
	
	@Test
	public void equalsTestv9() {
		Meme nullMeme = new Meme(testUser,testBackground,"caption");
		assertTrue(nullMeme.equals(myMeme));
	}
}