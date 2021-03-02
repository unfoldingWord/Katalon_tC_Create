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
import groovy.io.FileType as FileType
import org.apache.commons.io.FileUtils as FileUtils
import java.awt.datatransfer.Clipboard as Clipboard
import java.awt.datatransfer.Transferable as Transferable
import java.awt.datatransfer.DataFlavor as DataFlavor
import java.awt.Toolkit as Toolkit
import java.awt.datatransfer.StringSelection as StringSelection
import org.openqa.selenium.Keys as Keys
import groovy.time.*
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.testobject.ConditionType

resource = ['unfoldingWord/en_obs-sn', 'content/', '01/', '01.md']

WebUI.callTestCase(findTestCase('tCC Components/tCC md Open For Edit'), [('$username') : '', ('$password') : '', ('resource') : resource], FailureHandling.STOP_ON_FAILURE)

header = "God’s Spirit"

WebUI.scrollToElement(findTestObject('Object Repository/Page_tC Create/header_mdParmed', [('header') : header]) ,1)

WebUI.click(findTestObject('Object Repository/Page_tC Create/header_mdParmed', [('header') : header]))

WebUI.delay(2)

WebUI.clickOffset(findTestObject('Page_tC Create/link_scripture_24_08'), 0, 0)

if ((!WebUI.verifyElementPresent(findTestObject('Page_tC Create/link_scripture_24_08'), 1, FailureHandling.OPTIONAL)) ||
	WebUI.verifyElementPresent(findTestObject('Page_tCC translationAcademy/h1_Page Not Found'), 1, FailureHandling.OPTIONAL)) {

	println('ERROR: Clicking on a scripture link in OBS-sn causes a 404 error')
	
	CustomKeywords.'unfoldingWord_Keywords.SendMessage.SendFailMessage'('Test failed because clicking on a scripture link to in OBS-sn causes a 404 error.')
} else {
	println('no errors')
	
}
