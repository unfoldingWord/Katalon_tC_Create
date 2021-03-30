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
import com.kms.katalon.core.testobject.ConditionType as ConditionType

println('Testing for app crash after when adding data to deleted row. ISSUE 639')

IDs = ['e3ce', 'sshf', 'x93f', 'o6j4', 'z4ec']

WebUI.callTestCase(findTestCase('tCC Components/tCC tN Open For Edit'), [('$username') : '', ('$password') : '', ('file') : 'en_tn_55-1TI.tsv'], 
    FailureHandling.STOP_ON_FAILURE)

columns = ['Book', 'ID']

CustomKeywords.'unfoldingWord_Keywords.ManageTNColumns.toggleColumn'(columns)

WebUI.click(findTestObject('Page_tCC translationNotes/button_Search'))

set = false

for (def id : IDs) {
    WebUI.setText(findTestObject('Page_tCC translationNotes/input_Search'), id)

    book = WebUI.getText(findTestObject('Page_tCC translationNotes/text_Book_SearchId'))

    println(book)

    println(book.length())

    if (book.length() < 2) {
        WebUI.setText(findTestObject('Page_tCC translationNotes/text_Book_SearchId'), '1TI')

        WebUI.clickOffset(findTestObject('Page_tCC translationNotes/text_Book_SearchId'), 0, 100)

        set = true
    }
    
    if (set) {
		
        break
		
    } else {
		
        WebUI.setText(findTestObject('Page_tCC translationNotes/input_Search'), '')

        WebUI.sendKeys(findTestObject('Page_tCC translationNotes/input_Search'), Keys.chord(Keys.BACK_SPACE, Keys.BACK_SPACE, 
                Keys.BACK_SPACE, Keys.BACK_SPACE))
    }
}

if (!set) {
	println('ERROR: Failed to find any deleted row')
	
	CustomKeywords.'unfoldingWord_Keywords.SendMessage.SendFailMessage'('Could not execute test because no deleted row could be found.')
}

WebUI.delay(2)

if (!(WebUI.waitForElementPresent(findTestObject('Page_tC Create/chip_Repo'), 5, FailureHandling.OPTIONAL))) {
    println('ERROR: Repo chip is not present after setting book on a deleted row')

    CustomKeywords.'unfoldingWord_Keywords.SendMessage.SendFailMessage'('Test failed because the repo chip is not present after setting book on a deleted row.')
} else {
    println('App did not crash after setting the book on a deleted row.')
}

WebUI.delay(2)

GlobalVariable.scriptRunning = false

WebUI.closeBrowser()

