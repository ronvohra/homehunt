package io.github.ronvohra;

import static javax.ws.rs.core.Response.ok;

import io.github.ronvohra.entity.Home;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.jboss.logmanager.Logger;

@Path("/homes")
@RequestScoped
public class HomeResource {
  private static final Logger LOG = Logger.getLogger(HomeResource.class.getName());

  @POST
  @Transactional
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public Response saveHome(@Valid Home home) {
    LOG.info("Received Home object with ");
    home.persist();
    return ok(Home.find("streetAddress", home.streetAddress).firstResult()).build();
  }

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public List<Home> getAllPosts() {
    return Home.listAll();
  }
}
