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
public class ExpenseShareId implements Serializable {
    @Column(name = "participant_id", nullable = false)
    private UUID participantId;

    @Column(name = "expense_id", nullable = false)
    private UUID expenseId;
}
