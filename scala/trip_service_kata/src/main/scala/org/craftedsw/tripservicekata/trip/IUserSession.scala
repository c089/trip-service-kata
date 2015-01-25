package org.craftedsw.tripservicekata.trip

import org.craftedsw.tripservicekata.user.User

trait IUserSession {
  def getLoggedUser(): Option[User]
}
