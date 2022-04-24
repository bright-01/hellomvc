package hello.springmvc.basic.requestmapping;

import org.springframework.web.bind.annotation.*;

/**
 * 회원 목록 조회: GET /users
 * 회원 등록: POST /users
 * 회원 조회: GET /users/{userId}
 * 회원 수정: PATCH /users/{userId}
 * 회원 삭제: DELETE /users/{userId}
 */

@RestController
@RequestMapping("/mapping/users")
public class MappingClassController {

    @GetMapping
    public String users(){
        return "get users";
    }

    @PostMapping
    public String addUsers(){
        return "post users";
    }

    @GetMapping("/{usersId}")
    public String findUser(@PathVariable String usersId){
        return "get users Id " + usersId;
    }

    @PatchMapping("/{userID}")
    public String updateUser(@PathVariable String userId){
        return "update userId" + userId;
    }

    @DeleteMapping("/{userId}")
    public String deleteUsers(@PathVariable String userId){
        return "delete userId " + userId;
    }
}
