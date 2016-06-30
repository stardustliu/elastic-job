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
 *
 */

package com.dangdang.ddframe.job.spring.namespace.parser.simple;

import com.dangdang.ddframe.job.api.config.impl.SimpleJobConfiguration.SimpleJobConfigurationBuilder;
import com.dangdang.ddframe.job.fixture.SimpleElasticJob;
import org.junit.Test;
import org.mockito.internal.matchers.apachecommons.ReflectionEquals;

import static com.dangdang.ddframe.job.spring.util.JobConfigurationDtoHelper.buildJobConfigurationBuilder;
import static com.dangdang.ddframe.job.spring.util.JobConfigurationDtoHelper.buildJobConfigurationDto;
import static org.junit.Assert.assertThat;

public final class SimpleJobConfigurationDtoTest {
    
    private SimpleJobConfigurationDto jobConfigurationDto = new SimpleJobConfigurationDto("simpleJob", SimpleElasticJob.class, 10, "0/1 * * * * ?");
    
    private SimpleJobConfigurationBuilder jobConfigurationBuilder = createSimpleJobConfigurationBuilder();
    
    @Test
    public void testBuildSimpleJobConfigurationDtoWithCustomizedProperties() {
        assertThat(buildJobConfigurationDto(jobConfigurationDto), new ReflectionEquals(buildJobConfigurationBuilder(jobConfigurationBuilder).build()));
    }
    
    @Test
    public void testBuildSimpleJobConfigurationDtoWithDefaultProperties() {
        assertThat(jobConfigurationDto.toJobConfiguration(), new ReflectionEquals(jobConfigurationBuilder.build()));
    }
    
    private SimpleJobConfigurationBuilder createSimpleJobConfigurationBuilder() {
        return new SimpleJobConfigurationBuilder("simpleJob", SimpleElasticJob.class, 10, "0/1 * * * * ?");
    }
}
