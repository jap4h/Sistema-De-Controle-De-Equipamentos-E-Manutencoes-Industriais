package model;

import App.Main;
import exception.*;
import java.util.Random;

public class GerenciamentoDeEquipamentos {
    final private Random geraCodigo = new Random();
    private int codigo = geraCodigo.nextInt(90000);
    private String nome;
    private String categoria;
    private String fabricante;
    private String modelo;
    private String setor;
    private String dataDeInstalacao;
    private String status;

    public GerenciamentoDeEquipamentos( String nome , String categoria , String fabricante , String modelo , String setor , String dataDeInstalacao  , String status){
        setCodigo(codigo);
        setNome(nome);
        setCategoria(categoria);    
        setFabricante(fabricante);
        setModelo(modelo);  
        setSetor(setor);
        setDataDeInstalacao(dataDeInstalacao);
        setStatus(status);
    }

    public void validarCodigo() throws CodigoExistenteException {
        for(GerenciamentoDeEquipamentos equipamentos : Main.Equipamentos){
            if(equipamentos.getCodigo() == codigo) {
                throw new CodigoExistenteException("O codigo do equipamento já existe.");
            }
        }
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        if(codigo <= 0 ){
            while(codigo <= 0 ){
                this.codigo = geraCodigo.nextInt(90000);
            }
        }
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        try {
            if(nome == null || nome.isEmpty()){
                throw new NomeInvalidoException("Nome inserido está vazio.");
        }
        this.nome = nome;
        } catch (NomeInvalidoException E) {
            System.err.println("Erro: " + E.getMessage());
        }
       

    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        try {
            if(categoria == null || categoria.isEmpty() ){
                throw new CategoriaInvalidaException("A categoria inserida está vazia.");
        }
        this.categoria = categoria;
        } catch (CategoriaInvalidaException E) {
            System.err.println("Erro: " + E.getMessage());
        }
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        try {
            if(fabricante == null || fabricante.isEmpty()){
                throw new FabricanteInvalidoException("Fabricante inserido está vazio.");
            }
            this.fabricante = fabricante;
        } catch (FabricanteInvalidoException E) {
            System.err.println("Erro: " + E.getMessage());
        }
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        try {
            if(modelo == null || modelo.isEmpty()){
            throw new Erro("Modelo inserido está vazio.");
        }
        this.modelo = modelo;
        } catch (Erro E) {
            System.err.println("Erro: " + E.getMessage());
        }
        
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        try {
            if(setor == null || setor.isEmpty()){
                throw new SetorInvalidoException("O setor inserido está vazio.");
            }
            this.setor = setor;
        } catch (SetorInvalidoException E) {
            System.err.println("Erro: " + E.getMessage());
        }
        
    }

    public String getDataDeInstalacao() {
        return dataDeInstalacao;
    }

    public void setDataDeInstalacao(String dataDeInstalacao) {
        try{
            if(dataDeInstalacao == null || dataDeInstalacao.isEmpty() ){
                throw new DataDeInstalacaoException("A data de instalação inserida está vazia.");
            }
            if(dataDeInstalacao.length() != 11){
                throw new DataDeInstalacaoException("A data de instalação inserida é invalida.");
            }
        this.dataDeInstalacao = dataDeInstalacao;
        }
        catch(DataDeInstalacaoException E){
            System.err.println("Erro: " + E.getMessage());
        }
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        try{
            if(!status.equalsIgnoreCase("inativo") || !status.equalsIgnoreCase("Operando") || !status.equalsIgnoreCase("Em manutencao")){
                throw new Erro("Status inserido invalido.");
            }
            this.status = status;
        }catch(Erro E){
            System.err.println("Erro: " + E.getMessage());
        }
    }

    public void mostrarEquipamento(){
        System.out.println("Coidigo: " + getCodigo());
        System.out.println("Nome: " + getNome());
        System.out.println("Categoria: " + getCategoria());
        System.out.println("Fabricante: " + getFabricante());
        System.out.println("Modelo: " + getModelo());
        System.out.println("Setor: " + getSetor());
        System.out.println("Data de instalação: " + getDataDeInstalacao());
        System.out.println("Status: " + getStatus()); 
    }
}   
