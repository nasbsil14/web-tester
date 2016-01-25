import scala.io.Source

trait DocumentReader {
  lazy val fileName = DocumentReader.fileName

  def read() = ???
  def createCommandList: List[Command] = ???
}
class TextReader extends DocumentReader {
  override def createCommandList: Seq[Command] = {
    Source.fromFile(fileName).getLines().map {line =>
      line match {
        case "" => Command(Operation.CLICK,Some(""),Some(""))
        case "" => Command(Operation.CLICK,Some(""),Some(""))
        case "" => Command(Operation.CLICK,Some(""),Some(""))
      }
    }.toSeq
  }
}
class ExcelReader extends DocumentReader {
  override def createCommandList: List[Command] = ???
}
object DocumentReader {
  val fileName = Setting.conf.getString("testcase_file")
  def reader: DocumentReader = {
    new TextReader
  }
}