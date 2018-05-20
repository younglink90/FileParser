package com.satorimaiden;

import com.satorimaiden.xml.Config;

public class Main {
    public static void main(String[] args) throws Exception {
        RuleExecutor re = RuleExecutor.of(Config.get());
        re.start();
    }
}
