package grupo11;

import grupo11.casosDeUso.Politicas.CalculoCustoViagemBasico;
import grupo11.casosDeUso.Politicas.CalculoCustoViagemRelampago;
import grupo11.casosDeUso.Politicas.CalculoCustoViagemVerao;
import grupo11.entidades.Roteiro;
import grupo11.entidades.geometria.*;
import grupo11.interfaces.Persistencia.RepositorioBairrosImplMem;
import grupo11.interfaces.Persistencia.RepositorioPassageirosImplMem;

public class App {
    
    public static void main(String args[]){
    
        RepositorioBairrosImplMem rb = new RepositorioBairrosImplMem();
        RepositorioPassageirosImplMem rp = new RepositorioPassageirosImplMem();
        CalculoCustoViagemVerao ccv = new CalculoCustoViagemVerao();
        Roteiro r = new Roteiro(rb.recuperaPorNome("Boa Vista"), rb.recuperaPorNome("Vila Nova"), rb.recuperaListaBairros());
        ccv.defineRoteiro(r);
        ccv.definePassageiro(rp.recuperaPorCPF("123456789"));
        System.out.println("Custo basico: " + ccv.calculoCustoBasico());
        System.out.println("Custo viagem: " + ccv.custoViagem());
        
    }
}