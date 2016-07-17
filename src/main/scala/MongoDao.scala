import reactivemongo.api.collections.bson.BSONCollection
import reactivemongo.api.commands.WriteResult

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
/**
  * Created by nmupp on 7/9/16.
  */
class MongoDao {
  import MongoConnect._
  import FeatureReadAndWriteImplicits._

  def save(feature:Feature) = {
    //save feature to mongo and return the response
    val writeResult: Future[WriteResult] = db.flatMap(db => {
      val featuresCollection:BSONCollection = db("features")
      featuresCollection.insert(feature)
    })
    writeResult.map(result => {
      SuccessResponse("Document created",result.ok)
    })
  }
}
