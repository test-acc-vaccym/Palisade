/*
 * Copyright 2018 Crown Copyright
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package uk.gov.gchq.palisade.policy;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class RulesTest {

    private Rules<String> testObj;

    @Before
    public void setUp() throws Exception {
        testObj = new Rules<>();
        testObj.rule("one", new TestRule());
    }

    @Test
    public void shouldNotEquals() throws Exception {
        Assert.assertFalse(testObj.equals(null));
        final Rules<String> o = new Rules<>();
        Assert.assertFalse(testObj.equals(o));
        o.rule("two", new TestRule());
        Assert.assertFalse(testObj.equals(o));
    }

    @Test
    public void shouldEquals() throws Exception {
        final Rules o = new Rules();
        o.rule("one", new TestRule());
        assertTrue(testObj.equals(o));
    }
}