package org.example.facebook.mapper;

import org.example.facebook.dto.PostCreateDTO;
import org.example.facebook.model.Post;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component("postMapper")
public interface PostMapper {
    Post fromPostToPostCreateDTO (PostCreateDTO postCreateDTO);
}
