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
    private HashMap<String,HashMap> glosario;
    private HashMap<String, String> saludos;
    private HashMap<String, String> problemas;
    private HashMap<String, String> enfados;
    private HashMap<String,String> claves;
    private Random rnd;
    private ArrayList<String> contestaciones;
    /**
     * Construct a Responder - nothing to do
     */
    public Responder()
    {
        glosario = new HashMap<>();
        saludos = new HashMap<>();
        problemas = new HashMap<>();
        enfados = new HashMap<>();
        claves = new HashMap<>();
        
        glosario.put("saludos", saludos);
        glosario.put("problemas", problemas);
        glosario.put("enfados", enfados);
        glosario.put("claves", claves);
        
        rnd = new Random();
        contestaciones = new ArrayList<>();
        contestaciones.add("Claro, claro... te escucho");
        contestaciones.add("Sigue hablando, me interesa mucho");
        contestaciones.add("Aham... entiendo...");
        contestaciones.add("si?? hablas en serio??");
        
        glosario.get("saludos").put("hola","Hola! encantado de hablar contigo");
        glosario.get("saludos").put("dias","Buenos dias.");
        glosario.get("saludos").put("tardes","Buenas tardes.");
        glosario.get("saludos").put("saludos", "Muy buenas.");
        
        glosario.get("problemas").put("enciende","Con respecto a tu problema, deberías revisar que el ordenador está enchufado.");
        glosario.get("problemas").put("cuelga","Con respecto a tu problema sobrelos cuelgues, Si no te queda mucho espacio en el disco duro, deberías pensar en vaciarlo");
        glosario.get("problemas").put("apaga","Con respecto a que se te apague el ordenador, Tienes instalado un antivirus?");
        glosario.get("problemas").put("error", "Sin saber que error concreto es, no puedo ayudarte.");
        
        glosario.get("enfados").put("imbecil","No soy yo el que está insultando a un programa.");
        glosario.get("enfados").put("incompetente","Tranquilo, solo pretendo solucinar tus problemas");
        glosario.get("enfados").put("inutil","tranquilo, solo intento ayudarte");
        glosario.get("enfados").put("cabron", "Dicese del macho de la cabra, gracias por usar nuestro sistema de diccionarios.");
        
        glosario.get("claves").put("enciende","El encendido del ordenador está en un botón situado en la torre");
        glosario.get("claves").put("cuelga","Que un ordenador se cuelgue significa que deja de responder");
        glosario.get("claves").put("apaga","El ordenador se debe apagar siguiendo las ordenes de tu Sistema operativo");
        glosario.get("claves").put("error", "Errores, son los mensajes que usa el ordenador para avisarte de problemas en lo que intentas hacer");
        
    }

    /**
     * Generate a response.
     * @return   A string that should be displayed as the response
     */
    public String generateResponse(HashSet mensaje)
    {
        StringBuffer contestacion = new StringBuffer();
        boolean personality = false;
        boolean haveProblem = false;
        Iterator<String> it = mensaje.iterator();
        while(it.hasNext()){
            String palabra = it.next();
            if(glosario.get("saludos").containsKey(palabra)){
                contestacion.append(glosario.get("saludos").get(palabra));
                contestacion.append("\n");
                personality = true;
            }
            
            if(glosario.get("enfados").containsKey(palabra)){
                contestacion.append(glosario.get("enfados").get(palabra));
                contestacion.append("\n");
                personality = true;
            }
            
            if(palabra.contains("problema")){
                haveProblem = true;
                personality = true;
            }
        }
        
        it = mensaje.iterator();
        while(it.hasNext()){
            String palabra = it.next();
            if(haveProblem){
                if(glosario.get("problemas").containsKey(palabra)){
                    contestacion.append(glosario.get("problemas").get(palabra));
                    contestacion.append("\n");
                    personality = true;
                }
            }
            else{
                if(glosario.get("claves").containsKey(palabra)){
                    contestacion.append(glosario.get("claves").get(palabra));
                    contestacion.append("\n");
                    personality = true;
                }
            }
        }
        
        
        
        if(!personality){
            contestacion.append(contestaciones.get(rnd.nextInt(contestaciones.size())));
        }
        
        return contestacion.toString();
    }
}
