/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.ejb.Stateless;
import javax.faces.bean.RequestScoped;
import model.DAO.PersonDAO;

/**
 *
 * @author Semir
 */
@RequestScoped
@Stateless
public class Controller {

    PersonDAO persondao = new PersonDAO();

    public Controller() {

    }

    public void addPerson(String firstname, String surname, String username, String password, String email, String ssn) {
        persondao.addPerson(firstname, surname, username, password, email, ssn);
    }

}
