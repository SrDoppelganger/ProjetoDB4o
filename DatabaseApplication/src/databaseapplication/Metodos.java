package databaseapplication;

import com.db4o.ObjectContainer;
import com.db4o.query.Predicate;
import java.util.List;


public class Metodos {
    public static void adicionar(ObjectContainer container){
        Dados d = new Dados("Café","Bombaim");
        container.store(d);
        System.out.println("Add " + d);
    }
    
    public static void deletar(ObjectContainer container){
        List<Dados> dados = container.query(new Predicate<Dados>(){
        @Override
        public boolean match(Dados o){
        return o.getNome().equals("Café");
            }
        });
        
        Dados d = dados.get(0);
        container.delete(d);
        
        System.out.println(d.getNome()+" foi deletado com sucesso.");
    }
    
    public static void buscar(ObjectContainer container){
        List<Dados> dados = container.query(new Predicate<Dados>(){
        @Override
        public boolean match(Dados o){
            return o.getNome().equals("Café");
        }
        }); 
        for (Dados d : dados){
            System.out.println("Nome|Raça");
            System.out.println(d.getNome()+"|"+d.getRaça());
        }
        
        
    }
    
    public static void atualizar(ObjectContainer container){
        List<Dados> dados = container.query(new Predicate<Dados>(){
        @Override
        public boolean match(Dados o){
        return o.getNome().equals("Café");
        }
        });
        
        Dados d = dados.get(0);
        d.setNome("moca");
        container.store(d);
        
        System.out.println("Dado(s) atualizado(s) com sucesso.");
    }
    
}
