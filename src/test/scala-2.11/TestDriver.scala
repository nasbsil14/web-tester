import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.ie.InternetExplorerDriver
import org.openqa.selenium.safari.SafariDriver
import org.scalatest.selenium.{Driver, WebBrowser}
import com.typesafe.config.{Config, ConfigFactory}

trait TestDriver extends WebBrowser with Driver {
  implicit val webDriver: WebDriver = TestDriver.driver
}

object TestDriver {
  val conf:Config = ConfigFactory.load()
  val driver: WebDriver = selectDriver

  private def selectDriver(): WebDriver = {
    Option(conf.getString("selenium.browser")).map { _.toLowerCase } match {
      case Some("chrome") => {
        //System.setProperty("webdriver.chrome.driver","""/users/nasb/downloads/chromedriver""")
        new ChromeDriver
      }
      case Some("firefox") => new FirefoxDriver
      case Some("safari") => new SafariDriver
      case Some("ie") => new InternetExplorerDriver
      case _ => new FirefoxDriver
    }
  }
}