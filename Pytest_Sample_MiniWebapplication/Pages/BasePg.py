# from selenium import webdriver
from selenium.webdriver import ActionChains
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC


class BasePg:

    def __init__(self, driver):
        self.driver = driver

    def get_title(self, title):
        WebDriverWait(self.driver, 30).until(EC.title_is(title))
        print("Title base", self.driver.title)
        return self.driver.title

    def click_ele(self, by_locator):
        element = WebDriverWait(self.driver, 40).until(EC.visibility_of_element_located(by_locator))
        element.click()

    def check_ele(self, by_locator):
        WebDriverWait(self.driver, 10).until(EC.visibility_of_element_located(by_locator))

    def is_visible(self, by_locator):
        element = WebDriverWait(self.driver, 20).until(EC.visibility_of_element_located(by_locator))
        return bool(element)

    def is_selected(self, by_locator):
        element = WebDriverWait(self.driver, 20).until(EC.visibility_of_element_located(by_locator))
        return bool(element)
'''
    def send_keys(self, by_locator):
        element = WebDriverWait(self.driver, 20).until(EC.visibility_of_element_located(by_locator))
        element.send_keys()
        '''




