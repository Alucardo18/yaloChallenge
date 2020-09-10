package com.yalo.core;


import cucumber.runtime.Env;

import java.util.*;

public class Request {
    public String hostname = Env.INSTANCE.get("HostName");

    public  String requestPath;
}
