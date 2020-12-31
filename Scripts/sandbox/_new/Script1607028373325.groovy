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

myFile = 'en_tn_65-3JN.tsv' // SET TO FILE TO BE TESTED

myId = '' // SET TO THE ID OF THE CHECK TO START TESTING WITH. IF EMPTY, STARTS WITH FIRST ID.

fName = ((('/Users/' + GlobalVariable.pcUser) + '/Downloads/') + myFile)

WebUI.openBrowser('https://git.door43.org/unfoldingWord/en_tn/raw/branch/master/' + myFile)

WebUI.maximizeWindow()

WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.COMMAND, 'a'))

WebUI.delay(2)

WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.CONTROL, Keys.INSERT))

Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard()

Transferable contents = clipboard.getContents(null)

result = ((contents.getTransferData(DataFlavor.stringFlavor)) as String)

println('result:' + result)

