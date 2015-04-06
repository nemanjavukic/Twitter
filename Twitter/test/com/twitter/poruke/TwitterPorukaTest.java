/**
 * 
 */
package com.twitter.poruke;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Nemanja
 *
 */
public class TwitterPorukaTest {
	private TwitterPoruka poruka;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		poruka=new TwitterPoruka();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		poruka=null;
	}

	/**
	 * Test method for {@link com.twitter.poruke.TwitterPoruka#setKorisnik(java.lang.String)}.
	 */
	@Test
	public void testSetKorisnik() {
		poruka.setKorisnik("Nemanja");
		assertEquals("Nemanja", poruka.getKorisnik());
	}
	
   /**
    * Test method for {@link com.twitter.poruke.TwitterPoruka#setKorisnik(java.lang.String)}.
    */
		@Test (expected = java.lang.RuntimeException.class)
		public void testSetKorisnikNull() {
			poruka.setKorisnik(null);
		}
		
    /**
     * Test method for {@link com.twitter.poruke.TwitterPoruka#setKorisnik(java.lang.String)}.
     */
    @Test (expected = java.lang.RuntimeException.class)
    public void testSetKorisnikEmpty() {
    poruka.setKorisnik("");
			}

	/**
	 * Test method for {@link com.twitter.poruke.TwitterPoruka#setPoruka(java.lang.String)}.
	 */
	@Test
	public void testSetPoruka() {
		poruka.setPoruka("Ovo je poruka");
		assertEquals("Ovo je poruka", poruka.getPoruka());
	}
	
	/**
	  * Test method for {@link com.twitter.poruke.TwitterPoruka#setPoruka(java.lang.String)}.
	  */
		@Test (expected = java.lang.RuntimeException.class)
		public void testSetPorukaPrekoracenje() {
			poruka.setPoruka("Ovo je porukaOvo je porukaOvo je porukaOvo je porukaOvo je porukaOvo je porukaOvo je porukaOvo je porukaOvo je porukaOvo je porukaOvo je porukaOvo je porukaOvo je porukaOvo je porukaOvo je porukaOvo je poruka");
		}
	
	/**
	 * Test method for {@link com.twitter.poruke.TwitterPoruka#setPoruka(java.lang.String)}.
	 */
		@Test (expected = java.lang.RuntimeException.class)
		public void testSetPorukaNull() {
			poruka.setPoruka(null);
		}
		

	/**
	 * Test method for {@link com.twitter.poruke.TwitterPoruka#toString()}.
	 */
	@Test
	public void testToString() {
		poruka.setKorisnik("Nemanja");
		poruka.setPoruka("Ovo je poruka");
		assertEquals("KORISNIK:"+poruka.getKorisnik()+" PORUKA:"+poruka.getPoruka(), poruka.toString());		
				
	}

}
