package com.codeup.springblog.services;

import com.codeup.springblog.Services.EmailService;
import com.codeup.springblog.Services.SillySvc;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.Assert.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class UserDetailsLoaderTest {

        private SillySvc sillySvc;

        @Before
        public void setUp() {
            sillySvc = new SillySvc();
                }

        @Test
        public void twoIsTwo() {
            assertEquals(2, 2);
        }

        @Test
        public void svcNotNUll() {
            assertNotNull(sillySvc);
        }

}

