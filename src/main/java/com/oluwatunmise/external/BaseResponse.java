package com.oluwatunmise.external;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BaseResponse<T> {
  private int statusCode;
  private T data;
  private Boolean success;
}
