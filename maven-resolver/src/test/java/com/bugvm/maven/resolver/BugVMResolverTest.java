/*
 * Copyright (C) 2014 RoboVM AB
 *
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
 */
package com.bugvm.maven.resolver;

import static org.junit.Assert.*;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests {@link BugVMResolver}.
 */
public class BugVMResolverTest {

    File m2Repo = new File(System.getProperty("user.home"), ".m2/repository");
    File distAlpha2Dir = new File(m2Repo, "com/bugvm/bugvm-dist/1.1.0-SNAPSHOT/unpacked/bugvm-1.1.0-SNAPSHOT");
    
    @Before
    public void setup() throws Exception {
        if (distAlpha2Dir.getParentFile().exists()) {
            FileUtils.deleteDirectory(distAlpha2Dir.getParentFile());
        }
    }
    
    @Test
    public void testResolveAndUnpackBugVMDistArtifact() throws Exception {
        BugVMResolver resolver = new BugVMResolver();
        File dir = resolver.resolveAndUnpackBugVMDistArtifact("1.1.0-SNAPSHOT");
        assertEquals(distAlpha2Dir, dir);
        assertTrue(new File(dir, "bin/ios-sim").canExecute());
        //assertEquals(1411637293L, new File(dir, "lib/bugvm-rt.jar").lastModified() / 1000L);
    }

}
