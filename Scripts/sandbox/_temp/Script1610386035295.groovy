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

file = 'Validation-en_tn_43-LUK.tsv-2021-01-25T19_47_10.013Z.csv'
if (file.substring(file.length()-3) == 'csv') {
	println('not')
} else {
	println('is')
}
return false
line = 1

if (1 == 1) {
WebUI.callTestCase(findTestCase('tCC Components/tCC tN Open For Edit'), [('$username') : GlobalVariable.validateUser, ('$password') : GlobalVariable.validatePassword
	, ('file') : ''], FailureHandling.STOP_ON_FAILURE)

currentWindow = WebUI.getWindowIndex()

alertText = WebUI.getText(findTestObject('Object Repository/Page_tCC translationNotes/alert_validator_Error_Msg'))
} else {
alertText = 'This file cannot be opened by tC Create. Please contact your administrator to address the following error(s).\n ' +
'On line 1 Bad TSV Header, expecting "Book,Chapter,Verse,ID,SupportReference,OrigQuote,Occurrence,GLQuote,OccurrenceNote"\n' +  
'On line 22 Not enough columns, expecting 9, found 8\n' +
'On line 26 Not enough columns, expecting 9, found 8\n' +  
'On line 98 Not enough columns, expecting 9, found 8'
}

currentWindow = WebUI.getWindowIndex()

alertText = WebUI.getText(findTestObject('Object Repository/Page_tCC translationNotes/alert_validator_Error_Msg'))

println(alertText)

List lines = alertText.split( '\n').findAll {it}

println(lines)

WebUI.delay(2)

for (line in lines) {
	if (line.contains('line ')) {
		lStart = line.indexOf('line ')
		str = line.substring(lStart + 5)
		lEnd = str.indexOf(' ')
		lineNum = str.substring(0,lEnd)
		WebUI.click(findTestObject('Object Repository/Page_tCC translationNotes/link_errorLine_Parmed', [('lineNum') : lineNum]))
		WebUI.switchToWindowIndex(currentWindow + 1)
		WebUI.waitForElementPresent(findTestObject('Page_Git Repo/repo_validator_lineNumber_parmed', [('lineNum') : lineNum]), 3)
		lineClass = WebUI.getAttribute(findTestObject('Page_Git Repo/repo_validator_lineNumber_parmed', [('lineNum') : lineNum]), 'class', FailureHandling.OPTIONAL)
		if (!lineClass.contains('active')) {
			println('Row is not highlighted')
		} else {
			println('Row was correctly highlighted')
		}
		WebUI.closeWindowIndex(currentWindow + 1)
		WebUI.delay(1)
		WebUI.switchToWindowIndex(currentWindow)
		WebUI.delay(1)
	}
}
