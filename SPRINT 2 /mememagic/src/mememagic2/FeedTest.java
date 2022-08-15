package mememagic2;

import static org.junit.Assert.*;
import java.util.ArrayList;


import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

public class FeedTest {
	
	private Feed myFeed;
	@Before
	public void setUp() throws Exception {
		myFeed = new Feed();
	}

	@Test
	public void setAndGetMemesTest() {
		ArrayList<Meme> meme = new ArrayList<Meme>();
		myFeed.setMemes(meme);
		assertEquals(meme, myFeed.getMemes());
	}
	
	@Test
	public void getNewMemeTest() {
		User Peter = new User("Peter");
		User Zachary = new User("Zachary");
		BackgroundImage image1 = new BackgroundImage("pepe.png", "pepe", "image of a frog");
		BackgroundImage image2 = new BackgroundImage("doge.png", "doge", "image of a dog");
		Meme meme1 = new Meme(Peter, image1, "x");
		Meme meme2 = new Meme(Peter, image2, "y");
		Peter.shareMeme(meme1, myFeed);
		Peter.shareMeme(meme2, myFeed);

		
		ArrayList<Meme> viewed = new ArrayList<Meme>();
		viewed.add(meme1);
		Zachary.setMemesViewed(viewed);
		
		assertEquals(meme2, myFeed.getNewMeme(Zachary));
	}
	 
	@Test
	public void getNewMemeTestv2() {
		User Peter = new User("Russell");
		User Zachary = new User("Zach");
		BackgroundImage i1 = new BackgroundImage("x","y","z");
		BackgroundImage i2 = new BackgroundImage("x","y","z");
		Meme meme1 = new Meme(Peter, i1, "z");
		Meme meme2 = new Meme(Peter, i2,"x");
		Meme meme3 = new Meme(Peter, i2, "y");
		
		Peter.shareMeme(meme1, myFeed);
		Peter.shareMeme(meme2, myFeed);
		Peter.shareMeme(meme3, myFeed);

		
		
		Zachary.rateMeme(meme1, 0);
		Zachary.rateMeme(meme2, 0);
		Zachary.rateMeme(meme3, 0);
		
		
		myFeed.getNewMeme(Zachary);
	
	}
	@Test
	public void toStringTest() {
		User Peter = new User("Peter");
		BackgroundImage image1 = new BackgroundImage("tree.jpeg", "wow", "green tree");
		BackgroundImage image2 = new BackgroundImage("bush.png", "hello", "purple bush");
		Meme meme1 = new Meme(Peter, image1, "wow");
		Meme meme2 = new Meme(Peter, image2, "hello");
		
		Peter.shareMeme(meme1, myFeed);
		Peter.shareMeme(meme2, myFeed);
		
	
		
		assertEquals(myFeed.toString(), 
				"wow <green tree> 'tree' 0.0 [+1: 0, -1: 0] - created by Peter\nhello <purple bush>  'hello' 0.0 [+1: 0, -1: 0] - created by Peter\n");
	}
}

