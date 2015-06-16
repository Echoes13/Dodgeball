##Dodgeball-pelin aihemäärittely

####**Aihe:**
Olet yksinäinen opiskelija liikuntasalissa jonka tehtävä on seuraava: Väistä palloja! Ystäväsi ja vihollisesi heittävät palloja salin sivuilta ja yrittävät osua sinuun niillä. Jotkut heittäjistä eivät kuitenkaan oikein tiedä minnepäin kannattaa heittää, joten varaudu myös outouihin heittoihin. Peli päättyy kun joka heittäjistä osuu sinuun pallolla.

####**Käyttäjät:**
*Pelaaja* tai muu vastaava

####**Pelaajan toiminnot:**
* *Pelaaja* voi liikuttaa hahmoansa kahdeksaan eri suuntaan.
* *Pelaaja* näkee missä hahmo ja pallot liikkuvat.
* *Pelaaja* saa pisteitä sen mukaan miten selviytyy.
* *Pelaaja* voi asettaa pelin pauselle.
* *Pelaaja* voi aloittaa uuden pelin hävittyään tai pausen aikana.

####**Pallojen toiminnot:**
* *Pallot* heitetään joltakin sivulta ja liikkuvat tiettyyn suuntaan.
* *Pallot* kimpoavat seinistä.
* *Pallo* heitetään takaisin samantien sen liikuttua salin yli.
* Uusi *Pallo* lisätään peliin sadan pisteen välein.



####**Ohjelman rakenne**:
Ohjelma aloittaa luomalla *PeliValvoja*-olion, joka luo pelit ja välittää tietoja, sekä *Käyttöliittymän*. *PeliValvoja* luo *PeliEdistäjä*-olion joka käyttää valvojalta saamaansa *PeliLogiikka*-oliota. *PeliLogiikkaan* kuuluu myös *pallot*, sekä *väistäjä*, jota *Näppäimistönkuuntelija* ohjaa. PeliEdistäjä saa PeliLogiikan etenemään, ja pitää myös huolen siitä että pelialustan piirtäjä päivittää jatkuvasti tilannetta. Kun peli hävitään, *PeliEdistäjä*-olio lopettaa toimintansa. Uuden pelin alkaessa *PeliValvoja* korvaa vanhan *PeliLogiikan* ja -*Edistäjän* uusilla olioilla.