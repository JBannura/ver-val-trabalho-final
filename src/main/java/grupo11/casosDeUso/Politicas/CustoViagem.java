package grupo11.casosDeUso.Politicas;

import grupo11.entidades.Passageiro;
import grupo11.entidades.Roteiro;

public class CustoViagem {
    private CalculoCustoViagem ccv;
    
    public CustoViagem(CalculoCustoViagem ccv){
        this.ccv = ccv;
    }            

    public double custoViagem(Roteiro roteiro,Passageiro passageiro){
        ccv.defineRoteiro(roteiro);
        ccv.definePassageiro(passageiro);
        return ccv.custoViagem();
    }
}