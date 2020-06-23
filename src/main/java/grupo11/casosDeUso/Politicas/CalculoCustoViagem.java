package grupo11.casosDeUso.Politicas;

import grupo11.entidades.Passageiro;
import grupo11.entidades.Roteiro;

public interface CalculoCustoViagem {
    
    void defineRoteiro(Roteiro roteiro);
    
    void definePassageiro(Passageiro passageiro);
    
    public Roteiro getRoteiro();
    
    public Passageiro getPassageiro();
    
    double calculoCustoBasico();
    
    double descontoPontuacao();
    
    double descontoPromocaoSazonal();
    
    double custoViagem();
}