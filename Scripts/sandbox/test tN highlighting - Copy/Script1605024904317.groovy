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
import org.openqa.selenium.Point as Point

//import com.kms.katalon.core.webui.common.WebUiCommonHelper
WebUI.callTestCase(findTestCase('tCC Components/tCC tN Open For Edit'), [('$username') : '', ('$password') : '', ('file') : ''], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Page_tCC translationNotes/button_ViewColumns'))

WebUI.click(findTestObject('Page_tCC translationNotes/columns_ID'))

WebUI.click(findTestObject('Page_tCC translationNotes/columns_OrigQuote'))

WebUI.click(findTestObject('Page_tCC translationNotes/columns_SupportReference'))

WebUI.click(findTestObject('Page_tCC translationNotes/columns_OccurrenceNote'))

WebUI.click(findTestObject('Page_tCC translationNotes/btnX_CloseColumns'))

id = 'rtc9'

WebUI.delay(1)

divId = 'id("header-1-1-rtc9")'

WebUI.scrollToElement(findTestObject('Page_tCC translationNotes/span_OrigWordParmed_1', [('myDiv') : divId]), 1)

highlighted = 'rgba(255, 255, 0, 1)'

//myWord = 'Θεοῦ'

myWord = 'κατὰ'

for (def myNum : (1..20)) {
    //myNum = 8
    //WebUI.click(findTestObject('Page_tCC translationNotes/span_OLW_Parmed',[('word') : myWord, ('wordNum') : myNum]))
    word = WebUI.getText(findTestObject('Page_tCC translationNotes/span_OLW_Parmed_1', [('wordNum') : myNum]), FailureHandling.OPTIONAL)
	//println(word)
    if (word == myWord) {
        if (WebUI.getCSSValue(findTestObject('Page_tCC translationNotes/span_OLW_Parmed', [('word') : myWord, ('wordNum') : myNum]), 
            'background-color') == highlighted) {
            print(('word ' + myNum) + ' is highighted')
        } else {
            print(('word ' + myNum) + ' is not highlighted')
        }
    }
}

return false

def testHighlightStatus(def word) {
    def flag = false

    highlighted = 'rgba(255, 255, 0, 1)'

    println(WebUI.getCSSValue(findTestObject('Page_tCC translationNotes/span_OrigLangWord', [('word') : word]), 'background-color'))

    if (WebUI.getCSSValue(findTestObject('Page_tCC translationNotes/span_OrigLangWord', [('word') : word]), 'background-color') == 
    highlighted) {
        flag = true
    }
    
    return flag
}

