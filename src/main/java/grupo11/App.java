package grupo11;

import grupo11.entidades.Roteiro;
import grupo11.entidades.geometria.*;
import grupo11.interfaces.Persistencia.RepositorioBairrosImplMem;

public class App {
    
    public static void main(String args[]){
    
        RepositorioBairrosImplMem rb = new RepositorioBairrosImplMem();
        Roteiro r = new Roteiro(rb.recuperaPorNome("Ipiranga"), rb.recuperaPorNome("Petropolis"), rb.recuperaListaBairros());
        System.out.println(r.bairrosPercoridos().size());
    
    }
}