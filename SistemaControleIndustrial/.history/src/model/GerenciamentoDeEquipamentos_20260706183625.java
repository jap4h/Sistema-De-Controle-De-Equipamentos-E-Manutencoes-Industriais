package model;

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
}   
