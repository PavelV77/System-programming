package hibernatepackage;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import recordspackage.OneRecord;

public class HibClass {
    private static SessionFactory sf;
    public static ObservableList arr;
    public HibClass(){
        Configuration con = new Configuration().configure();
        con.addAnnotatedClass(OneRecord.class);
        StandardServiceRegistryBuilder sBilder = new StandardServiceRegistryBuilder().applySettings(con.getProperties());
        sf = con.buildSessionFactory(sBilder.build());
    }

    public static void createRecord(String address, String port,String protocol){
        Session sessionCreate = sf.openSession();
        Transaction trCreate = sessionCreate.beginTransaction();
        sessionCreate.save(new OneRecord(address,port,protocol));
        trCreate.commit();
        sessionCreate.close();
    }

    public static void deleteRecord(int id){
        Session sessionDelete = sf.openSession();
        Transaction trDelete = sessionDelete.beginTransaction();
        OneRecord record = new OneRecord();
        record.setId(id);
        sessionDelete.delete(record);
        trDelete.commit();
        sessionDelete.close();
    }

    public static ObservableList<Object> getAllRec(){
        Session sessionGet = sf.openSession();
        Transaction trGet = sessionGet.beginTransaction();
        arr = FXCollections.observableArrayList(sessionGet.createSQLQuery("SELECT * FROM bd_sp1.myrecords;").addEntity(OneRecord.class).list());
        trGet.commit();
        sessionGet.close();
        return arr;
    }
}
