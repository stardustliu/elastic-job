/*
 * Copyright 1999-2015 dangdang.com.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * </p>
 */

package com.dangdang.ddframe.job.internal.job;

import com.dangdang.ddframe.job.api.ElasticJob;
import lombok.Setter;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * Elastic Job Lite提供的Quartz封装作业.
 *
 * @author zhangliang
 */
public class LiteJob implements Job {
    
    @Setter
    private ElasticJob elasticJob;
    
    @Override
    public void execute(final JobExecutionContext context) throws JobExecutionException {
        elasticJob.execute();
    }
}
