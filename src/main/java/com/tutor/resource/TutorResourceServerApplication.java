package com.tutor.resource;

import com.tutor.resource.dal.dao.*;
import com.tutor.resource.resources.*;
import com.tutor.resource.service.dailyLog.DailyLogService;
import com.tutor.resource.service.department.DepartmentService;
import com.tutor.resource.service.event.EventService;
import com.tutor.resource.service.message.MessageService;
import com.tutor.resource.service.partnerUniversity.PartnerUniversityService;
import com.tutor.resource.service.payPeriod.PayPeriodService;
import com.tutor.resource.service.privilegedUser.PrivilegedUserService;
import com.tutor.resource.service.resource.ResourceService;
import com.tutor.resource.service.school.SchoolService;
import com.tutor.resource.service.school.SchoolServiceImpl;
import com.tutor.resource.service.shift.ShiftService;
import com.tutor.resource.service.student.StudentService;
import com.tutor.resource.service.tutor.TutorService;
import io.dropwizard.Application;
import io.dropwizard.jdbi3.JdbiFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.jdbi.v3.core.Jdbi;
import com.tutor.resource.TutorResourceServerConfiguration;

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
//        final RegistrarDAO registrarDAO = dbi.onDemand(RegistrarDAO.class);
        final StudentDAO studentDAO = jdbi.onDemand(StudentDAO.class);
        final ResourceDAO resourceDAO = jdbi.onDemand(ResourceDAO.class);
        final PrivilegedUserDAO privilegedUserDAO = jdbi.onDemand(PrivilegedUserDAO.class);
        final PartnerUniversityDAO partnerUniversityDAO = jdbi.onDemand(PartnerUniversityDAO.class);
        final MessageDAO messageDAO = jdbi.onDemand(MessageDAO.class);
        final EventDAO eventDAO = jdbi.onDemand(EventDAO.class);
        final TutorDAO tutorDAO = jdbi.onDemand(TutorDAO.class);
        final ShiftDAO shiftDAO = jdbi.onDemand(ShiftDAO.class);
        final DailyLogDAO dailyLogDAO = jdbi.onDemand(DailyLogDAO.class);
        final PayPeriodDAO payPeriodDAO = jdbi.onDemand(PayPeriodDAO.class);
        final DepartmentDAO departmentDAO = jdbi.onDemand(DepartmentDAO.class);


        final DailyLogService dailyLogService = new DailyLogService(dailyLogDAO);
        final DepartmentService departmentService = new DepartmentService(departmentDAO);
        final EventService eventService = new EventService(eventDAO);
        final MessageService messageService = new MessageService(messageDAO);
        final PartnerUniversityService partnerUniversityService = new PartnerUniversityService(partnerUniversityDAO);
        final PayPeriodService payPeriodService = new PayPeriodService(payPeriodDAO);
        final PrivilegedUserService privilegedUserService = new PrivilegedUserService(privilegedUserDAO);
//        final RegistrarService registrarService = new RegistrarService(registrarDAO);
        final ResourceService resourceService = new ResourceService(resourceDAO);
        final SchoolService schoolService = new SchoolServiceImpl(schoolDAO);
        final ShiftService shiftService = new ShiftService(shiftDAO);
        final StudentService studentService = new StudentService(studentDAO);
        final TutorService tutorService = new TutorService(tutorDAO);


        environment.jersey().register(new SchoolResource(schoolService));
        environment.jersey().register(new DailyLogResource(dailyLogService));
        environment.jersey().register(new DepartmentResource(departmentService));
        environment.jersey().register(new EventResource(eventService));
        environment.jersey().register(new MessageResource(messageService));
        environment.jersey().register(new PartnerUniversityResource(partnerUniversityService));
        environment.jersey().register(new PayPeriodResource(payPeriodService));
        environment.jersey().register(new PrivilegedUserResource(privilegedUserService));
//        environment.jersey().register(new RegistrarResource(registrarService));
        environment.jersey().register(new ResourceResource(resourceService));
        environment.jersey().register(new ShiftResource(shiftService));
        environment.jersey().register(new StudentResource(studentService));
        environment.jersey().register(new TutorResource(tutorService));
    }

}
