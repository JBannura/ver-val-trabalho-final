package grupo11.entidades.casosDeUso;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import grupo11.casosDeUso.Politicas.CalculoCustoViagemBasico;
import grupo11.entidades.Roteiro;
import grupo11.interfaces.Persistencia.RepositorioBairrosImplMem;

public class TesteCCVBasico {
    
    RepositorioBairrosImplMem rb = new RepositorioBairrosImplMem();
    CalculoCustoViagemBasico ccv = new CalculoCustoViagemBasico();

    @Test
    public void testeCalculoCustoBasico(){
        Roteiro r = new Roteiro(rb.recuperaPorNome("Solidao"), rb.recuperaPorNome("Alegria"), rb.recuperaListaBairros());
        ccv.defineRoteiro(r);
        double actual = ccv.calculoCustoBasico();
        double expected = 25.0;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testeCustoViagem(){
        Roteiro r = new Roteiro(rb.recuperaPorNome("Solidao"), rb.recuperaPorNome("Alegria"), rb.recuperaListaBairros());
        ccv.defineRoteiro(r);
        double actual = ccv.custoViagem();
        double expected = 25.0;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testeDescontoPontuacao(){
        Roteiro r = new Roteiro(rb.recuperaPorNome("Solidao"), rb.recuperaPorNome("Alegria"), rb.recuperaListaBairros());
        ccv.defineRoteiro(r);
        double actual = ccv.descontoPontuacao();
        double expected = 0;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testeDescontoSazonal(){
        Roteiro r = new Roteiro(rb.recuperaPorNome("Solidao"), rb.recuperaPorNome("Alegria"), rb.recuperaListaBairros());
        ccv.defineRoteiro(r);
        double actual = ccv.descontoPromocaoSazonal();
        double expected = 0;
        Assertions.assertEquals(expected, actual);
    }
}