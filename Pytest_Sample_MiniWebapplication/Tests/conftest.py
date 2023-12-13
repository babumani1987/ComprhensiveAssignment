import pytest
from selenium import webdriver
from selenium.webdriver.chrome.options import Options
from webdriver_manager.chrome import ChromeDriverManager


@pytest.fixture(params=["chrome"], scope="class")
def driver(request):
    option = webdriver.ChromeOptions()
    web_driver = webdriver.Chrome(options=option)
    #web_driver = webdriver.Chrome(ChromeDriverManager().install())
    request.cls.driver = web_driver
    #web_driver.implicitly_wait(10)
    yield
    web_driver.close()
