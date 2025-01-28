package com.example.projetoEmakers.controller;

import com.example.projetoEmakers.data.entity.Instrutor;
import com.example.projetoEmakers.repository.InstrutorRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.AfterEach;

@WebMvcTest(InstrutorController.class)
class InstrutorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private InstrutorRepository instrutorRepository;

    @Autowired
    private ObjectMapper objectMapper;

    private Instrutor instrutor;

    // Selenium WebDriver
    private WebDriver driver;

    @BeforeEach
    void setUp() {
        instrutor = new Instrutor();
        instrutor.setIdInst(1L);
        instrutor.setNome("João");
        instrutor.setIdade(30);
        instrutor.setSalario(5000.0);

        // Inicializar o ChromeDriver para Selenium
        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");  // Substitua o caminho correto
        driver = new ChromeDriver();
    }

    @Test
    void testGetAllInstrutores() throws Exception {
        when(instrutorRepository.findAll()).thenReturn(Arrays.asList(instrutor));

        mockMvc.perform(get("/instrutor"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].nome").value("João"))
                .andExpect(jsonPath("$[0].idade").value(30))
                .andExpect(jsonPath("$[0].salario").value(5000.0));
    }

    // Novo teste Selenium para interação no navegador
    @Test
    void testInstrutorCriarComSelenium() {
        driver.get("http://localhost:8080/instrutor/novo"); // Altere para a URL correta do seu sistema

        // Preencher o formulário de cadastro de instrutor
        WebElement nomeField = driver.findElement(By.name("nome"));
        WebElement idadeField = driver.findElement(By.name("idade"));
        WebElement salarioField = driver.findElement(By.name("salario"));
        WebElement submitButton = driver.findElement(By.id("submitBtn"));  // Substitua pelo ID do seu botão

        nomeField.sendKeys("Carlos");
        idadeField.sendKeys("35");
        salarioField.sendKeys("6000");

        submitButton.click();

        // Espera até que a página de sucesso apareça
        WebElement sucessoMensagem = driver.findElement(By.id("sucessoMensagem"));  // Altere conforme necessário
        assertEquals("Instrutor criado com sucesso", sucessoMensagem.getText());

        // Fechar o navegador após o teste
        driver.quit();
    }

    @Test
    void testCreateInstrutor() throws Exception {
        when(instrutorRepository.save(any(Instrutor.class))).thenReturn(instrutor);

        mockMvc.perform(post("/instrutor")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(instrutor)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nome").value("João"))
                .andExpect(jsonPath("$.idade").value(30))
                .andExpect(jsonPath("$.salario").value(5000.0));
    }

    @Test
    void testGetInstrutorById_Success() throws Exception {
        when(instrutorRepository.findById(1L)).thenReturn(Optional.of(instrutor));

        mockMvc.perform(get("/instrutor/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nome").value("João"))
                .andExpect(jsonPath("$.idade").value(30))
                .andExpect(jsonPath("$.salario").value(5000.0));
    }

    // Outros testes do MockMvc permanecem iguais...

    @AfterEach
    void tearDown() {
        // Fechar o WebDriver após o teste
        if (driver != null) {
            driver.quit();
        }
    }
}
