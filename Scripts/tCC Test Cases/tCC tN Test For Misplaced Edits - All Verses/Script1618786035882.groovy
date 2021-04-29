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
import com.kms.katalon.core.testobject.ConditionType as ConditionType

//testFiles = ['en_tn_23-ISA.tsv', 'en_tn_42-MRK.tsv',  'en_tn_44-JHN.tsv', 'en_tn_45-ACT.tsv', 'en_tn_46-ROM.tsv', 'en_tn_47-1CO.tsv', 'en_tn_48-2CO.tsv']
//testFiles = ['en_tn_42-MRK.tsv'] //,  'en_tn_44-JHN.tsv', 'en_tn_45-ACT.tsv', 'en_tn_46-ROM.tsv', 'en_tn_47-1CO.tsv', 'en_tn_48-2CO.tsv']
testFiles = ['en_tn_65-3JN.tsv']

	testFiles.each { file ->
	WebUI.callTestCase(findTestCase('tCC Components/tCC tN Open For Edit'), [('file') : file], FailureHandling.STOP_ON_FAILURE)
	
	WebUI.delay(15)
	
	rows = WebUI.getText(findTestObject('Page_tCC translationNotes/list_RowsPerPage'))
	
	if (rows != '25') {
	    println(('ERROR: The initial rows per page is set to ' + rows) + ' when it should be 25.')
	
	    CustomKeywords.'unfoldingWord_Keywords.SendMessage.SendFailMessage'(('Test failed because the initial rows per page is set to ' + 
	        rows) + ' when it should be 25.')
	}
	
	displayRows = WebUI.getText(findTestObject('Page_tCC translationNotes/text_RowsOnPage'))
	
	rowsList = [50, 100, 25, 10]
	
	//	WebUI.click(findTestObject('Page_tCC translationNotes/list_RowsPerPage'))
	//	WebUI.click(findTestObject('Page_tCC translationNotes/option_RowsPerPage_parmned', [('rows') : rows]))
	displayRows = WebUI.getText(findTestObject('Object Repository/Page_tCC translationNotes/text_RowsOnPage'))
	
	// Count the number of SupportReference fields on the screen (this counts both from the source and target)
	List elements = WebUI.findWebElements(new TestObject().addProperty('xpath', ConditionType.EQUALS, '//*[@class = \'MuiTypography-root-114 jss255 MuiTypography-subtitle2-126 MuiTypography-colorTextSecondary-140 MuiTypography-alignLeft-129\' and (text() = \'SupportReference\' or . = \'SupportReference\')]'), 
	    10)
	
	totalRows = (elements.size() / 2)
	
	page = 'Page_tCC translationNotes/'
	
	//dcsRepo = 'https://qa.door43.org/translate_test/en_tn/_edit/tc01-tc-create-1/en_tn_43-LUK.tsv'
	dcsRepo = 'https://qa.door43.org/translate_test/en_tn/raw/branch/tc01-tc-create-1/en_tn_43-LUK.tsv'
	
	//def columns = new String[10]
	columns = []
	
	columns = ['Page_tCC translationNotes/columns_Book', 'Page_tCC translationNotes/columns_Chapter', 'Page_tCC translationNotes/columns_Verse'
	    , 'Page_tCC translationNotes/columns_ID', 'Page_tCC translationNotes/columns_OrigQuote', 'Page_tCC translationNotes/columns_Occurrence'
	    , 'Page_tCC translationNotes/columns_GLQuote']
	
	WebUI.click(findTestObject('Page_tCC translationNotes/button_ViewColumns'))
	
	KeywordUtil.logInfo('Setting all columns ON')
	
	for (def c : (0..columns.size() - 1)) {
	    //    col = (page + (columns[c]))
	    col = (columns[c])
	
	    WebUI.uncheck(findTestObject(col), FailureHandling.OPTIONAL)
	}
	
	//One by one set each column on 
	for (def c : (0..columns.size() - 1)) {
	    col = (columns[c])
	
	    WebUI.click(findTestObject(col))
	
	    WebUI.verifyElementChecked(findTestObject(col), 1, FailureHandling.CONTINUE_ON_FAILURE)
	}
	
	WebUI.click(findTestObject('Page_tCC translationNotes/btnX_CloseColumns'))
	
	atEnd = false
	
	pages = 0
	
	row = 1
	
	myRow = row
	
	repoLines = []
	
	repoTexts = []
	
	while (!(atEnd) && (pages < 250)) {
	    myRow += 1
	
	    myID = WebUI.getText(findTestObject('Object Repository/Page_tCC translationNotes/last_ID', [('line') : row]))
	
	    myText = ((('Testing row ' + myRow) + ' ID = ') + myID)
	
	    WebUI.setText(findTestObject('Object Repository/Page_tCC translationNotes/last_SupportReference', [('line') : row]), 
	        myText)
		
		row ++
		
		myRow ++
	
		if (row >= 25) {
		    row = 1
			
			myRow = 1
		
		    WebUI.click(findTestObject('Object Repository/Page_tCC translationNotes/button_NextPage'))
		
		    count = 0
		
		    while ((count < 5) && !(WebUI.verifyElementClickable(findTestObject('Object Repository/Page_tCC translationNotes/button_NextPage'), 
		        FailureHandling.OPTIONAL))) {
		        WebUI.delay(1)
		
		        count++
		    }
		    
		    if (count >= 5) {
		        println('Next Page was not clickable after 5 seconds, assuming last page.')
		
		        atEnd = true
		    }
		    
		    pages++
		}
	}
	
	WebUI.click(findTestObject('Page_tCC translationNotes/button_SaveEnabled - xPath'))
	
	while (WebUI.verifyTextPresent('Save', false, FailureHandling.OPTIONAL)) {
	    println('Save present')
		WebUI.mouseOverOffset(findTestObject('Page_tCC translationNotes/button_SaveEnabled - xPath'), -100, 0)
	}
	
	WebUI.delay(10)
	
	WebUI.closeBrowser()
} 

if (1 == 2) {
	// Open a second browser tab
	WebUI.executeJavaScript('window.open();', [])
	
	currentWindow = WebUI.getWindowIndex()
	
	//Go to new tab
	WebUI.switchToWindowIndex(currentWindow + 1)
	
	// Navigate to dcs repo
	
	WebUI.navigateToUrl(dcsRepo)
	
	WebUI.delay(3)
	
	println(repoLines)
	println(repoTexts)
	
	text = WebUI.getText(findTestObject('Page_Git Repo/text_Full_Repo_Raw'))
	
	//println(text)
	
	List lines = text.split( '\n' )
	
	l = 0
	
	//for (def line : repoLines) {
	repoLines.each { line -> 
		
	//	println(line)
		
		text = lines[line-1]
		
		println(text)
	
	    if (!(text.contains(repoTexts[l]))) {
	        println((((('ERROR: repo line ' + line) + ' text is ') + text) + ', expected to find ') + (repoTexts[l]))
	    }
		
		l ++
	}
}

GlobalVariable.scriptRunning = false
