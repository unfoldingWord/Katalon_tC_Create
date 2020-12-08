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

// /Users/cckozie/Katalon Studio/Files/Reference/Validation-en_tn_57-TIT.tsv_base.csv
// Lines 4,6,7

testLines = [4,6,7]

baseLines = []
new File('/Users/cckozie/Katalon Studio/Files/Reference/Validation-en_tn_57-TIT.tsv_base.csv').eachLine({ def line ->
//	println(line)
	baseLines.add(line)
})

newLines = []
new File('/Users/cckozie/Downloads/Validation-en_tn_57-TIT.tsv-2020-12-07T23_10_10.404Z.csv').eachLine({ def line ->
//	println(line)
	newLines.add(line)
})

//for (baseLine in baseLines) {
//for (line in testLines) {
testLines.each({ def line ->
	for (newLine in newLines) {
		if (newLine == baseLines[line]) {
			println('ERROR: Validation file line ' + (line + 1) + ' [' + newLine + '] still exists after being fixed')
		}
		
	}
})
