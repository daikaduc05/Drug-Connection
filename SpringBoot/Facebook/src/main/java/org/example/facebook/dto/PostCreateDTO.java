package org.example.facebook.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PostCreateDTO {
    private String userId;
    private String postId;
    private String username;
    private String title;
    private String body;
    private String createAt;
    private String isEdit;
}
