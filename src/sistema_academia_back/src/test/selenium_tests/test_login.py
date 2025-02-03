from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys
import time

# Configuração do WebDriver
driver = webdriver.Chrome()

# Acessar a página de login
driver.get("http://localhost:5500/src/sistema_academia_front/tela_login/index.html")  # Ajuste a URL
time.sleep(2)

# Preencher credenciais
email_input = driver.find_element(By.NAME, "email")
senha_input = driver.find_element(By.NAME, "senha")
botao_login = driver.find_element(By.ID, "btnLogin")

email_input.send_keys("admin@academia.com")
senha_input.send_keys("Senha123!")
botao_login.click()

time.sleep(2)

# Verificar se o login foi bem-sucedido
try:
    driver.find_element(By.ID, "dashboard")  # Ajuste conforme a página real
    print("Teste de Login: ✅ Aprovado")
    driver.save_screenshot("../screenshots/test_login_aprovado.png")
except:
    print("Teste de Login: ❌ Reprovado")
    driver.save_screenshot("../screenshots/test_login_reprovado.png")

# Fechar navegador
driver.quit()
