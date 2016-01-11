import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

import com.typesafe.config.{ConfigFactory, Config}
import org.scalatest.{FlatSpec, BeforeAndAfterAll, FunSpec}
import org.scalatest.Matchers._

import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.ui.{ ExpectedCondition, WebDriverWait }

class TestSeleniumSpec extends FlatSpec
with BeforeAndAfterAll
with TestDriver {
  val conf: Config = ConfigFactory.load()
  val testCase: TestCase = createTestCase()

  it should "Google Search" in {
    val commands: Seq[Command] = Seq(Command("click","q",""), Command("enter","","Cheese!"), Command("capture","",""))
//    commands :+ Command("click","q","")
//    commands :+ Command("enter","","Cheese!")
//    commands :+ Command("capture","","")

    println(commands.length)

    val testCase = TestCase("https://www.google.co.jp/", commands)
    testCase.testStart()

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
    setCaptureDir(conf.getString("selenium.capture_dir"))
  }
  override def afterAll(): Unit = {
    println("after")
    quit()
  }
  def createTestCase(): TestCase = {
    val commands: Seq[Command] = Nil
    TestCase("", commands)
  }
}