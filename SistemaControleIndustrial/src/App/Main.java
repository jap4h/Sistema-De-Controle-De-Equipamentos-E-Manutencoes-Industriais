package App;
import exception.CodigoExistenteException;
import exception.MatriculaExistenteException;
import java.util.ArrayList;
import model.*;

public class Main {
    public static ArrayList <GerenciadorDeTecnicos> Tecnicos = new ArrayList<>();
    static ArrayList <GerenciamentoDeEquipamentos> Equipamentos = new ArrayList<>();
    
    public static void cadastrarTecnicos(String nome , String setor , int matricula , String telefone) throws CodigoExistenteException , MatriculaExistenteException{
        try {
            for(GerenciadorDeTecnicos T : Tecnicos){
                T.validarCodigo();
                T.validarMatricula();
            }
            GerenciadorDeTecnicos tecnicoPraCadastro = new GerenciadorDeTecnicos(nome, setor, matricula, telefone);
            Tecnicos.add(tecnicoPraCadastro);
            System.out.println("Usuario cadastrado com sucesso.");
        } catch (CodigoExistenteException E) {
            System.err.println("Erro: " + E.getMessage());
        }
    }

    
}
