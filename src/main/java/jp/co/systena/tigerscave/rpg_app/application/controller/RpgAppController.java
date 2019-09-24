package jp.co.systena.tigerscave.rpg_app.application.controller;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import jp.co.systena.tigerscave.rpg_app.application.model.RpgUserForm;

//viewありで返すため＠Controller
@Controller
public class RpgAppController {
//選んだ職業をセッション管理する。
  @Autowired
  HttpSession session;

//URLを指定してマッピングする
  @RequestMapping(value = "/character",method = RequestMethod.GET)
  public String character(Model model) {
    //ラジオボタンの選択肢
    Map<String, String> professionMap = new LinkedHashMap<String, String>();
    professionMap.put("戦士","戦士");
    professionMap.put("魔法使い","魔法使い");

    model.addAttribute("jobMap",professionMap);

    model.addAttribute("RpgUserForm",new RpgUserForm());

    return "character";
  }

  @RequestMapping(value = "/command",method = RequestMethod.POST)
  public String command(@ModelAttribute RpgUserForm rpgUserForm , Model model) {

    return "command";
  }

}
