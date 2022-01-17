
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author simonemattioli
 */
public class NewClass {
    public static void main(String[] args) throws MalformedURLException, IOException {
        //api e link
        //https://www.metaweather.com/api/location/search/?query=<>
        
        Scanner sc = new Scanner(System.in);
        String Città = "";
        
        //imposto l'URL dalla quale ricevero l'array in formato JSON
        URL url = new URL("https://www.metaweather.com/api/location/search/?query=");
        
        //Provo ad instaurare una connessione specificando il metodo della richiesta
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();
    }
}
