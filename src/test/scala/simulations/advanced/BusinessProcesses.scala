package simulations.advanced

import io.gatling.core.Predef._
import io.gatling.http.Predef._

import scala.concurrent.duration._

object AdvancedSearch {
  val feeder = csv("search.csv").random

  val search =
    exec(http("home")
    .get("/"))
    .pause(1 second)
    .feed(feeder)
    .exec(http("search")
    .post("/search")
    .body(StringBody("${searchCriterion}"))
    .check(bodyString.is("${searchResult}")))
}

object AdvancedItem {

  val item = repeat(5, "n") {
    exec(http("Item ${n}")
      .get("/item")
      .queryParam("itemId", "${n}"))
  }

}