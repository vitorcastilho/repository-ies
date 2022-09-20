package com.ies.repositoryapi;

//import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.context.annotation.Import;
//import org.springframework.security.test.context.support.WithMockUser;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MvcResult;

//import com.ies.repository.config.security.SecurityConfig;
//import com.ies.repository.controller.AuthController;
//import com.ies.repository.controller.CourseController;
//import com.ies.repository.service.TokenService;
//
//@WebMvcTest({CourseController.class, AuthController.class})
//@Import({SecurityConfig.class, TokenService.class})
class CourseControllerTest {

//	@Autowired
//    MockMvc mvc;
//
//    @Test
//    void rootWhenUnauthenticatedThen401() throws Exception {
//        this.mvc.perform(get("/course"))
//                .andExpect(status().isUnauthorized());
//    }
//    
//    @Test
//    void rootWhenAuthenticatedThenSaysHelloUser() throws Exception {
//        MvcResult result = this.mvc.perform(post("/token")
//                        .with(httpBasic("32020004305", "senhaParaTeste")))
//                .andExpect(status().isOk())
//                .andReturn();
//
//        String token = result.getResponse().getContentAsString();
//
//        this.mvc.perform(get("/")
//                        .header("Authorization", "Bearer " + token))
//                .andExpect(content().string("Hello, IES repository!"));
//    }
//
//    @Test
//    @WithMockUser
//    public void rootWithMockUserStatusIsOK() throws Exception {
//        this.mvc.perform(get("/")).andExpect(status().isOk());
//    }

}
