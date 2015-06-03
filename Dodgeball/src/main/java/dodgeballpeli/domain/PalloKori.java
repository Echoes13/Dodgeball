
package dodgeballpeli.domain;

import dodgeballpeli.peli.PeliLogiikka;
import java.util.ArrayList;
import java.util.Random;

/**
  * Luokka joka määrittelee pelissä olevat pallot, pitää kirjaa niistä,
  * sekä lisää niitä tarpeen mukaan
  * Luokka toteuttaa rajapinnan Liikkuva
  */
public class PalloKori implements Liikkuva {
    
/**
  * @param satu Satunnaisuus pallojen alkupisteiden määrittämiseen
  * @param pallot Lista pelissä olevista palloista
  * @param leveys Pelin oikeanpuoleinen reuna
  * @param korkeus Pelin alareuna
  */    
    private Random satu;
    private ArrayList<Pallo> pallot;
    private int leveys;
    private int korkeus;
    
    
/**
  * Konstruktorissa määritellään satunnaisuus, lista palloista,
  * sekä pelialueen rajat
  * 
  * @param leveys Pelin oikeanpuoleinen reuna
  * @param korkeus Pelin alareuna
  */    
    public PalloKori(int leveys, int korkeus) {
        this.satu = new Random();
        this.pallot = new ArrayList<Pallo>();
        this.leveys = leveys;
        this.korkeus = korkeus;
    }
    
/**
  * Metodi lisää peliin yhden pallon ja lisää pallon samalla
  * oliossa olevaan listaan palloista
  * Uudelle pallolle asetetaan satunnainen alkupiste y:lle sekä
  * pelialueen rajat
  */    
    public void lisaaPeliinPallo() {
        pallot.add(new Pallo(satu.nextInt(korkeus-20), korkeus, leveys));
    }
    
/**
  * Metodi palauttaa pelissä olevien pallojen määrän
  * 
  * @return listassa olevien pallojen määrä
  */    
    public int pallojaKorissa() {
        return pallot.size();
    }
    
/**
  * Metodi palauttaa listan pelissä olevista palloista
  * 
  * @return lista palloista
  */    
    public ArrayList<Pallo> getPallot() {
        return pallot;
    }
    
/**
  * Metodi joka vaaditaan rajapinnan toteuttamiseksi
  * Metodi liikuttaa jokaista pelissä olevaa palloa
  */    
    @Override
    public void liiku() {
        for (Pallo pallo : pallot) {
            pallo.liiku();
        }
    }
    
/**
  * Metodilla haetaan pallojen sijainteja tekstinä
  * Metodin lopussa tekstiä siistitään
  * 
  * @return pallojen vasempien yläkulmien koordinaatit
  */      
    @Override
    public String toString() {
        String tulostus = "";
        for(Pallo pallo : pallot) {
            tulostus += pallo.toString() + "\n";
        }
        return tulostus.trim();
    }
}
