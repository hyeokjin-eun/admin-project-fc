package com.fast.admin.model.network.request;

import com.fast.admin.model.enumClass.PartnerStatus;
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
@ApiModel(value = "PartnerApiRequest", description = "파트너 요청 모델")
public class PartnerApiRequest {

    @ApiModelProperty(value = "파트너 식별자")
    private Long id;

    @ApiModelProperty(value = "파트너 명")
    private String name;

    @ApiModelProperty(value = "파트너 상태")
    private PartnerStatus status;

    @ApiModelProperty(value = "파트너 주소")
    private String address;

    @ApiModelProperty(value = "고객 센터")
    private String callCenter;

    @ApiModelProperty(value = "담당자 연락처")
    private String partnerNumber;

    @ApiModelProperty(value = "사업자 번호")
    private String businessNumber;

    @ApiModelProperty(value = "CEO 이름")
    private String ceoName;

    @ApiModelProperty(value = "파트너 등록 일자")
    private LocalDateTime registeredAt;

    @ApiModelProperty(value = "파트너 해지 일자")
    private LocalDateTime unregisteredAt;

    @ApiModelProperty(value = "카테고리 식별자")
    private Long categoryId;
}
