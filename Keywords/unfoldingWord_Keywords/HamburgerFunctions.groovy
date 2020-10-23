package unfoldingWord_Keywords

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil

import internal.GlobalVariable


public class HamburgerFunctions {
	@Keyword
	// Call with CustomKeywords.'unfoldingWord_Keywords.HamburgerFunctions.toggleAllScripture'(parm) where parm in('on','off,'test')
	// If parm = 'test', returns 'on' or 'off'
	def toggleAllScripture(toState) {
		def newState = toState.toLowerCase()
		def myState = ''
		def drawerOpen = WebUI.waitForElementPresent(findTestObject('Page_tC Create/button_DrawerClose'), 1)
		if (!drawerOpen) {
			WebUI.click(findTestObject('Page_tC Create/button_DrawerOpen'))
		}
		WebUI.delay(1)
		def state = WebUI.verifyElementChecked(findTestObject('Page_tC Create/input_Expand all Scripture'), 2,FailureHandling.OPTIONAL)
		if (state) {
			myState = 'on'
		} else {
			myState = 'off'
		}
		println('Expand all Scripture switch is ' + myState)
		if (newState != 'test') {
			if (myState != newState) {
				println('Toggling scripture pane ' + newState)
				WebUI.click(findTestObject('Page_tC Create/input_Expand all Scripture'))
				WebUI.delay(1)
			}
		} else {
			return myState
		}
		if (!drawerOpen) {
			WebUI.click(findTestObject('Page_tC Create/button_DrawerClose'))
			WebUI.waitForElementVisible(findTestObject('Page_tC Create/button_DrawerOpen'), 5)
		}
	}

	@Keyword
	def chooseFile(name) {
		def drawerOpen = WebUI.waitForElementPresent(findTestObject('Page_tC Create/button_DrawerClose'), 1, FailureHandling.OPTIONAL)
		if (!drawerOpen) {
			WebUI.click(findTestObject('Page_tC Create/button_DrawerOpen'))
		}
		WebUI.delay(2)
		WebUI.click(findTestObject('Page_tC Create/file_Parmed', [('fileName') : name]))
//		WebUI.click(findTestObject('Page_tC Create/file_Parmed'))
		
		if (!drawerOpen) {
			WebUI.click(findTestObject('Page_tC Create/button_DrawerClose'))
			WebUI.waitForElementVisible(findTestObject('Page_tC Create/button_DrawerOpen'), 5)
		}
	}

}