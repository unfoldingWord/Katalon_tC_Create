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

// NEED TO ADD TESTS FOR THE INITIAL PROBLEMS WHEN ATTEMPTING TO RESOLVE ERRORS IN TN
// NEED TO ADD TESTS FOR THE INTRODUCTION OF ERRORS AFTER FIXING THE EXISTING ONES
dirName = '/Users/cckozie/Downloads'

baseDir = '/Users/cckozie/Katalon Studio/Files/Reference/'

testFiles = ['en_tn_50-EPH.tsv', 'en_tn_57-TIT.tsv']

for (def fileNum : (0..testFiles.size() - 1)) {
    testFile = (testFiles[fileNum])

    baseFile = (((baseDir + 'Validation-') + testFile) + '_base.csv')

    bFile = new File(baseFile)

    baseContent = bFile.text

    println('baseContent:' + baseContent)

    // Get the count of how many validation files already exist for the file being tested
    println('testFile:' + testFile)

    vFiles = getValidationFiles(testFile)

    initSize = vFiles.size()

    // Load the project in tN
    WebUI.callTestCase(findTestCase('tCC Components/tCC tN Open For Edit'), [('$username') : '', ('$password') : '', ('file') : testFile], 
        FailureHandling.STOP_ON_FAILURE)

    // Run the validation
    (vSize, newContent) = runValidation(initSize, testFile)

    println('newContent:' + newContent)

    // Test to see if the validation results are what was expected based on the originally saved validation file
    if (newContent != baseContent) {
        println('ERROR: Initial validation content does not match the base content')

        CustomKeywords.'unfoldingWord_Keywords.SendMessage.SendFailMessage'('Test failed because the initial validation content does not match the base content.')

        WebUI.closeBrowser()

        return false
    } else {
        println('Initial content matches the base content')
    }
    
    WebUI.delay(1)

    // Show the additional required columns
    WebUI.click(findTestObject('Page_tCC translationNotes/button_ViewColumns'))

    WebUI.click(findTestObject('Page_tCC translationNotes/columns_Parmed', [('column') : 'ID']))

    WebUI.click(findTestObject('Page_tCC translationNotes/columns_Parmed', [('column') : 'OrigQuote']))

    WebUI.click(findTestObject('Page_tCC translationNotes/btnX_CloseColumns'))

    if (fileNum == 0) {
        // Fix the en_tn_50-EPH.tsv validation errors
        u2bwBaseQuote = 'ἑνὶ…ἐκάστῳ ἡμῶν ἐδόθη ἡ χάρις'

        u2bwNewQuote = 'ἑνὶ…ἑκάστῳ ἡμῶν ἐδόθη ἡ χάρις'

        WebUI.click(findTestObject('Page_tCC translationNotes/button_Search'))

        WebUI.setText(findTestObject('Page_tCC translationNotes/input_Search'), 'u2bw')

        WebUI.setText(findTestObject('Object Repository/Page_tCC translationNotes/text_OrigQuote_SearchId'), u2bwNewQuote)

        abbwBaseQuote = 'ἑνὶ…ἐκάστῳ ἡμῶν ἐδόθη ἡ χάρις'

        abbwNewQuote = 'ἑνὶ…ἑκάστῳ ἡμῶν ἐδόθη ἡ χάρις'

        WebUI.scrollToPosition(0, 0)

        WebUI.click(findTestObject('Object Repository/Page_tCC translationNotes/button_SearchCloseX'))

        WebUI.delay(1)

        WebUI.click(findTestObject('Page_tCC translationNotes/button_Search'))

        WebUI.setText(findTestObject('Page_tCC translationNotes/input_Search'), 'abbw')

        WebUI.setText(findTestObject('Object Repository/Page_tCC translationNotes/text_OrigQuote_SearchId'), abbwNewQuote)
		
		testLines = [1,2]

    } else if (fileNum == 1) {
	
        WebUI.click(findTestObject('Page_tCC translationNotes/button_Preview'))

        WebUI.click(findTestObject('Page_tCC translationNotes/text_Introduction to Titus'))

        WebUI.delay(1)

        WebUI.sendKeys(findTestObject('Page_tCC translationNotes/text_Introduction to Titus'), Keys.chord(Keys.UP, Keys.UP, 
                Keys.RIGHT, Keys.RIGHT, Keys.RIGHT, Keys.RIGHT, Keys.RIGHT, Keys.BACK_SPACE))

        WebUI.delay(1)

        WebUI.sendKeys(findTestObject('Page_tCC translationNotes/text_Introduction to Titus'), Keys.chord(Keys.DOWN, Keys.BACK_SPACE, 
                Keys.DOWN, Keys.BACK_SPACE))

        WebUI.delay(1)
		
        WebUI.click(findTestObject('Page_tCC translationNotes/button_Preview'))

		rtc9NewQuote = '​κατὰ πίστιν'
		
		WebUI.click(findTestObject('Page_tCC translationNotes/button_Search'))

		WebUI.setText(findTestObject('Page_tCC translationNotes/input_Search'), 'rtc9')

		WebUI.setText(findTestObject('Object Repository/Page_tCC translationNotes/text_OrigQuote_SearchId'), rtc9NewQuote)
		
		WebUI.setText(findTestObject('Page_tCC translationNotes/input_Search'), '')
		
		xyz8NewQuote = 'εὐσέβειαν'

        WebUI.scrollToPosition(0, 0)

        WebUI.click(findTestObject('Object Repository/Page_tCC translationNotes/button_SearchCloseX'))

        WebUI.delay(1)

        WebUI.click(findTestObject('Page_tCC translationNotes/button_Search'))

		WebUI.setText(findTestObject('Page_tCC translationNotes/input_Search'), 'xyz8')

		WebUI.setText(findTestObject('Object Repository/Page_tCC translationNotes/text_OrigQuote_SearchId'), xyz8NewQuote)
		
		testLines = [4,6,7]
		
    }
    
    // Rerun the validation
    initSize = vSize

    (vSize, newContent, myFile) = runValidation(initSize, testFile)
	
    println('newContent:' + newContent)
	
	testOutput(testLines, baseFile, myFile)
	
    // Read the file into field lists
    prioritys = []

    chapters = []

    verses = []

    lines = []

    ids = []

    detailss = []

    poss = []

    excerpts = []

    messages = []

    locations = []

    new File(myFile).splitEachLine(',', { def fields ->
            prioritys.add(fields[0])

            chapters.add(fields[1])

            verses.add(fields[2])

            lines.add(fields[3])

            ids.add(fields[4])

            detailss.add(fields[5])

            poss.add(fields[6])

            excerpts.add(fields[7])

            messages.add(fields[8])

            locations.add(fields[9])
        })

    if (fileNum == 0) {
        // Test to see if there are more rows than just the header/labels row
        if (prioritys.size() > 1) {
            println('ERROR: Validation errors remain in csv file')

            CustomKeywords.'unfoldingWord_Keywords.SendMessage.SendFailMessage'('Test failed because validation errors remain in csv file.')

            println(newContent)
        } else {
            println('There are no validation errors in the csv file')
        }
    }
    
    WebUI.closeBrowser()
}

GlobalVariable.scriptRunning = false

WebUI.closeBrowser()
 // Get list of files in the Download folder
 // Add the validation files to a list
// Wait for the validation file to be downloaded
// Sort the list
// Get the name of the last (newest) file in the list

def getValidationFiles(def testFile) {
	
    List files = new File(dirName).list()
	
    vFiles = []

//	for (file in files) {
    files.each({ def file ->
            if (file.contains('Validation-' + testFile)) {
                vFiles.add(file)
            }
        })

    return vFiles
}

def runValidation(def initSize, def testFile) {
    WebUI.click(findTestObject('Page_tCC translationNotes/button_validate'))

    vSize = initSize

    while (vSize <= initSize) {
        WebUI.delay(5)

        vFiles = getValidationFiles(testFile)

        vSize = vFiles.size()
    }
    
    vFiles = vFiles.toSorted()

    myFile = (vFiles[(vFiles.size() - 1)])

    println('myFile:' + myFile)

    myFile = ((dirName + '/') + myFile)

    nFile = new File(myFile)

    newContent = nFile.text

    return [vSize, newContent, myFile]
}

def testOutput(testLines, baseFile, testFile) {
//	testLines = [4,6,7]
	
	baseLines = []
	new File(baseFile).eachLine({ def line ->
	//	println(line)
		baseLines.add(line)
	})
	
	newLines = []
	new File(testFile).eachLine({ def line ->
	//	println(line)
		newLines.add(line)
	})
	
	//for (baseLine in baseLines) {
	//for (line in testLines) {
	testLines.each({ def line ->
		for (newLine in newLines) {
			if (newLine == baseLines[line]) {
				println('ERROR: Validation file line ' + (line + 1) + ' [' + newLine + '] still exists after being fixed')
				CustomKeywords.'unfoldingWord_Keywords.SendMessage.SendFailMessage'('Test failed because validation file line ' + (line + 1) + ' [' + newLine + '] still exists after being fixed.')
			}
			
		}
	})
	
}
