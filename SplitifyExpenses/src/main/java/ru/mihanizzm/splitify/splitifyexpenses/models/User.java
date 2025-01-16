package ru.mihanizzm.splitify.splitifyexpenses.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
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
    private List<Expense> paidExpenses;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "sharePayer", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private List<ExpenseShare> paidShares;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private List<PaymentDetails> paymentDetailsList;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "participant", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private List<EventParticipants> participatedEvents;

    @OneToOne(fetch = FetchType.EAGER, mappedBy = "user", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private UserPreferences preferences;
}
