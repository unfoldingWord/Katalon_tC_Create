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

if (1 == 1) {
	WebUI.callTestCase(findTestCase('tCC Components/tCC tN Open For Edit'), [('$username') : '', ('$password') : '', ('file') : ''], 
	    FailureHandling.STOP_ON_FAILURE)
	
	WebUI.click(findTestObject('Page_tCC translationNotes/button_ViewColumns'))
	
	WebUI.click(findTestObject('Page_tCC translationNotes/columns_ID'))
	
	WebUI.click(findTestObject('Page_tCC translationNotes/columns_OrigQuote'))
	
	WebUI.click(findTestObject('Page_tCC translationNotes/columns_SupportReference'))
	
	WebUI.click(findTestObject('Page_tCC translationNotes/columns_OccurrenceNote'))
	
	WebUI.click(findTestObject('Page_tCC translationNotes/btnX_CloseColumns'))
	
	WebUI.delay(1)

}

highlighted = 'rgba(255, 255, 0, 1)'

ids = []

origQuotes = []

first = true

new File('/Users/cckozie/Downloads/en_tn_57-TIT.tsv').splitEachLine('\t', { def fields ->
        if ((fields[4]) != '') {
            if (!(first)) {
                println(((fields[3]) + ':') + (fields[5]))

                ids.add(fields[3])

                origQuotes.add(fields[5])
            } else {
                first = false
            }
        }
    } //Read data from CSV
    )

i = 0
//for (id in ids) {
ids.each { id ->
	println('>>>> ' + id)
	words = []
	words = origQuotes[i].split(' ')
//	for (word in words) {
//		println(word)
//	}
//	i ++
//}

//id = 'rtc9'

	divId = 'id("header-1-1-' + id + '")'
	
	if (WebUI.verifyElementPresent(findTestObject('Page_tCC translationNotes/span_OrigWordParmed_1', [('myDiv') : divId]), 1)) {
			
		WebUI.scrollToElement(findTestObject('Page_tCC translationNotes/span_OrigWordParmed_1', [('myDiv') : divId]), 1)
		
	} else {
	
		println('stopping')
	}
	
	WebUI.delay(1)
	
	spans = []
//(1..10).findAll{it < 5}.each{println it} 
//	(1..30).each { myNum ->
//	(1..30).findAll{it.length() > 0}.each {
	for (def myNum : (1..30)) {
	    word = WebUI.getText(findTestObject('Page_tCC translationNotes/span_OLW_Parmed_1', [('wordNum') : myNum]), FailureHandling.OPTIONAL)
		if (word.length() > 0) {
			spans.add(word)
		} else {
			break
		}
	}
	
//	for (myWord in words) {
	words.each { myWord ->
		
		println('Testing highlighting of ' + myWord)
	
		myNum = 1
		for (span in spans) {
//		spans.each { span ->
//		    if (word == myWord) {
		    if (span == myWord) {
				bgColor = WebUI.getCSSValue(findTestObject('Page_tCC translationNotes/span_OLW_Parmed', [('myDiv') : divId, ('wordNum') : myNum]), 
		            'background-color')
		        if (bgColor == highlighted) {
		            print(('word ' + myNum) + ' is highighted\n')
		        } else {
		            print(('word ' + myNum) + ' is not highlighted\n')
					println('Background color is ' + bgColor)
		        }
		    }
		myNum ++
		}
	}
	i++
}