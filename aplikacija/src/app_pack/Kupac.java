package app_pack;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.TreeMap;

public class Kupac {
	private int ID;
	private String korisnickoIme;
	private String ime;
	private String prezime;
	private String lozinka;
	private String telefon;
	private String adresa;
	private String grad;
	private String drzava;
	private String postanskiBroj;
	private String pol;
	private String email;
	private static TreeMap<Integer,Kupac> kupci=new TreeMap<>();
	
	public Kupac(int ID, String korisnickoIme, String ime,String prezime, String lozinka,
			String telefon,String adresa,String grad,String drzava,String postanskiBroj,
			String pol, String email, boolean sql) {
		this.ID=ID;
		this.korisnickoIme=korisnickoIme;
		this.ime=ime;
		this.prezime=prezime;
		if(sql)
			this.lozinka=lozinka;
		else
			this.lozinka=getMd5(lozinka);
		this.telefon=telefon;
		this.adresa=adresa;
		this.grad=grad;
		this.drzava=drzava;
		this.postanskiBroj=postanskiBroj;
		this.pol=pol;
		this.email=email;
		
		kupci.put(ID, this);
	}
	public static TreeMap<Integer,Kupac> getKupci(){
		return kupci;
	}
	public static boolean postojiKorisnicko(String s) {
		for(Kupac k: kupci.values())
			if(k.korisnickoIme.equals(s))
				return true;
		for(Kupac k: kupci.values())
			if(k.email.equals(s))
				return true;
		return false;
	}
	public static boolean ispravnaLozinka(String s, String l) {
		for(Kupac k: kupci.values())
			if(k.korisnickoIme.equals(s)) {
				if(k.lozinka.equals(getMd5(l)))
					return true;
				return false;
			}
		return false;
	}
	public static String getMd5(String input) 
    { 
        try { 
  
            MessageDigest md = MessageDigest.getInstance("MD5"); 
            byte[] messageDigest = md.digest(input.getBytes()); 
            BigInteger no = new BigInteger(1, messageDigest); 
            String hashtext = no.toString(16); 
            while (hashtext.length() < 32) { 
                hashtext = "0" + hashtext; 
            } 
            return hashtext; 
        }  
 
        catch (NoSuchAlgorithmException e) { 
            throw new RuntimeException(e); 
        } 
    } 

	public int getBrojObavNarudzbi() {
		int broj=0;
		TreeMap<Integer,Narudzba>narudzbe=Narudzba.getNarudzbe();
		for(Narudzba n: narudzbe.values())
			if(n.getKupac().equals(this) && n.getDatumIsporuke()!=null)
				broj++;
		
		return broj;
	}
	public int getBrojNarudzbiCekanje() {
		int broj=0;
		TreeMap<Integer,Narudzba>narudzbe=Narudzba.getNarudzbe();
		for(Narudzba n: narudzbe.values())
			if(n.getKupac().equals(this) && n.getDatumIsporuke()==null)
				broj++;
		
		return broj;
	}
	public float getVrijednostNarudzbiCekanje() {
		float broj=0;
		TreeMap<Integer,Narudzba>narudzbe=Narudzba.getNarudzbe();
		for(Narudzba n: narudzbe.values())
			if(n.getKupac().equals(this) && n.getDatumIsporuke()==null)
				broj+=n.getVrijednostNarudzbe();
		
		return broj;
	}
	public int getID() {
		return ID;
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
	public String getGrad() {
		return grad;
	}
	public String getDrzava() {
		return drzava;
	}
	public String getAdresa() {
		return adresa;
	}
	public String getEmail() {
		return email;
	}
	public String getPol() {
		return pol;
	}
	public String getPostanski() {
		return postanskiBroj;
	}
	public String getTelefon() {
		return telefon;
	}
	@Override
	public String toString() {
		return ime+" "+prezime;
	}

}
