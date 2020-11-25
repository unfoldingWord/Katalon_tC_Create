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

// TEST MOVING A ROW UP AND THEN BACK DOWN
// REDO THE TEST BUT THIS TIME SAVING THE FILE AFTER THE FIRST MOVE, THEN SAVING
// REOPEN THE SAVED PROJECT, VERIFY THAT THE CHANGED ORDER WAS SAVED, THEN RESTORE TO ORIGINAL ORDER

WebUI.callTestCase(findTestCase('tCC Components/tCC tN Open For Edit'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(1)

WebUI.click(findTestObject('Page_tCC translationNotes/button_ViewColumns'))

WebUI.click(findTestObject('Page_tCC translationNotes/columns_Parmed', [('column') : 'ID']))

WebUI.click(findTestObject('Page_tCC translationNotes/btnX_CloseColumns'))

// When project is loaded, ID rtc9 is above xyz8
rtc9Text = WebUI.getText(findTestObject('Page_tCC translationNotes/p_rtc9'))

xyz8Text = WebUI.getText(findTestObject('Page_tCC translationNotes/p_xyz8'))

if ((rtc9Text != 'rtc9') || (xyz8Text != 'xyz8')) {
    println('ERROR: Rows are not in the expected order')

    println('rtc9:' + rtc9Text)

    println('xyz8:' + xyz8Text)

    CustomKeywords.'unfoldingWord_Keywords.SendMessage.SendFailMessage'('Test failed because the rows are not in the expected order.')
}

WebUI.scrollToElement(findTestObject('Page_tCC translationNotes/button_MoveRow_xyz8Up'), 1)

WebUI.click(findTestObject('Page_tCC translationNotes/button_MoveRow_xyz8Up'))

rtc9Text = WebUI.getText(findTestObject('Page_tCC translationNotes/p_rtc9'))

xyz8Text = WebUI.getText(findTestObject('Page_tCC translationNotes/p_xyz8'))

if ((rtc9Text != 'xyz8') || (xyz8Text != 'rtc9')) {
    println('ERROR: Rows do not appear to have been moved')

    println('rtc9:' + rtc9Text)

    println('xyz8:' + xyz8Text)

    CustomKeywords.'unfoldingWord_Keywords.SendMessage.SendFailMessage'('Test failed because the rows do not appear to have been moved.')
}

WebUI.delay(1)

WebUI.scrollToPosition(0, 2800)

WebUI.delay(1)

WebUI.click(findTestObject('Page_tCC translationNotes/button_MoveRow_rtc9Down'))

rtc9Text = WebUI.getText(findTestObject('Page_tCC translationNotes/p_rtc9'))

xyz8Text = WebUI.getText(findTestObject('Page_tCC translationNotes/p_xyz8'))

if ((rtc9Text != 'rtc9') || (xyz8Text != 'xyz8')) {
    println('ERROR: Rows were returned to the original order')

    println('rtc9:' + rtc9Text)

    println('xyz8:' + xyz8Text)

    CustomKeywords.'unfoldingWord_Keywords.SendMessage.SendFailMessage'('Test failed because the rows were not returned to the original order.')
}

WebUI.scrollToElement(findTestObject('Page_tCC translationNotes/button_MoveRow_xyz8Up'), 1)

WebUI.click(findTestObject('Page_tCC translationNotes/button_MoveRow_xyz8Up'))

WebUI.click(findTestObject('Page_tCC translationNotes/button_SaveEnabled - xPath'))

WebUI.delay(1)

WebUI.closeBrowser()

WebUI.callTestCase(findTestCase('tCC Components/tCC tN Open For Edit'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(1)

WebUI.click(findTestObject('Page_tCC translationNotes/button_ViewColumns'))

WebUI.click(findTestObject('Page_tCC translationNotes/columns_Parmed', [('column') : 'ID']))

WebUI.click(findTestObject('Page_tCC translationNotes/btnX_CloseColumns'))

// Now ID rtc9 should be below xyz8
rtc9Text = WebUI.getText(findTestObject('Page_tCC translationNotes/p_rtc9'))

xyz8Text = WebUI.getText(findTestObject('Page_tCC translationNotes/p_xyz8'))

if ((rtc9Text != 'xyz8') || (xyz8Text != 'rtc9')) {
    println('ERROR: Rows do not appear to have been moved before the Save')

    println('rtc9:' + rtc9Text)

    println('xyz8:' + xyz8Text)

    CustomKeywords.'unfoldingWord_Keywords.SendMessage.SendFailMessage'('Test failed because the rows do not appear to have been moved before the Savce.')
}

WebUI.delay(1)

WebUI.scrollToPosition(0, 2800)

WebUI.click(findTestObject('Page_tCC translationNotes/button_MoveRow_rtc9Down'))

rtc9Text = WebUI.getText(findTestObject('Page_tCC translationNotes/p_rtc9'))

xyz8Text = WebUI.getText(findTestObject('Page_tCC translationNotes/p_xyz8'))

if ((rtc9Text != 'rtc9') || (xyz8Text != 'xyz8')) {
    println('ERROR: Rows were not returned to the original order')

    println('rtc9:' + rtc9Text)

    println('xyz8:' + xyz8Text)

    CustomKeywords.'unfoldingWord_Keywords.SendMessage.SendFailMessage'('Test failed because the rows were not returned to the original order.')
}

WebUI.click(findTestObject('Page_tCC translationNotes/button_SaveEnabled - xPath'))

WebUI.delay(1)

WebUI.closeBrowser()

