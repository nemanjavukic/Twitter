/**
 * 
 */
package com.twitter;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.twitter.poruke.TwitterPoruka;

/**
 * @author Nemanja
 *
 */
public class TwitterTest {
	private Twitter profil;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		profil= new Twitter();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		profil=null;
	}

	/**
	 * Test method for {@link com.twitter.Twitter#vratiSvePoruke()}.
	 */
	@Test
	public void testVratiSvePoruke() {
		 LinkedList<TwitterPoruka> poruke =
				new LinkedList<TwitterPoruka>();
		assertEquals(poruke, profil.vratiSvePoruke());
	}

	/**
	 * Test method for {@link com.twitter.Twitter#unesi(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testUnesi() {
		profil.unesi("Nemanja", "Ovo je poruka");
				
	assertEquals(1, profil.vratiSvePoruke().size());
	assertEquals("Nemanja", profil.vratiSvePoruke().get(0).getKorisnik());
	assertEquals("Ovo je poruka", profil.vratiSvePoruke().get(0).getPoruka());
			
	}
	
	/**
	  * Test method for {@link com.twitter.Twitter#unesi(java.lang.String, java.lang.String)}.
	  */
		@Test
		public void testUnesi2unosa() {
			
			profil.unesi("Nemanja", "Ovo je poruka");
			profil.unesi("Nemanja2", "Ovo je poruka2");
			
			assertEquals(2, profil.vratiSvePoruke().size());
			
			assertEquals("Nemanja", profil.vratiSvePoruke().get(0).getKorisnik());
			assertEquals("Ovo je poruka", profil.vratiSvePoruke().get(0).getPoruka());
			
			assertEquals("Nemanja2", profil.vratiSvePoruke().get(1).getKorisnik());
			assertEquals("Ovo je poruka2", profil.vratiSvePoruke().get(1).getPoruka());
		}
		
	 /**
		* Test method for {@link com.twitter.Twitter#unesi(java.lang.String, java.lang.String)}.
	    */
			@Test (expected = java.lang.RuntimeException.class)
			public void testUnesiNull() {
				
				profil.unesi(null, null);
		
			}
			
	 /**
	    * Test method for {@link com.twitter.Twitter#unesi(java.lang.String, java.lang.String)}.
		*/
			@Test (expected = java.lang.RuntimeException.class)
			public void testUnesiEmpty() {
				
				profil.unesi("","");
		
			}
			
	/**
	    * Test method for {@link com.twitter.Twitter#unesi(java.lang.String, java.lang.String)}.
	    */
			@Test (expected = java.lang.RuntimeException.class)
			public void testUnesiPrekoracenje() {
				
			   profil.unesi("Nemanja","Ovo je porukaOvo je porukaOvo je porukaOvo je porukaOvo je porukaOvo je porukaOvo je porukaOvo je porukaOvo je porukaOvo je porukaOvo je porukaOvo je porukaOvo je porukaOvo je porukaOvo je porukaOvo je poruka");
		
			}

	/**
		 * Test method for {@link com.twitter.Twitter#vratiPoruke(int, java.lang.String)}.
		 */
				@Test
				public void testVratiPoruke() {
					profil.unesi("Nemanja", "Ovo je poruka");
					profil.unesi("Nemanja2", "Ovo je poruka2");
					profil.unesi("Nemanja3", "Ovo je poruka3");
					
					
					assertEquals(10, profil.vratiPoruke(10, "Ovo je poruka").length);
					assertEquals("Nemanja", profil.vratiPoruke(10, "Ovo je poruka")[0].getKorisnik());
					assertEquals("Ovo je poruka", profil.vratiPoruke(10, "Ovo je poruka")[0].getPoruka());
					assertEquals("Nemanja2", profil.vratiPoruke(10, "Ovo je poruka")[1].getKorisnik());
					assertEquals("Ovo je poruka2", profil.vratiPoruke(10, "Ovo je poruka")[1].getPoruka());
					assertEquals("Nemanja3", profil.vratiPoruke(10, "Ovo je poruka")[2].getKorisnik());
					assertEquals("Ovo je poruka3", profil.vratiPoruke(10, "Ovo je poruka")[2].getPoruka());
				}
				
				/**
				 * Test method for {@link com.twitter.Twitter#vratiPoruke(int, java.lang.String)}.
				 */
				@Test (expected = java.lang.RuntimeException.class)
				public void testVratiPorukeNull() {
					profil.unesi("Nemanja", "Ovo je poruka");
					profil.unesi("Nemanja2", " Ovo je poruka2");
					
					
					profil.vratiPoruke(5, null);
					
				}
				
				/**
				 * Test method for {@link com.twitter.Twitter#vratiPoruke(int, java.lang.String)}.
				 */
				@Test (expected = java.lang.RuntimeException.class)
				public void testVratiPorukeEmpty() {
					profil.unesi("Nemanja", "Ovo je poruka");
					profil.unesi("Nemanja2", "Ovo je poruka2");
					
					
					profil.vratiPoruke(5, "");
					
				}
				
				/**
				 * Test method for {@link com.twitter.Twitter#vratiPoruke(int, java.lang.String)}.
				 */
				@Test
				public void testVratiPorukeMaxBtoj0() {
					profil.unesi("Nemanja", "Ovo je poruka");
					profil.unesi("Nemanja2", "Ovo je poruka2");
					profil.unesi("Nemanja3", "Ovo je poruka3");
				
					assertEquals(100, profil.vratiPoruke(0, "Ovo je poruka").length);
					assertEquals("Nemanja", profil.vratiPoruke(5, "Ovo je poruka")[0].getKorisnik());
					assertEquals("Ovo je poruka", profil.vratiPoruke(5, "Ovo je poruka")[0].getPoruka());
					assertEquals("Nemanja2", profil.vratiPoruke(5, "Ovo je poruka")[1].getKorisnik());
					assertEquals("Ovo je poruka2", profil.vratiPoruke(5, "Ovo je poruka")[1].getPoruka());
				}
				
				/**
				 * Test method for {@link com.twitter.Twitter#vratiPoruke(int, java.lang.String)}.
				 */
				@Test
				public void testVratiManjiMaxOdBrojaPoruka() {
					profil.unesi("Nemanja", "Ovo je poruka");
					profil.unesi("Nemanja2", "Ovo je poruka2");
					profil.unesi("Nemanja3", "Ovo je poruka3");
					
					
				    assertEquals(2, profil.vratiPoruke(2, "Ovo je poruka").length);
					assertEquals("Nemanja", profil.vratiPoruke(2, "Ovo je poruka")[0].getKorisnik());
					assertEquals("Ovo je poruka", profil.vratiPoruke(2, "Ovo je poruka")[0].getPoruka());
					assertEquals("Nemanja2", profil.vratiPoruke(2, "Ovo je poruka")[1].getKorisnik());
					assertEquals("Ovo je poruka2", profil.vratiPoruke(2, "poruka")[1].getPoruka());
				}
			
			}
