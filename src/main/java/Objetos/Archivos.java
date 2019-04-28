package Objetos;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.json.*;

public class Archivos {

    private ArrayList<Zapatilla> sap = new ArrayList();

    /**
     * El metodo lee el archivo json y transforma y mete los datos en un arreglo
     * de objetos y los devuelve
     *
     * @param ruta
     * @return
     */
    public JSONArray leerArchivo(String ruta) {
        JSONParser parser = new JSONParser();
        JSONArray zapatillas = new JSONArray();
        try  {
            
            Object a = parser.parse(new FileReader(ruta));
            JSONObject jsonObject = (JSONObject) a;
            zapatillas=(JSONArray) jsonObject.get("zapatillas");

        } catch (FileNotFoundException e) {
            System.out.println("Error");
        } catch (IOException e) {
            System.out.println("Error");
        } catch (ParseException e) {
            System.out.println("Error");
        }
        return zapatillas;
    }

    /**
     * Recibe el array de json y los tranforma en array de objetos tipo
     * sapatilla.
     *
     */
    public  void JSONArrayAobjetos(JSONArray c) {

        for(int i=0;i<c.size();i++){
            JSONObject zapatilla = (JSONObject) c.get(i);
            JsonAobjetos(zapatilla);
        }

    }

    /**
     * Convierte los obejtos json a objetos normales y los añade a un array de
     * objetos.
     *
     * @param e
     */
    public void JsonAobjetos(JSONObject e) {
        
        String marca = (String) e.get("marca");
        String modelo = (String) e.get("modelo");
        String color = (String) e.get("color");
        Zapatilla s = new Zapatilla(marca, modelo, color);
        sap.add(s);
    }
    public ArrayList<Zapatilla> getArregloS(){
        return sap;
    }
    
    /**
     *Crea el nuevo archivo json con un arreglo de objetos.
     * @param ruta
     * @param zapatillas
     */
    public void crearArchivoJ(String ruta,ArrayList<Zapatilla> zapatillas){
        JSONArray listaZapatillas = new JSONArray();
        try{
        for(int i=0;i<zapatillas.size();i++){
            
        JSONObject zapatilla = new JSONObject();
        zapatilla.put("marca", zapatillas.get(i).getMarca());
        zapatilla.put("modelo", zapatillas.get(i).getModelo());
        zapatilla.put("color", zapatillas.get(i).getColor());
         
        JSONObject zapa = new JSONObject();
        zapa.put("zapatilla", zapatilla);
        listaZapatillas.add(zapa);
        }
        }catch(IndexOutOfBoundsException e){
            System.out.println("Es posible que no hayan datos que guardar");
        }
        try (FileWriter file = new FileWriter(ruta)) {
 
            file.write(listaZapatillas.toJSONString());
            file.flush();
 
        } catch (IOException e) {
            System.out.println("Error a crear archivo");
        }
        
    }
}
