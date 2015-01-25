package org.craftedsw.tripservicekata.trip

import org.craftedsw.tripservicekata.user.User
import org.craftedsw.tripservicekata.exception.UserNotLoggedInException

class TripService(tripDAO: ITripDAO = TripDAO) {

	def getTripsByUser(user: User, loggedInUser: Option[User]): List[Trip] = {
		loggedInUser match {
			case None => throw new UserNotLoggedInException
			case Some(loggedInUser) => findTripsFor(user, loggedInUser)
		}
	}

	def findTripsFor(user: User, loggedInUser: User): List[Trip] = {
		if (user.isFriendsWith(loggedInUser)) tripDAO.findTripsByUser(user) else List()
	}
}
