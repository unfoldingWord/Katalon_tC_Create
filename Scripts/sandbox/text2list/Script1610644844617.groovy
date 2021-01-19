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
import groovy.time.*

pList = [109,'Priority',916]
println(pList)
pList = pList.sort()
println(pList)

content = 'a'
newContent = ''

println(content.length())
println(newContent.length())
if (newContent == '') {
	println('empty')
}
if (newContent == null) {
	println('null')
}

return false

startTime = new Date()

println(startTime)

WebUI.delay(3)

endTime = new Date()

println(endTime)

//elapsedTime = Duration.between(endTime, startTime)
TimeDuration elapsedTime = TimeCategory.minus(endTime, startTime)

//elapsedTime = elapsedTime.format('hh:mm:ss')

println(elapsedTime)

return false

fixedRows = [0,3]

for (def i : (0..5)) {
	if (i in fixedRows) {
		println(i +' was found')
	} else {
		println(i + ' was not found')
	}
}
return false

myFile = '/Users/cckozie/Downloads/Validation-en_tn_15-EZR.tsv-2021-01-14T17_06_07.059Z.csv'

baseFile = '/Users/cckozie/git/Katalon/tC Create Project/Data Files/Validation-en_tn_15-EZR.tsv_base.csv'

newLines = removeExcerpts(myFile)

newLines.each({ def line ->
	println(line)
})

baseLines = removeExcerpts(baseFile)

fixedRows = []	// New array to hold the index of base file rows that no longer appear in the validation file - assume they're fixed
l = 0
//	for (line in baseLines) {
	baseLines.each({ def line ->
		println(line)
		if (!newLines.contains(line)) {
////                errorFlag = true
			fixedRows.add(l)
			msg = ('The error in row ' + (l+1) + ' in ' + baseFile + ' is no longer flagged by the validator.' )
			println(msg)
//			CustomKeywords.'unfoldingWord_Keywords.SendMessage.SendInfoMessage'(msg)
		} else {
			println('row ' + l + ' was found')
		}
		l ++
	})


//lines.each({ line ->
//	println(line)
//})


def removeExcerpt(myFile) {
	lines = []
	new File(myFile).splitEachLine('\\12', { def fields ->
		lines.add(fields[0])
	})
	lines.each({ def line ->
		int [] commas = line.findIndexValues {
			it == ','
		}
		line = line.substring(0,commas[6]) + line.substring(commas[7])
	})
	return lines
}

def removeExcerpts(myFile) {
	lines = []
	new File(myFile).splitEachLine('\\12', { def fields ->
		line = fields[0]
		int [] commas = line.findIndexValues {
			it == ','
		}
		line = line.substring(0,commas[6]) + line.substring(commas[7])
		lines.add(line)
	})
	return lines
}
