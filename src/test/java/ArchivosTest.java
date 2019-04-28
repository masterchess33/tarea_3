/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Objetos.Archivos;
import Objetos.Zapatilla;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author envergador
 */
public class ArchivosTest {
    Zapatilla a;
    Zapatilla b;
    Zapatilla c;
    Zapatilla d;
    Zapatilla e;
    Zapatilla f;
    Zapatilla g;

    /**
     *prepara el array de objetos esperados
     */
    @Before
    public void preparar(){
         a=new Zapatilla("Nike","Cortez","White");
         b=new Zapatilla("Adidas","Superstar","Black");
         c=new Zapatilla("Puma","SuedeOG","Blue");
         d=new Zapatilla("Adidas","Yeezy350","Zebra");
         e=new Zapatilla("Nike","AirMax720","Gold");
         f=new Zapatilla("Jordan","1","Black");
         g=new Zapatilla("Adidas","NMD","Green");
    }
    /**
     * Prueba el conjunto de metodos de lectura para comprobar de que el metodo lee correctamente.
     */
    @Test
    public void ArchivosTest() {
        Archivos ar=new Archivos();
        ar.JSONArrayAobjetos(ar.leerArchivo("zapatillas.json"));
        ArrayList<Zapatilla> resultado=ar.getArregloS();
        ArrayList<Zapatilla> esperado= new ArrayList();
        esperado.add(a);
        esperado.add(b);
        esperado.add(c);
        esperado.add(d);
        esperado.add(e);
        esperado.add(f);
        esperado.add(g);
        
        assertEquals(esperado.get(0).getMarca(),resultado.get(0).getMarca());
        assertEquals(esperado.get(0).getColor(),resultado.get(0).getColor());
        assertEquals(esperado.get(0).getModelo(),resultado.get(0).getModelo());
        
        assertEquals(esperado.get(1).getMarca(),resultado.get(1).getMarca());
        assertEquals(esperado.get(1).getColor(),resultado.get(1).getColor());
        assertEquals(esperado.get(1).getModelo(),resultado.get(1).getModelo());
        
        assertEquals(esperado.get(2).getMarca(),resultado.get(2).getMarca());
        assertEquals(esperado.get(2).getColor(),resultado.get(2).getColor());
        assertEquals(esperado.get(2).getModelo(),resultado.get(2).getModelo());
    }
    
}
