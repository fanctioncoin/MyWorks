package com.example.work.domain;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Please fill the Description")
    @Length(max=2048,message ="Message too long(more than 2kB)" )
    private String text; //будет храниться текст

    @NotBlank(message = "Please fill the VIN")
    @Length(max=255,message ="Message too long" )
    private String tag; // будем хранить vin, для поиска

    @NotBlank(message = "Please fill the model auto")
    private String modelAuto;

    @NotNull(message = "Please fill the mileage")
    private Long mileage;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User autor;

    private String filename;



    public Message(){ // создаем специально пустой конструктор для Entety

    }

    public Message(String modelAuto,Long mileage, String text, String tag,User autor) {
        this.modelAuto=modelAuto;
        this.mileage = mileage;
        this.text = text;
        this.tag = tag;
        this.autor =autor;
    }
    public String getAuthorName(){
        return autor!=null ? autor.getUsername(): "<none>";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getModelAuto() {
        return modelAuto;
    }

    public void setModelAuto(String modelAuto) {
        this.modelAuto = modelAuto;
    }

    public Long getMileage() {
        return mileage;
    }

    public void setMileage(Long mileage) {
        this.mileage = mileage;
    }

    public User getAutor() { return autor; }

    public void setAutor(User autor) { this.autor = autor;
    }
    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }
}
