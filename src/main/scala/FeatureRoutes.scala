import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import akka.http.scaladsl.server.Directives._
import spray.json._

/**
  * Created by nmupp on 7/6/16.
  */
trait JsonSupport extends SprayJsonSupport with DefaultJsonProtocol {
  implicit val successResponse = jsonFormat2(SuccessResponse)
  implicit val featureFormat = jsonFormat2(Feature)
}

class FeatureRoutes(featureService: FeatureService) extends JsonSupport {

  import featureService._

  val routes =
    path("feature") {
      get {
        complete("get feature")
      } ~
        post {
          entity(as[Feature]) { feature =>
            onSuccess(addFeature(feature)) {
              case response => complete(response)
            }
          }
        } ~
        delete {
          complete("delete feature")
        }
    }
}