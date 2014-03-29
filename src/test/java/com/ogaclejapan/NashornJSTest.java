package com.ogaclejapan;

import org.junit.Test;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class NashornJSTest {

    @Test
    public void testEval() throws Exception {

        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("nashorn");

        String js = "var names = ['foo', 'bar', 'buzz']; print(names);";

        engine.eval(js);

    }
}
