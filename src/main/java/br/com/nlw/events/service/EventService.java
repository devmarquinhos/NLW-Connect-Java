package br.com.nlw.events.service;

import br.com.nlw.events.model.Event;
import br.com.nlw.events.repo.EventRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {
    @Autowired
    private EventRepo eventRepo;

    // Criando o pretty name
    public Event addNewEvent(Event event){
        // Gerando o pretty name usando metodos String
        event.setPrettyName(event.getTitle().toLowerCase().replaceAll(" ", "-"));
        return eventRepo.save(event);
    }

    // Buscando todos os eventos
    public List<Event> getAllEvents(){
        return (List<Event>)eventRepo.findAll();
    }

    public Event getByPrettyName(String prettyName){
        return eventRepo.findByPrettyName(prettyName);
    }
}
