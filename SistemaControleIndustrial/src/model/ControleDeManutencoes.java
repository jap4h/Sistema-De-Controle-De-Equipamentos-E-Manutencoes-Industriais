package model;

import App.Main;
import exception.*;
import java.util.Random;
import java.util.Scanner;

public class ControleDeManutencoes {
    private Scanner sc = new Scanner(System.in);
    private Random geraId = new Random();
    private int codigoDaManutencao;
    private GerenciamentoDeEquipamentos equipamentoRelacionado;
    private GerenciadorDeTecnicos tecnicoResponsavel;
    private String dataDeAbertura;
    private String dataDeEncerramento;
    private String tipoDaManutencao;
    private String descricaoDoProblema ;
    private String situacao;

    public ControleDeManutencoes(String dataDeAbertura , String dataDeEncerramento , String tipoDaManutencao , String descricaoDoProblema ) throws Exception {
        setCodigoDaManutencao(codigoDaManutencao);
        setDataDeAbertura(dataDeAbertura);  
        setDataDeEncerramento(dataDeEncerramento);  
        setTipoDaManutencao(tipoDaManutencao);  
        setDescricaoDoProblema(descricaoDoProblema);    
        setSituacao("Aberta");
        setEquipamentoRelacionado(equipamentoRelacionado);
        setTecnicoResponsavel(tecnicoResponsavel);  
    }

    public void AlterarSituaçãoDaManutenção(String situacao) throws Erro {
        setSituacao(situacao);
    }
    
    public void FinalizarManutencao() throws Erro{
        try{
            System.out.println("Digite a data de encerramento: ");
            String dataE = sc.nextLine();
            if(dataE.length() != 10){
                throw new Erro("A data digitada é invalida.");
            }
            setDataDeEncerramento(dataE);
            setSituacao("Finalizada");
            System.out.println("Manutenção finalizada com sucesso.");
        }catch(Erro E){
            System.err.println("Erro: " + E.getMessage() );
        }
    }

    public int getCodigoDaManutencao() {
        return codigoDaManutencao;
    }

    public void setCodigoDaManutencao(int codigoDaManutencao) {
        if(codigoDaManutencao <= 0){
            while(codigoDaManutencao <= 0 ){
                setCodigoDaManutencao(geraId.nextInt());
            }
        }
        else{
            this.codigoDaManutencao = codigoDaManutencao;
        }
        
    }

    public Object getEquipamentoRelacionado() {
        return equipamentoRelacionado;
    }

    public void setEquipamentoRelacionado(GerenciamentoDeEquipamentos equipamentoR) throws Exception {
        for(ControleDeManutencoes manutencoes : Main.Manutencoes){
            if(manutencoes.getEquipamentoRelacionado() == equipamentoR && manutencoes.getSituacao().equalsIgnoreCase("Aberta") && manutencoes.getSituacao().equalsIgnoreCase("Em andamento")){
                throw new Erro("Equipamento já está em manutenção.");
            }
        }
        this.equipamentoRelacionado = equipamentoR;
    }

    public Object getTecnicoResponsavel() {
        return tecnicoResponsavel;
    }

    public void setTecnicoResponsavel(GerenciadorDeTecnicos tecnicoR){
        this.tecnicoResponsavel = tecnicoR;
        }
    

    public String getDataDeAbertura() {
        return dataDeAbertura;
    }

    public void setDataDeAbertura(String dataDeAbertura) throws Erro {
        try {
            if(dataDeAbertura == null || dataDeAbertura.isEmpty()){
                throw new Erro("A data inserida está vazia");
            }
            if(dataDeAbertura.length() != 10){
                throw new Erro("A data inserida é invalida.");
            }
            this.dataDeAbertura = dataDeAbertura;          
        } catch (Erro E) {
            System.err.println("Erro: " + E.getMessage());
        }
    }

    public String getDataDeEncerramento() {
        return dataDeEncerramento;
    }

    public void setDataDeEncerramento(String dataDeEncerramento) throws Erro {
        try {
            if(dataDeEncerramento == null || dataDeEncerramento.isEmpty()){
                throw new Erro("A data de encerramento inserida está vazia");
            }
            if(dataDeEncerramento.length() != 10 ){
                throw new Erro("A data de encerramento inserida não é valida.");
            }
            this.dataDeEncerramento = dataDeEncerramento;
        }catch (Erro E) {
            System.err.println("Erro: " + E.getMessage());
        }
    }

    public String getTipoDaManutencao() {
        return tipoDaManutencao;
    }

    public void setTipoDaManutencao(String tipoDaManutencao) throws Erro {
        try {
            if(tipoDaManutencao == null || tipoDaManutencao.isEmpty()){
                throw new Erro("O tipo da manutenção inserida está vazia");
            }
            if(tipoDaManutencao.equalsIgnoreCase("Corretiva") || tipoDaManutencao.equalsIgnoreCase("Preventiva")){
                this.tipoDaManutencao = tipoDaManutencao;
                return;
            }
            throw new Erro("Tipo de manutenção inserido é invalido.");
        }catch (Erro E) {
            System.err.println("Erro: " + E.getMessage());
        }
    }

    public String getDescricaoDoProblema() {
        return descricaoDoProblema;
    }

    public void setDescricaoDoProblema(String descricaoDoProblema) throws Erro {
        try{
            if(descricaoDoProblema == null || descricaoDoProblema.isEmpty()){
                throw new Erro("A descrição do problema está vazia.");
            }
            this.descricaoDoProblema = descricaoDoProblema;
        }catch(Erro E){
            System.err.println("Erro: " + E.getMessage());
        }
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) throws Erro {
        try{
            if(situacao == null || situacao.isEmpty()){
                throw new Erro("A situação inserida está vazia.");
            }
            for(ControleDeManutencoes manutencoes : Main.Manutencoes){
                if(manutencoes.getEquipamentoRelacionado() == equipamentoRelacionado && (manutencoes.getSituacao() .equalsIgnoreCase("Em andamento") || manutencoes.getSituacao().equalsIgnoreCase("Aberta"))){
                    throw new Erro("O equipamento já está em uma manutenção.");
                }
            }
            if(situacao.equalsIgnoreCase("Finalizada")){
                throw new Erro("Está manutenção já foi realizada.");
            }
            if(situacao.equalsIgnoreCase("Em andamento") || situacao.equalsIgnoreCase("Aberta") || situacao.equalsIgnoreCase("Finalizada")){
                if(situacao.equalsIgnoreCase("Aberta")){
                    equipamentoRelacionado.setStatus("Em manutencao");
                    this.situacao = situacao;
                    return;
                }
                if(situacao.equalsIgnoreCase("Em andamento")){
                    this.situacao = situacao;
                    return;
                }
                if(situacao.equalsIgnoreCase("Finalizada")){
                    equipamentoRelacionado.setStatus("Operando");
                    this.situacao = situacao;
                    return;
                }
                return;
            }
            throw new Erro("A situação inserida é invalida.");
        }catch(Erro E){
            System.err.println("Erro: " + E.getMessage());
        }
    }

    // ConsultarManutenção;
}
