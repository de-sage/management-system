package com.claritae.maintainance.audit;

import org.springframework.data.domain.AuditorAware;

import java.security.SecureRandom;
import java.util.Optional;

public class AuditorAwareImple implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        SecureRandom randomNumbers = new SecureRandom();
        int randomValue = randomNumbers.nextInt(3);
        String[] arr = {"John", "Doe", "Joe"};

        String name = arr[randomValue];
//        if(SecurityContextHolder.getContext().getAuthentication().isAuthenticated()) {
//            name = SecurityContextHolder.getContext().getAuthentication().getName();
//        }
        return Optional.ofNullable(name);
    }

}
