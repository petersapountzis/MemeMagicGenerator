package mememagic2;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;


public class BackgroundImageTest {
	private BackgroundImage myBackgroundImage;

	
	@Before
	public void setUp() throws Exception {
		//System.out.println("Before");
		this.myBackgroundImage = new BackgroundImage("imageFileName","title","description");

	}
	
	@Test 
	public void setAndGetImageFileNameTest() {
		String name = "testName";
		myBackgroundImage.setImageFileName(name);
		assertEquals(name, myBackgroundImage.getImageFileName());
	}
	
	@Test
	public void setAndGetTitleTest() {
		String title = "testTitle";
		myBackgroundImage.setTitle(title);
		assertEquals(title, myBackgroundImage.getTitle());
	}
	 
	@Test
	public void setAndGetDescriptionTest() {
		String description = "testDescription";
		myBackgroundImage.setDescription(description);
		assertEquals(description, myBackgroundImage.getDescription());
	}
	
	@Test
	public void toStringTest() {
		assertEquals("title <description>",myBackgroundImage.toString());
	}
	
	@Test
	public void equalsTestv0() {
		assertFalse(myBackgroundImage.equals(null));
	}
	
	@Test
	public void equalsTestv1() {
		assertTrue(myBackgroundImage.equals(myBackgroundImage));
	}
	
	@Test
	public void equalsTestv2() {
		User testUser = new User();
		assertFalse(myBackgroundImage.equals(testUser));
	}
	
	@Test
	public void equalsTestv3() {
		BackgroundImage nullBackgroundImage = new BackgroundImage(null,null,null);
		assertFalse(nullBackgroundImage.equals(myBackgroundImage));
	}
	
	@Test
	public void equalsTestv4() {
		BackgroundImage nullBackgroundImage = new BackgroundImage(null,null,"descriptions");
		assertFalse(nullBackgroundImage.equals(myBackgroundImage));
	}
	
	@Test
	public void equalsTestv5() {
		BackgroundImage nullBackgroundImage = new BackgroundImage(null,null,"description");
		assertFalse(nullBackgroundImage.equals(myBackgroundImage));
	}
	
	@Test
	public void equalsTestv6() {
		BackgroundImage nullBackgroundImage = new BackgroundImage("imageFileNames",null,"description");
		assertFalse(nullBackgroundImage.equals(myBackgroundImage));
	}
	@Test
	public void equalsTestv7() {
		BackgroundImage nullBackgroundImage = new BackgroundImage("imageFileName",null,"description");
		assertFalse(nullBackgroundImage.equals(myBackgroundImage));
	}
	
	@Test
	public void equalsTestv8() {
		BackgroundImage nullBackgroundImage = new BackgroundImage("imageFileName","titles","description");
		assertFalse(nullBackgroundImage.equals(myBackgroundImage));
	}
	
	@Test
	public void equalsTestv9() {
		BackgroundImage nullBackgroundImage = new BackgroundImage("imageFileName","title","description");
		assertTrue(nullBackgroundImage.equals(myBackgroundImage));
	}
			
			
			
			
	
	
	
}