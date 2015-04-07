package com.twitter;


	import java.util.LinkedList;

	import com.twitter.poruke.TwitterPoruka;
	/**
	 * Klasa Twitter koja pretstavlja drustvenu mrezu sa metodama za pretrazivanje po tagu i unosenje poruke.
	 * @author Nemanja
	 *@version 2.0
	 */
	public class Twitter {
		/**
		 * Atribut koji pretstavlja listu ovjekata klase TwitterPoruka.
		 */
	private LinkedList<TwitterPoruka> poruke =
	new LinkedList<TwitterPoruka>();
	/**
	 * Metoda koja vraca sve poruke iz liste.
	 * @return Twitter poruke koje su u listi
	 */
	public LinkedList<TwitterPoruka> vratiSvePoruke(){
	return poruke;
	}
	/**
	 * Metoda za unosenje objekta klase TwitterPoruka u listu
	 * @param korisnik ime korisnika cija se poruka unosi
	 * @param poruka poruka koja se unosi u listu
	 */
	public void unesi(String korisnik, String poruka) {
	//Pravi se nova poruka i puni podacima.
	TwitterPoruka tp = new TwitterPoruka();
	tp.setKorisnik(korisnik);
	tp.setPoruka(poruka);
	//Poruka se unosi u listu na kraj
	poruke.addLast(tp);
	}
	/**
	 * Metoda koja pretrazuje poruke po tagu 
	 * @param maxBroj maksimalan broj poruka koji vracamo
	 * @param tag tag poruke po kojem pretrazujemo
	 * @return niz objekata klase TwitterPoruka
	 * @throws java.lang.RuntimeException ako je tag
	 * null ili prazan String
	 */
	public TwitterPoruka[] vratiPoruke(int maxBroj, String tag) {
	 if (tag==null || tag.isEmpty())
	throw new RuntimeException("Morate uneti tag");
	//Ako je maxBroj <=0, vraca maxBroj se postavlja na 100 poruka
	if (maxBroj<=0)
	maxBroj = 100;
	 //Pomocna promenljiva koja predstavlja brojac upisanih poruka
	int brojac = 0;
	//Pomocni niz koja predstavlja rezultat pretrage tj. sadrzace
	//sve poruke koje u sebi imaju zadati tag
	TwitterPoruka[] rezultat = new TwitterPoruka[maxBroj];
	//Pretrazuju se poruke i traze se one koje sadrze tag.
	//Ako se nadje neka takva, i ako nije prekoracen maxBroj
	//ona se upisuje u niz. Ako je prekoracen maxBroj,pretraga
	//se prekida.
	for (int i = 0; i < poruke.size(); i++)
	if (poruke.get(i).getPoruka().indexOf(tag)!=-1)
	if (brojac < maxBroj){
	rezultat[brojac]=poruke.get(i);
	brojac++;
	}
	else break;
	return rezultat;
	}
	} 

