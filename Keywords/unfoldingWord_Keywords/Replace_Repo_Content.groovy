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

// THIS IS UNDER CONSTRUCTION. HOPING THAT UPDATING THE CONTENT IN PRODCUTION WILL ELIMINATE THE NEED FOR THIS, AT LEAST FOR NOW
public class Replace_Repo_Content {
	@Keyword
	def replaceContent(repo,content) {
		println('The repo is ' + repo)
		println('The content is ' + content)
		if (1 == 2) {
			//// MODIFY THIS CODE TO TEST FOR EXISTSING OPEN BROWSER AND OPEN AND USE A NEW SESSION IF SO
			try {
				WebUI.refresh()
				browser = true
			} catch (Exception e) {
				browser = false
			}
		}
		WebUI.openBrowser(repo)
		if (WebUI.verifyElementPresent(findTestObject('Page_Git Repo/icon_UserSignIn'), 1)) {
			WebUI.click(findTestObject('Page_Git Repo/icon_UserSignIn'))
			WebUI.setText(findTestObject('Page_Git Repo/input_Username'), GlobalVariable.user1Name)
			WebUI.setText(findTestObject('Page_Git Repo/input_Password'), GlobalVariable.user1Password)
			WebUI.click(findTestObject('Page_Git Repo/button_SignIn'))
		}
		WebUI.click(findTestObject('Page_Git Repo/icon_Edit'))
		WebUI.click(findTestObject('Page_Git Repo/span_ProjectTextHeader'))
		WebUI.delay(2)
		WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.CONTROL, 'a'))

	}
}