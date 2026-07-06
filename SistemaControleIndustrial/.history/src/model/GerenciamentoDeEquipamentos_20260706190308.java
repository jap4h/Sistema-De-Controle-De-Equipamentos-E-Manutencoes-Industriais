package model;

import exception.CategoriaInvalidaException;
import exception.FabricanteInvalidoException;
import exception.NomeInvalidoException;
import java.util.Random;

public class GerenciamentoDeEquipamentos {
    private Random geraId = new Random();
    private int codigo = geraId.nextInt(90000);
    private String nome;
    private String categoria;
    private String fabricante;
    private String modelo;
    private String setor;
    private  String dataDeInstalacao;
    private boolean status;
    public Random getGeraId() {
        return geraId;
    }
    public void setGeraId(Random geraId) {
        this.geraId = geraId;
    }
    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        try {
            if(codigo <= 0 || )
            this.codigo = codigo;
        } catch (Exception e) {
        }
        
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
        this.modelo = modelo;
    }
    public String getSetor() {
        return setor;
    }
    public void setSetor(String setor) {
        this.setor = setor;
    }
    public String getDataDeInstalacao() {
        return dataDeInstalacao;
    }
    public void setDataDeInstalacao(String dataDeInstalacao) {
        this.dataDeInstalacao = dataDeInstalacao;
    }
    public boolean isStatus() {
        return status;
    }
    public void setStatus(boolean status) {
        this.status = status;
    }

    
}   
