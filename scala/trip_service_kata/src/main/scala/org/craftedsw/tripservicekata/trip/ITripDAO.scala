package org.craftedsw.tripservicekata.trip

import org.craftedsw.tripservicekata.user.User

trait ITripDAO {
  def findTripsByUser(user: User): List[Trip]
}
