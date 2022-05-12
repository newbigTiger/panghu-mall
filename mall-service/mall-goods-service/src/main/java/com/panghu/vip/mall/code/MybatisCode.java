package com.panghu.vip.mall.code;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

/**
 * @author 胖虎
 * @date 2022/5/10 下午 3:20
 */
public class MybatisCode {
    public static void main(String[] args) {
        try {
            // 代码生成器
            AutoGenerator mpg = new AutoGenerator();
            // 全局配置
            GlobalConfig gc = new GlobalConfig();
            String projectPath = System.getProperty("user.dir");
            gc.setOutputDir(projectPath + "/src/main/java");
            // 文件输出路径
            gc.setAuthor("胖虎");
            //作者
            gc.setOpen(true);
            //生成之后是否打开目录
            gc.setIdType(IdType.NONE);
            //主键策略
            gc.setServiceName("%sService");
            //名字设置 %s是占位符，可以理解成类的名字
            mpg.setGlobalConfig(gc);
            // 数据源配置
            DataSourceConfig dsc = new DataSourceConfig();
            dsc.setUrl("jdbc:mysql://47.98.207.131:3306/shop_goods? useUnicode=true&useSSL=false&characterEncoding=utf8");
            dsc.setDriverName("com.mysql.jdbc.Driver");
            dsc.setUsername("root");
            dsc.setPassword("5475096a");
            mpg.setDataSource(dsc);
            // 包配置
            PackageConfig pc = new PackageConfig();
            pc.setModuleName("panghu-mall");
            pc.setParent("com.panghu.vip.mall.goods");
            mpg.setPackageInfo(pc);
            // 策略配置
            StrategyConfig strategy = new StrategyConfig();
            strategy.setNaming(NamingStrategy.underline_to_camel);
            //驼峰命名
            strategy.setColumnNaming(NamingStrategy.underline_to_camel);
            //驼峰命名
            strategy.setEntityLombokModel(true);
            //是否使用Lombok
            strategy.setRestControllerStyle(true);
            //是否生成RestController
            // 写于父类中的公共字段
            //公共字段定义
            strategy.setControllerMappingHyphenStyle(true);
            //驼峰转连字符
            strategy.setTablePrefix(pc.getModuleName() + "_");
            mpg.setStrategy(strategy);
            mpg.execute();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
