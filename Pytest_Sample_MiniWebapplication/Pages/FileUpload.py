from selenium.webdriver.common.by import By
from selenium.webdriver.remote.webelement import WebElement
from selenium.webdriver.support.wait import WebDriverWait
from webdriver_manager.core.file_manager import File
import os
from selenium import webdriver
from Config.config import TestData
from Pages.BasePg import BasePg


class FileUpload(BasePg):
    FILEUPLOAD_LINK = (By.LINK_TEXT, "File Upload")
    FILE_CHOOSE = (By.ID, "//*[@id='file-upload']")
    File_INPUT = (By.CSS_SELECTOR, "input[type='file']")
    File_INPUT2 =(By.ID, "file-upload")
    UPLOAD_Button = (By.ID, "file-submit")
    # upload_file = os.path.abspath(os.path.join(os.path.dirname(__file__), ".." , TestData.FilePath))

    file_name_element = (By.ID, "uploaded-files")

    def click_fileuploadlink(self):
        self.click_ele(self.FILEUPLOAD_LINK)

    def click_choosefile(self):
        upload_file = os.path.abspath(
            "C:/Users/babu/PycharmProjects/Pytest_Sample_MiniWebapplication/Report/file1.txt")
        fileinp = self.driver.find_element(By.CSS_SELECTOR, "input[type='file']")
        fileinp.send_keys(upload_file)
        self.click_ele(self.UPLOAD_Button)


    def upload_data(self):
        file_name_element = self.driver.find_element(By.ID, "uploaded-files")
        file_name = file_name_element.text
        return file_name



