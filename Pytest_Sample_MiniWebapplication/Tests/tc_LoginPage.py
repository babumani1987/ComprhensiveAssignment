import pytest
from selenium import webdriver

from Config.config import TestData
from Pages.LoginPage import LoginPage
from Tests.Test_Base import Test_Base


class TestLoginPage(Test_Base):

    def test_login_page_title(self):
        self.loginpage = LoginPage(self.driver)
        title = self.loginpage.get_title(TestData.Login_PG_TITLE)
        assert title == TestData.Login_PG_TITLE

    def test_login_page(self):
        self.loginpage = LoginPage(self.driver)
        flag = self.loginpage.checkbox_link_exist()
        assert flag

    def test_login_checkbox(self):
        self.loginpage = LoginPage(self.driver)
        self.loginpage.click_checkbox()
