package com.oluwatunmise.external;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OTPSuccessResponseMeta {
  @SerializedName("created_at")
  String created_at;
  @SerializedName("updated_at")
  String updated_at;
  @SerializedName("expires_at")
  String expiresAt;
  String id;
  String identifier;
  String status;
  String type;
  @SerializedName("delivery_methods")
  List<String> deliveryMethods;
  @SerializedName("delivery_details")
  OTPDelivery deliveryDetails;
}
