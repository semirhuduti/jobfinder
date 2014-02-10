/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.Person;
import model.Role;

/**
 *
 * @author Semir
 */
public class PersonDAO {

    @PersistenceContext(unitName = "JobFinderPU")
    private EntityManager em;
    Person person;

    public PersonDAO(){
        person = new Person();
    }
    
    
    
    public void addPerson(String firstname, String surname, String username, String password, String email, String ssn) throws InterruptedException {
        this.person = new Person();
        person.setName(firstname);
        person.setSurname(surname);
        person.setUsername(username);
        person.setPassword(password);
        person.setEmail(email);
        person.setSsn(ssn);
        person.setPersonId((long) 1);

        Role role = new Role();
        role.setName("asdasdsad");
        role.setRoleId((long) 23);

        person.setRoleId(role);

        System.out.println("Person name" + person.getName() + person.getSurname() + "Username" + person.getUsername());
        System.out.println("SSN " + person.getSsn());
        System.out.println("E-mail " + person.getEmail());
        System.out.println("Role " + person.getRoleId().getName() + " " + person.getRoleId().getRoleId());
        System.out.println("Password" + person.getPassword());
        System.out.println("e" + em.getClass());
        
        Thread.sleep(2000);
        
        em.persist(person);
    }
    

}
