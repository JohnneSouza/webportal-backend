package br.com.imobiliariaype.webportal.utils;

import org.springframework.http.HttpHeaders;

public class HeadersUtils {

    private static final String X_TOTAL_COUNT = "X-Total-Count";
    private static final String ACCESS_CONTROL_EXPOSE_HEADERS = "Access-Control-Expose-Headers";
    private static final String ACCESS_CONTROL_ALLOW_ORIGIN = "Access-Control-Allow-Origin";

    private HeadersUtils() {
    }

    public static HttpHeaders pageAmountTotalCount(int pageAmount){
        HttpHeaders header = new HttpHeaders();
        header.add(X_TOTAL_COUNT, String.valueOf(pageAmount));
        header.add(ACCESS_CONTROL_EXPOSE_HEADERS, X_TOTAL_COUNT);
        header.add(ACCESS_CONTROL_ALLOW_ORIGIN, "*");

        return header;
    }
}
