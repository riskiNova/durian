/*
 * Original Guava code is copyright (C) 2015 The Guava Authors.
 * Modifications from Guava are copyright (C) 2016 DiffPlug.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.diffplug.common.collect.testing.testers;

import com.diffplug.common.annotations.GwtCompatible;
import com.diffplug.common.collect.testing.AbstractMapTester;

/**
 * A generic JUnit test which tests {@code size()} operations on a map.
 * Can't be invoked directly; please see
 * {@link com.diffplug.common.collect.testing.MapTestSuiteBuilder}.
 *
 * @author George van den Driessche
 */
@GwtCompatible
public class MapSizeTester<K, V> extends AbstractMapTester<K, V> {
	public void testSize() {
		assertEquals("size():", getNumElements(), getMap().size());
	}
}