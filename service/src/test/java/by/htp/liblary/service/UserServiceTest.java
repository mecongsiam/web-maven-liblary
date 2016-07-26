package by.htp.liblary.service;

import by.htp.liblary.dao.DBBookOperationDAO;

import by.htp.liblary.entity.Book;

import by.htp.liblary.service.exception.ServiceException;
import org.junit.Before;


import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by meco on 20.05.2016.
 */
public class UserServiceTest {


    @org.junit.Test
    public void regUser() throws Exception {
        //TODO

    }

    @org.junit.Test
    public void showUsersNotNull() throws Exception {
        //assertNotNull(UserService.showUsers());

    }
    @org.junit.Test
    public void showUsers() throws Exception{
        //assertEquals(new ArrayList<Abonement>().getClass(),UserService.showUsers().getClass());

    };

    @org.junit.Test
    public void showBooks() throws Exception {
       // assertEquals(new ArrayList<Book>().getClass(),UserService.showBooks().getClass());

    }

    @org.junit.Test
    public void regLoginValidator() throws Exception {
        assertFalse(UserService.regLoginValidator(""));

    }

    @org.junit.Test
    public void regPasswordValidator() throws Exception {
        assertFalse(UserService.regPasswordValidator(""));

    }

    @org.junit.Test
    public void reqNameValidator() throws Exception {
        assertFalse(UserService.reqNameValidator(""));

    }

    @org.junit.Test
    public void reqSurnameValidator() throws Exception {
        assertFalse(UserService.reqSurnameValidator(""));
    }

    @org.junit.Test
    public void reqEmailValidator() throws Exception {
        assertFalse(UserService.reqEmailValidator(""));
    }

    @org.junit.Test
    public void reqAdressValidator() throws Exception {
        assertFalse(UserService.reqAdressValidator(""));
    }

    @org.junit.Test
    public void reqPhoneValidator() throws Exception {
        assertFalse(UserService.reqPhoneValidator(""));
    }


    @org.junit.Test
    public void reqRoleValidator() throws Exception {
        assertFalse(UserService.reqRoleValidator(""));
    }

    @org.junit.Test
    public void reqLoginDualityValidator() throws Exception {
       // assertFalse(UserService.reqLoginDualityValidator("admin"));
        //in this case admin exist

    }

    @org.junit.Test
    public void regEmailDualityValidatoe() throws Exception {
       // assertFalse(UserService.regEmailDualityValidatoe("pup@gmail.com"));

    }

}