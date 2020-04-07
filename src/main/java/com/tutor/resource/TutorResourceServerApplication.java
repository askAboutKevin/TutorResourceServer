package com.tutor.resource;

import com.tutor.resource.auth.CustomAuthFilter;
import com.tutor.resource.auth.CustomAuthenticator;
import com.tutor.resource.auth.CustomAuthorizer;
import com.tutor.resource.auth.TutorResourceUser;
import com.tutor.resource.dal.dao.*;
import com.tutor.resource.resources.*;
import com.tutor.resource.service.dailyLog.DailyLogService;
import com.tutor.resource.service.event.EventService;
import com.tutor.resource.service.privilegedUser.PrivilegedUserService;
import com.tutor.resource.service.school.SchoolService;
import com.tutor.resource.service.school.SchoolServiceImpl;
import com.tutor.resource.service.shift.ShiftService;
import com.tutor.resource.service.student.StudentService;
import com.tutor.resource.service.tutor.TutorService;
import io.dropwizard.Application;
import io.dropwizard.auth.AuthDynamicFeature;
import io.dropwizard.auth.basic.BasicCredentialAuthFilter;
import io.dropwizard.jdbi3.JdbiFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.jdbi.v3.core.Jdbi;

public class TutorResourceServerApplication extends Application<TutorResourceServerConfiguration> {

    public static void main(final String[] args) throws Exception {
        new TutorResourceServerApplication().run(args);
    }

    @Override
    public String getName() {
        return "TutorResourceServer";
    }

    @Override
    public void initialize(final Bootstrap<TutorResourceServerConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final TutorResourceServerConfiguration configuration, final Environment environment) {

        final JdbiFactory factory = new JdbiFactory();
        final Jdbi jdbi = factory.build(environment, configuration.getDataSourceFactory(), "mysql");

        final SchoolDAO schoolDAO = jdbi.onDemand(SchoolDAO.class);
        final StudentDAO studentDAO = jdbi.onDemand(StudentDAO.class);
        final PrivilegedUserDAO privilegedUserDAO = jdbi.onDemand(PrivilegedUserDAO.class);
        final EventDAO eventDAO = jdbi.onDemand(EventDAO.class);
        final TutorDAO tutorDAO = jdbi.onDemand(TutorDAO.class);
        final ShiftDAO shiftDAO = jdbi.onDemand(ShiftDAO.class);
        final DailyLogDAO dailyLogDAO = jdbi.onDemand(DailyLogDAO.class);

        final DailyLogService dailyLogService = new DailyLogService(dailyLogDAO);
        final EventService eventService = new EventService(eventDAO);
        final PrivilegedUserService privilegedUserService = new PrivilegedUserService(privilegedUserDAO);
        final SchoolService schoolService = new SchoolServiceImpl(schoolDAO);
        final ShiftService shiftService = new ShiftService(shiftDAO);
        final StudentService studentService = new StudentService(studentDAO);
        final TutorService tutorService = new TutorService(tutorDAO);

        environment.jersey().register(new AuthDynamicFeature(new BasicCredentialAuthFilter.Builder<TutorResourceUser>()
                .setAuthenticator(new CustomAuthenticator(tutorDAO, privilegedUserDAO))
                .setAuthorizer(new CustomAuthorizer())
                .setRealm("BASIC-AUTH-REALM")
                .buildAuthFilter()));

        environment.jersey().register(new SchoolResource(schoolService));
        environment.jersey().register(new DailyLogResource(dailyLogService));
        environment.jersey().register(new EventResource(eventService));
        environment.jersey().register(new PrivilegedUserResource(privilegedUserService));
        environment.jersey().register(new ShiftResource(shiftService));
        environment.jersey().register(new StudentResource(studentService));
        environment.jersey().register(new TutorResource(tutorService));

        CustomAuthFilter filter = new CustomAuthFilter();
        environment.jersey().register(new AuthDynamicFeature(filter));
    }

}
