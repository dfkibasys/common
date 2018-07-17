/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.commons.scxml2.env;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StopWatchTest {

    private StopWatch stopWatch;

    /**
     * Set up instance variables required by this test case.
     */
    @Before
    public void setUp() throws Exception {
        stopWatch = new StopWatch();
    }

    /**
     * Tear down instance variables required by this test case.
     */
    @After
    public void tearDown() {
        stopWatch = null;
    }

    @Test
    public void testStopWatch() {
        Assert.assertEquals("reset", stopWatch.getCurrentState());
        stopWatch.fireEvent(StopWatch.EVENT_START);
        Assert.assertEquals("running", stopWatch.getCurrentState());
        stopWatch.fireEvent(StopWatch.EVENT_SPLIT);
        Assert.assertEquals("paused", stopWatch.getCurrentState());
        stopWatch.fireEvent(StopWatch.EVENT_UNSPLIT);
        Assert.assertEquals("running", stopWatch.getCurrentState());
        stopWatch.fireEvent(StopWatch.EVENT_STOP);
        Assert.assertEquals("stopped", stopWatch.getCurrentState());
        stopWatch.fireEvent(StopWatch.EVENT_RESET);
        Assert.assertEquals("reset", stopWatch.getCurrentState());
    }

}

