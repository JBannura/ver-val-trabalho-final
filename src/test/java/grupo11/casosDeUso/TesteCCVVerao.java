package grupo11.casosDeUso;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import grupo11.casosDeUso.Politicas.CalculoCustoViagemVerao;
import grupo11.entidades.Roteiro;
import grupo11.interfaces.Persistencia.RepositorioBairrosImplMem;
import grupo11.interfaces.Persistencia.RepositorioPassageirosImplMem;

public class TesteCCVVerao{
    
    RepositorioBairrosImplMem rb = new RepositorioBairrosImplMem();
    RepositorioPassageirosImplMem rp = new RepositorioPassageirosImplMem();
    CalculoCustoViagemVerao ccv = new CalculoCustoViagemVerao();

    @Test
    public void testeCustoViagem(){
        Roteiro r = new Roteiro(rb.recuperaPorNome("Boa Vista"), rb.recuperaPorNome("Vila Nova"), rb.recuperaListaBairros());
        ccv.defineRoteiro(r);
        ccv.definePassageiro(rp.recuperaPorCPF("123457689"));
        double actual = ccv.custoViagem();
        double expected = 54.0;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testeDescontoPontuacao(){
        Roteiro r = new Roteiro(rb.recuperaPorNome("Boa Vista"), rb.recuperaPorNome("Vila Nova"), rb.recuperaListaBairros());
        ccv.defineRoteiro(r);
        ccv.definePassageiro(rp.recuperaPorCPF("123457689"));
        double actual = ccv.descontoPontuacao();
        double expected = 0;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testeDescontoSazonal(){
        Roteiro r = new Roteiro(rb.recuperaPorNome("Boa Vista"), rb.recuperaPorNome("Vila Nova"), rb.recuperaListaBairros());
        ccv.defineRoteiro(r);
        ccv.definePassageiro(rp.recuperaPorCPF("123457689"));
        double actual = ccv.descontoPromocaoSazonal();
        double expected = (ccv.calculoCustoBasico()*0.1);
        Assertions.assertEquals(expected, actual);
    }
}