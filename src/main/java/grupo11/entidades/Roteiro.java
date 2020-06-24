package grupo11.entidades;

import java.util.ArrayList;
import java.util.Collection;

import grupo11.entidades.geometria.Ponto;
import grupo11.entidades.geometria.Reta;
import grupo11.entidades.geometria.SituacaoReta;

public class Roteiro {
    private Bairro bairroOrigem;
    private Bairro bairroDestino;
    private Reta rota;
    private ArrayList<Bairro> bairrosPercorridos = new ArrayList<>();

    private void determinaBairrosPercorridos(Reta rota,Collection<Bairro> todosBairros){
        for(Bairro bairro:todosBairros){
            SituacaoReta sr = bairro.getArea().classifica(rota);
            if (sr != SituacaoReta.TODA_FORA){
                // DEBUG
                //System.out.println("Bairro que Intersecciona: " + bairro.getNome());
                bairrosPercorridos.add(bairro);
            }
        }
    }
  
    public Roteiro(Bairro bairroOrigem, Bairro bairroDestino,Collection<Bairro> todosBairros) {
        this.bairrosPercorridos = new ArrayList<>();
        this.bairroOrigem = bairroOrigem;
        this.bairroDestino = bairroDestino;
        Ponto pOrig = bairroOrigem.getArea().pontoCentral();
        Ponto pDest = bairroOrigem.getArea().pontoCentral();
        rota =  new Reta(pOrig,pDest);
        determinaBairrosPercorridos(rota,todosBairros);
    }
  
    public Reta getRota(){
        return rota;
    }
    
    public Bairro getBairroOrigem() {
        return bairroOrigem;
    }

    public Bairro getBairroDestino() {
        return bairroDestino;
    }

    public Collection<Bairro> bairrosPercoridos(){
        return bairrosPercorridos;
    }
    
    @Override
    public String toString() {
        return "Roteiro [bairroDestino=" + bairroDestino + ", bairroOrigem=" + bairroOrigem + "]";
    }
}