package org.example.facebook.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Messenger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // tự động
    @Column(name = "id") // tên cho cột ở trong table
    private Integer id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "from_id")
    private User fromUser;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "to_id")
    private User toUser;
    @Column(name = "content")
    private String content;
    @Column(name = "create_at")
    private LocalDateTime createAt;
    private Boolean seen;
}
