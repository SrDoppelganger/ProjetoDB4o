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
        System.out.println("o que você deseja fazer?\n 1- adicionar dados\n 2-deletar dados\n 3-buscar dados\n 4-atualizar dados\n 5-imprimir dados\n 0-sair");
        int escolha = scan.nextInt();
        
        switch(escolha){
            case 1:
                try{
                    Scanner ler = new Scanner(System.in);
                    System.out.print("Insira o nome: ");
                    String addNome = ler.nextLine();
                    System.out.print("Insira a raça: ");
                    String addRaça = ler.nextLine();
                    adicionar(container,addNome,addRaça);
                }finally{
                    container.close();} 
            break;
            case 2:
                try{
                    Scanner ler = new Scanner(System.in);
                    System.out.print("Insira o nome a ser deletado: ");
                    String delDado = ler.nextLine();
                    deletar(container,delDado);
                }finally{
                    container.close();} 
            break;
            case 3:
                try{
                    Scanner ler = new Scanner(System.in);
                    System.out.print("Insira o nome a ser buscado: ");
                    String seaDado = ler.nextLine();
                    buscar(container,seaDado);
                }finally{
                    container.close();} 
            break;
            case 4:
                try{
                    Scanner ler = new Scanner(System.in);
                    System.out.print("Insira o nome original: ");
                    String oldNome = ler.nextLine();
                    System.out.print("Insira um novo nome: ");
                    String newNome = ler.nextLine();
                    atualizar(container,oldNome,newNome);
                }finally{
                    container.close();} 
            break;
            case 5:
                try{
                    imprimir(container);
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