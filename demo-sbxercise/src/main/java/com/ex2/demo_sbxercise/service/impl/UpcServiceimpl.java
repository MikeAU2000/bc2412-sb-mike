package com.ex2.demo_sbxercise.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ex2.demo_sbxercise.Dto.CommentByuserDTO;
import com.ex2.demo_sbxercise.Dto.UpcDTO;
import com.ex2.demo_sbxercise.codewave.BusinessException;
import com.ex2.demo_sbxercise.codewave.SysCode;
import com.ex2.demo_sbxercise.dio.CommentDto;
import com.ex2.demo_sbxercise.dio.PostDto;
import com.ex2.demo_sbxercise.dio.UserDto;
import com.ex2.demo_sbxercise.entity.AddressEntity;
import com.ex2.demo_sbxercise.entity.CommentEntity;
import com.ex2.demo_sbxercise.entity.CompanyEntity;
import com.ex2.demo_sbxercise.entity.GeoEntity;
import com.ex2.demo_sbxercise.entity.PostEntity;
import com.ex2.demo_sbxercise.entity.UserEntity;
import com.ex2.demo_sbxercise.repository.AddressRespository;
import com.ex2.demo_sbxercise.repository.CommentRespository;
import com.ex2.demo_sbxercise.repository.CompanyRepository;
import com.ex2.demo_sbxercise.repository.GeoRepository;
import com.ex2.demo_sbxercise.repository.PostRespository;
import com.ex2.demo_sbxercise.repository.UserRepository;
import com.ex2.demo_sbxercise.service.UpcSservice;

@Service
public class UpcServiceimpl implements UpcSservice {
  @Autowired
  private UserServiceImpl userServiceImpl;
  @Autowired
  private GeoRepository geoRepository;
  @Autowired
  private AddressRespository addressRespository;
  @Autowired
  private CompanyRepository companyRepository;
  @Autowired
  private UserRepository userRepository;
  @Autowired
  private PostRespository postRespository;
  @Autowired
  private CommentRespository commentRespository;

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
    List<UpcDTO> upcDTOs = getUpc();
    List<CommentByuserDTO> commentByuserDTOs = new ArrayList<>();
    for (UpcDTO upcDTO : upcDTOs) {
      List<CommentByuserDTO.Comment> commentList = new ArrayList<>();
      for (UpcDTO.Post upcDTOpost : upcDTO.getPosts()) {
        for (UpcDTO.Post.Comment upcDTOpostcomment : upcDTOpost.getComments()) {
          commentList.add(CommentByuserDTO.Comment.builder()
              .name(upcDTOpostcomment.getName())
              .email(upcDTOpostcomment.getEmail())
              .body(upcDTOpostcomment.getBody()).build());
        }
      }
      commentByuserDTOs.add(CommentByuserDTO.builder().id(upcDTO.getId())
          .username(upcDTO.getName()).comments(commentList).build());
    }
    return commentByuserDTOs;
  }


  @Override
  public CommentByuserDTO getcby(Long id) {

    if (id <= 0) {
      throw BusinessException.of(SysCode.INVALID_INPUT);
    }

    for (CommentByuserDTO commentByuserDTO : getCommentByUser()) {
      if (commentByuserDTO.getId() == id) {
        return commentByuserDTO;
      }
    }
    throw BusinessException.of(SysCode.USER_NOT_FOUND);
  }


  @Override
  public void saveAllUsersEntity() {
    if (userRepository.count() == 0) {
      List<UserDto> users = this.userServiceImpl.getUsers();
      for (UserDto userDto : users) {
        String lat = userDto.getAddress().getGeo().getLat();
        String lng = userDto.getAddress().getGeo().getLng();
        GeoEntity geoEntity =
            geoRepository.save(GeoEntity.builder().lat(lat).lng(lng).build());
        String zipcode = userDto.getAddress().getZipcode();
        String street = userDto.getAddress().getStreet();
        String suite = userDto.getAddress().getSuite();
        String city = userDto.getAddress().getCity();
        AddressEntity addressEntity =
            AddressEntity.builder().city(city).geo(geoEntity).zipcode(zipcode)
                .suite(suite).street(street).build();
        addressRespository.save(addressEntity);

        // company
        String name = userDto.getCompany().getName();
        String catchPhrase = userDto.getCompany().getCatchPhrase();
        String bs = userDto.getCompany().getBs();
        CompanyEntity companyEntity = companyRepository.save(CompanyEntity
            .builder().name(name).catchPhrase(catchPhrase).bs(bs).build());

        Long uid = userDto.getId();
        String uName = userDto.getName();
        String uEmail = userDto.getEmail();
        String username = userDto.getUsername();
        AddressEntity uAddressEntity = addressEntity;
        String uPhone = userDto.getPhone();
        String uWebsite = userDto.getWebsite();
        CompanyEntity CompanyEntity = companyEntity;

        userRepository
            .save(UserEntity.builder().id(uid).name(uName).email(uEmail)
                .username(username).addressEntity(uAddressEntity).phone(uPhone)
                .website(uWebsite).CompanyEntity(CompanyEntity).build());
      }
    }
  }


  @Override
  public void saveAllPostEntity() {
    if (postRespository.count() == 0) {
      List<PostDto> posts = this.userServiceImpl.getPosts();

      for (PostDto postDto : posts) {
        Long postId = postDto.getId();
        String title = postDto.getTitle();
        String body = postDto.getBody();
        UserEntity userEntity;
        userEntity = userRepository.findById(postDto.getUserId())
            .orElseThrow(() -> new RuntimeException(
                "User not found with id: " + postDto.getUserId()));

        postRespository.save(PostEntity.builder().id(postId).title(title)
            .body(body).userEntity(userEntity).build());

      }

    }

  }


  @Override
  public void saveAllCommentEntity() {
    if (commentRespository.count() == 0) {
      List<CommentDto> comments = this.userServiceImpl.getComment();
      for (CommentDto commentDto : comments) {
        Long id = commentDto.getId();
        String name = commentDto.getName();
        String email = commentDto.getEmail();
        String body = commentDto.getBody();
        PostEntity postEntity;
        if (postRespository.findById(commentDto.getPostId()).isPresent()) {
          postEntity = postRespository.findById(commentDto.getPostId()).get();
        } else {
          throw new RuntimeException(
              "User not found with id: " + commentDto.getPostId());
        }

        commentRespository.save(CommentEntity.builder().name(name).email(email)
            .body(body).id(id).postEntity(postEntity).build());
      }
    }
  }


  @Override
  public UserEntity putUserEntity(Long id, UserEntity userEntity) {
    if (userRepository.findById(id).isPresent()) {
        UserEntity existingUser = userRepository.findById(id).get();

          final GeoEntity newGeoEntity = userEntity.getAddressEntity().getGeo();
          final GeoEntity savedGeoEntity;
        // check if the given geoentity is not null
        
        if (newGeoEntity != null) {
          // 检查数据库中是否存在相同的geo
          List<GeoEntity> listgeoEntity = geoRepository.findByLatAndLng(newGeoEntity.getLat(), newGeoEntity.getLng());
          if (!listgeoEntity.isEmpty()) {
            savedGeoEntity = listgeoEntity.get(0);
          } else {
            savedGeoEntity = geoRepository.save(GeoEntity.builder()
                .lat(newGeoEntity.getLat())
                .lng(newGeoEntity.getLng())
                .build());
          }
        } else {
          savedGeoEntity = null;
        }
        
        CompanyEntity companyEntity= userEntity.getCompanyEntity();
        CompanyEntity saveCompanyEntity= null;
        if (companyEntity != null) {
          if (companyEntity.getId() != null) {
            if (companyRepository.findById(companyEntity.getId()).isPresent()) {
              saveCompanyEntity= companyRepository.findById(companyEntity.getId()).get();
            }
          }
          List<CompanyEntity> listcompanyEntity= companyRepository.findByNameAndCatchPhraseAndBs(companyEntity.getName(),companyEntity.getCatchPhrase(),companyEntity.getBs());
          if (!listcompanyEntity.isEmpty()) {
            saveCompanyEntity = listcompanyEntity.get(0);
          }else{
            saveCompanyEntity = companyRepository.save(
              CompanyEntity.builder()
              .name(companyEntity.getName())
              .catchPhrase(companyEntity.getCatchPhrase())
              .bs(companyEntity.getBs())
              .build());
          }
        }
        

        AddressEntity addressEntity= userEntity.getAddressEntity();
        AddressEntity savedAddressEntity=null;
        if (addressEntity != null) {
          String zipcode= addressEntity.getZipcode();
          if (addressRespository.findById(zipcode).isPresent()) {
            savedAddressEntity= addressRespository.findById(zipcode).get();
            savedAddressEntity.setGeo(savedGeoEntity);
            addressEntity=addressRespository.save(savedAddressEntity);
          }else{
            savedAddressEntity= AddressEntity.builder().zipcode(addressEntity.getZipcode()).city(addressEntity.getCity()).geo(savedGeoEntity).street(addressEntity.getStreet()).suite(addressEntity.getSuite()).build();
            savedAddressEntity= addressRespository.save(savedAddressEntity);
          }
        }

        

        // 更新用户实体
        existingUser.setAddressEntity(savedAddressEntity);
        existingUser.setCompanyEntity(saveCompanyEntity);
        existingUser.setEmail(userEntity.getEmail());
        existingUser.setName(userEntity.getName());
        existingUser.setPhone(userEntity.getPhone());
        existingUser.setUsername(userEntity.getUsername());
        existingUser.setWebsite(userEntity.getWebsite());

        return userRepository.save(existingUser);
    } else {
        throw new RuntimeException("User not found with id: " + id);
    }
  }


  @Override
  public void deletPostByPostId(Long postId) {
    postRespository.deleteById(postId);
  }


  @Override
  public void deletCommentByPostId(Long postId) {
    
  }


  @Override
  public void addPostByUserId(Long userId, PostEntity postEntity) {
    if (userRepository.findById(userId).isPresent()) {
      PostEntity newPostEntity= PostEntity.builder().body(postEntity.getBody())
      .id(postEntity.getId())
      .title(postEntity.getTitle())
      .userEntity(userRepository.findById(userId).get())
      .build();
      postRespository.save(newPostEntity);
    }
  }


  @Override
  public void addCommentByPostId(Long postId, CommentEntity commentEntity) {
    if (postRespository.findById(postId).isPresent()) {
      CommentEntity newCommentEntity=  CommentEntity.builder().body(commentEntity.getBody())
      .email(commentEntity.getEmail())
      .id(commentEntity.getId())
      .name(commentEntity.getName())
      .postEntity(postRespository.findById(postId).get())
      .build();
      commentRespository.save(newCommentEntity);
    }
  }

  @Override
  public void updateCommentByCommentId(Long commentId, CommentEntity commentEntity) {
      Optional<CommentEntity> existingCommentOpt = commentRespository.findById(commentId);
      
      if (existingCommentOpt.isPresent()) {
          CommentEntity existingComment = existingCommentOpt.get();
  
          CommentEntity newCommentEntity = CommentEntity.builder()
              .id(commentId)
              .body(commentEntity.getBody())
              .email(commentEntity.getEmail())
              .name(commentEntity.getName())
              .postEntity(existingComment.getPostEntity())
              .build();
  
          commentRespository.save(newCommentEntity);
      }
  }
  
}
