package com.example.config.server;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.assertj.MockMvcTester;
import org.springframework.test.web.servlet.assertj.MvcTestResult;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(properties = {"spring.config.name=configserver"})
@AutoConfigureMockMvc
class ConfigServerTests {

    @Autowired
    private MockMvcTester mvc;

    @Test
    void decryptsPlainTextResource() {
        MvcTestResult result = mvc.get().uri("/{name}/{profile}/{path}?useDefaultLabel", "application", "dev", "application-dev.properties")
                .accept(MediaType.TEXT_PLAIN)
                .exchange();

        assertThat(result).hasStatusOk();

        assertThat(result).bodyText().doesNotContain("{cipher}")
                .isEqualToIgnoringWhitespace("foo=bar");
    }

}
