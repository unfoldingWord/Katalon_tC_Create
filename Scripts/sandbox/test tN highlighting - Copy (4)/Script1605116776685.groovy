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
import java.io.File


//import com.kms.katalon.core.webui.common.WebUiCommonHelper

details = false

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

chapters = []

verses = []

first = true

elips = '...'

new File('/Users/cckozie/Downloads/en_tn_57-TIT.tsv').splitEachLine('\t', { def fields ->
        if ((fields[2]) != 'intro') {
            if (!(first)) {
                println(((fields[3]) + ':') + (fields[5]))
                ids.add(fields[3])
				fields[5] = fields[5].replace(',', '')
                origQuotes.add(fields[5])
				chapters.add(fields[1])
				verses.add(fields[2])
            } else {
                first = false
            }
        }
    } //Read data from CSV
    )
lastChapter = ''
lastVerse = ''

oFile = new File('/Users/cckozie/Katalon Studio/Files/out.txt')
oFile.delete()

i = 0

ultLeft = WebUI.getElementLeftPosition(findTestObject('Page_tCC translationNotes/text_unfoldingWord Literal Text v15')) - 30
println('ultLeft is ' + ultLeft)
//for (id in ids) {
ids.each { id ->
	msg = '>>>> ' + id + '\n'
	println(msg)
	oFile.append(msg)
	words = []
//	println('1 ' + origQuotes[i])
	words = origQuotes[i].split('…| ')
	println(words)
	
	divId = 'id("header-' + chapters[i] + '-' + verses[i]+ '-' + id + '")'
	
	if (WebUI.verifyElementPresent(findTestObject('Page_tCC translationNotes/span_OrigWordParmed_1', [('myDiv') : divId]), 1, FailureHandling.OPTIONAL)) {
		println('scrolling')
		WebUI.scrollToElement(findTestObject('Page_tCC translationNotes/span_OrigWordParmed_1', [('myDiv') : divId]), 1)
		
	} else {
		println('paging')
		WebUI.click(findTestObject('Object Repository/Page_tCC translationNotes/button_NextPage'))
		WebUI.delay(2)
	}
	
	println('done scrolling')
	
	WebUI.delay(1)
	
	if (chapters[i] != lastChapter || verses[i] != lastVerse ) {
		msg = 'Reading spans for ' + chapters[i] + ':' + verses[i] + '\n'
		println(msg)
		oFile.append(msg)
		
	
		spans = []
		for (def myNum : (1..30)) {
		    word = WebUI.getText(findTestObject('Page_tCC translationNotes/span_OLW_Parmed', [('myDiv') : divId, ('chpt') : chapters[i], ('verse') : verses[i], ('wordNum') : myNum]), FailureHandling.OPTIONAL)
		    wordLeft = WebUI.getElementLeftPosition(findTestObject('Page_tCC translationNotes/span_OLW_Parmed', [('myDiv') : divId, ('chpt') : chapters[i], ('verse') : verses[i], ('wordNum') : myNum]))
//			println('wordLeft is ' + wordLeft)
			if (word.length() > 0 && wordLeft < ultLeft) {
				spans.add(word)
			} else {
				break
			}
		}
		println(spans)
		
		lastChapter = chapters[i]
		
		lastVerse = verses[i]
	}
	bgColors = []
	for (def wordNum : (1..spans.size())) {
		bgColors.add(WebUI.getCSSValue(findTestObject('Page_tCC translationNotes/span_OLW_Parmed', [('myDiv') : divId, ('chpt') : chapters[i], ('verse') : verses[i], ('wordNum') : wordNum]),
			'background-color'))
	}
	
	int myNum = 1
	for (span in spans) {
		wordStr = 'word ' + myNum + ', ' + span
	    if (span in words) {
	        if (bgColors[myNum-1] == highlighted) {
				if (details) {
					print(wordStr + ' is highighted as expected\n')
				}
	        } else {
	            msg = wordStr + ' is not highlighted but should be\n'
				println('---------- ' + msg)
				println('Background color is ' + bgColors[myNum-1])
				oFile.append(msg)
				
//				WebUI.closeBrowser()
	        }
	    } else {
	        if (bgColors[myNum-1] == highlighted) {
	            msg = wordStr + ' is highighted but should not be\n'
				println('++++++++++ ' + msg)
				oFile.append(msg)
//				WebUI.closeBrowser()
	        } else {
				if (details) {
					print(wordStr + ' is not highlighted as expected\n')
				}
	        }
	    }
	myNum ++
	}
	
	i++
}