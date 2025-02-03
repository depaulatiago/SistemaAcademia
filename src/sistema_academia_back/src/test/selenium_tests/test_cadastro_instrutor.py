from selenium import webdriver
from selenium.webdriver.common.by import By
import time

driver = webdriver.Chrome()

# Acessar a tela de cadastro
driver.get("http://localhost:8080/tela_adicionar_instrutor/index.html")  # Ajuste a URL
time.sleep(2)

# Preencher os campos obrigatórios
nome_input = driver.find_element(By.NAME, "nomeInstrutor")
idade_input = driver.find_element(By.NAME, "idadeInstrutor")
salario_input = driver.find_element(By.NAME, "salarioInstrutor")
botao_adicionar = driver.find_element(By.ID, "btnAdicionarInstrutor")

nome_input.send_keys("Carlos Silva")
idade_input.send_keys("35")
salario_input.send_keys("4500")
botao_adicionar.click()

time.sleep(2)

# Verificar se o cadastro foi bem-sucedido
try:
    driver.find_element(By.ID, "msgSucesso")  # Ajuste conforme necessário
    print("Teste de Cadastro de Instrutor: ✅ Aprovado")
    driver.save_screenshot("../screenshots/test_cadastro_instrutor_aprovado.png")
except:
    print("Teste de Cadastro de Instrutor: ❌ Reprovado")
    driver.save_screenshot("../screenshots/test_cadastro_instrutor_reprovado.png")

driver.quit()
