import com.typesafe.config.{ConfigFactory, Config}

object Setting {
  val conf: Config = ConfigFactory.load()
}
