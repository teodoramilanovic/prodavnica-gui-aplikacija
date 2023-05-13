package app_pack;

import java.util.TreeMap;

public class ArtikalNarudzbe {
	private Narudzba narudzba;
	private Proizvod proizvod;
	private int kolicina;
	private double cijenaPoKomadu;
	private int ID;
	private static TreeMap<Integer,ArtikalNarudzbe> artikliNarudzbe=new TreeMap<>();
	
	public ArtikalNarudzbe(int narudzbaID, int proizvodID, int kolicina, double cijenaPoKomadu,int ID) {
		this.kolicina=kolicina;
		this.cijenaPoKomadu=cijenaPoKomadu;
		this.ID=ID;
		TreeMap<Integer,Narudzba>narudzbe=Narudzba.getNarudzbe();
		this.narudzba=narudzbe.get(narudzbaID);
		TreeMap<Integer,Proizvod>proizvodi=Proizvod.getProizvodi();
		this.proizvod=proizvodi.get(proizvodID);
		
		artikliNarudzbe.put(ID,this);
	}
	public static TreeMap<Integer,ArtikalNarudzbe> getArtikliNarudzbe(){
		return artikliNarudzbe;
	}
	public Narudzba getNarudzba() {
		return narudzba;
	}
	public int getKolicina() {
		return kolicina;
	}
	public double getCijenaPoKomadu() {
		return cijenaPoKomadu;
	}
	public Proizvod getProizvod() {
		return proizvod;
	}
	public int getID() {
		return ID;
	}
	@Override
	public String toString() {
		return kolicina+" "+cijenaPoKomadu;
	}
	
}
