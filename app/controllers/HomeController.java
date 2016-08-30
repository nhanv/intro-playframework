package controllers;

import models.Person;

import play.data.Form;
import com.avaje.ebean.Model;
import play.mvc.*;

import views.html.*;

import java.util.List;

import static play.libs.Json.toJson;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {

    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
    public Result index() {
        return ok(index.render("Hello World."));
    }

    public Result addPerson() {
    	Person person = Form.form(Person.class).bindFromRequest().get();
    	
    	System.out.println(person.name);

    	//person.save();
    	return redirect(routes.HomeController.index());
    }

    public Result getPerson() {
    	List<Person> persons = new Model.Finder(String.class, Person.class).all();
    	return ok(toJson(persons));
    }

}
