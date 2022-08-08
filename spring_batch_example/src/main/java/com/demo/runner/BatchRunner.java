package com.demo.runner;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.explore.JobExplorer;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class BatchRunner implements CommandLineRunner {

    @Resource
    private JobBuilderFactory jobBuilderFactory;

    @Resource
    private StepBuilderFactory stepBuilderFactory;

    @Resource
    private JobLauncher jobLauncher;

    @Resource
    private Job demoJob;

    @Resource
    private JobExplorer jobExplorer;

    @Override
    public void run(String... args) throws Exception {
//        JobParameters jobParameters = new JobParametersBuilder(jobExplorer).getNextJobParameters(demoJob).toJobParameters();
//        JobExecution run = jobLauncher.run(demoJob, jobParameters);
          jobLauncher.run(runJob(),new JobParametersBuilder().toJobParameters());

    }


    public Job runJob() {
        return jobBuilderFactory.get("runJob")
                .start(runStep())
                .build();
    }

    public Step runStep() {
        return stepBuilderFactory.get("runStep")
                .<String, String>chunk(10)
                .reader(runReader())
                .writer(runWriter())
                .build();
    }

    public FlatFileItemReader<String> runReader() {
        return new FlatFileItemReaderBuilder<String>()
                .name("runReader")
                .encoding("utf-8")
                .resource(new FileSystemResource("d:/abc/abc.txt"))
                .lineMapper((line, number) -> line)
                .build();
    }

    public ItemWriter<String> runWriter() {
        return items -> {
            System.out.println("===============================");
            for (String item : items) {
                System.out.println(item);
            }
        };
    }

}
