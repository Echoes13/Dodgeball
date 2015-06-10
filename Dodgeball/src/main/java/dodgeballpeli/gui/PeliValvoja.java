
package dodgeballpeli.gui;

import dodgeballpeli.peli.PeliLogiikka;
import javax.swing.JTextField;

/**
  * Luokka joka valvoo peliä ja luo tarvittaessa
  * uuden pelin
  */
public class PeliValvoja{
    
/**
  * @param logiikka Pelin logiikka
  * @param edistaja Pelin edistäjä
  * @param paivitettava Piirtoalusta joka tulee päivittää
  * @param tuloskentta Kenttä jossa näkyy saavutetut pisteet
  * @param ennatyskentta Kenttä jossa näkyy pelituokion ennätystulos
  * @param ennatystulos Pelituokion paras tulos
  */    
    PeliLogiikka logiikka;
    PeliEdistaja edistaja;
    Paivitettava paivitettava;
    JTextField tuloskentta;
    JTextField ennatyskentta;
    int ennatystulos;

/**
  * Konstruktorissa asetetaan Timer-luokan vaaditut
  * parametrit, jonka jälkeen asetetaan pelin logiikka
  * ja asettaa pelin pauselle jotta peli ei heti käynnistyisi,
  * ja myös että peli ei ole päättynyt
  * Päivittäjä asettaa itsensä pelin pyörittäjäksi ja
  * varmistaa ettei mitään tapahdu ensimmäisen sekunnin aikana
  * 
  * @param leveys pelin leveys
  * @param korkeus pelin korkeus
  */    
    public PeliValvoja(int leveys, int korkeus) {  
        this.logiikka = new PeliLogiikka(leveys,korkeus);
    }
    
/**
  * Metodi asettaa piirtoalustan päivittäjälle
  * 
  * @param paivitettava päivitettävä piirtoalusta
  */    
    public void setPaivitettava(Paivitettava paivitettava) {
        this.paivitettava = paivitettava;
    }
    
/**
  * Metodi asettaa pistenäkymän päivittäjälle
  * 
  * @param tulos tulosruutu josta näkyy nykyiset pisteet
  * @param ennatys tulosruutu josta näkyy tuokion ennätystulos
  */    
    public void setTuloskentat(JTextField tulos, JTextField ennatys) {
        this.tuloskentta = tulos;
        this.ennatyskentta = ennatys;
    }

/**
  * Metodi joka palauttaa pelin logiikan
  * 
  * @return pelin logiikka
  */    
    public PeliLogiikka haeLogiikka() {
        return logiikka;
    }
    
/**
  * Metodi joka palauttaa pelin piirtoalustan
  * 
  * @return pelin piirtoalusta
  */    
    public Paivitettava haePaivitettava() {
        return paivitettava;
    }
    
/**
  * Metodi joka palauttaa pelin edistäjän
  * 
  * @return pelin edistäjä
  */    
    public PeliEdistaja haeEdistaja() {
        return edistaja;
    }    
    
/**
  * Metodi joka päivittää pelin pisteet
  */    
    public void nykyinenTulos() {
        tuloskentta.setText("Score: " + logiikka.haePisteet());
    }       
    
/**
  * Metodi joka luo uuden pelin ja päivittää ennätystuloksen
  * jos on tarpeen
  */    
    public void luoUusiPeli() {
        uusiEnnatys();
        logiikka = new PeliLogiikka(logiikka.getLeveys(),logiikka.getKorkeus());
        paivitettava.setNewGame(logiikka);
        paivitettava.paivita();
        nykyinenTulos();
        aloitaPeli();
    }
    
/**
  * Metodi joka tarkistaa onko pelin pisteet suuremmat kuin
  * nykyinen ennätys
  */    
    public void uusiEnnatys() {
        int loppupisteet = logiikka.haePisteet();
        if (loppupisteet >= ennatystulos) {
            ennatystulos = loppupisteet;
            ennatyskentta.setText("Highscore: " + ennatystulos);
        }
    }
    
/**
  * Metodi joka aloittaa uuden pelituokion luomalla
  * pelin edistäjän
  */     
    public void aloitaPeli() {
        this.edistaja = new PeliEdistaja(this);
        edistaja.start();
    }

}
