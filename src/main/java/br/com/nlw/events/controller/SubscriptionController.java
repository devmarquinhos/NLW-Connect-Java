package br.com.nlw.events.controller;

import br.com.nlw.events.model.Subscription;
import br.com.nlw.events.model.User;
import br.com.nlw.events.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class SubscriptionController {
    @Autowired
    private SubscriptionService service;

    @PostMapping("/subscription/{prettyName}")
    public ResponseEntity<Subscription> createSubscription(@PathVariable String prettyName, @RequestBody User subscriber) {
        Subscription res = service.createNewSubscription(prettyName, subscriber);

        if (res != null) {
            return ResponseEntity.ok(res);
        }
        return ResponseEntity.badRequest().build();
    }
}
