package com.twitter.poruke;

/**
 * Pretstavlja jednu twitter poruku.
 * @autor nemanjavukic
 * @version 2.0
 */

public class TwitterPoruka {
	
	/**
	 * Ime korisnika.
	 */
	private String korisnik;
	/**
	 * Sadrzaj poruke.
	 */
	private String poruka;
	/**
	 * Metoda koja vraca ime korisnika, tj vrednost privatnog atributa korisnik.
	 * @return ime korisnika kao String.
	 */
	public String getKorisnik() {
	return korisnik;
	}
	/**
	 * Metoda koja postavljam ime korisnika na unetu vrednost.
	 * @param korisnik novo ime korisnika
	 * @throws java.lang.RuntimeException ako je uneto ime korisnika
	 * null ili prazan String
	 */
	public void setKorisnik(String korisnik) {
	if (korisnik==null || korisnik.equals(""))
	throw new RuntimeException(
	"Ime korisnika mora biti uneto");
	this.korisnik = korisnik;
	}
	/**
	 * Metoda koja vraca poruku, tj vrednost privatnog atributa poruka.
	 * @return poruku kao String
	 */
	public String getPoruka() {
	return poruka;
	}
	/**
	 * Metoda koja postavlja vrednost privatnog atributa poruka na unetu vrednost.
	 * @param poruka sadrzaj poruke
	 *  @throws java.lang.RuntimeException ako je kao poruka unet tekst koji je
	 *  null ili duzi od 140 karaktera
	 */
	public void setPoruka(String poruka) {
	if (poruka==null || poruka.length()>140)
	throw new RuntimeException(
	"Poruka mora biti uneta i mora imati najvise 140 znakova");
	this.poruka = poruka;
	}
	/**
	 * Metoda koja ispisuje vrednost privatnih atributa korisnik i poruka.
	 */
	public String toString(){
	return "KORISNIK:"+korisnik+" PORUKA:"+poruka;
	}
	}


