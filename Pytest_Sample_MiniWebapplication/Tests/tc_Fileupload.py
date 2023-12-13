import pytest
from selenium import webdriver
from selenium.webdriver.common.by import By

from Config.config import TestData
from Pages.FileUpload import FileUpload
from Pages.HomePage import HomePage
from Pages.LoginPage import LoginPage
from Tests.Test_Base import Test_Base
from Tests.conftest import driver


class TestFileUpload(Test_Base):

    def test_file_upload(self):
        self.loginpg = LoginPage(self.driver)
        self.homepg = HomePage(self.driver)
        self.homepg.click_checkbox()
        self.homepg.wait_home_checkbox()
        self.driver.back()
        title = self.loginpg.get_title(TestData.Login_PG_TITLE)
        assert title == TestData.Login_PG_TITLE
        self.fileupload1 = FileUpload(self.driver)
        self.fileupload1.click_fileuploadlink()
        self.fileupload1.click_choosefile()
        #file_nme = self.fileupload1.upload_data()
        #assert file_nme == TestData.FILENAME






