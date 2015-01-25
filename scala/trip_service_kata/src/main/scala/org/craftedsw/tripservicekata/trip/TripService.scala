package org.craftedsw.tripservicekata.trip

import org.craftedsw.tripservicekata.user.{UserSession, User}
import org.craftedsw.tripservicekata.exception.UserNotLoggedInException

class TripService(tripDAO: ITripDAO = TripDAO, userSession: IUserSession = UserSession) {

	def getTripsByUser(user: User): List[Trip] = {
		userSession.getLoggedUser() match {
			case None => throw new UserNotLoggedInException
			case Some(loggedInUser) => findTripsFor(user, loggedInUser)
		}
	}

	def findTripsFor(user: User, loggedInUser: User): List[Trip] = {
		if (user.isFriendsWith(loggedInUser)) tripDAO.findTripsByUser(user) else List()
	}
}
