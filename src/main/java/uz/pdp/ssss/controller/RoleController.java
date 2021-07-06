package uz.pdp.ssss.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.ssss.payload.ApiResponce;
import uz.pdp.ssss.payload.RoleDto;
import uz.pdp.ssss.service.RoleService;

import java.net.http.HttpClient;

@RestController
@RequestMapping("/api/role")
public class RoleController {

    Autowired
    RoleService roleService;

    @PostMapping("/add")
    public HttpEntity<?> addRole(@RequestBody RoleDto roleDto) {

        ApiResponce responce = roleService.addRole(roleDto);

        return ResponseEntity.status(responce.isSuccess() ? 200 : 409).body(responce);
    }


}
