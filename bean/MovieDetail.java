package com.nsu.movie2023.bean;

import lombok.Data;


@Data
public class MovieDetail {
    private int filmId;
    private String title;
    private String category;
    private String description;
    private String releaseYear;
    private int rentalDuration;
    private float rentalRate;
    private int length;
    private float replacementCost;
    private String rating;
    private String specialFeatures;
    private String actors;
    private int count;
}
