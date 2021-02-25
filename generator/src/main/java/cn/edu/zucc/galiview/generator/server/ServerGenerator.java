package cn.edu.zucc.galiview.generator.server;

import cn.edu.zucc.galiview.generator.util.FreemarkerUtil;
import freemarker.template.TemplateException;

import java.io.IOException;

public class ServerGenerator {
    static String toPath = "generator//src//main//java//cn//edu//zucc//galiview//generator//test//";

    public static void main(String[] args) throws IOException, TemplateException {
        FreemarkerUtil.initConfig("test.ftl");
        FreemarkerUtil.generator(toPath + "Test.java");
    }
}
