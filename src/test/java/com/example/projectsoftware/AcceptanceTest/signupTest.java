package com.example.projectsoftware.AcceptanceTest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.example.projectsoftware.signup;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class signupTest {
  @Test
    public void testIdValidation() {
    
        assertTrue(signup.idTest("123456789"));

        assertFalse(signup.idTest("12345678"));

      
        assertFalse(signup.idTest("1234567890"));
    }

    @Test
    public void testNameValidation() {
   
        assertTrue(signup.nameTest("John Doe"));

        assertFalse(signup.nameTest(""));

        assertFalse(signup.nameTest("John@Doe"));
    }

    @Test
    public void testEmailValidation() {
        
        assertTrue(signup.gmailTest("john.doe@example.com"));

     
        assertFalse(signup.gmailTest("johndoe.example.com"));

        assertFalse(signup.gmailTest("john.doe@example"));
    }

    @Test
    public void testPasswordValidation() {
       
        assertTrue(signup.passwordTest("StrongPassword123"));

        // Test invalid password (less than 8 characters)
        assertFalse(signup.passwordTest("Pass123"));

 
        assertFalse(signup.passwordTest("weakpassword123"));

   
        assertFalse(signup.passwordTest("WEAKPASSWORD123"));

        assertFalse(signup.passwordTest("WeakPassword"));
    }

    @Test
    public void testRegisterWithExistingEmail() {
     
        assertTrue(signup.registerWithExistingEmail("existing.user@example.com"));


        assertFalse(signup.registerWithExistingEmail("new.user@example.com"));
    }
}
