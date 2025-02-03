from selenium import webdriver
from selenium.webdriver.chrome.service import Service
from selenium.webdriver.chrome.options import Options
import time

# Configurar o Selenium para usar Chromium
chrome_options = Options()
chrome_options.binary_location = "/usr/bin/chromium-browser"  # Caminho do Chromium
chrome_options.add_argument("--headless")  # Rodar sem interface gráfica
chrome_options.add_argument("--no-sandbox")
chrome_options.add_argument("--disable-dev-shm-usage")

# Configurar o ChromeDriver
service = Service("/usr/local/bin/chromedriver")  # Caminho do ChromeDriver
driver = webdriver.Chrome(service=service, options=chrome_options)

# Teste: Acessar Google e capturar tela
driver.get("https://www.google.com")
time.sleep(2)

# Capturar tela do teste
driver.save_screenshot("test_chromium.png")

# Fechar navegador
driver.quit()
