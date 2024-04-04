package com.james.api.common;
import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import java.time.LocalDateTime;

@MappedSuperclass //
@EntityListeners(value = {}) //  보안요소 거는것
@Getter
public class BaseEntity {

    @CreatedDate
    @Column(name="reg.data", updatable = false)
    private LocalDateTime regData;

    @LastModifiedDate
    @Column(name="mod.data") // updatable = true는 디폴트값이라 생략
    private LocalDateTime modData;

}
