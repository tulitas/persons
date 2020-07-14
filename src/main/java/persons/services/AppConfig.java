//package persons.services;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.domain.AuditorAware;
//import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//import persons.models.Persons;
//
//@Configuration
//@EnableTransactionManagement
//@EnableJpaAuditing
//public class AppConfig
//{
//    @Bean
//    public AuditorAware<Persons> auditorProvider() {
//        return new AuditorAwareImpl();
//    }
//}
