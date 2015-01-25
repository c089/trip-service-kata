package org.craftedsw.tripservicekata.user

import org.craftedsw.tripservicekata.exception.CollaboratorCallException
import org.craftedsw.tripservicekata.trip.IUserSession

object UserSession extends IUserSession {

	override def getLoggedUser(): Option[User] = {
		throw new CollaboratorCallException(
			"UserSession.getLoggedUser() should not be called in an unit test");
	}

}
