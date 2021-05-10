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
import com.kms.katalon.core.webui.keyword.internal.WebUIAbstractKeyword
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
import java.awt.datatransfer.Clipboard as Clipboard
import java.awt.datatransfer.Transferable as Transferable
import java.awt.datatransfer.DataFlavor as DataFlavor
import java.awt.Toolkit as Toolkit

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import com.kms.katalon.core.webui.driver.DriverFactory

repo = 'https://qa.door43.org/translate_test/en_tn/src/branch/tc01-tc-create-1/en_tn_57-TIT.tsv'

WebUI.openBrowser(repo)

table = WebUI.getText(findTestObject('Object Repository/Page_Git Repo/table_GitRepo'))
table.splitEachLine(' ', { def fields ->
	book = fields[0]
	chapter = fields[1]
	verse = fields[2]
	id = fields[3]
	sRef = fields[4]
})

//myFile = '/Users/cckozie/Downloads/en_tn_43-LUK-line-edits.tsv'
myFile = '/Users/cckozie/Downloads/en_tn_43-LUK-edit2.tsv'

testRows = ['00', '01', '25', '26', '50', '51', '75', '76']

f3 = 'uk55'
f4 = 'Testing row 2 ID = uk55'

loc = f4.indexOf(f3)
println('loc is ' + loc)

row = 1
String ssRow = row
if (ssRow.length() < 2) {
	ssRow = '0' + ssRow
}
l2 = ssRow.substring(ssRow.length()-2, ssRow.length())
println(l2  + ':' +  l2.length())

if (testRows.contains(l2) ) {
	if (f4.indexOf(f3) < 0) {
		println('ERROR: on row ' + ssRow + ', ' + f3 + ' not found in ' + f4)
	} else {
		println('Found match on row ' + ssRow)
	}
}

//return false
row = 0
new File(myFile).splitEachLine('\t', { def fields ->
	String sRow = row
	if (sRow.length() < 2) {
		sRow = '0' + sRow
	}
	l2 = sRow.substring(sRow.length()-2, sRow.length())
//	println(l2)
	if (testRows.contains(l2) ) {
		if (fields[4].indexOf(fields[3]) < 0) {
			println('ERROR: on row ' + sRow + ', ' + fields[3] + ' not found in ' + fields[4])
			println('The ID is [' + fields[3] + '] and the SupportReference is [' + fields[4] + '].')
		} else {
			println('Found match on row ' + sRow)
		}
	}
//	println(row + ' - ' + fields[3] + ' : ' + fields[4])
	row ++
})

