package com.demo.runner;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.explore.JobExplorer;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class BatchRunner implements CommandLineRunner {

    @Resource
    private JobLauncher jobLauncher;

    @Resource
    private Job demoJob;

    @Resource
    private JobExplorer jobExplorer;

    @Override
    public void run(String... args) throws Exception {
        JobParameters jobParameters = new JobParametersBuilder(jobExplorer).getNextJobParameters(demoJob).toJobParameters();
        JobExecution run = jobLauncher.run(demoJob, jobParameters);


    }
}
