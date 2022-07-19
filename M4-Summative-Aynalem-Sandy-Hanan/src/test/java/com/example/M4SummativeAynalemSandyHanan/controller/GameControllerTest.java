//package com.example.M4SummativeAynalemSandyHanan.controller;

//@RunWith(SpringRunner.class)
//@WebMvcTest(M4SummativeAynalemSandyHananApplication.class)
//public class GameControllerTest
//{


//    @Autowired
//    private MockMvc mockMvc;
//
//    private ObjectMapper mapper = new ObjectMapper();
//
//    @Test
//    public void shouldReturnGamesByStudio() throws Exception {
//        //Arrange
//        Game outputGame = new Game();
//        outputGame.setGameId(1);
//        outputGame.setTitle("Test Game");
//        outputGame.setEsrbRating("m");
//        outputGame.setDescription("Test Description");
//        outputGame.setPrice(29.99);
//        outputGame.setStudio("Test Studio");
//        outputGame.setQuantity(1);
//
//
//        String outputJson = mapper.writeValueAsString(outputGame);
//        mockMvc.perform(get("/games/studio/{studio}", "Test Studio"))
//                .andDo(print())
//                .andExpect(status().isOk())
//                .andExpect((ResultMatcher) content().json(outputJson));
//    }
//    @Test
//    public void shouldReturnGamesByTitle() throws Exception {
//        //Arrange
//        Game outputGame = new Game();
//        outputGame.setGameId(1);
//        outputGame.setTitle("Test Game");
//        outputGame.setEsrbRating("m");
//        outputGame.setDescription("Test Description");
//        outputGame.setPrice(29.99);
//        outputGame.setStudio("Test Studio");
//        outputGame.setQuantity(1);
//
//
//        String outputJson = mapper.writeValueAsString(outputGame);
//        mockMvc.perform(get("/games/title/{title}", "Test Game"))
//                .andDo(print())
//                .andExpect(status().isOk())
//                .andExpect((ResultMatcher) content().json(outputJson));
//    }
//    @Test
//    public void shouldReturnGamesByEsrbRating() throws Exception {
//        //Arrange
//        Game outputGame = new Game();
//        outputGame.setGameId(1);
//        outputGame.setTitle("Test Game");
//        outputGame.setEsrbRating("m");
//        outputGame.setDescription("Test Description");
//        outputGame.setPrice(29.99);
//        outputGame.setStudio("Test Studio");
//        outputGame.setQuantity(1);
//
//
//        String outputJson = mapper.writeValueAsString(outputGame);
//        mockMvc.perform(get("/games/esrbRating/{esrbRating}", "T"))
//                .andDo(print())
//                .andExpect(status().isOk())
//                .andExpect((ResultMatcher) content().json(outputJson));
//    }
//}


