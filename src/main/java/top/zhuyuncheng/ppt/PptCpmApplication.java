package top.zhuyuncheng.ppt;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("top.zhuyuncheng.ppt.dao")
public class PptCpmApplication {

	public static void main(String[] args) {
		SpringApplication.run(PptCpmApplication.class, args);
	}
}
