package com.james.api.account;
import com.james.api.user.User;
import jakarta.persistence.*;
import lombok.*;
import java.util.Date;
import java.util.List;

@Entity(name = "accounts")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString
public class Account {

    @Id
    @Column(name = "account_id",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "account")
    private List<User> user;

    @Column(name = "account_number")
    private String accountNumber;

    @Column(name = "account_holder")
    private String accountHolder;

    private double balance;

    @Column(name = "transaction_date")
    private Date transactionDate;

    @Builder(builderMethodName = "builder")
    public Account(Long id, String accountNumber, String accountHolder, double balance, Date transactionDate) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
        this.transactionDate = transactionDate;
    }
}





