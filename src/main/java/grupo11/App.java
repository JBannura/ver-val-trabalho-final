package grupo11;

import grupo11.entidades.Bairro;
import grupo11.entidades.Passageiro;
import grupo11.entidades.Roteiro;
import grupo11.interfaces.Persistencia.RepositorioBairrosImplMem;
import grupo11.interfaces.Persistencia.RepositorioPassageirosImplMem;
import grupo11.casosDeUso.Politicas.*;
import grupo11.entidades.Viagem;
import grupo11.casosDeUso.Servicos.ServicosPassageiro;

import java.time.LocalDateTime;

import javax.sound.sampled.SourceDataLine;

public class App {
    
    public static void main(String args[]){
    
        RepositorioBairrosImplMem rb = new RepositorioBairrosImplMem();
        RepositorioPassageirosImplMem rp = new RepositorioPassageirosImplMem();
        // CalculoCustoViagemBasico ccv = new CalculoCustoViagemBasico();
        
        // ServicosPassageiro sp = new ServicosPassageiro(rb, rp, ccv);
        // Roteiro r = sp.criaRoteiro("Petropolis", "Solidao");
        // Viagem v = sp.criaViagem(1, sp.criaRoteiro("Petropolis", "Solidao"), "123456789");
        // System.out.println(v.toString());

        Roteiro r = new Roteiro(rb.recuperaPorNome("Solidao"), rb.recuperaPorNome("Ipiranga"), rb.recuperaListaBairros());

        CalculoCustoViagemBasico ccv = new CalculoCustoViagemBasico();
        ccv.defineRoteiro(r);
        System.out.println("Bairros percorridos pela rota: " + r.bairrosPercoridos());
        double d = ccv.calculoCustoBasico();
        System.out.println("Calculo custo básico: "+d);

    /*   
    // Alimentando repositorio bairros
    RepositorioBairrosImplMem b = new RepositorioBairrosImplMem();
    RepositorioPassageirosImplMem p = new RepositorioPassageirosImplMem();
    
    // Criando roteiro
    Roteiro r = new Roteiro(b.recuperaPorNome("Gavea"), b.recuperaPorNome("Ipiranga"), b.recuperaListaBairros());

    
    // Criando localDateTime e viagem
    LocalDateTime ldt = LocalDateTime.now();
    Passageiro p1 = p.recuperaPorCPF("123456789");
    Viagem v = new Viagem(1, ldt, r, p1, 10.0);
    System.out.println(v.toString());
    */

    }
}