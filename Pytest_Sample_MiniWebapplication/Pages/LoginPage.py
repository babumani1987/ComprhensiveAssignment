from selenium.webdriver.common.by import By

from Config.config import TestData
from Pages.BasePg import BasePg


class LoginPage(BasePg):
    CHECKBOX_LINK = (By.LINK_TEXT, "Checkboxes")

    def __init__(self, driver):
        # super.__init__(driver)
        self.driver = driver
        self.driver.get(TestData.Base_URL)

    def get_login_title(self, title):
        return self.get_title(title)

    def checkbox_link_exist(self):
        return self.is_visible(self.CHECKBOX_LINK)



