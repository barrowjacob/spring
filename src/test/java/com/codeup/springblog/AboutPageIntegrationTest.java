package com.codeup.springblog;

//because integration, use these additional annotations:

import com.codeup.springblog.Models.User;
import com.codeup.springblog.Repositories.userRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javax.servlet.http.HttpSession;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringblogApplication.class)
@AutoConfigureMockMvc
public class AboutPageIntegrationTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void twoIsTwo() {
        assertEquals(2, 2);
    }

    @Test
    public void testMvcNotNull() {
        assertNotNull(mvc);
    }
    @Test
    public void testAboutPage() throws Exception {
        mvc.perform(get("/about").session((MockHttpSession) session))
        .andExpect(status().isOk())
        .andExpect(view().name("about"))
        .andExpect(content().string(containsString("About Page")));
    }

    @Autowired
    private userRepository userDao;

    @Autowired
    private PasswordEncoder pen;

    private User testUser;

    private HttpSession session;

    @Before
    public void setUp() throws Exception {
        testUser = userDao.findByUsername("testUser");
        if (testUser == null) {
            User user = new User();
            user.setUsername("testUser");
            user.setEmail("test@email.com");
            user.setPassword(pen.encode("password"));
            testUser = userDao.save(user);
        }

        session = mvc.perform(
                post("/login").with(csrf())
                        .param("username", testUser.getUsername())
                        .param("password", testUser.getPassword()))
            .andExpect(status().isFound())
            .andReturn()
            .getRequest()
            .getSession();
    }
    @Test
    public void sessionIsValid() {
        assertNotNull(session);
    }

    @After
    public void cleanUp() {
        userDao.delete(testUser);
    }

}
