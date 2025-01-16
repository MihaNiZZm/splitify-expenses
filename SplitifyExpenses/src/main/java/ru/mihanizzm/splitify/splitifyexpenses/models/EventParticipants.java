package ru.mihanizzm.splitify.splitifyexpenses.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.mihanizzm.splitify.splitifyexpenses.models.id.EventParticipantsId;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(schema = "main", name = "events_participants")
public class EventParticipants {
    @EmbeddedId
    private EventParticipantsId id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @MapsId("participantId")
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User participant;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @MapsId("eventId")
    @JoinColumn(name = "event_id", referencedColumnName = "id", nullable = false)
    private Event event;

    @Column(name = "event_nickname")
    private String nickname;
}
