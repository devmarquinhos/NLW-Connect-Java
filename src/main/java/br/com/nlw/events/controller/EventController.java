package br.com.nlw.events.controller;

import br.com.nlw.events.model.Event;
import br.com.nlw.events.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EventController {
    @Autowired
    private EventService service;

    // Rota para criar os eventos
    @PostMapping("/events")
    public Event addEvent(@RequestBody Event newEvent){
        return service.addNewEvent(newEvent);
    }

    // Rota para buscar uma lista com os eventos existentes
    @GetMapping("/events")
    public List<Event> getAllEvents(){
        return service.getAllEvents();
    }

    // Rota para buscar um evento pelo Pretty Name
    @GetMapping("/events/{prettyName}")
    public ResponseEntity<Event> getEventByPrettyName(@PathVariable String prettyName){
        Event evt = service.getByPrettyName(prettyName);

        // Checar se o evento existe
        if (evt != null){
            return ResponseEntity.ok().body(evt); // Retorna 200
        }
        return ResponseEntity.notFound().build(); // Retorna 404
    }
}
