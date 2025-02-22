package br.com.nlw.events.service;
import br.com.nlw.events.model.Event;
import br.com.nlw.events.model.User;
import br.com.nlw.events.model.Subscription;
import br.com.nlw.events.repo.SubscriptionRepo;
import br.com.nlw.events.repo.UserRepo;
import br.com.nlw.events.repo.EventRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private EventRepo evtRepo;

    @Autowired
    private SubscriptionRepo subRepo;

    public Subscription createNewSubscription(String eventName, User user) {
        Subscription subs = new Subscription();

        // Recuperando o evento pelo nome
        Event evt = evtRepo.getByPrettyName(eventName);
        userRepo.save(user);

        subs.setEvent(evt);
        subs.setUser(user);

        Subscription res = subRepo.save(subs);
        return res;
    }
}
