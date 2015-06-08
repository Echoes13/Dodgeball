
package dodgeballpeli.gui;

import dodgeballpeli.peli.PeliLogiikka;

/**
  * Rajapinta pelin päivitettäville luokille
  */  
public interface Paivitettava {
    
/**
  * Metodi luokkien olioiden päivittämistä varten
  */      
    void paivita();

/**
  * Metodi uuden pelin luomista varten
  * 
  * @param peli uuden pelin logiikka
  */      
    void setNewGame(PeliLogiikka peli);    
}
