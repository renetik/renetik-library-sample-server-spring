package renetik.spring.sample.api

import com.fasterxml.jackson.annotation.JsonProperty

data class Response(val success: Boolean, val message: String? = null)
data class ValuesResponse(@JsonProperty("success") val success: Boolean,
                          @JsonProperty("values") val values: Map<String, String>)

data class ValueResponse<T>(@JsonProperty("success") val success: Boolean,
                            @JsonProperty("value") val value: T)

data class ListResponse<T>(val success: Boolean, val list: List<T>)

fun restOperation(function: () -> Any) = try {
    function()
} catch (ex: Throwable) {
    Response(false, "Exception on server: $ex")
}