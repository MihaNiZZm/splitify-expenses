package ru.mihanizzm.splitify.splitifyexpenses.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(schema = "main", name = "users")
public class User {
    @Id
    @Column(name = "id", nullable = false, unique = true)
    private UUID id;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "phone_number", unique = true)
    private String phoneNumber;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "nickname", unique = true)
    private String nickname;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "eventCreator", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private List<Event> createdEvents;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "payer", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private List<Event> paidEvents;
}
