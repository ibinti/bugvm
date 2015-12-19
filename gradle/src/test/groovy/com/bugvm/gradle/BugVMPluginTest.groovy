/*
 * Copyright (C) 2014 RoboVM AB.
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
package com.bugvm.gradle

import org.gradle.api.Project
import org.gradle.testfixtures.ProjectBuilder
import org.junit.After
import org.junit.AfterClass
import org.junit.Before
import org.junit.BeforeClass
import org.junit.Test
import com.bugvm.gradle.tasks.ArchiveTask
import com.bugvm.gradle.tasks.IOSDeviceTask
import com.bugvm.gradle.tasks.IPadSimulatorTask
import com.bugvm.gradle.tasks.IPhoneSimulatorTask

import static org.junit.Assert.*

/**
 *
 * @author Junji Takakura
 */
class BugVMPluginTest {

    private Project project;

    public BugVMPluginTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        project = ProjectBuilder.builder().build();
        project.apply plugin: 'bugvm'

    }

    @After
    public void tearDown() {
    }

    @Test
    public void testGetPropertiesFile() {
//        String expected = "/home/test/test.properties";
//
//        project.bugvm {
//            propertiesFile expected
//        }

        //assertEquals(expected, project.bugvm.propertiesFile)
    }

    @Test
    public void testGetConfigFile() {
//        String expected = "/home/test/test.xml";
//
//        project.bugvm {
//            configFile expected
//        }

        //assertEquals(expected, project.bugvm.configFile)
    }

    @Test
    public void testGetIosSignIdentity() {
//        String expected = "signIdentity";
//
//        project.bugvm {
//            iosSignIdentity expected
//        }

        //assertEquals(expected, project.bugvm.iosSignIdentity)
    }

    @Test
    public void testGetIosProvisioningProfile() {
//        String expected = "provisioningProfile";
//
//        project.bugvm {
//            iosProvisioningProfile expected
//        }

        //assertEquals(expected, project.bugvm.iosProvisioningProfile)
    }

    @Test
    public void testGetIosSimulatorSdk() {
//        String expected = "iosSimulatorSdk";
//
//        project.bugvm {
//            iosSimulatorSdk expected
//        }

        //assertEquals(expected, project.bugvm.iosSimulatorSdk)
    }
    
    @Test
    public void testGetStdoutFifo() {
//        String expected = "/tmp/stdout.log";
//
//        project.bugvm {
//            stdoutFifo expected
//        }

        //assertEquals(expected, project.bugvm.stdoutFifo)
    }
    
    @Test
    public void testGetStderrFifo() {
//        String expected = "/tmp/stderr.log";
//
//        project.bugvm {
//            stderrFifo expected
//        }
        //assertEquals(expected, project.bugvm.stderrFifo)
    }

    @Test
    public void testIsIosSkipSigning() {
//        boolean expected = true;
//
//        project.bugvm {
//            iosSkipSigning expected
//        }

        //assertEquals(expected, project.bugvm.iosSkipSigning)
    }

    @Test
    public void testGetTaskByNameLaunchIPhoneSimulator() {
        //ssertTrue(project.tasks.launchIPhoneSimulator instanceof IPhoneSimulatorTask);
    }

    @Test
    public void testGetTaskByNameLaunchIPadSimulator() {
        //assertTrue(project.tasks.launchIPadSimulator instanceof IPadSimulatorTask);
    }

    @Test
    public void testGetTaskByNameLaunchIOSDevice() {
        //assertTrue(project.tasks.launchIOSDevice instanceof IOSDeviceTask);
    }

    @Test
    public void testGetTaskByNameCreateIPA() {
        //assertTrue(project.tasks.createIPA instanceof ArchiveTask);
    }
    
    @Test
    public void testUnpackDistribution() {
//        ArchiveTask task = project.tasks.createIPA;
//        task.unpack();
    }
}
