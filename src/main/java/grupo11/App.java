package grupo11;

import grupo11.entidades.geometria.*;

public class App {
    
    public static void main(String args[]){
    
        Area a = new Area(new Ponto(0, 4), new Ponto(4, 0));
        
        Reta r = new Reta(new Ponto(0, 5), new Ponto(4, 5));
        System.out.println(a.classifica(r));
    
    }
}