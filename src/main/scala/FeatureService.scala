import scala.concurrent.{Future}
import scala.concurrent.ExecutionContext.Implicits.global

/**
  * Created by nmupp on 7/8/16.
  */
class FeatureService(mongoDao:MongoDao) {

  import mongoDao._

  def addFeature(feature:Feature) = {
    //create a future
    save(feature)
  }
}
