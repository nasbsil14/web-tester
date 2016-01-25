import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

import org.scalatest.{FlatSpec, BeforeAndAfterAll, FunSpec}
import org.scalatest.Matchers._

import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.ui.{ ExpectedCondition, WebDriverWait }

class TestSeleniumSpec extends FlatSpec with BeforeAndAfterAll with TestDriver {

  it should "Google Search" in {
    val reader = DocumentReader.reader
    val commands: Seq[Command] = reader.createCommandList
//    val commands: Seq[Command] = Seq(
//      Command("click","q","")
//      , Command("enter","","Cheese!")
//      , Command("capture","","")
//    )

    println(commands.length)

    val testCase: TestCase = TestCase("https://www.google.co.jp/", commands)
    testCase.setCaptureDir(Setting.conf.getString("selenium.capture_dir"))
    testCase.start()

//    go to ("https://www.google.co.jp/")
//
//    pageTitle should be("Google")
//
//    click on "q"
//    enter("Cheese!")
//    submit()
//
//    (new WebDriverWait(webDriver, 10)).until(new ExpectedCondition[Boolean] {
//      override def apply(d: WebDriver): Boolean =
//        d.getTitle.toLowerCase.startsWith("cheese!")
//    })
//
//    pageTitle should be("Cheese! - Google 検索")
//
//    val df:String = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"))
//    capture to conf.getString("selenium.capture_dir") + s"$df.png"
  }

  override def beforeAll(): Unit = {
    println("before")
    //println(System.getProperty("webdriver.chrome.driver"))
    //setCaptureDir(Setting.conf.getString("selenium.capture_dir"))
  }
  override def afterAll(): Unit = {
    println("after")
    quit()
  }
}