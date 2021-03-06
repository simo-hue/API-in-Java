
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;  
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import jdk.jshell.spi.ExecutionControl;
import org.json.simple.parser.ParseException;

/**
 *
 * @author simonemattioli
 */
public class NewClass {
    public static void main(String[] args) throws MalformedURLException, IOException, ParseException {
        //api e link
        //https://www.metaweather.com/api/location/search/?query=<>
        
        Scanner sc = new Scanner(System.in);
        String Città = "";
        int Risposta;
        
        try {
                System.out.println("Digitare il ");
        //imposto l'URL dalla quale ricevero l'array in formato JSON
        URL url = new URL("https://www.metaweather.com/api/location/search/?query=");
        
        //Provo ad instaurare una connessione specificando il metodo della richiesta
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();
        
        //Tramite la variabile risposta controllo se è stata effettuata la connesione con successo o meno
        Risposta = conn.getResponseCode();
        
        //visto che il 200 significa che è tutto ok implemento un controllo basato sul numero resituito
        if(Risposta != 200){
            System.out.println("Errore avvenuto ha il codice: " + Risposta);
        
        } else{
            StringBuilder infoString = new StringBuilder();
            Scanner scanner = new Scanner(url.openStream());
            
            //aggiungo alla stringa infoString le informazioni dalla risposta;
            while(scanner.hasNext()){
                infoString.append(scanner.nextLine());
            }
            //va sempre chiusa
            scanner.close();
            
            //stampo la risposta
            System.out.println(infoString);
            
            //Converto la stringa in formato JSON;
            JSONParser parse = new JSONParser();
            JSONArray dataObject = (JSONArray) parse.parse(String.valueOf(infoString));
            
            System.out.println(dataObject.get(0));
            
            JSONObject datiPerCittà;
            datiPerCittà = (JSONObject) datiPerCittà.get(0);
            
            //mi faccio resituire il tipo di dato inserito dall'utente (città-paese-...)
            System.out.println(datiPerCittà.get("location_type"));
        }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}
