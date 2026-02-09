package com.Carambar.Carambar.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BlagueDTO {
    public BlagueDTO(String string, String string2) {
        // TODO Auto-generated constructor stub
    }

    private Long id;
    @NotBlank(message = "La question est obligatoire")
    @Size(max = 1000, message = "La question ne doit pas dépasser 1000 caractères")
    private String question;

    @NotBlank(message = "La réponse est obligatoire")
    @Size(max = 1000, message = "La réponse ne doit pas dépasser 1000 caractères")
    private String reponse;
}
