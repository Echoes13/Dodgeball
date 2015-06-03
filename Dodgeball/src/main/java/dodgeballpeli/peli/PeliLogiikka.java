
package dodgeballpeli.peli;

import dodgeballpeli.domain.Liikkuva;
import dodgeballpeli.domain.PalloKori;
import dodgeballpeli.domain.Vaistaja;
import java.util.ArrayList;
import java.util.List;

/**
  * Luokka joka käsittelee pelissä tapahtuvia sisäisiä toimintoja
  */
public class PeliLogiikka{
    
/**
  * @param leveys Pelialueen oikeanpuoleinen reuna
  * @param korkeus Pelialueen alareuna
  * @param kulunutAika Sadasosa-sekuntien määrä siitä että peli alkoi
  * @param pelaaja Pelaajahahmo joka liitetään kyseiseen peliin
  * @param pallokori Kori joka käsittelee pelissä olevia palloja
  * @param liikkuvatOsat Pelissä olevat Liikkuvat oliot
  */    
    final private int leveys;
    final private int korkeus;
    private int kulunutAika;
    private Vaistaja pelaaja;
    private PalloKori pallokori;
    private List<Liikkuva> liikkuvatOsat;

/**
  * Konstruktorissa asetetaan pelialueen reunat, nollataan
  * laskuri ja luodaan liikkuvat osat
  * 
  * @param leveys pelialueen oikeanpuoleinen reuna
  * @param korkeus pelialueen alareuna
  */    
    public PeliLogiikka(int leveys, int korkeus) {  
        this.leveys = leveys;
        this.korkeus = korkeus;
        this.kulunutAika = 0;
        liikkuvatOsat = new ArrayList<Liikkuva>();
        luoPelaaja();
        luoPalloKori();
    }
/**
  * Metodi joka luo pelin PalloKorin ja lisää sen
  * liikkuvien osien listaan
  */    
    private void luoPalloKori() {
        pallokori = new PalloKori(leveys, korkeus);
        liikkuvatOsat.add(pallokori);
    }
 
/**
  * Metodi joka luo pelin pelaajahahmon ja lisää sen
  * liikkuvien osien listaan
  */        
    private void luoPelaaja() {
        this.pelaaja = new Vaistaja(leveys, korkeus);
        liikkuvatOsat.add(pelaaja);
    }

/**
  * Metodi joka palauttaa pelialueen oikeanpuoleisen reunan
  * 
  * @return pelialueen oikeanpuoleinen reuna
  */        
    public int getLeveys() {
        return leveys;
    }

/**
  * Metodi joka palauttaa pelialueen alareunan
  * 
  * @return pelialueen alareuna
  */       
    public int getKorkeus() {
        return korkeus;
    }
    
/**
  * Metodi joka palauttaa pelin pelaajahahmon
  * 
  * @return pelin pelaajahahmo
  */       
    public Vaistaja haePelaaja() {
        return pelaaja;
    }
    
/**
  * Metodi joka palauttaa pelin pallojen käsittelijän
  * 
  * @return pelin pallokori
  */       
    public PalloKori haeKori() {
        return pallokori;
    }
    
/**
  * Metodi joka palauttaa pelissä saadut pisteet, jotka
  * vastaavat kymmenesosa-sekunteja mitä on pärjännyt pelissä
  * 
  * @return pelin kuluneet kymmenesosa-sekunnit
  */       
    public int haePisteet() {
        return kulunutAika/10;
    }
 
/**
  * Metodi joka liikuttaa kaikkia liikkuvia osia,
  * ts pelaajahahmoa ja palloja
  * Metodi nostaa myös vaikeustasoa tarvittaessa ja
  * lisää aikalaskuriin
  */       
    public void etene() {
        for(Liikkuva osa : liikkuvatOsat) {
            osa.liiku();
        }
        nostaVaikeustasoa();
        kulunutAika++;
    }
 
/**
  * Metodi joka nostaa pelin vaikeustasoa lisäämällä
  * peliin ensimmäisen pallon, sekä yhden pallon lisää 
  * joka kymmenes sekunti
  */   
    public void nostaVaikeustasoa() {
        if (kulunutAika%1000 == 0) {
            pallokori.lisaaPeliinPallo();                
        }
    }
    
/**
  * Metodi palauttaa liikkuvien osien koordinaatit tekstinä
  * Metodi siistii tekstin lopuksi
  * 
  * @return liikkuvien osien koordinaatit
  */  
    @Override
    public String toString() {
        String tulostus = "";
        for(Liikkuva osa : liikkuvatOsat) {
            tulostus += osa.toString() + "\n";
        }
        return tulostus.trim();
    }

}
