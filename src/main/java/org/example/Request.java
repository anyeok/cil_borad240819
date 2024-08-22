package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Request {
    private String actionCode;
    private Map<String, String> params = new HashMap<>();

    public Request(String command) {
        String[] commandList = command.split("\\?", 2);

        actionCode = commandList[0];

        if (commandList.length == 1) return;

        String[] paramsList = commandList[1].split("&");

        ArrayList<String> paramsId =  new ArrayList<>();

        for (String paramsRow : paramsList) {
            String[] paramsStr = paramsRow.split("=", 2);
            String key = paramsStr[0];
            if(paramsStr[1].startsWith("id=%")){
                paramsId.add(paramsStr[1]);
            }else{
                String value = paramsStr[1];
                params.put(key, value);
            }
        }

    }

    public String getActionCode() {
        return actionCode;
    }

    public String getParams(String key) {
        return params.get(key);
    }
}
