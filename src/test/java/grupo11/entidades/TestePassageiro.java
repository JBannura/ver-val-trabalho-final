package grupo11.entidades;

// Classes
import grupo11.interfaces.Persistencia.RepositorioPassageirosImplMem;

// Teste
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestePassageiro {

    RepositorioPassageirosImplMem rp = new RepositorioPassageirosImplMem();

    @Test
    public void testeGetPontuacaoMedia(){
        Passageiro expected = rp.recuperaPorCPF("123456789");
        Passageiro actual = Passageiro.novoPassageiro("123456789", "Ze");

        Assertions.assertEquals(expected.getPontuacaoMedia(), actual.getPontuacaoMedia());
    }
    
    @Test
    public void testeInfoPontuacao(){
        Passageiro expected = rp.recuperaPorCPF("123456789");
        expected = Passageiro.passageiroExistente("123456789", "Ze", 16, 2);

        Passageiro actual = Passageiro.novoPassageiro("123456789", "Ze");
        actual.infoPontuacao(8);
        
        Assertions.assertEquals(expected.getPontuacaoMedia(), actual.getPontuacaoMedia());
    }
}