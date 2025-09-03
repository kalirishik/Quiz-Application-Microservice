package com.project.question_service.model;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@Data
@Setter
@Getter
@RequiredArgsConstructor
public class Response {
    private int id;
    private String response;
}

