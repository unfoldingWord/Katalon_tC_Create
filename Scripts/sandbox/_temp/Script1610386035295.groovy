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

import java.awt.datatransfer.StringSelection;

import org.openqa.selenium.Keys as Keys

//Download tsv file
//Save it with another name
//Remove header row
//Remove a tab
//Replace DCS content
//https://qa.door43.org/translate_test/en_t/src/branch/tc01-tc-create-1/en_tn_57-TIT.tsv
//https://qa.door43.org/translate_test/en_tn/src/branch/tc01-tc-create-1/en_tn_57-TIT.tsv
user = 'tc01'

myFile = 'en_tn_57-TIT.tsv' // SET TO FILE TO BE TESTED

repoBase = 'https://qa.door43.org/translate_test/'

resource = myFile.substring(0, 5)

myRepo = (((((repoBase + resource) + '/src/branch/') + user) + '-tc-create-1/') + myFile)

baseDir = (GlobalVariable.projectPath + '/Data Files/')

error1File = 'en_tn_57-TIT-no_header.tsv'

restoreFile = 'en_tn_57-TIT-SAVE.tsv'

myFile = restoreFile

//CustomKeywords.'unfoldingWord_Keywords.Replace_Repo_Content.replaceContent'(myRepo,'')
WebUI.openBrowser(myRepo)

if (WebUI.verifyElementPresent(findTestObject('Page_Git Repo/icon_UserSignIn'), 1)) {
    WebUI.click(findTestObject('Page_Git Repo/icon_UserSignIn'))

    WebUI.setText(findTestObject('Page_Git Repo/input_Username'), GlobalVariable.user1Name)

    WebUI.setText(findTestObject('Page_Git Repo/input_Password'), GlobalVariable.user1Password)

    WebUI.click(findTestObject('Page_Git Repo/button_SignIn'))
}

WebUI.click(findTestObject('Page_Git Repo/icon_Edit'))

WebUI.delay(3)

row1Text = WebUI.getText(findTestObject('Object Repository/Page_Git Repo/repoText_Row1'))

row2Text = WebUI.getText(findTestObject('Object Repository/Page_Git Repo/repoText_Row2'))

println(row1Text)

println(row2Text)

//	WebUI.setText(findTestObject('Object Repository/Page_Git Repo/repoText_Row1'),'ABC')
//	r2Text = row2Text.replaceFirst('\\9','X')
//	row2Text = WebUI.setText(findTestObject('Object Repository/Page_Git Repo/repoText_Row2'), r2Text)
WebUI.click(findTestObject('Page_Git Repo/span_ProjectTextHeader'))

//    WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.COMMAND, Keys.DOWN))
//    WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.TAB, Keys.TAB))
WebUI.delay(3)

WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.COMMAND, 'a'))

WebUI.delay(1)

WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.DELETE))

iFile = new File(baseDir + myFile)

String fileText = FileUtils.readFileToString(iFile)

println(fileText)

//String myString = "This text will be copied into clipboard"
StringSelection stringSelection = new StringSelection(fileText)

Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard()

clipboard.setContents(stringSelection, null)

WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.COMMAND, 'v'))

WebUI.click(findTestObject('Page_Git Repo/button_CommitChanges'))

return false

if ((GlobalVariable.browser == '') || (GlobalVariable.browser == null)) {
    GlobalVariable.browser = CustomKeywords.'unfoldingWord_Keywords.GetTestingConfig.getBrowserAndVersion'()
}

if (GlobalVariable.systemOS.contains('Windows')) {
    WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.CONTROL, 'a'))

    WebUI.delay(1)

    WebUI.sendKeys(null, Keys.chord(Keys.CONTROL, 'c'))
} else if (GlobalVariable.browser.contains('firefox')) {
    WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.COMMAND, 'a'))

    WebUI.delay(1)

    WebUI.sendKeys(null, Keys.chord(Keys.COMMAND, 'c'))
} else {
    WebUI.sendKeys(null, Keys.chord(Keys.COMMAND, 'a'))

    WebUI.delay(1)

    WebUI.sendKeys(null, Keys.chord(Keys.CONTROL, Keys.INSERT))
}

