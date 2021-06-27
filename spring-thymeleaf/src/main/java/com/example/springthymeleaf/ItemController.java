package com.example.springthymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

/**
 * @author Andrew
 * @since 2020-01-19
 */
@Controller
public class ItemController {

    @GetMapping("/item")
    public String findItem(Model model) {
        // 원래는 DB에서 정보를 가지고 와서 화면에 뿌려야 한다.
        // 화면에 뿌릴 때, 검색, 페이징을 고려해야 한다.
        List<Item> items = Arrays.asList(
                new Item("Chair", 30),
                new Item("Lug", 20),
                new Item("Desk", 50)
        );


        model.addAttribute("items", items);

        model.addAttribute("isPurchased", true);
        model.addAttribute("itemStatus", 1);


        UserInfo userInfo = new UserInfo();
        User user = new User();
        user.setFirstName("andrew");
        user.setLastName("han");
        user.setCity("Seoul");
        userInfo.setUser(user);

        model.addAttribute("userInfo", userInfo);
        return "item_list";
    }
}
