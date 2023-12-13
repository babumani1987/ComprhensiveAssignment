import pytest
from selenium import webdriver
from selenium.webdriver.common.by import By

from Config.config import TestData
from Pages.HomePage import HomePage
from Tests.Test_Base import Test_Base
from Tests.conftest import driver


class TestHomePage(Test_Base):

    def test_home_checkbox(self):
        self.homepage = HomePage(self.driver)
        self.homepage.click_checkbox()
        self.homepage.wait_home_checkbox()
        # Validating Checkbox1 is not checked
        assert not self.homepage.is_checkbox1(), "Checkbox 1 is not checked"
        # Validating Checkbox2 is checked
        assert self.homepage.is_checkbox2(), "Checkbox 2 is checked"

        # assert not self.homepage.is_selected(self.homepage.CHECKBOX1), "Checkbox should be not checked"
        # assert self.homepage.is_selected(self.homepage.CHECKBOX2), "Checkbox should checked"

