package Objetos;


public class Zapatilla {
    private String marca;
    private String modelo;
    private String color;
    public Zapatilla(String Marca,String Modelo, String Color) {
        marca=Marca;
        modelo=Modelo;
        color=Color;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getColor() {
        return color;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
    
}
