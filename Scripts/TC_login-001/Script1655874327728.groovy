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
import org.testng.Assert as Assert

simpletestdata = findTestData('Data Files/1st test modified')

String url = simpletestdata.getObjectValue(3, 1)

WebUI.openBrowser(url) 

WebUI.maximizeWindow()   

WebUI.click(findTestObject('Object Repository/repos/a_Accept'))    

WebUI.click(findTestObject('Object Repository/repos/a_Register'))

String username = simpletestdata.getObjectValue(1, 1)

WebUI.setText(findTestObject('Object Repository/repos/emailtxtfld'), username)

String password = simpletestdata.getObjectValue(2, 1)

WebUI.setText(findTestObject('Object Repository/repos/pwdtxtfld'), password)

WebUI.delay(3)

WebUI.click(findTestObject('Object Repository/repos/loginbtn'))

String usernametextverify = simpletestdata.getObjectValue(4, 1)

WebUI.verifyTextPresent(usernametextverify, false)

textpresent = usernametextverify

expectedtext = WebUI.getText(findTestObject('Object Repository/repos/checkusername'))

println(expectedtext)

Assert.assertEquals(expectedtext, textpresent)

WebUI.click(findTestObject('Object Repository/repos/checkusername'))

WebUI.waitForPageLoad(5)

verifypagecontent = WebUI.getText(findTestObject('Object Repository/repos/check page content'))

String pagecontentverify = simpletestdata.getObjectValue(5, 1)

Assert.assertEquals(verifypagecontent, pagecontentverify)

WebUI.click(findTestObject('Object Repository/repos/click continue shopping'))

//homepagetitle = 'https://uat-live-products.metcal.com/INTERSHOP/web/WFS/OKI-METCAL-Site/en_US/-/GBP/ViewHomepage-Start'
windowtitle = WebUI.getWindowTitle()

String verifypagetitle = simpletestdata.getObjectValue(6, 1)

if (windowtitle.contains(verifypagetitle)) {
    println('code is passed')
} else {
    println('failed')
}

Region = WebUI.getText(findTestObject('Object Repository/repos/Region check'))

println('The region is --'+Region.trim())

WebUI.mouseOver(findTestObject('Object Repository/repos/checkusername'))

WebUI.click(findTestObject('Object Repository/repos/logout'))

WebUI.waitForPageLoad(7)

WebUI.click(findTestObject('Object Repository/repos/a_Register'))

String username1 = simpletestdata.getObjectValue(1, 2)

WebUI.setText(findTestObject('Object Repository/repos/emailtxtfld'), username1)

String password1 = simpletestdata.getObjectValue(2, 2)

WebUI.setText(findTestObject('Object Repository/repos/pwdtxtfld'), password1)

WebUI.delay(2)

WebUI.click(findTestObject('Object Repository/repos/loginbtn'))

String usernametextverify1 = simpletestdata.getObjectValue(4, 2)

expectedusername = WebUI.getText(findTestObject('Object Repository/repos/checkusername'))

Assert.assertEquals(expectedusername, usernametextverify1)

WebUI.click(findTestObject('Object Repository/repos/checkusername'))

String usernamevalidate1 = simpletestdata.getObjectValue(5, 2)

expectedname = WebUI.getText(findTestObject('Object Repository/repos/check page content1'))

Assert.assertEquals(expectedname, usernamevalidate1)

WebUI.click(findTestObject('Object Repository/repos/click continue shopping'))

windowtitle1 = WebUI.getWindowTitle()

String verifypagetitle1 = simpletestdata.getObjectValue(6, 2)

if (windowtitle1.contains(verifypagetitle1)) {
    println('you are on homepage')
} else {
    println('failed')
}

Region1 = WebUI.getText(findTestObject('Object Repository/repos/Region check'))

println('The region is --'+Region1.trim())

WebUI.closeBrowser()

