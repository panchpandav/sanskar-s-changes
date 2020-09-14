import com.google.inject.Guice;
import com.google.inject.Injector;
import health.CollegeSuiteHealthCheck;
import io.dropwizard.Application;
import io.dropwizard.jersey.jackson.JsonProcessingExceptionMapper;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import resources.DepartmentResource;
import resources.MarksResource;
import resources.SemesterResource;
import resources.StudentResource;
import resources.TeacherResource;

public class CollegeSuiteApplication extends Application<CollegeSuiteServiceConfiguration> {
    public static final String APPLICATION_NAME = "college-suite-application";
    private static final Logger LOGGER = LoggerFactory.getLogger(CollegeSuiteApplication.class);

    @Override
    public String getName() {
        return APPLICATION_NAME;
    }

    @Override
    public void initialize(Bootstrap<CollegeSuiteServiceConfiguration> bootstrap) {
        super.initialize(bootstrap);
    }

    @Override
    public void run(CollegeSuiteServiceConfiguration configuration, Environment environment)
            throws Exception {
        Injector injector = Guice.createInjector(new CollegeSuiteServiceModule(configuration));
        environment.healthChecks().register(this.getName(), new CollegeSuiteHealthCheck());
        environment.jersey().register(injector.getInstance(StudentResource.class));
        environment.jersey().register(injector.getInstance(MarksResource.class));
        environment.jersey().register(injector.getInstance(TeacherResource.class));
        environment.jersey().register(injector.getInstance(SemesterResource.class));
        environment.jersey().register(injector.getInstance(DepartmentResource.class));
        environment.jersey().register(new JsonProcessingExceptionMapper(true));
        LOGGER.info("All resources added for college-suite");
    }

    public static void main(String []args) throws Exception {
        new CollegeSuiteApplication().run(args);
    }
}
