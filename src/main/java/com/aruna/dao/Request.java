package com.aruna.dao;

import lombok.*;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Request {
    private List<String> ids;
}
