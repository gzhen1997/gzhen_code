package com.demo.batch;

import com.demo.model.User;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.SkipListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.support.CompositeItemProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * @author gz
 *
 * 测试问题描述： 配置了错误容忍，没有配置错误重试的情况下，当writer出现问题的时候
 * 会默认重试一次从process开始但是如果process里面的参数是对象类型，第二次重试的
 * 时候process里面的参数并不一定是reader中读取后的参数了，可能被修改了。（由于
 * process方法中操作了相同的地址值了）
 */
@Configuration
public class JobConfig {

    @Resource
    private JobBuilderFactory jobBuilderFactory;

    @Resource
    private StepBuilderFactory stepBuilderFactory;

    @Bean
    public Job demoJob() {
        return jobBuilderFactory.get("demoJob")
                .start(demoStep())
                .incrementer(new RunIdIncrementer())
                .build();
    }

    @Bean
    public Step demoStep() {
        return stepBuilderFactory.get("demoStep")
                .<User, User>chunk(10)
                .reader(demoReader())
                .processor(compositeItemProcessor())
                .writer(demoWriter())
                .faultTolerant()
                .skip(Exception.class)
                .skipLimit(Integer.MAX_VALUE)
                .listener(new SkipListener<User, User>() {
                    @Override
                    public void onSkipInRead(Throwable throwable) {
                        System.out.println(throwable);
                    }

                    @Override
                    public void onSkipInWrite(User s, Throwable throwable) {
                        System.out.println(s);
                        System.out.println(throwable);
                    }

                    @Override
                    public void onSkipInProcess(User user, Throwable throwable) {
                        System.out.println(user);
                        System.out.println(throwable);

                    }
                })
                .build();
    }

    @Bean
    @StepScope
    public FlatFileItemReader<User> demoReader() {
        return new FlatFileItemReaderBuilder<User>()
                .name("demoReader")
                .resource(new FileSystemResource("d://abc.txt"))
                .delimited()
                .names("username", "password")
                .targetType(User.class)
                .encoding("utf-8")
                .build();
    }

    @Bean
    @StepScope
    public ItemProcessor<User, User> demoProcessor() {
        return user -> {
            if (user.getId() == null)
                throw new RuntimeException("user.id不为空");
            User cloneUser = user.clone();
            cloneUser.setId(123456789);
            return cloneUser;
        };
    }


    @Bean
    @StepScope
    public ItemProcessor<User, User> demoProcessor2() {
        return user -> {
            System.out.println(user);
            if (user.getId() != null)
                throw new RuntimeException("process2:user.id不为空");
            return user;
        };
    }

    @Bean
    @StepScope
    public CompositeItemProcessor<User, User> compositeItemProcessor() {
        CompositeItemProcessor<User, User> itemProcessor = new CompositeItemProcessor<>();
        itemProcessor.setDelegates(Arrays.asList(demoProcessor(), demoProcessor2()));
        return itemProcessor;
    }

    @Bean
    @StepScope
    public ItemWriter<User> demoWriter() {
        return new ItemWriter<User>() {
            @Override
            public void write(List<? extends User> list) throws Exception {
                for (User s : list) {
                    throw new RuntimeException("自定义异常：" + s);
                }
            }
        };
    }
}
