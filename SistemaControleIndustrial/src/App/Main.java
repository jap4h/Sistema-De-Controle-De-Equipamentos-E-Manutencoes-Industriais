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

    public static void Menu() throws Exception {
        int pergunta = -1;
        while(pergunta != 0){
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
                    System.out.println("Encerrando sistema.");
                    break;

                case 1:
                    System.out.println("1-Cadastrar equipamento.\n2-Consultar equipamento pelo codigo.\n3-Alterar informações.\n4-Excluir equipamento.\n5-Listar todos equipamentos.");
                    int perguntaEqp = sc.nextInt();
                    sc.nextLine();
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
                            boolean encontrado = false;
                            System.out.println("Digite o codigo do equipamento que deseja consultar: ");
                            int codDesejado = sc.nextInt();
                            sc.nextLine();
                            for(GerenciamentoDeEquipamentos equipamentosConsulta : Equipamentos){
                                if(equipamentosConsulta.getCodigo() == codDesejado){
                                    equipamentosConsulta.mostrarEquipamento();
                                    encontrado = true;
                                    break;
                                }
                            }
                            if(!encontrado){
                                    throw new Erro("O codigo do equipamento não foi encontrado.");
                                }
                        } catch (Exception E) {
                            System.err.println("Erro: " + E.getMessage());
                        }
                           break;
                        case 3:
                            boolean encontradoAlterar = false;
                            System.out.println("Digite o codigo desejado do equipamento pra alterar: ");
                            int codAlterar  = sc.nextInt();
                            sc.nextLine();
                            for(GerenciamentoDeEquipamentos equipamentosAlterar : Equipamentos){
                                if(equipamentosAlterar.getCodigo() == codAlterar){
                                    System.out.println("Equipamento encontrado.");
                                    System.out.println("Digite qual informação deseja alterar: \n1-Nome \n2-Categoria \n3-Modelo \n4-Fabricante \n5-Setor \n6-Data de instalação \n7-Status");
                                    String informacao = sc.nextLine();
                                    if(informacao.equalsIgnoreCase("Nome")){
                                        System.out.println("Digite o novo nome do equipamento: ");
                                        equipamentosAlterar.setNome(sc.nextLine());
                                        break;
                                    }
                                    if(informacao.equalsIgnoreCase("Categoria")){
                                        System.out.println("Digite a nova categoria: ");
                                        equipamentosAlterar.setCategoria(sc.nextLine());
                                        break;
                                    }
                                    if(informacao.equalsIgnoreCase("Modelo")){
                                        System.out.println("Digite o novo modelo: ");
                                        equipamentosAlterar.setModelo(sc.nextLine());
                                        break;
                                    }
                                    if(informacao.equalsIgnoreCase("Fabricante")){
                                        System.out.println("Digite o novo fabricante: ");
                                        equipamentosAlterar.setFabricante(sc.nextLine());
                                        break;
                                    }
                                    if(informacao.equalsIgnoreCase("Setor")){
                                        System.out.println("Digite o novo setor: ");
                                        equipamentosAlterar.setSetor(sc.nextLine());
                                        break;
                                    }
                                    if(informacao.equalsIgnoreCase("Data de instalação")){
                                        System.out.println("Digite a data de instalação:");
                                        equipamentosAlterar.setDataDeInstalacao(sc.nextLine());
                                        break;
                                    }
                                    if(informacao.equalsIgnoreCase("Status")){
                                        System.out.println("Digite o status do equipamento: ");
                                        equipamentosAlterar.setStatus(sc.nextLine());
                                        break;
                                    }
                                    else{
                                        throw new Erro("O atributo que voê deseja altera é inexistente.");
                                    }
                                }
                            }
                            if(!encontradoAlterar){
                                throw new Erro("Codigo digitado invalido");
                            }
                            break;
                        case 4: 
                            try {
                                boolean encontradoEqp = false;
                                System.out.println("Digite o codigo do equipamento que você deseja excluir: ");
                                int codExcluir = sc.nextInt();
                                sc.nextLine();
                                for ( int cont = 0 ; cont < Equipamentos.size() ; cont++ ){
                                    if(Equipamentos.get(cont).getCodigo() == codExcluir){
                                        Equipamentos.remove(cont);
                                        System.out.println("Equipamento excluido com sucesso.");
                                        encontradoEqp = true;
                                        break;
                                    } 
                                }
                                if(!encontradoEqp){
                                    throw new Erro("Equipamento não encontrado, codigo incorreto digitado.");
                                }
                            } catch (Exception E) {
                                System.err.println("Erro: " + E.getMessage());
                            }
                            break;

                        case 5:
                            for( GerenciamentoDeEquipamentos E : Equipamentos){
                                E.mostrarEquipamento();
                            }
                            break;
                    }
                    break;

                case 2:
                    System.out.println("1-Cadastrar técnico.\r\n" + //
                                                "2-Consultar técnico.\r\n" + //
                                                "3-Alterar informações.\r\n" + //
                                                "4-Excluir técnico.\r\n" + //
                                                "5-Listar todos os técnicos cadastrados");
                    int perguntaTecnico = sc.nextInt();
                    sc.nextLine();
                    switch(perguntaTecnico){
                        case 1:
                            try{
                                System.out.println("Digite o nome do tecnico: ");
                                String nome = sc.nextLine();
                                System.out.println("Digite o setor do tecnico: ");
                                String setor = sc.nextLine();
                                System.out.println("Digite o numero da matricula: ");
                                int matricula = sc.nextInt();
                                sc.nextLine();
                                System.out.println("Digite o numero de telefone: ");
                                String telefone = sc.nextLine();
                                GerenciadorDeTecnicos tecnico = new GerenciadorDeTecnicos(nome, setor, matricula, telefone);
                                Tecnicos.add(tecnico);
                            } catch(Exception E){
                                System.out.println("Erro: " + E.getMessage());
                            }
                            break;
                        case 2:
                            try {
                                System.out.println("Digite o codigo do tecnico pra coonsultar: ");
                                int codTecCons = sc.nextInt();
                                sc.nextLine();
                                for(GerenciadorDeTecnicos tecnicos : Tecnicos){
                                    if(tecnicos.getCodigo() == codTecCons){

                                    }else{
                                        throw new Erro("O codigo digitado não foi encontrado.");
                                    }
                                }
                            } catch (Exception E) {
                                System.err.println("Erro: " + E.getMessage());
                            }
                            break;
                        case 3:
                            break;

                        case 4:
                            try {
                                System.out.println("Digite o codigo do tecnico que você deseja excluir: ");
                                int codTecExc = sc.nextInt();
                                sc.nextLine();
                                for(int cont = 0 ; cont < Main.Tecnicos.size() ; cont++ ){
                                    if(Main.Tecnicos.get(cont).getCodigo() == codTecExc){
                                        Main.Tecnicos.remove(cont);
                                        System.out.println("Tecnico removido com sucesso.");
                                    }else{
                                        throw new Erro("O tecnico não foi encontrado , codigo digitiado incorreto.");
                                    }
                                }
                            } catch (Exception E) {
                                System.err.println("Erro: " + E.getMessage());
                            }
                            break;
                        case 5:
                            for(GerenciadorDeTecnicos tecnicos : Tecnicos){
                                tecnicos.mostrarTecnico();
                            }
                            break;
                    }
                    break;
                case 3:
                    System.out.println("1-Registrar nova manutenção;\r\n" + //
                                                "2-Consultar manutenção;\r\n" + //
                                                "3-Alterar situação da manutenção;\r\n" + //
                                                "4-Finalizar manutenção;\r\n" + //
                                                "5-Listar todas as manutenções cadastradas.\r\n" + //
                                                "");
                    int perguntaManutencao = sc.nextInt();
                    sc.nextLine();
                    switch(perguntaManutencao){
                        case 1:
                            try{
                                System.out.println("Digite a data de abertura da manutenção: ");
                                String dataAberturaManutencao = sc.nextLine();
                                System.out.println("Digite a data de encerramento da manutenção: ");
                                String dataEncerramentoManutencao = sc.nextLine();
                                System.out.println("Digite o tip ode manutenção: ");
                                String tipoManutencao = sc.nextLine();
                                System.out.println("Digite a descrição do problema: ");
                                String descricaoProblema = sc.nextLine();
                                ControleDeManutencoes controle = new ControleDeManutencoes(tipoManutencao, dataEncerramentoManutencao, dataAberturaManutencao, descricaoProblema);
                                Manutencoes.add(controle);
                            }catch(Exception E){
                                System.err.println("Erro: " + E.getMessage());
                            }
                            break;

                        case 2:
                            System.out.println("Digite o codigo da manutenção que deseja consultar: ");
                            int codManCons = sc.nextInt();
                            for(ControleDeManutencoes controles : Manutencoes){
                                if(controles.getCodigoDaManutencao() == codManCons){
                                    controles.mostrarManutencao();
                                    break;
                                }else{
                                    throw new Erro("OA manutenção não foi encontrada , codigo não encontrado.");
                                }
                            }
                            break;

                        case 3:
                            
                            break;

                        case 4:
                            break;

                        case 5:
                            break;
                    }
                    break;

                case 4:
                    break;

                
            }
        }
    }
}
