package ricash

import org.http4s.dsl._
import org.http4s.server.HttpService
import org.http4s.server.jetty.JettyBuilder

/**
  * Created by rslima on 09/11/15.
  */
object RicashApp {

  def main (args: Array[String]) {
    JettyBuilder.
      bindLocal(8080).
      mountService(service).
      run
  }

  def service = HttpService {
    case r @ GET -> Root ⇒
      Ok("It Works!")

  }

}
