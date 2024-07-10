package apis;

import com.google.gson.annotations.SerializedName;

import java.util.Map;

public record TaxasConversao(@SerializedName("conversion_rates") Map<String, Double> taxasConversoes) {
}
