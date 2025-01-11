package ru.mihanizzm.splitify.splitifyexpenses.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(schema = "main", name = "currencies")
public class Currency {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Integer id;

    @Column(name = "code", nullable = false)
    private String code;

    @Column(name = "symbol")
    private String symbol;

    @Column(name = "name", nullable = false)
    private String name;
}
