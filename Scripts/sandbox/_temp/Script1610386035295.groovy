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

rrows = 50
String srRows = rrows
text = '1-50 of 199'
println(text.indexOf(srRows))
//return false
WebUI.callTestCase(findTestCase('tCC Components/tCC tN Open For Edit'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(1)


displayRows = WebUI.getText(findTestObject('Object Repository/Page_tCC translationNotes/text_RowsOnPage'))

println(displayRows)

rows = 100

WebUI.click(findTestObject('Page_tCC translationNotes/list_RowsPerPage'))

WebUI.delay(1)

timeStart = new Date()

WebUI.click(findTestObject('Page_tCC translationNotes/option_RowsPerPage_parmned', [('rows') : rows]))

timeMid = new Date()

TimeDuration timeMidElapsed = TimeCategory.minus(timeMid, timeStart)

println(timeMidElapsed)

while (WebUI.getText(findTestObject('Object Repository/Page_tCC translationNotes/text_RowsOnPage')) == displayRows) {
	println(WebUI.getText(findTestObject('Object Repository/Page_tCC translationNotes/text_RowsOnPage')))
	WebUI.delay(1)
}

rowsText = WebUI.getText(findTestObject('Object Repository/Page_tCC translationNotes/text_RowsOnPage'))

timeEnd = new Date()

println(rowsText)

String sRows = rows

println(sRows)

if (rowsText.indexOf(sRows) != 2) {
	println('oops')
} else {
	println('yeah')
}
	
TimeDuration timeElapsed = TimeCategory.minus(timeEnd, timeStart)

println(timeElapsed)

//println(WebUI.waitForElementNotClickable(findTestObject('Page_tCC translationNotes/list_RowsPerPage'),1))

WebUI.delay(1)

WebUI.closeBrowser()
