package app_pack;

import java.util.TreeMap;

public class ProdajnoMjesto {
	private int ID;
	private String grad;
	private String drzava;
	private String adresa;
	private String telefon;
	private static TreeMap<Integer,ProdajnoMjesto> prodajnaMjesta=new TreeMap<>();
	private static int brojac=1;
	
	public static TreeMap<Integer,ProdajnoMjesto> getProdajnaMjesta() {
		return prodajnaMjesta;
	}
	
	public ProdajnoMjesto(String grad,String drzava,String adresa, String telefon) {
		this.ID=brojac++;
		this.grad=grad;
		this.drzava=drzava;
		this.adresa=adresa;
		this.telefon=telefon;
		
		prodajnaMjesta.put(ID,this);
	}
	@Override
	public String toString() {
		return "ID prodajnog mjesta: " +ID+"       Grad: "+grad+"       Drzava: "+drzava;
	}
	public int getID() {
		return ID;
	}
	public String getGrad() {
		return grad;
	}
	public String getDrzava() {
		return drzava;
	}
	public String getTelefon() {
		return telefon;
	}
	public String getAdresa() {
		return adresa;
	}
	public static boolean postojiProdajno(String drzava) {
		for(ProdajnoMjesto pm: prodajnaMjesta.values())
			if(pm.drzava.equals(drzava)) 
				return true;
		return false;	
	}
}
