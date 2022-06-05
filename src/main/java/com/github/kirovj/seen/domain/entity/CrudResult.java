package com.github.kirovj.seen.domain.entity;

import com.github.kirovj.seen.domain.enums.CrudStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Collections;
import java.util.List;

/**
 * CrudResult
 *
 * @author : kirovj
 * @date : 2022/6/5 15:59
 */
@Getter
@Setter
@AllArgsConstructor
public class CrudResult<T> {
    private CrudStatus status;
    private List<T> data;

    public static <T> CrudResult<T> of(CrudStatus status, List<T> data) {
        return status == CrudStatus.Success ? ok(data) : fail(status);
    }

    public static <T> CrudResult<T> of(CrudStatus status, T data) {
        return status == CrudStatus.Success ? ok(data) : fail(status);
    }

    public static <T> CrudResult<T> ok(List<T> data) {
        return new CrudResult<>(CrudStatus.Success, data);
    }

    public static <T> CrudResult<T> ok(T data) {
        return new CrudResult<>(CrudStatus.Success, Collections.singletonList(data));
    }

    public static <T> CrudResult<T> fail(CrudStatus status) {
        return new CrudResult<>(status, Collections.emptyList());
    }
}
