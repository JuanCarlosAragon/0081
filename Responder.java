import java.util.Random;
import java.util.ArrayList;
/**
 * The responder class represents a response generator object.
 * It is used to generate an automatic response to an input string.
 * 
 * @author     Michael Kölling and David J. Barnes
 * @version    0.1 (2011.07.31)
 */
public class Responder
{
    private Random rnd;
    private ArrayList<String> contestaciones;
    /**
     * Construct a Responder - nothing to do
     */
    public Responder()
    {
        rnd = new Random();
        contestaciones = new ArrayList<>();
        contestaciones.add("Claro, claro... te escucho");
        contestaciones.add("Sigue hablando, me interesa mucho");
        contestaciones.add("Aham... entiendo...");
        contestaciones.add("si?? hablas en serio??");
    }

    /**
     * Generate a response.
     * @return   A string that should be displayed as the response
     */
    public String generateResponse()
    {
        String contestacion = contestaciones.get(rnd.nextInt(contestaciones.size()));
        return contestacion;
    }
}
