package model;

import exception.MatriculaInvalidaException;
import exception.NomeInvalidoException;
import exception.SetorInvalidoException;
import exception.TelefoneInvalidoException;
import java.util.Random;

public class GerenciadorDeTecnicos {
    private Random geraCodigo = new Random();
    private int codigo = geraCodigo.nextInt(90000);
    private String nome;
    private String setor;
    private int matricula;
    private String telefone;

    public GerenciadorDeTecnicos( String nome , String setor , int matricula , String telefone){
        setCodigo(codigo);
        setNome(nome);  
        setSetor(setor);
        setMatricula(matricula);
        setTelefone(telefone);  
        
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        try {
            if(nome == null || nome.isEmpty()){
                throw new NomeInvalidoException("O nome inserido está vazio.");
            }
            this.nome = nome;
        } catch (NomeInvalidoException E) {
            System.err.println("Erro: " + E.getMessage());
        }
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        try{
        if(setor == null || setor.isEmpty()){
            throw new SetorInvalidoException("O setor inserido está vazio.");
        }
        this.setor = setor;
        }
        catch(SetorInvalidoException E){
            System.err.println("Erro: " + E.getMessage());
        }
       
    }

    public Random getGeraCodigo() {
        return geraCodigo;
    }

    public void setGeraCodigo(Random geraCodigo) {
        this.geraCodigo = geraCodigo;
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
        this.codigo = codigo;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        try {
            if(matricula <= 0 ){
                throw new  MatriculaInvalidaException("A matricula insrida é invalida.");
            }
            this.matricula = matricula;
        } catch (MatriculaInvalidaException E) {
            System.err.println("Erro: " + E.getMessage());
        }
        
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        try{
            if(telefone == null || telefone.isEmpty()){
                throw new TelefoneInvalidoException("O telefone inserido está vazio.");
            }  
            if(telefone.length() != 11){
                throw new TelefoneInvalidoException("O telefone inserido é invalido.");
            }      
            this.telefone = telefone;
        }
        catch(TelefoneInvalidoException E){
            System.err.println("Erro: " + E.getMessage());
        }
    }
}
