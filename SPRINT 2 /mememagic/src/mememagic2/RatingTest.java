package mememagic2;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;


public class RatingTest {
	private Rating myRatingDefault;
	private Rating myRatingConst;
	private User testUser;

	
	@Before
	public void setUp() throws Exception {
		//System.out.println("Before");
		this.myRatingDefault = new Rating();
		this.testUser = new User();
		this.myRatingConst = new Rating(testUser,1);
		

	}
	
	@Test 
	public void setAndGetScoreTest() {
		int score = -1;
		myRatingConst.setScore(score);
		assertEquals(score, myRatingConst.getScore());
	}
	
	@Test
	public void setScoreFailTest() {
		int score = 2;
		myRatingConst.setScore(score);
		assertEquals(0, myRatingConst.getScore());
	}
	
	@Test
	public void setAndGetUserTest() {
		myRatingDefault.setUser(testUser);
		assertEquals(testUser, myRatingDefault.getUser());
	}
	
	@Test
	public void toStringUpvoteTest() {
		myRatingDefault.setScore(1);
		assertEquals("Rating was a upvote",myRatingDefault.toString());
	}

	@Test
	public void toStringDownvoteTest() {
		myRatingDefault.setScore(-1);
		assertEquals("Rating was a downvote",myRatingDefault.toString());
	}
	
	@Test
	public void toStringPassTest() {
		myRatingDefault.setScore(0);
		assertEquals("Rating was a pass",myRatingDefault.toString());
	}
	
	@Test
	public void equalsTestv0() {
		assertFalse(myRatingConst.equals(null));
	}
	
	@Test
	public void equalsTestv1() {
		assertTrue(myRatingConst.equals(myRatingConst));
	}
	
	@Test
	public void equalsTestv2() {
		User testUser1 = new User();
		assertFalse(myRatingConst.equals(testUser1));
	}
	
	@Test
	public void equalsTestv3() {
		Rating nullRating = new Rating(null,0);
		assertFalse(nullRating.equals(myRatingConst));
	}
	
	@Test
	public void equalsTestv4() {
		Rating nullRating = new Rating(null,1);
		assertFalse(nullRating.equals(myRatingConst));
	}
			
	@Test
	public void equalsTestv5() {
		User testUser2 = new User();
		Rating nullRating = new Rating(testUser2,1);
		assertFalse(nullRating.equals(myRatingConst));
	}
	
	@Test
	public void equalsTestv6() {
		Rating nullRating = new Rating(testUser,1);
		assertTrue(nullRating.equals(myRatingConst));
	
	}
			
			
	
	
	
}
