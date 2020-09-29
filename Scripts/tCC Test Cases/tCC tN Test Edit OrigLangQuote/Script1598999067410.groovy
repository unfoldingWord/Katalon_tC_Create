import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration

WebUI.callTestCase(findTestCase('tCC Components/tCC tN Open For Edit'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Page_tCC translationNotes/button_ViewColumns'))

WebUI.click(findTestObject('Page_tCC translationNotes/columns_OrigQuote'))

WebUI.click(findTestObject('Page_tCC translationNotes/btnX_CloseColumns'))

origQuote = WebUI.getText(findTestObject('Page_tCC translationNotes/text_OrigQuote-GL-rtc9'))

println('Original language quote is ' + origQuote)

String newOrigQuote = origQuote + ' abc'

println('Setting original language quote to ' + newOrigQuote)

WebUI.setText(findTestObject('Page_tCC translationNotes/text_OrigQuote-GL-rtc9'), newOrigQuote)

WebUI.clickOffset(findTestObject('Page_tCC translationNotes/text_OrigQuote-GL-rtc9'), 0, -20)

WebUI.click(findTestObject('Page_tCC translationNotes/button_SaveEnabled'))

WebUI.waitForElementNotPresent(findTestObject('Page_tCC translationNotes/button_SaveEnabled'), 10)

WebUI.verifyElementText(findTestObject('Page_tCC translationNotes/text_OrigQuote-GL-rtc9'), newOrigQuote)

WebUI.closeBrowser()

WebUI.callTestCase(findTestCase('tCC Components/tCC tN Open For Edit'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Page_tCC translationNotes/button_ViewColumns'))

WebUI.click(findTestObject('Page_tCC translationNotes/columns_OrigQuote'))

WebUI.clickOffset(findTestObject('Page_tCC translationNotes/columns_OrigQuote'), -30, 0)

origQuote2 = WebUI.getText(findTestObject('Page_tCC translationNotes/text_OrigQuote-GL-rtc9'))

println((((('At ' + GlobalVariable.url) + ' before was ') + origQuote) + ' and after is ') + origQuote2)

WebUI.verifyElementText(findTestObject('Page_tCC translationNotes/text_OrigQuote-GL-rtc9'), newOrigQuote)

WebUI.closeBrowser()

