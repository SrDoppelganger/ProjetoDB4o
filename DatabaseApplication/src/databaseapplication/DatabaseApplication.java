package databaseapplication;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import java.util.Scanner;

public class DatabaseApplication extends Metodos{

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        //criação ou acesso do bd
        ObjectContainer container = Db4oEmbedded.openFile("database.db4o");
        
        System.out.println("Projeto Banco de Dados db4o");
        System.out.println("o que você deseja fazer?\n 1- adicionar dados\n 2-deletar dados\n 3-buscar dados\n 4-atualizar dados\n 0-sair");
        int escolha = scan.nextInt();
        
        switch(escolha){
            case 1:
                try{
                    adicionar(container);
                }finally{
                    container.close();} 
            break;
            case 2:
                try{
                    deletar(container);
                }finally{
                    container.close();} 
            break;
            case 3:
                try{
                    buscar(container);
                }finally{
                    container.close();} 
            break;
            case 4:
                try{
                    atualizar(container);
                }finally{
                    container.close();} 
            break;
            case 0:
                System.out.println("Desligando...");
            break;
            default:
            System.out.println("Opção inválida");
        }
        
       
        
        scan.close();
    }
    
}
