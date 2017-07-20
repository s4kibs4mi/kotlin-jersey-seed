package ninja.sakib.kotlin.jersey.seed

import ninja.sakib.kotlin.jersey.seed.services.HelloService
import org.eclipse.jetty.server.Server
import org.eclipse.jetty.servlet.ServletContextHandler
import org.glassfish.jersey.servlet.ServletContainer
import java.lang.Exception

/**
 * := Coded with love by Sakib Sami on 7/20/17.
 * := s4kibs4mi@gmail.com
 * := www.sakib.ninja
 * := Coffee : Dream : Code
 */

fun main(args: Array<String>) {
    val API_BASE_PATH = "/api/v1"
    val SERVER_PORT = 9090

    val servletContextHandler = ServletContextHandler(ServletContextHandler.NO_SESSIONS)
    servletContextHandler.contextPath = API_BASE_PATH

    val jettyServer = Server(SERVER_PORT)
    jettyServer.handler = servletContextHandler

    val jerseyServletHolder = servletContextHandler.addServlet(ServletContainer::class.java, "/*")
    jerseyServletHolder.initOrder = 0

    val jerseyServletParams = mutableMapOf<String, String>()
    jerseyServletParams.put("jersey.config.server.provider.packages", HelloService::class.java.`package`.name)

    jerseyServletHolder.initParameters = jerseyServletParams

    try {
        jettyServer.start()
        println("Jetty server with jersey has been started [port=$SERVER_PORT].")
        println("Open Browser @ http://localhost:$SERVER_PORT$API_BASE_PATH/hello")
    } catch (e: Exception) {
        println("Failed to start jetty server.")
    }
}
