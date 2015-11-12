package ricash.users

import argonaut._
import Argonaut._

case class User(id: Long, name: String, email: String, password: String)

object User {
  implicit lazy val userCodec = casecodec4(User.apply, User.unapply)("id","name","email","password")
}

