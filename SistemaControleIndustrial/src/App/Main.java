package App;

import exception.*;
import java.util.ArrayList;
import java.util.Scanner;
import model.*;

public class Main {
    public static ArrayList <GerenciadorDeTecnicos> Tecnicos = new ArrayList<>();
    public static ArrayList <GerenciamentoDeEquipamentos> Equipamentos = new ArrayList<>();
    public static ArrayList <ControleDeManutencoes> Manutencoes = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    
    public static void cadastrarTecnicos(String nome , String setor , int matricula , String telefone) {
        try {
            GerenciadorDeTecnicos tecnicoPraCadastro = new GerenciadorDeTecnicos(nome, setor, matricula, telefone);
            tecnicoPraCadastro.validarCodigo();
            tecnicoPraCadastro.validarMatricula();
            Tecnicos.add(tecnicoPraCadastro);
            System.out.println("Usuario cadastrado com sucesso.");
        } catch (Exception E) {
            System.err.println("Erro: " + E.getMessage());
        }
    }

    public static void cadastrarEquipamentos(String nome , String categoria , String fabricante , String modelo , String setor , String dataDeInstalacao , String status){
        try {
            GerenciamentoDeEquipamentos equipamento = new GerenciamentoDeEquipamentos(nome, categoria, fabricante, modelo, setor, dataDeInstalacao , status);
            equipamento.validarCodigo();
            Equipamentos.add(equipamento);
            System.out.println("Cadastro realizado com sucesso.");
        } catch (Exception E) {
            System.err.println("Erro: " + E.getMessage());
        }
    }

    public static void cadastrarManutencao(String dataDeAbertura, String dataDeEncerramento, String tipoDaManutencao, String descricaoDoProblema) throws Erro{
        try{
            ControleDeManutencoes manutencao = new ControleDeManutencoes(dataDeAbertura, dataDeEncerramento, tipoDaManutencao, descricaoDoProblema);
            Manutencoes.add(manutencao);
            System.out.println("Manutenção cadastrada com sucesso.");
        } catch(Exception E){
            System.err.println("Erro: " + E.getMessage());
        }
    }

    public static void Menu() throws Erro {
        int pergunta = -1;
        while(pergunta != 0)
            System.out.println("==============================================\r\n" + //
                            "SISTEMA DE CONTROLE DE EQUIPAMENTOS\r\n" + //
                            "==============================================\r\n" + //
                            "1 - Equipamentos\r\n" + //
                            "2 - Técnicos\r\n" + //
                            "3 - Manutenções\r\n" + //
                            "4 - Relatórios\r\n" + //
                            "0 - Encerrar Sistema\r\n" + //
                            "Escolha uma opção:");
            pergunta = sc.nextInt();
            sc.nextLine();
            switch(pergunta){

                case 0:
                    
                    break;

                case 1:
                    System.out.println("1-Cadastrar equipamento.\n2-Consultar equipamento pelo codigo.\n3-Alterar informações.\n4-Excluir equipamento.\n5-Listar todos equipamentos.");
                    int perguntaEqp = sc.nextInt();
                    switch(perguntaEqp){
                        case 1:
                            try {
                                System.out.println("Digite o nome do equipamento: ");
                                String nome = sc.nextLine();
                                System.out.println("Digite a categoria do equipamento: ");
                                String categoria = sc.nextLine();
                                System.out.println("Digite o fabricante do equipamento: ");
                                String fabricante = sc.nextLine();
                                System.out.println("Digite o modelo do equipamento: ");
                                String modelo = sc.nextLine();
                                System.out.println("Digite o setor do equipamento: ");
                                String setor = sc.nextLine();
                                System.out.println("Digite a data de instalação(xx/xx/xxxx): ");
                                String dataDeInstalacao = sc.nextLine();
                                System.out.println("Digite o status do equipamento(Inativo,Operando ou Em manutencao): ");
                                String status = sc.nextLine();
                                cadastrarEquipamentos(nome, categoria, fabricante, modelo, setor, dataDeInstalacao , status);

                            } catch (Exception E) {
                                System.out.println("Erro: " + E.getMessage());
                            }
                            break;                            

                        case 2: 
                        try {
                            System.out.println("Digite o codigo do equipamento que deseja consultar: ");
                            int codDesejado = sc.nextInt();
                            for(GerenciamentoDeEquipamentos equipamentosConsulta : Equipamentos){
                                if(equipamentosConsulta.getCodigo() == codDesejado){
                                    equipamentosConsulta.mostrarEquipamento();
                                    return;
                                }
                                throw new Erro("Equipamento não encontrado.");
                            }
                            
                        } catch (Exception E) {
                            System.err.println("Erro: " + E.getMessage());
                        }
                           break;
                        case 3:
                            System.out.println("Digite o codigo desejado do equipamento pra alterar: ");
                            int codAlterar  = sc.nextInt();
                            for(GerenciamentoDeEquipamentos equipamentosAlterar : Equipamentos){
                                if(equipamentosAlterar.getCodigo() == codAlterar){
                                    System.out.println("Equipamento encontrado.");
                                    System.out.println("Digite qual informação deseja alterar: \n1-Nome \n2-Categoria \n3-Modelo \n4-Fabricante \n5-Setor \n6-Data de instalação \n7-Status");
                                    String informacao = sc.nextLine();
                                    if(informacao.equalsIgnoreCase("Nome")){
                                        System.out.println("Digite o novo nome do equipamento: ");
                                        equipamentosAlterar.setNome(sc.nextLine());
                                        return;
                                    }
                                    if(informacao.equalsIgnoreCase("Categoria")){
                                        System.out.println("Digite a nova categoria: ");
                                        equipamentosAlterar.setCategoria(sc.nextLine());
                                        return;
                                    }
                                    if(informacao.equalsIgnoreCase("Modelo")){
                                        System.out.println("Digite o novo modelo: ");
                                        equipamentosAlterar.setModelo(sc.nextLine());
                                        return;
                                    }
                                    if(informacao.equalsIgnoreCase("Fabricante")){
                                        System.out.println("Digite o novo fabricante: ");
                                        equipamentosAlterar.setFabricante(sc.nextLine());
                                        return;
                                    }
                                    if(informacao.equalsIgnoreCase("Setor")){
                                        System.out.println("Digite o novo setor: ");
                                        equipamentosAlterar.setSetor(sc.nextLine());
                                        return;
                                    }
                                    if(informacao.equalsIgnoreCase("Data de instalação")){
                                        System.out.println("Digite a data de instalação:");
                                        equipamentosAlterar.setDataDeInstalacao(sc.nextLine());
                                        return;
                                    }
                                    if(informacao.equalsIgnoreCase("Status")){
                                        System.out.println("Digite o status do equipamento: ");
                                        equipamentosAlterar.setStatus(sc.nextLine());
                                        return;
                                    }
                                    else{
                                        throw new Erro("O atributo que voê deseja altera é inexistente.");
                                    }
                                }
                                throw new Erro("Codigo digitado invalido");
                            }
                            break;
                        case 4: 
                            System.out.println("Digite o codigo do equipamento que voc^deseja excluir: ");
                            int codExcluir = sc.nextInt();
                            
                            break;

                        case 5:
                            break;
                    }
                    break;

                case 2:
                    break;

                case 3:
                    break;

                case 4:
                    break;

                
            }
    }


    
}
