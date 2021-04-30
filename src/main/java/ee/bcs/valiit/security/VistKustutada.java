//package ee.bcs.valiit.security;
//
//import ee.bcs.valiit.bankManager.LoginRequestClass;
//import io.jsonwebtoken.JwtBuilder;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.Date;
//
//@CrossOrigin
//@RestController
//public class VistKustutada {
//
//    @PostMapping("/public/banksql/login")
//    public String login(@RequestBody LoginRequestClass loginRequestClass) {
//        Date today = new Date();
//        Date tokenExpirationDate = new Date(today.getTime()+1000*60*60*24);
//        JwtBuilder jwtBuilder = Jwts.builder()
//                .setExpiration(tokenExpirationDate)
//                .setIssuedAt(new Date())
//                .signWith(SignatureAlgorithm.HS256, "c2VjcmV0")
//                .claim("username", loginRequestClass.getUsername());
//
//        return jwtBuilder.compact();
//    }
//}
