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
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
import java.awt.datatransfer.Clipboard as Clipboard
import java.awt.datatransfer.Transferable as Transferable
import java.awt.datatransfer.DataFlavor as DataFlavor
import java.awt.Toolkit as Toolkit

keyString = 'Keys.chord(Keys.CONTROL, "v")'
def l1 = keyString.indexOf(',')
def l2 = keyString.indexOf(')', l1)
def chars = keyString.substring(l1+1, l2)
keyString = Keys.chord(Keys.CONTROL,chars)

println(chars)
return false
WebUI.openBrowser(GlobalVariable.url)
WebUI.doubleClick(findTestObject('Object Repository/recordings/h1_Login'))
//keys = 'Keys.chord(Keys.CONTROL, "c")'
keys = 'Keys.chord(Keys.COMMAND, "c")'

element = 'null'

CustomKeywords.'unfoldingWord_Keywords.HotKeys.sendKeys'(element, keys)

element = findTestObject('Object Repository/Page_tC Create/input__username')

keys = 'Keys.chord(Keys.CONTROL, "v")'

CustomKeywords.'unfoldingWord_Keywords.HotKeys.sendKeys'(element, keys)

return false

if ((GlobalVariable.browser == '') || (GlobalVariable.browser == null)) {
    GlobalVariable.browser = unfoldingWord_Keywords.GetTestingConfig.getBrowserAndVersion()
}

if (GlobalVariable.systemOS.contains('Windows')) {
    WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.CONTROL, 'a'))

    WebUI.delay(1)

    WebUI.sendKeys(null, Keys.chord(Keys.CONTROL, 'c'))
} else if (GlobalVariable.browser.contains('firefox')) {
    WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.COMMAND, 'a'))

    WebUI.delay(1)

    WebUI.sendKeys(null, Keys.chord(Keys.COMMAND, 'c'))
} else {
    WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.COMMAND, 'a'))

    WebUI.delay(1)

    WebUI.sendKeys(null, Keys.chord(Keys.CONTROL, Keys.INSERT))
}

