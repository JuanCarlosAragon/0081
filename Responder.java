import java.util.Random;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
/**
 * The responder class represents a response generator object.
 * It is used to generate an automatic response to an input string.
 * 
 * @author     Michael KÃ¶lling and David J. Barnes
 * @version    0.1 (2011.07.31)
 */
public class Responder
{
    private HashMap<String,String> claves;
    private Random rnd;
    private ArrayList<String> contestaciones;
    /**
     * Construct a Responder - nothing to do
     */
    public Responder()
    {
        claves = new HashMap<>();
        rnd = new Random();
        contestaciones = new ArrayList<>();
        contestaciones.add("Claro, claro... te escucho");
        contestaciones.add("Sigue hablando, me interesa mucho");
        contestaciones.add("Aham... entiendo...");
        contestaciones.add("si?? hablas en serio??");
        
        claves.put("hola","Hola es un saludo ya muy visto amigo mio");
        claves.put("hello","Hello es un saludo muy visto tambien, aunque esté en ingles");
        claves.put("kaixo","Kaixo es un saludo muy visto aunque lo digas en euskera");
        claves.put("salut", "Salut es un saludo muy visto por mucho que lo intentes decir en frances"); 
    }

    /**
     * Generate a response.
     * @return   A string that should be displayed as the response
     */
    public String generateResponse(HashSet mensaje)
    {
        String contestacion = new String();
        boolean claveFound = false;
        Iterator<String> it = mensaje.iterator();
        while(it.hasNext() && !claveFound){
            String palabra = it.next();
            if(claves.containsKey(palabra)){
                claveFound = true;
                contestacion = claves.get(palabra);
            }
        }
        if(!claveFound){
            contestacion = contestaciones.get(rnd.nextInt(contestaciones.size()));
        }
        
        return contestacion;
    }
}
