package ricash.users

import doobie.imports._
import scalaz.concurrent.Task

import argonaut._
import Argonaut._

/**
  * Created by rslima on 12/11/15.
  */
object UserQueries {

  val xa = DriverManagerTransactor[Task]("org.postgresql.Driver","jdbc:postgresql://localhost/ricash","postgres","123456")

  val allUsers = sql"select * from ricash.tbl_user".query[User].list.transact(xa)

}
