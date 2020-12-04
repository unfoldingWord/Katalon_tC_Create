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


// Get list of files in the Download folder
String dirName = "/Users/cckozie/Downloads" 
List files = new File(dirName).list()

// Add the validation files to a list
vFiles = []
files.each({ file ->
	if (file.contains('Validation-en_tn_57-TIT.tsv')) {
		vFiles.add(file)
	}
})

// Sort the list
println(vFiles)
vFiles = vFiles.toSorted()
vFiles.each({ file ->
	println(file)
})

// Get the name of the last (newest) file in the list
myFile = vFiles[vFiles.size()-1]
println(myFile)

// Read the file
// Columns = [Priority,Chapter,Verse,Line,Row ID,Details,Char Pos,Excerpt,Message,Location]
prioritys = []; chapters = []; verses = []; lines = []; ids = []; detailss = []; poss = []; excerpts = []; messages = []; locations = []
File new File(dirName + '/' + myFile).splitEachLine(',', { def fields ->
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
