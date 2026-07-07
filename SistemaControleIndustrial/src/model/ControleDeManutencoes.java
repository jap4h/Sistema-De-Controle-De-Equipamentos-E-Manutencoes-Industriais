
import java.util.Random;
import java.util.Scanner;

public class ControleDeManutencoes {
    private Scanner sc = new Scanner(System.in);
    private Random geraId = new Random();
    private int CódigoDaManutenção;
    private Object EquipamentoRelacionado;
    private Object TecnicoResponsável;
    private String DataDeAbertura;
    private String DataDeEncerramento;
    private String TipoDaManutencao;
    private String DescricaoDoProblema ;
    private String Situação;

    RegistrarNovaManutenção;
    ConsultarManutenção;
    AlterarSituaçãoDaManutenção;
    
    public void FinalizarManutencao(){
        System.out.println("Digite a data de encerramento: ");
        String dataE = sc.nextLine();
        if(dataE.length() != 8){
            
        }
    }
   
}
