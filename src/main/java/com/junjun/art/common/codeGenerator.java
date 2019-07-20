package com.junjun.art.common;


import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

/**
 * @author junjun
 * @date 2019-01-10 15:55:23
 **/
public class codeGenerator {

    public static void main(String[] args) {

        AutoGenerator mpg = new AutoGenerator();

        // 1.全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = "D:/IDEA/code/art";
        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setAuthor("junjun");
        // 是否打开输出目录
        gc.setOpen(false);
        mpg.setGlobalConfig(gc);

        // 2.自定义文件命名，注意 %s 会自动填充表实体属性！
        gc.setControllerName("%sController");
        gc.setServiceName("%sService");
        gc.setServiceImplName("%sServiceImpl");
        gc.setMapperName("%sMapper");
        gc.setXmlName("%sMapper");
        gc  .setBaseResultMap(true)     // XML开启ResultMap
            .setBaseColumnList(true);   // XML开启columnList
        mpg.setGlobalConfig(gc);

        // 3.数据源配置 参照李俊代码，YmlUtils TODO
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://localhost:3306/art?serverTimezone=GMT&useUnicode=true&useSSL=false&characterEncoding=utf-8");
        // dsc.setSchemaName("public");
        dsc.setDriverName("com.mysql.jdbc.Driver"); //com.mysql.cj.jdbc.Driver
        dsc.setUsername("root");
        dsc.setPassword("Zls_[2019-6-6]");
        mpg.setDataSource(dsc);

        // 4.包配置
        PackageConfig pc = new PackageConfig();
        //pc.setModuleName(null);
        pc.setParent("com.junjun.art");
        pc.setController("controller");
        pc.setService("service");
        pc.setServiceImpl("service.impl");
        pc.setMapper("mapper");
        pc.setEntity("pojo");
        pc.setXml("mapper.xml");
        mpg.setPackageInfo(pc);

        // 5.策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(false);
        strategy.setSuperControllerClass(null);
        strategy.setSuperServiceClass(null);
        strategy.setSuperServiceImplClass(null);
        strategy.setSuperMapperClass(null);
        strategy.setControllerMappingHyphenStyle(true);
        strategy.setTablePrefix(pc.getModuleName() + "_");
        // 修改替换成你需要的表名，多个表名传数组
        strategy.setInclude("sys_file");
        mpg.setStrategy(strategy);

        mpg.execute();
    }

}
