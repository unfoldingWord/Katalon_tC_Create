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
import com.kms.katalon.core.configuration.RunConfiguration as RC
import java.io.File


//def executionProfile = RC.getExecutionProfile()

//WebUI.comment("executionProfile=${executionProfile}")
if (1 == 2) {
	String bs = $/ab\c/$
	
	println(bs)
	
	println((char)65)
	
	int a = 1
	a += 64
	println((char)a)
	 
	//int pos1 = path1.lastIndexOf(bs)
	
	GlobalVariable.version = 'translationCore Create - v1.0.4.rc-2'
	
	println(CustomKeywords.'unfoldingWord_Keywords.TestVersion.isVersionGreater'('1.0.5'))
}
origString = 'πάντα καθαρὰ τοῖς καθαροῖς; τοῖς δὲ μεμιαμμένοις καὶ ἀπίστοις, οὐδὲν καθαρόν; ἀλλὰ μεμίανται αὐτῶν καὶ ὁ νοῦς, καὶ ἡ συνείδησις.'
elips = '…'
origQuote = 'τοῖς…μεμιαμμένοις καὶ ἀπίστοις, οὐδὲν καθαρόν'
//words = []
//words = (origQuotes).split('…| ')
finds = origString.count('τοῖς')
println('finds is ' + finds)
ellipsis = origQuote.contains('…')
println(ellipsis)

elpLoc = origQuote.indexOf(elips)
preWords = origQuote.substring(0,elpLoc)
println(preWords)
postWords = origQuote.substring(elpLoc + 1)
println(postWords)

return false

data = 'χρηστότης καὶ ἡ φιλανθρωπία ἐπεφάνη τοῦ Σωτῆρος ἡμῶν, Θεοῦ'
ellipsis = data.contains('…')
println(ellipsis)
words = []
words = data.split('…| ')

details = true
data = ''
words = []
words = data.split('…| ')
numWords = words.size()
if (details) {
	println('words = ' + words)
	println('There are ' + numWords + ' words in the quote string')
}
if (numWords > 0) {
	println('greater')
} else {
	println('not greater')
}
if (!words.isEmpty()) {
	println('not empty')
} else {
	println('empty')
}

d1 = 'δεῖ γὰρ τὸν ἐπίσκοπον ἀνέγκλητον εἶναι ὡς Θεοῦ οἰκονόμον μὴ αὐθάδη μὴ ὀργίλον μὴ πάροινον μὴ πλήκτην μὴ αἰσχροκερδῆ'
d2 = 'μὴ πάροινον'

oqs = 'κατὰ πίστιν'
olString = 'Παῦλος δοῦλος Θεοῦ ἀπόστολος δὲ Ἰησοῦ Χριστοῦ κατὰ πίστιν ἐκλεκτῶν Θεοῦ καὶ ἐπίγνωσιν ἀληθείας τῆς κατ’ εὐσέβειαν'


w = d1.indexOf(d2)
println('w is at ' + w)

spaces = d1.count(' ')
println('there are ' + spaces + 'spaces')

left = d1.substring(0,w)
println(left)
spaces = left.count(' ')
println('there are ' + spaces + 'spaces')

right = d1.substring(w + d2.length()+1, d1.length()-1)
println(right)
spaces = right.count(' ')
println('there are ' + spaces + 'spaces')

