package by.htp.liblary.service;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by meco on 21.05.2016.
 */
public class ValidatorTest {
    @Test
    public void loginValidator() throws Exception {

        assertFalse(UserService.Validator.loginValidator("",""));

    }

}