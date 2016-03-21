package simulations.standard

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._

class StandardSimulation extends Simulation {

  val httpConf = http
    .baseURL("http://localhost:5687")
    .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
    .doNotTrackHeader("1")
    .acceptLanguageHeader("en-US,en;q=0.5")
    .acceptEncodingHeader("gzip, deflate")
    .userAgentHeader("Mozilla/5.0 (Windows NT 5.1; rv:31.0) Gecko/20100101 Firefox/31.0")

  val scn = scenario("StandardSimulation").exec(Search.search, Items.items, Item.item, Create.create)

  setUp(
    scn.inject(rampUsers(100) over (5 seconds))
  ).protocols(httpConf)
}