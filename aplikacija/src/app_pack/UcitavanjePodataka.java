package app_pack;

import java.sql.*;

public class UcitavanjePodataka {
	public static Connection getKonekcija() {
		Connection konekcija=null;
		try {
			konekcija=DriverManager.getConnection("jdbc:mysql://localhost:3306/seminarski_ors1", "root", "bicebolje");
		}catch(Exception e) {
			e.printStackTrace();
		}
		return konekcija;
	}
	public static void ucitavanjeGUI() {
		Connection myConn=null;
		try {
			myConn=getKonekcija();
			Statement myStmt=myConn.createStatement();
			
			ResultSet myRs3 = myStmt.executeQuery("select * from prodajno_mjesto");
			while (myRs3.next()) {
				new ProdajnoMjesto(myRs3.getString("grad"),
						myRs3.getString("drzava"), myRs3.getString("adresa"),myRs3.getString("telefon"));
			}
			
			ResultSet myRs = myStmt.executeQuery("select * from kupac");
			while (myRs.next()) {
				new Kupac(Integer.parseInt(myRs.getString("id")),myRs.getString("korisnicko_ime"),
						myRs.getString("ime"), myRs.getString("prezime"), myRs.getString("lozinka"),
						myRs.getString("telefon"),myRs.getString("adresa"),myRs.getString("grad"),
						myRs.getString("drzava"),myRs.getString("postanski_broj"),myRs.getString("pol"),
						myRs.getString("email"),true);
			}
			ResultSet myRs1 = myStmt.executeQuery("select * from trgovac");
			while (myRs1.next()) {
				new Trgovac(myRs1.getString("korisnicko_ime"),
						myRs1.getString("ime"), myRs1.getString("prezime"), myRs1.getString("lozinka"),
						myRs1.getString("telefon"),myRs1.getString("pol"),
						myRs1.getString("email"),Integer.parseInt(myRs1.getString("prodajno_mjesto_id")),true);
			}
			ResultSet myRs2 = myStmt.executeQuery("select * from proizvod");
			while (myRs2.next()) {
				new Proizvod(myRs2.getString("naziv"),
						myRs2.getString("opis"), Float.parseFloat(myRs2.getString("cijena")));
			}
			
			ResultSet myRs4 = myStmt.executeQuery("select * from narudzba");
			while (myRs4.next()) {
				new Narudzba(Integer.parseInt(myRs4.getString("id")),
						Integer.parseInt(myRs4.getString("kupac_id")), Integer.parseInt(myRs4.getString("trgovac_id")),myRs4.getString("datum_narudzbe"),
						myRs4.getString("datum_isporuke"), myRs4.getString("napomena"));
			}
			ResultSet myRs5 = myStmt.executeQuery("select * from artikal_narudzbe");
			while (myRs5.next()) {
				new ArtikalNarudzbe(Integer.parseInt(myRs5.getString("narudzba_id")),
						Integer.parseInt(myRs5.getString("proizvod_id")), Integer.parseInt(myRs5.getString("kolicina")),
						Float.parseFloat(myRs5.getString("cijena_po_komadu")),Integer.parseInt(myRs5.getString("id")));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		if(myConn != null) {
			try {
				myConn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public static void insertKupac(Kupac k) {
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		try {
		connection=getKonekcija();
		preparedStatement=connection.prepareStatement("INSERT INTO kupac (id,korisnicko_ime,ime,prezime,lozinka,telefon,adresa,grad,drzava,postanski_broj,pol,email)" + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?)");
		preparedStatement.setInt(1, k.getID());
		preparedStatement.setString(2,k.getKorisnickoIme());
		preparedStatement.setString(3,k.getIme());
		preparedStatement.setString(4,k.getPrezime());
		preparedStatement.setString(5,k.getLozinka());
		preparedStatement.setString(6, k.getTelefon());
		preparedStatement.setString(7,k.getAdresa());
		preparedStatement.setString(8,k.getGrad());
		preparedStatement.setString(9,k.getDrzava());
		preparedStatement.setString(10,k.getPostanski());
		preparedStatement.setString(11,k.getPol());
		preparedStatement.setString(12,k.getEmail());
		preparedStatement.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			if(preparedStatement !=null) {
				try {
					preparedStatement.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
		if(connection != null) {
			try {
				connection.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public static void insertArtikal(ArtikalNarudzbe a) {
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		try {
		connection=getKonekcija();
		preparedStatement=connection.prepareStatement("INSERT INTO artikal_narudzbe (narudzba_id,proizvod_id,kolicina,cijena_po_komadu,id)" + "VALUES (?,?,?,?,?)");
		Narudzba n=a.getNarudzba();
		preparedStatement.setInt(1, n.getID());
		preparedStatement.setInt(2,a.getProizvod().getID());
		preparedStatement.setInt(3,a.getKolicina());
		preparedStatement.setDouble(4,a.getCijenaPoKomadu());
		preparedStatement.setInt(5,a.getID());
		preparedStatement.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			if(preparedStatement !=null) {
				try {
					preparedStatement.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
		if(connection != null) {
			try {
				connection.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public static void insertNarudzba(Narudzba n) {
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		try {
		connection=getKonekcija();
		preparedStatement=connection.prepareStatement("INSERT INTO narudzba (id,kupac_id,trgovac_id,datum_narudzbe,datum_isporuke,napomena)" + "VALUES (?,?,?,?,?,?)");
		
		preparedStatement.setInt(1, n.getID());
		Kupac k=n.getKupac();
		preparedStatement.setInt(2, k.getID());
		Trgovac t= n.getTrgovac();
		if(t==null)
			preparedStatement.setInt(3, -1);
		else
			preparedStatement.setInt(3, t.getID());
		preparedStatement.setString(4, n.getDatumNarudzbe());
		preparedStatement.setString(5, n.getDatumIsporuke());
		preparedStatement.setString(6, n.getNapomena());
		preparedStatement.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			if(preparedStatement !=null) {
				try {
					preparedStatement.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
		if(connection != null) {
			try {
				connection.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public static void insertProdajnoMjesto(ProdajnoMjesto pm) {
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		try {
		connection=getKonekcija();
		preparedStatement=connection.prepareStatement("INSERT INTO prodajno_mjesto (id,grad,drzava,adresa,telefon)" + "VALUES (?,?,?,?,?)");
		
		preparedStatement.setInt(1, pm.getID());
		preparedStatement.setString(2, pm.getGrad());
		preparedStatement.setString(3, pm.getDrzava());
		preparedStatement.setString(4, pm.getAdresa());
		preparedStatement.setString(5, pm.getTelefon());
		preparedStatement.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			if(preparedStatement !=null) {
				try {
					preparedStatement.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
		if(connection != null) {
			try {
				connection.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public static void insertTrgovac(Trgovac t) {
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		try {
		connection=getKonekcija();
		preparedStatement=connection.prepareStatement("INSERT INTO trgovac (id,korisnicko_ime,ime,prezime,lozinka,pol,telefon,email,prodajno_mjesto_id)" + "VALUES (?,?,?,?,?,?,?,?,?)");
		
		preparedStatement.setInt(1, t.getID());
		preparedStatement.setString(2, t.getKorisnickoIme());
		preparedStatement.setString(3, t.getIme());
		preparedStatement.setString(4, t.getPrezime());
		preparedStatement.setString(5, t.getLozinka());
		preparedStatement.setString(6, t.getPol());
		preparedStatement.setString(7, t.getTelefon());
		preparedStatement.setString(8, t.getEmail());
		preparedStatement.setInt(9, t.getProdajnoMjesto().getID());
		preparedStatement.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			if(preparedStatement !=null) {
				try {
					preparedStatement.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
		if(connection != null) {
			try {
				connection.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public static void insertProizvod(Proizvod p) {
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		try {
		connection=getKonekcija();
		preparedStatement=connection.prepareStatement("INSERT INTO proizvod (id,naziv,opis,cijena)" + "VALUES (?,?,?,?)");
		
		preparedStatement.setInt(1, p.getID());
		preparedStatement.setString(2, p.getNaziv());
		preparedStatement.setString(3, p.getOpis());
		preparedStatement.setDouble(4, p.getCijena());
		preparedStatement.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			if(preparedStatement !=null) {
				try {
					preparedStatement.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
		if(connection != null) {
			try {
				connection.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public static void updateProizvod(Proizvod p,Object c, String s) {
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		try {
		connection=getKonekcija();
		
		if(s.equals("cijena")) {
		preparedStatement=connection.prepareStatement("UPDATE proizvod SET " +"naziv = ?, opis = ?, cijena = ? WHERE id = ?");
		preparedStatement.setString(1, p.getNaziv());
		preparedStatement.setString(2, p.getOpis());
		preparedStatement.setDouble(3,(double)c);
		preparedStatement.setDouble(4, p.getID());
		p.setCijena((double)c);
			}
		else if(s.equals("naziv")) {
			preparedStatement=connection.prepareStatement("UPDATE proizvod SET " +"naziv = ?, opis = ?, cijena = ? WHERE id = ?");
			preparedStatement.setString(1, (String)c);
			preparedStatement.setString(2, p.getOpis());
			preparedStatement.setDouble(3,p.getCijena());
			preparedStatement.setDouble(4, p.getID());
			p.setNaziv((String)c);
			}
		else {
			preparedStatement=connection.prepareStatement("UPDATE proizvod SET " +"naziv = ?, opis = ?, cijena = ? WHERE id = ?");
			preparedStatement.setString(1, p.getNaziv());
			preparedStatement.setString(2, (String)c);
			preparedStatement.setDouble(3,p.getCijena());
			preparedStatement.setDouble(4, p.getID());
			p.setOpis((String)c);
			}
		
		preparedStatement.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			if(preparedStatement !=null) {
				try {
					preparedStatement.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
		if(connection != null) {
			try {
				connection.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public static void updateNarudzba(Narudzba n, Object d, String atribut) {
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		try {
		connection=getKonekcija();
		
		if(atribut.equals("datum")) {
		preparedStatement=connection.prepareStatement("UPDATE narudzba SET " +"kupac_id = ?, trgovac_id = ?, datum_narudzbe = ?, datum_isporuke = ?, napomena = ? WHERE id = ?");
		preparedStatement.setInt(1, n.getKupac().getID());
		preparedStatement.setInt(2, n.getTrgovac().getID());
		preparedStatement.setString(3, n.getDatumNarudzbe());
		preparedStatement.setString(4,(String)d);
		preparedStatement.setString(5, n.getNapomena());
		preparedStatement.setInt(6, n.getID());
		n.setDatumIsporuke((String)d);
		}else {
			preparedStatement=connection.prepareStatement("UPDATE narudzba SET " +"kupac_id = ?, trgovac_id = ?, datum_narudzbe = ?, datum_isporuke = ?, napomena = ? WHERE id = ?");
			preparedStatement.setInt(1, n.getKupac().getID());
			preparedStatement.setInt(2, (int)d);
			preparedStatement.setString(3, n.getDatumNarudzbe());
			preparedStatement.setString(4,n.getDatumIsporuke());
			preparedStatement.setString(5, n.getNapomena());
			preparedStatement.setInt(6, n.getID());
		}
		
		preparedStatement.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			if(preparedStatement !=null) {
				try {
					preparedStatement.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
		if(connection != null) {
			try {
				connection.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public static void deleteNarudzba(int id) {
		Connection connection = null;
		PreparedStatement preparedStatement= null;
		PreparedStatement preparedStatement1= null;
		
		try {
			connection=getKonekcija();
			preparedStatement=connection.prepareStatement("DELETE FROM narudzba WHERE id = ?");
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
			preparedStatement1=connection.prepareStatement("DELETE FROM artikal_narudzbe WHERE narudzba_id = ?");
			preparedStatement1.setInt(1, id);
			preparedStatement1.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(preparedStatement !=null) {
				try {
					preparedStatement.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
		if(connection != null) {
			try {
				connection.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
}

