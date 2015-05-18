
package dodgeballpeli.dodgeball;

import dodgeballpeli.peli.Peli;

public class Main {
    
    public static void main(String[] args) {
        Peli dodgeball = new Peli(10,10);
        
        dodgeball.etene();
        
        System.out.println(dodgeball);
        
        dodgeball.etene();
        dodgeball.etene();

        System.out.println(dodgeball);
        
        for (int i = 0; i<11; i++) {
            dodgeball.etene();
        }
        
        
        System.out.println(dodgeball);
    }
}
