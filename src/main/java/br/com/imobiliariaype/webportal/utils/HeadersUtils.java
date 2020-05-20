package br.com.imobiliariaype.webportal.utils;

import org.springframework.http.HttpHeaders;

public class HeadersUtils {

    private static final String X_TOTAL_COUNT = "X-Total-Count";
    private static final String ACCESS_CONTROL_EXPOSE_HEADERS = "Access-Control-Expose-Headers";

    private HeadersUtils() {
    }

    public static HttpHeaders pageAmountTotalCount(int pageAmount){
        HttpHeaders header = fixedHeaders();
        header.add(X_TOTAL_COUNT, String.valueOf(pageAmount));

        return header;
    }

    public static HttpHeaders CORS_RESPONSE(){
        return fixedHeaders();
    }

    private static HttpHeaders fixedHeaders(){
        HttpHeaders header = new HttpHeaders();
        header.add(ACCESS_CONTROL_EXPOSE_HEADERS, X_TOTAL_COUNT);

        return header;
    }
}
