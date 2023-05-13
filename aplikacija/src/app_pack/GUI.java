package app_pack;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import javafx.application.Application;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.MapValueFactory;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class GUI extends Application{
	public static void main(String[]args) {
		UcitavanjePodataka.ucitavanjeGUI();
		launch(args);
	}
	Service service=new ProcessService();
	
	@Override
	public void start(Stage primaryStage){
		
		//PRIJAVA I REGISTRACIJA
		VBox prijava=new VBox(10);
		prijava.setPadding(new Insets(50,50,50,50));
		prijava.setMaxSize(350, 350);
		prijava.setBackground(new Background(new BackgroundFill(Color.rgb(219, 219, 219),CornerRadii.EMPTY,Insets.EMPTY)));
		Label unos=new Label("Unesite korisnicko ime ili e-mail:");
		TextField korIme=new TextField();
		korIme.setMaxWidth(200);
		Label unos2=new Label("Unesite lozinku:");
		PasswordField loz=new PasswordField();
		loz.setMaxWidth(200);
		Label unos3=new Label("Prijavljujem se kao:");
		ToggleGroup tg=new ToggleGroup();
		RadioButton kupRB=new RadioButton("Kupac");
		RadioButton trgRB=new RadioButton("Trgovac");
		kupRB.setToggleGroup(tg);
		trgRB.setToggleGroup(tg);
		HBox toggle=new HBox(20);
		toggle.getChildren().addAll(kupRB,trgRB);
		Button prijavaB=new Button("Prijavite se");
		Label greska3=new Label();
		greska3.setTextFill(Color.RED);
		HBox regHB=new HBox(20);
		regHB.setPadding(new Insets(10,0,0,0));
		Label unos4=new Label("Nemate korisnicki racun?");
		Button regB=new Button("Registrujte se");
		Label greska=new Label();
		greska.setTextFill(Color.GREEN);
		regHB.getChildren().addAll(unos4,regB);
		prijava.getChildren().addAll(unos,korIme,unos2,loz,unos3,toggle,greska3,prijavaB,regHB,greska);
		
		VBox registracija=new VBox(10);
		registracija.setPadding(new Insets(20,20,20,20));
		registracija.setMaxSize(460, 500);
		registracija.setBorder(new Border(new BorderStroke(Color.MEDIUMPURPLE, BorderStrokeStyle.SOLID,CornerRadii.EMPTY,BorderWidths.DEFAULT)));
		registracija.setBackground(new Background(new BackgroundFill(Color.rgb(219, 219, 219),CornerRadii.EMPTY,Insets.EMPTY)));
		
		Label ime=new Label("Ime:");
		TextField imeTF=new TextField();
		imeTF.setMinWidth(200);
		Label prezime=new Label("Prezime:");
		TextField prezimeTF=new TextField();
		prezimeTF.setMinWidth(200);
		VBox imeVB=new VBox(10);
		imeVB.getChildren().addAll(ime,imeTF);
		VBox prezimeVB=new VBox(10);
		prezimeVB.getChildren().addAll(prezime,prezimeTF);
		HBox imePrez=new HBox(20);
		imePrez.getChildren().addAll(imeVB,prezimeVB);
		
		Label drzava=new Label("Drzava:");
		TextField drzavaTF=new TextField();
		drzavaTF.setMaxWidth(200);
		Label grad=new Label("Grad:");
		TextField gradTF=new TextField();
		gradTF.setMinWidth(200);
		VBox drzavaVB=new VBox(10);
		drzavaVB.getChildren().addAll(drzava,drzavaTF);
		VBox gradVB=new VBox(10);
		gradVB.getChildren().addAll(grad,gradTF);
		Label adresa=new Label("Adresa:");
		TextField adresaTF=new TextField();
		adresaTF.setMaxWidth(200);
		Label postanskiBroj=new Label("Postanski broj:");
		TextField postanskiTF=new TextField();
		postanskiTF.setMinWidth(200);
		VBox adresaVB=new VBox(10);
		adresaVB.getChildren().addAll(adresa,adresaTF);
		VBox postanskiVB=new VBox(10);
		postanskiVB.getChildren().addAll(postanskiBroj,postanskiTF);
		HBox grdPost=new HBox(20);
		grdPost.getChildren().addAll(gradVB,postanskiVB);
		
		Label telefon=new Label("Telefon:");
		TextField telefonTF=new TextField();
		telefonTF.setMaxWidth(200);
		Label email=new Label("E-mail:");
		TextField emailTF=new TextField();
		emailTF.setMaxWidth(200);
		VBox telefonVB=new VBox(10);
		telefonVB.getChildren().addAll(telefon,telefonTF);
		VBox emailVB=new VBox(10);
		emailVB.getChildren().addAll(email,emailTF);
		
		Label korisnickoIme=new Label("Korisnicko ime:");
		TextField korisnickoTF=new TextField();
		korisnickoTF.setMinWidth(200);
		Label lozinka=new Label("Lozinka:");
		PasswordField lozinkaTF=new PasswordField();
		lozinkaTF.setMinWidth(200);
		VBox korisnickoVB=new VBox(10);
		korisnickoVB.getChildren().addAll(korisnickoIme,korisnickoTF);
		VBox lozinkaVB=new VBox(10);
		lozinkaVB.getChildren().addAll(lozinka,lozinkaTF);
		HBox korLoz=new HBox(20);
		korLoz.getChildren().addAll(korisnickoVB,lozinkaVB);
		
		RadioButton muski=new RadioButton("M");
		RadioButton zenski=new RadioButton("Z");
		ToggleGroup tg1=new ToggleGroup();
		muski.setToggleGroup(tg1);
		zenski.setToggleGroup(tg1);
		HBox mzHB=new HBox(20);
		mzHB.getChildren().addAll(muski,zenski);
		
		Label greska4=new Label();
		greska4.setTextFill(Color.RED);
		greska4.setManaged(false);
		greska4.setVisible(false);
		Button reg=new Button("Registrujte se");
		Button nazadR=new Button("Nazad");
		HBox dugR=new HBox(20);
		dugR.getChildren().addAll(reg,nazadR);
		registracija.getChildren().addAll(imePrez,mzHB,emailVB,telefonVB,drzavaVB,grdPost,adresaVB,korLoz,greska4,dugR);
		
		Scene scena=new Scene(prijava,350,380);
		Scene scenaREG=new Scene(registracija,500,600);
		primaryStage.setScene(scena);
		primaryStage.show();
		
		prijavaB.setOnAction(e-> {
			greska.setText("");
			if(!kupRB.isSelected() && !trgRB.isSelected()) {
				greska3.setText("Niste nista oznacili!");
				return;
			}
			
			if (kupRB.isSelected()) {

			greska3.setText("");
			if(!Kupac.postojiKorisnicko(korIme.getText())){
				greska3.setManaged(true);
				greska3.setText("Nepostojece korisnicko ime ili email!");
				return;
			}
			
			if(!Kupac.ispravnaLozinka(korIme.getText(),loz.getText())) {
				greska3.setManaged(true);
				greska3.setText("Neispravna lozinka! Pokusajte ponovo.");
				return;
			}
			
			greska3.setText("");
			
			
			//KUPAC
			HBox informacije=new HBox(10);
			informacije.setPadding(new Insets(10,10,10,10));
			informacije.setMaxHeight(300);
			informacije.setMinWidth(700);
			informacije.setBackground(new Background(new BackgroundFill(Color.rgb(219, 219, 219),CornerRadii.EMPTY,Insets.EMPTY)));
			String ki=korIme.getText();
			Kupac kupacS1=null;
			TreeMap<Integer,Kupac>kupci1=Kupac.getKupci();
			for(Kupac kup: kupci1.values())
				if(kup.getKorisnickoIme().equals(ki))
					kupacS1=kup;
			final Kupac kupacS=kupacS1;
			Label imeINF=new Label("Ime: "+kupacS.getIme());
			Label prezimeINF=new Label("Prezime: "+kupacS.getPrezime());
			Label gradINF= new Label("Grad: "+kupacS.getGrad());
			Label adresaINF=new Label();
			if(kupacS.getAdresa()==null)
				adresaINF.setText("Adresa: ");
			else
				adresaINF.setText("Adresa: "+kupacS.getAdresa());
			Label drzavaINF=new Label("Drzava: "+kupacS.getDrzava());
			Label brojONarINF=new Label("Broj obavljenih narudzbi: "+kupacS.getBrojObavNarudzbi());
			Label brojNarCekINF=new Label("Broj narudzbi cija se isporuka ceka: "+kupacS.getBrojNarudzbiCekanje());
			Label vrijednostINF=new Label("Vrijednost narudzbi cija se isporuka ceka: "+kupacS.getVrijednostNarudzbiCekanje());
			VBox lijevi=new VBox(10);
			VBox desni= new VBox(10);
			VBox odjavaVB=new VBox(10);
			Button odjava=new Button("Odjavite se");
			odjavaVB.getChildren().add(odjava);
			odjavaVB.setAlignment(Pos.CENTER);
			lijevi.setPadding(new Insets(0,20,0,20));
			desni.setPadding(new Insets(30,20,30,20));
			lijevi.getChildren().addAll(imeINF, prezimeINF, gradINF, adresaINF,drzavaINF);
			desni.getChildren().addAll(brojONarINF,brojNarCekINF,vrijednostINF);
			informacije.getChildren().addAll(lijevi,desni,odjavaVB);
			
			Label spisakN=new Label("Spisak obavljenih narudzbi:");
			Button prikaziNar=new Button("Prikazi/Sakrij");
			HBox prikazi=new HBox(10);
			prikazi.setPadding(new Insets(20,10,0,20));
			prikazi.getChildren().addAll(spisakN,prikaziNar);
			
			TableView tv=new TableView();
			tv.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
			TableColumn<Map,String> kolonaDatumN=new TableColumn<>("Datum narudzbe");
			TableColumn<Map,String> kolonaDatumI=new TableColumn<>("Datum isporuke");
			TableColumn<Map,String> kolonaVrijednost=new TableColumn<>("Vrijednost narudzbe");
			kolonaDatumN.setCellValueFactory(new MapValueFactory<>("datumNar"));
			kolonaDatumI.setCellValueFactory(new MapValueFactory<>("datumIsp"));
			kolonaVrijednost.setCellValueFactory(new MapValueFactory<>("vrijednost"));
			tv.getColumns().addAll(kolonaDatumN, kolonaDatumI, kolonaVrijednost);
			
			tv.setMaxHeight(100);
			tv.setMaxWidth(450);
		
			ScrollPane sp=new ScrollPane();
			sp.setContent(tv);
			sp.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
			sp.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
			
			TreeMap<Integer,Narudzba>narudzbe=Narudzba.getNarudzbe();
			for(Narudzba n: narudzbe.values()) {
				if(n.getDatumIsporuke()==null || !n.getKupac().equals(kupacS))
					continue;
				
				Map<String,Object>m1=new HashMap<>();
				m1.put("datumNar", n.getDatumNarudzbe());
				m1.put("datumIsp", n.getDatumIsporuke());
				DecimalFormat df = new DecimalFormat("#.00");
				m1.put("vrijednost", df.format(n.getVrijednostNarudzbe()));
				m1.put("id", n.getID());
				
				tv.getItems().add(m1);
			}
			
			Button prikaziDetalje=new Button("Vise informacija");
			HBox tabela1HB=new HBox(10);
			VBox tabela1=new VBox(10);
			tabela1.setMinWidth(450);
			tabela1.getChildren().add(tv);
			tabela1.setPadding(new Insets(0,0,0,20));
			VBox tabela1B=new VBox(10);
			tabela1B.setAlignment(Pos.CENTER);
			tabela1B.getChildren().add(prikaziDetalje);
			tabela1HB.getChildren().addAll(tabela1,tabela1B);
			tabela1HB.setVisible(false);
			tabela1HB.setManaged(false);
			
			VBox prikaziD=new VBox();
			TableView tv2=new TableView();
			Label prodajnoMjestoL=new Label();
		    TextField iznosTF=new TextField();
		    tv2.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
			TableColumn<Map,String> spisakNarucenih=new TableColumn<>("Artikal");
			TableColumn<Map,String> kolicinaNarucenih=new TableColumn<>("Kolicina");
			TableColumn<Map,String> iznosNarucenih=new TableColumn<>("Cijena");
			spisakNarucenih.setCellValueFactory(new MapValueFactory<>("artikal"));
			kolicinaNarucenih.setCellValueFactory(new MapValueFactory<>("kolicina"));
			iznosNarucenih.setCellValueFactory(new MapValueFactory<>("vrijednost"));
			tv2.getColumns().addAll(spisakNarucenih,kolicinaNarucenih,iznosNarucenih);
			tv2.setMaxHeight(75);
			tv2.setMaxWidth(400);
			
			ScrollPane sp1=new ScrollPane();
			sp1.setContent(tv2);
			sp1.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
			sp1.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
			
			prikaziD.setPadding(new Insets(5,10,0,20));
			prikaziD.setManaged(false);
			prikaziD.setVisible(false);
			
			Label spisakNC=new Label("Spisak narudzbi cija se isporuka ceka:");
			Button prikaziNarCek=new Button("Prikazi/Sakrij");
			HBox prikaziNC=new HBox(10);
			prikaziNC.setPadding(new Insets(20,10,0,20));
			prikaziNC.getChildren().addAll(spisakNC,prikaziNarCek);
			
			TableView tv1=new TableView();
			tv1.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
			TableColumn<Map,String> kolonaDatumN1=new TableColumn<>("Datum narudzbe");
			TableColumn<Map,String> kolonaDatumI1=new TableColumn<>("Datum isporuke");
			TableColumn<Map,String> kolonaVrijednost1=new TableColumn<>("Vrijednost narudzbe");
			kolonaDatumN1.setCellValueFactory(new MapValueFactory<>("datumNar"));
			kolonaDatumI1.setCellValueFactory(new MapValueFactory<>("datumIsp"));
			kolonaVrijednost1.setCellValueFactory(new MapValueFactory<>("vrijednost"));
			tv1.getColumns().addAll(kolonaDatumN1, kolonaDatumI1, kolonaVrijednost1);
			tv1.setMaxHeight(100);
			tv1.setMaxWidth(450);
		    ScrollPane sp4=new ScrollPane();
			sp4.setContent(tv1);
			sp4.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
			sp4.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
			
			for(Narudzba n: narudzbe.values()) {
				if(n.getDatumIsporuke()!=null || !n.getKupac().equals(kupacS))
					continue;
				
				Map<String,Object>m1=new HashMap<>();
				m1.put("datumNar", n.getDatumNarudzbe());
				m1.put("datumIsp", "Ceka se");
				DecimalFormat df = new DecimalFormat("#.00");
				m1.put("vrijednost", df.format(n.getVrijednostNarudzbe()));
				m1.put("id", n.getID());
				
				tv1.getItems().add(m1);
			}
			
			Button prikaziDetalje2=new Button("Vise informacija");
			Button otkaziNarudzbu=new Button("Otkazite narudzbu");
			HBox tabela2HB=new HBox(10);
			VBox tabela2=new VBox(10);
			tabela2.setMinWidth(450);
			tabela2.getChildren().add(tv1);
			tabela2.setPadding(new Insets(0,0,0,20));
			VBox tabela2B=new VBox(10);
			tabela2B.setAlignment(Pos.CENTER);
			tabela2B.getChildren().addAll(prikaziDetalje2,otkaziNarudzbu);
			tabela2HB.getChildren().addAll(tabela2,tabela2B);
			tabela2HB.setVisible(false);
			tabela2HB.setManaged(false);
			
			VBox prikaziD2=new VBox();
			TableView tv3=new TableView();
			Label prodajnoMjesto2L=new Label();
			VBox tabela4VB=new VBox(tv3);

		    tv3.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
			TableColumn<Map,String> spisakNarucenih2=new TableColumn<>("Artikal");
			TableColumn<Map,String> kolicinaNarucenih2=new TableColumn<>("Kolicina");
			TableColumn<Map,String> iznosNarucenih2=new TableColumn<>("Cijena");
			spisakNarucenih2.setCellValueFactory(new MapValueFactory<>("artikal"));
			kolicinaNarucenih2.setCellValueFactory(new MapValueFactory<>("kolicina"));
			iznosNarucenih2.setCellValueFactory(new MapValueFactory<>("vrijednost"));
			tv3.getColumns().addAll(spisakNarucenih2,kolicinaNarucenih2,iznosNarucenih2);
			tv3.setMaxWidth(400);
			tv3.setMaxHeight(75);
		    spisakNarucenih2.prefWidthProperty().bind(tv3.widthProperty().multiply(0.33333333));
		    kolicinaNarucenih2.prefWidthProperty().bind(tv3.widthProperty().multiply(0.33333333));
		    iznosNarucenih2.prefWidthProperty().bind(tv3.widthProperty().multiply(0.3333333));
			
		    ScrollPane sp5=new ScrollPane();
			sp5.setContent(tv3);
			sp5.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
			sp5.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
		    
		    prikaziD2.setPadding(new Insets(5,10,0,20));
			prikaziD2.setManaged(false);
			prikaziD2.setVisible(false);
			
		    Button novaNarudzba=new Button("Nova narudzba");
			VBox novaN=new VBox(10);
			novaN.setPadding(new Insets(10,0,10,20));
			novaN.getChildren().add(novaNarudzba);
		
			VBox kupac=new VBox(10);
			kupac.setBackground(new Background(new BackgroundFill(Color.rgb(244, 244, 244),CornerRadii.EMPTY,Insets.EMPTY)));
			kupac.getChildren().addAll(informacije,prikazi,tabela1HB,prikaziD,prikaziNC,tabela2HB,prikaziD2,novaN);
			Scene scena2=new Scene(kupac,600,800);
			primaryStage.setScene(scena2);
			
			odjava.setOnAction(ex -> {
				korIme.setText("");
				loz.setText("");
				kupRB.setSelected(false);
				trgRB.setSelected(false);
				primaryStage.setScene(scena);
			});
			
			prikaziNar.setOnAction(ex-> {
				if(prikaziD.isManaged() && prikaziD.isVisible()) {
					prikaziD.setManaged(false);
					prikaziD.setVisible(false);
				}		
				
				tabela1HB.setVisible(!tabela1HB.isVisible());
				tabela1HB.setManaged(!tabela1HB.isManaged());
				
			});
			
			prikaziNarCek.setOnAction(ex -> {
				if(prikaziD2.isManaged() && prikaziD2.isVisible()) {
					prikaziD2.setManaged(false);
					prikaziD2.setVisible(false);
				}		
				
				tabela2HB.setVisible(!tabela2HB.isVisible());
				tabela2HB.setManaged(!tabela2HB.isManaged());
			});
			
			prikaziDetalje.setOnAction(ex -> {
				
				Map<String,Object> selected=(HashMap<String,Object>)tv.getSelectionModel().getSelectedItem();
				if(prikaziD.isManaged() && prikaziD.isVisible()) {
					prikaziD.setManaged(false);
					prikaziD.setVisible(false);
					return;
				}	
				
				if(selected==null)
					return;	
			
				tv2.getItems().clear();
				int ID=(int)selected.get("id");
				Narudzba narudzba=narudzbe.get(ID);
				ProdajnoMjesto pm=narudzba.getTrgovac().getProdajnoMjesto();
				prodajnoMjestoL.setText(""+pm);
				
			    TreeMap<Integer,ArtikalNarudzbe>artikli=ArtikalNarudzbe.getArtikliNarudzbe();
			    for(ArtikalNarudzbe a: artikli.values()) {
					if(!a.getNarudzba().equals(narudzba))
						continue;
					
					Map<String,Object>m1=new HashMap<>();
					m1.put("artikal", a.getProizvod().getNaziv());
					m1.put("kolicina", a.getKolicina());
					DecimalFormat df = new DecimalFormat("#.00");
					m1.put("vrijednost", df.format(a.getCijenaPoKomadu()));
					
					tv2.getItems().add(m1);
				}
			    
			    prikaziD.getChildren().clear();
			    prodajnoMjestoL.setBorder(new Border(new BorderStroke(Color.GREY, BorderStrokeStyle.SOLID,CornerRadii.EMPTY,BorderWidths.DEFAULT)));
			    prodajnoMjestoL.setBackground(new Background(new BackgroundFill(Color.LIGHTGREY,CornerRadii.EMPTY,Insets.EMPTY)));
			    prodajnoMjestoL.setMinWidth(400);
			    prodajnoMjestoL.setMinHeight(25);
			    prodajnoMjestoL.setAlignment(Pos.CENTER);
				prikaziD.getChildren().addAll(tv2,prodajnoMjestoL);
				prikaziD.setVisible(true);
				prikaziD.setManaged(true);
				
			});
			
			prikaziDetalje2.setOnAction(ex -> {		
				Map<String,Object> selected=(HashMap<String,Object>)tv1.getSelectionModel().getSelectedItem();
				if(prikaziD2.isManaged() && prikaziD2.isVisible()) {
					prikaziD2.setManaged(false);
					prikaziD2.setVisible(false);
					return;
				}
				if(selected==null)
								return;
							
				tv3.getItems().clear();
				int ID=(int)selected.get("id");
				Narudzba narudzba=narudzbe.get(ID);
				ProdajnoMjesto pm=null;
				if(narudzba.getTrgovac() != null) {
					pm=narudzba.getTrgovac().getProdajnoMjesto();
					prodajnoMjesto2L.setText(""+pm);
					}
				else
					prodajnoMjesto2L.setText("Prodajno mjesto jos nije dodijeljeno");
							
				TreeMap<Integer,ArtikalNarudzbe>artikli=ArtikalNarudzbe.getArtikliNarudzbe();
					for(ArtikalNarudzbe a: artikli.values()) {
						if(!a.getNarudzba().equals(narudzba))
							continue;
								
						Map<String,Object>m1=new HashMap<>();
						m1.put("artikal", a.getProizvod().getNaziv());
						m1.put("kolicina", a.getKolicina());
						DecimalFormat df = new DecimalFormat("#.00");
						m1.put("vrijednost", df.format(a.getCijenaPoKomadu()));
						
						tv3.getItems().add(m1);
						}
						    
						    
				prikaziD2.getChildren().clear();
				prodajnoMjesto2L.setBorder(new Border(new BorderStroke(Color.GREY, BorderStrokeStyle.SOLID,CornerRadii.EMPTY,BorderWidths.DEFAULT)));
			    prodajnoMjesto2L.setBackground(new Background(new BackgroundFill(Color.LIGHTGREY,CornerRadii.EMPTY,Insets.EMPTY)));
			    prodajnoMjesto2L.setMinWidth(400);
			    prodajnoMjesto2L.setMinHeight(25);
			    prodajnoMjesto2L.setAlignment(Pos.CENTER);
				prikaziD2.getChildren().addAll(tabela4VB,prodajnoMjesto2L);
				prikaziD2.setVisible(true);
				prikaziD2.setManaged(true);
			});
			
			otkaziNarudzbu.setOnAction(ex -> {
				Map<String,Object> selected=(HashMap<String,Object>)tv1.getSelectionModel().getSelectedItem();
				if (selected==null)
					return;
				int ID=(int)selected.get("id");
				UcitavanjePodataka.deleteNarudzba(ID);
				tv1.getItems().remove(selected);
				if(prikaziD2.isManaged() && prikaziD2.isVisible()) {
					prikaziD2.setManaged(false);
					prikaziD2.setVisible(false);
				}
				
				narudzbe.remove(ID);
				
			});
			
			//NOVA NARUDZBA
			novaNarudzba.setOnAction(ex -> {
				TableView tv4=new TableView();
				tv4.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
				TableColumn<Map,String> kolonaNaziv=new TableColumn<>("Naziv");
				TableColumn<Map,String> kolonaCijena=new TableColumn<>("Cijena");
				kolonaNaziv.setCellValueFactory(new MapValueFactory<>("naziv"));
				kolonaCijena.setCellValueFactory(new MapValueFactory<>("cijena"));
				tv4.getColumns().addAll(kolonaNaziv, kolonaCijena);
				
				tv4.setMaxHeight(300);
				tv4.setMinWidth(400);
			    kolonaNaziv.prefWidthProperty().bind(tv4.widthProperty().multiply(0.65));
			    kolonaCijena.prefWidthProperty().bind(tv4.widthProperty().multiply(0.35));
				
				ScrollPane sp2=new ScrollPane();
				sp2.setContent(tv4);
				sp2.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
				sp2.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
				
			    TreeMap<Integer,Proizvod>proizvodi=Proizvod.getProizvodi();
				for(Proizvod p: proizvodi.values()) {
							
					Map<String,Object>m1=new HashMap<>();
					m1.put("naziv", p.getNaziv());
					DecimalFormat df = new DecimalFormat("#.00");
					m1.put("cijena", df.format(p.getCijena()));
					m1.put("id", p.getID());
					
					tv4.getItems().add(m1);
					}
			    
				VBox desniB=new VBox(10);
				desniB.setAlignment(Pos.CENTER);
				Label kolicina=new Label("Kolicina:");
				TextField kolicinaTF=new TextField();
				kolicinaTF.setMaxWidth(100);
				Button dodaj=new Button("Dodaj u korpu");
				Label greska6=new Label("");
				greska6.setTextFill(Color.RED);
				greska6.setManaged(false);
				greska6.setVisible(false);
				VBox desniDjeca=new VBox(10);
				desniDjeca.getChildren().addAll(kolicina,kolicinaTF,greska6,dodaj);
				desniB.getChildren().add(desniDjeca);
			    VBox tabela5VB=new VBox(tv4);
			    tabela5VB.setPadding(new Insets(20,10,10,20));
			    HBox tabela5HB=new HBox(10);
			    tabela5HB.getChildren().addAll(tabela5VB,desniB);
			    
			    Label korpa=new Label("Korpa:");
			    TableView tv5=new TableView();
			    tv5.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
				TableColumn<Map,String> kolonaNaziv1=new TableColumn<>("Naziv");
				TableColumn<Map,String> kolonaCijena1=new TableColumn<>("Cijena");
				TableColumn<Map,String> kolonaKolicina1=new TableColumn<>("Kolicina");
				kolonaNaziv1.setCellValueFactory(new MapValueFactory<>("naziv"));
				kolonaCijena1.setCellValueFactory(new MapValueFactory<>("cijena"));
				kolonaKolicina1.setCellValueFactory(new MapValueFactory<>("kolicina"));
				tv5.getColumns().addAll(kolonaNaziv1, kolonaCijena1,kolonaKolicina1);
				
				tv5.setMaxHeight(150);
				tv5.setMaxWidth(400);
				
			    ScrollPane sp3=new ScrollPane();
				sp3.setContent(tv5);
				sp3.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
				sp3.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
			    
			    Label ukupanIzn=new Label("Ukupan iznos:");
			    Label ukupanIznTF=new Label();
			    ukupanIznTF.setAlignment(Pos.CENTER);
			    ukupanIznTF.setMinWidth(100);
			    ukupanIznTF.setMinHeight(20);
			    ukupanIznTF.setBackground(new Background((new BackgroundFill(Color.WHITE,CornerRadii.EMPTY,Insets.EMPTY))));
			    Label greskaUk=new Label();
			    greskaUk.setTextFill(Color.RED);
			    HBox ukupanIznHB=new HBox(10);
			    ukupanIznHB.getChildren().addAll(ukupanIzn,ukupanIznTF,greskaUk);
			    VBox kosarica=new VBox(5);
			    kosarica.getChildren().addAll(korpa,tv5,ukupanIznHB);
			    kosarica.setPadding(new Insets(10,10,10,20));
			    Button naruci=new Button("Narucite");
			    Button nazad=new Button("Nazad");
			    HBox dugNN=new HBox(20);
			    dugNN.getChildren().addAll(naruci,nazad);
			    dugNN.setPadding(new Insets(10,10,10,20));
			    VBox narudzba=new VBox(10);
			    narudzba.setBackground(new Background((new BackgroundFill(Color.rgb(244,244,244),CornerRadii.EMPTY,Insets.EMPTY))));
			    narudzba.getChildren().addAll(tabela5HB,kosarica,dugNN);
			    Scene scena3=new Scene(narudzba,600,650);
				primaryStage.setScene(scena3);
				
				dodaj.setOnAction(exc -> {
					greskaUk.setText("");
					Map<String,Object> selected=(HashMap<String,Object>)tv4.getSelectionModel().getSelectedItem();
					if(selected== null)
						return;
					if(kolicinaTF.getText().equals("")) {
						greska6.setVisible(true);
						greska6.setManaged(true);
						greska6.setText("Nije validan unos!");
						return;
						}
					
					int kolicinaBroj=0;
					try {
						kolicinaBroj=Integer.parseInt(kolicinaTF.getText());
					}catch(Exception excep) {
						greska6.setText("Nije validan unos!");
						greska6.setVisible(true);
						greska6.setManaged(true);
						return;
					}
					if(greska6.isManaged() && greska6.isVisible()) {
						greska6.setVisible(false);
						greska6.setManaged(false);
						}
					
					int ID1=(int)selected.get("id");
					Proizvod proizvod=proizvodi.get(ID1);
					
					double ukupno=0;
					for(Object mapa: tv5.getItems()) {
						Map<String,Object>m=(HashMap<String, Object>)mapa;
						ukupno+=(double)m.get("cijena")*(int)m.get("kolicina");
					}
					
					for(Object mapa: tv5.getItems()) {
						Map<String,Object>m=(HashMap<String, Object>)mapa;
						if((int)m.get("id")==ID1) {
							m.put("kolicina",(int)m.get("kolicina")+kolicinaBroj);
							ukupno+=(double)m.get("cijena")*kolicinaBroj;
							DecimalFormat df = new DecimalFormat("#.00");
							ukupanIznTF.setText(df.format(ukupno)+"");
							tv5.refresh();
							return;
						}
					}
					
					Map<String,Object>m1=new HashMap<>();
					m1.put("naziv", proizvod.getNaziv());
					m1.put("cijena",proizvod.getCijena());
					m1.put("kolicina", kolicinaBroj);
					m1.put("id", proizvod.getID());
					
					tv5.getItems().add(m1);
					ukupno+=proizvod.getCijena()*kolicinaBroj;
					DecimalFormat df = new DecimalFormat("#.00");
					ukupanIznTF.setText(df.format(ukupno)+"");
				});
				
				naruci.setOnAction(exc -> {
					if(ukupanIznTF.getText().isEmpty()) {
						greskaUk.setText("Korpa je prazna!");
						return;
					}
					
					int narID=narudzbe.lastKey()+1;
					int kupID=kupacS.getID();
					LocalDate datum=java.time.LocalDate.now();
					String datumNar=datum.toString();
					String datumIsp=null;
					String napomena=null;
					Narudzba n=new Narudzba(narID,kupID,-1,datumNar,datumIsp,napomena);
					UcitavanjePodataka.insertNarudzba(n);
					TreeMap<Integer,ArtikalNarudzbe>artikli=ArtikalNarudzbe.getArtikliNarudzbe();
					for(Object mapa: tv5.getItems()) {
						Map<String,Object>m=(HashMap<String, Object>)mapa;
						int proID=(int)m.get("id");
						int kolPr=(int)m.get("kolicina");
						double cijP=(double)m.get("cijena");
						int anID=artikli.lastKey()+1;
						ArtikalNarudzbe a=new ArtikalNarudzbe(narID,proID,kolPr,cijP,anID);
						UcitavanjePodataka.insertArtikal(a);
					}
					primaryStage.setScene(scena2);
					tv1.getItems().clear();
					for(Narudzba n1: narudzbe.values()) {
						if(n1.getDatumIsporuke()!=null || !n1.getKupac().equals(kupacS))
							continue;
						
						Map<String,Object>m1=new HashMap<>();
						m1.put("datumNar", n1.getDatumNarudzbe());
						m1.put("datumIsp", "Ceka se");
						DecimalFormat df = new DecimalFormat("#.00");
						m1.put("vrijednost", df.format(n1.getVrijednostNarudzbe()));
						m1.put("id", n1.getID());
						
						tv1.getItems().add(m1);
					}
				});
				nazad.setOnAction(exc -> {
					primaryStage.setScene(scena2);
				});
			});
			}
			
			//TRGOVAC
			if(trgRB.isSelected()) {
				
				greska3.setText("");
				if(!Trgovac.postojiKorisnicko(korIme.getText())){
					greska3.setManaged(true);
					greska3.setText("Nepostojece korisnicko ime ili email!");
						return;
					}
				
				if(!Trgovac.ispravnaLozinka(korIme.getText(),loz.getText())) {
					greska3.setManaged(true);
					greska3.setText("Neispravna lozinka! Pokusajte ponovo.");
					return;
				}
				
				greska3.setText("");
					
				
				HBox informacije=new HBox(70);
				informacije.setPadding(new Insets(10,10,10,10));
				informacije.setMaxHeight(300);
				informacije.setMinWidth(700);
				informacije.setBackground(new Background(new BackgroundFill(Color.rgb(219,219,219),CornerRadii.EMPTY,Insets.EMPTY)));
				String ti=korIme.getText();
				Trgovac trgovacS1=null;
				TreeMap<Integer,Trgovac>trgovci=Trgovac.getTrgovci();
				for(Trgovac trg: trgovci.values())
					if(trg.getKorisnickoIme().equals(ti))
						trgovacS1=trg;
				final Trgovac trgovacS=trgovacS1;
				Label imeINF=new Label("Ime: "+trgovacS.getIme());
				Label prezimeINF=new Label("Prezime: "+trgovacS.getPrezime());
				Label prodajnoINF=new Label(""+trgovacS.getProdajnoMjesto());
				VBox infoVB=new VBox(10);
				infoVB.getChildren().addAll(imeINF,prezimeINF,prodajnoINF);
				VBox odjavaVB=new VBox(10);
				Button odjava=new Button("Odjavite se");
				odjavaVB.getChildren().add(odjava);
				odjavaVB.setAlignment(Pos.CENTER);
				informacije.getChildren().addAll(infoVB,odjavaVB);
				
				Label neprihvL=new Label("Narudzbe koje nisu prihvacene:");
				TableView tv2=new TableView();
			    tv2.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
				TableColumn<Map,String> kolonaK1=new TableColumn<>("Kupac");
				TableColumn<Map,String> kolonaDK1=new TableColumn<>("Drzava");
				TableColumn<Map,String> kolonaDN1=new TableColumn<>("Datum narudzbe");
				TableColumn<Map,String> kolonaV1=new TableColumn<>("Vrijednost");
				kolonaK1.setCellValueFactory(new MapValueFactory<>("kupac"));
				kolonaDK1.setCellValueFactory(new MapValueFactory<>("drzava"));
				kolonaDN1.setCellValueFactory(new MapValueFactory<>("datumN"));
				kolonaV1.setCellValueFactory(new MapValueFactory<>("vrijednost"));
				tv2.getColumns().addAll(kolonaK1,kolonaDK1,kolonaDN1,kolonaV1);
				
				tv2.setMaxSize(550, 100);
				ScrollPane sp=new ScrollPane();
				sp.setContent(tv2);
				sp.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
				sp.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
				
			    TreeMap<Integer,Narudzba>Nnarudzbe=Narudzba.getNeprihvaceneNar();
				for(Narudzba n: Nnarudzbe.values()) {
					
					boolean postoji=ProdajnoMjesto.postojiProdajno(n.getKupac().getDrzava());
					if(!postoji) {
					Map<String,Object>m1=new HashMap<>();
					Kupac k=n.getKupac();
					String imePrezK=k.getIme()+" "+k.getPrezime();
					m1.put("kupac", imePrezK);
					m1.put("drzava", k.getDrzava());
					m1.put("datumN", n.getDatumNarudzbe());
					DecimalFormat df = new DecimalFormat("#.00");
					m1.put("vrijednost", df.format(n.getVrijednostNarudzbe()));
					m1.put("id", n.getID());
					
					tv2.getItems().add(m1);
					}
					else {
						Kupac k=n.getKupac();
						boolean odgovara=trgovacS.odgovaraDrzava(k.getDrzava());
						if(odgovara) {
							Map<String,Object>m1=new HashMap<>();
					
							String imePrezK=k.getIme()+" "+k.getPrezime();
							m1.put("kupac", imePrezK);
							m1.put("drzava", k.getDrzava());
							m1.put("datumN", n.getDatumNarudzbe());
							DecimalFormat df = new DecimalFormat("#.00");
							m1.put("vrijednost", df.format(n.getVrijednostNarudzbe()));
							m1.put("id", n.getID());
							
							tv2.getItems().add(m1);
							}
					}
				}
				Button prihvatiNar=new Button("Prihvatite narudzbu");
				VBox prihvatiVB=new VBox(5);
				prihvatiVB.getChildren().addAll(neprihvL,tv2,prihvatiNar);
				prihvatiVB.setPadding(new Insets(10,10,10,20));
				
				Label odobrene=new Label("Odobrene narudzbe:");
				Button prikazi=new Button("Prikazi/Sakrij");
				HBox prikaziHB=new HBox(10);
				prikaziHB.getChildren().addAll(odobrene,prikazi);
				prikaziHB.setPadding(new Insets(10,10,0,20));
				
				TableView tv=new TableView();
			    tv.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
				TableColumn<Map,String> kolonaK=new TableColumn<>("Kupac");
				TableColumn<Map,String> kolonaDN=new TableColumn<>("Datum narudzbe");
				TableColumn<Map,String> kolonaDI=new TableColumn<>("Datum isporuke");
				TableColumn<Map,String> kolonaV=new TableColumn<>("Vrijednost");
				kolonaK.setCellValueFactory(new MapValueFactory<>("kupac"));
				kolonaDN.setCellValueFactory(new MapValueFactory<>("datumN"));
				kolonaDI.setCellValueFactory(new MapValueFactory<>("datumI"));
				kolonaV.setCellValueFactory(new MapValueFactory<>("vrijednost"));
				tv.getColumns().addAll(kolonaK,kolonaDN,kolonaDI,kolonaV);
				
				tv.setMaxSize(550, 150);
				ScrollPane sp4=new ScrollPane();
				sp4.setContent(tv);
				sp4.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
				sp4.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
			    
			    TreeMap<Integer,Narudzba>narudzbe=Narudzba.getNarudzbe();
				for(Narudzba n: narudzbe.values()) {
					if(n.getTrgovac()==null || !n.getTrgovac().equals(trgovacS))
						continue;
					
					Map<String,Object>m1=new HashMap<>();
					Kupac k=n.getKupac();
					String imePrezK=k.getIme()+" "+k.getPrezime();
					m1.put("kupac", imePrezK);
					m1.put("datumN", n.getDatumNarudzbe());
					if(n.getDatumIsporuke()!=null)
						m1.put("datumI", n.getDatumIsporuke());
					else
						m1.put("datumI", "Ceka se");
					DecimalFormat df = new DecimalFormat("#.00");
					m1.put("vrijednost", df.format(n.getVrijednostNarudzbe()));
					m1.put("id", n.getID());
					
					tv.getItems().add(m1);
				}
			    
			    VBox tabela1HB=new VBox(10);
			    tabela1HB.setPadding(new Insets(0,10,10,20));
			    
			    Label unosIsp=new Label("Unesite datum isporuke:");
			    TextField unosTFISP=new TextField();
			    unosTFISP.setMaxWidth(200);
			    Button azurISP=new Button("Azuriranje");
			    Label greskaIsp=new Label();
			    greskaIsp.setTextFill(Color.RED);
			    greskaIsp.setManaged(false);
			    greskaIsp.setVisible(false);
			    HBox unosHB=new HBox(10);
			    unosHB.getChildren().addAll(unosIsp,unosTFISP,azurISP,greskaIsp);
			    unosHB.setPadding(new Insets(0,10,0,0));
			    
			    Button dodajTRG= new Button("Dodaj trgovca");
			    Button dodajPM= new Button("Dodaj prodajno mjesto");
			    Button dodajPRO=new Button("Dodaj proizvod");
			    Button azurirajPRO=new Button("Azuriraj proizvod");
			    HBox dodavanje=new HBox(30);
			    dodavanje.getChildren().addAll(dodajTRG,dodajPM,dodajPRO,azurirajPRO);
			    dodavanje.setPadding(new Insets(20,10,10,20));
			    
			    tabela1HB.getChildren().addAll(tv,unosHB);
			    tabela1HB.setVisible(false);
			    tabela1HB.setManaged(false);
			    
			    Label greskaDOD=new Label();
			    greskaDOD.setManaged(false);
			    greskaDOD.setTextFill(Color.GREEN);
			    greskaDOD.setPadding(new Insets(0,0,0,10));
				VBox root=new VBox(10);
				root.getChildren().addAll(informacije,prihvatiVB,prikaziHB,tabela1HB,dodavanje,greskaDOD);
				Scene scena3=new Scene(root,600,650);
				primaryStage.setScene(scena3);
				
				odjava.setOnAction(ex -> {
					korIme.setText("");
					loz.setText("");
					kupRB.setSelected(false);
					trgRB.setSelected(false);
					primaryStage.setScene(scena);
				});
				
				prikazi.setOnAction(ex -> {
					tabela1HB.setVisible(!tabela1HB.isVisible());
				    tabela1HB.setManaged(!tabela1HB.isManaged());
				});
				
				prihvatiNar.setOnAction(ex -> {
					Map<String,Object> selected=(HashMap<String,Object>)tv2.getSelectionModel().getSelectedItem();
					if(selected==null)
						return;
					int narID=(int)selected.get("id");
					Narudzba n=narudzbe.get(narID);
					UcitavanjePodataka.updateNarudzba(n, trgovacS.getID(), "trgovac");
					n.setTrgovac(trgovacS);
					Nnarudzbe.remove(narID);
					
					tv2.getItems().clear();
					for(Narudzba n1: Nnarudzbe.values()) {
						
						boolean postoji=ProdajnoMjesto.postojiProdajno(n1.getKupac().getDrzava());
						if(!postoji) {
						Map<String,Object>m1=new HashMap<>();
						Kupac k=n1.getKupac();
						String imePrezK=k.getIme()+" "+k.getPrezime();
						m1.put("kupac", imePrezK);
						m1.put("drzava", k.getDrzava());
						m1.put("datumN", n1.getDatumNarudzbe());
						DecimalFormat df = new DecimalFormat("#.00");
						m1.put("vrijednost", df.format(n1.getVrijednostNarudzbe()));
						m1.put("id", n1.getID());
						
						tv2.getItems().add(m1);
						}
						else {
							Kupac k=n.getKupac();
							boolean odgovara=trgovacS.odgovaraDrzava(k.getDrzava());
							if(odgovara) {
								Map<String,Object>m1=new HashMap<>();
						
								String imePrezK=k.getIme()+" "+k.getPrezime();
								m1.put("kupac", imePrezK);
								m1.put("drzava", k.getDrzava());
								m1.put("datumN", n.getDatumNarudzbe());
								DecimalFormat df = new DecimalFormat("#.00");
								m1.put("vrijednost", df.format(n.getVrijednostNarudzbe()));
								m1.put("id", n.getID());
								
								tv2.getItems().add(m1);
								}
						}
					}
					
					tv.getItems().clear();
					for(Narudzba n1: narudzbe.values()) {
						if(n1.getTrgovac()==null || !n1.getTrgovac().equals(trgovacS))
							continue;
						
						Map<String,Object>m1=new HashMap<>();
						Kupac k=n1.getKupac();
						String imePrezK=k.getIme()+" "+k.getPrezime();
						m1.put("kupac", imePrezK);
						m1.put("datumN", n1.getDatumNarudzbe());
						if(n1.getDatumIsporuke()!=null)
							m1.put("datumI", n1.getDatumIsporuke());
						else
							m1.put("datumI", "Ceka se");
						DecimalFormat df = new DecimalFormat("#.00");
						m1.put("vrijednost", df.format(n1.getVrijednostNarudzbe()));
						m1.put("id", n1.getID());
						
						tv.getItems().add(m1);
					}
					
				});
				
				azurISP.setOnAction(ex -> {
					
					Map<String,Object> selected=(HashMap<String,Object>)tv.getSelectionModel().getSelectedItem();
					if (selected==null)
						return;
					int ID=(int)selected.get("id");
					Narudzba n=narudzbe.get(ID);
					if(n.getDatumIsporuke()!=null) {
						greskaIsp.setVisible(true);
						greskaIsp.setManaged(true);
						greskaIsp.setText("Narudzba je vec isporucena!");
						return;
					}
					if(unosTFISP.getText().isEmpty()) {
						greskaIsp.setVisible(true);
						greskaIsp.setManaged(true);
						greskaIsp.setText("Unesite vrijednost!");
						return;
					}
					greskaIsp.setText("");
					String datum=unosTFISP.getText();
					if(datum.length()!=10) {
						greskaIsp.setVisible(true);
						greskaIsp.setManaged(true);
						greskaIsp.setText("Nije validan unos!");
						return;
					}
					String godina=datum.substring(0,4);
					String mjesec=datum.substring(5,7);
					String dan=datum.substring(8, 10);
					int godinaB=0,mjesecB=0,danB=0;
					try {
						godinaB=Integer.parseInt(godina);
						mjesecB=Integer.parseInt(mjesec);
						danB=Integer.parseInt(dan);
					}catch(Exception x) {
						greskaIsp.setVisible(true);
						greskaIsp.setManaged(true);
						greskaIsp.setText("Nije validan unos!");
						return;
					}
					String datum2=n.getDatumNarudzbe();
					String godina2=datum2.substring(0, 4);
					int godina2B=Integer.parseInt(godina2);
					if(godinaB<godina2B || mjesecB>12 || mjesecB<1 || danB>31 || danB<1) {
						greskaIsp.setVisible(true);
						greskaIsp.setManaged(true);
						greskaIsp.setText("Nije validan unos!");
						return;
					}
					greskaIsp.setVisible(false);
					greskaIsp.setManaged(false);
					String datumIsp=godina+"-"+mjesec+"-"+dan;
					UcitavanjePodataka.updateNarudzba(n, datumIsp,"datum");
					
					for(Object mapa: tv.getItems()) {
						Map<String,Object>m=(HashMap<String, Object>)mapa;
						if((int)m.get("id")==n.getID()) {
							m.put("datumI",(String)datumIsp);
							tv.refresh();
							return;
						}
					}
				});
				
				dodajTRG.setOnAction(ex -> {
					VBox dodTrg=new VBox(10);
					dodTrg.setBackground(new Background(new BackgroundFill(Color.rgb(219, 219, 219),CornerRadii.EMPTY,Insets.EMPTY)));
					dodTrg.setPadding(new Insets(10,10,10,10));
					
					TableView tv1=new TableView();
					Label prodajnoT=new Label("Prodajno mjesto:");
					tv1.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
					TableColumn<Map,String> kolonaGrad=new TableColumn<>("Grad");
					TableColumn<Map,String> kolonaDrzava=new TableColumn<>("Drzava");
					TableColumn<Map,String> kolonaAdresa=new TableColumn<>("Adresa");
					kolonaGrad.setCellValueFactory(new MapValueFactory<>("grad"));
					kolonaDrzava.setCellValueFactory(new MapValueFactory<>("drzava"));
					kolonaAdresa.setCellValueFactory(new MapValueFactory<>("adresa"));
					tv1.getColumns().addAll(kolonaAdresa,kolonaGrad,kolonaDrzava);
					
					tv1.setMaxSize(450, 150);
					ScrollPane sp1=new ScrollPane();
					sp1.setContent(tv1);
					sp1.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
					sp1.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
					
				    TreeMap<Integer,ProdajnoMjesto>prodajna=ProdajnoMjesto.getProdajnaMjesta();
					for(ProdajnoMjesto pm: prodajna.values()) {
								
						Map<String,Object>m1=new HashMap<>();
						m1.put("adresa", pm.getAdresa());
						m1.put("grad", pm.getGrad());
						m1.put("drzava", pm.getDrzava());
						m1.put("id", pm.getID());
						
						tv1.getItems().add(m1);
						}
				    VBox prodajnoVB=new VBox();
				    prodajnoVB.getChildren().addAll(prodajnoT,tv1);
					
					Label imeT=new Label("Ime:");
					TextField imeTTF=new TextField();
					imeTTF.setMinWidth(200);
					Label prezimeT=new Label("Prezime:");
					TextField prezimeTTF=new TextField();
					prezimeTTF.setMinWidth(200);
					VBox imeTVB=new VBox(10);
					imeTVB.getChildren().addAll(imeT,imeTTF);
					VBox prezimeTVB=new VBox(10);
					prezimeTVB.getChildren().addAll(prezimeT,prezimeTTF);
					HBox imePrezT=new HBox(20);
					imePrezT.getChildren().addAll(imeTVB,prezimeTVB);
					
					Label telefonT=new Label("Telefon:");
					TextField telefonTTF=new TextField();
					telefonTTF.setMaxWidth(200);
					Label emailT=new Label("E-mail:");
					TextField emailTTF=new TextField();
					emailTTF.setMaxWidth(200);
					VBox telefonTVB=new VBox(10);
					telefonTVB.getChildren().addAll(telefonT,telefonTTF);
					VBox emailTVB=new VBox(10);
					emailTVB.getChildren().addAll(emailT,emailTTF);
					
					Label korisnickoImeT=new Label("Korisnicko ime:");
					TextField korisnickoTTF=new TextField();
					korisnickoTTF.setMinWidth(200);
					Label lozinkaT=new Label("Lozinka:");
					PasswordField lozinkaTTF=new PasswordField();
					lozinkaTTF.setMinWidth(200);
					VBox korisnickoTVB=new VBox(10);
					korisnickoTVB.getChildren().addAll(korisnickoImeT,korisnickoTTF);
					VBox lozinkaTVB=new VBox(10);
					lozinkaTVB.getChildren().addAll(lozinkaT,lozinkaTTF);
					HBox korLozT=new HBox(20);
					korLozT.getChildren().addAll(korisnickoTVB,lozinkaTVB);
					
					RadioButton muskiT=new RadioButton("M");
					RadioButton zenskiT=new RadioButton("Z");
					ToggleGroup tg2=new ToggleGroup();
					muskiT.setToggleGroup(tg2);
					zenskiT.setToggleGroup(tg2);
					HBox mzTHB=new HBox(20);
					mzTHB.getChildren().addAll(muskiT,zenskiT);
					
					Label greska5=new Label();
					greska5.setTextFill(Color.RED);
					greska5.setManaged(false);
					greska5.setVisible(false);
					Button dodajT=new Button("Dodajte trgovca");
					Button nazadT=new Button("Nazad");
					HBox dugT=new HBox(20);
					dugT.getChildren().addAll(dodajT,nazadT);
					dodTrg.getChildren().addAll(prodajnoVB,imePrezT,mzTHB,emailTVB,telefonTVB,korLozT,greska5,dugT);
					
					Scene scena4=new Scene(dodTrg,500,550);
					primaryStage.setScene(scena4);
					
					nazadT.setOnAction(exc -> {
						greskaDOD.setManaged(false);
						primaryStage.setScene(scena3);
					});
					dodajT.setOnAction(exc -> {
						Map<String,Object> selected=(HashMap<String,Object>)tv1.getSelectionModel().getSelectedItem();
						if (selected==null) {
							greska5.setManaged(true);
							greska5.setVisible(true);
							greska5.setText("Prodajno mjesto nije oznaceno!");
							return;}
						if(imeTTF.getText().isEmpty() || prezimeTTF.getText().isEmpty() || 
								telefonTTF.getText().isEmpty() || emailTTF.getText().isEmpty()
								|| korisnickoTTF.getText().isEmpty() || lozinkaTTF.getText().isEmpty()
								|| (!muskiT.isSelected() && !zenskiT.isSelected())) {
							greska5.setText("Niste unijeli sve podatke!");
							greska5.setManaged(true);
							greska5.setVisible(true);
							return;
						}
						if(Trgovac.postojiKorisnicko(korisnickoTTF.getText())) {
							greska5.setText("Korisnicko ime vec postoji!");
							greska5.setManaged(true);
							greska5.setVisible(true);
							return;
						}
						greska5.setManaged(false);
						greska5.setVisible(false);
					
						int prodID=(int)selected.get("id");
						String ime1=imeTTF.getText();
						String prezime1=prezimeTTF.getText();
						String telefon1=telefonTTF.getText();
						String email1=emailTTF.getText();
						String korisnicko1=korisnickoTTF.getText();
						String lozinka1=lozinkaTTF.getText();
						String pol1="";
						if(muskiT.isSelected())
							pol1="M";
						else
							pol1="Z";
						
						Trgovac t=new Trgovac(korisnicko1,ime1,prezime1,lozinka1,telefon1,pol1,email1,prodID,false);
						UcitavanjePodataka.insertTrgovac(t);
						greskaDOD.setText("Uspjesno dodavanje trgovca!");
						greskaDOD.setManaged(true);
						greskaDOD.setVisible(true);
						primaryStage.setScene(scena3);
						if(!service.isRunning())
							service.start();
					});
				});
				
				dodajPM.setOnAction(ex -> {
					
					Label gradPM=new Label("Grad:");
					TextField gradPMTF=new TextField();
					gradPMTF.setMaxWidth(200);
					Label drzavaPM=new Label("Drzava:");
					TextField drzavaPMTF=new TextField();
					drzavaPMTF.setMaxWidth(200);
					Label adresaPM=new Label("Adresa:");
					TextField adresaPMTF=new TextField();
					adresaPMTF.setMaxWidth(200);
					Label telefonPM=new Label("Telefon");
					TextField telefonPMTF=new TextField();
					telefonPMTF.setMaxWidth(200);
					Label greskaPM=new Label();
					greskaPM.setVisible(false);
					greskaPM.setManaged(false);
					greskaPM.setTextFill(Color.RED);
					Button dodajPMB=new Button("Dodaj prodajno mjesto");
					Button nazadPM=new Button("Nazad");
					HBox dugPM=new HBox(20);
					dugPM.getChildren().addAll(dodajPMB,nazadPM);
					VBox prodajnoVB=new VBox(10);
					prodajnoVB.getChildren().addAll(gradPM,gradPMTF,drzavaPM,drzavaPMTF,adresaPM,adresaPMTF,telefonPM,telefonPMTF,greskaPM,dugPM);
					prodajnoVB.setBackground(new Background(new BackgroundFill(Color.rgb(219, 219, 219),CornerRadii.EMPTY,Insets.EMPTY)));
					prodajnoVB.setPadding(new Insets(10,10,10,10));
					
					Scene scena5=new Scene(prodajnoVB,300,350);
					primaryStage.setScene(scena5);
					
					nazadPM.setOnAction(exc -> {
						greskaDOD.setManaged(false);
						primaryStage.setScene(scena3);
					});
					
					dodajPMB.setOnAction(exc -> {
						if(gradPMTF.getText().isEmpty() || drzavaPMTF.getText().isEmpty() || 
							drzavaPMTF.getText().isEmpty() || telefonPMTF.getText().isEmpty()) {
							greskaPM.setVisible(true);
							greskaPM.setManaged(true);
							greskaPM.setText("Niste unijeli sve podatke!");
							return;
						}
						greskaPM.setVisible(false);
						greskaPM.setManaged(false);
						String grad1=gradPMTF.getText();
						String drzava1=drzavaPMTF.getText();
						String adresa1=adresaPMTF.getText();
						String telefon1=telefonPMTF.getText();
						
						ProdajnoMjesto pm=new ProdajnoMjesto(grad1,drzava1,adresa1,telefon1);
						UcitavanjePodataka.insertProdajnoMjesto(pm);
						greskaDOD.setText("Uspjesno dodavanje prodajnog mjesta!");
						greskaDOD.setManaged(true);
						greskaDOD.setVisible(true);
						primaryStage.setScene(scena3);
						if(!service.isRunning())
							service.start();
					});
				});
				
				dodajPRO.setOnAction(ex -> {
					
					Label nazivPRO=new Label("Naziv:");
					TextField nazivPTF=new TextField();
					nazivPTF.setMaxWidth(200);
					Label opisPRO=new Label("Opis:");
					TextField opisPTF=new TextField();
					opisPTF.setMaxWidth(200);
					Label cijenaPRO=new Label("Cijena:");
					TextField cijenaPTF=new TextField();
					cijenaPTF.setMaxWidth(200);
					Label greskaPRO=new Label();
					greskaPRO.setManaged(false);
					greskaPRO.setVisible(false);
					greskaPRO.setTextFill(Color.RED);
					Button dodajPROB=new Button("Dodaj proizvod");
					Button nazadPRO=new Button("Nazad");
					HBox dugPRO=new HBox(20);
					dugPRO.getChildren().addAll(dodajPROB,nazadPRO);
					VBox proizvodVB=new VBox(10);
					proizvodVB.getChildren().addAll(nazivPRO,nazivPTF,opisPRO,opisPTF,cijenaPRO,cijenaPTF,greskaPRO,dugPRO);
					proizvodVB.setBackground(new Background(new BackgroundFill(Color.rgb(219, 219, 219),CornerRadii.EMPTY,Insets.EMPTY)));
					proizvodVB.setPadding(new Insets(10,10,10,10));
					
					Scene scena5=new Scene(proizvodVB,300,300);
					primaryStage.setScene(scena5);
					
					nazadPRO.setOnAction(exc -> {
						greskaDOD.setManaged(false);
						primaryStage.setScene(scena3);
					});
					
					dodajPROB.setOnAction(exc -> {
						if(nazivPTF.getText().isEmpty() || 
							cijenaPTF.getText().isEmpty()) {
								greskaPRO.setVisible(true);
								greskaPRO.setManaged(true);
								greskaPRO.setText("Niste unijeli sve podatke!");
								return;
							}
						double cijena=0;
						try {
							cijena=Double.parseDouble(cijenaPTF.getText());
						}catch(Exception x) {
							greskaPRO.setVisible(true);
							greskaPRO.setManaged(true);
							greskaPRO.setText("Nije validan unos cijene!");
							return;
						}
						greskaPRO.setVisible(false);
						greskaPRO.setManaged(false);
						String naziv1=nazivPTF.getText();
						String opis1=opisPTF.getText();
						
						Proizvod p=new Proizvod(naziv1,opis1,cijena);
						UcitavanjePodataka.insertProizvod(p);
						greskaDOD.setText("Uspjesno dodavanje proizvoda!");
						greskaDOD.setManaged(true);
						greskaDOD.setVisible(true);
						primaryStage.setScene(scena3);
						if(!service.isRunning())
							service.start();
					});
				});
				
				azurirajPRO.setOnAction(ex -> {
					TableView tv1=new TableView();
					Label proizvodL=new Label("Izaberite proizvod:");
					tv1.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
					TableColumn<Map,String> kolonaNaziv=new TableColumn<>("Naziv");
					TableColumn<Map,String> kolonaOpis=new TableColumn<>("Opis");
					TableColumn<Map,String> kolonaCijena=new TableColumn<>("Cijena");
					kolonaNaziv.setCellValueFactory(new MapValueFactory<>("naziv"));
					kolonaOpis.setCellValueFactory(new MapValueFactory<>("opis"));
					kolonaCijena.setCellValueFactory(new MapValueFactory<>("cijena"));
					tv1.getColumns().addAll(kolonaNaziv,kolonaOpis,kolonaCijena);
					
					tv1.setMaxSize(450, 300);
					ScrollPane sp2=new ScrollPane();
					sp2.setContent(tv1);
					sp2.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
					sp2.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
				    
				    TreeMap<Integer,Proizvod> proizvodi=Proizvod.getProizvodi();
					for(Proizvod p: proizvodi.values()) {
								
						Map<String,Object>m1=new HashMap<>();
						m1.put("naziv", p.getNaziv());
						m1.put("opis", p.getOpis());
						DecimalFormat df = new DecimalFormat("#.00");
						m1.put("cijena", df.format(p.getCijena()));
						m1.put("id", p.getID());
						
						tv1.getItems().add(m1);
						}
					VBox azurVB=new VBox();
					azurVB.getChildren().addAll(proizvodL,tv1);
					
					Label aznazivPRO=new Label("Azuriraj naziv:");
					TextField aznazivPTF=new TextField();
					aznazivPTF.setMaxWidth(200);
					Label azopisPRO=new Label("Azuriraj opis:");
					TextField azopisPTF=new TextField();
					azopisPTF.setMaxWidth(200);
					Label azcijenaPRO=new Label("Azuriraj cijenu:");
					TextField azcijenaPTF=new TextField();
					azcijenaPTF.setMaxWidth(200);
					Label greskaAZ=new Label();
					greskaAZ.setTextFill(Color.RED);
					greskaAZ.setManaged(false);
					greskaAZ.setVisible(false);
					
					Button azurPROB=new Button("Azuriraj proizvod");
					Button aznazad=new Button("Nazad");
					HBox azPRO=new HBox(20);
					azPRO.getChildren().addAll(azurPROB,aznazad);
					VBox azuriranjeP=new VBox(10);
					azuriranjeP.getChildren().addAll(azurVB,aznazivPRO,aznazivPTF,azopisPRO,azopisPTF,azcijenaPRO,azcijenaPTF,greskaAZ,azPRO);
					azuriranjeP.setBackground(new Background(new BackgroundFill(Color.rgb(219, 219, 219),CornerRadii.EMPTY,Insets.EMPTY)));
					azuriranjeP.setPadding(new Insets(10,10,10,10));
					
					Scene scena6=new Scene(azuriranjeP,500,600);
					primaryStage.setScene(scena6);
					
					aznazad.setOnAction(exc -> {
						greskaDOD.setManaged(false);
						primaryStage.setScene(scena3);
					});
					azurPROB.setOnAction(exc -> {
						Map<String,Object> selected=(HashMap<String,Object>)tv1.getSelectionModel().getSelectedItem();
						if(selected==null) {
							greskaAZ.setManaged(true);
							greskaAZ.setVisible(true);
							greskaAZ.setText("Niste oznacili proizvod!");
							return;
						}
						if(aznazivPTF.getText().isEmpty() && azopisPTF.getText().isEmpty()
							&& azcijenaPTF.getText().isEmpty()) {
							greskaAZ.setManaged(true);
							greskaAZ.setVisible(true);
							greskaAZ.setText("Niste nista unijeli!");
							return;
						}
						greskaAZ.setManaged(false);
						greskaAZ.setVisible(false);
						
						int prodID=(int)selected.get("id");
						Proizvod p=proizvodi.get(prodID);
						String naziv1="";
						String opis1="";
						double cijena1=0;
						
						if(!aznazivPTF.getText().isEmpty()) {
							naziv1=aznazivPTF.getText();
							UcitavanjePodataka.updateProizvod(p, naziv1, "naziv");
						}
						if(!azopisPTF.getText().isEmpty()) {
							opis1=azopisPTF.getText();
							UcitavanjePodataka.updateProizvod(p, opis1, "opis");
						}
						if(!azcijenaPTF.getText().isEmpty()) {
							try {
							cijena1=Double.parseDouble(azcijenaPTF.getText());
							}catch(Exception x) {
								greskaAZ.setManaged(true);
								greskaAZ.setVisible(true);
								greskaAZ.setText("Cijena nije validna!");
								return;
							}
							UcitavanjePodataka.updateProizvod(p, cijena1, "cijena");
						}
						primaryStage.setScene(scena3);
						greskaDOD.setText("Uspjesno azuriranje proizvoda!");
						greskaDOD.setManaged(true);
						greskaDOD.setVisible(true);
						if(!service.isRunning())
							service.start();
					});
				});
				service.setOnSucceeded(ex -> {
					greskaDOD.setManaged(false);
					greskaDOD.setVisible(false);
					service.reset();
				});
			}
		});
		
		
		regB.setOnAction(e->{
			
			primaryStage.setScene(scenaREG);
		});
		
		nazadR.setOnAction(e -> {
			greska.setText("");
			primaryStage.setScene(scena);
		});
		
		reg.setOnAction(e-> {
			
			if(imeTF.getText().isEmpty() || prezimeTF.getText().isEmpty() || lozinkaTF.getText().isEmpty() 
					|| korisnickoTF.getText().isEmpty() || telefonTF.getText().isEmpty()
					|| emailTF.getText().isEmpty() || adresaTF.getText().isEmpty() 
					|| gradTF.getText().isEmpty() || drzavaTF.getText().isEmpty() ||
					postanskiTF.getText().isEmpty() || (!muski.isSelected() && !zenski.isSelected())) {
				greska4.setText("Niste unijeli sve podatke!");
				greska4.setVisible(true);
				greska4.setManaged(true);
				return;
			}
			
			TreeMap<Integer,Kupac>kupci=Kupac.getKupci();
			for(Kupac k: kupci.values())
				if(k.getKorisnickoIme().equals(korisnickoTF.getText())) {
					greska4.setText("Korisnicko ime vec postoji!");
					greska4.setVisible(true);
					greska4.setManaged(true);
					return;
				}
			for(Kupac k: kupci.values())
				if(k.getEmail().equals(emailTF.getText())) {
					greska4.setText("E-mail adresa je vec u upotrebi!");
					greska4.setVisible(true);
					greska4.setManaged(true);
					return;
				}
			
			if(greska4.isManaged()) {
				greska4.setText("");
				greska4.setManaged(false);
				greska4.setVisible(false);
			}
			int ID=kupci.get(kupci.lastKey()).getID()+1;
			String pol="";
			if(muski.isSelected())
				pol="M";
			else
				pol="Z";
			Kupac k=new Kupac(ID,korisnickoTF.getText(),imeTF.getText(),prezimeTF.getText(),lozinkaTF.getText(),
					telefonTF.getText(),adresaTF.getText(),gradTF.getText(),drzavaTF.getText(),
					postanskiTF.getText(),pol,emailTF.getText(),false);
			UcitavanjePodataka.insertKupac(k);
			
			primaryStage.setScene(scena);
			greska.setText("Uspjesno ste se registrovali!");
			imeTF.setText("");prezimeTF.setText("");emailTF.setText("");telefonTF.setText("");lozinkaTF.setText("");korisnickoTF.setText("");
			drzavaTF.setText("");adresaTF.setText("");gradTF.setText("");postanskiTF.setText("");
			muski.setSelected(false);zenski.setSelected(false);
		});
	}
	class ProcessService extends Service<Void>{

		@Override
		protected Task<Void> createTask() {
			return new Task<Void>() {

				@Override
				protected Void call() throws Exception {
					Thread.sleep(2000);
					return null;
				}
				
			};
		}
		
	}
}
