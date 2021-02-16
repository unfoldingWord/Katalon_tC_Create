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
import java.awt.datatransfer.StringSelection as StringSelection
import org.openqa.selenium.Keys as Keys

value = CustomKeywords.'unfoldingWord_Keywords.TestVersion.isVersionGreater'('1.0.3')

line = "792,21,37,2229,p5cd,Occurrence,,undefined,Invalid '11' occurrence field"

int[] commas = line.findIndexValues({
	it == ','
})

count = commas.size()
if (count < 7) {
	println('#################### not enough commas in line ' + line)
}

err = line.substring(commas[0]+1, commas[6])
println('err:' + err)

return false

nFile = '/Users/cckozie/Downloads/Validation-en_tn_42-MRK.tsv-2021-02-11T22_43_39.600Z.csv'

(newPrioritys, newErrors, newMessages) = parseFile(nFile)

bFile = '/Users/cckozie/git/Katalon/tC Create Project.save/Data Files/Validation-en_tn_42-MRK.tsv_base.csv'

(basePrioritys, baseErrors, baseMessages) = parseFile(bFile)

for (def row : (0 .. baseErrors.size()-1)) {
	fnd = false
	int[] found = newErrors.findIndexValues({
		it == baseErrors[row]
	})
//	println(found)
	if (found.size() > 0) {
		for (def i : (0 .. found.size()-1)) { 
			if (newPrioritys[found[i]] == basePrioritys[row] || newMessages[found[i]] == baseMessages[row]) {
				fnd = true
				println('row ' + row + ' was found')
			} else {
				println('row ' + row + ' was not found A')
			}
		}
	} else {
		println('row ' + row + ' was not found B')
	}
	if (!fnd) {
		println('the row was not found')
	}
}
	
def parseFile (aFile) {
	errs = []
	priors = []
	msgs = []
	
	File file = new File(aFile)
	file.withReader { reader ->
		while ((line = reader.readLine()) != null) {
			int[] commas = line.findIndexValues({
				it == ','
			})
			
			count = commas.size()
			if (count < 7) {
				println('#################### not enough commas in line ' + line)
			}
			
			err = line.substring(commas[0]+1, commas[6])
//			println('err:' + err)
			errs.add(err)
			
			prior = line.substring(0,commas[0])
//			println('prior:' + prior)
			priors.add(prior)
			
			if (count > 8) {
				msg = line.substring(commas[7]+1, commas[8])
			} else {
				msg = line.substring(commas[7]+1)
			}
//			println('msg:' + msg)
			msgs.add(msg)

//			println(prior + ':' + err + ':' + msg)
			
		}
	}
	return [priors,errs,msgs]
}
