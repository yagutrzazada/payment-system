package org.example.paymentsystem.dao.entity;

import jakarta.persistence.*;
import lombok.*;
import org.example.paymentsystem.model.enums.TransferStatus;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;


@Entity
@Table(name="payments")
@Getter
@Setter

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransferEntity {
    @Id
    @GeneratedValue(strategy= GenerationType. IDENTITY)
    private Long id;
    private String transactionId;
    private String from;
    private String to;
    private BigDecimal amount;
    @Enumerated(EnumType.STRING)

    private TransferStatus status;
    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransferEntity that = (TransferEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
