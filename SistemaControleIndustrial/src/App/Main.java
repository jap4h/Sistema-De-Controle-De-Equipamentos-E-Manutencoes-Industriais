package App;
import exception.CodigoExistenteException;
import exception.MatriculaExistenteException;
import java.util.ArrayList;
import model.*;

public class Main {
    public static ArrayList <GerenciadorDeTecnicos> Tecnicos = new ArrayList<>();
    public static ArrayList <GerenciamentoDeEquipamentos> Equipamentos = new ArrayList<>();
    public static ArrayList <ControleDeManutencoes> Manutencoes = new ArrayList<>();
    
    public static void cadastrarTecnicos(String nome , String setor , int matricula , String telefone) throws CodigoExistenteException , MatriculaExistenteException{
        try {
            GerenciadorDeTecnicos tecnicoPraCadastro = new GerenciadorDeTecnicos(nome, setor, matricula, telefone);
            for(GerenciadorDeTecnicos T : Tecnicos){
                T.validarCodigo();
                T.validarMatricula();
            }
            Tecnicos.add(tecnicoPraCadastro);
            System.out.println("Usuario cadastrado com sucesso.");
        } catch (CodigoExistenteException E) {
            System.err.println("Erro: " + E.getMessage());
        }
    }

    public static void cadastrarEquipamentos(String nome , String categoria , String fabricante , String modelo , String setor , String dataDeInstalacao ){
        try {
            GerenciamentoDeEquipamentos equipamento = new GerenciamentoDeEquipamentos(nome, categoria, fabricante, modelo, setor, dataDeInstalacao);
            for(GerenciamentoDeEquipamentos E : Equipamentos){
                E.validarCodigo();  
            }
        } catch (Exception E) {
            System.err.println("Erro: " + E.getMessage());
        }
    }

    public static void cadastrarManutencao(String dataDeAbertura , String dataDeEncerramento , String tipoDaManutencao , String descricaoDoProblema){
        try {
            
        } catch (Erro E) {
        }
    }


    
}
