package ru.mihanizzm.splitify.splitifyexpenses.models.id;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Embeddable
public class EventParticipantsId implements Serializable {
    @Column(name = "user_id", nullable = false)
    private UUID participantId;

    @Column(name = "event_id", nullable = false)
    private UUID eventId;
}
