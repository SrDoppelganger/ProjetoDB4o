package databaseapplication;

import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Predicate;
import java.util.List;


public class Metodos {
    public static void adicionar(ObjectContainer container, String addNome, String addRaça){
        try{
            Dados d = new Dados(addNome,addRaça);
            container.store(d);
            System.out.println("Add " + d);
        }catch(Exception e){
            System.out.println("Dado(s) inválido(s)");
        }
    }
    
    public static void deletar(ObjectContainer container, String delDado){
        try{
            List<Dados> dados = container.query(new Predicate<Dados>(){
            @Override
            public boolean match(Dados o){
            return o.getNome().equals(delDado);
                }
            });

            Dados d = dados.get(0);
            container.delete(d);

        System.out.println(d.getNome()+" foi deletado com sucesso.");
        }catch(Exception e){
            System.out.println("Dado(s) não encontrado(s)");
        }
        
    }
    
    public static void buscar(ObjectContainer container, String seaDado){
        
            List<Dados> dados = container.query(new Predicate<Dados>(){
            @Override
            public boolean match(Dados o){
            return o.getNome().equals(seaDado);
            }
            }); 
            for (Dados d : dados){
                System.out.println("Nome|Raça");
                System.out.println(d.getNome()+"|"+d.getRaça());
            }
    }
    
    public static void atualizar(ObjectContainer container, String oldNome, String newNome){
        try{
             List<Dados> dados = container.query(new Predicate<Dados>(){
            @Override
            public boolean match(Dados o){
            return o.getNome().equals(oldNome);
            }
            });

            Dados d = dados.get(0);
            d.setNome(newNome);
            container.store(d);
        
            System.out.println("Dado(s) atualizado(s) com sucesso.");
        }catch(Exception e){
            System.out.println("Dado(s) Inválido(s) ou Não Encontrado(s)");
        }
       
    }
    
    public static void imprimir(ObjectContainer container){
        System.out.println("Nome|Raça");
        ObjectSet<Dados> result = container.queryByExample(Dados.class);
        while (result.hasNext()) {
            Dados dado = result.next();
            System.out.println(dado.getNome()+"|"+dado.getRaça());
        }
    }  
}