import java.util.concurrent.ThreadLocalRandom;
import javax.swing.*;
import java.util.ArrayList;
import java.util.*;

class Gokje
{
    public static void main(String[] args)
    {
        drukaf("Hallo kandidaten"  ); // Welkomsbericht.
        drukaf("Getal is tussen 0 en 16 "); // Tip voor de speler.
        List<Integer> list = new ArrayList<Integer>(); // List wordt aangemaakt. In de list worden de gekozen antwoorden opgeslagen.
        int randomNum = ThreadLocalRandom.current().nextInt(1, 15 + 1); // Random getal tussen 0 en 16 wordt gegeneerd en wordt in variabele genaamd randomNum geplaatst.
        int kansen = 10; // variabele van het type int wordt aangemaakt. Dit zijn het aantal kansen dat de speler heeft. De speler heeft dus 10 kansen.
        
        while(true) // Iteratie, oftewel while loop. 
        {
            int gekozengetal = leesgetal(); // Methode leesgetal() wordt geplaatst in variabele van het type int genaamd gekozengetal.
            if( gekozengetal == randomNum) // Selectie,als het gekozen getal door de speler hetzelfde is als het gegeneerde random getal, dan wordt de lus verlaten.
                {
                    drukaf("Goed gedaan!");
                    list.add(gekozengetal); // Getal wat speler heeft gekozen wordt toegevoegd aan de lijst.
                    drukaf("Gekozen nummers zijn = " + list); // Alle geraden nummers wordt weergeven.
                    String opnieuw = opnieuwspelen(); // Er wordt gevraagd of de speler nog een keer wilt spelen.
                    if(opnieuw.equals("nee") )
                        {
                            drukaf("Een fijne dag nog!");
                            break; // verlaat loop en daarmee ook het programma
                        }
                    if(opnieuw.equals("ja") )  // Speler wilt nog een keer spelen
                        {
                            list.clear(); // Alle content in de lijst wordt hersteld naar default.
                            kansen = 10; // kansen wordt weer op 10 gezet.
                            randomNum = ThreadLocalRandom.current().nextInt(1, 15 + 1); // Random getal tussen 0 en 16 wordt gegeneerd en wordt in variabele genaamd randomNum geplaatst.
                            continue;
                        
                        
                        }
                
                }
            else
                {
                    drukaf("Fout antwoord"); // Zolang het antwoord niet goed is wordt dit geprint op het beeldscherm.
                    kansen -= 1; // Aantal kansen dat speler had in het begin(10) wordt verminderd met "1'.
                    list.add(gekozengetal); // Getal wat speler heeft gekozen wordt toegevoegd aan de lijst.
                    drukaf("Je hebt nog "+ kansen +  " kansen");
                    drukaf("Gekozen nummers zijn = " + list); // Alle geraden nummers wordt weergeven.
                    if(kansen == 0)
                        {
                           drukaf("Je hebt niet genoeg kansen meer!");
                           String overnieuw = opnieuwspelen(); 
                           if(overnieuw.equals("ja"))
                               {
                                 kansen = 10;
                                 list.clear();
                                 randomNum = ThreadLocalRandom.current().nextInt(1, 15 + 1); // Random getal tussen 0 en 16 wordt gegeneerd en wordt in variabele genaamd randomNum geplaatst.

                               }
                          else
                               {
                                 drukaf("Een fijne dag nog");
                                 break;
                               }
                        }
            }
            
        }
        
    }
    
    public static void drukaf(String tekst)
    {
        System.out.println(tekst);
    }
        
    public static int leesgetal()
    {
            String tekst = JOptionPane.showInputDialog(null,"Vul een getal in" ,"Getal nodig",JOptionPane.WARNING_MESSAGE);
            int getal = Integer.parseInt(tekst);
            return getal;
    }
    
    public static String opnieuwspelen()
    {
        String[] choices = { "ja", "nee"};
        String antwoord = (String) JOptionPane.showInputDialog(null,"Wil je nog een keer spelen?" ,"Antwoord nodig",JOptionPane.QUESTION_MESSAGE, null, choices, choices[1]);
        return antwoord; 
    }
    
}