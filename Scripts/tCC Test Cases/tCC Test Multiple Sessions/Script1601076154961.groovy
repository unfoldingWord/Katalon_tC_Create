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
import org.openqa.selenium.Keys as Keys

system = CustomKeywords.'unfoldingWord_Keywords.GetTestingConfig.getOperatingSystem'()

// Open Titus tN for editing
WebUI.callTestCase(findTestCase('tCC Components/tCC tN Open For Edit'), [:], FailureHandling.STOP_ON_FAILURE)

myBrowser = CustomKeywords.'unfoldingWord_Keywords.GetTestingConfig.getBrowserAndVersion'()

if (!system.contains('Mac') || myBrowser.contains('chrome')) {

	// Open a second browser tab
	if (myBrowser.contains('chrome')) {
	    WebUI.executeJavaScript('window.open();', [])
	} else if (system.contains('Windows')) {
	    WebUI.sendKeys(findTestObject('Page_tCC translationNotes/tNText_GLOutlinePoint1'), Keys.chord(Keys.CONTROL, 't'))
	}
	currentWindow = WebUI.getWindowIndex()
	
	//Go to new tab
	WebUI.switchToWindowIndex(currentWindow + 1)
	
	// Navigate to tCC
	WebUI.navigateToUrl('https://create.translationcore.com')
	
	//Prevent the login script from opening a browser thereby closing the open ones
	GlobalVariable.openBrowser = false
	
	//Login to second session
	WebUI.callTestCase(findTestCase('tCC Components/tCC Login'), [('user') : $username, ('password') : $password], FailureHandling.STOP_ON_FAILURE)
	
	GlobalVariable.openBrowser = true
	
	//Switch back to original tab
	WebUI.switchToWindowIndex(currentWindow)
	
	//Test saving of edit
	WebUI.waitForElementPresent(findTestObject('Page_tCC translationNotes/tNText_GLOutlinePoint1'), 5)
	
	//Add an 'x' to the end of GLOutlinePoint1
	WebUI.sendKeys(findTestObject('Page_tCC translationNotes/tNText_GLOutlinePoint1'), Keys.chord(Keys.END))
	
	WebUI.sendKeys(findTestObject('Page_tCC translationNotes/tNText_GLOutlinePoint1'), 'x')
	
	WebUI.clickOffset(findTestObject('Page_tCC translationNotes/tNText_GLOutlinePoint1'), -500, 0)
	
	WebUI.delay(2)
	
	WebUI.click(findTestObject('Page_tCC translationNotes/button_SaveEnabled - xPath'))
	
	//If the save worked, remove the 'x' added to GLOutlinePoint1
	if (WebUI.waitForElementNotPresent(findTestObject('Page_tCC translationAcademy/button_SaveEnabled - xPath'), 30, FailureHandling.CONTINUE_ON_FAILURE)) {
	    WebUI.click(findTestObject('Page_tCC translationNotes/tNText_GLOutlinePoint1'))
	
	    WebUI.sendKeys(findTestObject('Page_tCC translationNotes/tNText_GLOutlinePoint1'), Keys.chord(Keys.END))
	
	    WebUI.sendKeys(findTestObject('Page_tCC translationNotes/tNText_GLOutlinePoint1'), Keys.chord(Keys.BACK_SPACE))
	
	    WebUI.clickOffset(findTestObject('Page_tCC translationNotes/tNText_GLOutlinePoint1'), -500, 0)
	
	    WebUI.delay(2)
	
	    WebUI.click(findTestObject('Page_tCC translationAcademy/button_SaveEnabled - xPath'))
	
	    WebUI.waitForElementNotPresent(findTestObject('Page_tCC translationAcademy/button_SaveEnabled - xPath'))
	} else {
	    CustomKeywords.'unfoldingWord_Keywords.SendMessage.SendFailMessage'('Test failed because the Save button remained enabled.')
	}
} else {
	println('Bypassed testing multiple sessions in Firefox on Mac')
	WebUI.closeBrowser()
}

WebUI.closeBrowser()

