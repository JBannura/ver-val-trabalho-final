package grupo11;

import grupo11.entidades.Bairro;
import grupo11.entidades.Passageiro;
import grupo11.entidades.Roteiro;
import grupo11.interfaces.Persistencia.RepositorioBairrosImplMem;
import grupo11.interfaces.Persistencia.RepositorioPassageirosImplMem;
import grupo11.casosDeUso.Politicas.*;
import grupo11.entidades.Viagem;
import grupo11.casosDeUso.Servicos.ServicosPassageiro;
import grupo11.entidades.geometria.*;

public class App {
    
    public static void main(String args[]){
    
        RepositorioBairrosImplMem rb = new RepositorioBairrosImplMem();
        RepositorioPassageirosImplMem rp = new RepositorioPassageirosImplMem();
        CalculoCustoViagemBasico ccv = new CalculoCustoViagemBasico();
        
        Bairro expected = rb.recuperaPorNome("Petropolis");
        Bairro actual = expected.novoBairroQuadrado("Petropolis", new Ponto(0,12), 4, 10.0);

        Ponto p1 = new Ponto(0,2);
        Ponto p2 = new Ponto(1,5);
        Reta r = new Reta(p1,p2);
        System.out.println(r.tamanho());


        // ServicosPassageiro sp = new ServicosPassageiro(rb, rp, ccv);
        // Roteiro r = sp.criaRoteiro("Gavea", "Bom Fim");
        // Viagem v = sp.criaViagem(1, sp.criaRoteiro("Ipiranga", "Bom Fim"), "123456789");
        // System.out.println(v.toString());
        
        
        // System.out.println("Area: " + rb.recuperaPorNome("Ipiranga").getArea());
        // System.out.println("Ponto central: " + rb.recuperaPorNome("Ipiranga").getArea().pontoCentral());
        // System.out.println("Area: " + rb.recuperaPorNome("Solidao").getArea());
        // System.out.println("Ponto central: " + rb.recuperaPorNome("Solidao").getArea().pontoCentral());
        // System.out.println("Area: " + rb.recuperaPorNome("Gavea").getArea());
        // System.out.println("Ponto central: " + rb.recuperaPorNome("Gavea").getArea().pontoCentral());

        // Roteiro r = new Roteiro(rb.recuperaPorNome("Solidao"), rb.recuperaPorNome("Ipiranga"), rb.recuperaListaBairros());
        // CalculoCustoViagemBasico ccv = new CalculoCustoViagemBasico();
        // ccv.defineRoteiro(r);
        // System.out.println("Bairros percorridos pela rota: " + r.bairrosPercoridos());
        // double d = ccv.calculoCustoBasico();
        // System.out.println("Calculo custo básico: "+d);

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