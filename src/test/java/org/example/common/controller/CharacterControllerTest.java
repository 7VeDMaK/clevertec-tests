package org.example.common.controller;

import org.example.controller.CharacterController;
import org.example.domain.Character;
import org.example.service.CharacterService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = CharacterController.class)
class CharacterControllerTest {

    @MockBean
    private CharacterService characterService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldFindAll() throws Exception {
        when(characterService.getCharacters())
                .thenReturn(List.of(new Character(), new Character(), new Character()));

        mockMvc.perform(get("/api/v1/cakes"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(3));
    }
}