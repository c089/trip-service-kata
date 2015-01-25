package org.craftedsw.tripservicekata.trip

import org.craftedsw.tripservicekata.exception.UserNotLoggedInException
import org.craftedsw.tripservicekata.infrastructure.UnitSpec
import org.craftedsw.tripservicekata.user.User

class TripServiceSpec extends UnitSpec {

  it should "throw for guests" in {
    val service = new TripService()
    a[UserNotLoggedInException] shouldBe thrownBy { service.getTripsByUser(null, None) }
  }

  it should "return an empty list if the logged in users is not friends with the user" in {
    val loggedInUser = new User()
    val otherUser: User = new User()
    val service: TripService = new TripService()

    service.getTripsByUser(otherUser, Some(loggedInUser)) shouldBe empty
  }

  it should "return the other users trips if he is friends with the logged in user" in {
    val loggedInUser = new User()
    val otherUser = new User()
    val trips: List[Trip] = List(new Trip())
    val tripDao = mock[ITripDAO]
    val service = new TripService(tripDao)

    otherUser.addFriend(loggedInUser)
    (tripDao.findTripsByUser(_)).expects(otherUser).returns(trips)

    service.getTripsByUser(otherUser, Some(loggedInUser)) shouldBe trips
  }

}
