package com.fast.admin.model.network;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel(value = "Header", description = "API 통신 모델")
public class Header<T> {

    // API 응답 시간
    @ApiModelProperty(value = "API 시간", required = true)
    private LocalDateTime transactionTime;

    // API 응답 코드
    @ApiModelProperty(value = "API 응답 코드", required = true)
    private String resultCode;

    // API 응답 설명
    @ApiModelProperty(value = "API 시간", required = true)
    private String description;

    // 응답 데이터
    @ApiModelProperty(value = "API 응답 데이터", required = true)
    private T data;

    // OK
    public static <T> Header<T> OK() {
        return (Header<T>) Header.builder()
                .transactionTime(LocalDateTime.now())
                .resultCode("OK")
                .description("OK")
                .build();
    }

    // OK DATA
    public static <T> Header<T> OK(T data) {
        return (Header<T>) Header.builder()
                .transactionTime(LocalDateTime.now())
                .resultCode("OK")
                .description("OK")
                .data(data)
                .build();
    }

    //ERROR
    public static <T> Header<T> ERROR(String description) {
        return (Header<T>) Header.builder()
                .transactionTime(LocalDateTime.now())
                .resultCode("ERROR")
                .description(description)
                .build();
    }
}
