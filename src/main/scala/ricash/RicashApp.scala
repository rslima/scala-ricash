package ricash

import org.http4s.ContentCoding
import org.http4s.StaticFile
import org.http4s.dsl._
import org.http4s.headers.`Content-Encoding`
import org.http4s.server.HttpService
import org.http4s.server.Router
import org.http4s.server.jetty.JettyBuilder
import org.http4s.argonaut._
import org.http4s.util.CaseInsensitiveString
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
      Ok(UserQueries.allUsers).putHeaders(`Content-Encoding`(ContentCoding(CaseInsensitiveString("UTF-8"))))
  }

  def rootService = HttpService {
    case r if r.pathInfo.startsWith("/webjars") ⇒
      StaticFile.fromResource("/META-INF/resources" + r.pathInfo, Some(r)).fold(NotFound())(Task.now)
    case r if r.pathInfo.endsWith("/") ⇒
      StaticFile.fromResource("/web" + r.pathInfo + "index.html", Some(r)).fold(NotFound())(Task.now)
    case r ⇒
      StaticFile.fromResource("/web" + r.pathInfo, Some(r)).fold(NotFound())(Task.now)
  }

}
