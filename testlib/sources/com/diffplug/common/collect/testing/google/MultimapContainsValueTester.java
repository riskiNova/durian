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
package com.diffplug.common.collect.testing.google;

import static com.diffplug.common.collect.testing.features.CollectionSize.ZERO;
import static com.diffplug.common.collect.testing.features.MapFeature.ALLOWS_NULL_VALUES;
import static com.diffplug.common.collect.testing.features.MapFeature.ALLOWS_NULL_VALUE_QUERIES;

import com.diffplug.common.annotations.GwtCompatible;
import com.diffplug.common.collect.Multimap;
import com.diffplug.common.collect.testing.features.CollectionSize;
import com.diffplug.common.collect.testing.features.MapFeature;

/**
 * Tester for {@link Multimap#containsValue}.
 *
 * @author Louis Wasserman
 */
@GwtCompatible
public class MultimapContainsValueTester<K, V>
		extends AbstractMultimapTester<K, V, Multimap<K, V>> {
	@CollectionSize.Require(absent = ZERO)
	public void testContainsValueYes() {
		assertTrue(multimap().containsValue(v0()));
	}

	public void testContainsValueNo() {
		assertFalse(multimap().containsValue(v3()));
	}

	@MapFeature.Require(ALLOWS_NULL_VALUES)
	@CollectionSize.Require(absent = ZERO)
	public void testContainsNullValueYes() {
		initMultimapWithNullValue();
		assertTrue(multimap().containsValue(null));
	}

	@MapFeature.Require(ALLOWS_NULL_VALUE_QUERIES)
	public void testContainsNullValueNo() {
		assertFalse(multimap().containsValue(null));
	}

	@MapFeature.Require(absent = ALLOWS_NULL_VALUE_QUERIES)
	public void testContainsNullValueFails() {
		try {
			multimap().containsValue(null);
			fail("Expected NullPointerException");
		} catch (NullPointerException expected) {
			// success
		}
	}
}