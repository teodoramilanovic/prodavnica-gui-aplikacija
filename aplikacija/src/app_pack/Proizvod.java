package app_pack;

import java.util.TreeMap;

public class Proizvod {
	private int ID;
	private String naziv;
	private String opis;
	private double cijena;
	private static TreeMap<Integer,Proizvod> proizvodi=new TreeMap<>();
	private static int brojac=1;
	
	public Proizvod(String naziv, String opis, double cijena) {
		this.naziv=naziv;
		this.opis=opis;
		this.cijena=cijena;
		this.ID=brojac++;
		
		proizvodi.put(ID,this);
	}
	public static TreeMap<Integer,Proizvod> getProizvodi(){
		return proizvodi;
	}
	public String getNaziv() {
		return naziv;
	}
	public double getCijena() {
		return cijena;
	}
	public int getID() {
		return ID;
	}
	public String getOpis() {
		return opis;
	}
	public void setOpis(String opis) {
		this.opis=opis;
	}
	public void setNaziv(String naziv) {
		this.naziv=naziv;
	}
	public void setCijena(double cijena) {
		this.cijena=cijena;
	}
	@Override
	public String toString() {
		return naziv+" "+cijena+" "+opis; 
	}

}
