package cn.edu.zucc.galiview.generator.server;

import cn.edu.zucc.galiview.generator.util.DbUtil;
import cn.edu.zucc.galiview.generator.util.Field;
import cn.edu.zucc.galiview.generator.util.FreemarkerUtil;

import java.util.*;

public class ServerGenerator {
    static String MODULE = "business";
    static String toDtoPath = "server//src//main//java//cn//edu//zucc//galiview//server//dto//";
    static String toServicePath = "server//src//main//java//cn//edu//zucc//galiview//server//service//";
    static String toControllerPath = MODULE + "//src//main//java//cn//edu//zucc//galiview//" + MODULE + "//controller//admin//";

    public static void main(String[] args) throws Exception {
        String Domain = "Section";
        String domain = "section";
        String tableNameCn = "小节";
        String module = MODULE;
        List<Field> fieldList = DbUtil.getColumnByTableName(domain);
        Set<String> typeSet = getJavaTypes(fieldList);
        Map<String, Object> map = new HashMap<>();
        map.put("Domain", Domain);
        map.put("domain", domain);
        map.put("tableNameCn", tableNameCn);
        map.put("module", module);
        map.put("fieldList", fieldList);
        map.put("typeSet", typeSet);

        // 生成dto
        FreemarkerUtil.initConfig("dto.ftl");
        FreemarkerUtil.generator(toDtoPath + Domain + "Dto.java", map);

        // 生成service
        FreemarkerUtil.initConfig("service.ftl");
        FreemarkerUtil.generator(toServicePath + Domain + "Service.java", map);

        // 生成controller
        FreemarkerUtil.initConfig("controller.ftl");
        FreemarkerUtil.generator(toControllerPath + Domain + "Controller.java", map);
    }

    /**
     * 获取所有的Java类型，使用Set去重
     */
    private static Set<String> getJavaTypes(List<Field> fieldList) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < fieldList.size(); i++) {
            Field field = fieldList.get(i);
            set.add(field.getJavaType());
        }
        return set;
    }
}
