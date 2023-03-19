package com.code.wings.exambooster.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "question")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "creator")
    private String creator;

    @Column(name = "category")
    private String category;

    @Column(name = "sentence")
    private String sentence;

    @Column(name = "answer")
    private String answer;

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Question() {
    }

    public Question(int id, String creator, String sentence) {
        this.id = id;
        this.creator = creator;
        this.sentence = sentence;
    }

    public Question(String creator, String sentence) {
        this.creator = creator;
        this.sentence = sentence;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", creator='" + creator + '\'' +
                ", category='" + category + '\'' +
                ", sentence='" + sentence + '\'' +
                '}';
    }
}
