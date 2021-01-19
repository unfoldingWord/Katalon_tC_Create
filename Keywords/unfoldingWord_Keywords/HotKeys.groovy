package unfoldingWord_Keywords
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords

import internal.GlobalVariable

import MobileBuiltInKeywords as Mobile
import WSBuiltInKeywords as WS
import WebUiBuiltInKeywords as WebUI

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException

import org.openqa.selenium.Keys as Keys

class HotKeys {
	/**
	 * Refresh browser
	 */
	@Keyword
	def sendKeys(element,keyString) {
		if (GlobalVariable.browser == '' || GlobalVariable.browser == null) {
			GlobalVariable.browser = GetTestingConfig.getBrowserAndVersion()
		}

		if (element == 'null') {
			element = null
		}

		keyString = keyString.replace(' ','')
		keyString = keyString.replace("'",'"')

		if (GlobalVariable.systemOS.contains('Windows')) {
			def l1 = keyString.indexOf('"')
			def l2 = keyString.indexOf('"', l1)
			def chars = keyString.substring(l1+1, l2)
			keyString = Keys.chord(Keys.CONTROL,chars)
		} else {
			if (keyString.contains('Keys.CONTROL,"c"') || keyString.contains('Keys.COMMAND,"c"')) {
				if (GlobalVariable.browser.contains('firefox')) {
					println('firefox')
					keyString = Keys.chord(Keys.COMMAND, 'c')
				} else {
					println('Chrome')
					keyString = Keys.chord(Keys.CONTROL, Keys.INSERT)
				}
			} else if (keyString.contains('Keys.CONTROL,"v"') || keyString.contains('Keys.COMMAND,"v"')) {
				if (GlobalVariable.browser.contains('firefox')) {
					println('firefox')
					keyString = Keys.chord(Keys.COMMAND, 'v')
				} else {
					println('Chrome')
					keyString = Keys.chord(Keys.SHIFT, Keys.INSERT)
				}
			}
		}
		WebUI.sendKeys(element, keyString)
	}

	@Keyword
	def sendKeys2() {
		WebUI.sendKeys(null, Keys.chord(Keys.CONTROL, Keys.INSERT))
	}
}