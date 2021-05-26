package org.orakris;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.persistence.TypedQuery;
import java.util.Iterator;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure().build();
        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

        SessionFactory sf = meta.getSessionFactoryBuilder().build();
        Session session = sf.openSession();

        //Transaction transaction = session.beginTransaction();

//        // Store data
//        Student student = new Student();
//        student.setName("abcd");
//
//        Address address = new Address();
//        address.setAddressline("line1");
//        address.setCity("hyderabad");
//        address.setCountry("india");
//        address.setState("hyderabad");
//        address.setPincode(456);
//
//        student.setAddress(address);
//        address.setStudent(student);
//
//        session.persist(student);

        // Retrieve data

     TypedQuery query = session.createQuery("from Student");
     List<Student> list = query.getResultList();
     Iterator<Student> itr = list.iterator();
     while (itr.hasNext()) {
      Student student = itr.next();
      System.out.println(student.getId() + " " + student.getName());
      Address address = student.getAddress();
      System.out.println(address.getId() + " " + address.getAddressline() + " " + address.getCity() + " " + address.getState() + " " + address.getCountry() + " " + address.getPincode());
     }
        //transaction.commit();
        session.close();
        System.out.println("success");
    }
}
