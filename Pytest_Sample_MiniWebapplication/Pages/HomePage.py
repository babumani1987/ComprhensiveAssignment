from selenium.webdriver.common.by import By
from selenium.webdriver.remote.webelement import WebElement
from selenium.webdriver.support.wait import WebDriverWait

from Config.config import TestData
from Pages.BasePg import BasePg
from Tests.conftest import driver
from selenium.webdriver.support import expected_conditions as EC


class HomePage(BasePg):
    CHECKBOX_LINK = (By.LINK_TEXT, "Checkboxes")
    CHECKBOX1 = (By.XPATH, "/html/body/div[2]/div/div/form/input[1]")
    CHECKBOX2 = (By.XPATH, "/html/body/div[2]/div/div/form/input[2]")

    def __init__(self, driver):
        # super.__init__(driver)
        self.driver = driver
        self.driver.get(TestData.Base_URL)

    def click_checkbox(self):
        self.click_ele(self.CHECKBOX_LINK)

    def wait_home_checkbox(self):
        self.driver.implicitly_wait(5)
        new_url = self.driver.current_url
        self.driver.get(new_url)
        WebDriverWait(self.driver, 15)

    def is_checkbox1(self):
        self.is_selected(self.CHECKBOX1)

    def is_checkbox2(self):
        return self.is_selected(self.CHECKBOX2)
