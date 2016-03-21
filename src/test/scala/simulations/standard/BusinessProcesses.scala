package simulations.standard

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._

object Search {
  val search = exec(http("home")
    .get("/"))
    .pause(1 second)
  exec(http("search")
    .post("/search")
    .body(StringBody("search pattern")))
}

object Items {
  val items = exec(http("items")
    .get("/items"))
}

object Item {
  val item = exec(http("item")
    .get("/item")
    .queryParam("itemId", 1))
}

object Create {
  val create = exec(http("create")
    .post("/create")
    .body(RawFileBody("myfile.txt")))
}