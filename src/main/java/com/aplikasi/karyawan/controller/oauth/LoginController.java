package com.aplikasi.karyawan.controller.oauth;


import com.aplikasi.karyawan.Config;
import com.aplikasi.karyawan.repository.oauth.UserRepository;
import com.aplikasi.karyawan.request.LoginModel;
import com.aplikasi.karyawan.service.oauth.UserService;
import com.aplikasi.karyawan.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping("/v1/user-login/")
public class LoginController {

    @Autowired
    public UserService serviceReq;

    @PostMapping("/login")
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Map> login(@Valid @RequestBody LoginModel objModel) {
        Map map = serviceReq.login(objModel);
        return new ResponseEntity<Map>(map, HttpStatus.OK);
    }

}
