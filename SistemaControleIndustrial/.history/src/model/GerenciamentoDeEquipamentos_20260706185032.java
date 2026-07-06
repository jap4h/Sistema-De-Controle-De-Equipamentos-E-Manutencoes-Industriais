package model;

import java.util.Random;

import exception.NomeInvalidoException;

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
        this.codigo = codigo;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        try {
            if(nome == null || nome.isEmpty()){
                throw new NomeInvalidoException("")
        }
        this.nome = nome;
        } catch (NomeInvalidoException E) {
        }
       

    }
    public String getCategoria() {
        return categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    public String getFabricante() {
        return fabricante;
    }
    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
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
