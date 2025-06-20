package com.security.memory;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;

@SpringBootTest
public class MemoryApplicationTests {

    private static final Logger logger = LoggerFactory.getLogger(MemoryApplicationTests.class);

    @Test
    @WithMockUser(username = "admin", roles = {"ADMIN", "DEVELOPER", "USER"})
    public void testWithMockUser() {
        logger.info("Context loaded with mock user");
    }
}
