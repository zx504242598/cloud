package com.zx.cloud.security.utils;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;


/**
 * @author zhaoxuan
 * @date 2020-06-30 16:38
 **/
public class Generator {
    public static void main(String[] args) {
        //1. 全局配置
        GlobalConfig config = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");

        config
                // 是否支持AR模式
                .setActiveRecord(true)
                // 作者
                .setAuthor("zhaoxuan")
                // 生成路径
                .setOutputDir(projectPath +"/src/main/java")
                // 文件覆盖
                .setFileOverride(true)
                // 主键策略
                .setIdType(IdType.INPUT)
                // 设置生成的service接口的名字的首字母是否为I
                .setServiceName("%sService")
                // IEmployeeService
                .setBaseResultMap(true)
                .setBaseColumnList(true)
                .setEnableCache(false)
                .setSwagger2(true)
        ;



        //2. 数据源配置
        DataSourceConfig dsConfig  = new DataSourceConfig();
        // 设置数据库类型
        dsConfig.setDbType(DbType.MYSQL)
                .setDriverName("com.mysql.jdbc.Driver")
                .setUrl("jdbc:mysql://101.132.115.189:3306/security?useUnicode=true&characterEncoding=utf8")
                .setUsername("root")
                .setPassword("root");


        //3. 策略配置
        StrategyConfig stConfig = new StrategyConfig();
        //全局大写命名
        stConfig.setCapitalMode(true)
                // 数据库表映射到实体的命名策略
                .setNaming(NamingStrategy.underline_to_camel)
                .setLogicDeleteFieldName("IS_DELETE")
                // 生成的表
                .setEntityLombokModel(true)
                .setInclude("USER");

        stConfig.setRestControllerStyle(true).setColumnNaming(NamingStrategy.underline_to_camel);

        //4. 包名策略配置
        PackageConfig pkConfig = new PackageConfig();
        pkConfig.setParent("com.example.security")
                .setMapper("mapper")
                .setService("service")
                .setController("controller")
                .setEntity("model")
                .setXml("mapper");

        //5. 整合配置
        AutoGenerator ag = new AutoGenerator();

        ag.setGlobalConfig(config)
                .setDataSource(dsConfig)
                .setStrategy(stConfig)
                .setPackageInfo(pkConfig);

        //6. 执行
        ag.execute();
    }
}
