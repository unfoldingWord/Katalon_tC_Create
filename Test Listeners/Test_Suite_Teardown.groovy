import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject

import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

import internal.GlobalVariable as GlobalVariable

import com.kms.katalon.core.annotation.BeforeTestCase
import com.kms.katalon.core.annotation.BeforeTestSuite
import com.kms.katalon.core.annotation.AfterTestCase
import com.kms.katalon.core.annotation.AfterTestSuite
import com.kms.katalon.core.context.TestCaseContext
import com.kms.katalon.core.context.TestSuiteContext

class Test_Suite_Teardown {
	/**
	 * Executes after every test suite ends.
	 * @param testSuiteContext: related information of the executed test suite.
	 */
	@AfterTestSuite
	def sampleAfterTestSuite(TestSuiteContext testSuiteContext) {
		String separator = 'vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv'
		println(separator)
		String prefix = '>>>>>>>>>'
		boolean hdr = false
		boolean first = true
		boolean error = false
//		println(GlobalVariable.tsMessages)
//		println('hdr is '+hdr)
//		println('first is '+ first)
//		println('error is '+error)
		for (def i : (0..GlobalVariable.tsMessages.size()-1)) {
//			println(i)
		
			if (GlobalVariable.tsMessages[i].length() > 2) {
//				println('more than 2')
//				println('hdr is '+hdr)
//				println('first is '+ first)
//				println('error is '+error)
				if (GlobalVariable.tsMessages[i][0..1] == '##') {
//					println('##')
//					println('hdr is '+hdr)
//					println('first is '+ first)
//					println('error is '+error)
					if (!first) {
//						println('not first')
//						println('hdr is '+hdr)
//						println('first is '+ first)
//						println('error is '+error)
						if (hdr) {
//							println('hdr')
//							println('hdr is '+hdr)
//							println('first is '+ first)
//							println('error is '+error)
							println('+++++++++++++++++++ PASSED +++++++++++++++++++++')
							error = false
						}
						println('\n        ----------------------------------------\n')
					}
					println(prefix + GlobalVariable.tsMessages[i][2..GlobalVariable.tsMessages[i].length()-1])
					hdr = true
					first = false
//					println('hdr is '+hdr)
//					println('first is '+ first)
//					println('error is '+error)
				} else {
//					println('not ##')
//					println('hdr is '+hdr)
//					println('first is '+ first)
//					println('error is '+error)
					println(GlobalVariable.tsMessages[i])
					hdr = false
					error = true
				}
			} else {
//				println('less than 2')
//				println('hdr is '+hdr)
//				println('first is '+ first)
//				println('error is '+error)
				println(GlobalVariable.tsMessages[i])
				hdr = false
			}
			if (error) {
//				println('error')
//				println('hdr is '+hdr)
//				println('first is '+ first)
//				println('error is '+error)
				println('******************* FAILED *********************')
				error = false
			}
		}
		if (hdr) {
//			println('hdr 2')
//			println('hdr is '+hdr)
//			println('first is '+ first)
//			println('error is '+error)
			println('+++++++++++++++++++ PASSED +++++++++++++++++++++')
		} 
		
	println('^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^')
	}
}