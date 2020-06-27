package grupo11.entidades;

// Classes
import grupo11.interfaces.Persistencia.RepositorioBairrosImplMem;
import grupo11.interfaces.Persistencia.RepositorioPassageirosImplMem;

import java.time.LocalDateTime;

// Teste
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TesteViagem{
    
    RepositorioBairrosImplMem rb = new RepositorioBairrosImplMem();
    RepositorioPassageirosImplMem rp = new RepositorioPassageirosImplMem();
    LocalDateTime ldt = LocalDateTime.now();
    Roteiro r = new Roteiro(rb.recuperaPorNome("Gavea"), rb.recuperaPorNome("Ipiranga"), rb.recuperaListaBairros());
    Passageiro p1 = rp.recuperaPorCPF("123456789");
    Viagem v = new Viagem(1, ldt, r, p1, 10.0);
    
    @Test
    public void testaGetId(){
        Assertions.assertEquals(1, v.getId());
    }

    @Test
    public void testaGetValorCobrado(){
        Assertions.assertEquals(10.0, v.getValorCobrado());
    }

    @Test
    public void testaGetPassageiro(){
        Assertions.assertEquals(p1, v.getPassageiro());
    }

    @Test
    public void testaGetRoteiro(){
        Assertions.assertEquals(r, v.getRoteiro());
    }

}