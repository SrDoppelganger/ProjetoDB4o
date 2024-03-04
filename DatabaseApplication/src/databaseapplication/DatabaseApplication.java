package databaseapplication;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;

public class DatabaseApplication extends Metodos{

    public static void main(String[] args) {
        ObjectContainer container = Db4oEmbedded.openFile("database.db4o");
        
        try{
           buscar(container);
        }finally{
            container.close();
        }
    }
    
}
