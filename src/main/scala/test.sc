import akka.http.scaladsl.model.HttpMethods
import akka.http.scaladsl.server.Route
import akka.http.scaladsl.server.Directives._

val a:Route = ctx => {
 if(ctx.request.method == HttpMethods.GET)
   ctx.complete("GET")
 else
   ctx.complete("Something else")
}

val route1 = get {
  complete("get")
} ~
 complete("other thing")