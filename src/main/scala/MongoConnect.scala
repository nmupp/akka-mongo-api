import reactivemongo.api._
import scala.concurrent.ExecutionContext.Implicits.global

/**
  * Created by nmupp on 7/9/16.
  */
object MongoConnect {
  val driver = new MongoDriver
  val connection = driver.connection(List("localhost"))
  val db = connection.database("field-operations")
}
