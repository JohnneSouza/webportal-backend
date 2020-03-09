package br.com.imobiliariaype.webportal.utils;

import org.springframework.http.HttpHeaders;

public class HeaderUtils {

    private HeaderUtils() {
    }

    private static final String X_TOTAL_COUNT = "X-Total-Count";
    private static final String ACCESS_CONTROL_EXPOSE = "Access-Control-Expose-Headers";

    public static HttpHeaders getTotalCount(int amountOfPages){
        HttpHeaders header = new HttpHeaders();
        header.add("X-Total-Count", String.valueOf(amountOfPages));
        header.add("Access-Control-Expose-Headers", "X-Total-Count");

        return header;
    }

}
