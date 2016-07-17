import akka.actor.ActorSystem
import akka.stream.ActorMaterializer
import akka.http.scaladsl.Http

/**
  * Created by nmupp on 7/6/16.
  */
object FeatureServer {
  def main(args:Array[String]) {
    implicit val system = ActorSystem("field-system")
    implicit val materializer = ActorMaterializer()
    implicit val executionContext = system.dispatcher

    val mongoDao = new MongoDao()
    val featureService = new FeatureService(mongoDao)
    val featureRoutes = new FeatureRoutes(featureService)

    Http().bindAndHandle(featureRoutes.routes, "localhost", 8080)
  }
}
