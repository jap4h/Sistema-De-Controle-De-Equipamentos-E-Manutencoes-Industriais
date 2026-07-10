package service;

import app.Main;

import java.util.ArrayList;

import model.ControleDeManutencoes;
import model.GerenciadorDeTecnicos;
import model.GerenciamentoDeEquipamentos;

public class ArrayListServices {
    public static final ArrayList<ControleDeManutencoes> Manutencoes = Main.enviarManutencoes();
    public static final ArrayList<GerenciamentoDeEquipamentos> Equipamentos = Main.enviarEquipamentos();
    public static final ArrayList<GerenciadorDeTecnicos> Tecnicos =  Main.enviarTecnicos();
}
