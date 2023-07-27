package com.techbee.demo.week3.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins ="http://localhost:4200")
@RequestMapping("/shopping-cart")
public class ProductController {

}
