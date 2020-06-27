package grupo11.casosDeUso;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import grupo11.casosDeUso.Politicas.CalculoCustoViagemRelampago;
import grupo11.entidades.Roteiro;
import grupo11.interfaces.Persistencia.RepositorioBairrosImplMem;
import grupo11.interfaces.Persistencia.RepositorioPassageirosImplMem;

public class TesteCCVRelampago{
    
    RepositorioBairrosImplMem rb = new RepositorioBairrosImplMem();
    RepositorioPassageirosImplMem rp = new RepositorioPassageirosImplMem();
    CalculoCustoViagemRelampago ccv = new CalculoCustoViagemRelampago();

    @Test
    public void testeCustoViagem(){
        Roteiro r = new Roteiro(rb.recuperaPorNome("Gavea"), rb.recuperaPorNome("Ipiranga"), rb.recuperaListaBairros());
        ccv.defineRoteiro(r);
        ccv.definePassageiro(rp.recuperaPorCPF("123456789"));
        double actual = ccv.custoViagem();
        double expected = 62.7;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testeDescontoPontuacao(){
        Roteiro r = new Roteiro(rb.recuperaPorNome("Gavea"), rb.recuperaPorNome("Ipiranga"), rb.recuperaListaBairros());
        ccv.defineRoteiro(r);
        ccv.definePassageiro(rp.recuperaPorCPF("123456789"));
        double actual = ccv.descontoPontuacao();
        double expected = 0;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testeDescontoSazonal(){
        Roteiro r = new Roteiro(rb.recuperaPorNome("Gavea"), rb.recuperaPorNome("Ipiranga"), rb.recuperaListaBairros());
        ccv.defineRoteiro(r);
        ccv.definePassageiro(rp.recuperaPorCPF("123456789"));
        double actual = ccv.descontoPromocaoSazonal();
        double expected = (ccv.calculoCustoBasico()*0.05);
        Assertions.assertEquals(expected, actual);
    }
}