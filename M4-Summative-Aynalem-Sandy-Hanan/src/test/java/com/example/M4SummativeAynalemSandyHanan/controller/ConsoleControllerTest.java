//package com.example.M4SummativeAynalemSandyHanan.controller;
//
//import com.example.M4SummativeAynalemSandyHanan.model.Console;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.client.match.MockRestRequestMatchers;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.ResultMatcher;
//
//import static com.sun.javafx.fxml.expression.Expression.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@RunWith(SpringRunner.class)
//@WebMvcTest(com.example.M4SummativeAynalemSandyHanan.repository.ConsoleControllerTest.class)
//public class ConsoleControllerTest {
//
//
//
//        @Autowired
//        private MockMvc mockMvc;
//
//        // ObjectMapper used to convert Java objects to JSON and vice versa
//        private ObjectMapper mapper = new ObjectMapper();
//
//        @Before
//        public void setUp() {
//            // This is the standard set up method that runs before each test. It's typically used for instantiating test
//            // objects. We don't have to do anything special for mockMvc since it's Autowired. We will however be using
//            // setUp() in the future.
//        }
//
//
//                @Test
//        public void shouldReturnAConsoleByConsoleId() throws Exception {
//            Arrange
//            Console outputConsole = new Console();
//            outputConsole.setConsoleId(1);
//            outputConsole.setConsoleModel("Playstation 4");
//            outputConsole.setConsoleManufacturer("Sony");
//            outputConsole.setConsoleModel("PS4");
//            outputConsole.setConsoleMemory("8GB");
//            outputConsole.setConsoleProcessor("Dual Core");
//            outputConsole.setConsolePrice(299.99);
//            outputConsole.setConsoleQuantity(5);
//
//
//
//            String outputJson = mapper.writeValueAsString(outputConsole);
//            mockMvc.perform(get("/console/{consoleId}", 1))
//                    .andDo(print())
//                    .andExpect(status().isOk())
//                    .andExpect((ResultMatcher) MockRestRequestMatchers.content().json(outputJson));
//        }
//        @Test
//        public void shouldReturnAConsoleByConsoleModel() throws Exception {
//            //Arrange
//            Console outputConsole = new Console();
//            outputConsole.setConsoleModel("Playstation 4");
//            outputConsole.setConsoleManufacturer("Sony");
//            outputConsole.setConsoleModel("PS4");
//            outputConsole.setConsoleMemory("8GB");
//            outputConsole.setConsoleProcessor("Dual Core");
//            outputConsole.setConsolePrice(299.99);
//            outputConsole.setConsoleQuantity(5);
//
//
//
//            String outputJson = mapper.writeValueAsString(outputConsole);
//            mockMvc.perform(get("/console/{consoleModel}", "Playstation 4"))
//                    .andDo(print())
//                    .andExpect(status().isOk())
//                    .andExpect((ResultMatcher) MockRestRequestMatchers.content().json(outputJson));
//        }
//
//
//
//        @Test
//        public void shouldFindAllByConsoleManufacturer() throws Exception {
//            //Arrange
//            Console outputConsole = new Console();
//            outputConsole.setConsoleManufacturer("Sony");
//            outputConsole.setConsoleModel("PS4");
//            outputConsole.setConsoleMemory("8GB");
//            outputConsole.setConsoleProcessor("Dual Core");
//            outputConsole.setConsolePrice(299.99);
//            outputConsole.setConsoleQuantity(5);
//
//
//
//            String outputJson = mapper.writeValueAsString(outputConsole);
//            mockMvc.perform(get("/console/{consoleManufacturer}", "Sony"))
//                    .andDo(print())
//                    .andExpect(status().isOk())
//                    .andExpect((ResultMatcher) MockRestRequestMatchers.content().json(outputJson));
//
//        }
//        @Test
//        public void shouldFindAllByConsoleByPrice() throws Exception {
//            //Arrange
//            Console outputConsole = new Console();
//            outputConsole.setConsolePrice(299.99);
//            outputConsole.setConsoleModel("PS4");
//            outputConsole.setConsoleMemory("8GB");
//            outputConsole.setConsoleProcessor("Dual Core");
//            outputConsole.setConsolePrice(299.99);
//            outputConsole.setConsoleQuantity(5);
//
//
//
//            String outputJson = mapper.writeValueAsString(outputConsole);
//            mockMvc.perform(get("/console/{consolePrice}", "299.99"))
//                    .andDo(print())
//                    .andExpect(status().isOk())
//                    .andExpect((ResultMatcher) MockRestRequestMatchers.content().json(outputJson));
//
//        }
//
//    }
//
//
