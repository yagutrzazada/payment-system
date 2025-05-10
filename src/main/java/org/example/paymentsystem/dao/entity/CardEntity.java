package org.example.paymentsystem.dao.entity;

import lombok.NoArgsConstructor;
import jakarta.persistence.*;
import lombok.*;
import org.example.paymentsystem.model.enums.CardType;
import org.example.paymentsystem.model.enums.TransferStatus;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "cards")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String holderName;
    private String cardNumber;
    private LocalDate expirationDate;
    private String cvv;
    @Enumerated(EnumType.STRING)
    private CardType type;
    private BigDecimal balance;
    @Enumerated(EnumType.STRING)

    private TransferStatus status;
    private String accountNumber;
    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CardEntity that = (CardEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
