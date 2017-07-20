package ninja.sakib.kotlin.jersey.seed.services

import com.eclipsesource.json.JsonArray
import com.eclipsesource.json.JsonObject
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

/**
 * := Coded with love by Sakib Sami on 7/20/17.
 * := s4kibs4mi@gmail.com
 * := www.sakib.ninja
 * := Coffee : Dream : Code
 */

@Path("/hello")
class HelloService {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    fun welcomeMessage(): Response {
        val includedLibraries = JsonArray()
        includedLibraries.add("javax.ws.rs-api-2.1-m09")
        includedLibraries.add("jersey-client-2.25.1")
        includedLibraries.add("jersey-server-2.25.1")
        includedLibraries.add("jersey-common-2.25.1")
        includedLibraries.add("jersey-container-servlet-2.25.1")
        includedLibraries.add("jersey-container-servlet-core-2.25.1")
        includedLibraries.add("jetty-server-9.4.6.v20170531")
        includedLibraries.add("jetty-servlet-9.4.6.v20170531")
        includedLibraries.add("minimal-json-0.9.4")

        val result = JsonObject()
                .add("Topic", "Jersey RESTFull Webservice Seed")
                .add("Platform", "Java with Jetty Server")
                .add("Author", "Sakib Sami")
                .add("Email", "root@sakib.ninja")
                .add("Version", "0.0.1")
                .add("included", includedLibraries)

        return Response.status(200).entity(result.toString()).build()
    }
}
