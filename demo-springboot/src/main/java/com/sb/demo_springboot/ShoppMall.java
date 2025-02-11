package com.sb.demo_springboot;

import java.time.LocalDate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Controller
@ResponseBody
@Getter
@AllArgsConstructor
public class ShoppMall {
  private String name;
  private int area;
  private Cinema Cinema;
  private ShopCategory shopCategory;

  @GetMapping(value="/shoppingMall")
  public ShoppMall getMallInfor(){
    new Cinema(name, null, null);
    return null;
  }

  @Getter
@AllArgsConstructor
  public class ReleasedFilms {
  private String name;
  private LocalDate releaseDate;
}

@Getter
@AllArgsConstructor
public class Cinema {
  private String name;
  private LocalDate localDate;
  private ReleasedFilms[] releasedFilms;
}

  public enum ShopCategory {
    Sport,Food,Clothing,
  }

}
