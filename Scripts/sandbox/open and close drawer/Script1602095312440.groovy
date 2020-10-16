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
import groovy.transform.Field as Field
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.interactions.Actions as Actions
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.sikuli.script.*

String highlighted = 'rgba(255, 255, 0, 1)'

WebUI.callTestCase(findTestCase('tCC Components/tCC tN Open For Edit'), [('$username') : '', ('$password') : '', ('$origQuote') : ''
        , ('$newOrigQuote') : ''], FailureHandling.STOP_ON_FAILURE)

//CustomKeywords.'unfoldingWord_Keywords.HamburgerFunctions.toggleAllScripture'(null)
WebUI.click(findTestObject('Page_tC Create/button_DrawerOpen'))

WebUI.delay(5)

onState = WebUI.verifyImagePresent(findTestObject('Page_tC Create/image_ExpandAllScriptureOn'), FailureHandling.OPTIONAL)

println('On state is ' + onState)
	
if (1 == 2) {

	onState = WebUI.verifyImagePresent(findTestObject('Page_tC Create/image_ExpandAllScriptureOn'), FailureHandling.OPTIONAL)
	
	println('On state is ' + onState)
	
	offState = WebUI.verifyImagePresent(findTestObject('Page_tC Create/image_ExpandAllScriptureOff'), FailureHandling.OPTIONAL)
	
	println('Off state is ' + offState)
	
	WebUI.click(findTestObject('Page_tC Create/input_Expand all Scripture'))
	
	WebUI.delay(5)
	
	onState = WebUI.verifyImagePresent(findTestObject('Page_tC Create/image_ExpandAllScriptureOn'), FailureHandling.OPTIONAL)
	
	println('On state is ' + onState)
	
	offState = WebUI.verifyImagePresent(findTestObject('Page_tC Create/image_ExpandAllScriptureOff'), FailureHandling.OPTIONAL)
	
	println('Off state is ' + offState)
}
CustomKeywords.'unfoldingWord_Keywords.HamburgerFunctions.toggleAllScripture'('Off')
scripture = CustomKeywords.'unfoldingWord_Keywords.HamburgerFunctions.toggleAllScripture'('test')
println('The scripture pane is ' + scripture)
WebUI.delay(5)
CustomKeywords.'unfoldingWord_Keywords.HamburgerFunctions.toggleAllScripture'('ON')
scripture = CustomKeywords.'unfoldingWord_Keywords.HamburgerFunctions.toggleAllScripture'('TEST')
println('The scripture pane is ' + scripture)
//Pattern switchOn = new Pattern('/Users/cckozie/Katalon Studio/Sikuli Images/switchOn.png')
//Pattern switchOff = new Pattern('/Users/cckozie/Katalon Studio/Sikuli Images/switchOff.png')
//Screen s = new Screen()
//if (s.exists(switchOn)) {
//	println('The switch is on as expected')
//} else {
//	println('The switch is off')
//}
//WebUI.verifyImagePresent(findTestObject('Page_tC Create/image_ExpandAllScriptureOn'), FailureHandling.OPTIONAL)
//WebUI.click(findTestObject('Page_tC Create/image_ExpandAllScriptureOn'))
WebUI.delay(2)
//if (s.exists(switchOff)) {
//	println('The switch is off as expected')
//} else {
//	println('The switch is on')
//}
WebUI.click(findTestObject('Page_tC Create/button_DrawerClose'))

WebUI.closeBrowser()

