package com.company.jobManager.dto;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="job")
public class Job {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "started")
    private Boolean started;

    /*@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "manager", referencedColumnName = "userName")
    private User user;*/

    public Job() {}

    public Job(Long id, String name, Boolean started) {
        this.id = id;
        this.name = name;
        this.started = started;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getStarted() {
        return started;
    }

    public void setStarted(Boolean started) {
        this.started = started;
    }
}
