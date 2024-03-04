package databaseapplication;

public class Dados {
    private String nome;
    private String raça;
    
    public Dados(String nome,String raça){
        this.nome = nome;
        this.raça = raça;
    }
    
    public String getNome(){
        return nome;
    }
    
    public void setNome(String n){
        this.nome=n;
    }
    
    public String getRaça(){
        return raça;
    }
    
    @Override
    public String toString(){
        return nome+"|"+raça;
    }
    
    public Dados(){}
}
