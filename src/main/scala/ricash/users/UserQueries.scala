package ricash.users

import doobie.imports._
import scalaz.concurrent.Task

import argonaut._
import Argonaut._

/**
  * Created by rslima on 12/11/15.
  */
object UserQueries {

  val xa = DriverManagerTransactor[Task]("org.postgresql.Driver","jdbc:postgresql://localhost/ricash","postgres","esiq188")

  val allUsers = sql"select * from ricash.tbl_user".query[User].process.transact(xa).map(_.asJson.spaces4)

}
