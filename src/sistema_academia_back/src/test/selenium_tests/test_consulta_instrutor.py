from selenium import webdriver
from selenium.webdriver.common.by import By
import time

# Configuração do WebDriver
driver = webdriver.Chrome()

# Acessar a página de instrutores
driver.get("http://localhost:8080/tela_instrutores/index.html")  # Ajuste a URL
time.sleep(2)

# Buscar instrutor pelo nome
campo_busca = driver.find_element(By.NAME, "buscaInstrutor")
campo_busca.send_keys("Carlos Silva")

time.sleep(2)

# Verificar se o resultado foi exibido
try:
    driver.find_element(By.CLASS_NAME, "instrutorNome")  # Ajuste conforme necessário
    print("Teste de Consulta de Instrutor: ✅ Aprovado")
    driver.save_screenshot("../screenshots/test_consulta_instrutor_aprovado.png")
except:
    print("Teste de Consulta de Instrutor: ❌ Reprovado")
    driver.save_screenshot("../screenshots/test_consulta_instrutor_reprovado.png")

driver.quit()
