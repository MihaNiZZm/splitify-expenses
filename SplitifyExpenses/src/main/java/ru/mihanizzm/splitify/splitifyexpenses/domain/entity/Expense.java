package ru.mihanizzm.splitify.splitifyexpenses.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import static jakarta.persistence.FetchType.EAGER;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(schema = "main", name = "expenses")
public class Expense {
    @Id
    @Column(name = "id", nullable = false, unique = true)
    private UUID id;

    @Column(name = "amount", nullable = false)
    private BigDecimal amount;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @ManyToOne(fetch = EAGER)
    @JoinColumn(name = "payer_id", referencedColumnName = "id", nullable = false)
    private User payer;

    @ManyToOne(fetch = EAGER)
    @JoinColumn(name = "currency_id", referencedColumnName = "id", nullable = false)
    private Currency currency;

    @ManyToOne(fetch = EAGER)
    @JoinColumn(name = "event_id", referencedColumnName = "id", nullable = false)
    private Event event;
}
