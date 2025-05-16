/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

/**
 *
 * @author adalb
 */
public class ConstructorJoyas {
    
    public int codigo;
    public String nombre;
    public String color;
    public String joyeria;
    public int clas;

    public ConstructorJoyas() {
        this.codigo = codigo;
        this.nombre = nombre;
        this.color = color;
        this.joyeria = joyeria;
        this.clas = clas;
    }

    public ConstructorJoyas(int codigo, String nombre, String color, String joyeria, int clas) {
         this.codigo = codigo;
        this.nombre = nombre;
        this.color = color;
        this.joyeria = joyeria;
        this.clas = clas;
        
    }

   

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getJoyeria() {
        return joyeria;
    }

    public void setJoyeria(String joyeria) {
        this.joyeria = joyeria;
    }

    public int getClas() {
        return clas;
    }

    public void setClas(int clas) {
        this.clas = clas;
    }

    
    
    

       
}
