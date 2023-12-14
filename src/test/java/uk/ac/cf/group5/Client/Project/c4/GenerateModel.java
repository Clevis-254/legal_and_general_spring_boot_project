package uk.ac.cf.group5.Client.Project.c4;

import com.structurizr.Workspace;
import com.structurizr.analysis.ComponentFinder;
import com.structurizr.analysis.ReferencedTypesSupportingTypesStrategy;
import com.structurizr.analysis.SpringComponentFinderStrategy;
import com.structurizr.api.StructurizrClient;
import com.structurizr.model.*;
import com.structurizr.view.*;
import org.junit.jupiter.api.Test;

public class GenerateModel {

    private final static int WORKSPACE_ID = 88554;
    private final static String API_KEY = "3f2babfa-a3cd-45f3-a998-6399d91ebca5";
    private final static String API_SECRET = "36c26b22-0cd3-4f84-94ba-627c73bd9655";

    @Test
    public void generateModel() throws Exception {
        //set up workspace and model
        // these are the core objects of our workspace
        Workspace workspace = new Workspace("Client project",
                "the client project used for the 2023/2024 assessment");
        Model model = workspace.getModel();

        // create the basic model (the stuff we can't get from the code)
        SoftwareSystem ReviewSystem = model.addSoftwareSystem("360 review", "a 360 review system where " +
                "an employee is able to get their 360 form review");
        Person admin = model.addPerson("HR personel", "The person who manages the 360's requests");
        Person user = model.addPerson("Employee personel", "The person who makes a " +
                "360's requests and gets their results");
        Person contact = model.addPerson("reviewer", "The person who does a review to the employee");


        admin.uses(ReviewSystem, "Uses");
        user.uses(ReviewSystem, "Uses");
        contact.uses(ReviewSystem, "Uses");


        Container webApplication = ReviewSystem.addContainer(
                "Spring Boot Application", "The web application", "Embedded web container.  Tomcat 7.0");
        Container relationalDatabase =ReviewSystem.addContainer(
                "Relational Database", "Stores information regarding the products.", "MySQL");
        admin.uses(webApplication, "Uses", "HTTP");
        user.uses(webApplication, "Uses", "HTTP");
        contact.uses(webApplication, "Uses", "HTTP");

        webApplication.uses(relationalDatabase, "Reads from and writes to", "JDBC, port 3306");

        // and now automatically find all Spring @Controller, @Component, @Service and @Repository components
        ComponentFinder componentFinder = new ComponentFinder(
                webApplication,
                "uk.ac.cf.group5.Client.Project",
                new SpringComponentFinderStrategy(
                        new ReferencedTypesSupportingTypesStrategy()
                ));

        componentFinder.findComponents();

        webApplication.getComponents().stream()
                .filter(c ->
                        c.getTechnology().equals(SpringComponentFinderStrategy.SPRING_REPOSITORY))
                .forEach(c -> c.uses(relationalDatabase, "Reads from and writes to", "JDBC"));

        ViewSet viewSet = workspace.getViews();
        SystemContextView contextView =viewSet.createSystemContextView(ReviewSystem, "context",
                "The SystemContext diagram for the 360's review system");
        contextView.addAllSoftwareSystems();
        contextView.addAllPeople();
        contextView.enableAutomaticLayout();

        ContainerView containerView = viewSet.createContainerView(ReviewSystem,"containers",
                "The Containers diagram for  the 360's review system");
        containerView.addAllPeople();

        containerView.addAllSoftwareSystems();
        containerView.addAllContainers();
        containerView.enableAutomaticLayout();

        ComponentView componentView =viewSet.createComponentView(webApplication, "components",
                "TheComponents diagram for the 360's review system");
        componentView.addAllComponents();
        componentView.addAllPeople();
        componentView.add(relationalDatabase);
        componentView.enableAutomaticLayout();

        ReviewSystem.addTags("360 review 2023");
        webApplication.getComponents().stream().filter(c ->
                c.getTechnology().equals(SpringComponentFinderStrategy.SPRING_MVC_CONTROLLER))
                .forEach(c -> c.addTags("Spring MVC Controller"));
        webApplication.getComponents().stream().filter(c ->
                c.getTechnology().equals(SpringComponentFinderStrategy.SPRING_MVC_CONTROLLER))
                .forEach(c -> c.addTags("Spring REST Controller"));
        webApplication.getComponents().stream().filter(c ->
                c.getTechnology().equals(SpringComponentFinderStrategy.SPRING_SERVICE))
                .forEach(c -> c.addTags("Spring Service"));
        webApplication.getComponents().stream().filter(c ->
                c.getTechnology().equals(SpringComponentFinderStrategy.SPRING_REPOSITORY))
                .forEach(c -> c.addTags("Spring Repository"));
        relationalDatabase.addTags("Database");

        Styles styles = viewSet.getConfiguration().getStyles();
        styles.addElementStyle("Lots of Spam2023").background("#6CB33E").color("#ffffff");
        styles.addElementStyle(Tags.PERSON).background("#519823").color("#ffffff").shape(Shape.Person);
        styles.addElementStyle(Tags.CONTAINER).background("#91D366").color("#ffffff");

        styles.addElementStyle("Database").shape(Shape.Cylinder);
        styles.addElementStyle("Spring RESTController").background("#D4FFC0").color("#000000");
        styles.addElementStyle("Spring MVCController").background("#D4F3C0").color("#000000");
        styles.addElementStyle("SpringService").background("#6CB33E").color("#000000");
        styles.addElementStyle("SpringRepository").background("#95D46C").color("#000000");

        StructurizrClient structurizrClient = new StructurizrClient(API_KEY,API_SECRET);
        structurizrClient.putWorkspace(WORKSPACE_ID, workspace);
    }
}
