package com.claritae.maintainance.audit;

import org.springframework.data.domain.AuditorAware;
import java.util.Optional;

public class AuditorAwareImple implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        String name = "SYSTEM";
//        if(SecurityContextHolder.getContext().getAuthentication().isAuthenticated()) {
//            name = SecurityContextHolder.getContext().getAuthentication().getName();
//        }
        return Optional.ofNullable(name);
    }

}
