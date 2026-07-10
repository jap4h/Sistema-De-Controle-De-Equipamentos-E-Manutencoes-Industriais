package app;

import exception.*;
import java.util.ArrayList;
import java.util.Scanner;
import model.*;

public class Main {
    private static ArrayList <model.GerenciadorDeTecnicos> Tecnicos = new ArrayList<>();
    private static ArrayList <model.GerenciamentoDeEquipamentos> Equipamentos = new ArrayList<>();
    private static ArrayList <model.ControleDeManutencoes> Manutencoes = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);
    
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

    public static void cadastrarManutencao(String dataDeAbertura, String dataDeEncerramento, String tipoDaManutencao, String descricaoDoProblema , GerenciamentoDeEquipamentos equipamentoEmManutencao , GerenciadorDeTecnicos tecnicoResponsavel) throws Exception{
        try{
            model.ControleDeManutencoes manutencao = new ControleDeManutencoes(dataDeAbertura, dataDeEncerramento, tipoDaManutencao, descricaoDoProblema, equipamentoEmManutencao, tecnicoResponsavel);
            
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
                                System.out.println("Digite o status do equipamento(Inativo ou Operando): ");
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
                            try {
                                boolean encontradoAlterar = false;
                                System.out.println("Digite o codigo desejado do equipamento pra alterar: ");
                                int codAlterar  = sc.nextInt();
                                sc.nextLine();
                                for(GerenciamentoDeEquipamentos equipamentosAlterar : Equipamentos){
                                    if(equipamentosAlterar.getCodigo() == codAlterar){
                                        encontradoAlterar = true;
                                        System.out.println("Equipamento encontrado.");
                                        System.out.println("Digite qual informação deseja alterar: \nNome \nCategoria \nModelo \nFabricante \nSetor \nData de instalação \nStatus");
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
                            } catch (Exception E) {
                                System.err.println("Erro: " + E.getMessage());
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
                                        if( !Equipamentos.get(cont).getStatus().equalsIgnoreCase("Operando") && !Equipamentos.get(cont).getStatus().equalsIgnoreCase("Em manutencao")){
                                            Equipamentos.remove(cont);
                                            System.out.println("Equipamento excluido com sucesso.");
                                            encontradoEqp = true;
                                        }else{
                                            throw new Exception("Equipamento está em manutenção.");
                                        }
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
                                cadastrarTecnicos(nome, setor, matricula, telefone);
                            } catch(Exception E){
                                System.out.println("Erro: " + E.getMessage());
                            }
                            break;
                            
                        case 2:
                            try {
                                boolean encontradoCodTecAlt = false;
                                System.out.println("Digite o codigo do tecnico pra coonsultar: ");
                                int codTecCons = sc.nextInt();
                                sc.nextLine();
                                for(GerenciadorDeTecnicos tecnicos : Tecnicos){
                                    if(tecnicos.getCodigo() == codTecCons){
                                        tecnicos.mostrarTecnico();
                                        encontradoCodTecAlt = true;
                                    }
                                }
                                if(encontradoCodTecAlt == false){
                                        throw new Erro("O codigo digitado não foi encontrado.");
                                    }
                            } catch (Exception E) {
                                System.err.println("Erro: " + E.getMessage());
                            }
                            break;

                        case 3:
                            try {
                                System.out.println("Digite o codigo do tecnico que deseja alterar: ");
                                int codAltTec = sc.nextInt();
                                for(GerenciadorDeTecnicos tecnicos : Tecnicos){
                                    if(tecnicos.getCodigo() == codAltTec){
                                        System.out.println("Digite o que você deseja alterar no tecnico: \n1-nome \n2-setor \n3-matricula \n4-telefone");
                                        int perguntaAltTec = sc.nextInt();
                                        sc.nextLine();
                                        switch(perguntaAltTec){
                                            case 1:
                                                System.out.println("Digite o novo nome do tecnico: ");
                                                tecnicos.setNome(sc.nextLine());
                                                break;

                                                case 2:
                                                    System.out.println("Digite o nome do setor: ");
                                                    tecnicos.setSetor(sc.nextLine());
                                                    break;

                                                case 3:
                                                    System.out.println("Digite o novo numero da matricula: ");
                                                    tecnicos.setMatricula(sc.nextInt());
                                                    break;

                                                case 4:
                                                    System.out.println("Digite o novo numero do telefone: ");
                                                    tecnicos.setTelefone(sc.nextLine());
                                                    break;

                                                default: 
                                                    throw new Erro("O atributo inserido é invalido");
                                        }
                                    }
                                }
                            } catch (Exception E) {
                                System.err.println("Erro: " + E.getMessage());
                            }
                            break;

                        case 4:
                            try {
                                boolean encontradoTecExc = false;
                                System.out.println("Digite o codigo do tecnico que você deseja excluir: ");
                                int codTecExc = sc.nextInt();
                                sc.nextLine();
                                for(int cont = 0 ; cont < Main.Tecnicos.size() ; cont++ ){
                                    if(Main.Tecnicos.get(cont).getCodigo() == codTecExc){
                                        Main.Tecnicos.remove(cont);
                                        encontradoTecExc = true;
                                        System.out.println("Tecnico removido com sucesso.");
                                    }
                                }
                                if(encontradoTecExc == false){
                                        throw new Erro("O tecnico não foi encontrado , codigo digitiado incorreto.");
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

                                GerenciamentoDeEquipamentos equipamentoEmManutencao = null;
                                System.out.println("Digite o codigo do equipamento em manutenção: ");
                                int codEqpMan = sc.nextInt();
                                sc.nextLine();
                                boolean encontradoManEqps = false;
                                for(GerenciamentoDeEquipamentos equipamentos : Equipamentos){
                                    if(equipamentos.getCodigo() == codEqpMan){
                                        equipamentoEmManutencao = equipamentos;
                                        encontradoManEqps = true;
                                    }
                                }
                                if(encontradoManEqps == false){
                                        throw new Erro("Equipamento não encontrado.");
                                }
                                boolean encontradoManTec = false;
                                GerenciadorDeTecnicos tecnicoResponsavel = null;
                                System.out.println("Digite o codigo do tecnico responsavel: ");
                                int codTecMan = sc.nextInt();
                                sc.nextLine();
                                for(GerenciadorDeTecnicos tecnicos : Tecnicos){
                                    if(tecnicos.getCodigo() == codTecMan){
                                        tecnicoResponsavel = tecnicos;
                                        encontradoManTec = true;
                                    }
                                }
                                if(encontradoManTec == false){
                                        throw new Erro("O tecnic não foi encontrado.");
                                    }
                                cadastrarManutencao(dataAberturaManutencao, dataEncerramentoManutencao, tipoManutencao, descricaoProblema , equipamentoEmManutencao , tecnicoResponsavel);
                            }catch(Exception E){
                                System.err.println("Erro: " + E.getMessage());
                            }
                            break;

                        case 2:
                            try {
                                boolean encontradoCodManCon = false;
                                System.out.println("Digite o codigo da manutenção que deseja consultar: ");
                                int codManCons = sc.nextInt();
                                for(ControleDeManutencoes controles : Manutencoes){
                                    if(controles.getCodigoDaManutencao() == codManCons){
                                        controles.mostrarManutencao();
                                        encontradoCodManCon = true;
                                        break;
                                    }
                                }
                                if(encontradoCodManCon == false){
                                        throw new Erro("A manutenção não foi encontrada , codigo não encontrado.");
                                    }
                            } catch (Exception E) {
                                System.err.println("Erro: " + E.getMessage());
                            }
                            break;

                        case 3:
                            try {
                                boolean encontradoCodAltMan = false;
                                System.out.println("Digite o codigo da manutenção: ");
                                int codManAlt = sc.nextInt();
                                sc.nextLine();
                                for(ControleDeManutencoes  manutencoes : Manutencoes){
                                    if(manutencoes.getCodigoDaManutencao() == codManAlt){
                                        System.out.println("Digite o atributo que deseja alterar na manutenção: \n1-Tipo da manutenção \n2-Data de encerramento da manutenção \n3-Data de abertura da manutenção \n4-Descrição do problema");
                                        int perguntaAltMan = sc.nextInt();
                                        sc.nextLine();
                                        switch(perguntaAltMan){
                                            case 1:
                                                System.out.println("Digite o novo tipo da manutenção (Preventiva/Corretiva): ");
                                                manutencoes.setTipoDaManutencao(sc.nextLine());
                                                encontradoCodAltMan = true;
                                                break;

                                            case 2:
                                                System.out.println("Digite a nova data de encerramento da manutenção(xx/xx/xxxx: ");
                                                manutencoes.setDataDeEncerramento(sc.nextLine());
                                                encontradoCodAltMan = true;
                                                break;

                                            case 3:
                                                System.out.println("Digite a data de abertura da manutenção: ");
                                                manutencoes.setDataDeAbertura(sc.nextLine());
                                                encontradoCodAltMan = true;
                                                break;

                                            case 4:
                                                System.out.println("Digite a descrição do problema: ");
                                                manutencoes.setDescricaoDoProblema(sc.nextLine());
                                                encontradoCodAltMan = true;
                                                break;
                                        }
                                    }
                                }
                                if(encontradoCodAltMan == false){
                                        throw new Erro("O codigo da mautenção não foi encontrado.");
                                    }
                            } catch (Exception E) {
                                System.err.println("Erro: " + E.getMessage());
                            }                                                         
                            break;

                        case 4:
                            try {
                                boolean encontradoManFin = false;
                                System.out.println("Digite o codigo da manutenção que vai ser finalizada: ");
                                int codManFin = sc.nextInt();
                                sc.nextLine();
                                for(ControleDeManutencoes controles : Manutencoes){
                                    if(controles.getCodigoDaManutencao() == codManFin){
                                        controles.FinalizarManutencao();
                                        encontradoManFin = true;
                                    }
                                }
                                if(encontradoManFin == false){
                                        throw new Erro("O codigo da manutenção não foi encontrado.");
                                }
                            } catch (Exception E) {
                                System.err.println("Erro: " + E.getMessage());
                            }
                            break;

                        case 5:
                            for(ControleDeManutencoes controles : Manutencoes){
                                controles.mostrarManutencao();
                            }
                            break;
                    }
                    break;

                case 4:
                    System.out.println("Relatorios: ");
                    System.out.println("1-Quantidade total de equipamentos cadastrados");
                    System.out.println("2-Total de técnicos cadastrados");
                    System.out.println("3-Equipamentos em manutenção");
                    System.out.println("4-Equipamentos ativos");
                    System.out.println("5-Equipamentos inativos");
                    System.out.println("6-Quantidade de manutenções abertas");
                    System.out.println("7-Quantidade de manutenções finalizadas");
                    System.out.println("8-Quantidade de manutenções por equipamento.");
                    int perguntaRelatorio = sc.nextInt();
                    switch(perguntaRelatorio){
                        case 1:
                            System.out.println("equipamentos cadastrado: " + Equipamentos.size());
                            break;

                        case 2:
                            System.out.println("Tecnicos cadastrados: " + Tecnicos.size());
                            break;

                        case 3:
                            int eqpsManu = 0;
                            for(ControleDeManutencoes manutencoes : Manutencoes ){
                                if(manutencoes.getEquipamentoRelacionado().getStatus().equalsIgnoreCase("Em manutencao")){
                                    eqpsManu++;
                                }
                            }
                            System.out.println("Equipamentos em manutenção: " + eqpsManu);
                            break;

                        case 4:
                            int eqpsOprnd = 0;
                            for(GerenciamentoDeEquipamentos equipamentos : Equipamentos){
                                if(equipamentos.getStatus().equalsIgnoreCase("Operando")){
                                    eqpsOprnd++;
                                }
                            }
                            System.out.println("Equipamtos operando: " + eqpsOprnd);
                            break;
                        case 5:
                            int eqpsIntvs = 0;
                            for(GerenciamentoDeEquipamentos equipamentos : Equipamentos){
                                if(equipamentos.getStatus().equalsIgnoreCase("Inativo")){
                                    eqpsIntvs++;
                                }
                            }
                            System.out.println("Equipamentos inativos: " + eqpsIntvs);
                            break;

                        case 6:
                            int manAbrts = 0;
                            for(ControleDeManutencoes manutencoes : Manutencoes ){
                                if(manutencoes.getSituacao().equalsIgnoreCase("Aberta")){
                                    manAbrts++;
                                }
                            }
                            System.out.println("Manutenções abertas: " + manAbrts);
                            break;

                        case 7:
                            int manFnlzds = 0;
                            for(ControleDeManutencoes manutencoes : Manutencoes){
                                if(manutencoes.getSituacao().equalsIgnoreCase("Finalizada")){
                                    manFnlzds++;
                                }
                            }
                            System.out.println("Manutenções finalizadas: " + manFnlzds);
                            break;

                        case 8:
                            for(int cont2 = 0 ; cont2 < Equipamentos.size() ; cont2++ ){
                                int eqpsQtdd = 0;

                                for(int cont = 0 ; cont < Manutencoes.size() ; cont++ ){
                                    if(Manutencoes.get(cont).getEquipamentoRelacionado().getCodigo() == Equipamentos.get(cont2).getCodigo()){
                                        eqpsQtdd++;
                                    }
                                }
                                System.out.println("Manutencões do equipamento " + Equipamentos.get(cont2).getCodigo() + ": ");
                                System.out.println(eqpsQtdd);
                            }
                            break;
                    }
                    break;

                
            }
        }
    }

    public static ArrayList<GerenciamentoDeEquipamentos> enviarEquipamentos(){
        return Equipamentos;
    }
    public static ArrayList<GerenciadorDeTecnicos> enviarTecnicos(){
        return Tecnicos;
    }
    public static ArrayList<ControleDeManutencoes> enviarManutencoes(){
        return Manutencoes;
    }
    public static Scanner enviarScanner(){
        return sc;
    }


    public void main(String[] args) throws Exception{
        Menu();
    }
}
