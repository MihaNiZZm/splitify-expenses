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
import ru.mihanizzm.splitify.splitifyexpenses.models.id.ExpenseShareId;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(schema = "main", name = "expenses_shares")
public class ExpenseShare {
    @EmbeddedId
    private ExpenseShareId id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @MapsId("participantId")
    @JoinColumn(name = "participant_id", referencedColumnName = "id", nullable = false)
    private User participant;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @MapsId("expenseId")
    @JoinColumn(name = "expense_id", referencedColumnName = "id", nullable = false)
    private Expense expense;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "paid_by_id", referencedColumnName = "id", nullable = false)
    private User sharePayer;

    @Column(name = "amount_to_pay", nullable = false)
    private BigDecimal amountToPay;
}
