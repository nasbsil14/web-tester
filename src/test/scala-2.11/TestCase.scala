import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import com.typesafe.config.{ConfigFactory, Config}
import org.openqa.selenium.WebDriver
import org.scalatest.selenium.WebBrowser

case class TestCase(targetUrl: String, commands: Seq[Command])(implicit val webDriver: WebDriver) extends WebBrowser {
  def start(): Unit = {
    go to targetUrl
    commands.foreach(cmd => cmd.exec())
  }
}

sealed abstract class Operation
object Operation {
  case object CLICK extends Operation

  case object ENTER extends Operation

  case object SUBMIT extends Operation

  case object CAPTURE extends Operation
}

case class Command(operation: Operation, target: Option[String], data: Option[String])(implicit val webDriver: WebDriver) extends WebBrowser {
  def exec(): Unit = {
    operation match {
      case Operation.CLICK => {
        target.foreach(s => click on s)
        println("click")
      }
      case Operation.ENTER => {
        data.foreach(s => enter(s))
        println("enter")
      }
      case Operation.SUBMIT => {
        submit()
        println("submit")
      }
      case Operation.CAPTURE => {
        val df:String = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"))
        //TODO ここだとPATHの前にデフォルトで「var/〜」とかついてうまくいかない
        println()
        capture to s"$df.png"
        println("capture")
      }
    }
  }
}
object Command {
  def apply(operation: String, target: String, data: String)(implicit webDriver: WebDriver): Command = {
    operation match {
      case "click" => Command(Operation.CLICK, Some(target), None)
      case "enter" => Command(Operation.ENTER, None, Some(data))
      case "submit" => Command(Operation.SUBMIT, None, None)
      case "capture" => Command(Operation.CAPTURE, None, None)
    }
  }
}
