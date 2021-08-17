package com.example.work.domain;

import javax.persistence.*;

@Entity
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String text; //будет храниться текст
    private String tag; // будем хранить vin, для поиска
    private String modelAuto;
    private Integer mileage;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User autor;

    private String filename;



    public Message(){ // создаем специально пустой конструктор для Entety

    }

    public Message(String modelAuto,Integer mileage, String text, String tag,User autor) {
        this.modelAuto=modelAuto;
        this.mileage = mileage;
        this.text = text;
        this.tag = tag;
        this.autor =autor;
    }
    public String getAuthorName(){
        return autor!=null ? autor.getUsername(): "<none>";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Integer getMileage() {
        return mileage;
    }

    public void setMileage(Integer mileage) {
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
