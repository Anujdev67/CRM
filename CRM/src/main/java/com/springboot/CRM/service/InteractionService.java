package com.springboot.CRM.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.CRM.model.Interaction;
import com.springboot.CRM.repository.InteractionRepository;

@Service
public class InteractionService {
    @Autowired
    private InteractionRepository interactionRepository;

    //save interaction
    public Interaction saveInteraction(Interaction interaction) {
        return interactionRepository.save(interaction);
    }

    // fetch interaction by id
    public List<Interaction> getInteractionsByCustomerId(int customerId) {
        return interactionRepository.findAll().stream()
                .filter(interaction -> interaction.getCustomer().getId() == customerId)
                .toList();
    }
}
