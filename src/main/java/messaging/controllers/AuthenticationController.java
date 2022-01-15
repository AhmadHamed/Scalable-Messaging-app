package messaging.controllers;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class AuthenticationController {

  @GetMapping("/user")
  public String getUserName(@AuthenticationPrincipal OAuth2User principal) {
    return principal.getAttribute("name");
  }
}
