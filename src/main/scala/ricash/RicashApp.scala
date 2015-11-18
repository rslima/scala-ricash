package ricash

import org.http4s.StaticFile
import org.http4s.dsl._
import org.http4s.server.HttpService
import org.http4s.server.Router
import org.http4s.server.jetty.JettyBuilder
import org.http4s.argonaut._
import ricash.users.UserQueries
import ricash.users.User

import scalaz.concurrent.Task

/**
  * Created by rslima on 09/11/15.
  */
object RicashApp {

  implicit lazy val userEntityEncoder = jsonEncoderOf[List[User]]

  def main (args: Array[String]) {
    JettyBuilder.
      bindLocal(8080).
      mountService(service).
      run
  }

  def service: HttpService = Router("/api" → apiService, "" → rootService)

  def apiService = HttpService {
    case r @ GET -> Root ⇒
      Ok(UserQueries.allUsers)
  }

  def rootService = HttpService {
    case r if r.pathInfo.endsWith("/") ⇒
      StaticFile.fromResource(r.pathInfo + "index.html", Some(r)).fold(NotFound())(Task.now)
    case req ⇒
      StaticFile.fromResource(req.pathInfo, Some(req)).fold(NotFound())(Task.now)
  }

}
