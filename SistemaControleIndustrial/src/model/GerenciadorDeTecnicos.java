package model;


import app.*;
import exception.*;
import java.util.Random;

public class GerenciadorDeTecnicos {
    final private Random geraCodigo = new Random();
    private int codigo = geraCodigo.nextInt(90000);
    private String nome;
    private String setor;
    private int matricula;
    private String telefone;

    public GerenciadorDeTecnicos( String nome , String setor , int matricula , String telefone) throws Exception{
        setCodigo(codigo);
        setNome(nome);  
        setSetor(setor);
        setMatricula(matricula);
        setTelefone(telefone);  
        
    }

    public void validarCodigo()throws Exception {
            for(GerenciadorDeTecnicos tecnicos : Main.Tecnicos) {
            if(tecnicos.getCodigo() == this.codigo){
                throw new CodigoExistenteException("O codigo já existe.");
            }
        } 
        
    }

    public void validarMatricula() throws Exception{
        for(GerenciadorDeTecnicos tecnicos : Main.Tecnicos){
            if(tecnicos.getMatricula() == this.matricula){
                throw new MatriculaExistenteException("A matricula inserida já existe.");
            }
        }
    }

        
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) throws Exception {

        if(nome == null || nome.isEmpty()){
            throw new NomeInvalidoException("O nome inserido está vazio.");
        }
        this.nome = nome;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) throws Exception {
        if(setor == null || setor.isEmpty()){
            throw new SetorInvalidoException("O setor inserido está vazio.");
        }
        this.setor = setor;
        
    }
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        if(codigo <= 0 ){
            while (codigo <= 0 ){
                this.codigo = geraCodigo.nextInt(90000);
            }
        }
        else{
            this.codigo = codigo;
        }
        
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) throws Exception{
        if(matricula <= 0 ){
            throw new  MatriculaInvalidaException("A matricula insrida é invalida.");
        }
        this.matricula = matricula;  
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) throws Exception {
            if(telefone == null || telefone.isEmpty()){
                throw new TelefoneInvalidoException("O telefone inserido está vazio.");
            }  
            if(telefone.length() != 11){
                throw new TelefoneInvalidoException("O telefone inserido é invalido.");
            }      
            this.telefone = telefone;
    }

    public void mostrarTecnico(){
        System.out.println("Tecnico: " + getNome());
        System.out.println("Codigo: " + getCodigo());
        System.out.println("Matricula: " + getMatricula());
        System.out.println("Telefone: " + getTelefone());
        System.out.println("Setor: " + getSetor());
    }
}
