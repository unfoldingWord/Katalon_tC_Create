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
import com.kms.katalon.core.webui.keyword.internal.WebUIAbstractKeyword as WebUIAbstractKeyword
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
import java.awt.datatransfer.Clipboard as Clipboard
import java.awt.datatransfer.Transferable as Transferable
import java.awt.datatransfer.DataFlavor as DataFlavor
import java.awt.Toolkit as Toolkit
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory

WebUI.callTestCase(findTestCase('tCC Components/tCC tN Open For Edit'), [('$username') : GlobalVariable.validateUser, ('$password') : GlobalVariable.validatePassword
        , ('file') : 'GlobalVariable.tNFile]'], FailureHandling.STOP_ON_FAILURE)

//WebUI.clickOffset(findTestObject('Page_tCC translationNotes/link2'), -250, 0)
//return false

xPath = '/html/body/div[2]/div[3]/div/div[2]/p'

WebDriver driver = DriverFactory.getWebDriver()

WebElement Paragraph = driver.findElement(By.xpath(xPath))

List rows = Paragraph.findElements(By.tagName('p'))

List links = Paragraph.findElements(By.tagName('a'))

row = 0
links.each({
		println('The row text is ' + rows[row].getText())
        println(it.getText())
		it.click()
		row ++
    })
return false
for (def row : (1..4)) {
    if (WebUI.verifyElementPresent(findTestObject('Object Repository/Page_tCC translationNotes/text_Validator_Message_Row_Parmed', 
            [('row') : row]), 1)) {
        text = WebUI.getText(findTestObject('Object Repository/Page_tCC translationNotes/text_Validator_Message_Row_Parmed', 
                [('row') : row]))

        println((('Text of row ' + row) + ' is ') + text)

        width = WebUI.getElementWidth(findTestObject('Object Repository/Page_tCC translationNotes/text_Validator_Message_Row_Parmed', 
                [('row') : row]))

        println((('Width of row ' + row) + ' is ') + width)

        height = WebUI.getElementHeight(findTestObject('Object Repository/Page_tCC translationNotes/text_Validator_Message_Row_Parmed', 
                [('row') : row]))

        println((('Width of row ' + row) + ' is ') + width)

        println((('Height of row ' + row) + ' is ') + height)

        linkOffset = ((width / 2) -25) * -1
		
		println('Clicking link on row ' + row)

        WebUI.clickOffset(findTestObject('Object Repository/Page_tCC translationNotes/text_Validator_Message_Row_Parmed', 
                [('row') : row]), -250, -528)
		return false
		WebUI.delay(5)
    } else {
        break
    }
}

WebUI.clickOffset(findTestObject('Page_tCC translationNotes/link2'), -250, 0)

