package org.orakris;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

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

        Transaction transaction = session.beginTransaction();

        // Store data
        Student student = new Student();
        student.setName("abcd");

        Address address = new Address();
        address.setAddressline("line1");
        address.setCity("hyderabad");
        address.setCountry("india");
        address.setState("hyderabad");
        address.setPincode(456);

        student.setAddress(address);
        address.setStudent(student);

        session.persist(student);

        transaction.commit();
        session.close();
        System.out.println("success");
    }
}
