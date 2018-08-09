/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Custos;

import java.util.List;

/**
 *
 * @author 17111168
 */
public class CustosConta {
    private EstatisticaCliente estatistica;
    private PontuacaoCliente pontuacao;
    private final double porcentagem = 0.3;
    
    public CustosConta(EstatisticaCliente estatistica, PontuacaoCliente pontuacao){
        
        this.estatistica = estatistica;
        this.pontuacao = pontuacao;
        
        throw new UnsupportedOperationException("Not implemented yet");
    }
    
    public double jurosNoMes(int nroConta, int mes, int ano){
        try{
            List<Double> saldos = estatistica.saldosMes(nroConta, mes, ano);
            double juros = 0;

            for(int i=0; i < saldos.size(); i++){
                if(saldos.get(i) < 0){
                    juros += (saldos.get(i) * porcentagem)/100;
                }
            }
        
            return juros;
        }catch(UnsupportedOperationException u){
            throw new UnsupportedOperationException("Not implemented yet");           
        }
    }
    
    public double taxaNoMes(int nroConta, int mes, int ano){
        try{
 
            double taxa = 100;
            double porc = 0;
            double pontuacao = this.pontuacao.pontuacaoSaldoMedio(nroConta, mes, ano) + 
                    this.pontuacao.pontuacaoSaldoMedioNegativoMes(nroConta, mes, ano) +
                    this.pontuacao.pontuacaoValorMedioOperacoes(nroConta, mes, ano);
            
            if(pontuacao > 20000){
                porc = 100;
            }else if(pontuacao > 10000){
                porc = 50;
            }else if(pontuacao > 5000){
                porc = 30;
            }else{
                porc = 0;
            }
            
            taxa = taxa-(taxa * porc)/100;
            
            return taxa;
 
        }catch(UnsupportedOperationException u){
            throw new UnsupportedOperationException("Not implemented yet");
        }
    }
    
}
