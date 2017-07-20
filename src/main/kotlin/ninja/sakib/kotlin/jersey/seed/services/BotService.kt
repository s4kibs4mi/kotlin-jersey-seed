package ninja.sakib.kotlin.jersey.seed.services

import com.eclipsesource.json.JsonObject
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.PathParam
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

/**
 * := Coded with love by Sakib Sami on 7/20/17.
 * := s4kibs4mi@gmail.com
 * := www.sakib.ninja
 * := Coffee : Dream : Code
 */

@Path("/bot")
class BotService {

    @GET
    @Path("/{who}")
    @Produces(MediaType.APPLICATION_JSON)
    fun dummy(@PathParam("who") who: String): Response {
        val result = JsonObject()
                .add("Who", who)

        return Response.status(200).entity(result).build()
    }
}
