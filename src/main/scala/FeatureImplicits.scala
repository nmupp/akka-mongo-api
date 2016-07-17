import reactivemongo.bson.{BSONDocument, BSONDocumentReader, BSONDocumentWriter}

/**
  * Created by nmupp on 7/9/16.
  */

case class Feature(name:String, featureType:String)

object FeatureReadAndWriteImplicits {
  implicit object FeatureReader extends BSONDocumentReader[Feature] {
    override def read(doc: BSONDocument): Feature = {
      Feature(
        doc.getAs[String]("name").get,
        doc.getAs[String]("featureType").get
      )
    }
  }

  implicit object FeatureWriter extends BSONDocumentWriter[Feature] {
    override def write(feature: Feature): BSONDocument = {
      BSONDocument(
        "name" -> feature.name,
        "featureType" -> feature.featureType
      )
    }
  }
}

