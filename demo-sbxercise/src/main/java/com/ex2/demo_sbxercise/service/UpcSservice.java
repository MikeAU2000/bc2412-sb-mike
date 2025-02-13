package com.ex2.demo_sbxercise.service;

import java.util.List;
import com.ex2.demo_sbxercise.Dto.CommentByuserDTO;
import com.ex2.demo_sbxercise.Dto.UpcDTO;

public interface UpcSservice {
  List<UpcDTO> getUpc();

  List<CommentByuserDTO> getCommentByUser();

  CommentByuserDTO getcby(Long id);
}

