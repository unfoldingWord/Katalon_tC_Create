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

WebUI.callTestCase(findTestCase('tCC Components/tCC tN Open For Edit'), [('$username') : '', ('$password') : '', ('file') : ''], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.scrollToElement(findTestObject('recordings/button_ExpandChapter'), 2)

WebUI.delay(2)

WebUI.click(findTestObject('recordings/button_ExpandChapter'))

WebUI.delay(2)

WebUI.mouseOver(findTestObject('recordings/verse_1-2'))

WebUI.delay(2)

WebUI.click(findTestObject('recordings/verse_1-2'))

for (def i : (1..20)) {
    WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.PAGE_DOWN)) //    WebUI.delay(1)
}

WebUI.closeBrowser()

