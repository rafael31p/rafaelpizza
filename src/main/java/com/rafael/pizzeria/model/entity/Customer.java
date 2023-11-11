package com.rafael.pizzeria.model.entity;

import com.rafael.pizzeria.model.audit.Auditable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import lombok.Builder;
import java.io.Serializable;
@Entity
@Table(name = "customer")
@EntityListeners(AuditingEntityListener.class)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer extends Auditable implements Serializable {
    @Id
    @Column(name = "id_customer", nullable = false, length = 15)
    private String idCustomer;
    @Column(nullable = false, length = 60)
    private String name;
    @Column(length = 100)
    private String address;
    @Column(nullable = false, length = 50, unique = true)
    private String email;
    @Column(name = "phone_number", length = 20)
    private String phoneNumber;
}
