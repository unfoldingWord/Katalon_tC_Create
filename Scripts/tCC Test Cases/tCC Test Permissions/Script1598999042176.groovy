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

WebUI.callTestCase(findTestCase('tCC Components/tCC Login'), [('user') : 'tc01', ('password') : 'tc01'], FailureHandling.STOP_ON_FAILURE)

if (!(WebUI.callTestCase(findTestCase('tCC Components/tCC Select Org-Lang-Resource'), [('organization') : '', ('language') : ''
        , ('resource') : 'unfoldingWord® Translation Academy'], FailureHandling.STOP_ON_FAILURE))) {
    KeywordUtil.markFailed('Exiting script because organization was not found..')

    WebUI.closeBrowser()

    return null
}

WebUI.closeBrowser()

WebUI.callTestCase(findTestCase('tCC Components/tCC Login'), [('user') : 'tc02', ('password') : 'tc02'], FailureHandling.STOP_ON_FAILURE)

if (!(WebUI.callTestCase(findTestCase('tCC Components/tCC Select Org-Lang-Resource'), [('organization') : '', ('language') : ''
        , ('resource') : 'unfoldingWord® Translation Academy'], FailureHandling.OPTIONAL))) {
    if (!WebUI.verifyElementPresent(findTestObject('Page_tC Create/msg_No organizations for this account'), 1, FailureHandling.OPTIONAL)) {
		msg = 'Exiting script because organization was not found and no error message was displayed.'
		CustomKeywords.'unfoldingWord_Keywords.SendMessage.SendFailMessage'(msg)
    } else {
		println('No organizations for this account message was displayed.')
    }
    WebUI.closeBrowser()

    return null
}

WebUI.closeBrowser()

