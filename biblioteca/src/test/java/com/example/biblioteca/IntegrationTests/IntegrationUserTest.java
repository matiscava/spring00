package com.example.biblioteca.IntegrationTests;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static net.bytebuddy.matcher.ElementMatchers.is;

@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationUserTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testFindAllUsersOk() throws Exception {
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/user/getAll"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.status().is(500))
//                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andReturn();
    }

    @Test
    public void testFindByIdParamOk() throws Exception {
        String expectedJson = "{\"name\":\"Jorge\",\"lastname\":\"Corona\",\"dni\":4126987,\"address\":\"Calle 234\",\"age\":32,\"phone\":114897652,\"email\":\"jorgecorona@mail.com\",\"password\":\"jorge123\",\"maxBook\":2,\"tickets\"}";

        MvcResult mvcResult = this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/user")
                        .param("id","0")
        )
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.status().is(500))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").exists())
                .andReturn();

        String actualJson = mvcResult.getResponse().getContentAsString();

        Assert.assertEquals(actualJson,expectedJson);
    }
}
