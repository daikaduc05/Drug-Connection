package org.example.facebook.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ChatBox {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // tự động
    @Column(name = "id") // tên cho cột ở trong table
    private Integer id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user1_id")
    private User user1;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user2_id")
    private User user2;
    private Boolean isBlock;
}
