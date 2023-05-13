package app_pack;

import java.util.TreeMap;

public class Trgovac {
	private int ID;
	private String korisnickoIme;
	private String ime;
	private String prezime;
	private String lozinka;
	private String telefon;
	private String pol;
	private String email;
	private ProdajnoMjesto prodajnoMjesto;
	private static TreeMap<Integer,Trgovac> trgovci=new TreeMap<>();
	private static int brojac=1;
	
	public Trgovac(String korisnickoIme, String ime,String prezime, String lozinka,
			String telefon, String pol, String email, int prodajnoMjestoID,boolean sql) {
		this.ID=brojac++;
		this.korisnickoIme=korisnickoIme;
		this.ime=ime;
		this.prezime=prezime;
		if(sql)
			this.lozinka=lozinka;
		else
			this.lozinka=Kupac.getMd5(lozinka);
		this.telefon=telefon;
		this.pol=pol;
		this.email=email;
		TreeMap<Integer,ProdajnoMjesto>prodajnaMjesta=ProdajnoMjesto.getProdajnaMjesta();
		this.prodajnoMjesto=prodajnaMjesta.get(prodajnoMjestoID);
		
		trgovci.put(ID,this);
	}
	public static TreeMap<Integer,Trgovac> getTrgovci(){
		return trgovci;	
	}
	@Override
	public String toString() {
		return korisnickoIme+" "+ime+" "+prezime;
	}
	public static boolean postojiKorisnicko(String s) {
		for(Trgovac t: trgovci.values())
			if(t.korisnickoIme.equals(s))
				return true;
		for(Trgovac t: trgovci.values())
			if(t.email.equals(s))
				return true;
		return false;
	}
	public static boolean ispravnaLozinka(String s, String l) {
		for(Trgovac t: trgovci.values())
			if(t.korisnickoIme.equals(s)) {
				if(t.lozinka.equals(Kupac.getMd5(l)))
					return true;
				return false;
			}
		return false;
	}
	
	public int getID() {
		return ID;
	}
	public ProdajnoMjesto getProdajnoMjesto() {
		return prodajnoMjesto;
	}
	public String getKorisnickoIme() {
		return korisnickoIme;
	}
	public String getIme() {
		return ime;
	}
	public String getPrezime() {
		return prezime;
	}
	public String getLozinka() {
		return lozinka;
	}
	public String getTelefon() {
		return telefon;
	}
	public String getEmail() {
		return email;
	}
	public String getPol() {
		return pol;
	}
	public boolean odgovaraDrzava(String drzava) {
		if(this.prodajnoMjesto.getDrzava().equals(drzava))
			return true;
		else
			return false;
	}
}
