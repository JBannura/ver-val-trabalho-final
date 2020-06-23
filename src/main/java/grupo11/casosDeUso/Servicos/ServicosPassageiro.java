package grupo11.casosDeUso.Servicos;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import grupo11.casosDeUso.Politicas.CustoViagem;
import grupo11.casosDeUso.Politicas.CalculoCustoViagem;
import grupo11.casosDeUso.Repositorios.RepositorioBairros;
import grupo11.casosDeUso.Repositorios.RepositorioPassageiros;
import grupo11.entidades.Bairro;
import grupo11.entidades.Passageiro;
import grupo11.entidades.Roteiro;
import grupo11.entidades.Viagem;

public class ServicosPassageiro {
    private RepositorioBairros repBairros;
    private RepositorioPassageiros repPassageiros;
    private CustoViagem custoViagem;

    public ServicosPassageiro(RepositorioBairros repBairros, RepositorioPassageiros repPassageiros,
            CalculoCustoViagem ccv) 
        {
        this.repBairros = repBairros;
        this.repPassageiros = repPassageiros;
        this.custoViagem = new CustoViagem(ccv);
    }

    public List<String> getListaBairros(){
        return repBairros.recuperaListaBairros()
                .stream()
                .map(b->b.getNome())
                .collect(Collectors.toList());
    }

    public List<String> getPassageirosCadastrados(){
        return repPassageiros.listaPassageiros()
                .stream()
                .map(p->p.getNome())
                .collect(Collectors.toList());
    }

    public Roteiro criaRoteiro(String bairroOrigem,String bairroDestino){
        Collection<Bairro> todosBairros = repBairros.recuperaListaBairros();
        Bairro bOrigem = repBairros.recuperaPorNome(bairroOrigem);
        Bairro bDestino = repBairros.recuperaPorNome(bairroDestino);
        return new Roteiro(bOrigem,bDestino,todosBairros);
    }

    public Viagem criaViagem(int id,Roteiro roteiro,String cpfPassageiro){
        LocalDateTime data = LocalDateTime.now();
        Passageiro passageiro = repPassageiros.recuperaPorCPF(cpfPassageiro);
        double valorCobrado = custoViagem.custoViagem(roteiro, passageiro);
        return new Viagem(id,data,roteiro,passageiro,valorCobrado);
    }
}