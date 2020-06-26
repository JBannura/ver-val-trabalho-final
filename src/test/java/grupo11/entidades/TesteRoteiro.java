package grupo11.entidades;

// Classes
import grupo11.interfaces.Persistencia.RepositorioBairrosImplMem; 

// Teste
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TesteRoteiro {

    RepositorioBairrosImplMem rb = new RepositorioBairrosImplMem();
    
    @Test
    public void testeBairrosPercorridos1(){
        Roteiro r = new Roteiro(rb.recuperaPorNome("Alegria"), rb.recuperaPorNome("Bom Fim"), rb.recuperaListaBairros());
        int actual = r.bairrosPercoridos().size();
        int expected = 4;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testeBairrosPercorridos2(){
        Roteiro r = new Roteiro(rb.recuperaPorNome("Ipiranga"), rb.recuperaPorNome("Petropolis"), rb.recuperaListaBairros());
        int actual = r.bairrosPercoridos().size();
        int expected = 2;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testeBairroOrigem(){
        Roteiro r = new Roteiro(rb.recuperaPorNome("Ipiranga"), rb.recuperaPorNome("Petropolis"), rb.recuperaListaBairros());
        Bairro actual = r.getBairroOrigem();
        Bairro expected = rb.recuperaPorNome("Ipiranga");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testeBairroDestino(){
        Roteiro r = new Roteiro(rb.recuperaPorNome("Ipiranga"), rb.recuperaPorNome("Petropolis"), rb.recuperaListaBairros());
        Bairro actual = r.getBairroDestino();
        Bairro expected = rb.recuperaPorNome("Petropolis");
        Assertions.assertEquals(expected, actual);
    }

}