import GLOOP.*;
import java.util.*;


public class Items
{
    // Bezugsobjekte
    private GLKugel hatKugeln;
    private GLQuader hatQuader;
    private GLTorus hatTori;
    // Attribute
    private Random randoml;

    // Konstruktor
   /* public Items()
    {
        hatKugeln = new GLKugel(, Random zufgen, Random zufgen, 3);
        hatQuader = new GLQuader();
        hatTori = new GLTori();
        
        Random random1 = new Random();
        
        randomNumber=(int)(Math.random()*100); 
        int number=(int)(Math.random()*5+10); 
    }*/
    
    private void random1 (int n, Random zufgen, int max) 
    {
        for(int i = 0; i < n; i++) 
        {
            System.out.print(zufgen.nextInt( max+1));        
        }
    }
}
