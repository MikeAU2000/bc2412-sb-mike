package com.ex2.demo_sbxercise.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ex2.demo_sbxercise.Dto.CommentByuserDTO;
import com.ex2.demo_sbxercise.Dto.UpcDTO;
import com.ex2.demo_sbxercise.codewave.BusinessException;
import com.ex2.demo_sbxercise.codewave.SysCode;
import com.ex2.demo_sbxercise.dio.CommentDto;
import com.ex2.demo_sbxercise.dio.PostDto;
import com.ex2.demo_sbxercise.dio.UserDto;
import com.ex2.demo_sbxercise.service.UpcSservice;

@Service
public class UpcServiceimpl implements UpcSservice {
  @Autowired
  private UserServiceImpl userServiceImpl;




  @Override
  public List<UpcDTO> getUpc() {
    List<UserDto> users = this.userServiceImpl.getUsers();
    List<PostDto> posts = this.userServiceImpl.getPosts();
    List<CommentDto> comments = this.userServiceImpl.getComment();

    List<UpcDTO> allUserPostComments = new ArrayList<>();



    for (UserDto user : users) {
      List<UpcDTO.Post> ucpPosts = new ArrayList<>();
      for (PostDto post : posts) {
        List<UpcDTO.Post.Comment> ucpComments = new ArrayList<>();
        for (CommentDto comment : comments) {
          if (comment.getPostId() == post.getId()) {
            UpcDTO.Post.Comment ucpComment =
                new UpcDTO.Post.Comment(comment.getId(), comment.getName(),
                    comment.getEmail(), comment.getBody());
            ucpComments.add(ucpComment);
          }
        }
        if (post.getUserId() == user.getId()) {
          ucpPosts.add(new UpcDTO.Post(post.getId(), post.getTitle(),
              post.getBody(), ucpComments));

        }
      }
      allUserPostComments.add(UpcDTO.builder().id(user.getId())
          .name(user.getName()).username(user.getUsername())
          .email(user.getEmail())
          .address(UpcDTO.Address.builder()
              .street(user.getAddress().getStreet())
              .suite(user.getAddress().getSuite())
              .city(user.getAddress().getCity())
              .zipcode(user.getAddress().getZipcode())
              .geo(UpcDTO.Address.Geo.builder()
                  .lat(user.getAddress().getGeo().getLat())
                  .lng(user.getAddress().getGeo().getLng()).build())
              .build())
          .phone(user.getPhone()).website(user.getWebsite())
          .company(UpcDTO.Company.builder().name(user.getCompany().getName())
              .catchPhrase(user.getCompany().getCatchPhrase())
              .bs(user.getCompany().getBs()).build())
          .posts(ucpPosts).build());

    }
    return allUserPostComments;
  }


  @Override
  public List<CommentByuserDTO> getCommentByUser() {
    List<UpcDTO> upcDTOs= getUpc();
    List<CommentByuserDTO> commentByuserDTOs= new ArrayList<>();
    for (UpcDTO upcDTO : upcDTOs) {
      List<CommentByuserDTO.Comment> commentList= new ArrayList<>();
      for (UpcDTO.Post upcDTOpost : upcDTO.getPosts()) {
        for (UpcDTO.Post.Comment upcDTOpostcomment : upcDTOpost.getComments()) {
          commentList.add(CommentByuserDTO.Comment.builder().name(upcDTOpostcomment.getName())
          .email(upcDTOpostcomment.getEmail())
          .body(upcDTOpostcomment.getBody())
          .build()
          );
        }
      }
      commentByuserDTOs.add(CommentByuserDTO.builder().id(upcDTO.getId())
      .username(upcDTO.getName())
      .comments(commentList).build());
    }
    return commentByuserDTOs;
  }


  @Override
  public CommentByuserDTO getcby(Long id) {

    if (id<=0) {
      throw BusinessException.of(SysCode.INVALID_INPUT);
    }

    for (CommentByuserDTO commentByuserDTO : getCommentByUser()) {
      if (commentByuserDTO.getId()==id) {
        return commentByuserDTO;
      }
    }
    throw BusinessException.of(SysCode.USER_NOT_FOUND);
  }
}
