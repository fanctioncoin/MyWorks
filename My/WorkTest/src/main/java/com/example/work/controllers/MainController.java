package com.example.work.controllers;

import com.example.work.domain.Message;
import com.example.work.domain.User;
import com.example.work.repos.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

@Controller
public class MainController {
    @Autowired
    private MessageRepo messageRepo;

    @Value("${upload.path}")
    private String uploadPath;

    @GetMapping("/")
    public String greeting(Map<String,Object> model){
        return "greeting"; //возращать файл шаблон который хотим отобразить

    }
    @GetMapping("/main")
    public String main(@RequestParam(required = false, defaultValue = "") String filter, Model model){
        Iterable<Message> messages= messageRepo.findAll();
        if(filter!=null && !filter.isEmpty() ) {
            messages = messageRepo.findByTag(filter);
        } else{
            messages = messageRepo.findAll();
        }
        model.addAttribute("messages",messages);
        model.addAttribute("filter", filter);

        return "main";
    }
    @PostMapping("/main")
    public String add(
            @AuthenticationPrincipal User user,
            @RequestParam String modelAuto,
            @RequestParam Long mileage,
            @RequestParam String text,
            @RequestParam String tag, Map<String,Object> model,
            @RequestParam("file") MultipartFile file
            ) throws IOException {
        Message message = new Message(modelAuto, mileage, text, tag,user);

        if (file !=null && !file.getOriginalFilename().isEmpty()){
            File uploadDir = new File(uploadPath);
            if(!uploadDir.exists()){
                uploadDir.mkdirs();
            }
            String uuidFile = UUID.randomUUID().toString();//для уникального имени файла
            String resultFilename = uuidFile + "." + file.getOriginalFilename();

            file.transferTo(new File(uploadPath+ "/"+ resultFilename)); //загружаем файл
            message.setFilename(resultFilename);
        }
        messageRepo.save(message);
        Iterable<Message> messages= messageRepo.findAll();
        model.put("messages",messages);
        return "main";
    }
}
