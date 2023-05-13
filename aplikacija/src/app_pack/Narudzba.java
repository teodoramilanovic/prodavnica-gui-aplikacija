package app_pack;

import java.util.TreeMap;

public class Narudzba {
	private int ID;
	private Kupac kupac;
	private Trgovac trgovac;
	private String datumNarudzbe;
	private String datumIsporuke;
	private String napomena;
	private static TreeMap<Integer,Narudzba> narudzbe=new TreeMap<>();
	private static TreeMap<Integer,Narudzba>neprihvaceneNar=new TreeMap<>();
	
	public Narudzba(int ID, int kupacID, int trgovacID, String datumNarudzbe, String datumIsporuke, String napomena) {
		this.datumIsporuke=datumIsporuke;
		this.datumNarudzbe=datumNarudzbe;
		this.napomena=napomena;
		this.ID=ID;
		TreeMap<Integer,Kupac>kupci=Kupac.getKupci();
		this.kupac=kupci.get(kupacID);
		TreeMap<Integer,Trgovac>trgovci=Trgovac.getTrgovci();
		if(trgovacID == -1) {
			this.trgovac=null;
			neprihvaceneNar.put(ID,this);
			}
		else
			this.trgovac=trgovci.get(trgovacID);
		
		narudzbe.put(ID, this);
	}
	public static TreeMap<Integer,Narudzba> getNarudzbe(){
		return narudzbe;
	}
	public double getVrijednostNarudzbe() {
		TreeMap<Integer,ArtikalNarudzbe>artikli=ArtikalNarudzbe.getArtikliNarudzbe();
		double vrijednost=0;
		for(ArtikalNarudzbe an: artikli.values())
			if(this.ID == an.getNarudzba().ID)
				vrijednost+=an.getKolicina()*an.getCijenaPoKomadu();
		
		return vrijednost;
	}
	public String getDatumNarudzbe() {
		return datumNarudzbe;
	}
	public String getDatumIsporuke() {
		return datumIsporuke;
	}
	public Kupac getKupac() {
		return kupac;
	}
	public int getID() {
		return ID;
	}
	public Trgovac getTrgovac() {
		return trgovac;
	}
	public String getNapomena() {
		return napomena;
	}
	public void setDatumIsporuke(String datumIsporuke) {
		this.datumIsporuke=datumIsporuke;
	}
	public void setTrgovac(Trgovac t) {
		this.trgovac=t;
	}
	public static TreeMap<Integer,Narudzba> getNeprihvaceneNar(){
		return neprihvaceneNar;
	}
	@Override
	public String toString() {
		return datumNarudzbe+" "+datumIsporuke+" "+napomena;
	}
	public static void main(String[]args) {
		UcitavanjePodataka.ucitavanjeGUI();
		Narudzba n=new Narudzba(10138,187,1,"2005-10-20",null,null);
		Narudzba n1=new Narudzba(10139,187,1,"2006-09-15",null,null);
		UcitavanjePodataka.insertNarudzba(n);
		UcitavanjePodataka.insertNarudzba(n1);
	}
}
