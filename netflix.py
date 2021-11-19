from selenium import webdriver
from selenium.webdriver.chrome.service import Service
from webdriver_manager.chrome  import ChromeDriverManager
from selenium.webdriver.chrome.options import Options
from selenium.webdriver.common.by import By
import time
import pandas as pd
import datetime


options = Options()
options.add_experimental_option("detach", True)
driver = webdriver.Chrome(service=Service(ChromeDriverManager().install()), options=options)
url = 'https://www.netflix.com/latest' 
driver.get(url)

login_xpath = "/html/body/div[1]/div/div[3]/div/div/div[1]/form/button"
driver.find_element(By.NAME,"userLoginId").send_keys("studyhaza5@gmail.com")
time.sleep(2)
driver.find_element(By.NAME,"password").send_keys("qlsdb%ekdltmzl3")
time.sleep(2)
driver.find_element(By.XPATH,login_xpath).click()
time.sleep(5)

href = driver.find_element(By.TAG_NAME, "a")
href.click()
time.sleep(5)

least = driver.find_element(By.XPATH, "/html/body/div[1]/div/div/div[1]/div[1]/div[1]/div/div/ul/li[5]/a")
least.click()
time.sleep(5)

# 자료들 담을 리스트 준비
info_list = []
rate1_list = []
rate2_list = []
rate3_list = []
rate4_list = []
rate5_list = []
rate6_list = []
rate7_list = []
rate8_list = []
rate9_list = []
rate10_list = []


#1위
rating1 = driver.find_element(By.CSS_SELECTOR, "#title-card-1-0 > div.ptrack-content > a > div.boxart-size-7x10.boxart-container.boxart-rounded > svg > use")
rate_num1 = rating1.get_attribute("xlink:href")

rate1 = driver.find_element(By.XPATH, "//*[@id='title-card-1-0']/div[1]/a")
title_rate1 = rate1.get_attribute("aria-label")

rate1_img = driver.find_element(By.CSS_SELECTOR, ".boxart-image-in-padded-container")
rate1_src = rate1_img.get_attribute("src")

rate1_list.append(rate_num1)
rate1_list.append(title_rate1)
rate1_list.append(rate1_src)

#2위
rating2 = driver.find_element(By.CSS_SELECTOR, "#title-card-1-1 > div.ptrack-content > a > div.boxart-size-7x10.boxart-container.boxart-rounded > svg > use")
rate_num2 = rating2.get_attribute("xlink:href")

rate2 = driver.find_element(By.XPATH, "//*[@id='title-card-1-1']/div[1]/a")
title_rate2 = rate2.get_attribute("aria-label")

rate2_img = driver.find_element(By.CSS_SELECTOR, ".boxart-image-in-padded-container")
rate2_src = rate2_img.get_attribute("src")

rate2_list.append(rate_num2)
rate2_list.append(title_rate2)
rate2_list.append(rate2_src)

#3위
rating3 = driver.find_element(By.CSS_SELECTOR, "#title-card-1-2 > div.ptrack-content > a > div.boxart-size-7x10.boxart-container.boxart-rounded > svg > use")
rate_num3 = rating3.get_attribute("xlink:href")

rate3 = driver.find_element(By.XPATH, "//*[@id='title-card-1-2']/div[1]/a")
title_rate3 = rate3.get_attribute("aria-label")

rate3_img = driver.find_element(By.CSS_SELECTOR, ".boxart-image-in-padded-container")
rate3_src = rate3_img.get_attribute("src")

rate3_list.append(rate_num3)
rate3_list.append(title_rate3)
rate3_list.append(rate3_src)

#4위
rating4 = driver.find_element(By.CSS_SELECTOR, "#title-card-1-3 > div.ptrack-content > a > div.boxart-size-7x10.boxart-container.boxart-rounded > svg > use")
rate_num4 = rating4.get_attribute("xlink:href")

rate4 = driver.find_element(By.XPATH, "//*[@id='title-card-1-3']/div[1]/a")
title_rate4 = rate4.get_attribute("aria-label")

rate4_img = driver.find_element(By.CSS_SELECTOR, ".boxart-image-in-padded-container")
rate4_src = rate4_img.get_attribute("src")

rate4_list.append(rate_num4)
rate4_list.append(title_rate4)
rate4_list.append(rate4_src)

#5위
rating5 = driver.find_element(By.CSS_SELECTOR, "#title-card-1-4 > div.ptrack-content > a > div.boxart-size-7x10.boxart-container.boxart-rounded > svg > use")
rate_num5 = rating5.get_attribute("xlink:href")

rate5 = driver.find_element(By.XPATH, "//*[@id='title-card-1-4']/div[1]/a")
title_rate5 = rate5.get_attribute("aria-label")

rate5_img = driver.find_element(By.CSS_SELECTOR, ".boxart-image-in-padded-container")
rate5_src = rate5_img.get_attribute("src")

rate5_list.append(rate_num5)
rate5_list.append(title_rate5)
rate5_list.append(rate5_src)

#6위
rating6 = driver.find_element(By.CSS_SELECTOR, "#title-card-1-5 > div.ptrack-content > a > div.boxart-size-7x10.boxart-container.boxart-rounded > svg > use")
rate_num6 = rating6.get_attribute("xlink:href")

rate6 = driver.find_element(By.XPATH, "//*[@id='title-card-1-5']/div[1]/a")
title_rate6 = rate6.get_attribute("aria-label")

rate6_img = driver.find_element(By.CSS_SELECTOR, ".boxart-image-in-padded-container")
rate6_src = rate6_img.get_attribute("src")

rate6_list.append(rate_num6)
rate6_list.append(title_rate6)
rate6_list.append(rate6_src)

#7위
rating7 = driver.find_element(By.CSS_SELECTOR, "#title-card-1-6 > div.ptrack-content > a > div.boxart-size-7x10.boxart-container.boxart-rounded > svg > use")
rate_num7 = rating7.get_attribute("xlink:href")

rate7 = driver.find_element(By.XPATH, "//*[@id='title-card-1-6']/div[1]/a")
title_rate7 = rate7.get_attribute("aria-label")

rate7_img = driver.find_element(By.CSS_SELECTOR, ".boxart-image-in-padded-container")
rate7_src = rate7_img.get_attribute("src")

rate7_list.append(rate_num7)
rate7_list.append(title_rate7)
rate7_list.append(rate7_src)

#8위
rating8 = driver.find_element(By.CSS_SELECTOR, "#title-card-1-7 > div.ptrack-content > a > div.boxart-size-7x10.boxart-container.boxart-rounded > svg > use")
rate_num8 = rating8.get_attribute("xlink:href")

rate8 = driver.find_element(By.XPATH, "//*[@id='title-card-1-7']/div[1]/a")
title_rate8 = rate8.get_attribute("aria-label")

rate8_img = driver.find_element(By.CSS_SELECTOR, ".boxart-image-in-padded-container")
rate8_src = rate8_img.get_attribute("src")

rate8_list.append(rate_num8)
rate8_list.append(title_rate8)
rate8_list.append(rate8_src)


hidden = driver.find_element(By.CSS_SELECTOR, "#row-1 > div > div > div > span > b")
driver.execute_script("arguments[0].click();", hidden)
time.sleep(5)
driver.execute_script("arguments[0].click();", hidden)
time.sleep(5)

#9위
rating9 = driver.find_element(By.CSS_SELECTOR, "#title-card-1-8 > div.ptrack-content > a > div.boxart-size-7x10.boxart-container.boxart-rounded > svg > use")
rate_num9 = rating9.get_attribute("xlink:href")

rate9 = driver.find_element(By.XPATH, "//*[@id='title-card-1-8']/div[1]/a")
title_rate9 = rate9.get_attribute("aria-label")

rate9_img = driver.find_element(By.CSS_SELECTOR, ".boxart-image-in-padded-container")
rate9_src = rate9_img.get_attribute("src")

rate9_list.append(rate_num9)
rate9_list.append(title_rate9)
rate9_list.append(rate9_src)

#10위
rating10 = driver.find_element(By.CSS_SELECTOR, "#title-card-1-9 > div.ptrack-content > a > div.boxart-size-7x10.boxart-container.boxart-rounded > svg > use")
rate_num10 = rating10.get_attribute("xlink:href")

rate10 = driver.find_element(By.XPATH, "//*[@id='title-card-1-9']/div[1]/a")
title_rate10 = rate10.get_attribute("aria-label")

rate10_img = driver.find_element(By.CSS_SELECTOR, ".boxart-image-in-padded-container")
rate10_src = rate10_img.get_attribute("src")

rate10_list.append(rate_num10)
rate10_list.append(title_rate10)
rate10_list.append(rate10_src)

#리스트들 취합
info_list.append(rate1_list)
info_list.append(rate2_list)
info_list.append(rate3_list)
info_list.append(rate4_list)
info_list.append(rate5_list)
info_list.append(rate6_list)
info_list.append(rate7_list)
info_list.append(rate8_list)
info_list.append(rate9_list)
info_list.append(rate10_list)

#오늘 날짜 가져오기
now = datetime.datetime.now().date()
today_split = str(now).split("-")
today = today_split[1]+today_split[2]

#데이터 csv 파일로 저장
data = pd.DataFrame(info_list)
data.columns = ["rate", "title", "img_link"]

data.to_csv(today+"_netflix.csv", encoding="cp949", index=None)

driver.close()



