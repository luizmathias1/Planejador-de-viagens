package com.rocketseat.planner.participants;

import com.rocketseat.planner.trip.Trip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service

public class ParticipantsService {


    @Autowired
    private ParticipantRepository repository;

    public void registerParticipantesToEvent(List<String> participantesToInvite, Trip trip){
        List<Participant> participants = participantesToInvite.stream().map(email -> new Participant(email, trip)).toList();

        this.repository.saveAll(participants);

        System.out.println(participants.get(0).getId());
    }

    public void triggerConfirmationEmailToParticipants(UUID tripId){

    }

    public void triggerConfirmationEmailToParticipants(String email){

    }

    public ParticipantCreateResponse registerParticipantToEvent(String email, Trip trip){
        Participant newParticipant = new Participant(email, trip);
        this.repository.save(newParticipant);

        return new ParticipantCreateResponse(newParticipant.getId());
    }

    public List<ParticipantsData> getAllParticipantsFromEvent(UUID trip_id){
        return this.repository.findByTripId(trip_id).stream().map(participant -> new ParticipantsData(participant.getId(), participant.getName(), participant.getEmail(), participant.getIsConfirmed())).toList();
    }
}
