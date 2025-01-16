package ru.mihanizzm.splitify.splitifyexpenses.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(schema = "main", name = "events")
public class Event {
    @Id
    @Column(name = "id", nullable = false, unique = true)
    private UUID id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "ended_at")
    private LocalDateTime endedAt;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "creator_id", referencedColumnName = "id", nullable = false)
    private User eventCreator;

    @OneToMany(mappedBy = "event", fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private List<Expense> expenses;

    @OneToMany(mappedBy = "event", fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private List<EventParticipants> participants;
}
