package ricash

import org.http4s.dsl._
import org.http4s.server.HttpService
import org.http4s.server.jetty.JettyBuilder
import org.http4s.argonaut._
import ricash.users.UserQueries
import ricash.users.User

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

  def service = HttpService {
    case r @ GET -> Root ⇒
      Ok(UserQueries.allUsers)

  }

}
