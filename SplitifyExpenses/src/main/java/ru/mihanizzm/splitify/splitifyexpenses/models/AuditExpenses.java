package ru.mihanizzm.splitify.splitifyexpenses.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.JsonNode;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.mihanizzm.splitify.splitifyexpenses.util.JsonbToStringConverter;

import java.time.LocalDateTime;
import java.util.UUID;

@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(schema = "main", name = "audit_expenses")
public class AuditExpenses {
    @Id
    @Column(name = "id", nullable = false, unique = true)
    private UUID id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "expense_id", referencedColumnName = "id", nullable = false)
    private Expense expense;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "changed_by_id", referencedColumnName = "id", nullable = false)
    private User changedByUser;

    @Column(name = "change_type", nullable = false)
    private String changeType;

    @Column(name = "change_data", columnDefinition = "jsonb", nullable = false)
    @Convert(converter = JsonbToStringConverter.class)
    private JsonNode changeData;

    @Column(name = "changed_at", nullable = false)
    private LocalDateTime changedAt;
}
